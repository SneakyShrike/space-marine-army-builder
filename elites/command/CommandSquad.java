package elites.command;

import gui.model.Unit;
import gui.model.UnitSquad;
import troops.scout.Scout;

public class CommandSquad extends UnitSquad
{
	public CommandSquad(String squadName) 
	{
		super(squadName);
		unitName = "Command ";
		super.setMaxSize(5);
		super.setMinSize(5);
	}
	
	@Override
	public void addUnitSquad ()
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Command());	
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
