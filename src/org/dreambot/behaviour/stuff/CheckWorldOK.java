package org.dreambot.behaviour.stuff;

import org.dreambot.api.methods.world.Worlds;
import org.dreambot.framework.Leaf;
import org.dreambot.utilities.API;
import org.dreambotScript.Main;

public class CheckWorldOK extends Leaf<Main> {

    @Override
    public boolean isValid() {
        return API.randomWorld == Worlds.getCurrentWorld() && API.worldHops > 0;
    }

    @Override
    public int onLoop() {
		API.worldHops = 0;
    	return (int) ((double) 50 + API.rand2.nextInt(50) * API.sleepMod);
    }
}
