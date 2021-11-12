package org.dreambot.behaviour.selling;

import org.dreambot.api.Client;
import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.grandexchange.GrandExchange;
import org.dreambot.framework.Leaf;
import org.dreambot.utilities.API;
import org.dreambotScript.Main;

public class WaitForSaleOrCancel extends Leaf<Main> {

    @Override
    public boolean isValid() {
        return GrandExchange.isGeneralOpen() && 
        		(GrandExchange.slotContainsItem(0) ||
        				GrandExchange.slotContainsItem(1) ||
        				GrandExchange.slotContainsItem(2));
    }

    @Override
    public int onLoop() {
    	API.randomAFK();
    	if(API.randSellTime == 0)
    	{
    		int tmp = (int) ((double) 3000 + API.rand2.nextInt(2750) * API.sleepMod);
    		MethodProvider.log("Waiting for something to sell... " + (int) (tmp / 50) +"s");
    		API.randSellTime = tmp;
    	}
    	if(Client.getIdleTime() >= API.randSellTime)
    	{
    		if(GrandExchange.cancelAll())
    		{
    			MethodProvider.log("Aborted offers after " + (int) (API.randSellTime / 50)+"s");
        		API.randSellTime = 0;
        		API.phatTries++;
        		API.randPHatPrice = (int) ((double) 7000 + API.rand2.nextInt(250) * API.sleepMod);
    		}
    	}
    	
    	return (int) ((double) 50 + API.rand2.nextInt(100) * API.sleepMod);
    }
}
