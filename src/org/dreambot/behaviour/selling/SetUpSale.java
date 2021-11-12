package org.dreambot.behaviour.selling;

import org.dreambot.api.methods.grandexchange.GrandExchange;
import org.dreambot.framework.Leaf;
import org.dreambot.utilities.API;
import org.dreambotScript.Main;

public class SetUpSale extends Leaf<Main> {

    @Override
    public boolean isValid() {
        return GrandExchange.isSellOpen();
    }

    @Override
    public int onLoop() {
    	API.randomAFK();
    	if(GrandExchange.getCurrentPrice() != 1)
    	{
    		GrandExchange.setPrice(1);
    	}
    	if(!API.setSellAll)
    	{
    		if(GrandExchange.getEnterAllButton().interact("All"))
        	{
        		API.setSellAll = true;
        		return (int) ((double) 50 + API.rand2.nextInt(100) * API.sleepMod);
        	}
    	}
    	
    	if(API.setSellAll && GrandExchange.getCurrentPrice() == 1)
    	{
    		GrandExchange.confirm();
    	}
    	return (int) ((double) 555 + API.rand2.nextInt(1111) * API.sleepMod);
    }
}
