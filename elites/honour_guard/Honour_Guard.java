package elites.honour_guard;

import gui.model.Unit;
import wargear.weapon.WeaponList;

public class Honour_Guard extends Unit 
{
	public Honour_Guard()
	{
		super();
		unitName = "Honour Guard Squad"; 
        weapon = WeaponList.getMelee("Power Sword");
        weaponTwo = WeaponList.getRanged("Boltgun");
        weapon.setWeaponPoints(0);
		points = 25 + weapon.getWeaponPoints() + weaponTwo.getWeaponPoints();
        weaponSkill = 4;
        ballisticSkill = 4;
        strength = 4;
        toughness = 4; 
        wounds = 1;
        initiative = 4;
        attacks = 2;
        leadership = 10;
        save = "2+";
        
        unitWeaponsList.add(WeaponList.getMelee("Power Axe"));
        unitWeaponsList.add(WeaponList.getMelee("Power Lance"));
        unitWeaponsList.add(WeaponList.getMelee("Power Maul"));
        unitWeaponsList.add(WeaponList.getMelee("Power Sword"));
        unitWeaponsList.add(WeaponList.getHonour_GuardWeapon("Relic Blade"));
        
        unitWeaponsList.get(0).setWeaponPoints(0);
        unitWeaponsList.get(1).setWeaponPoints(0);
        unitWeaponsList.get(2).setWeaponPoints(0);
        unitWeaponsList.get(3).setWeaponPoints(0);
	}
	
	@Override
	public String getUnitDetails()
	{
		return "|| " + "Weapons: " + weapon + " + " + weaponTwo + " || " + "Points: " + points;
	}
}
