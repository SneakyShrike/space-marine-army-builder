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
	}
	
	@Override
	public void addUnitSquad (int number)
	{
		for (int i = 0; i < number; i++)
		{
			if (unitList.size() < MAX)
				unitList.add(new Venerable_Dreadnought());	
		}
	}
}
