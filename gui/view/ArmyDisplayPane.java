package gui.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class ArmyDisplayPane extends BorderPane 
{
	private ListView<String> armyDisplay;
	private ObservableList<String> unitDisplay;
	private Button saveDisplay;
	private HBox buttonHAlign; //allows the button to be horizontally centred
	
	public ArmyDisplayPane()
	{
		this.setPadding(new Insets(40, 40, 40, 40));
		
		unitDisplay = FXCollections.observableArrayList();
		armyDisplay = new ListView<>(unitDisplay);
		armyDisplay.setEditable(false); //ensures a user can't edit the TextArea
		armyDisplay.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		armyDisplay.setPrefSize(200, 150);
		
		saveDisplay = new Button("Save Army Display");
		
		buttonHAlign = new HBox();
		buttonHAlign.setAlignment(Pos.CENTER); //set the HBox to be horizontally centre
		buttonHAlign.setPadding(new Insets(15, 0, 0, 0)); //allows a gap between the display and button
		buttonHAlign.getChildren().add(saveDisplay); //adds the button to the HBox
				
		this.setCenter(armyDisplay); //sets the centre of the BorderPane to be a TextArea
		this.setBottom(buttonHAlign); //sets the bottom of the BorderPane to be a Button 		
	}
	
	public void setDisplayInput(String input)
	{
		unitDisplay.add(input);
	}
	
	/*public ObservableList<String> getContents()
	{
		return units;
	}*/
	
		
	public void SaveArmyHandler(EventHandler<ActionEvent> handler)
	{
		saveDisplay.setOnAction(handler);
	}	
}
