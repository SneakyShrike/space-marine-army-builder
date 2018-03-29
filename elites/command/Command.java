package elites.command;

import gui.model.Unit;
import wargear.weapon.WeaponList;

public class Command extends Unit 
{
	public Command()
	{
		super();
		unitName = "Command Squad"; 
        weapon = WeaponList.getMelee("Chainsword");
		points = 18 + weapon.getWeaponPoints();
        weaponSkill = 4;
        ballisticSkill = 4;
        strength = 4;
        toughness = 4; 
        wounds = 1;
        initiative = 4;
        attacks = 2;
        leadership = 9;
        save = "3+";
        
        unitWeaponsList.add(WeaponList.getRanged("Boltgun"));
        unitWeaponsList.add(WeaponList.getRanged("Storm Bolter"));
        unitWeaponsList.add(WeaponList.getRanged("Combi-Flamer"));
        unitWeaponsList.add(WeaponList.getRanged("Combi-Grav"));
        unitWeaponsList.add(WeaponList.getRanged("Combi-Melta"));
        unitWeaponsList.add(WeaponList.getRanged("Combi-Plasma"));
        unitWeaponsList.add(WeaponList.getRanged("Grav Pistol"));
        unitWeaponsList.add(WeaponList.getRanged("Plasma Pistol"));
        unitWeaponsList.add(WeaponList.getSpecial("Flamer"));
        unitWeaponsList.add(WeaponList.getSpecial("Meltagun"));
        unitWeaponsList.add(WeaponList.getSpecial("Grav-Gun"));
        unitWeaponsList.add(WeaponList.getSpecial("Plasma Gun"));
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
