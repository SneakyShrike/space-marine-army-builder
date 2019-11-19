package model.hq.techmarine;

import model.Unit;
import model.wargear.weapon.WeaponList;

public class Techmarine extends Unit 
{
	public Techmarine()
	{
		super();
		unitName = "Techmarine"; 
        weapon = WeaponList.getRanged("Bolt Pistol");
        weaponTwo = WeaponList.getHQWeapon("Power Axe");
		points = 65 + weapon.getWeaponPoints() + weaponTwo.getWeaponPoints();
        weaponSkill = 4;
        ballisticSkill = 5;
        strength = 4;
        toughness = 4; 
        wounds = 2;
        initiative = 4;
        attacks = 2;
        leadership = 9;
        save = "2+";	
        
        unitWeaponsList.add(WeaponList.getRanged("Bolt Pistol"));
        unitWeaponsList.add(WeaponList.getRanged("Boltgun"));
        unitWeaponsList.add(WeaponList.getRanged("Storm Bolter"));
        unitWeaponsList.add(WeaponList.getRanged("Combi-Flamer"));
        unitWeaponsList.add(WeaponList.getRanged("Combi-Grav"));
        unitWeaponsList.add(WeaponList.getRanged("Combi-Melta"));
        unitWeaponsList.add(WeaponList.getRanged("Combi-Plasma"));
        unitWeaponsList.add(WeaponList.getRanged("Grav Pistol"));
        unitWeaponsList.add(WeaponList.getRanged("Plasma Pistol"));
        
        unitSecondWeaponsList.add(WeaponList.getHQWeapon("Power Axe"));
        unitSecondWeaponsList.add(WeaponList.getMelee("Chainsword"));
        unitSecondWeaponsList.add(WeaponList.getMelee("Lightning Claw"));
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
