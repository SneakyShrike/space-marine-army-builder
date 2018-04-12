package model.heavy_support.vindicator;

import model.Unit;
import model.wargear.weapon.WeaponList;

public class Vindicator extends Unit 
{
	protected int frontArmour, sideArmour, rearArmour, hitPoints;
	
	public Vindicator()
	{
		 super();
		 unitName = "Vindicator Squad"; 
		 weapon = WeaponList.getTankWeapon("Demolisher Cannon");
		 points = 120 + weapon.getWeaponPoints();
		 ballisticSkill = 4;
		 frontArmour = 13;
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
