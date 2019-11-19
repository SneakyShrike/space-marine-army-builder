package model.heavy_support.thunderfire_cannon;

import model.Unit;
import model.wargear.weapon.WeaponList;

public class Thunderfire_Cannon extends Unit 
{
	public Thunderfire_Cannon()
	{
		super();
		unitName = "Thunderfire Cannon Squad"; 
        weapon = WeaponList.getTankWeapon("Thunderfire Cannon");
		points = 100 + weapon.getWeaponPoints();
        weaponSkill = 0;
        ballisticSkill = 0;
        strength = 0;
        toughness = 7; 
        wounds = 2;
        initiative = 0;
        attacks = 0;
        leadership = 0;
        save = "3+";
	}
}
