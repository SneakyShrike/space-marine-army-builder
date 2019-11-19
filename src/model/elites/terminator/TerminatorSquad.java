package model.elites.terminator;

import model.Unit;

import model.UnitSquad;

public class TerminatorSquad extends UnitSquad
{
	public TerminatorSquad(String squadName) 
	{
		super(squadName);
		unitName = "Terminator ";
		super.setMaxSize(10);
		super.setMinSize(5);		
	}
		
	@Override
	public void addUnitSquad ()
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Terminator());	
		}
	}
	
	@Override
	public String SquadWeaponsCheck()
	{
		int weaponCount = 0;
		String message = "";
		
		if (unitListSize() == 5)
		{
			for (Unit unit : unitList)
			{
				switch(unit.getWeaponUpgrade().toString())
				{
				    case "Assault Cannon":
				    case "Heavy Flamer":
				    case "Cyclone Missile Launcher":	   
						weaponCount++;					   					   
				}					
			}
			
			if (weaponCount > 1)
			{
				message = "A Terminator Squad with " + min + " members can upgrade to 1 of the following: "
						+ "Assault Cannon / Heavy Flamer / Cyclone Missile Launcher only";
			}
		}
		
		else if (unitListSize() == 10)
		{
			for (Unit unit : unitList)
			{
				switch(unit.getWeaponUpgrade().toString())
				{
				    case "Assault Cannon":
			        case "Heavy Flamer":
			        case "Cyclone Missile Launcher":	 	   
						 weaponCount++;					   					   
				}					
			}
			
			if (weaponCount > 2)
			{
				message = "A Terminator Squad with " + max + " members can upgrade to 2 of the following: "
						+ "Assault Cannon / Heavy Flamer / Cyclone Missile Launcher only";
			}
		}
							
	return message;	
		
	}
}
