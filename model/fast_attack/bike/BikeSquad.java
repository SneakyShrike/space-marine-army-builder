package model.fast_attack.bike;

import model.Unit;
import model.UnitSquad;

public class BikeSquad extends UnitSquad
{
	public BikeSquad(String squadName)
	{
		super(squadName);
		unitName = "Bike ";
		super.setMaxSize(8);
		super.setMinSize(3);
	}
	
	@Override
	public void addUnitSquad ()//adds scouts to the specified number instead of max
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Bike());	
		}
	}
	
	@Override
	public String SquadWeaponsCheck()
	{
		int weaponCount = 0;
		String message = "";
		
		for (Unit unit : unitList)
		{
			switch(unit.getWeaponUpgrade().toString())
			{
			   case "Flamer" :
			   case "Meltagun" :			 
			   case "Grav-Gun" :
			   case "Plasma Gun" :
				   weaponCount++;
			}			
		}			
			if (weaponCount > 2)
			{
				message = "A Bike Squad is permitted to only 2 Special weapons";
			}
			
		return message;	
	}
}
