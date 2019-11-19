package model.wargear.weapon;

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
		put("Bolt Pistol", new Ranged("Bolt Pistol", 0));	
		put("None", new Ranged("None", 0));
	}};
	
	static Map<String, Melee> meleeWeapons = new HashMap<String, Melee>()
	{{			
		put("Chainsword", new Melee("Chainsword", 0));
		put("Lightning Claw", new Melee("Lightning Claw", 15));
		put("Power Axe", new Melee("Power Axe", 15));
		put("Power Maul", new Melee("Power Maul", 15));
		put("Power Sword", new Melee("Power Sword", 15));
		put("Power Lance", new Melee("Power Lance", 15));
		put("Power Fist", new Melee("Power Fist", 25));
		put("Thunder Hammer", new Melee("Thunder Hammer", 30));
		put("Storm Shield", new Melee("Storm Shield", 10));
		put("Eviscerator", new Melee("Eviscerator", 25));
		
		put("Power Fist (Vanguard)", new Melee("Power Fist (Vanguard)", 15));
		put("Lightning Claw (Vanguard)", new Melee("Lightning Claw (Vanguard)", 5));
		put("Power Axe (Vanguard)", new Melee("Power Axe (Vanguard)", 5));
		put("Power Maul (Vanguard)", new Melee("Power Maul (Vanguard)", 5));
		put("Power Sword (Vanguard)", new Melee("Power Sword (Vanguard)", 5));
		put("Power Lance (Vanguard)", new Melee("Power Lance (Vanguard)", 5));
		put("Thunder Hammer (Vanguard)", new Melee("Thunder Hammer (Vanguard)", 20));
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
	}};
	
	static Map<String, CenturionWeapon> centurionWeapons = new HashMap<String, CenturionWeapon>()
	{{			
		put("Ironclad Assault Launcher", new CenturionWeapon("Ironclad Assault Launcher", 0));
		put("Hurricane Bolter", new CenturionWeapon("Hurricane Bolter", 0));
		put("Twin-Linked Flamer", new CenturionWeapon("Twin-Linked Flamer", 0));
		put("Twin-Linked Meltagun", new CenturionWeapon("Twin-Linked Meltagun", 5)); 
		
		put("Grav-Cannon (Arm)", new CenturionWeapon("Grav-Cannon (Arm)", 25)); 
		put("Grav-Amp (Arm)", new CenturionWeapon("Grav-Amp (Arm)", 25)); 
		put("Twin-Linked Heavy Bolter (Arm)", new CenturionWeapon("Twin-Linked Heavy Bolter (Arm)", 0)); 
		put("Twin-Linked Lascannon (Arm)", new CenturionWeapon("Twin-Linked Lascannon (Arm)", 15)); 
		
		put("Hurricane Bolter (Chest)", new CenturionWeapon("Hurricane Bolter (Chest)", 0)); 
		put("Missile Launcher (Chest)", new CenturionWeapon("Missile Launcher (Chest)", 10)); 
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
	
	static Map<String, Honour_GuardWeapon> honourGuardWeapons = new HashMap<String, Honour_GuardWeapon>()
	{{		
		put("Relic Blade", new Honour_GuardWeapon("Relic Blade", 10));
	}};
	
	static Map<String, Ironclad_DreadnoughtWeapon> ironcladDreadnoughtdWeapons = new HashMap<String, Ironclad_DreadnoughtWeapon>()
	{{		
		put("Power Fist With Built-in Storm Bolter", new Ironclad_DreadnoughtWeapon("Power Fist With Built-in Storm Bolter", 0));
		put("Power Fist With Built-in Heavy Flamer", new Ironclad_DreadnoughtWeapon("Power Fist With Built-in Heavy Flamer", 10));
		
		put("Seismic Hammer With Built-in Meltagun", new Ironclad_DreadnoughtWeapon("Seismic Hammer With Built-in Meltagun", 0));
		put("Seismic Hammer With Built-in Heavy Flamer", new Ironclad_DreadnoughtWeapon("Seismic Hammer With Built-in Heavy Flamer", 0));
		put("Chainfist With Built-in Meltagun", new Ironclad_DreadnoughtWeapon("Chainfist With Built-in Meltagun", 0));
		put("Chainfist With Built-in Heavy Flamer", new Ironclad_DreadnoughtWeapon("Chainfist With Built-in Heavy Flamer", 0));
	}};
	
	static Map<String, BikeWeapon> bikeWeapons = new HashMap<String, BikeWeapon>()
	{{	
		put("Twin-Linked Bolter (Integrated)", new BikeWeapon("Twin-Linked Bolter (Integrated)", 0));
		put("Grenade Launcher (Integrated)", new BikeWeapon("Grenade Launcher (Integrated)", 5));
		
		put("Heavy Bolter (Mounted)", new BikeWeapon("Heavy Bolter (Mounted)", 0));
		put("Multi-Melta (Mounted)", new BikeWeapon("Multi-Melta (Mounted)", 10));		
	}};
	
	static Map<String, Drop_PodWeapon> dropPodWeapons = new HashMap<String, Drop_PodWeapon>()
	{{		
		put("Deathwind Launcher", new Drop_PodWeapon("Deathwind Launcher", 15));
	}};
		
	static Map<String, Land_SpeederWeapon> landSpeederWeapons = new HashMap<String, Land_SpeederWeapon>()
	{{	
		put("Assault Cannon (Hull)", new Land_SpeederWeapon("Assault Cannon (Hull)", 20));
		put("Heavy Bolter (Hull)", new Land_SpeederWeapon("Heavy Bolter (Hull)", 5));
		put("Heavy Flamer (Hull)", new Land_SpeederWeapon("Heavy Flamer (Hull)", 5));
		put("Multi-Melta (Hull)", new Land_SpeederWeapon("Multi-Melta (Hull)", 15));		
		put("Typhoon Missile Launcher (Hull)", new Land_SpeederWeapon("Typhoon Missile Launcher (Hull)", 25));
		put("Cerberus Launcher (Hull)", new Land_SpeederWeapon("Cerberus Launcher (Hull)", 0));
		
		put("Assault Cannon (Rail)", new Land_SpeederWeapon("Assault Cannon (Rail)", 15));
		put("Heavy Bolter (Rail)", new Land_SpeederWeapon("Heavy Bolter (Rail)", 0));
		put("Heavy Flamer (Rail)", new Land_SpeederWeapon("Heavy Flamer (Rail)", 0));
		put("Multi-Melta (Rail)", new Land_SpeederWeapon("Multi-Melta (Rail)", 10));
	}};
	
	static Map<String, RazorbackWeapon> razorbackWeapons = new HashMap<String, RazorbackWeapon>()
	{{	
		put("Lascannon And Twin-Linked Plasma Gun (Turret)", new RazorbackWeapon("Lascannon And Twin-Linked Plasma Gun (Turret)", 20));
		put("Twin-Linked Assault Cannon (Turret)", new RazorbackWeapon("Twin-Linked Assault Cannon (Turret)", 20));
		put("Twin-Linked Heavy Bolter (Turret)", new RazorbackWeapon("Twin-Linked Heavy Bolter (Turret)", 0));
		put("Twin-Linked Heavy Flamer (Turret)", new RazorbackWeapon("Twin-Linked Heavy Flamer (Turret)", 0));
		put("Twin-Linked Lascannon (Turret)", new RazorbackWeapon("Twin-Linked Lascannon (Turret)", 20));
	}};
	
	static Map<String, GunshipWeapon> gunshipWeapons = new HashMap<String, GunshipWeapon>()
	{{	
		put("Icarus Stormcannon (Primary)", new GunshipWeapon("Icarus Stormcannon (Primary)", 0));
		put("Las-Talon (Primary)", new GunshipWeapon("Las-Talon (Primary)", 0));
		put("Twin-Linked Assault Cannon (Primary)", new GunshipWeapon("Twin-Linked Assault Cannon (Primary)", 0));
		
		put("Skyhammer Missile Launcher (Side Hull)", new GunshipWeapon("Skyhammer Missile Launcher (Side Hull)", 5));
		put("Twin-Linked Heavy Bolter (Side Hull)", new GunshipWeapon("Twin-Linked Heavy Bolter (Side Hull)", 0));
		put("Typhoon Missile Launcher (Side Hull)", new GunshipWeapon("Typhoon Missile Launcher (Side Hull)", 20));
		put("Twin-Linked Lascannon (Side Hull)", new GunshipWeapon("Twin-Linked Lascannon (Side Hull)", 15));
		
		put("Hurricane Bolter (Sponson)", new GunshipWeapon("Hurricane Bolter (Sponson)", 30));
		put("Duel Side Access Points (Sponson)", new GunshipWeapon("Duel Side Access Points (Sponson)", 0));
		
		put("Twin-Linked Assault Cannon (Turret)", new GunshipWeapon("Twin-Linked Assault Cannon (Turret)", 0));
		put("Twin-Linked Lascannon (Turret)", new GunshipWeapon("Twin-Linked Lascannon (Turret)", 0));
		put("Twin-Linked Plasma Cannon (Turret)", new GunshipWeapon("Twin-Linked Plasma Cannon (Turret)", 0));	
	}};
	
	static Map<String, TankWeapon> tankWeapons = new HashMap<String, TankWeapon>()
	{{	
		put("Skyspear Missile Launcher", new TankWeapon("Skyspear Missile Launcher", 0));
		put("Twin-Linked Heavy Bolter (Front)", new TankWeapon("Twin-Linked Heavy Bolter (Front)", 0));
		put("Duel Twin-Linked Lascannon (Sides)", new TankWeapon("Duel Twin-Linked Lascannon (Sides)", 0));
		put("Twin-Linked Assault Cannon (Front)", new TankWeapon("Twin-Linked Assault Cannon (Front)", 0));
		put("Duel Hurricane Bolters (Sides)", new TankWeapon("Duel Hurricane Bolters (Sides)", 0));
		put("Duel Flamestorm Cannons (Sides)", new TankWeapon("Duel Flamestorm Cannons (Sides)", 0));
		
		put("Autocannon (Turret)", new TankWeapon("Autocannon (Turret)", 0));	
		put("Twin-Linked Lascannon (Turrent)", new TankWeapon("Twin-Linked Lascannon (Turrent)", 25));		
		put("Heavy Bolter (Sponson)", new TankWeapon("Heavy Bolter (Sponson)", 20));
		put("Lascannon (Sponson)", new TankWeapon("Lascannon (Sponson)", 40));
		
		put("Icarus Stormcannon Array", new TankWeapon("Icarus Stormcannon Array", 0));
		
		put("Thunderfire Cannon", new TankWeapon("Thunderfire Cannon", 0));
		put("Demolisher Cannon", new TankWeapon("Demolisher Cannon", 0));
		put("Whirlwind Multiple Missile Launcher", new TankWeapon("Whirlwind Multiple Missile Launcher", 0));
	}};
	
	static Map<String, HQWeapon> hqWeapons = new HashMap<String, HQWeapon>()
	{{			
		put("Relic Blade (Captain)", new HQWeapon("Relic Blade (Captain)", 25));
		put("Storm Shield (Captain)", new HQWeapon("Storm Shield (Captain)", 15));
		put("Crozius Arcanum", new HQWeapon("Crozius Arcanum", 0));
		put("Force Axe", new HQWeapon("Force Axe", 0));
		put("Force Stave", new HQWeapon("Force Stave", 0));
		put("Force Sword", new HQWeapon("Force Sword", 0));
		put("Power Axe", new HQWeapon("Power Axe", 0));
	}};
				
	static Map<String, ScoutWeapon> scoutWeapons = new HashMap<String, ScoutWeapon>()
	{{			
		put("Shotgun", new ScoutWeapon("Shotgun", 0));
		put("Close Combat Weapon", new ScoutWeapon("Close Combat Weapon", 0));
		put("Sniper Rifle", new ScoutWeapon("Sniper Rifle", 1));
		put("Heavy Bolter (Hellfire Shell)", new ScoutWeapon("Heavy Bolter (Hellfire Shell)", 8 + 5));
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
	
	public static Honour_GuardWeapon getHonour_GuardWeapon(String key)
	{		
        return honourGuardWeapons.get(key);   
	}
	
	public static Ironclad_DreadnoughtWeapon getIronclad_DreadnoughtWeapon(String key)
	{		
        return ironcladDreadnoughtdWeapons.get(key);   
	}
	
	public static TerminatorWeapon getTerminator(String key)
	{		
        return terminatorWeapons.get(key);   
	}
	
	public static BikeWeapon getBikeWeapon(String key)
	{		
        return bikeWeapons.get(key);   
	}
	
	public static Drop_PodWeapon getDrop_PodWeapon(String key)
	{		
        return dropPodWeapons.get(key);   
	}
	
	public static Land_SpeederWeapon getLand_SpeederWeapon(String key)
	{		
        return landSpeederWeapons.get(key);   
	}
	
	public static RazorbackWeapon getRazorbackWeapon(String key)
	{		
        return razorbackWeapons.get(key);   
	}
	
	public static GunshipWeapon getGunshipWeapon(String key)
	{		
        return gunshipWeapons.get(key);   
	}
	
	public static TankWeapon getTankWeapon(String key)
	{		
        return tankWeapons.get(key);   
	}
	
	public static HQWeapon getHQWeapon(String key)
	{		
        return hqWeapons.get(key);   
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
