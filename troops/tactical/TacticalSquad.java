package troops.tactical;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import troops.scout.Scout;
import troops.scout.ScoutSergeant;
import wargear.weapon.WeaponList;

public class TacticalSquad implements Iterable<Tactical>
{
	private String squadName; //a scout squad has a name
	private List<Tactical> tacticalList; //a scout squad is an aggregation of scouts  
	private int number;
	private final int MAX = 9; //the maximum number of scouts in a squad is 9
	
	public TacticalSquad(String squadName) //creates a new array list of scouts with a name
	{
		this.squadName = squadName;
		tacticalList = new ArrayList<>();				
	}
	
	public Iterator<Tactical> iterator() 
	{
		return tacticalList.iterator();
	}
	
	public void setName (String name) //changes the name of a squad
	{
		this.squadName = name;
	}
	
	public String getName() //gets the updated name of a squad
	{
		return squadName;		
	}
	
	public void addTactical (Tactical s)
	{
		if (tacticalList.size() < MAX)
			tacticalList.add(s);
				
		else 
			System.out.println("You can only have 9 or less scouts");							
	}
	
	public void addTacticalSquad (Tactical s, int number)
	{
		for (int i = 0; i < number; i++)
		{
			if (tacticalList.size() < MAX)
			tacticalList.add(s);
			
			else 
				System.out.println("You can only have 9 or less scouts");
		}			
	}
				
	public void removeTactical (int number)
	{
		tacticalList.remove(number);
	}
	
	public void clearTacticalList()
	{
		tacticalList.clear();
	}
	
	public Tactical getTactical(int index)
	{
		Tactical s = null;
        if (0 <= index && index < tacticalList.size())
          s = tacticalList.get(index);
        
         else 
           s = null;
        
        return s;
	}
		
	public ScoutSergeant getTacticalSergeant(int index)
	{
		ScoutSergeant s = null;
        if (0 <= index && index < tacticalList.size())
        	tacticalList.get(index);
        
         else 
           s = null;
        
        return s;
	}
	
	public String getTacticalSquad()
	{
		String s = "\nTactical Squad: " + this.squadName + "\n\n";		
		
		for (int i = 0; i < tacticalList.size(); i++)
			s = s + "(" + (i+1)+ ")" + " " + "Tactical" + " " + tacticalList.get(i).getTacticalDetails() + "\n";
		
		return s;
	}
	
	public int getMaxSize()
	{
		return MAX;
	}
		
	public void SquadWeaponsCheck() //checks to ensure there are only 1 of certain weapons in a squad
	{ 
		int HeavyBolterCount = 0;
		
		for (Tactical scout : tacticalList) //for all the scouts in the squad
        {
        	if (scout.getWeaponUpgrade().equals(WeaponList.getHeavy("Heavy Bolter"))) //if the scouts weapon upgrade = heavy bolter 
        	{
        		HeavyBolterCount++; //increment the heavy bolter count
        	
                if (HeavyBolterCount > 1) //if the heavy bolter count is greater than 1 
                {
                	System.out.println("A Scout Squad is permitted to 1 Heavy Bolter only."); //print this
                	scout.weaponUpgrade(WeaponList.getRanged("Boltgun")); //reset the weapon upgrade back to a default boltgun
                	scout.setPoints(11); //set points back to default            	
                }      		
        	}
        }		
	}

}
