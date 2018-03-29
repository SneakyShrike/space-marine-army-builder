package elites.ironclad_dreadnought;

import gui.model.Unit;
import wargear.weapon.WeaponList;

public class Ironclad_Dreadnought extends Unit 
{
	protected int frontArmour, sideArmour, rearArmour, hitPoints;
	
	public Ironclad_Dreadnought()
	{
		super();
		unitName = "Ironclad Dreadnought Squad"; 
        weapon = WeaponList.getIronclad_DreadnoughtWeapon("Power Fist With Built-in Storm Bolter");
        weaponTwo = WeaponList.getIronclad_DreadnoughtWeapon("Seismic Hammer With Built-in Meltagun");
		points = 135 + weapon.getWeaponPoints() + weaponTwo.getWeaponPoints();
        weaponSkill = 4;
        ballisticSkill = 4;
        strength = 6;
        frontArmour = 13;
        sideArmour = 13;
        rearArmour = 10;
        initiative = 4;
        attacks = 4;
        hitPoints = 3;
               
        unitWeaponsList.add(WeaponList.getIronclad_DreadnoughtWeapon("Power Fist With Built-in Storm Bolter"));
        unitWeaponsList.add(WeaponList.getIronclad_DreadnoughtWeapon("Power Fist With Built-in Heavy Flamer"));
        unitWeaponsList.add(WeaponList.getCenturionWeapon("Hurricane Bolter"));
        
        unitSecondWeaponsList.add(WeaponList.getIronclad_DreadnoughtWeapon("Seismic Hammer With Built-in Meltagun"));
        unitSecondWeaponsList.add(WeaponList.getIronclad_DreadnoughtWeapon("Seismic Hammer With Built-in Heavy Flamer"));
        unitSecondWeaponsList.add(WeaponList.getIronclad_DreadnoughtWeapon("Chainfist With Built-in Meltagun"));
        unitSecondWeaponsList.add(WeaponList.getIronclad_DreadnoughtWeapon("Chainfist With Built-in Heavy Flamer"));
	}
		
	@Override
	public String getUnitDetails()
	{
		return "|| " + "Weapons: " + weapon + " + " + weaponTwo + " || " + "Points: " + points;
	}
	

}
