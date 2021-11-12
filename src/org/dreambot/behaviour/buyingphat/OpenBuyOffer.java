package org.dreambot.behaviour.buyingphat;

import org.dreambot.api.methods.grandexchange.GrandExchange;
import org.dreambot.framework.Leaf;
import org.dreambot.utilities.API;
import org.dreambotScript.Main;

public class OpenBuyOffer extends Leaf<Main> {

    @Override
    public boolean isValid() {
        return GrandExchange.isGeneralOpen();
    }

    @Override
    public int onLoop() {
    	API.randomAFK();
    	GrandExchange.openBuyScreen(GrandExchange.getFirstOpenSlot());
    	return (int) ((double) 555 + API.rand2.nextInt(1111) * API.sleepMod);
    }
}
