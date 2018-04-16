package model.hq.librarian;

import model.Unit;
import model.wargear.weapon.WeaponList;

public class Librarian extends Unit
{
	public Librarian()
	{
		super();
		unitName = "Librarian"; 
        weapon = WeaponList.getRanged("Bolt Pistol");
        weaponTwo = WeaponList.getHQWeapon("Force Stave");
		points = 65 + weapon.getWeaponPoints() + weaponTwo.getWeaponPoints();
        weaponSkill = 5;
        ballisticSkill = 4;
        strength = 4;
        toughness = 4; 
        wounds = 2;
        initiative = 4;
        attacks = 2;
        leadership = 10;
        save = "3+";
        
        unitWeaponsList.add(WeaponList.getRanged("Bolt Pistol"));
        unitWeaponsList.add(WeaponList.getRanged("Boltgun"));
        unitWeaponsList.add(WeaponList.getRanged("Storm Bolter"));
        unitWeaponsList.add(WeaponList.getRanged("Combi-Flamer"));
        unitWeaponsList.add(WeaponList.getRanged("Combi-Grav"));
        unitWeaponsList.add(WeaponList.getRanged("Combi-Melta"));
        unitWeaponsList.add(WeaponList.getRanged("Combi-Plasma"));
        unitWeaponsList.add(WeaponList.getRanged("Grav Pistol"));
        unitWeaponsList.add(WeaponList.getRanged("Plasma Pistol"));
        
        unitSecondWeaponsList.add(WeaponList.getHQWeapon("Force Stave"));
        unitSecondWeaponsList.add(WeaponList.getHQWeapon("Force Axe"));
        unitSecondWeaponsList.add(WeaponList.getHQWeapon("Force Sword"));
	}
	
	@Override
	public String getUnitDetails()
	{
		return "|| " + "Weapons: " + weapon + " + " + weaponTwo + " || " + "Points: " + points;
	}
}
