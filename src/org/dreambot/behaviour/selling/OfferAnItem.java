package org.dreambot.behaviour.selling;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.grandexchange.GrandExchange;
import org.dreambot.api.wrappers.items.Item;
import org.dreambot.framework.Leaf;
import org.dreambot.utilities.API;
import org.dreambotScript.Main;

public class OfferAnItem extends Leaf<Main> {

    @Override
    public boolean isValid() {
        return GrandExchange.isGeneralOpen() &&
    			Inventory.contains("Grain","Cabbage","Potato","Onion",
    					"White partyhat","Purple partyhat","Red partyhat",
    	    			"Green partyhat","Blue partyhat","Yellow partyhat");
    }

    @Override
    public int onLoop() {
    	API.randomAFK();
    	API.clickedBank = false;
    	
    	//randomize item order
    	int randItem = API.rand2.nextInt(10);
    	String randName = "";
    	switch(randItem){
    	case(0):{
    		if(Inventory.contains("Grain")) randName = "Grain";
    		break;
    	}
    	case(1):{
    		if(Inventory.contains("Cabbage")) randName = "Cabbage";
    		break;
    	}
    	case(2):{
    		if(Inventory.contains("Onion")) randName = "Onion";
    		break;
    	}
    	case(3):{
    		if(Inventory.contains("Potato")) randName = "Potato";
    		break;
    	}
    	case(4):{
    		if(Inventory.contains("White partyhat")) randName = "White partyhat";
    		break;
    	}
    	case(5):{
    		if(Inventory.contains("Purple partyhat")) randName = "Purple partyhat";
    		break;
    	}
    	case(6):{
    		if(Inventory.contains("Red partyhat")) randName = "Red partyhat";
    		break;
    	}
    	case(7):{
    		if(Inventory.contains("Green partyhat")) randName = "Green partyhat";
    		break;
    	}
    	case(8):{
    		if(Inventory.contains("Blue partyhat")) randName = "Blue partyhat";
    		break;
    	}
    	case(9):{
    		if(Inventory.contains("Yellow partyhat")) randName = "Yellow partyhat";
    		break;
    	}
    	}
    	
    	//offer the random item name from above
    	if(!randName.isBlank())
    	{
    		for(Item i : Inventory.all())
        	{
        		if(i == null || i.getID() == -1) continue;
        		if(i.getName().contains(randName)) 
        		{
        			Inventory.interact(randName, "Offer");
        			MethodProvider.sleep((int) ((double) 600 + API.rand2.nextInt(444) * API.sleepMod));
        			break;
        		}
        	}
    	}
    	
    	return (int) ((double) 50 + API.rand2.nextInt(100) * API.sleepMod);
    }
}
