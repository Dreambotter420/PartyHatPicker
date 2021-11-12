package org.dreambot.behaviour.selling;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.grandexchange.GrandExchange;
import org.dreambot.framework.Leaf;
import org.dreambot.utilities.API;
import org.dreambotScript.Main;

public class CloseGE extends Leaf<Main> {

    @Override
    public boolean isValid() {
    	return GrandExchange.isGeneralOpen();
    }

    @Override
    public int onLoop() {
    	if(		!GrandExchange.slotContainsItem(0) && 
    			!GrandExchange.slotContainsItem(1) && 
    			!GrandExchange.slotContainsItem(2))
    	{
    		if(Inventory.contains("Coins"))
    		{
    			API.coins = Inventory.get("Coins").getAmount();
    		}
    	}
    	MethodProvider.sleep((int) ((double) 999 + API.rand2.nextInt(1111) * API.sleepMod));
    	return (int) ((double) 500 + API.rand2.nextInt(1000) * API.sleepMod);
    }
}
