package model.heavy_support.devastator;

import model.Unit;
import model.wargear.weapon.WeaponList;

public class Devastator extends Unit 
{
	public Devastator()
	{
		unitName = "Devastator Squad"; 
        weapon = WeaponList.getRanged("Boltgun");
		points = 14 + weapon.getWeaponPoints();
        weaponSkill = 4;
        ballisticSkill = 4;
        strength = 4;
        toughness = 4; 
        wounds = 1;
        initiative = 4;
        attacks = 1;
        leadership = 8;
        save = "3+";	
        
        unitWeaponsList.add(WeaponList.getRanged("Boltgun"));
        unitWeaponsList.add(WeaponList.getHeavy("Heavy Bolter"));
        unitWeaponsList.add(WeaponList.getHeavy("Multi-Melta"));
        unitWeaponsList.add(WeaponList.getHeavy("Missile Launcher (Frag)"));
        unitWeaponsList.add(WeaponList.getHeavy("Missile Launcher (Krak)"));
        unitWeaponsList.add(WeaponList.getHeavy("Missile Launcher (Flakk)"));
        unitWeaponsList.add(WeaponList.getHeavy("Plasma Cannon"));
        unitWeaponsList.add(WeaponList.getHeavy("Lascannon"));
        unitWeaponsList.add(WeaponList.getHeavy("Grav-Cannon"));
        unitWeaponsList.add(WeaponList.getHeavy("Grav-Amp"));
	}
}
