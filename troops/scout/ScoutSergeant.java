package troops.scout;

import wargear.weapon.Ranged;
import wargear.weapon.Weapon;
import wargear.weapon.WeaponList;

public class ScoutSergeant extends Scout 
{
	private Weapon weapon;
	private int points;
	
	public ScoutSergeant()
	{
		super();
	}
	
	@Override
	public void weaponUpgrade(Weapon weapon) 
	{		
		 this.weapon = weapon; 
	     points = points + weapon.getWeaponPoints();
    }  
		
	@Override
	public String toString() 
	{
		return "Sergeant " + super.getScoutDetails();
	}
}
