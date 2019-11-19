package model;

import java.util.Iterator;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Army implements Iterable<UnitSquad>
{
	private int currentPoints, totalPoints; //actual points value of the army, maximum points of an army 
	private ObservableList<UnitSquad> armyList; //aggregation of unit squads 
	private ListProperty<UnitSquad> lp; //viewable list to be used with the Bidirectional method to update the view 
	
	
	public Army()
	{
		currentPoints = 0; //initial points is zero
		this.armyList = FXCollections.observableArrayList(); //initialise the Observable army list of unit squads
		lp = new SimpleListProperty<>(armyList); //initialise the list property with the Observable army list
	}
	
	@Override
	public Iterator<UnitSquad> iterator() //allows the army to be cycled through
	{
		return armyList.iterator();
	}
			
	public void setCurrentPoints (int currentPoints) //sets the actual points of the army
	{		
		this.currentPoints = currentPoints;
	}
	
	public int getCurrentPoints () //gets the current actual points of an army
	{
        int currentTotal = 0; 
		
		for (int i = 0; i < armyList.size(); i++)
			currentTotal = currentTotal + armyList.get(i).getSquadPoints();
							
		return currentTotal;
	}
	
	public void setTotalPoints (int currentPoints) //sets the maximum points value of an army
	{
		this.totalPoints = currentPoints;		
	}
	
	public int getTotalPoints () //gets the maximum points value of an army
	{
		return totalPoints;
	}
		
	public String getArmyUnits() //cycle through each unit squad in an army and display the output for each unit squad
	{
		String squad = "";
		
		for (int i = 0; i < armyList.size(); i++)
			squad = squad + armyList.get(i).getUnitSquad();
		
		return squad;
	}
	
	public void bindContentBidirectional(ObservableList<UnitSquad> otherList) //binds the army list from the view and the model together, 
	//which means that any updates on the model also update the view list display  
	{
		lp.bindContentBidirectional(otherList);
	}
	
	public void addUnitSquad (UnitSquad u) //adds a unit squad to the army 
	{
		armyList.add(u);
	}
	
	public void updatUnitSquad (int index, UnitSquad u) //updates a unit squad at a particular index in the army
	{
		armyList.set(index, u);		
	}
	
	/*public void removeUnitSquad(int index)
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
	}*/
}
