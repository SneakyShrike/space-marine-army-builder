package model.heavy_support.stalker;

import model.UnitSquad;

public class StalkerSquad extends UnitSquad
{
	public StalkerSquad(String squadName)
	{
		super(squadName);
		unitName = "Stalker ";
		super.setMaxSize(3);
		super.setMinSize(1);
	}
	
	@Override
	public void addUnitSquad ()
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Stalker());	
		}
	}
}
