package org.dreambot.behaviour.selling;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.grandexchange.GrandExchange;
import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.dreambot.api.wrappers.interactive.NPC;
import org.dreambot.framework.Leaf;
import org.dreambot.utilities.API;
import org.dreambotScript.Main;

public class ClickGE extends Leaf<Main> {

    @Override
    public boolean isValid() {
    	return Players.localPlayer().distance(API.GE) <= 8 && !GrandExchange.isOpen();
    }

    @Override
    public int onLoop() {
    	if(API.clickedBank && Players.localPlayer().isMoving())
    	{
    		return (int) ((double) 100 + API.rand2.nextInt(587) * API.sleepMod);
    	}
    	API.randomAFK();
    	NPC exchanger = null;
    	GameObject GEBooth = null;
    	if(API.rand2.nextInt(50) < 15)
    	{
    		exchanger = NPCs.closest("Grand Exchange Clerk");
    	}
    	if(exchanger != null)
    	{
    		if(exchanger.interact("Exchange"))
    		{
    			API.clickedBank = true;
    		}
    		return (int) ((double) 700 + API.rand2.nextInt(444) * API.sleepMod);
    	} else {
    		GEBooth = GameObjects.closest("Grand Exchange Booth");
    	}
    	if(GEBooth != null)
    	{
    		if(GEBooth.getName().contains("Grand Exchange Booth")) 
    		{
    			if(GEBooth.interact("Exchange"))
    			{
        			API.clickedBank = true;
        		}
    		}
    		return (int) ((double) 700 + API.rand2.nextInt(444) * API.sleepMod);
    	}else
    	{
    		MethodProvider.logInfo("No bank or npc found in range of GE area!!!!");
        	MethodProvider.sleep(1000000000);
    	}
    	
    	return (int) ((double) 50 + API.rand2.nextInt(100) * API.sleepMod);
    }
}
