package org.dreambot.behaviour.stuff;

import org.dreambot.framework.Leaf;
import org.dreambot.utilities.API;
import org.dreambotScript.Main;

public class CheckShouldSwitchAreas extends Leaf<Main> {

    @Override
    public boolean isValid() {
        return API.banksLeft <= 0;
    }

    @Override
    public int onLoop() {
		API.randomizeArea();
    	return (int) ((double) 100 + API.rand2.nextInt(1000) * API.sleepMod);
    }
}
