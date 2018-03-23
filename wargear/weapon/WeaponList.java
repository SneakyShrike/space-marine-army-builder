package wargear.weapon;

import java.util.HashMap;

import java.util.Map;

public class WeaponList
{
	static Map<String, Ranged> rangedWeapons = new HashMap<String, Ranged>()
	{{			
		put("Boltgun", new Ranged("Boltgun", 0));
		put("Storm Bolter", new Ranged("Storm Bolter", 5));
		put("Combi-Flamer", new Ranged("Combi-Flamer", 10));
		put("Combi-Grav", new Ranged("Combi-Grav", 10));
		put("Combi-Melta", new Ranged("Combi-Melta", 10));
		put("Combi-Plasma", new Ranged("Combi-Plasma", 10));
		put("Grav Pistol", new Ranged("Grav Pistol", 15));
		put("Plasma Pistol", new Ranged("Plasma Pistol", 15));		
	}};
	
	static Map<String, Melee> meleeWeapons = new HashMap<String, Melee>()
	{{			
		put("Chainsword", new Melee("Chainsword", 0));
		put("Lightning Claw", new Melee("Lightning Claw", 15));
		put("Power Axe", new Melee("Power Axe", 15));
		put("Power Maul", new Melee("Power Maul", 15));
		put("Power Sword", new Melee("Power Sword", 15));
		put("Power Fist", new Melee("Power Fist", 25));
		put("Thunder Hammer", new Melee("Thunder Hammer", 30));
	}};
			
	static Map<String, Heavy> heavyWeapons = new HashMap<String, Heavy>()
	{{
		put("Heavy Bolter", new Heavy("Heavy Bolter", 10));
		put("Heavy Flamer", new Heavy("Heavy Flamer", 10));
		put("Multi-Melta", new Heavy("Multi-Melta", 10));
		put("Missile Launcher (Frag)", new Heavy("Missile Launcher (Frag)", 15));
		put("Missile Launcher (Krak)", new Heavy("Missile Launcher (Krak)", 15));
		put("Missile Launcher (Flakk)", new Heavy("Missile Launcher (Flakk)", 10));
		put("Plasma Cannon", new Heavy("Plasma Cannon", 15));
		put("Lascannon", new Heavy("Lascannon", 20));
		put("Grav-Cannon", new Heavy("Grav-Cannon", 35));
		put("Grav-Amp", new Heavy("Grav-Amp", 35));		
	}};
	
	static Map<String, Special> specialWeapons = new HashMap<String, Special>()
	{{
		put("Flamer", new Special("Flamer", 5));
		put("Meltagun", new Special("Meltagun", 10));
		put("Grav-Gun", new Special("Grav-Gun", 15));
		put("Plasma Gun", new Special("Plasma Gun", 15));	
		put("None", new Special("None", 0));
	}};
	
	static Map<String, CenturionWeapon> centurionWeapons = new HashMap<String, CenturionWeapon>()
	{{			
		put("Ironclad Assault Launcher", new CenturionWeapon("Ironclad Assault Launcher", 0));
		put("Hurricane Bolter", new CenturionWeapon("Hurricane Bolter", 0));
		put("Twin-Linked Flamer", new CenturionWeapon("Twin-Linked Flamer", 0));
		put("Twin-Linked Meltagun", new CenturionWeapon("Twin-Linked Meltagun", 5)); 
	}};
	
	static Map<String, DreadnoughtWeapon> dreadnoughtWeapons = new HashMap<String, DreadnoughtWeapon>()
	{{	
		put("Multi-Melta", new DreadnoughtWeapon("Multi-Melta", 0));
		put("Twin-Linked Autocannon", new DreadnoughtWeapon("Twin-Linked Autocannon", 5));
		put("Twin-Linked Heavy Bolter", new DreadnoughtWeapon("Twin-Linked Heavy Bolter", 5));
		put("Twin-Linked Heavy Flamer", new DreadnoughtWeapon("Twin-Linked Heavy Flamer", 5));
		put("Plasma Cannon", new DreadnoughtWeapon("Plasma Cannon", 5));
		put("Assault Cannon", new DreadnoughtWeapon("Assault Cannon", 10));
		put("Twin-Linked Lascannon", new DreadnoughtWeapon("Twin-Linked Lascannon", 15));
		
		put("Power Fist With Built-In Storm Bolter", new DreadnoughtWeapon("Power Fist With Built-In Storm Bolter", 0));
		put("Power Fist With Built-In Heavy Flamer", new DreadnoughtWeapon("Power Fist With Built-In Heavy Flamer", 10));
		put("Missile Launcher", new DreadnoughtWeapon("Missile Launcher", 10));
		put("Left Arm Twin-Linked Autocannon", new DreadnoughtWeapon("Left Arm Twin-Linked Autocannon", 15));
	}};
	
	static Map<String, TerminatorWeapon> terminatorWeapons = new HashMap<String, TerminatorWeapon>()
	{{	
		put("Storm Bolter", new TerminatorWeapon("Storm Bolter", 0));
		put("Power Fist", new TerminatorWeapon("Power Fist", 0));
		put("Chainfist", new TerminatorWeapon("Chainfist", 5));
		put("Assault Cannon", new TerminatorWeapon("Assault Cannon", 20));
		put("Cyclone Missile Launcher", new TerminatorWeapon("Cyclone Missile Launcher", 25));
		put("Heavy Flamer", new TerminatorWeapon("Heavy Flamer", 10));
		
		put("Duel Lightning Claws", new TerminatorWeapon("Duel Lightning Claws", 0));
		put("Thunder Hammer and Storm Shield", new TerminatorWeapon("Thunder Hammer and Storm Shield", 10));
	}};
		
	static Map<String, ScoutWeapon> scoutWeapons = new HashMap<String, ScoutWeapon>()
	{{			
		put("Shotgun", new ScoutWeapon("Shotgun", 0));
		put("Close Combat Weapon", new ScoutWeapon("Close Combat Weapon", 0));
		put("Sniper Rifle", new ScoutWeapon("Sniper Rifle", 1));
		put("Heavy Bolter (Hellfire Shell)", new ScoutWeapon("Heavy Bolter (Hellfire Shell)", 8 + 5)); //THIS NEEDS REVIEWING	
	}};
	
		
	public static Ranged getRanged(String key)
	{		
        return rangedWeapons.get(key);   
	}
	
	public static Melee getMelee(String key)
	{		
        return meleeWeapons.get(key);   
	}
		
	public static Heavy getHeavy(String key)
	{		
        return heavyWeapons.get(key);   
	}
	
	public static Special getSpecial(String key)
	{		
        return specialWeapons.get(key);   
	}
	
	public static CenturionWeapon getCenturionWeapon(String key)
	{		
        return centurionWeapons.get(key);   
	}
	
	public static DreadnoughtWeapon getDreadnoughtWeapon(String key)
	{		
        return dreadnoughtWeapons.get(key);   
	}
	
	public static TerminatorWeapon getTerminator(String key)
	{		
        return terminatorWeapons.get(key);   
	}
	
	public static ScoutWeapon getScoutWeapon(String key)
	{		
        return scoutWeapons.get(key);   
	}
		
	public static Map<String, Ranged> getRangedList()
	{			
		return rangedWeapons;
	}
}
