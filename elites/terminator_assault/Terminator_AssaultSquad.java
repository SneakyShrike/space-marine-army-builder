package elites.terminator_assault;

import gui.model.UnitSquad;
import wargear.weapon.Weapon;

public class Terminator_AssaultSquad extends UnitSquad 
{
	public Terminator_AssaultSquad(String squadName) 
	{
		super(squadName);
		unitName = "Terminator Assault ";
		super.setMaxSize(9);
	}
	
	@Override
	public void addUnitSquad (int number)//adds scouts to the specified number instead of max
	{
		for (int i = 0; i < number; i++)
		{
			if (unitList.size() < MAX)
				unitList.add(new Terminator_Assault());	
		}
	}
}
