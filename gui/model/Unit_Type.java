package gui.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import troops.scout.Scout;

public class Unit_Type implements Serializable 
{
	private String typeName;
	private transient ObservableList<Unit> units; //a unit type is an aggregation of units
	
	/*private void writeObject(ObjectOutputStream stream) throws IOException 
	{
        stream.defaultWriteObject();
        // serialize units list as string array 
        stream.writeObject(units.toArray());
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException 
    {
        stream.defaultReadObject();

        // read array from stream and initialize list with it
        // Note: because of the way we write objects of this type we can use the raw type here safely
        units = (ObservableList) FXCollections.<Object>observableArrayList((Object[])stream.readObject());
    }*/
	
	public Unit_Type(String typeName, Unit... units) //a unit type must have a name and some units
	{
		this.typeName = typeName;
		this.units = FXCollections.observableArrayList(units);
	}
	
	public void setTypeName(String name)
	{
		typeName = name; 
	}
		
	public ObservableList<Unit> getUnitsForType() //used in the ChangeListner in the addUnitPane to populate the unitCombo (second ComboBox)
	{
		return units;		
	}

	@Override
	public String toString() //allows the unitCombo (second ComboBox) to display values correctly
	{
		return typeName;		
	}
}
