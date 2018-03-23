package elites.centurion_assault;

import gui.model.UnitSquad;

public class Centurion_AssaultSquad extends UnitSquad 
{
	public Centurion_AssaultSquad(String squadName) 
	{
		super(squadName);
		unitName = "Centurion Assault ";
		super.setMaxSize(6);
	}
	
	@Override
	public void addUnitSquad (int number)//adds scouts to the specified number instead of max
	{
		for (int i = 0; i < number; i++)
		{
			if (unitList.size() < MAX)
				unitList.add(new Centurion_Assault());	
		}
	}
}
