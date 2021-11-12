package org.dreambot.behaviour;

import org.dreambot.api.Client;
import org.dreambot.api.data.GameState;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.framework.Root;
import org.dreambot.utilities.API;
import org.dreambotScript.Main;

public class FullInvy extends Root<Main> {
    @Override
    public boolean isValid() {
        return Client.getGameState() == GameState.LOGGED_IN && 
        		Inventory.isFull();
    }

}
