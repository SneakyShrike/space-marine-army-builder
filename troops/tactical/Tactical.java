package troops.tactical;

import gui.model.Unit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import wargear.weapon.Weapon;
import wargear.weapon.WeaponList;

public class Tactical extends Unit
{	
	//DEFAULT Tactical
	public Tactical() 
	{  
		//super();
		unitName = "Tactical Squad";
		COMBOMAXSIZE = 7;
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
        
        unitWeaponsList.add(WeaponList.getSpecial("Flamer"));
        unitWeaponsList.add(WeaponList.getSpecial("Meltagun"));
        unitWeaponsList.add(WeaponList.getSpecial("Grav-Gun"));
        unitWeaponsList.add(WeaponList.getSpecial("Plasma Gun"));
        unitWeaponsList.add(WeaponList.getHeavy("Heavy Bolter"));
        unitWeaponsList.add(WeaponList.getHeavy("Multi-Melta"));
        unitWeaponsList.add(WeaponList.getHeavy("Missle Launcher (Frag)"));
        unitWeaponsList.add(WeaponList.getHeavy("Missle Launcher (Krak)"));
        unitWeaponsList.add(WeaponList.getHeavy("Missle Launcher (Flakk)"));
        unitWeaponsList.add(WeaponList.getHeavy("Plasma Cannon"));
        unitWeaponsList.add(WeaponList.getHeavy("Lascannon"));
        unitWeaponsList.add(WeaponList.getHeavy("Grav-Cannon"));
        unitWeaponsList.add(WeaponList.getHeavy("Grav-Amp"));

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
		return COMBOMAXSIZE;
	}


}
