package elites.terminator;

import gui.model.UnitSquad;
import wargear.weapon.Weapon;

public class TerminatorSquad extends UnitSquad
{
	public TerminatorSquad(String squadName) 
	{
		super(squadName);
		unitName = "Terminator ";
		super.setMaxSize(9);
	}
		
	@Override
	public void addUnitSquad (int number)//adds scouts to the specified number instead of max
	{
		for (int i = 0; i < number; i++)
		{
			if (unitList.size() < MAX)
				unitList.add(new Terminator());	
		}
	}
	
	@Override
	public void weaponUpgrade(Weapon weapon, int amount)
	{
		for (int i = 1; i <= amount; i++)
		{
			switch(weapon.toString())
			{
			   case "Heavy Flamer" :
			   case "Assault Cannon" :			 
			   case "Cyclone Missile Launcher" :
				   amount = 1;
			   default:
				   getUnit(i).unitWeaponUpgrade(weapon);
			}
		}
	}
}
