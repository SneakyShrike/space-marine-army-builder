package model.fast_attack.land_speeder;

import model.UnitSquad;

public class Land_SpeederSquad extends UnitSquad 
{
	public Land_SpeederSquad(String squadName) 
	{
		super(squadName);
		unitName = "Land Speeder ";
		super.setMaxSize(3);
		super.setMinSize(1);
	}
	
	@Override
	public void addUnitSquad ()
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Land_Speeder());	
		}
	}
}
