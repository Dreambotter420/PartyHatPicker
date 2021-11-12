package org.dreambot.behaviour;

import org.dreambot.api.Client;
import org.dreambot.api.data.GameState;
import org.dreambot.framework.Root;
import org.dreambot.utilities.API;
import org.dreambotScript.Main;

public class SellTheStuff extends Root<Main> {
    @Override
    public boolean isValid() {
        return API.stuffBanked >= API.sellAmount;
    }

}
