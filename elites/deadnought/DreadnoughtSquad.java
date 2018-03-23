package elites.deadnought;

import gui.model.UnitSquad;
import troops.scout.Scout;
import wargear.weapon.Weapon;

public class DreadnoughtSquad extends UnitSquad
{
	public DreadnoughtSquad(String squadName) 
	{
		super(squadName);
		unitName = "Dreadnought ";
		super.setMaxSize(3);
	}
	
	@Override
	public void addUnitSquad (int number)
	{
		for (int i = 0; i < number; i++)
		{
			if (unitList.size() < MAX)
				unitList.add(new Dreadnought());	
		}
	}
}
