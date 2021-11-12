package org.dreambot.behaviour;

import org.dreambot.api.Client;
import org.dreambot.api.data.GameState;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.container.impl.equipment.Equipment;
import org.dreambot.framework.Root;
import org.dreambot.utilities.API;
import org.dreambotScript.Main;

public class BuyThePhat extends Root<Main> {
    @Override
    public boolean isValid() {
        return Client.getGameState() == GameState.LOGGED_IN 
        		&& (!Equipment.contains("Purple partyhat") &&
        				!Equipment.contains("Red partyhat") &&
        				!Equipment.contains("Yellow partyhat") &&
        				!Equipment.contains("White partyhat") &&
        				!Equipment.contains("Blue partyhat") &&
        				!Equipment.contains("Green partyhat"))
        		&& API.coins >= 8000;
    }

}
