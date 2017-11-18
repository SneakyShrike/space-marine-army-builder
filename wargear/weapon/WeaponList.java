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
		put("Missle Launcher (Frag)", new Heavy("Missle Launcher (Frag)", 15));
		put("Missle Launcher (Krak)", new Heavy("Missle Launcher (Krak)", 15));
		put("Missle Launcher (Flakk)", new Heavy("Missle Launcher (Flakk)", 10));
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
	
		
	public static Ranged getRanged(String index)
	{		
        return rangedWeapons.get(index);   
	}
	
	public static Melee getMelee(String index)
	{		
        return meleeWeapons.get(index);   
	}
	
	public static Heavy getHeavy(String index)
	{		
        return heavyWeapons.get(index);   
	}
	
	public static Special getSpecial(String index)
	{		
        return specialWeapons.get(index);   
	}
		
	public static Map<String, Ranged> getRangedList()
	{			
		return rangedWeapons;
	}
}
