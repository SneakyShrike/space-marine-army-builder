package troops.scout;

import wargear.weapon.Weapon;

public class ScoutSergeant extends Scout 
{
	private Weapon weapon;
	private int points;
	
	public ScoutSergeant()
	{
		super();
	}
	
	@Override
	public void scoutWeaponUpgrade(Weapon weapon) 
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
