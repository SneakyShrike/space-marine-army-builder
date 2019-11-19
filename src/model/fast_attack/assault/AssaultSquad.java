package model.fast_attack.assault;

import model.Unit;
import model.UnitSquad;

public class AssaultSquad extends UnitSquad
{
	public AssaultSquad(String squadName) 
	{
		super(squadName);
		unitName = "Assault Marine ";
		super.setMaxSize(10);
		super.setMinSize(5);
	}
	
	@Override
	public void addUnitSquad ()
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Assault());	
		}
	}
	
	@Override
	public String SquadWeaponsCheck()
	{
		int weaponCount = 0;
		String message = "";
		
			for (Unit unit : unitList)
			{
				switch(unit.getWeaponUpgrade().toString())
				{
				    case "Flamer":
				    case "Plasma Pistol":
				    	weaponCount++;
					break;   					   
				}					
			}
			
			if (weaponCount > 2)
			{
				message = "Only 2 Assault Marines may replace their Bolt Pistol with a Flamer or Plasma Pistol";
			}

							
	return message;	
		
	}
}
