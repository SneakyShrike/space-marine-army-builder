package gui.model;

import wargear.weapon.Weapon;
import wargear.weapon.WeaponList;

public class Unit1 
{
	private Weapon weapon;
	private final int weaponSkill, ballisticSkill, strength, 
	                  toughness, wounds, initiative, attacks,  
	                  leadership;
		
	private final String save;
	
	private int points;
	
	//DEFAULT SCOUT
	public Unit1() 
	{       
        weapon = WeaponList.getRanged("Boltgun");
        weaponSkill = 4;
        ballisticSkill = 4;
        strength = 4;
        toughness = 4; 
        wounds = 1;
        initiative = 4;
        attacks = 1;
        leadership = 8;
        save = "4+";
        points = 11; 
        points = points + weapon.getWeaponPoints();      
	}
	
	public void weaponUpgrade(Weapon weapon) 
	{		
		switch(weapon.toString())
		{
		   case "Boltgun" : 
		   case "Shotgun" :
		   case "Close Combat Weapon" :
		   case "Sniper Rifle" :
			   this.weapon = weapon; 
	           points = points + weapon.getWeaponPoints();
	       break;
		   case "Heavy Bolter" :
			   weapon.setWeaponPoints(8);
		   case "Heavy Bolter (Hellfire Shell)" :			 
		   case "Missle Launcher (Frag)" :
		   case "Missle Launcher (Krak)" :
		   case "Missle Launcher (Flakk)" :
		       this.weapon = weapon; 
	           points = points + weapon.getWeaponPoints();
	        break;        
	        default :
	        	System.out.println("A Scout can't have a " + weapon);	       	        	
		}
    }

	public void setPoints (int points)
	{
		this.points = points;
	}
	
							
	public Weapon getWeaponUpgrade()
	{
		return weapon;
	}
	
	public String getCharacteristics()
	{		
		return "Scout Characteristics: " + "WS:" + weaponSkill + "  " + "BS:" + ballisticSkill + "  " + "S:" + strength
				+ "  " + "T:" + toughness + "  " + "W" + wounds + "  " + "I:" + initiative + "  " + "A:" + attacks
				+ "  " + "LD:" + leadership + "  " + "SV:" + save;
	}

}
