package model.fast_attack.attack_bike;

import model.Unit;
import model.wargear.weapon.WeaponList;

public class Attack_Bike extends Unit
{
	public Attack_Bike()
	{
		super();
		unitName = "Attack Bike Squad";
        weapon = WeaponList.getBikeWeapon("Twin-Linked Bolter (Integrated)");
        weaponTwo = WeaponList.getBikeWeapon("Heavy Bolter (Mounted)");
	    points = 40 + weapon.getWeaponPoints() + weaponTwo.getWeaponPoints();
        weaponSkill = 4;
        ballisticSkill = 4;
        strength = 4;
        toughness = 5; 
        wounds = 2;
        initiative = 4;
        attacks = 2;
        leadership = 8;
        save = "3+";
        
        unitWeaponsList.add(WeaponList.getBikeWeapon("Twin-Linked Bolter (Integrated)"));
        
        unitSecondWeaponsList.add(WeaponList.getBikeWeapon("Heavy Bolter (Mounted)"));
        unitSecondWeaponsList.add(WeaponList.getBikeWeapon("Multi-Melta (Mounted)"));        
	}
	
	@Override
	public String getUnitDetails()
	{
		return "|| " + "Weapons: " + weapon + " + " + weaponTwo + " || " + "Points: " + points;
	}
}
