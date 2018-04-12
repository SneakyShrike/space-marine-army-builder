package model.elites.sternguard_veteran;

import model.Unit;
import model.UnitSquad;
import model.wargear.weapon.Weapon;
import model.wargear.weapon.WeaponList;

public class Sternguard_VeteranSquad extends UnitSquad
{

	public Sternguard_VeteranSquad(String squadName) 
	{
		super(squadName);
		unitName = "Sternguard Veteran ";
		super.setMaxSize(10);
		super.setMinSize(5);
	}
	
	@Override
	public void addUnitSquad ()
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Sternguard_Veteran());	
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
			if (weaponCount > 2)
			{
				message = "A Sternguard Veteran Squad is permitted to only 2 weapons from the Heavy Weapons list or Special weapons list only";
			}
			
		return message;	
	}
	
}
