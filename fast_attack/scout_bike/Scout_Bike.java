package fast_attack.scout_bike;

import gui.model.Unit;
import wargear.weapon.WeaponList;

public class Scout_Bike extends Unit 
{
	public Scout_Bike()
	{
		super();
		unitName = "Scout Bike Squad"; 
		weapon = WeaponList.getScoutWeapon("Shotgun");
	    weaponTwo = WeaponList.getBikeWeapon("Twin-Linked Bolter (Integrated)");
	    points = 18 + weapon.getWeaponPoints() + weaponTwo.getWeaponPoints();
        weaponSkill = 4;
        ballisticSkill = 4;
        strength = 4;
        toughness = 5; 
        wounds = 1;
        initiative = 4;
        attacks = 1;
        leadership = 8;
        save = "4+";
        
        unitWeaponsList.add(WeaponList.getScoutWeapon("Shotgun"));
        
        unitSecondWeaponsList.add(WeaponList.getBikeWeapon("Twin-Linked Bolter (Integrated)"));
        unitSecondWeaponsList.add(WeaponList.getBikeWeapon("Grenade Launcher (Integrated)"));
	}
	
	@Override
	public String getUnitDetails()
	{
		return "|| " + "Weapons: " + weapon + " + " + weaponTwo + " || " + "Points: " + points;
	}
}
