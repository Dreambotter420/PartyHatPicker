package org.dreambot.behaviour.stuff;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.wrappers.interactive.Player;
import org.dreambot.framework.Leaf;
import org.dreambot.utilities.API;
import org.dreambotScript.Main;

public class DetectPlayers extends Leaf<Main> {

    @Override
    public boolean isValid() {
    	if(API.randArea.contains(Players.localPlayer()))
    	{
    		for(Player pSpotted : Players.all())
    		{
    			if(!pSpotted.equals(Players.localPlayer()) &&
    				(API.randArea.contains(pSpotted) || pSpotted.distance(Players.localPlayer()) < 8))
    			{
    				MethodProvider.log("Player detected - randomizing worlds");
    				API.playersAvoided++;
    				API.randomizeWorld();
    				return true;
    			}
    		}
    	}
    	return false;
    }

    @Override
    public int onLoop() {
    	
    	return (int) ((double) 50 + API.rand2.nextInt(333) * API.sleepMod);
    }
}
