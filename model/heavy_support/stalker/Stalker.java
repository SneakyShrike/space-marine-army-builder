package model.heavy_support.stalker;

import model.Unit;
import model.wargear.weapon.WeaponList;

public class Stalker extends Unit 
{
	protected int frontArmour, sideArmour, rearArmour, hitPoints;
	
	public Stalker()
	{
		super();
	     unitName = "Stalker Squad"; 
	     weapon = WeaponList.getTankWeapon("Icarus Stormcannon Array");
		 points = 75 + weapon.getWeaponPoints();
		 ballisticSkill = 4;
		 frontArmour = 14;
		 sideArmour = 14;
		 rearArmour = 14;
		 hitPoints = 4;				
	}
	
	@Override
	public String getCharacteristics()
	{		
		return "Characteristics: " + "BS: " + ballisticSkill  + " Armour:  F: " + frontArmour + "  " + "S: " + sideArmour
				+ "  " + "R: " + rearArmour + "  " + "HP: " + hitPoints;
	}	
}
