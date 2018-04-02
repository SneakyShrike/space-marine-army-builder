package fast_attack.razorback;

import gui.model.Unit;
import wargear.weapon.WeaponList;

public class Razorback extends Unit 
{
	protected int frontArmour, sideArmour, rearArmour, hitPoints;
	
	public Razorback()
	{
		super();
		unitName = "Razorback"; 
        weapon = WeaponList.getRazorbackWeapon("Twin-Linked Heavy Bolter (Turret)");
		points = 55 + weapon.getWeaponPoints();
        ballisticSkill = 4;
        frontArmour = 11;
        sideArmour = 11;
        rearArmour = 10;
        hitPoints = 3;
        
        unitWeaponsList.add(WeaponList.getRazorbackWeapon("Twin-Linked Heavy Bolter (Turret)"));
        unitWeaponsList.add(WeaponList.getRazorbackWeapon("Twin-Linked Assault Cannon (Turret)"));
        unitWeaponsList.add(WeaponList.getRazorbackWeapon("Twin-Linked Heavy Flamer (Turret)"));
        unitWeaponsList.add(WeaponList.getRazorbackWeapon("Twin-Linked Lascannon (Turret)"));
        unitWeaponsList.add(WeaponList.getRazorbackWeapon("Lascannon And Twin-Linked Plasma Gun (Turret)"));
	}
}
