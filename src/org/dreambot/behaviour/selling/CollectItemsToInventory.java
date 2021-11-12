package org.dreambot.behaviour.selling;

import org.dreambot.api.methods.grandexchange.GrandExchange;
import org.dreambot.framework.Leaf;
import org.dreambot.utilities.API;
import org.dreambotScript.Main;

public class CollectItemsToInventory extends Leaf<Main> {

    @Override
    public boolean isValid() {
        return GrandExchange.isGeneralOpen() && GrandExchange.isReadyToCollect();
    }

    @Override
    public int onLoop() {
    	API.randomAFK();
    	GrandExchange.collect();
    	return (int) ((double) 666 + API.rand2.nextInt(999) * API.sleepMod);
    }
}
