package model;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.wargear.weapon.Weapon;

public class Unit
{
	protected ArrayList<Weapon> unitWeaponsList, unitSecondWeaponsList;
	protected Weapon weapon, weaponTwo;
	protected String unitName, save;
	protected int points, weaponSkill, ballisticSkill, strength, toughness, 
    wounds, initiative, attacks, leadership;
	
	public Unit()
	{
		unitWeaponsList = new ArrayList<>();
		unitSecondWeaponsList = new ArrayList<>();
	}
	
	public void unitWeaponUpgrade(Weapon weapon) 
	{
		this.weapon = weapon; 
	    points = points + weapon.getWeaponPoints();
    }
	
	public void unitSecondWeaponUpgrade(Weapon weaponTwo) 
	{
		this.weaponTwo = weaponTwo; 
	    points = points + weaponTwo.getWeaponPoints();
    }
							
	public Weapon getWeaponUpgrade()
	{
		return weapon;
	}
	
	public int getUnitPoints ()
	{
		return this.points;
	}
	
	public void resetUnitPoints()
	{
		this.points = 11;
	}
	
	public String getCharacteristics()
	{		
		return "Characteristics: " + "WS: " + weaponSkill + "  " + "BS: " + ballisticSkill + "  " + "S: " + strength
				+ "  " + "T: " + toughness + "  " + "W: " + wounds + "  " + "I: " + initiative + "  " + "A: " + attacks
				+ "  " + "LD: " + leadership + "  " + "SV: " + save;
	}
	
	public String getUnitDetails()
	{
		return "|| " + "Weapon: " + weapon + " || " + "Points: " + points;
	}
						
	public ObservableList<Weapon> getUnitWeapons()
	{		
		ObservableList<Weapon> unitWeaponsOList = FXCollections.observableArrayList(unitWeaponsList);
		return unitWeaponsOList;
	}
	
	public ObservableList<Weapon> getUnitSecondWeapons()
	{		
		ObservableList<Weapon> unitSecondWeaponsOList = FXCollections.observableArrayList(unitSecondWeaponsList);
		return unitSecondWeaponsOList;
	}
				
	@Override
	public String toString() 
	{
		return unitName;		
	}	
}
