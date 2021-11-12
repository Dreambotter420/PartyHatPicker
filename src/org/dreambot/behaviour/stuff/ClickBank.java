package org.dreambot.behaviour.stuff;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.dreambot.api.wrappers.interactive.NPC;
import org.dreambot.framework.Leaf;
import org.dreambot.utilities.API;
import org.dreambotScript.Main;

public class ClickBank extends Leaf<Main> {

    @Override
    public boolean isValid() {
    	return API.closestBank.contains(Players.localPlayer());
    }

    @Override
    public int onLoop() {
    	if(API.clickedBank && Players.localPlayer().isMoving())
    	{
    		return (int) ((double) 100 + API.rand2.nextInt(587) * API.sleepMod);
    	}
    	API.randomAFK();
    	NPC banker = null;
    	GameObject bank = null;
    	if(API.rand2.nextInt(50) < 15)
    	{
    		banker = NPCs.closest("Banker");
    	}
    	if(banker != null)
    	{
    		if(banker.interact("Bank"))
    		{
    			API.clickedBank = true;
    		}
    		return (int) ((double) 700 + API.rand2.nextInt(444) * API.sleepMod);
    	} else {
    		bank = GameObjects.closest("Bank booth","Bank deposit box");
    	}
    	if(bank != null)
    	{
    		if(bank.getName().contains("deposit")) 
    		{
    			if(bank.interact("Deposit"))
    			{
        			API.clickedBank = true;
        		}
    		}
    		else if (bank.interact("Bank"))
    		{
    			API.clickedBank = true;
    		}
    		return (int) ((double) 700 + API.rand2.nextInt(444) * API.sleepMod);
    	}else{
    		MethodProvider.logInfo("No bank or npc found in range of bank area!!!!");
        	MethodProvider.sleep(1000000000);
    	}
    	
    	return (int) ((double) 50 + API.rand2.nextInt(100) * API.sleepMod);
    }
}
