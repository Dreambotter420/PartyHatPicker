package org.dreambot.behaviour.stuff;

import java.util.ArrayList;
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

public class SearchForShitToPick extends Leaf<Main> {

    @Override
    public boolean isValid() {
        return API.nextPick == null || !API.nextPick.exists();
    }

    @Override
    public int onLoop() {
		List<GameObject> shit = GameObjects.all("Wheat","Onion","Potato","Cabbage");
		List<GameObject> bestshit = new ArrayList<GameObject>();
		List<GameObject> secondbestshit = new ArrayList<GameObject>();
		List<GameObject> lastresortshit = new ArrayList<GameObject>();
		GameObject randObject = null;
		for(GameObject go : shit)
		{
			if(go.equals(API.lastPicked)) continue;
			if(API.randArea.contains(go) && go.canReach()) {
				if(		(go.getTile().getX() == (Players.localPlayer().getTile().getX() - 1))&& 
						(go.getTile().getY() == Players.localPlayer().getTile().getY()) || 
						(go.getTile().getX() == (Players.localPlayer().getTile().getX() + 1))&& 
						(go.getTile().getY() == Players.localPlayer().getTile().getY()) || 
						(go.getTile().getY() == (Players.localPlayer().getTile().getY() - 1))&& 
						(go.getTile().getX() == Players.localPlayer().getTile().getX()) || 
						(go.getTile().getY() == (Players.localPlayer().getTile().getY() + 1))&& 
						(go.getTile().getX() == Players.localPlayer().getTile().getX()) || 
						(go.getTile().getX() == Players.localPlayer().getTile().getX())&& 
						(go.getTile().getY() == Players.localPlayer().getTile().getY()))
				{
					bestshit.add(go);
					continue;
				}
				if(bestshit == null || bestshit.isEmpty())
				{
					if((	go.getTile().getX() == (Players.localPlayer().getTile().getX() - 2))&& 
							(go.getTile().getY() == (Players.localPlayer().getTile().getY() + 1)) || 
							(go.getTile().getX() == (Players.localPlayer().getTile().getX() - 2)) && 
							(go.getTile().getY() == (Players.localPlayer().getTile().getY() - 0)) || 
							(go.getTile().getY() == (Players.localPlayer().getTile().getY() - 1))&& 
							(go.getTile().getX() == (Players.localPlayer().getTile().getX() - 2)) || 
							(go.getTile().getY() == (Players.localPlayer().getTile().getY() + 2))&& 
							(go.getTile().getX() == (Players.localPlayer().getTile().getX() - 1)) ||
							(go.getTile().getY() == (Players.localPlayer().getTile().getY() + 1))&& 
							(go.getTile().getX() == (Players.localPlayer().getTile().getX() - 1)) ||
							(go.getTile().getY() == (Players.localPlayer().getTile().getY() - 1))&& 
							(go.getTile().getX() == (Players.localPlayer().getTile().getX() - 1)) ||
							(go.getTile().getY() == (Players.localPlayer().getTile().getY() - 2))&& 
							(go.getTile().getX() == (Players.localPlayer().getTile().getX() - 1)) ||
							(go.getTile().getY() == (Players.localPlayer().getTile().getY() + 2))&& 
							(go.getTile().getX() == (Players.localPlayer().getTile().getX())) ||
							(go.getTile().getY() == (Players.localPlayer().getTile().getY() - 2))&& 
							(go.getTile().getX() == (Players.localPlayer().getTile().getX())) ||
							(go.getTile().getY() == (Players.localPlayer().getTile().getY() + 2))&& 
							(go.getTile().getX() == (Players.localPlayer().getTile().getX() + 1)) ||
							(go.getTile().getY() == (Players.localPlayer().getTile().getY() + 1))&& 
							(go.getTile().getX() == (Players.localPlayer().getTile().getX() + 1)) ||
							(go.getTile().getY() == (Players.localPlayer().getTile().getY() - 1)) && 
							(go.getTile().getX() == (Players.localPlayer().getTile().getX() + 1)) ||
							(go.getTile().getY() == (Players.localPlayer().getTile().getY() - 2))&& 
							(go.getTile().getX() == (Players.localPlayer().getTile().getX() + 1)) ||
							(go.getTile().getY() == (Players.localPlayer().getTile().getY() + 1))&& 
							(go.getTile().getX() == (Players.localPlayer().getTile().getX() + 2))||
							(go.getTile().getY() == (Players.localPlayer().getTile().getY() + 0))&& 
							(go.getTile().getX() == (Players.localPlayer().getTile().getX() + 2))||
							(go.getTile().getY() == (Players.localPlayer().getTile().getY() - 1))&& 
							(go.getTile().getX() == (Players.localPlayer().getTile().getX() + 2)))
					{
						secondbestshit.add(go);
						continue;
					}
				}
				if(secondbestshit == null || secondbestshit.isEmpty())
				{
					if(go.distance(Players.localPlayer()) <= 8 &&
							go.distance(Players.localPlayer()) >= 0)
					{
						lastresortshit.add(go);
					}
				}
			}
			
		}
		if(bestshit != null && !bestshit.isEmpty() && bestshit.size() > 0)
		{
			 randObject = bestshit.get(API.rand2.nextInt(bestshit.size()));
		}
		else if(secondbestshit != null && !secondbestshit.isEmpty() && secondbestshit.size() > 0)
		{
			randObject = secondbestshit.get(API.rand2.nextInt(secondbestshit.size()));
		}
		else if(lastresortshit != null && !lastresortshit.isEmpty() && lastresortshit.size() > 0)
		{
			randObject = lastresortshit.get(API.rand2.nextInt(lastresortshit.size()));
		}
		API.nextPick = randObject;
		if((API.nextPick == null || !API.nextPick.exists()) && 
				!API.randArea.contains(Players.localPlayer()))
		{
			API.randomAFK();
			if(API.randomTileInArea == null) API.randomizeTileInArea();
			if(API.randomTileInArea.distance(Players.localPlayer()) >= 7) { // far
	    		if(API.randDestLimit == 0) API.randDestLimit = 4 + API.rand2.nextInt(9);
	        	if(Walking.shouldWalk(API.randDestLimit))
	    		{
	        		if(Walking.walk(API.randomTileInArea))
	        		{
	        			API.randDestLimit = 0;
	        			MethodProvider.sleep((int) ((double) 333 + API.rand2.nextInt(555) * API.sleepMod));
	        		}
	        		else
	        		{
	        			API.walkFails++;
	        			MethodProvider.log("Failed walking step towards area");
	        		}
	    		}
	    	}
	    	else if(API.randomTileInArea.distance(Players.localPlayer()) < 7) { // closer
	    		if(API.randomTileInArea.distance(Players.localPlayer()) <= 0) 
	    		{
	    			MethodProvider.log("...");
	    			return (int) ((double) 50 + API.rand2.nextInt(100) * API.sleepMod);
	    		}
	    		if(Walking.shouldWalk(2))
	    		{
	        		if(!Walking.walk(API.randomTileInArea))
	        		{
	        			API.walkFails++;
	        			MethodProvider.log("Failed walking step towards area");
	        		}
	    		}
	    	}
		}
		if((API.nextPick == null || !API.nextPick.exists()) && 
				API.randArea.contains(Players.localPlayer()))
		{
			int tmp = (int) ((double) 600 + API.rand2.nextInt(20000) * API.sleepMod);
			MethodProvider.log("Inside area and no stuffs found, sleeping for " + (int) (tmp / 1000) + "s");
			MethodProvider.sleep(tmp);
		}
		if(API.walkFails >= 10)
		{
			API.walkFails = 0;
			API.randomTileInArea = null;
		}
		return (int) ((double) 111 + API.rand2.nextInt(444) * API.sleepMod);
    }
}
