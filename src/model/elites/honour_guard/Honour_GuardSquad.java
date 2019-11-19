package model.elites.honour_guard;

import model.UnitSquad;

public class Honour_GuardSquad extends UnitSquad 
{

	public Honour_GuardSquad(String squadName) 
	{
		super(squadName);
		unitName = "Honour Guard ";
		super.setMaxSize(10);
		super.setMinSize(3);
	}
	
	@Override
	public void addUnitSquad ()
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Honour_Guard());	
		}
	}

}
