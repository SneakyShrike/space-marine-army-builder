package model.fast_attack.drop_pod;

import model.UnitSquad;

public class Drop_PodSquad extends UnitSquad
{
	public Drop_PodSquad(String squadName)
	{
		super(squadName);
		unitName = "Drop Pod ";
		super.setMaxSize(1);
		super.setMinSize(1);		
	}
	
	@Override
	public void addUnitSquad ()
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Drop_Pod());	
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
    	   	
    	return message;   		   	
    }
}
