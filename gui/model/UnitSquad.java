package gui.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import troops.scout.ScoutSergeant;
import wargear.weapon.Weapon;

public class UnitSquad implements Serializable, Iterable<Unit>
{
	protected String squadName, unitName; 
	protected List<Unit> unitList; 
	private int number, squadPoints;
	protected int MAX;
	
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
			getUnit(i).unitWeaponUpgrade(weapon);				   				
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
		
	/*public ScoutSergeant getScoutSergeant(int index)
	{
		ScoutSergeant s = null;
        if (0 <= index && index < unitList.size())
        	unitList.get(index);
        
         else 
           s = null;
        
        return s;
	}*/
	
	public String getUnitSquad()
	{
		String s = "\n" + unitName + "Squad: " + this.squadName 
		+ "\n" + 
		"Total Squad Points: " + getSquadPoints() + "\n\n";		
		
		for (int i = 0; i < unitList.size(); i++)
			s = s + "(" + (i+1)+ ")" + " " + unitName + " " + unitList.get(i).getUnitDetails() + "\n";
		
		return s;
	}
	
	@Override 
	public String toString()
	{
		return this.getUnitSquad();
	}
	
	public void setMaxSize (int size) //changes the name of a squad
	{
		this.MAX = size;
	}
	
	public int getMaxSize()
	{
		return MAX;
	}
	
	public void setScoutSquadWeapons(int index, Weapon weapon)
	{
		unitList.get(index);		
	}
	
	public int getSquadPoints ()
	{
		int total = 0;
		
		for (int i = 0; i < unitList.size(); i++)
			total = total + unitList.get(i).getUnitPoints();
		
		return total; 
	}
}
	
