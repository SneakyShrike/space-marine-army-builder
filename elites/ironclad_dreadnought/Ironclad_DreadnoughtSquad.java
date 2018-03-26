package elites.ironclad_dreadnought;

import elites.deadnought.Dreadnought;
import gui.model.UnitSquad;

public class Ironclad_DreadnoughtSquad extends UnitSquad 
{

	public Ironclad_DreadnoughtSquad(String squadName) 
	{
		super(squadName);
		unitName = "Ironclad Dreadnought ";
		super.setMaxSize(3);
	}
	
	@Override
	public void addUnitSquad (int number)
	{
		for (int i = 0; i < number; i++)
		{
			if (unitList.size() < MAX)
				unitList.add(new Ironclad_Dreadnought());	
		}
	}
}
