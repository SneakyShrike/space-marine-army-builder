package model.heavy_support.land_raider_redeemer;

import model.Unit;
import model.wargear.weapon.WeaponList;

public class Land_Raider_Redeemer extends Unit 
{
	protected int frontArmour, sideArmour, rearArmour, hitPoints;
	
	public Land_Raider_Redeemer()
	 {
		 super();
	     unitName = "Land Raider Redeemer"; 
		 weapon = WeaponList.getTankWeapon("Twin-Linked Assault Cannon (Front)");
		 weaponTwo = WeaponList.getTankWeapon("Duel Flamestorm Cannons (Sides)");
		 points = 240 + weapon.getWeaponPoints() + weaponTwo.getWeaponPoints();
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
		return "Characteristics: " + "BS: " + ballisticSkill  + " Armour:  F: " + frontArmour + "  " + "S: " + sideArmour
				+ "  " + "R: " + rearArmour + "  " + "HP: " + hitPoints;
	}	
}
