package model.elites.vanguard_veteran;

import model.Unit;
import model.wargear.weapon.WeaponList;

public class Vanguard_Veteran extends Unit 
{
	public Vanguard_Veteran()
	{
		super();
		unitName = "Vanguard Veteran Squad"; 
        weapon = WeaponList.getRanged("Bolt Pistol");
        weaponTwo = WeaponList.getMelee("Chainsword");
		points = 19 + weapon.getWeaponPoints() + weaponTwo.getWeaponPoints();
        weaponSkill = 4;
        ballisticSkill = 4;
        strength = 4;
        toughness = 4; 
        wounds = 1;
        initiative = 4;
        attacks = 2;
        leadership = 9;
        save = "3+";
        
        unitWeaponsList.add(WeaponList.getRanged("Bolt Pistol"));
        unitWeaponsList.add(WeaponList.getRanged("Grav Pistol"));
        unitWeaponsList.add(WeaponList.getRanged("Plasma Pistol"));
        unitWeaponsList.add(WeaponList.getMelee("Storm Shield"));
        
        unitSecondWeaponsList.add(WeaponList.getMelee("Chainsword"));
        unitSecondWeaponsList.add(WeaponList.getMelee("Lightning Claw (Vanguard)"));
        unitSecondWeaponsList.add(WeaponList.getMelee("Power Axe (Vanguard)"));
        unitSecondWeaponsList.add(WeaponList.getMelee("Power Maul (Vanguard)"));
        unitSecondWeaponsList.add(WeaponList.getMelee("Power Sword (Vanguard)"));
        unitSecondWeaponsList.add(WeaponList.getMelee("Power Lance (Vanguard)"));
        unitSecondWeaponsList.add(WeaponList.getMelee("Power Fist (Vanguard)"));
        unitSecondWeaponsList.add(WeaponList.getMelee("Thunder Hammer (Vanguard)"));       
	}
	
	@Override
	public String getUnitDetails()
	{
		return "|| " + "Weapons: " + weapon + " + " + weaponTwo + " || " + "Points: " + points;
	}
}
