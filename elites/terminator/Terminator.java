package elites.terminator;

import gui.model.Unit;
import wargear.weapon.WeaponList;

public class Terminator extends Unit
{
	
	public Terminator() //creates a new array list of scouts with a name
	{
		super();
		unitName = "Terminator Squad"; 
		COMBOMAXSIZE = 9; 
        weapon = WeaponList.getTerminator("Power Fist");
		points = 35 + weapon.getWeaponPoints();
        weaponSkill = 4;
        ballisticSkill = 4;
        strength = 4;
        toughness = 4; 
        wounds = 1;
        initiative = 4;
        attacks = 2;
        leadership = 9;
        save = "2+";
        
        unitWeaponsList.add(WeaponList.getTerminator("Storm Bolter"));
        unitWeaponsList.add(WeaponList.getTerminator("Chainfist"));
        unitWeaponsList.add(WeaponList.getTerminator("Heavy Flamer"));
        unitWeaponsList.add(WeaponList.getTerminator("Assault Cannon"));
        unitWeaponsList.add(WeaponList.getTerminator("Cyclone Missile Launcher"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
