package troops.scout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gui.model.Unit;
import wargear.weapon.Weapon;
import wargear.weapon.WeaponList;

public class ScoutSquad implements Iterable<Scout>
{
	private String squadName; //a scout squad has a name
	private List<Scout> scoutlist; //a scout squad is an aggregation of scouts  
	private int number;
	private final int MAX = 9; //the maximum number of scouts in a squad is 9
	
	public ScoutSquad(String squadName) //creates a new array list of scouts with a name
	{
		this.squadName = squadName;
		scoutlist = new ArrayList<>();				
	}
	
	public Iterator<Scout> iterator() 
	{
		return scoutlist.iterator();
	}
	
	public void setName (String name) //changes the name of a squad
	{
		this.squadName = name;
	}
	
	public String getName() //gets the updated name of a squad
	{
		return squadName;		
	}
	
	public void addScout (Scout s)
	{
		if (scoutlist.size() < MAX)
				scoutlist.add(s);
				
		else 
			System.out.println("You can only have 9 or less scouts");							
	}
	
	public void addScoutSquad (Scout s, int number)
	{
		for (int i = 0; i < number; i++)
		{
			if (scoutlist.size() < MAX)
			scoutlist.add(s);
			
			else 
				System.out.println("You can only have 9 or less scouts");
		}			
	}
				
	public void removeScout (int number)
	{
		scoutlist.remove(number);
	}
	
	public void clearScoutList()
	{
		scoutlist.clear();
	}
	
	public Scout getScout(int index)
	{
		Scout s = null;
        if (0 <= index && index < scoutlist.size())
          s = scoutlist.get(index);
        
         else 
           s = null;
        
        return s;
	}
		
	public ScoutSergeant getScoutSergeant(int index)
	{
		ScoutSergeant s = null;
        if (0 <= index && index < scoutlist.size())
          scoutlist.get(index);
        
         else 
           s = null;
        
        return s;
	}
	
	public String getScoutSquad()
	{
		String s = "\nScout Squad: " + this.squadName + "\n\n";		
		
		for (int i = 0; i < scoutlist.size(); i++)
			s = s + "(" + (i+1)+ ")" + " " + "Scout" + " " + scoutlist.get(i).getScoutDetails() + "\n";
		
		return s;
	}
	
	public int getMaxSize()
	{
		return MAX;
	}
		
	public void SquadWeaponsCheck() //checks to ensure there are only 1 of certain weapons in a squad
	{ 
		int HeavyBolterCount = 0;
		
		for (Scout scout : scoutlist) //for all the scouts in the squad
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
