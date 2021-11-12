package org.dreambot.behaviour.stuff;

import org.dreambot.api.Client;
import org.dreambot.api.data.GameState;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.framework.Leaf;
import org.dreambot.utilities.API;
import org.dreambotScript.Main;

public class CheckStuffLeft extends Leaf<Main> {

    @Override
    public boolean isValid() {
    	int stuffTotal = 0;
    	if(Inventory.contains(1958)) stuffTotal += Inventory.get(1958).getAmount();
    	if(Inventory.contains(1966)) stuffTotal += Inventory.get(1966).getAmount();
    	if(Inventory.contains(1948)) stuffTotal += Inventory.get(1948).getAmount();
    	if(Inventory.contains(1943)) stuffTotal += Inventory.get(1943).getAmount();
    	if(stuffTotal >= API.sellAmount) 
    	{
    		API.stuffBanked += stuffTotal;
    		return false;
    	}
        return API.stuffLeft <= 0 && Client.getGameState() == GameState.LOGGED_IN;
    }

    @Override
    public int onLoop() {
		API.randomizeWorld();
		API.stuffLeft = (int) ((double) 51 + API.rand2.nextInt(133) * API.sleepMod);
    	return (int) ((double) 100 + API.rand2.nextInt(1000) * API.sleepMod);
    }
}
