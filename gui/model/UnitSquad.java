package gui.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import troops.scout.Scout;
import troops.scout.ScoutSergeant;
import wargear.weapon.Weapon;
import wargear.weapon.WeaponList;

public abstract class UnitSquad implements Iterable<Unit>
{
	private String squadName; 
	private List<Unit> unitList; 
	private int number;
	private final int MAX = 0;
	
	public UnitSquad(String squadName) //creates a new array list of scouts with a name
	{
		this.squadName = squadName;
		unitList = new ArrayList<>();				
	}
	
	public Iterator<Unit> iterator() 
	{
		return unitList.iterator();
	}
	
	public void setName (String name) //changes the name of a squad
	{
		this.squadName = name;
	}
	
	public String getName() //gets the updated name of a squad
	{
		return squadName;		
	}
	
	public void addUnit (Unit u) //adds scouts until it reaches max
	{
		if (unitList.size() < MAX)
			unitList.add(u);
				
		else 
			System.out.println("You can only have 9 or less scouts");							
	}
	
	public void addUnitSquad (int number)//adds scouts to the specified number instead of max
	{
		for (int i = 0; i < number; i++)
		{
			if (unitList.size() < MAX)
				unitList.add(new Unit());		
		}			
	}
	
	public void weaponUpgrade(Weapon weapon, int amount)
	{
		for (int i = 1; i <= amount; i++)
		{
			switch(weapon.toString())
			{
			   case "Heavy Bolter" :
			   case "Heavy Bolter (Hellfire Shell)" :			 
			   case "Missle Launcher (Frag)" :
			   case "Missle Launcher (Krak)" :
			   case "Missle Launcher (Flakk)" :
				   amount = 1;
			   default:
				   getScout(i).scoutWeaponUpgrade(weapon);				   				
			}
		}
	}
	
	public int getSquadSize ()
	{
		return number;
	}
				
	public void removeUnit (int number) //remove a single scout from a squad, specified by the squad member number
	{
		unitList.remove(number);
	}
	
	public void clearUnitList() //clears an entire scout squad
	{
		unitList.clear();
	}
	
	public Unit getUnit(int index)
	{
		Unit u = null;
        if (0 <= index && index < unitList.size())
          u = unitList.get(index);
        
         else 
           u = null;
        
        return u;
	}
		
	public ScoutSergeant getScoutSergeant(int index)
	{
		ScoutSergeant s = null;
        if (0 <= index && index < unitList.size())
        	unitList.get(index);
        
         else 
           s = null;
        
        return s;
	}
	
	public String getUnitSquad()
	{
		String s = "\nScout Squad: " + this.squadName + "\n\n";		
		
		for (int i = 0; i < unitList.size(); i++)
			s = s + "(" + (i+1)+ ")" + " " + "Scout" + " " + unitList.get(i).getScoutDetails() + "\n";
		
		return s;
	}
	
	public int getMaxSize()
	{
		return MAX;
	}
	
	public void setScoutSquadWeapons(int index, Weapon weapon)
	{
		unitList.get(index);		
	}		
}
	
