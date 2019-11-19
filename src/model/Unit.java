package model;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.wargear.weapon.Weapon;

public class Unit //unit super class
{
	public ArrayList<Weapon> unitWeaponsList, unitSecondWeaponsList; //one or two lists of available weapon upgrades
	protected Weapon weapon, weaponTwo; //one one two default weapons
	protected String unitName, save; //id of the squad to be used in switch statements, unit characteristic save value
	protected int points, weaponSkill, ballisticSkill, strength, toughness, 
    wounds, initiative, attacks, leadership; //other unit characteristic values
	
	public Unit()
	{
		unitWeaponsList = new ArrayList<>(); 
		unitSecondWeaponsList = new ArrayList<>(); //initialise both lists of weapon upgrades
	}
	
	public void unitWeaponUpgrade(Weapon weapon) //upgrades the unit members first weapon and updates the points value with the weapons points
	{
		this.weapon = weapon; 
	    points = points + weapon.getWeaponPoints();
    }
	
	public void unitSecondWeaponUpgrade(Weapon weaponTwo) //upgrades the unit members second weapon and updates the points value with the weapons points
	{
		this.weaponTwo = weaponTwo; 
	    points = points + weaponTwo.getWeaponPoints();
    }
							
	public Weapon getWeaponUpgrade() //returns the unit members current weapon
	{
		return weapon;
	}
	
	public int getUnitPoints () //returns the unit members current points value
	{
		return this.points;
	}
	
	public ArrayList<Weapon> getUnitWeaponsList() //return unit members available first weapon upgrades
	{
		return unitWeaponsList;
	}
	
	public ArrayList<Weapon> getUnitSecondWeaponsList() //return unit members available first weapon upgrades
	{
		return unitSecondWeaponsList;
	}
	
	/*public void resetUnitPoints()
	{
		this.points = 11;
	}*/
	
	public String getCharacteristics() //printout of the units characteristics 
	{		
		return "Characteristics:   WS: " + weaponSkill + "   BS: " + ballisticSkill + "   S: " + strength
				+  "   T: " + toughness + "   W: " + wounds + "   I: " + initiative + "   A: " + attacks
				+ "   LD: " + leadership + "   SV: " + save;
	}
	
	public String getUnitDetails() //printout format of each unit member
	{
		return "|| " + "Weapon: " + weapon + " || " + "Points: " + points;
	}
						
	public ObservableList<Weapon> getUnitWeapons() //returns an observable list of upgradable weapons
	{		
		ObservableList<Weapon> unitWeaponsOList = FXCollections.observableArrayList(unitWeaponsList);
		return unitWeaponsOList;
	}
	
	public ObservableList<Weapon> getUnitSecondWeapons() //returns an observable list of upgradable weapons
	{		
		ObservableList<Weapon> unitSecondWeaponsOList = FXCollections.observableArrayList(unitSecondWeaponsList);
		return unitSecondWeaponsOList;
	}
				
	@Override
	public String toString() //used to ensure the unit id is accessible in the controller
	{
		return unitName;		
	}	
}
