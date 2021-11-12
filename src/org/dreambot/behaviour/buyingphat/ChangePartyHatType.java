package org.dreambot.behaviour.buyingphat;

import org.dreambot.api.methods.grandexchange.GrandExchange;
import org.dreambot.framework.Leaf;
import org.dreambot.utilities.API;
import org.dreambotScript.Main;

public class ChangePartyHatType extends Leaf<Main> {

    @Override
    public boolean isValid() {
        return API.phatTries > 3;
    }

    @Override
    public int onLoop() {
    	API.randomAFK();
    	switch(API.rand2.nextInt(6))
    	{
    	case(0):
    	{
    		if(!API.phatType.contains("Purple partyhat"))
    		{
    	    	API.phatType = "Purple partyhat";
    	    	API.phatTries = 0;
    	    	break;
    		}
    	}
    	case(1):
    	{
    		if(!API.phatType.contains("Green partyhat"))
    		{
    	    	API.phatType = "Green partyhat";
    	    	API.phatTries = 0;
    	    	break;
    		}
    	}
    	case(2):
    	{
    		if(!API.phatType.contains("Red partyhat"))
    		{
    	    	API.phatType = "Red partyhat";
    	    	API.phatTries = 0;
    	    	break;
    		}
    	}
    	case(3):
    	{
    		if(!API.phatType.contains("White partyhat"))
    		{
    	    	API.phatType = "White partyhat";
    	    	API.phatTries = 0;
    	    	break;
    		}
    	}
    	case(4):
    	{
    		if(!API.phatType.contains("Blue partyhat"))
    		{
    	    	API.phatType = "Blue partyhat";
    	    	API.phatTries = 0;
    	    	break;
    		}
    	}
    	case(5):
    	{
    		if(!API.phatType.contains("Yellow partyhat"))
    		{
    	    	API.phatType = "Yellow partyhat";
    	    	API.phatTries = 0;
    	    	break;
    		}
    	}
    	}
    	return (int) ((double) 555 + API.rand2.nextInt(1111) * API.sleepMod);
    }
}
