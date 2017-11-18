package troops.scout;

import java.util.HashMap;
import java.util.Map;

import wargear.weapon.Weapon;
import wargear.weapon.WeaponList;

public class ScoutWeaponList
{
	static Map<String, Weapon> scoutWeapons = new HashMap<String, Weapon>()
	{{			
		put("Shotgun", new ScoutWeapon("Shotgun", 0));
		put("Close Combat Weapon", new ScoutWeapon("Close Combat Weapon", 0));
		put("Sniper Rifle", new ScoutWeapon("Sniper Rifle", 1));
		put("Heavy Bolter (Hellfire Shell)", new ScoutWeapon("Heavy Bolter (Hellfire Shell)", 8 + 5));
		put("Sniper Rifle", new ScoutWeapon("Sniper Rifle", 1));		
	}};
	
	//WeaponList.getHeavy("Heavy Bolter").setWeaponPoints(8);
	
	public static Weapon getscoutWeapons(String index)
	{		
        return scoutWeapons.get(index);   
	}
}
