package model.elites.command;

import model.Unit;
import model.UnitSquad;
import model.troops.scout.Scout;

public class CommandSquad extends UnitSquad
{
	public CommandSquad(String squadName) 
	{
		super(squadName);
		unitName = "Command ";
		super.setMaxSize(5);
		super.setMinSize(5);
	}
	
	@Override
	public void addUnitSquad ()
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Command());	
		}
	}
	
}
