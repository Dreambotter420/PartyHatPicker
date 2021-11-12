package org.dreambot.behaviour.selling;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.container.impl.bank.BankMode;
import org.dreambot.api.wrappers.items.Item;
import org.dreambot.framework.Leaf;
import org.dreambot.utilities.API;
import org.dreambotScript.Main;

public class WithdrawNoted extends Leaf<Main> {

    @Override
    public boolean isValid() {
        return Bank.isOpen() && Bank.contains("Grain", "Onion","Cabbage","Potato",
    			"White partyhat","Purple partyhat","Red partyhat",
    			"Green partyhat","Blue partyhat","Yellow partyhat");
    }

    @Override
    public int onLoop() {
    	API.randomAFK();
    	for(Item i : Inventory.all())
    	{
    		if(i == null || i.getID() == -1) continue;
    		if(!i.isNoted() && !i.getName().contains("Coins")) 
    		{
    			Bank.depositAllItems();
    			MethodProvider.sleep((int) ((double) 233 + API.rand2.nextInt(1200) * API.sleepMod));
    			break;
    		}
    	}
    	if(BankMode.ITEM == Bank.getWithdrawMode())
    	{
    		Bank.setWithdrawMode(BankMode.NOTE);
    		MethodProvider.sleep((int) ((double) 100 + API.rand2.nextInt(222) * API.sleepMod));
    	}
    	
    	//randomize item order
    	int randItem = API.rand2.nextInt(10);
    	String randName = "";
    	switch(randItem){
    	case(0):{
    		if(Bank.contains("Grain")) randName = "Grain";
    		break;
    	}
    	case(1):{
    		if(Bank.contains("Cabbage")) randName = "Cabbage";
    		break;
    	}
    	case(2):{
    		if(Bank.contains("Onion")) randName = "Onion";
    		break;
    	}
    	case(3):{
    		if(Bank.contains("Potato")) randName = "Potato";
    		break;
    	}
    	case(4):{
    		if(Bank.contains("White partyhat")) randName = "White partyhat";
    		break;
    	}
    	case(5):{
    		if(Bank.contains("Purple partyhat")) randName = "Purple partyhat";
    		break;
    	}
    	case(6):{
    		if(Bank.contains("Red partyhat")) randName = "Red partyhat";
    		break;
    	}
    	case(7):{
    		if(Bank.contains("Green partyhat")) randName = "Green partyhat";
    		break;
    	}
    	case(8):{
    		if(Bank.contains("Blue partyhat")) randName = "Blue partyhat";
    		break;
    	}
    	case(9):{
    		if(Bank.contains("Yellow partyhat")) randName = "Yellow partyhat";
    		break;
    	}
    	}
    	
    	//withdraw the random item name from above
    	if(!randName.isBlank())
    	{
    		for(Item i : Bank.all())
        	{
        		if(i == null || i.getID() == -1) continue;
        		if(i.getName().contains(randName)) 
        		{
        			Bank.withdrawAll(randName);
        			MethodProvider.sleep((int) ((double) 155 + API.rand2.nextInt(444) * API.sleepMod));
        			break;
        		}
        	}
    	}
    	if(!Bank.contains("Grain", "Onion","Cabbage","Potato",
    			"White partyhat","Purple partyhat","Red partyhat",
    			"Green partyhat","Blue partyhat","Yellow partyhat")) Bank.close();
    	return (int) ((double) 50 + API.rand2.nextInt(100) * API.sleepMod);
    }
}
