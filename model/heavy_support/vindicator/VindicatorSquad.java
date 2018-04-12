package model.heavy_support.vindicator;

import model.UnitSquad;

public class VindicatorSquad extends UnitSquad 
{
	public VindicatorSquad(String squadName) 
	{
		super(squadName);
		unitName = "Vindicator ";
		super.setMaxSize(3);
		super.setMinSize(1);		
	}
	
	@Override
	public void addUnitSquad ()
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Vindicator());	
		}
	}
}
