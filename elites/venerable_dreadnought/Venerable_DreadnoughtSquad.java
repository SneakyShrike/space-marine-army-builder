package elites.venerable_dreadnought;

import elites.deadnought.Dreadnought;
import gui.model.UnitSquad;

public class Venerable_DreadnoughtSquad extends UnitSquad 
{
	public Venerable_DreadnoughtSquad(String squadName)
	{
		super(squadName);
		unitName = "Venerable Dreadnought ";
		super.setMaxSize(3);
		super.setMinSize(1);
	}
	
	@Override
	public void addUnitSquad ()
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Venerable_Dreadnought());	
		}
	}
}
