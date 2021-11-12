package org.dreambot.behaviour.stuff;

import org.dreambot.api.Client;
import org.dreambot.api.data.GameState;
import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.methods.world.Worlds;
import org.dreambot.api.methods.worldhopper.WorldHopper;
import org.dreambot.api.wrappers.widgets.WidgetChild;
import org.dreambot.framework.Leaf;
import org.dreambot.utilities.API;
import org.dreambotScript.Main;

public class HopWorlds extends Leaf<Main> {

    @Override
    public boolean isValid() {
        return Worlds.getCurrentWorld() != API.randomWorld || 
        		Client.getGameState() != GameState.LOGGED_IN;
    }

    @Override
    public int onLoop() {
    	API.randomAFK();
    	if(Widgets.isOpen())
    	{
    		Widgets.closeAll();
    	}
    	WidgetChild boxClose = Widgets.getWidgetChild(192,1,11);
    	if(boxClose != null && boxClose.isVisible()) boxClose.interact();
    	MethodProvider.sleep(50);
    	if(Bank.isOpen()) Bank.close();
    	MethodProvider.sleep(50);
    	
    	if(API.worldHops < 25)
		{
			MethodProvider.log("Hopping to world " + API.randomWorld + " attempt #" + (API.worldHops+1));
			WorldHopper.hopWorld(API.randomWorld);
			API.worldHops++;
		} else 
		{
			MethodProvider.log("Over 25 hops and no success :-( going again...");
			API.worldHops = 0;
		}
    	return (int) ((double) 5000 + API.rand2.nextInt(3000) * API.sleepMod);
    }
}
