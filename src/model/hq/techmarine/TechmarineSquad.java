package model.hq.techmarine;

import model.UnitSquad;

public class TechmarineSquad extends UnitSquad
{
	public TechmarineSquad(String squadName) 
	{
		super(squadName);
		unitName = "Techmarine ";
		super.setMaxSize(1);
		super.setMinSize(1);		
	}
	
	@Override
	public void addUnitSquad ()
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Techmarine());	
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
