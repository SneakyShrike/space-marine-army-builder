package model.elites.ironclad_dreadnought;

import model.UnitSquad;

public class Ironclad_DreadnoughtSquad extends UnitSquad 
{

	public Ironclad_DreadnoughtSquad(String squadName) 
	{
		super(squadName);
		unitName = "Ironclad Dreadnought ";
		super.setMaxSize(3);
		super.setMinSize(1);
	}
	
	@Override
	public void addUnitSquad()
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Ironclad_Dreadnought());	
		}
	}
}
