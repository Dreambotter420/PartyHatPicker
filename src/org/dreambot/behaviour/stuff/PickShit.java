package org.dreambot.behaviour.stuff;

import java.util.List;

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

public class PickShit extends Leaf<Main> {

    @Override
    public boolean isValid() {
        return API.nextPick != null && API.nextPick.exists();
    }

    @Override
    public int onLoop() {
    	if(API.clickedTile != null && Players.localPlayer().getTile().distance(API.clickedTile) > 0) // wait for pick
    	{
    		return (int) ((double) 50 + API.rand2.nextInt(100) * API.sleepMod);
    	}
    	if(API.nextPick.distance(Players.localPlayer()) > 8 || 
    			API.nextPick.distance(Players.localPlayer()) < 0)
    	{
    		API.clickedTile = API.nextPick.getTile();
    		API.lastPicked = API.nextPick;
    		return (int) ((double) 50 + API.rand2.nextInt(100) * API.sleepMod);
    	}
    	if(API.nextPick.interact("Pick")) 
    	{
    		API.clickedTile = API.nextPick.getTile();
    		API.lastPicked = API.nextPick;
    	}
    	API.randomAFK();
		return (int) ((double) 50 + API.rand2.nextInt(100) * API.sleepMod);
    }
}
