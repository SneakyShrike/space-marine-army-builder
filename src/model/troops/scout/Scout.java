package model.troops.scout;

import model.Unit;
import model.wargear.weapon.WeaponList;

public class Scout extends Unit
{					
	public Scout() 
	{   
		super();
		unitName = "Scout Squad"; 
        weapon = WeaponList.getRanged("Boltgun"); //default weapon of a scout
		points = 11 + weapon.getWeaponPoints();
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



