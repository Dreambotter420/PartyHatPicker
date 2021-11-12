package org.dreambot.behaviour.selling;

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

public class OpenBank extends Leaf<Main> {

    @Override
    public boolean isValid() {
    	return !Bank.isOpen() && 
    			!Inventory.contains("Grain","Cabbage","Potato","Onion",
    					"White partyhat","Purple partyhat","Red partyhat",
    	    			"Green partyhat","Blue partyhat","Yellow partyhat");
    }

    @Override
    public int onLoop() {
    	API.randomAFK();
    	if(Bank.openClosest()) MethodProvider.sleep((int) ((double) 600 + API.rand2.nextInt(444) * API.sleepMod));
    	return (int) ((double) 600 + API.rand2.nextInt(444) * API.sleepMod);
    }

}
