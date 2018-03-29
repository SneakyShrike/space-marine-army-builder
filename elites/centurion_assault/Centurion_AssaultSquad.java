package elites.centurion_assault;

import gui.model.UnitSquad;

public class Centurion_AssaultSquad extends UnitSquad 
{
	public Centurion_AssaultSquad(String squadName) 
	{
		super(squadName);
		unitName = "Centurion Assault ";
		super.setMaxSize(6);
		super.setMinSize(3);
	}
	
	@Override
	public void addUnitSquad ()
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Centurion_Assault());	
		}
	}
}
