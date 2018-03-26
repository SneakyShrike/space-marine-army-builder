package gui.view;

import gui.model.UnitSquad;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class ArmyDisplayPane extends BorderPane 
{
	private ListView<UnitSquad> lv;
	private ObservableList<UnitSquad> armyList;
	private Button saveDisplayBtn, removeSquadBtn, clearArmyBtn;
	private HBox buttonHAlign; //allows the button to be horizontally centred
	
	public ArmyDisplayPane()
	{
		this.setPadding(new Insets(40, 40, 40, 40));
		
		armyList = FXCollections.observableArrayList();
		lv = new ListView<>(armyList);
		lv.setEditable(false); //ensures a user can't edit the TextArea
		lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		lv.setPrefSize(200, 150);
		
		saveDisplayBtn = new Button("Save Army Display");
		removeSquadBtn = new Button ("Remove A Selected Squad");
		clearArmyBtn = new Button ("Clear The Entire Army");
		
		buttonHAlign = new HBox();
		buttonHAlign.setAlignment(Pos.CENTER); //set the HBox to be horizontally centre
		buttonHAlign.setPadding(new Insets(15, 0, 0, 0)); //allows a gap between the display and button
		buttonHAlign.getChildren().addAll(saveDisplayBtn, removeSquadBtn, clearArmyBtn); //adds the button to the HBox
		buttonHAlign.setSpacing(15);
				
		this.setCenter(lv); //sets the centre of the BorderPane to be a TextArea
		this.setBottom(buttonHAlign); //sets the bottom of the BorderPane to be a Button 		
	}
	
	/*public void setDisplayInput(String input)
	{
		unitDisplay.add(input);
	}*/
	
	
	
	/*public ObservableList<String> getContents()
	{
		return units;
	}*/
	
	/*public void addUnitSquad(UnitSquad s)
	{
		armyList.add(s);
	}*/
		
	/*public ObservableList<UnitSquad> getContents()
	{
		return armyList;		
	}*/
	
	public void clearArmyList()
	{
		armyList.clear();
	}
	
	public UnitSquad getSelectedUnitSquad()
	{
		return lv.getSelectionModel().getSelectedItem();
	}
		
	public ObservableList<UnitSquad> getSelectedUnitSquads() 
	{
		return lv.getSelectionModel().getSelectedItems();
	}
	
	public void removeSelectedUnitSquad()
	{
		int index = lv.getSelectionModel().getSelectedIndex();
		if (index != -1) 
		{
			armyList.removeAll(this.getSelectedUnitSquads());
			this.clearSelection();
		}		
	}
			
	public void SaveArmyHandler(EventHandler<ActionEvent> handler)
	{
		saveDisplayBtn.setOnAction(handler);
	}	
	
	public void removeSquadHandler(EventHandler<ActionEvent> handler)
	{
		removeSquadBtn.setOnAction(handler);
	}	
	
	public void clearArmyHandler(EventHandler<ActionEvent> handler)
	{
		clearArmyBtn.setOnAction(handler);
	}
	
	public void clearSelection() 
	{
		lv.getSelectionModel().clearSelection();
	}
}
