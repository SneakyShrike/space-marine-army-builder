package gui.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Army implements Iterable<UnitSquad>
{
	private int currentPoints, totalPoints;
	private ObservableList<UnitSquad> armyList;
	private ListProperty<UnitSquad> lp;
	
	public Army()
	{
		currentPoints = 0;
		this.armyList = FXCollections.observableArrayList();
		lp = new SimpleListProperty<>(armyList);
	}
	
	@Override
	public Iterator<UnitSquad> iterator() 
	{
		return armyList.iterator();
	}
			
	public void setCurrentPoints (int currentPoints)
	{		
		this.currentPoints = currentPoints;
	}
	
	public int getCurrentPoints ()
	{
        int currentTotal = 0; 
		
		for (int i = 0; i < armyList.size(); i++)
			currentTotal = currentTotal + armyList.get(i).getSquadPoints();
							
		return currentTotal;
	}
	
	public void setTotalPoints (int currentPoints)
	{
		this.totalPoints = currentPoints;		
	}
	
	public int getTotalPoints ()
	{
		return totalPoints;
	}
	
	public void bindContentBidirectional(ObservableList<UnitSquad> otherList) 
	{
		lp.bindContentBidirectional(otherList);
	}
	
	public void addUnitSquad (UnitSquad u)
	{
		armyList.add(u);
	}
	
	public void removeUnitSquad(int index)
	{
		armyList.remove(index);
	}
	
	public boolean removeUnitSquad(UnitSquad u)
	{
		return armyList.remove(u);
	}
	
	public UnitSquad getUnitSquad(int index)
	{
		return armyList.get(index);		
	}
	
	public void armyListSize()
	{
		armyList.size();
	}
	
	public boolean isArmyListEmpty()
	{
		return armyList.isEmpty();
	}
	
	public void clearArmyList()
	{
		armyList.clear();
	}
	
	public boolean armyListContains(UnitSquad u)
	{
		return armyList.contains(u);
	}
	
	@Override
	public String toString() {
		return "Army:[armyList=" + armyList + "]";
	}
}
