package elites.terminator;

import gui.model.Unit;
import wargear.weapon.WeaponList;

public class Terminator extends Unit
{
	
	public Terminator() //creates a new array list of scouts with a name
	{
		super();
		unitName = "Terminator Squad"; 
        weapon = WeaponList.getTerminator("Power Fist");
        weaponTwo = WeaponList.getTerminator("Storm Bolter"); //this needs to be removed when an assault cannon is selected
		points = 35 + weapon.getWeaponPoints() + weaponTwo.getWeaponPoints();
        weaponSkill = 4;
        ballisticSkill = 4;
        strength = 4;
        toughness = 4; 
        wounds = 1;
        initiative = 4;
        attacks = 2;
        leadership = 9;
        save = "2+";
        
        unitWeaponsList.add(WeaponList.getTerminator("Power Fist"));
        unitWeaponsList.add(WeaponList.getTerminator("Chainfist"));
                
        unitSecondWeaponsList.add(WeaponList.getTerminator("Storm Bolter"));
        unitSecondWeaponsList.add(WeaponList.getTerminator("Heavy Flamer"));
        unitSecondWeaponsList.add(WeaponList.getTerminator("Assault Cannon"));
        unitSecondWeaponsList.add(WeaponList.getTerminator("Cyclone Missile Launcher"));
	}
	
	@Override
	public String getUnitDetails()
	{
		return "|| " + "Weapons: " + weapon + " + " + weaponTwo + " || " + "Points: " + points;
	}	
}
