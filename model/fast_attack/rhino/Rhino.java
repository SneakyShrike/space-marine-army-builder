package model.fast_attack.rhino;

import model.Unit;
import model.wargear.weapon.WeaponList;

public class Rhino extends Unit 
{
	protected int frontArmour, sideArmour, rearArmour, hitPoints;
	
	public Rhino()
	{
		super();
		unitName = "Rhino"; 
        weapon = WeaponList.getRanged("None");
		points = 35 + weapon.getWeaponPoints();
        ballisticSkill = 4;
        frontArmour = 11;
        sideArmour = 11;
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
