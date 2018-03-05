package troops.scout;

import java.util.List;

import gui.model.Unit;
import wargear.weapon.Weapon;
import wargear.weapon.WeaponList;

public class Scout extends Unit
{
				
	/**
	 * A default constructor that creates a scout with a default weapon of a boltgun,
	 * it also ensures that there can be no more than 9 members in a scout squad. A 
	 * unit name is also specified and the scouts characteristics values are set. 
	 * Lastly the points value of a scout is specified and that is then added onto 
	 * the points value of the default weapon. So the points value should now be 
	 * totalled for both the scout and it's weapon.   
	 */
	
	public Scout() 
	{   
		//super();
		unitName = "Scout Squad"; //default name of a scout squad
		COMBOMAXSIZE = 9; //max number of values in the combo box, NEEDS TO INHERIT FROM SCOUT SQUAD SQUAD MAXSIZE SOMEHOW
        weapon = WeaponList.getRanged("Boltgun"); //default weapon of a scout
        weaponSkill = 4;
        ballisticSkill = 4;
        strength = 4;
        toughness = 4; 
        wounds = 1;
        initiative = 4;
        attacks = 1;
        leadership = 8;
        save = "4+";
        points = 11; //the points value of a single scout
        points = points + weapon.getWeaponPoints(); /*points is updated to include the
                                                      points value of the default weapon*/
        
        unitWeaponsList.add(WeaponList.getRanged("Boltgun"));
        unitWeaponsList.add(WeaponList.getScoutWeapon("Shotgun"));
        unitWeaponsList.add(WeaponList.getScoutWeapon("Close Combat Weapon"));
        unitWeaponsList.add(WeaponList.getScoutWeapon("Sniper Rifle"));
        unitWeaponsList.add(WeaponList.getHeavy("Heavy Bolter"));
        unitWeaponsList.add(WeaponList.getScoutWeapon("Heavy Bolter (Hellfire Shell)"));
        unitWeaponsList.add(WeaponList.getHeavy("Missle Launcher (Frag)"));
        unitWeaponsList.add(WeaponList.getHeavy("Missle Launcher (Krak)"));
        unitWeaponsList.add(WeaponList.getHeavy("Missle Launcher (Flakk)"));

	}
		
	
	/**
	 * Allows a scout to upgrade it's weapon. It does this by checking if
	 * the weapon to upgrade to is permitted for the unit. If the weapon is contained
	 * within the switch statement then it is permitted and the weapon variable is 
	 * updated with the new weapon. The new weapons points value is then added onto 
	 * the existing points value. If the weapon supplied is not permitted then a prompt 
	 * is displayed telling the user which weapon they supplied was invalid.
	 * 
	 * @param weapon the weapon supplied to upgrade to.
	 */
	
	public void scoutWeaponUpgrade(Weapon weapon) 
	{		
		/*switch(weapon.toString())
		{
		   case "Boltgun" : 
		   case "Shotgun" :
		   case "Close Combat Weapon" :
		   case "Sniper Rifle" :*/
			   this.weapon = weapon; 
	           points = points + weapon.getWeaponPoints();
	       /*break;
		   case "Heavy Bolter" :
			   weapon.setWeaponPoints(8); //THIS NEEDS REVIEWING
		   case "Heavy Bolter (Hellfire Shell)" :			 
		   case "Missle Launcher (Frag)" :
		   case "Missle Launcher (Krak)" :
		   case "Missle Launcher (Flakk)" :
		       this.weapon = weapon; 
	           points = points + weapon.getWeaponPoints();
	        break;        
	        default :
	        	System.out.println("A Scout can't have a " + weapon);	       	        	
		}*/
    }
	
	
	
	public List<Weapon> getScoutWeapons ()
	{
		return unitWeaponsList;
	}
	
	/**
	 * Updates the existing points variable with the methods supplied parameter 
	 * 
	 * @param points the new points value to be added onto the existing points field declared
	 * in the classes constructor
	 */
	
	public void setPoints (int points)
	{
		this.points = points;
	}
	
	/**
	 * Returns the current weapon of a scout
	 * 
	 * @return the current weapon of a scout
	 */
	
							
	public Weapon getWeaponUpgrade()
	{
		return weapon;
	}
	
	/**
	 * Returns the scouts characteristics values in a nice format. 
	 * 
	 * @return the characteristics values of a scout
	 */
	
	public String getCharacteristics()
	{		
		return "Scout Characteristics: " + "WS:" + weaponSkill + "  " + "BS:" + ballisticSkill + "  " + "S:" + strength
				+ "  " + "T:" + toughness + "  " + "W" + wounds + "  " + "I:" + initiative + "  " + "A:" + attacks
				+ "  " + "LD:" + leadership + "  " + "SV:" + save;
	}
	
	/**
	 * Returns a scouts details including the weapon, equipment and points value of a single 
	 * scout, in a nice format.
	 * 
	 * @return a single scouts details
	 */
	
	public String getScoutDetails()
	{
		return "|| " + "Weapon: " + weapon + " || " + "Points: " + points;
	}
	
	/**
	 * Returns the maximum amount of scouts allowed in a scout squad
	 * 
	 * @return an int specifying the maximum amount of scouts allowed in a scout squad
	 */
	
	public int getMaxSize()
	{
		return COMBOMAXSIZE;
	}
	
}
