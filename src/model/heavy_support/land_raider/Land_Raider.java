package model.heavy_support.land_raider;

import model.Unit;
import model.wargear.weapon.WeaponList;

public class Land_Raider extends Unit  
{
	protected int frontArmour, sideArmour, rearArmour, hitPoints;
	
	 public Land_Raider()
	 {
		 super();
		 unitName = "Land Raider"; 
		 weapon = WeaponList.getTankWeapon("Twin-Linked Heavy Bolter (Front)");
		 weaponTwo = WeaponList.getTankWeapon("Duel Twin-Linked Lascannon (Sides)");
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
