package model.heavy_support.stormraven_gunship;

import model.Unit;
import model.wargear.weapon.WeaponList;

public class Stormraven_Gunship extends Unit 
{
	protected int frontArmour, sideArmour, rearArmour, hitPoints; 
	
	public Stormraven_Gunship()
	{
		super();
		unitName = "Stormraven Gunship"; 
		weapon = WeaponList.getGunshipWeapon("Twin-Linked Assault Cannon (Turret)");
		weaponTwo = WeaponList.getGunshipWeapon("Duel Side Access Points (Sponson)");
		points = 200 + weapon.getWeaponPoints() + weaponTwo.getWeaponPoints();
		ballisticSkill = 4;
		frontArmour = 12;
		sideArmour = 12;
		rearArmour = 12;
		hitPoints = 3;		
		
		unitWeaponsList.add(WeaponList.getGunshipWeapon("Twin-Linked Assault Cannon (Turret)"));
		unitWeaponsList.add(WeaponList.getGunshipWeapon("Twin-Linked Lascannon (Turret)"));
		unitWeaponsList.add(WeaponList.getGunshipWeapon("Twin-Linked Plasma Cannon (Turret)"));
		
		unitSecondWeaponsList.add(WeaponList.getGunshipWeapon("Duel Side Access Points (Sponson)"));
		unitSecondWeaponsList.add(WeaponList.getGunshipWeapon("Hurricane Bolter (Sponson)"));
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
