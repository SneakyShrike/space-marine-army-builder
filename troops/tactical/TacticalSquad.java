package troops.tactical;

import gui.model.Unit;
import gui.model.UnitSquad;

public class TacticalSquad extends UnitSquad
{		
		public TacticalSquad(String squadName) 
		{
			super(squadName);
			unitName = "Tactical ";
			super.setMaxSize(9);
			super.setMinSize(5);
		}
		
		@Override
		public void addUnitSquad ()
		{
			for (int i = 0; i < min; i++)
			{
				if (unitList.size() < max)
					unitList.add(new Tactical());	
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
