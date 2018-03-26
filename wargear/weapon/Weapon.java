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
}
