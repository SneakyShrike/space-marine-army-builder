package model.heavy_support.centurion_devastator;

import model.UnitSquad;

public class Centurion_DevastatorSquad extends UnitSquad 
{
	public Centurion_DevastatorSquad(String squadName) 
	{
		super(squadName);
		unitName = "Centurion Devastator ";
		super.setMaxSize(6);
		super.setMinSize(3);
	}
	
	@Override
	public void addUnitSquad ()
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Centurion_Devastator());	
		}
	}
}
