package fast_attack.stormtalon_gunship;

import gui.model.UnitSquad;

public class Stormtalon_GunshipSquad extends UnitSquad 
{

	public Stormtalon_GunshipSquad(String squadName) 
	{
		super(squadName);
		unitName = "Stormtalon Gunship ";
		super.setMaxSize(1);
		super.setMinSize(1);
	}
	
	@Override
	public void addUnitSquad ()
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Stormtalon_Gunship());	
		}
	}
	
	@Override
	public String getUnitSquad()
	{
		String s = "\n" + unitName + this.squadName 
		+ "\n" + 
		"Total Points: " + getSquadPoints() + "\n\n";		
		
		for (int i = 0; i < unitList.size(); i++)
			s = s + "(" + (i+1)+ ")" + " " + unitName + " " + unitList.get(i).getUnitDetails() + "\n";
		
		return s;
	}
	
	@Override
	public String SquadSizeCheck()
    {
    	String message = "";
    	
    	if (unitList.size() > max)
    	message =  "Only " + max + " " + unitName + " is permitted";
    	   	
    	return message;   		   	
    }
}
