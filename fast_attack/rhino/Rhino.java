package fast_attack.rhino;

import gui.model.Unit;
import wargear.weapon.WeaponList;

public class Rhino extends Unit 
{
	protected int frontArmour, sideArmour, rearArmour, hitPoints;
	
	public Rhino()
	{
		super();
		unitName = "Rhino"; 
        weapon = WeaponList.getRanged("None");
		points = 55 + weapon.getWeaponPoints();
        ballisticSkill = 4;
        frontArmour = 11;
        sideArmour = 11;
        rearArmour = 10;
        hitPoints = 3;     
	}
}
