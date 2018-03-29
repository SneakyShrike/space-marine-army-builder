package troops.scout;

import gui.model.Unit;
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
		super();
		unitName = "Scout Squad"; //default name of a scout squad
        weapon = WeaponList.getRanged("Boltgun");
		points = 11 + weapon.getWeaponPoints();//default weapon of a scout
        weaponSkill = 4;
        ballisticSkill = 4;
        strength = 4;
        toughness = 4; 
        wounds = 1;
        initiative = 4;
        attacks = 1;
        leadership = 8;
        save = "4+";
   
        unitWeaponsList.add(WeaponList.getRanged("Boltgun"));
        unitWeaponsList.add(WeaponList.getScoutWeapon("Shotgun"));
        unitWeaponsList.add(WeaponList.getScoutWeapon("Close Combat Weapon"));
        unitWeaponsList.add(WeaponList.getScoutWeapon("Sniper Rifle"));
        unitWeaponsList.add(WeaponList.getHeavy("Heavy Bolter"));
        unitWeaponsList.add(WeaponList.getScoutWeapon("Heavy Bolter (Hellfire Shell)"));
        unitWeaponsList.add(WeaponList.getHeavy("Missile Launcher (Frag)"));
        unitWeaponsList.add(WeaponList.getHeavy("Missile Launcher (Krak)"));
        unitWeaponsList.add(WeaponList.getHeavy("Missile Launcher (Flakk)"));       
	}
}
