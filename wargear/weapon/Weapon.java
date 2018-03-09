package wargear.weapon;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class Weapon 
{
	private String name;
	private int points;
	private ArrayList<Integer> weaponUpgradeAmount;

	public Weapon(String name, int points)
	{
		this.name = name;
		this.points = points;		
	}
	
	public int getWeaponPoints()
	{
		return points;		
	}
	
	public void setWeaponPoints(int points)
	{
		this.points = points;		
	}
	
	public String getWeapon()
	{
		return name + points;		
	}
	
	@Override
	public String toString() 
	{
		return name;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null || this.getClass() != obj.getClass())
			return false;
		
		Weapon other = (Weapon) obj;
		
		return this.name.equals(other.name);
	}
	
	
	/*public ObservableList<Integer> getWeaponUpgradeAmount(Weapon weapon)
	{	switch(weapon.toString())
		{
		   case "Boltgun" : 
		   case "Shotgun" :
		   case "Close Combat Weapon" :
		   case "Sniper Rifle" :
			   for (int i = 1; i == 5; i++)
			   {
				   weaponUpgradeAmount.add(i);				   
			   }				   			   
	       break;
		   case "Heavy Bolter" :
		   case "Heavy Bolter (Hellfire Shell)" :			 
		   case "Missle Launcher (Frag)" :
		   case "Missle Launcher (Krak)" :
		   case "Missle Launcher (Flakk)" :
			   for (int i = 1; i == 1; i++)
			   {
				   weaponUpgradeAmount.add(i);				   
			   }
	        break;        
       	        	
		}
		ObservableList<Integer> weaponUpgradeAmountOList = FXCollections.observableArrayList(weaponUpgradeAmount);
		return weaponUpgradeAmountOList;
	}*/
}
