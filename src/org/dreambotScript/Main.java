package org.dreambotScript;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.randoms.RandomEvent;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.script.listener.ChatListener;
import org.dreambot.api.script.listener.InventoryListener;
import org.dreambot.api.wrappers.items.Item;
import org.dreambot.api.wrappers.widgets.message.Message;
import org.dreambot.behaviour.*;
import org.dreambot.behaviour.buyingphat.*;
import org.dreambot.behaviour.initialization.*;
import org.dreambot.behaviour.selling.*;
import org.dreambot.behaviour.stuff.*;
import org.dreambot.framework.Branch;
import org.dreambot.framework.Tree;
import org.dreambot.paint.CustomPaint;
import org.dreambot.paint.PaintInfo;
import org.dreambot.utilities.*;
import java.awt.*;

@ScriptManifest(author = "Dreambotter420", name = "Picker", 
description = "Picks shit", version = 1.0, category = Category.MISC, image = "lFwvTuW.jpg")
public class Main extends AbstractScript implements PaintInfo, ChatListener, InventoryListener {

    /**
     * @param args script quick launch arguments
     */

    @Override
    public void onStart(String... args) {
        instantiateTree();
        getRandomManager().disableSolver(RandomEvent.DISMISS);
    }

    /**
     * On start from script launcher
     */
    @Override
    public void onStart() {
        instantiateTree();
        getRandomManager().disableSolver(RandomEvent.DISMISS); //let the randoms talk around a bunch of accounts at once
    }

    private final Tree<Main> tree = new Tree<>();
    private Branch<Main> initScript;
    private Branch<Main> sellthatshit;
    private Branch<Main> notFullyInventoried;
    private Branch<Main> fullyInventoried;
    private Branch<Main> buyPhat;
    private Branch<Main> initialBank;
   
    private void instantiateTree() {
    	initialBank = new InitialBank();
    	buyPhat = new BuyThePhat();
    	initScript = new InitializeScriptStuff();
    	sellthatshit = new SellTheStuff();
    	notFullyInventoried = new NotFullInvy();
    	fullyInventoried = new FullInvy();
        tree.addBranch(initScript.addLeafs(
        		
        		new CloseAllWidgets(),
        		new DisableRoofs(),
        		new GoFixedMode(), 
        		new DisableLeftClickAttackStuff(),
        		new UntoggleAIDS(), 
        		new SetCameraUp(), 
        		new Initialize()));
        
        tree.addBranch(initialBank.addLeafs(
        		new InitBank(),
        		new UpdateBank()));
        
        /**
         * The logic of the whole GE selling:
         *  Update API bank cache whenever bank is in open state while farming stuff
         *  	-this includes coins, stuffs, and partyhat
         *   
         *  if (all items totaling greater than random set value && items in bank)
         *  	-withdraw items
         *   if (all items totaling greater than random set value && no items in invy && no items in bank)
         *  	-set bankedstuff = 0
         *  If (all items totaling greater than random set value && any items in invy)
         * 		-walk to GE
         * 		-open GE
         * 		-collect any offers available to invy
         * 		-sell random item
         *
         * 
         * Logic of PHat buying:
         * 	If(No Phat equipped && PHat in inventory)	
         * 		-equip PHat
         * 	if(no Phat equipped && no PHat in invy && Phat in bank)
         * 		-withdraw PHat
         * If(No Phat equipped && 10k coins)
         * 		-walk to GE
         * 		-open GE
         * 		-collect any offers available to invy
         * 		-abort all offers if all are full
         * 		-make new buy offer for white partyhat at 6-8k random value
         * 
         */
        tree.addBranch(buyPhat.addLeafs(
        		new ChangePartyHatType(),
        		new CollectItemsToInventory(),
        		new WaitForSaleOrCancel(),
        		new WithdrawCoins(),
        		new EquipPhat(),
        		new WalkToGEPhat(),
        		new ClickGE(),
        		new OpenBuyOffer(),
        		new BuyPHat()
        		));
        
        tree.addBranch(sellthatshit.addLeafs(
        		new WithdrawNoted(),
        		new UpdateBankAlone(),
        		new CollectItemsToInventory(),
        		new WaitForSaleOrCancel(),
        		new OpenBank(),
        		new WalkToGE(),
        		new ClickGE(),
        		new SetUpSale(),
        		
        		new OfferAnItem()));
        
        tree.addBranch(fullyInventoried.addLeafs(
        		new BankShit(),
        		new OpenBank(),
        		new SetCameraUpAgain(),
        		new EnableRun(),
        		new ClickBank(),
        		new WalkToBank(),
        		new FindTileInBank()));
        
        tree.addBranch(notFullyInventoried.addLeafs(
        		
        		new UpdateBank(),
        		new SetCameraUpAgain(),
        		new CheckStuffLeft(),
        		new HopWorlds(),
        		new CheckShouldSwitchAreas(),
        		new EnableRun(), 
        		new DetectPlayers(), 
        		new WaitForPick(),
        		new PickShit(), 
        		new SearchForShitToPick()));
        
    }

