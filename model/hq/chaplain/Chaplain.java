package model.hq.chaplain;

import model.Unit;
import model.wargear.weapon.WeaponList;

public class Chaplain extends Unit 
{
	public Chaplain()
	{
		super();
		unitName = "Chaplain"; 
        weapon = WeaponList.getRanged("Bolt Pistol");
        weaponTwo = WeaponList.getHQWeapon("Crozius Arcanum");
		points = 90 + weapon.getWeaponPoints() + weaponTwo.getWeaponPoints();
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
        unitWeaponsList.add(WeaponList.getMelee("Power Fist"));
        unitWeaponsList.add(WeaponList.getRanged("Storm Bolter"));
        unitWeaponsList.add(WeaponList.getRanged("Combi-Flamer"));
        unitWeaponsList.add(WeaponList.getRanged("Combi-Grav"));
        unitWeaponsList.add(WeaponList.getRanged("Combi-Melta"));
        unitWeaponsList.add(WeaponList.getRanged("Combi-Plasma"));
        unitWeaponsList.add(WeaponList.getRanged("Grav Pistol"));
        unitWeaponsList.add(WeaponList.getRanged("Plasma Pistol"));
        
        unitSecondWeaponsList.add(WeaponList.getHQWeapon("Crozius Arcanum"));
        unitSecondWeaponsList.add(WeaponList.getRanged("Boltgun"));
        unitSecondWeaponsList.add(WeaponList.getRanged("Storm Bolter"));
        unitSecondWeaponsList.add(WeaponList.getRanged("Combi-Flamer"));
        unitSecondWeaponsList.add(WeaponList.getRanged("Combi-Grav"));
        unitSecondWeaponsList.add(WeaponList.getRanged("Combi-Melta"));
        unitSecondWeaponsList.add(WeaponList.getRanged("Combi-Plasma"));
        unitSecondWeaponsList.add(WeaponList.getRanged("Grav Pistol"));
        unitSecondWeaponsList.add(WeaponList.getRanged("Plasma Pistol"));               
	}
	
	@Override
	public String getUnitDetails()
	{
		return "|| " + "Weapons: " + weapon + " + " + weaponTwo + " || " + "Points: " + points;
	}
}
