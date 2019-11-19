package model.heavy_support.hunter;

import model.UnitSquad;

public class HunterSquad extends UnitSquad 
{
	public HunterSquad(String squadName) 
	{
		super(squadName);
		unitName = "Hunter ";
		super.setMaxSize(3);
		super.setMinSize(1);
	}
	
	@Override
	public void addUnitSquad ()
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Hunter());	
		}
	}
}
