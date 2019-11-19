package model.heavy_support.predator;

import model.Unit;
import model.wargear.weapon.WeaponList;

public class Predator extends Unit 
{
	protected int frontArmour, sideArmour, rearArmour, hitPoints;
	
	public Predator()
	{
		super();
	     unitName = "Predator Squad"; 
		 weapon = WeaponList.getTankWeapon("Autocannon (Turret)");
		 weaponTwo = WeaponList.getRanged("None");
		 points = 75 + weapon.getWeaponPoints() + weaponTwo.getWeaponPoints();
		 ballisticSkill = 4;
		 frontArmour = 13;
		 sideArmour = 11;
		 rearArmour = 10;
		 hitPoints = 3;	
		 
		 unitWeaponsList.add(WeaponList.getTankWeapon("Autocannon (Turret)"));
		 unitWeaponsList.add(WeaponList.getTankWeapon("Twin-Linked Lascannon (Turrent)"));
		 
		 unitSecondWeaponsList.add(WeaponList.getRanged("None"));
		 unitSecondWeaponsList.add(WeaponList.getTankWeapon("Heavy Bolter (Sponson)"));
		 unitSecondWeaponsList.add(WeaponList.getTankWeapon("Lascannon (Sponson)"));
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
