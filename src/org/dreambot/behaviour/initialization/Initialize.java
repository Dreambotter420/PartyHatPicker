package org.dreambot.behaviour.initialization;

import java.time.LocalTime;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.input.Keyboard;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.methods.walking.pathfinding.impl.obstacle.impl.PassableObstacle;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.utilities.Timer;
import org.dreambot.api.wrappers.widgets.WidgetChild;
import org.dreambot.framework.Leaf;
import org.dreambot.utilities.API;
import org.dreambotScript.Main;

public class Initialize extends Leaf<Main> {

    @Override
    public boolean isValid() {
        return !API.initialized;
    }

    @Override
    public int onLoop() {
    	if(!Bank.isOpen() && (Widgets.getChildWidget(192,4) == null || !Widgets.getChildWidget(192,4).isVisible()))
    	{
    		Widgets.closeAll(); // only close everything if bank / deposit box are NOT open
    	}
    	//randomize psuedorandom seed based on in-game account name  & time of day then set sleep modification factor (0-4x)
    	if(API.initialized == false && Players.localPlayer() != null && Players.localPlayer().exists() && Players.localPlayer().getName() != null && !Players.localPlayer().getName().isEmpty())
		{
			String name = Players.localPlayer().getName();
			int mult = 1;
			int sum = 0;
		    for(int i = 0; i < name.length() - 1; i++)
		    {
		    	sum += name.codePointAt(i) * mult;
				mult += 2;
		    	
		    }
			API.rand2.setSeed(sum + LocalTime.now().getNano());
		}
    	API.sleepMod = 1 + API.rand2.nextDouble();
		API.sleepMod = API.sleepMod * API.sleepMod;
    	
    	//all initial randomizations that depend on new random seed go here
    	API.sellAmount = (int) ((double) 857 + API.rand2.nextInt(555) * API.sleepMod);
		API.randPHatPrice = (int) ((double) 6000 + API.rand2.nextInt(500) * API.sleepMod);
		API.randIdleTime = (int) ((double) 250 + API.rand2.nextInt(100) * API.sleepMod);
    	Keyboard.setWordsPerMinute(API.rand2.nextInt(150) + 50);
    	API.randomizeArea();
    	API.cameraTimer = new Timer((int) ((double) 60000 + API.rand2.nextInt(150000) * API.sleepMod));
    	API.randSellTimer = new Timer((int) ((double) 7200000 + API.rand2.nextInt(3600000) * API.sleepMod));
    	API.initialized = true;
    	MethodProvider.log("Initialized");
        return 50;
    }
}
