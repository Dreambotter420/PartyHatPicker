package org.dreambot.behaviour.stuff;

import java.util.ArrayList;
import java.util.List;

import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.container.impl.equipment.Equipment;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.wrappers.items.Item;
import org.dreambot.api.wrappers.widgets.WidgetChild;
import org.dreambot.framework.Leaf;
import org.dreambot.utilities.API;
import org.dreambotScript.Main;

public class BankShit extends Leaf<Main> {

    @Override
    public boolean isValid() {
    	WidgetChild boxDepositInventory = Widgets.getChildWidget(192,4);
    	
    	return ((boxDepositInventory != null && boxDepositInventory.isVisible()) 
    			|| Bank.isOpen());
    }

    @Override
    public int onLoop() {
    	API.randomAFK();
    	API.clickedBank = false;
    	WidgetChild boxDepositInventory = Widgets.getChildWidget(192,4);
    	WidgetChild boxDepositEquipment = Widgets.getChildWidget(192,6);
    	if(boxDepositInventory != null && boxDepositInventory.isVisible())
    	{
    		List<Item> equipment = new ArrayList<Item>();
    		equipment = Equipment.all();
    		
    		for(Item i:Equipment.all())
			{
				if(i != null && (!i.getName().contains("White partyhat") &&
						!i.getName().contains("Blue partyhat") &&
						!i.getName().contains("Red partyhat") &&
						!i.getName().contains("Yellow partyhat") &&
						!i.getName().contains("Green partyhat") &&
						!i.getName().contains("Purple partyhat")))
				{
					boxDepositEquipment.interact();
        			MethodProvider.sleep((int) ((double) 50 + API.rand2.nextInt(222) * API.sleepMod));
        			break;
				}
			}
    		boxDepositInventory.interact();
    	}
    	if(Bank.isOpen())
    	{
    		for(Item i:Equipment.all())
			{
				if(i != null && (!i.getName().contains("White partyhat") &&
						!i.getName().contains("Blue partyhat") &&
						!i.getName().contains("Red partyhat") &&
						!i.getName().contains("Yellow partyhat") &&
						!i.getName().contains("Green partyhat") &&
						!i.getName().contains("Purple partyhat")))
				{
					Bank.depositAllEquipment();
        			MethodProvider.sleep((int) ((double) 50 + API.rand2.nextInt(222) * API.sleepMod));
        			break;
				}
			}
    		Bank.depositAllItems();
    	}
    	return (int) ((double) 600 + API.rand2.nextInt(444) * API.sleepMod);
    }

}
