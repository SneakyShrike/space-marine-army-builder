package elites.sternguard_veteran;

import gui.model.Unit;
import wargear.weapon.WeaponList;

public class Sternguard_Veteran extends Unit 
{
	public Sternguard_Veteran()
	{
		super();
		unitName = "Sternguard Veteran Squad"; //default name of a scout squad //max number of values in the combo box, NEEDS TO INHERIT FROM SCOUT SQUAD SQUAD MAXSIZE SOMEHOW
        weapon = WeaponList.getRanged("Boltgun");
		points = 22 + weapon.getWeaponPoints();//default weapon of a scout
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
        unitWeaponsList.add(WeaponList.getRanged("Combi-Flamer"));
        unitWeaponsList.add(WeaponList.getRanged("Combi-Grav"));
        unitWeaponsList.add(WeaponList.getRanged("Combi-Melta"));
        unitWeaponsList.add(WeaponList.getRanged("Combi-Plasma"));
        unitWeaponsList.add(WeaponList.getRanged("Storm Bolter"));
        
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
