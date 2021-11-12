package org.dreambot.behaviour.stuff;

import java.util.ArrayList;
import java.util.List;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.container.impl.equipment.Equipment;
import org.dreambot.api.methods.filter.Filter;
import org.dreambot.api.methods.interactive.GameObjects;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.methods.tabs.Tabs;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.dreambot.api.wrappers.interactive.Player;
import org.dreambot.api.wrappers.items.Item;
import org.dreambot.api.wrappers.widgets.WidgetChild;
import org.dreambot.framework.Leaf;
import org.dreambot.utilities.API;
import org.dreambotScript.Main;

public class UpdateBank extends Leaf<Main> {

    @Override
    public boolean isValid() {
    	return Bank.isOpen() && !API.initBank;
    }

    @Override
    public int onLoop() {
    	int tmp = 0;
    	int coins = 0;
    	boolean phat = false;
    	if(!(Equipment.contains("White partyhat")||
    			Equipment.contains("Blue partyhat") ||
    			Equipment.contains("Yellow partyhat") ||
    			Equipment.contains("Red partyhat") ||
    			Equipment.contains("Purple partyhat") ||
    			Equipment.contains("Green partyhat")))
    	{
    		if(!Equipment.contains("White partyhat"))
        	{
        		if(!Inventory.contains("White partyhat")) {
            		if(!Bank.contains("White partyhat")) {}
            		else { phat = true;
            		Bank.depositAllItems();
            			if(Bank.withdraw("White partyhat")) MethodProvider.sleep((int) ((double) 666 + API.rand2.nextInt(666) * API.sleepMod));}}
        		if(Inventory.contains("White partyhat")) { phat = true;
            		if(Inventory.get("White partyhat").interact("Wear")) MethodProvider.sleep((int) ((double) 666 + API.rand2.nextInt(666) * API.sleepMod));}
        	}
        	if(!phat)
        	{
        		if(!Equipment.contains("Blue partyhat"))
            	{
            		if(!Inventory.contains("Blue partyhat")) {
                		if(!Bank.contains("Blue partyhat")) {}
                		else { phat = true;
                		Bank.depositAllItems();
                			if(Bank.withdraw("Blue partyhat")) MethodProvider.sleep((int) ((double) 666 + API.rand2.nextInt(666) * API.sleepMod));}}
            		if(Inventory.contains("Blue partyhat")) { phat = true;
                		if(Inventory.get("Blue partyhat").interact("Wear")) MethodProvider.sleep((int) ((double) 666 + API.rand2.nextInt(666) * API.sleepMod));}
            	}
        	}
        	if(!phat)
        	{
        		if(!Equipment.contains("Green partyhat"))
            	{
            		if(!Inventory.contains("Green partyhat")) {
                		if(!Bank.contains("Green partyhat")) {}
                		else { phat = true;
                		Bank.depositAllItems();
                			if(Bank.withdraw("Green partyhat")) MethodProvider.sleep((int) ((double) 666 + API.rand2.nextInt(666) * API.sleepMod));}}
            		if(Inventory.contains("Green partyhat")) { phat = true;
                		if(Inventory.get("Green partyhat").interact("Wear")) MethodProvider.sleep((int) ((double) 666 + API.rand2.nextInt(666) * API.sleepMod));}
            	}
        	}
        	if(!phat)
        	{
        		if(!Equipment.contains("Yellow partyhat"))
            	{
            		if(!Inventory.contains("Yellow partyhat")) {
                		if(!Bank.contains("Yellow partyhat")) {}
                		else { phat = true;
                		Bank.depositAllItems();
                			if(Bank.withdraw("Yellow partyhat")) MethodProvider.sleep((int) ((double) 666 + API.rand2.nextInt(666) * API.sleepMod));}}
            		if(Inventory.contains("Yellow partyhat")) { phat = true;
                		if(Inventory.get("Yellow partyhat").interact("Wear")) MethodProvider.sleep((int) ((double) 666 + API.rand2.nextInt(666) * API.sleepMod));}
            	}
        	}
        	if(!phat)
        	{
        		if(!Equipment.contains("Red partyhat"))
            	{
            		if(!Inventory.contains("Red partyhat")) {
                		if(!Bank.contains("Red partyhat")) {}
                		else { phat = true;
                		Bank.depositAllItems();
                			if(Bank.withdraw("Red partyhat")) MethodProvider.sleep((int) ((double) 666 + API.rand2.nextInt(666) * API.sleepMod));}}
            		if(Inventory.contains("Red partyhat")) { phat = true;
                		if(Inventory.get("Red partyhat").interact("Wear")) MethodProvider.sleep((int) ((double) 666 + API.rand2.nextInt(666) * API.sleepMod));}
            	}
        	}
        	if(!phat)
        	{
        		if(!Equipment.contains("Purple partyhat"))
            	{
            		if(!Inventory.contains("Purple partyhat")) {
                		if(!Bank.contains("Purple partyhat")) {}
                		else { phat = true;
                		Bank.depositAllItems();
                			if(Bank.withdraw("Purple partyhat")) MethodProvider.sleep((int) ((double) 666 + API.rand2.nextInt(666) * API.sleepMod));}}
            		if(Inventory.contains("Purple partyhat")) { phat = true;
                		if(Inventory.get("Purple partyhat").interact("Wear")) MethodProvider.sleep((int) ((double) 666 + API.rand2.nextInt(666) * API.sleepMod));}
            	}
        	}
    	}
    	
    	for(Item i : Bank.all())
    	{
    		if(i == null || i.getID() == -1) continue;
    		
    		if(		i.getName().contains("Grain") ||
    				i.getName().contains("Potato") ||
    				i.getName().contains("Cabbage") ||
    				i.getName().contains("Onion"))
    		{
    			tmp += i.getAmount();
    		}
    		
    		if(!phat)
    		{
    			//simply setting the following API values should trigger the buy logic of a phat if >= 8000 coins found total
    			if(i.getName().contains("Coins"))
        		{
        			coins += i.getAmount();
        		} 
    		}
    	}
    	for(Item i : Inventory.all())
    	{
    		if(i == null || i.getID() == -1) continue;
    		
    		if(		i.getName().contains("Grain") ||
    				i.getName().contains("Potato") ||
    				i.getName().contains("Cabbage") ||
    				i.getName().contains("Onion"))
    		{
    			tmp += i.getAmount();
    		}
    		
    		if(i.getName().contains("Coins"))
    		{
    			coins += i.getAmount();
    		} 
    	}
    	API.coins = coins;
    	API.stuffBanked = tmp;
    	API.initBank = true;
    	return (int) ((double) 50 + API.rand2.nextInt(50) * API.sleepMod);
    }

}
