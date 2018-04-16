package model.heavy_support.land_raider_crusader;

import model.Unit;
import model.wargear.weapon.WeaponList;

public class Land_Raider_Crusader extends Unit 
{
	protected int frontArmour, sideArmour, rearArmour, hitPoints;
	
	public Land_Raider_Crusader()
	 {		
		super();
		unitName = "Land Raider Crusader"; 
		weapon = WeaponList.getTankWeapon("Twin-Linked Assault Cannon (Front)");
		weaponTwo = WeaponList.getTankWeapon("Duel Hurricane Bolters (Sides)");
		points = 250 + weapon.getWeaponPoints() + weaponTwo.getWeaponPoints();
		ballisticSkill = 4;
		frontArmour = 14;
		sideArmour = 14;
		rearArmour = 14;
		hitPoints = 4;			 
	 }
	 
	 @Override
	public String getUnitDetails()
	{
		return "|| " + "Weapons: " + weapon + " + " + weaponTwo + " || " + "Points: " + points;
	}
	 
	@Override
	public String getCharacteristics()
	{		
		return "Characteristics:   BS: " + ballisticSkill  +  "   HP: " + hitPoints +
				"   Armour:   FA: " + frontArmour + "   SA: " + sideArmour + "   RA: " + rearArmour;
	}		
}
