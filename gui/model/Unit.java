package gui.model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import wargear.weapon.Weapon;

public abstract class Unit
{
	protected String unitName; //a unit has a name
	protected int COMBOMAXSIZE, points; //max number of values in the combo box, NEEDS TO INHERIT FROM SCOUT SQUAD SQUAD MAXSIZE SOMEHOW
	protected ArrayList<Integer> unitSizeList, weaponUpgradeAmount; //a unit has a size
	protected ArrayList<Weapon> unitWeaponsList;
	protected Weapon weapon;
	protected int weaponSkill, ballisticSkill, strength, toughness, 
    wounds, initiative, attacks, leadership;
	protected String save;	
	
	public Unit()
	{
		unitSizeList = new ArrayList<>();
		unitWeaponsList = new ArrayList<>();
	}
	
			
	public ObservableList<Integer> getUnitSize() //used in the ChangeListner in the addUnitPane to populate the size ComboBox (third ComboBox)  
	{
		for (int i = 1; i <= COMBOMAXSIZE; i++)
		{
			unitSizeList.add(i);
		}		
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
			   {
				   weaponUpgradeAmount.add(i);				   
			   }

		ObservableList<Integer> weaponUpgradeAmountOList = FXCollections.observableArrayList(weaponUpgradeAmount);
		return weaponUpgradeAmountOList;
	}
	
		
	@Override
	public String toString() 
	{
		return unitName;		
	}
	
	
}
