package org.dreambot.behaviour.buyingphat;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.container.impl.bank.BankMode;
import org.dreambot.api.methods.container.impl.equipment.Equipment;
import org.dreambot.api.methods.grandexchange.GrandExchange;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.wrappers.items.Item;
import org.dreambot.framework.Leaf;
import org.dreambot.utilities.API;
import org.dreambotScript.Main;

public class EquipPhat extends Leaf<Main> {

    @Override
    public boolean isValid() {
        return 	Inventory.contains("White partyhat") || 
        		Inventory.contains("Blue partyhat") || 
        		Inventory.contains("Green partyhat") || 
        		Inventory.contains("Yellow partyhat") || 
        		Inventory.contains("Purple partyhat") || 
        		Inventory.contains("Red partyhat");
    }

    @Override
    public int onLoop() {
    	API.randomAFK();
    	Widgets.closeAll();
    	if(!Equipment.contains("White partyhat"))
    	{
    		if(Inventory.contains("White partyhat")) {
    			if(Inventory.get("White partyhat").interact("Wear")) MethodProvider.sleep((int) ((double) 666 + API.rand2.nextInt(666) * API.sleepMod));
    		}
    	}
    	if(!Equipment.contains("Red partyhat"))
    	{
    		if(Inventory.contains("Red partyhat")) {
    			if(Inventory.get("Red partyhat").interact("Wear")) MethodProvider.sleep((int) ((double) 666 + API.rand2.nextInt(666) * API.sleepMod));
    		}
    	}
    	if(!Equipment.contains("Green partyhat"))
    	{
    		if(Inventory.contains("Green partyhat")) {
    			if(Inventory.get("Green partyhat").interact("Wear")) MethodProvider.sleep((int) ((double) 666 + API.rand2.nextInt(666) * API.sleepMod));
    		}
    	}
    	if(!Equipment.contains("Blue partyhat"))
    	{
    		if(Inventory.contains("Blue partyhat")) {
    			if(Inventory.get("Blue partyhat").interact("Wear")) MethodProvider.sleep((int) ((double) 666 + API.rand2.nextInt(666) * API.sleepMod));
    		}
    	}
    	if(!Equipment.contains("Purple partyhat"))
    	{
    		if(Inventory.contains("Purple partyhat")) {
    			if(Inventory.get("Purple partyhat").interact("Wear")) MethodProvider.sleep((int) ((double) 666 + API.rand2.nextInt(666) * API.sleepMod));
    		}
    	}
    	if(!Equipment.contains("Yellow partyhat"))
    	{
    		if(Inventory.contains("Yellow partyhat")) {
    			if(Inventory.get("Yellow partyhat").interact("Wear")) MethodProvider.sleep((int) ((double) 666 + API.rand2.nextInt(666) * API.sleepMod));
    		}
    	}
    	Inventory.get(API.phatType).interact("Wear");
    	return (int) ((double) 555 + API.rand2.nextInt(555) * API.sleepMod);
    }
}
