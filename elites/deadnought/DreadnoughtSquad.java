package elites.deadnought;

import gui.model.Unit;
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
		super.setMinSize(1);
	}
	
	@Override
	public void addUnitSquad ()
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Dreadnought());	
		}
	}
}
