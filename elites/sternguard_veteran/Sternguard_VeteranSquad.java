package elites.sternguard_veteran;

import gui.model.UnitSquad;
import wargear.weapon.Weapon;
import wargear.weapon.WeaponList;

public class Sternguard_VeteranSquad extends UnitSquad
{

	public Sternguard_VeteranSquad(String squadName) 
	{
		super(squadName);
		unitName = "Sternguard Veteran ";
		super.setMaxSize(9);
	}
	
	@Override
	public void addUnitSquad (int number)
	{
		for (int i = 0; i < number; i++)
		{
			if (unitList.size() < MAX)
				unitList.add(new Sternguard_Veteran());	
		}
	}
	
	@Override
	public void weaponUpgrade(Weapon weapon, int amount)
	{
		for (int i = 0; i <= amount; i++)
		{
			switch(weapon.toString())
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
				   amount = 2;
			   default:
				   getUnit(i).unitWeaponUpgrade(weapon);
			}
		}
	}
}
