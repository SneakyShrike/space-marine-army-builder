package model.hq.captain;

import model.Unit;
import model.wargear.weapon.WeaponList;

public class Captain extends Unit
{
	public Captain()
	{
		super();
		unitName = "Captain"; 
        weapon = WeaponList.getRanged("Bolt Pistol");
        weaponTwo = WeaponList.getMelee("Chainsword");
		points = 90 + weapon.getWeaponPoints() + weaponTwo.getWeaponPoints();
        weaponSkill = 6;
        ballisticSkill = 5;
        strength = 4;
        toughness = 4; 
        wounds = 3;
        initiative = 5;
        attacks = 3;
        leadership = 10;
        save = "3+";
        
        unitWeaponsList.add(WeaponList.getRanged("Bolt Pistol"));
        unitWeaponsList.add(WeaponList.getHQWeapon("Storm Shield (Captain)"));
        unitWeaponsList.add(WeaponList.getRanged("Boltgun"));
        unitWeaponsList.add(WeaponList.getRanged("Storm Bolter"));
        unitWeaponsList.add(WeaponList.getRanged("Combi-Flamer"));
        unitWeaponsList.add(WeaponList.getRanged("Combi-Grav"));
        unitWeaponsList.add(WeaponList.getRanged("Combi-Melta"));
        unitWeaponsList.add(WeaponList.getRanged("Combi-Plasma"));
        unitWeaponsList.add(WeaponList.getRanged("Grav Pistol"));
        unitWeaponsList.add(WeaponList.getRanged("Plasma Pistol"));
        
        unitSecondWeaponsList.add(WeaponList.getMelee("Chainsword"));
        unitSecondWeaponsList.add(WeaponList.getHQWeapon("Relic Blade (Captain)"));
        unitSecondWeaponsList.add(WeaponList.getMelee("Lightning Claw"));
        unitSecondWeaponsList.add(WeaponList.getMelee("Power Axe"));
        unitSecondWeaponsList.add(WeaponList.getMelee("Power Maul"));
        unitSecondWeaponsList.add(WeaponList.getMelee("Power Sword"));
        unitSecondWeaponsList.add(WeaponList.getMelee("Power Lance"));
        unitSecondWeaponsList.add(WeaponList.getMelee("Power Fist"));
        unitSecondWeaponsList.add(WeaponList.getMelee("Thunder Hammer"));
	}
	
	@Override
	public String getUnitDetails()
	{
		return "|| " + "Weapons: " + weapon + " + " + weaponTwo + " || " + "Points: " + points;
	}
}
