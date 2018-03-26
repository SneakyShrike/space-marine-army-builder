package troops.tactical;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gui.model.UnitSquad;
import troops.scout.Scout;
import troops.scout.ScoutSergeant;
import wargear.weapon.Weapon;
import wargear.weapon.WeaponList;

public class TacticalSquad extends UnitSquad
{
	//private String squadName; //a scout squad has a name
		//private List<Unit> unitList; //a scout squad is an aggregation of scouts 
		//private int number;
		//private final int MAX = 9;
		
		public TacticalSquad(String squadName) //creates a new array list of scouts with a name
		{
			super(squadName);
			unitName = "Tactical ";
			super.setMaxSize(9);
			
			//this.squadName = squadName;
			//scoutList = new ArrayList<>();
		}
		
		/*public Iterator<Scout> iterator() 
		{
			return scoutList.iterator();
		}*/
		
		/*public void setName (String name) //changes the name of a squad
		{
			this.squadName = name;
		}*/
		
		/*public String getName() //gets the updated name of a squad
		{
			return squadName;		
		}*/
		
		/*@Override-------------------
		public void addUnit (Unit s) //adds scouts until it reaches max
		{
			if (unitList.size() < MAX)
				unitList.add(s);						
		}*/
		
		@Override
		public void addUnitSquad (int number)//adds scouts to the specified number instead of max
		{
			for (int i = 0; i < number; i++)
			{
				if (unitList.size() < MAX)
					unitList.add(new Tactical());	
			}
		}
		
		@Override
		public void weaponUpgrade(Weapon weapon, int amount)
		{
			for (int i = 0; i <= amount; i++)
			{
				switch(weapon.toString())
				{
				   case "Flamer" :
				   case "Meltagun" :			 
				   case "Grav-Gun" :
				   case "Heavy Bolter" :
				   case "Multi-Melta" :
				   case "Missile Launcher (Frag)" :
				   case "Missile Launcher (Krak)" :
				   case "Missile Launcher (Flakk)": //THIS NEEDS REVISTING
				   case "Plasma Cannon" :
				   case "Lascannon" :
				   case "Grav-Cannon" :
				   case "Grav-Amp" :
					   if (super.getMaxSize() < 10)
					       amount = 1;
					   
					   else if (super.getMaxSize() == 10)
						   amount = 2; //NEEDS CHANGING READ CODEX
				   default:
					   getUnit(i).unitWeaponUpgrade(weapon);
					   //super.weaponUpgrade(weapon, amount);
				}
			}
		}
		
		/*public int getSquadSize ()
		{
			return number;
		}*/
					
		/*public void removeScout (int number) //remove a single scout from a squad, specified by the squad member number
		{
			scoutList.remove(number);
		}*/
		
		/*public void clearScoutList() //clears an entire scout squad
		{
			scoutList.clear();
		}*/
		
		/*public Unit getScout(int index)
		{
			Unit s = null;
	        if (0 <= index && index < unitList.size())
	          s = unitList.get(index);
	        
	         else 
	           s = null;
	        
	        return s;
		}*/
			
		/*public ScoutSergeant getScoutSergeant(int index)
		{
			ScoutSergeant s = null;
	        if (0 <= index && index < scoutList.size())
	        	scoutList.get(index);
	        
	         else 
	           s = null;
	        
	        return s;
		}*/
		/*@Override
		public String getUnitSquad()
		{
			String s = "\n" + unitName + "Squad: " + this.squadName + "\n\n";
			
			for (int i = 0; i < unitList.size(); i++)
				s = s + "(" + (i+1)+ ")" + " " + unitName + " " + unitList.get(i).getUnitDetails() + "\n";
			
			return s;
		}*/
		
		/*public int getMaxSize()
		{
			return MAX;
		}*/		

}
