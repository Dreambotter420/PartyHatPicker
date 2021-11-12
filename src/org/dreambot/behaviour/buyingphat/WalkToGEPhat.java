package org.dreambot.behaviour.buyingphat;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.walking.impl.Walking;
import org.dreambot.framework.Leaf;
import org.dreambot.utilities.API;
import org.dreambotScript.Main;

public class WalkToGEPhat extends Leaf<Main> {

    @Override
    public boolean isValid() {
        return Players.localPlayer().distance(API.GE) > 8 && 
        		API.coins >= 8000;
    }

    @Override
    public int onLoop() {
    	API.randomAFK();
    	if(Players.localPlayer().distance(API.GE) > 8) { // far
    		if(API.randDestLimit == 0) API.randDestLimit = 4 + API.rand2.nextInt(9);
        	if(Walking.shouldWalk(API.randDestLimit))
    		{
        		if(Walking.walk(API.GE)) API.randDestLimit = 0;
        		else MethodProvider.log("Failed walking step towards GE");
    		}
        }
    	else if(Players.localPlayer().distance(API.GE) <= 8) { // closer
    		
    	}	
    	return (int) ((double) 50 + API.rand2.nextInt(100) * API.sleepMod);
    }
}
