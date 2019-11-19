package model.heavy_support.devastator;

import model.Unit;
import model.UnitSquad;
import model.troops.scout.Scout;

public class DevastatorSquad extends UnitSquad 
{
	public DevastatorSquad(String squadName) 
	{
		super(squadName);
		unitName = "Devastator ";
		super.setMaxSize(10);
		super.setMinSize(5);
	}
	
	@Override
	public void addUnitSquad ()//adds scouts to the specified number instead of max
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Devastator());	
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
			    case "Heavy Bolter":
		        case "Multi-Melta":
		        case "Missile Launcher (Frag)":
		        case "Missile Launcher (Krak)":
		        case "Missile Launcher (Flakk)":
		        case "Plasma Cannon":
		        case "Lascannon":
		        case "Grav-Cannon":
		        case "Grav-Amp":
				   weaponCount++;
			}			
		}			
			if (weaponCount > 4)
			{
				message = "A Devastator Squad is permitted to only 4 weapons from the Heavy Weapons list";
			}
			
		return message;	
	}
}
