package org.dreambot.behaviour.stuff;

import java.util.List;

import org.dreambot.api.Client;
import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.methods.world.Worlds;
import org.dreambot.api.methods.worldhopper.WorldHopper;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.dreambot.framework.Leaf;
import org.dreambot.utilities.API;
import org.dreambotScript.Main;

public class WaitForPick extends Leaf<Main> {

    @Override
    public boolean isValid() {
        return API.clickedTile != null;
    }

    @Override
    public int onLoop() {
    	API.randomAFK();
    	if((Players.localPlayer().getTile().distance(API.clickedTile) <= 0) || 
    			(API.lastPicked == null || !API.lastPicked.exists()))
    		/**
    		 * location reached that of picked thing or picked thing gone, null clickedTile and nextPick
    		 * this will allow a pick action to occur by passing this leaf
    		 * and also tell search leaf to search another random thing to pick
    		 */
    	{
    		API.clickedTile = null;
    		API.nextPick = null;
        }
    	if(Client.getIdleTime() >= API.randIdleTime)
    	{
    		MethodProvider.log("Continuing to pick after " + (int) (Client.getIdleTime() / 50)+"s");
    		API.randIdleTime = (int) ((double) 250 + API.rand2.nextInt(100) * API.sleepMod);
    		API.clickedTile = null;
    		API.nextPick = null;
    	}
    	return (int) ((double) 50 + API.rand2.nextInt(100) * API.sleepMod);
    }
}
