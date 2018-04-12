package model.fast_attack.bike;

import model.Unit;
import model.wargear.weapon.WeaponList;

public class Bike extends Unit 
{
	public Bike()
	{
		super();
		unitName = "Bike Squad"; 
        weapon = WeaponList.getBikeWeapon("Twin-Linked Bolter (Integrated)");
        weaponTwo = WeaponList.getRanged("Bolt Pistol");
	    points = 21 + weapon.getWeaponPoints() + weaponTwo.getWeaponPoints();
        weaponSkill = 4;
        ballisticSkill = 4;
        strength = 4;
        toughness = 5; 
        wounds = 1;
        initiative = 4;
        attacks = 1;
        leadership = 8;
        save = "3+";
        
        unitWeaponsList.add(WeaponList.getBikeWeapon("Twin-Linked Bolter (Integrated)"));

        unitSecondWeaponsList.add(WeaponList.getRanged("Bolt Pistol"));
        unitSecondWeaponsList.add(WeaponList.getMelee("Chainsword"));
        unitSecondWeaponsList.add(WeaponList.getSpecial("Flamer"));
        unitSecondWeaponsList.add(WeaponList.getSpecial("Meltagun"));
        unitSecondWeaponsList.add(WeaponList.getSpecial("Grav-Gun"));
        unitSecondWeaponsList.add(WeaponList.getSpecial("Plasma Gun"));
	}
	
	@Override
	public String getUnitDetails()
	{
		return "|| " + "Weapons: " + weapon + " + " + weaponTwo + " || " + "Points: " + points;
	}
}
