package model.fast_attack.assault;

import model.Unit;
import model.wargear.weapon.WeaponList;

public class Assault extends Unit
{
	public Assault()
	{
		super();
		unitName = "Assault Squad"; 
		weapon = WeaponList.getRanged("Bolt Pistol");
        weaponTwo = WeaponList.getMelee("Chainsword");
		points = 14 + weapon.getWeaponPoints() + weaponTwo.getWeaponPoints();
        weaponSkill = 4;
        ballisticSkill = 4;
        strength = 4;
        toughness = 4; 
        wounds = 1;
        initiative = 4;
        attacks = 1;
        leadership = 8;
        save = "3+";
   
        unitWeaponsList.add(WeaponList.getRanged("Bolt Pistol"));	
        unitWeaponsList.add(WeaponList.getRanged("Plasma Pistol"));	
        unitWeaponsList.add(WeaponList.getSpecial("Flamer"));	
               
        unitSecondWeaponsList.add(WeaponList.getMelee("Chainsword"));	
        unitSecondWeaponsList.add(WeaponList.getMelee("Eviscerator"));	
	}
	
	@Override
	public String getUnitDetails()
	{
		return "|| " + "Weapons: " + weapon + " + " + weaponTwo + " || " + "Points: " + points;
	}
}
