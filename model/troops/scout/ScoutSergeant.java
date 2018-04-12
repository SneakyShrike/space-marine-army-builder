package model.troops.scout;

import model.Unit;
import model.wargear.weapon.Weapon;

public class ScoutSergeant extends Scout 
{
	private Weapon weapon;
	private int points;
	
	public ScoutSergeant()
	{
		super();
		unitName = "Scout Sergeant ";
	}
	
	/*@Override
	public void ScoutSergeantWeaponUpgrade(Weapon weapon) 
	{		
		 this.weapon = weapon; 
	     points = points + weapon.getWeaponPoints();
    }*/ 
		
	@Override
	public String toString() 
	{
		return unitName;		
	}
}
