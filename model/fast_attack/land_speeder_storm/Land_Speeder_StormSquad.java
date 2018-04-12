package model.fast_attack.land_speeder_storm;

import model.UnitSquad;

public class Land_Speeder_StormSquad extends UnitSquad 
{

	public Land_Speeder_StormSquad(String squadName)
	{
		super(squadName);
		unitName = "Land Speeder Storm ";
		super.setMaxSize(1);
		super.setMinSize(1);

	}
	
	@Override
	public void addUnitSquad ()//adds scouts to the specified number instead of max
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Land_Speeder_Storm());	
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
