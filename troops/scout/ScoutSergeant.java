package troops.scout;

import gui.model.Unit;
import wargear.weapon.Weapon;

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
