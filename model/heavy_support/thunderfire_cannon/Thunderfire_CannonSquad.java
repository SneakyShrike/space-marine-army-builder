package model.heavy_support.thunderfire_cannon;

import model.UnitSquad;

public class Thunderfire_CannonSquad extends UnitSquad
{
	public Thunderfire_CannonSquad(String squadName) 
	{
		super(squadName);
		unitName = "Thunderfire Cannon ";
		super.setMaxSize(3);
		super.setMinSize(1);
	}
	
	@Override
	public void addUnitSquad ()//adds scouts to the specified number instead of max
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Thunderfire_Cannon());	
		}
	}
}
