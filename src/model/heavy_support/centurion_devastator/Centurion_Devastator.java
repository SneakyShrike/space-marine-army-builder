package model.heavy_support.centurion_devastator;

import model.Unit;
import model.wargear.weapon.WeaponList;

public class Centurion_Devastator extends Unit 
{
	public Centurion_Devastator()
	{
		super();
		unitName = "Centurion Devastator Squad"; 
		weapon = WeaponList.getCenturionWeapon("Twin-Linked Heavy Bolter (Arm)");
	    weaponTwo = WeaponList.getCenturionWeapon("Hurricane Bolter (Chest)");
	    points = 55 + weapon.getWeaponPoints() + weaponTwo.getWeaponPoints();
        weaponSkill = 4;
        ballisticSkill = 4;
        strength = 5;
        toughness = 5; 
        wounds = 2;
        initiative = 4;
        attacks = 1;
        leadership = 8;
        save = "2+";
        
        unitWeaponsList.add(WeaponList.getCenturionWeapon("Twin-Linked Heavy Bolter (Arm)"));
        unitWeaponsList.add(WeaponList.getCenturionWeapon("Grav-Cannon (Arm)"));
        unitWeaponsList.add(WeaponList.getCenturionWeapon("Grav-Amp (Arm)"));
        unitWeaponsList.add(WeaponList.getCenturionWeapon("Twin-Linked Lascannon (Arm)"));
        
        unitSecondWeaponsList.add(WeaponList.getCenturionWeapon("Hurricane Bolter (Chest)"));
        unitSecondWeaponsList.add(WeaponList.getCenturionWeapon("Missile Launcher (Chest)"));
	}
	
	@Override
	public String getUnitDetails()
	{
		return "|| " + "Weapons: " + weapon + " + " + weaponTwo + " || " + "Points: " + points;
	}
}
