package fast_attack.attack_bike;

import gui.model.UnitSquad;
import troops.scout.Scout;

public class Attack_BikeSquad extends UnitSquad
{
	public Attack_BikeSquad(String squadName)
	{
		super(squadName);
		unitName = "Attack Bike ";
		super.setMaxSize(3);
		super.setMinSize(1);		
	}
	
	@Override
	public void addUnitSquad ()
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Attack_Bike());	
		}
	}

}
