package model.fast_attack.stormtalon_gunship;

import model.Unit;
import model.wargear.weapon.WeaponList;

public class Stormtalon_Gunship extends Unit 
{
	protected int frontArmour, sideArmour, rearArmour, hitPoints;
	
	public Stormtalon_Gunship()
	{
		super();
		unitName = "Stormtalon Gunship"; 
		weapon = WeaponList.getGunshipWeapon("Twin-Linked Assault Cannon (Primary)");
	    weaponTwo = WeaponList.getGunshipWeapon("Twin-Linked Heavy Bolter (Side Hull)");
	    points = 110 + weapon.getWeaponPoints() + weaponTwo.getWeaponPoints();
        ballisticSkill = 4;
        frontArmour = 11;
        sideArmour = 11;
        rearArmour = 11;
        hitPoints = 2;	
        
        unitWeaponsList.add(WeaponList.getGunshipWeapon("Twin-Linked Assault Cannon (Primary)"));
        
        unitSecondWeaponsList.add(WeaponList.getGunshipWeapon("Twin-Linked Heavy Bolter (Side Hull)"));
        unitSecondWeaponsList.add(WeaponList.getGunshipWeapon("Skyhammer Missile Launcher (Side Hull)"));
        unitSecondWeaponsList.add(WeaponList.getGunshipWeapon("Twin-Linked Lascannon (Side Hull)"));
        unitSecondWeaponsList.add(WeaponList.getGunshipWeapon("Typhoon Missile Launcher (Side Hull)"));
	}
	
	@Override
	public String getUnitDetails()
	{
		return "|| " + "Weapons: " + weapon + " + " + weaponTwo + " || " + "Points: " + points;
	}
	
	@Override
	public String getCharacteristics()
	{		
		return "Characteristics: " + "BS: " + ballisticSkill  + " Armour:  F: " + frontArmour + "  " + "S: " + sideArmour
				+ "  " + "R: " + rearArmour + "  " + "HP: " + hitPoints;
	}
}
