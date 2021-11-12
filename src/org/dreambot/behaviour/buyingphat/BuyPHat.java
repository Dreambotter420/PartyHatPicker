package org.dreambot.behaviour.buyingphat;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.grandexchange.GrandExchange;
import org.dreambot.framework.Leaf;
import org.dreambot.utilities.API;
import org.dreambotScript.Main;

public class BuyPHat extends Leaf<Main> {

    @Override
    public boolean isValid() {
        return GrandExchange.isBuyOpen();
    }

    @Override
    public int onLoop() {
    	API.randomAFK();
    	if(GrandExchange.getCurrentChosenItem() == null || 
    			!GrandExchange.getCurrentChosenItem().getName().contains(API.phatType))
    	{
    		if(!GrandExchange.getSearchedItem().contains(API.phatType))
    		{
    			GrandExchange.searchItem(API.phatType);
    			return (int) ((double) 222 + API.rand2.nextInt(666) * API.sleepMod);
    		} else {
    			if(GrandExchange.scrollToItem(GrandExchange.getItemChildInSearch(API.phatType)))
    			{
    				GrandExchange.getItemChildInSearch(API.phatType).interact("Select");
    				return (int) ((double) 555 + API.rand2.nextInt(1111) * API.sleepMod);
    			}
    		}
    		
    	}
    	if(GrandExchange.getCurrentPrice() != API.randPHatPrice)
    	{
    		GrandExchange.setPrice(API.randPHatPrice);
    		MethodProvider.sleep((int) ((double) 111 + API.rand2.nextInt(444) * API.sleepMod));
    	}
    	if(GrandExchange.getCurrentAmount() != 1)
    	{
    		GrandExchange.setQuantity(1);
    		MethodProvider.sleep((int) ((double) 111 + API.rand2.nextInt(444) * API.sleepMod));
    	}
    	
    	if(GrandExchange.getCurrentChosenItem() != null &&
    			GrandExchange.getCurrentChosenItem().getName().contains(API.phatType) && 
    			GrandExchange.getCurrentPrice() == API.randPHatPrice &&
    			GrandExchange.getCurrentAmount() == 1)
    	{
    		GrandExchange.confirm();
    	}
    	return (int) ((double) 555 + API.rand2.nextInt(1111) * API.sleepMod);
    }
}
