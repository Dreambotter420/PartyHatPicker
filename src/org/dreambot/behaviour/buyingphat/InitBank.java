package org.dreambot.behaviour.buyingphat;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.grandexchange.GrandExchange;
import org.dreambot.api.wrappers.items.Item;
import org.dreambot.framework.Leaf;
import org.dreambot.utilities.API;
import org.dreambotScript.Main;

public class InitBank extends Leaf<Main> {

    @Override
    public boolean isValid() {
        return !API.initBank && !Bank.isOpen();
    }

    @Override
    public int onLoop() {
    	API.randomAFK();
    	if(!Bank.openClosest()) MethodProvider.sleep((int) ((double) 600 + API.rand2.nextInt(444) * API.sleepMod));
    	return (int) ((double) 50 + API.rand2.nextInt(100) * API.sleepMod);
    }
}
