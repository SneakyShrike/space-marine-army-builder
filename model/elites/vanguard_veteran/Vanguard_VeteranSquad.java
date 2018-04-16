package model.elites.vanguard_veteran;

import model.UnitSquad;

public class Vanguard_VeteranSquad extends UnitSquad
{
	public Vanguard_VeteranSquad(String squadName) 
	{
		super(squadName);
		unitName = "Vanguard Veteran ";
		super.setMaxSize(10);
		super.setMinSize(5);
	}
	
	@Override
	public void addUnitSquad ()
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Vanguard_Veteran());	
		}
	}	
}
