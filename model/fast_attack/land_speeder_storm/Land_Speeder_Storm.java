package model.fast_attack.land_speeder_storm;

import model.Unit;
import model.wargear.weapon.WeaponList;

public class Land_Speeder_Storm extends Unit 
{
	protected int frontArmour, sideArmour, rearArmour, hitPoints;
	
	public Land_Speeder_Storm()
	{
		super();
		unitName = "Land Speeder Storm"; 
		weapon = WeaponList.getLand_SpeederWeapon("Cerberus Launcher (Hull)");
	    weaponTwo = WeaponList.getLand_SpeederWeapon("Heavy Bolter (Rail)");
	    points = 40 + weapon.getWeaponPoints() + weaponTwo.getWeaponPoints();
        ballisticSkill = 4;
        frontArmour = 10;
        sideArmour = 10;
        rearArmour = 10;
        hitPoints = 2;	
         
        unitWeaponsList.add(WeaponList.getLand_SpeederWeapon("Cerberus Launcher (Hull)"));
        
        unitSecondWeaponsList.add(WeaponList.getLand_SpeederWeapon("Assault Cannon (Rail)"));
        unitSecondWeaponsList.add(WeaponList.getLand_SpeederWeapon("Heavy Bolter (Rail)"));
        unitSecondWeaponsList.add(WeaponList.getLand_SpeederWeapon("Heavy Flamer (Rail)"));
        unitSecondWeaponsList.add(WeaponList.getLand_SpeederWeapon("Multi-Melta (Rail)"));               
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

