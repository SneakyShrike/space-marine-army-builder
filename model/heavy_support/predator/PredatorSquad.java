package model.heavy_support.predator;

import model.UnitSquad;

public class PredatorSquad extends UnitSquad 
{
	public PredatorSquad(String squadName) 
	{
		super(squadName);
		unitName = "Predator ";
		super.setMaxSize(3);
		super.setMinSize(1);
	}
	
	@Override
	public void addUnitSquad ()
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Predator());	
		}
	}
}