    /**
     * onLoop is a infinite loop
     * @return gets the leaf and executes it
     */

    @Override
    public int onLoop() {
        return this.tree.onLoop();
    }

    /**
     * @return the information for the paint
     */
    @Override
    public String[] getPaintInfo() {
        return new String[] {
                "Runtime Hours:Minutes:Seconds " + API.runTimer.formatTime(API.runTimer.elapsed()),
                "Current Branch: " + API.currentBranch,
                "Current Leaf: " + API.currentLeaf,
                "Picking area: " + API.randAreaName,
                "Banking area: " + API.randBankName,
                "Stuff picked: " + API.stuffCount,
                "Players hopped around: " + API.playersAvoided,
                "Stuff to pick until next worldhop: " + API.stuffLeft,
                "Bank deposits to occur until new area: " + API.banksLeft,
                "Stuff banked: " + API.stuffBanked,
                "Stuff to bank until sell all at GE: " + API.sellAmount,
                "Coins: " + API.coins,
                "XP/hour: over 9000!!"
        };
        
    }
    @Override
    public void onGameMessage(Message msg)
    {
    	if(msg.getMessage().contains("I can't reach that"))
    	{
    		API.clickedBank = false;
    		API.clickedTile = null;
    		API.lastPicked = null;
    	}
    }
    
    @Override
	public void onItemChange(Item[] items) {
		if(items != null && items.length > 0)//at least 1 thing
		{
			for(Item i : items)
			{
				if((i.getName().contains("Potato") 
						|| i.getName().contains("Cabbage")
						|| i.getName().contains("Grain")
						|| i.getName().contains("Onion"))
						&& i.getAmount() > 0) 
				{
					if(!Bank.isOpen())
						{
						API.stuffCount += i.getAmount();
						API.stuffLeft -= i.getAmount();
						}
				}
			}
			for(Item i : items)
			{
				if((i.getName().contains("Potato") 
						|| i.getName().contains("Cabbage")
						|| i.getName().contains("Grain")
						|| i.getName().contains("Onion"))
						&& i.getAmount() < 0) 
				{
					API.banksLeft--;
					break;
				}
			}
		}
	}
    
    /**
     * Instantiate the paint object, can be customized to liking.
     */
    private final CustomPaint CUSTOM_PAINT = new CustomPaint(this,
            CustomPaint.PaintLocations.TOP_LEFT_PLAY_SCREEN, new Color[]{new Color(255, 251, 255)},
            "Trebuchet MS",
            new Color[]{new Color(50, 50, 50, 175)},
            new Color[]{new Color(28, 28, 29)},
            1, false, 5, 3, 0);

    private final RenderingHints aa = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


    /**
     * paint for the script
     */
    @Override
    public void onPaint(Graphics g) {
        Graphics2D gg = (Graphics2D) g;
        gg.setRenderingHints(aa);

        CUSTOM_PAINT.paint(gg);
    }

	
    

}
