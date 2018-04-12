package model.elites.venerable_dreadnought;

import model.Unit;
import model.wargear.weapon.WeaponList;

public class Venerable_Dreadnought extends Unit
{
	protected int frontArmour, sideArmour, rearArmour, hitPoints;
	
	public Venerable_Dreadnought()
	{
		super();
		unitName = "Venerable Dreadnought Squad"; 
        weapon = WeaponList.getDreadnoughtWeapon("Multi-Melta");
        weaponTwo = WeaponList.getDreadnoughtWeapon("Power Fist With Built-In Storm Bolter");
		points = 125 + weapon.getWeaponPoints() + weaponTwo.getWeaponPoints();
        weaponSkill = 5;
        ballisticSkill = 5;
        strength = 6;
        frontArmour = 12;
        sideArmour = 12;
        rearArmour = 10;
        initiative = 4;
        attacks = 4;
        hitPoints = 3;
        
        unitWeaponsList.add(WeaponList.getDreadnoughtWeapon("Multi-Melta"));
        unitWeaponsList.add(WeaponList.getDreadnoughtWeapon("Twin-Linked Autocannon"));
        unitWeaponsList.add(WeaponList.getDreadnoughtWeapon("Twin-Linked Heavy Bolter"));
        unitWeaponsList.add(WeaponList.getDreadnoughtWeapon("Twin-Linked Heavy Flamer"));
        unitWeaponsList.add(WeaponList.getDreadnoughtWeapon("Plasma Cannon"));
        unitWeaponsList.add(WeaponList.getDreadnoughtWeapon("Assault Cannon"));
        unitWeaponsList.add(WeaponList.getDreadnoughtWeapon("Twin-Linked Lascannon"));
        
        unitSecondWeaponsList.add(WeaponList.getDreadnoughtWeapon("Missile Launcher"));
        unitSecondWeaponsList.add(WeaponList.getDreadnoughtWeapon("Power Fist With Built-In Heavy Flamer"));
        unitSecondWeaponsList.add(WeaponList.getDreadnoughtWeapon("Power Fist With Built-In Storm Bolter"));
        unitSecondWeaponsList.add(WeaponList.getDreadnoughtWeapon("Left Arm Twin-Linked Autocannon"));	
	}
	
	@Override
	public String getUnitDetails()
	{
		return "|| " + "Weapons: " + weapon + " + " + weaponTwo + " || " + "Points: " + points;
	}
}
