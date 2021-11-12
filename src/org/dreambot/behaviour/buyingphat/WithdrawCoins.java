package org.dreambot.behaviour.buyingphat;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.container.impl.bank.BankMode;
import org.dreambot.api.methods.grandexchange.GrandExchange;
import org.dreambot.api.wrappers.items.Item;
import org.dreambot.framework.Leaf;
import org.dreambot.utilities.API;
import org.dreambotScript.Main;

public class WithdrawCoins extends Leaf<Main> {

    @Override
    public boolean isValid() {
        return !Inventory.contains("Coins") || Inventory.get("Coins").getAmount() < 8000;
    }

    @Override
    public int onLoop() {
    	API.randomAFK();
    	if(!Bank.isOpen()) Bank.openClosest();
    	if(Bank.isOpen())
    	{
    		if(Bank.withdrawAll("Coins"))
        	{
        		MethodProvider.log((int) ((double) 666 + API.rand2.nextInt(555) * API.sleepMod));
        	}
        	if(!Bank.contains("Coins")) 
        	{
        		Bank.close();
        		return (int) ((double) 50 + API.rand2.nextInt(100) * API.sleepMod);
        	}
    	}
    	
    	return (int) ((double) 666 + API.rand2.nextInt(555) * API.sleepMod);
    }
}
