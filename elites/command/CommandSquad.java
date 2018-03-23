package elites.command;

import gui.model.UnitSquad;
import troops.scout.Scout;

public class CommandSquad extends UnitSquad
{
	public CommandSquad(String squadName) 
	{
		super(squadName);
		unitName = "Command ";
		super.setMaxSize(5);
	}
	
	@Override
	public void addUnitSquad (int number)
	{
		for (int i = 0; i < number; i++)
		{
			if (unitList.size() < MAX)
				unitList.add(new Command());	
		}
	}
}
