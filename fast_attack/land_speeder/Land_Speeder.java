package fast_attack.land_speeder;

import gui.model.Unit;
import wargear.weapon.WeaponList;

public class Land_Speeder extends Unit 
{
	protected int frontArmour, sideArmour, rearArmour, hitPoints;
	
	public Land_Speeder()
	{
		super();
		unitName = "Land Speeder Squad"; 
		weapon = WeaponList.getRanged("None");
	    weaponTwo = WeaponList.getLand_SpeederWeapon("Heavy Bolter (Rail)");
	    points = 45 + weapon.getWeaponPoints() + weaponTwo.getWeaponPoints();
        ballisticSkill = 4;
        frontArmour = 12;
        sideArmour = 12;
        rearArmour = 12;
        hitPoints = 3;	
          
        unitWeaponsList.add(WeaponList.getRanged("None"));
        unitWeaponsList.add(WeaponList.getLand_SpeederWeapon("Assault Cannon (Hull)"));
        unitWeaponsList.add(WeaponList.getLand_SpeederWeapon("Heavy Bolter (Hull)"));
        unitWeaponsList.add(WeaponList.getLand_SpeederWeapon("Heavy Flamer (Hull)"));
        unitWeaponsList.add(WeaponList.getLand_SpeederWeapon("Multi-Melta (Hull)"));
        unitWeaponsList.add(WeaponList.getLand_SpeederWeapon("Typhoon Missile Launcher (Hull)"));
               
        unitSecondWeaponsList.add(WeaponList.getLand_SpeederWeapon("Heavy Bolter (Rail)"));
        unitSecondWeaponsList.add(WeaponList.getLand_SpeederWeapon("Heavy Flamer (Rail)"));
        unitSecondWeaponsList.add(WeaponList.getLand_SpeederWeapon("Multi-Melta (Rail)"));                      
	}
	
	@Override
	public String getUnitDetails()
	{
		return "|| " + "Weapons: " + weapon + " + " + weaponTwo + " || " + "Points: " + points;
	}
}
