package model.elites.centurion_assault;

import model.Unit;
import model.wargear.weapon.WeaponList;

public class Centurion_Assault extends Unit 
{
	public Centurion_Assault() 
	{   
		super();
		unitName = "Centurion Assault Squad"; 
        weapon = WeaponList.getCenturionWeapon("Twin-Linked Flamer");
        weaponTwo = WeaponList.getCenturionWeapon("Ironclad Assault Launcher");
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
   
        unitWeaponsList.add(WeaponList.getCenturionWeapon("Twin-Linked Flamer"));
        unitWeaponsList.add(WeaponList.getCenturionWeapon("Twin-Linked Meltagun"));
        
        unitSecondWeaponsList.add(WeaponList.getCenturionWeapon("Ironclad Assault Launcher"));
        unitSecondWeaponsList.add(WeaponList.getCenturionWeapon("Hurricane Bolter"));
	}
	
	@Override
	public String getUnitDetails()
	{
		return "|| " + "Weapons: " + weapon + " + " + weaponTwo + " || " + "Points: " + points;
	}
}
