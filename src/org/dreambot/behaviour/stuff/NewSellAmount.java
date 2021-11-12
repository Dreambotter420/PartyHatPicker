package org.dreambot.behaviour.stuff;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.utilities.Timer;
import org.dreambot.framework.Leaf;
import org.dreambot.utilities.API;
import org.dreambotScript.Main;

public class NewSellAmount extends Leaf<Main> {

    @Override
    public boolean isValid() {
        return API.randSellTimer.finished();
    }

    @Override
    public int onLoop() {
    	int lastSellAmt = API.sellAmount;
    	API.sellAmount = (int) ((double) 857 + API.rand2.nextInt(555) * API.sleepMod);
    	MethodProvider.log("Changed from old to new sell amount: " + lastSellAmt + "->" + API.sellAmount);
    	API.randSellTimer = new Timer((int) ((double) 7200000 + API.rand2.nextInt(3600000) * API.sleepMod));
    	return (int) ((double) 100 + API.rand2.nextInt(1000) * API.sleepMod);
    }
}
