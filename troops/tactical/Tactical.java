package troops.tactical;

import gui.model.Unit;
import wargear.weapon.Weapon;
import wargear.weapon.WeaponList;

public class Tactical extends Unit
{
	private Weapon weapon;
	private final int weaponSkill, ballisticSkill, strength, 
	                  toughness, wounds, initiative, attacks,  
	                  leadership;
		
	private  String save;
	
	private int points;
	private final int maxSize;
	
	//DEFAULT Tactical
	public Tactical() 
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
        save = "3+";
        points = 14; 
        points = points + weapon.getWeaponPoints();
        maxSize = 9;
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
		return "Tactical Characteristics: " + "WS:" + weaponSkill + "  " + "BS:" + ballisticSkill + "  " + "S:" + strength
				+ "  " + "T:" + toughness + "  " + "W" + wounds + "  " + "I:" + initiative + "  " + "A:" + attacks
				+ "  " + "LD:" + leadership + "  " + "SV:" + save;
	}
	
	public String getTacticalDetails()
	{
		return "|| " + "Weapon: " + weapon + " || " + "Points: " + points;
	}
	
	public int getMaxSize()
	{
		return maxSize;
	}

	

}
