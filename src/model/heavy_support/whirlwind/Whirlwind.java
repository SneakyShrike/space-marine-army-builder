package model.heavy_support.whirlwind;

import model.Unit;
import model.wargear.weapon.WeaponList;

public class Whirlwind extends Unit 
{
	protected int frontArmour, sideArmour, rearArmour, hitPoints;
	
	public Whirlwind()
	{
		super();
		unitName = "Whirlwind Squad"; 
		weapon = WeaponList.getTankWeapon("Whirlwind Multiple Missile Launcher");
		points = 65 + weapon.getWeaponPoints();
		ballisticSkill = 4;
		frontArmour = 11;
		sideArmour = 11;
		rearArmour = 10;
		hitPoints = 3;				
	}
	
	@Override
	public String getCharacteristics()
	{		
		return "Characteristics:   BS: " + ballisticSkill  +  "   HP: " + hitPoints +
				"   Armour:   FA: " + frontArmour + "   SA: " + sideArmour + "   RA: " + rearArmour;
	}
}
