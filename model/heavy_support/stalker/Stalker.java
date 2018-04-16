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
		frontArmour = 12;
		sideArmour = 12;
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
