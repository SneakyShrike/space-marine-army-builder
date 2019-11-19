package model.heavy_support.whirlwind;

import model.UnitSquad;

public class WhirlwindSquad extends UnitSquad 
{
	public WhirlwindSquad(String squadName) 
	{
		super(squadName);
		unitName = "Whirlwind ";
		super.setMaxSize(3);
		super.setMinSize(1);
	}
	
	@Override
	public void addUnitSquad ()
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Whirlwind());	
		}
	}
}
