package fast_attack.scout_bike;

import gui.model.Unit;
import gui.model.UnitSquad;

public class Scout_BikeSquad extends UnitSquad
{

	public Scout_BikeSquad(String squadName) 
	{
		super(squadName);
		unitName = "Scout Bike ";
		super.setMaxSize(10);
		super.setMinSize(3);
	}
	
	@Override
	public void addUnitSquad ()
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Scout_Bike());	
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
			   case "Grenade Launcher (Integrated)" :
				   weaponCount++;
			}			
		}			
			if (weaponCount > 3)
			{
				message = "A Scout Bike Squad is permitted to only 3 Grenade Launchers";
			}
			
		return message;	
	}
}
