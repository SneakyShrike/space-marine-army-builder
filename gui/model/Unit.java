package gui.model;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import wargear.weapon.Weapon;

public class Unit
{
	protected ArrayList<Integer> unitSizeList, weaponUpgradeAmount; //a unit has a size
	protected ArrayList<Weapon> unitWeaponsList;
	protected Weapon weapon;
	protected String unitName, save;
	protected int COMBOMAXSIZE, points, weaponSkill, ballisticSkill, strength, toughness, 
    wounds, initiative, attacks, leadership;
	
	public Unit()
	{
		unitSizeList = new ArrayList<>();
		unitWeaponsList = new ArrayList<>();
		weaponUpgradeAmount = new ArrayList<>();
	}
	
	public void unitWeaponUpgrade(Weapon weapon) 
	{
		this.weapon = weapon; 
	    points = points + weapon.getWeaponPoints();
    }
		
	/*public List<Weapon> getUnitWeapon ()
	{
		return unitWeaponsList;
	}*/
	
	/*public void setPoints (int points)
	{
		this.points = points;
	}*/
						
	/*public Weapon getWeaponUpgrade()
	{
		return weapon;
	}*/
	
	public String getCharacteristics()
	{		
		return "Scout Characteristics: " + "WS:" + weaponSkill + "  " + "BS:" + ballisticSkill + "  " + "S:" + strength
				+ "  " + "T:" + toughness + "  " + "W" + wounds + "  " + "I:" + initiative + "  " + "A:" + attacks
				+ "  " + "LD:" + leadership + "  " + "SV:" + save;
	}
	
	public String getUnitDetails()
	{
		return "|| " + "Weapon: " + weapon + " || " + "Points: " + points;
	}
		
	public int getMaxSize()
	{
		return COMBOMAXSIZE;
	}
	
			
	public ObservableList<Integer> getUnitSize() //used in the ChangeListner in the addUnitPane to populate the size ComboBox (third ComboBox)  
	{
		for (int i = 1; i <= COMBOMAXSIZE; i++)
			unitSizeList.add(i);
		
		ObservableList<Integer> unitSizeOList = FXCollections.observableArrayList(unitSizeList);
		return unitSizeOList;
	}
	
	public ObservableList<Weapon> getUnitWeapons()
	{		
		ObservableList<Weapon> unitWeaponsOList = FXCollections.observableArrayList(unitWeaponsList);
		return unitWeaponsOList;
	}
	
	public ObservableList<Integer> getWeaponUpgradeAmount(int amount)
	{	
			   for (int i = 1; i < amount; i++)
				   weaponUpgradeAmount.add(i);				   

		ObservableList<Integer> weaponUpgradeAmountOList = FXCollections.observableArrayList(weaponUpgradeAmount);
		return weaponUpgradeAmountOList;
	}
			
	@Override
	public String toString() 
	{
		return unitName;		
	}	
}
