package elites.terminator_assault;

import gui.model.UnitSquad;
import wargear.weapon.Weapon;

public class Terminator_AssaultSquad extends UnitSquad 
{
	public Terminator_AssaultSquad(String squadName) 
	{
		super(squadName);
		unitName = "Terminator Assault ";
		super.setMaxSize(10);
		super.setMinSize(5);
	}
	
	@Override
	public void addUnitSquad ()
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Terminator_Assault());	
		}
	}
}
