package model.heavy_support.hunter;

import model.Unit;
import model.wargear.weapon.WeaponList;

public class Hunter extends Unit 
{
	protected int frontArmour, sideArmour, rearArmour, hitPoints;
	
	public Hunter()
	{
		super();
		unitName = "Hunter Squad"; 
		weapon = WeaponList.getTankWeapon("Skyspear Missile Launcher");
	    points = 70 + weapon.getWeaponPoints();
        ballisticSkill = 4;
        frontArmour = 12;
        sideArmour = 12;
        rearArmour = 10;
        hitPoints = 3;			
	}
	
	@Override
	public String getCharacteristics()
	{		
		return "Characteristics: " + "BS: " + ballisticSkill  + " Armour:  F: " + frontArmour + "  " + "S: " + sideArmour
				+ "  " + "R: " + rearArmour + "  " + "HP: " + hitPoints;
	}
}
