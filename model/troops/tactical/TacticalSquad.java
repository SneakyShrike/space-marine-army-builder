package model.troops.tactical;

import model.Unit;
import model.UnitSquad;
import model.wargear.weapon.WeaponList;

public class TacticalSquad extends UnitSquad
{		
		public TacticalSquad(String squadName) 
		{
			super(squadName);
			unitName = "Tactical ";
			super.setMaxSize(10);
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
			
			if (unitListSize() < 10)
			{
				for (Unit unit : unitList)
				{
					switch(unit.getWeaponUpgrade().toString())
					{
					    case "Flamer":
					    case "Meltagun":
					    case "Grav-Gun":
					    case "Plasma Gun":
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
				
				if (weaponCount > 1)
				{
					message = "A Tactical Squad with less than " + max + " members can upgrade to 1 "
							+ "weapon from the Special Weapons or Heavy Weapons list only";
				}
			}
			
			else if (unitListSize() == 10)
			{
				for (Unit unit : unitList)
				{
					switch(unit.getWeaponUpgrade().toString())
					{
					    case "Flamer":
					    case "Meltagun":
					    case "Grav-Gun":
					    case "Plasma Gun":
					    	weaponCount++;
					    break;					    	
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
				
				if (weaponCount > 2)
				{
					message = "A Tactical Squad with " + max + " members can upgrade to 1 "
							+ "weapon from the Special Weapons and 1 weapon from the Heavy Weapons list only";
				}
			}
								
		return message;	
			
		}
}
