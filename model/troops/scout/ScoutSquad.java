package model.troops.scout;

import model.Unit;
import model.UnitSquad;

public class ScoutSquad extends UnitSquad
{	
	public ScoutSquad(String squadName) //creates a new array list of scouts with a name
	{
		super(squadName);
		unitName = "Scout ";
		super.setMaxSize(10);
		super.setMinSize(5);
	}	
	
	@Override
	public void addUnitSquad ()//adds scouts to the specified number instead of max
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Scout());	
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
			   case "Heavy Bolter" :
			   case "Heavy Bolter (Hellfire Shell)" :			 
			   case "Missile Launcher (Frag)" :
			   case "Missile Launcher (Krak)" :
			   case "Missile Launcher (Flakk)" :
				   weaponCount++;
			}			
		}			
			if (weaponCount > 1)
			{
				message = "A Scout Squad is permitted to only 1: Heavy Bolter / Heavy Bolter (Hellfire Shell) / "
						+ "Missile Launcher (Frag) / Missile Launcher (Krak) / Missile Launcher (Flakk)";
			}
			
		return message;	
	}		
}

