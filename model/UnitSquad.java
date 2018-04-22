package model;

import java.io.Serializable;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.wargear.weapon.Weapon;

public class UnitSquad implements Serializable, Iterable<Unit>
{
	protected String squadName, unitName; 
	protected List<Unit> unitList; 
	protected int max, min;
	
	public UnitSquad(String squadName) //creates a new array list of units with a name
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
	
	public void addUnit (Unit u) 
	{
		unitList.add(u);						
	}
	
	public void addUnitSquad ()//adds scouts to the specified number instead of max
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Unit());		
		}			
	}
	
	public void weaponUpgrade(Weapon weapon, int member)
	{
		getUnit(member).unitWeaponUpgrade(weapon);				   				
	}
	
	public void secondWeaponUpgrade(Weapon weapon, int member)
	{
		getUnit(member).unitSecondWeaponUpgrade(weapon);				   				
	}
	
	public void updateUnitSize(int number)
	{
		for (int i = 0; i < number; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Unit());		
		}		
	}
	
	public String SquadWeaponsCheck()
	{
		int weaponCount = 0;
		String message = "";		
		return message;
	}
	
	public String SquadSizeCheck()
    {
    	String message = "";
    	
    	if (unitList.size() > max)
    	message =  "A " + unitName + "Squad must not exceed " + max + " members";
    	
    	else if (unitList.size() < min)
    		message =  "A " + unitName + "Squad must not fall short of " + min + " members";
    	   	
    	return message;   		   	
    }
		
	public void removeUnit (int number) //remove a single member from a squad, specified by the squad member number
	{
		unitList.remove(number);		
	}
	
	public void clearUnitList() //clears an entire scout squad
	{
		unitList.clear();
	}
	
	public int unitListSize()
	{
		return unitList.size();
	}
		
	public int getLastIndex()
	{
		return unitList.size() -1;
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
			
	public String getUnitSquad()
	{
		String s = "\n" + unitName + "Squad: " + this.squadName 
		+ "\n" + 
		unitList.get(0).getCharacteristics() 
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
	
	public void setMaxSize (int size) 
	{
		this.max = size;
	}
	
	public int getMaxSize()
	{
		return max;
	}
	
	public void setMinSize (int size) 
	{
		this.min = size;
	}
	
	public int getMinSize()
	{
		return min;
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
	
	/*public ObservableList<Weapon> getUnitWeapons()
	{
		Unit u = new Unit();
		ObservableList<Weapon> unitWeaponsOList = FXCollections.observableArrayList(u.unitWeaponsList);
		return unitWeaponsOList;
	}
	
	public ObservableList<Weapon> getUnitSecondWeapons()
	{
		Unit u = new Unit();
		ObservableList<Weapon> unitSecondWeaponsOList = FXCollections.observableArrayList(u.unitSecondWeaponsList);
		return unitSecondWeaponsOList;
	}*/	
}
	
