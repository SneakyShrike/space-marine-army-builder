package elites.honour_guard;

import gui.model.UnitSquad;

public class Honour_GuardSquad extends UnitSquad 
{

	public Honour_GuardSquad(String squadName) 
	{
		super(squadName);
		unitName = "Honour Guard ";
		super.setMaxSize(9);
	}
	
	@Override
	public void addUnitSquad (int number)
	{
		for (int i = 0; i < number; i++)
		{
			if (unitList.size() < MAX)
				unitList.add(new Honour_Guard());	
		}
	}

}
