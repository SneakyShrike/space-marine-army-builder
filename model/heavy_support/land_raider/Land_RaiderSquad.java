package model.heavy_support.land_raider;

import model.UnitSquad;

public class Land_RaiderSquad extends UnitSquad 
{
	public Land_RaiderSquad(String squadName) 
	{
		super(squadName);
		unitName = "Land Raider ";
		super.setMaxSize(1);
		super.setMinSize(1);
	}
	
	@Override
	public void addUnitSquad ()//adds scouts to the specified number instead of max
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Land_Raider());	
		}
	}
	
	@Override
	public String getUnitSquad()
	{
		String s = "\n" + unitName + this.squadName 
		+ "\n" + 
		unitList.get(0).getCharacteristics() 
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
    	
    	else if (unitList.size() < min)
    		message =  "There must be at least " + min + " " + unitName;
    	   	
    	return message;   		   	
    }
}
