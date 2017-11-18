package gui.model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import troops.scout.Scout;
import troops.scout.ScoutSquad;

public class Unit 
{
	private String unitName; //a unit has a name
	private ArrayList<Integer> unitSize; //a unit has a size
	private int MAXSIZE; //MAX amount of solders in a particular Unit
	
	public Unit(String unitName)
	{
		this.unitName = unitName;
		unitSize = new ArrayList<>();		
	}
	
	public Unit()
	{MAXSIZE = 0;}
		
	public ObservableList<Integer> getUnitSize() //used in the ChangeListner in the addUnitPane to populate the size ComboBox (third ComboBox)  
	{
		for (int i = 1; i <= MAXSIZE; i++)
		{
			unitSize.add(i);
		}		
		ObservableList<Integer> unitSizeOList = FXCollections.observableArrayList(unitSize);
		return unitSizeOList;
	}
		
	@Override
	public String toString() 
	{
		return unitName;		
	}
	
	
}
