package view;

import javafx.beans.binding.BooleanBinding;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import model.Unit;
import model.UnitSquad;
import model.Unit_Type;
import model.elites.centurion_assault.Centurion_Assault;
import model.elites.command.Command;
import model.elites.deadnought.Dreadnought;
import model.elites.honour_guard.Honour_Guard;
import model.elites.ironclad_dreadnought.Ironclad_Dreadnought;
import model.elites.sternguard_veteran.Sternguard_Veteran;
import model.elites.terminator.Terminator;
import model.elites.terminator_assault.Terminator_Assault;
import model.elites.vanguard_veteran.Vanguard_Veteran;
import model.elites.venerable_dreadnought.Venerable_Dreadnought;
import model.fast_attack.assault.Assault;
import model.fast_attack.attack_bike.Attack_Bike;
import model.fast_attack.bike.Bike;
import model.fast_attack.drop_pod.Drop_Pod;
import model.fast_attack.land_speeder.Land_Speeder;
import model.fast_attack.land_speeder_storm.Land_Speeder_Storm;
import model.fast_attack.razorback.Razorback;
import model.fast_attack.rhino.Rhino;
import model.fast_attack.scout_bike.Scout_Bike;
import model.fast_attack.stormhawk_interceptor.Stormhawk_Interceptor;
import model.fast_attack.stormtalon_gunship.Stormtalon_Gunship;
import model.heavy_support.centurion_devastator.Centurion_Devastator;
import model.heavy_support.devastator.Devastator;
import model.heavy_support.hunter.Hunter;
import model.heavy_support.land_raider.Land_Raider;
import model.heavy_support.land_raider_crusader.Land_Raider_Crusader;
import model.heavy_support.land_raider_redeemer.Land_Raider_Redeemer;
import model.heavy_support.predator.Predator;
import model.heavy_support.stalker.Stalker;
import model.heavy_support.stormraven_gunship.Stormraven_Gunship;
import model.heavy_support.thunderfire_cannon.Thunderfire_Cannon;
import model.heavy_support.vindicator.Vindicator;
import model.heavy_support.whirlwind.Whirlwind;
import model.hq.captain.Captain;
import model.hq.chaplain.Chaplain;
import model.hq.librarian.Librarian;
import model.hq.techmarine.Techmarine;
import model.troops.scout.Scout;
import model.troops.tactical.Tactical;
import model.wargear.weapon.Weapon;

public class AddUnitPane extends BorderPane
{	
	private Label totalPoints, unitTypeLbl, unitLbl, unitNameLbl, unitMemberSelectedLbl, unitWeaponLbl, 
	              unitSecondWeaponLbl, weaponsCheckMessage, sizeCheckMessage;
	private ComboBox<Unit_Type> unitTypeCombo; 
	private ComboBox<Unit> unitCombo;
	private ComboBox<Integer> unitMemberSelectedCombo;
	private ListView<UnitSquad> lv;
	private ObservableList<UnitSquad> armyList;
	private ComboBox<Weapon> unitWeaponCombo, unitSecondWeaponCombo;
	private TextField unitNameTf;
	private Button addUnitBtn, addUnitMemberBtn, removeUnitMemberBtn, upgradeUnitWeaponBtn, removeSquadBtn, 
	               clearArmyBtn;

	private Unit_Type HQ, troops, elites, fast_attack, heavy_support;
	
	public AddUnitPane()
	{		
		HBox topSection = new HBox();
		
		GridPane leftSection = new GridPane();
		leftSection.setVgap(25);

		HBox centreSection = new HBox();
		
		GridPane rightSection = new GridPane();
		rightSection.setVgap(25);
		
		VBox bottomSection = new VBox();
				
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------		
        
		HQ = new Unit_Type("HQ", new Captain(), new Chaplain(), new Librarian(), new Techmarine());
		
		troops = new Unit_Type("Troops", new Scout(), new Tactical());
		
		elites = new Unit_Type("Elites", new Centurion_Assault(), new Command(), new Dreadnought(), new Honour_Guard(), 
				 new Ironclad_Dreadnought(), new Sternguard_Veteran(), new Terminator(), new Terminator_Assault(), 
				 new Vanguard_Veteran(), new Venerable_Dreadnought());
		
		fast_attack = new Unit_Type("Fast Attack", new Assault(), new Attack_Bike(), new Bike(), new Drop_Pod(), 
				      new Land_Speeder(), new Land_Speeder_Storm(), new Razorback(), new Rhino(), new Scout_Bike(),  
				      new Stormhawk_Interceptor(), new Stormtalon_Gunship()); 
		
		heavy_support = new Unit_Type("Heavy Support", new Centurion_Devastator(), new Devastator(), new Hunter(), 
				        new Land_Raider(), new Land_Raider_Crusader(), new Land_Raider_Redeemer(), new Predator(), 
				        new Stalker(), new Stormraven_Gunship(), new Thunderfire_Cannon(), new Vindicator(),
				        new Whirlwind());
						
		ObservableList<Unit_Type> unitTypeOList = FXCollections.observableArrayList(HQ, troops, elites, fast_attack, heavy_support);
		ObservableList<Integer> unitMemberSelectedOlist = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10);
		        
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			
        totalPoints = new Label();
		unitTypeLbl = new Label("Select The Unit Type:  "); 
		unitLbl = new Label("Select The Unit:  ");
		unitNameLbl = new Label("Type The Unit Name: ");
		unitMemberSelectedLbl = new Label("Select A Unit Member:  ");
		unitWeaponLbl = new Label("Select The Unit Members Weapon Upgrade:  ");
		unitSecondWeaponLbl = new Label("Select The Unit Members Second Weapon Upgrade:  ");
		weaponsCheckMessage = new Label();
		sizeCheckMessage = new Label();	
		
		totalPoints.setStyle("-fx-text-fill: #FFFFFF;");
		unitTypeLbl.setStyle("-fx-text-fill: #FFFFFF;");
		unitLbl.setStyle("-fx-text-fill: #FFFFFF;");
		unitNameLbl.setStyle("-fx-text-fill: #FFFFFF;");
		unitMemberSelectedLbl.setStyle("-fx-text-fill: #FFFFFF;");
		unitWeaponLbl.setStyle("-fx-text-fill: #FFFFFF;");
		unitSecondWeaponLbl.setStyle("-fx-text-fill: #FFFFFF;");
		weaponsCheckMessage.setStyle("-fx-text-fill: #FFFFFF;");
		sizeCheckMessage.setStyle("-fx-text-fill: #FFFFFF;");
						
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
				        
		unitTypeCombo = new ComboBox<Unit_Type>(); //Initialise the unitTypeCombo (first ComboBox)
		unitTypeCombo.setItems(unitTypeOList); //Populate the unitTypeCombo with the UnitTypeOList (observable list) from line 84
		
		unitCombo = new ComboBox<Unit>(); //Initialise the unitCombo (second ComboBox)
		unitCombo.setDisable(true);
		
		unitTypeCombo.valueProperty().addListener(new ChangeListener<Unit_Type>() //populates the unitCombo (second ComboBox) based on the unit type chosen
		{
		    @Override
		    public void changed(ObservableValue<? extends Unit_Type> observable, Unit_Type oldValue, Unit_Type newValue) 
		    {
		        unitCombo.setItems(newValue == null ? FXCollections.emptyObservableList() : newValue.getUnitsForType());
		    }
		});
				    				
		unitWeaponCombo = new ComboBox<>();
		unitWeaponCombo.setDisable(true);
		unitSecondWeaponCombo = new ComboBox<>();
		unitSecondWeaponCombo.setDisable(true);
		
		unitCombo.valueProperty().addListener(new ChangeListener<Unit>() 
		{
			@Override
			public void changed(ObservableValue<? extends Unit> observable, Unit oldValue, Unit newValue) 
			{												
				unitWeaponCombo.setItems(newValue == null ? FXCollections.emptyObservableList() : newValue.getUnitWeapons());
				unitSecondWeaponCombo.setItems(newValue == null ? FXCollections.emptyObservableList() : newValue.getUnitSecondWeapons());
				unitWeaponCombo.getSelectionModel().selectFirst();
				unitSecondWeaponCombo.getSelectionModel().selectFirst();
		    }			
		});
				
		/*lv.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<UnitSquad>() 
		{
			@Override
			public void changed(ObservableValue<? extends UnitSquad> observable, UnitSquad oldValue, UnitSquad newValue) 
			{												
				unitWeaponCombo.setItems(newValue == null ? FXCollections.emptyObservableList() : newValue.getUnitWeapons());
				unitSecondWeaponCombo.setItems(newValue == null ? FXCollections.emptyObservableList() : newValue.getUnitSecondWeapons());
				unitWeaponCombo.getSelectionModel().selectFirst();
				unitSecondWeaponCombo.getSelectionModel().selectFirst();
		    }			
		});*/
					
		unitNameTf = new TextField(); //Initialise the unit name TextField
						
		addUnitBtn = new Button("Add Unit");
		addUnitBtn.setDisable(true);
		
		armyList = FXCollections.observableArrayList();
		lv = new ListView<>(armyList);
		lv.setEditable(false); //ensures a user can't edit the TextArea
		lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); 
		lv.setPrefSize(500, 750);
		
		addUnitMemberBtn = new Button("Add Unit Member (+)");
		removeUnitMemberBtn = new Button("Remove Unit Member (-)");
		unitMemberSelectedCombo = new ComboBox<>();
		unitMemberSelectedCombo.setItems(unitMemberSelectedOlist);
		upgradeUnitWeaponBtn = new Button("Upgrade Unit Weapon");
		upgradeUnitWeaponBtn.setDisable(true);
		removeSquadBtn = new Button ("Remove A Selected Squad");
	    clearArmyBtn = new Button ("Clear The Entire Army");
	    		
		topSection.getChildren().add(totalPoints);
		topSection.setAlignment(Pos.CENTER);
		topSection.setPadding(new Insets(10,10,10,10));
		topSection.setStyle("-fx-background-color: #565656;");
		
		/*-----------------------------------------------------------------------*/
	
		leftSection.add(unitTypeLbl, 0, 0);
		leftSection.add(unitTypeCombo, 1, 0);
		
		leftSection.add(unitLbl, 0, 1);
		leftSection.add(unitCombo, 1, 1);

		
		leftSection.add(unitNameLbl, 0, 2);
		leftSection.add(unitNameTf, 1, 2);
				
		leftSection.add(new HBox(), 0, 3);
		leftSection.add(addUnitBtn, 1, 3);	
		
		VBox leftBox = new VBox(leftSection);
		leftBox.setStyle("-fx-background-color: #313131;");
		leftBox.setPadding(new Insets(20,20,20,20));
		
		/*--------------------------------------------------------------------------------*/
		
		centreSection.getChildren().add(lv);
		centreSection.setAlignment(Pos.CENTER);
		HBox.setHgrow(lv, Priority.ALWAYS);
		
		HBox innerCentreBox = new HBox(removeSquadBtn, clearArmyBtn);
		innerCentreBox.setPadding(new Insets(20,20,20,20));
		innerCentreBox.setSpacing(25);
		innerCentreBox.setAlignment(Pos.CENTER);
		
		VBox centreBox = new VBox(centreSection, innerCentreBox);	
		centreBox.setStyle("-fx-background-color: #313131;");
		
		/*--------------------------------------------------------------------------------*/
		
		rightSection.add(unitMemberSelectedLbl, 0, 0);
		rightSection.add(unitMemberSelectedCombo, 1, 0);
		
		rightSection.add(unitWeaponLbl, 0, 1);
		rightSection.add(unitWeaponCombo, 1, 1);
		
		rightSection.add(unitSecondWeaponLbl, 0, 2);
		rightSection.add(unitSecondWeaponCombo, 1, 2);
		
		rightSection.add(upgradeUnitWeaponBtn, 1, 3);
		
        rightSection.add(addUnitMemberBtn, 1, 4);	
		
		rightSection.add(removeUnitMemberBtn, 1, 5);
				
		VBox rightBox = new VBox(rightSection);	
		rightBox.setStyle("-fx-background-color: #313131;");
		rightBox.setPadding(new Insets(20,20,20,20));
		
		bottomSection.getChildren().addAll(weaponsCheckMessage, sizeCheckMessage);
		bottomSection.setStyle("-fx-background-color: #565656;");
		bottomSection.setAlignment(Pos.CENTER);
		bottomSection.setPadding(new Insets(10,10,10,10));
				
		this.setTop(topSection);
		this.setLeft(leftBox);
		this.setCenter(centreBox);
		this.setRight(rightBox);
		this.setBottom(bottomSection);	
	}
	
	/*public void populateUnitMemberComboBox(ArrayList<Integer> members)
	{
		unitMemberSelectedCombo.getItems().addAll(members);
		unitMemberSelectedCombo.getSelectionModel().select(0); //default selection
	}*/
	
	public void setTotalPointsColour(String colour)
	{
		totalPoints.setStyle(colour);
	}
	
	public Unit_Type getUnitType() //returns the selected unit type from the unitTypeCombo (first ComboBox)
	{
		return unitTypeCombo.getSelectionModel().getSelectedItem();		
	}
	
	public Unit getUnit() //returns the selected unit from the unitCombo (second ComboBox)
	{
		return unitCombo.getSelectionModel().getSelectedItem();
	}
			
	public Weapon getUnitWeapon() //returns the selected unit weapon from the unitWeaponCombo (fourth ComboBox)
	{
		return unitWeaponCombo.getSelectionModel().getSelectedItem();
	}
	
	public Weapon getUnitSecondWeapon() //returns the selected unit weapon from the unitWeaponCombo (fourth ComboBox)
	{
		return unitSecondWeaponCombo.getSelectionModel().getSelectedItem();
	}
	
	public Integer getunitMemberSelected() //returns the selected unit size from the unitSizeCombo (third ComboBox)
	{
		return unitMemberSelectedCombo.getSelectionModel().getSelectedItem();
	}
	
	public String getUnitName() //returns the user specified name given to the unit or squad
	{
		return unitNameTf.getText();
	}
		
	public void AddUnitHandler(EventHandler<ActionEvent> handler) //when the add button is pressed, control is allocated to an event handler in controller
	{
		addUnitBtn.setOnAction(handler);
	}
	
	public UnitSquad getUnitSquad()
	{
		return new UnitSquad(unitNameTf.getText());		
	}
			
	public void removeSelectedUnitSquad()
		{
			int index = lv.getSelectionModel().getSelectedIndex();
			if (index != -1) 
			{
				armyList.removeAll(this.getSelectedUnitSquads());
				//this.clearSelection();
			}		
		}

	public void setweaponsCheckMessage(String message)
	{
		weaponsCheckMessage.setText(message);		
	}
	
	public void setSizeCheckMessage(String message)
	{
		sizeCheckMessage.setText(message);		
	}
		
	public ObservableList<UnitSquad> getContents()
	{
		return armyList;		
	}
	
	public UnitSquad getSelectedUnitSquad()
	{
		return lv.getSelectionModel().getSelectedItem();
	}
	
	public int getSelectedUnitSquadIndex()
	{
		return lv.getSelectionModel().getSelectedIndex();
	}
	
	public ObservableList<UnitSquad> getSelectedUnitSquads() 
	{
		return lv.getSelectionModel().getSelectedItems();
	}
	
	/*--------------------------------------------------------EVENT HANDLER SECTION---------------------------------------------*/
	
	public void addUnitMemberBtn(EventHandler<ActionEvent> handler) //when the add button is pressed, control is allocated to an event handler in controller
	{
		addUnitMemberBtn.setOnAction(handler);
	}
	
	public void removeUnitMemberBtn(EventHandler<ActionEvent> handler) //when the add button is pressed, control is allocated to an event handler in controller
	{
		removeUnitMemberBtn.setOnAction(handler);
	}
	
	public void upgradeUnitWeaponHandler(EventHandler<ActionEvent> handler) //when the add button is pressed, control is allocated to an event handler in controller
	{
		upgradeUnitWeaponBtn.setOnAction(handler);
	}
	
	//--------------------------------------------------------------------------------------------------------------------
	
	public void setMaxpoints(int currentPoints, int totalPoints)
	{
		this.totalPoints.textProperty().bind(new SimpleIntegerProperty(currentPoints).asString()
		.concat("/")
		.concat(new SimpleIntegerProperty(totalPoints).asString()));
	}
	
	public void removeSquadHandler(EventHandler<ActionEvent> handler)
	{
		removeSquadBtn.setOnAction(handler);
	}	
		
	public void clearArmyHandler(EventHandler<ActionEvent> handler)
	{
		clearArmyBtn.setOnAction(handler);
	}
	
	public void clearArmyList()
	{
		armyList.clear();
	}
	
	/*--------------------------------------------------------BINDING SECTION---------------------------------------------*/
	
	public void addUnitBtnDisableBind(BooleanBinding property)
	{
		addUnitBtn.disableProperty().bind(property);
	}
	
	public BooleanBinding areAddUnitOptionsEmpty()
	{
		return unitNameTf.textProperty().isEmpty()
				.or(unitTypeCombo.valueProperty().isNull()
				.or(unitCombo.valueProperty().isNull()));		
	}
	
	public void unitComboDisableBind(BooleanBinding property)
	{
		unitCombo.disableProperty().bind(property);
	}
	
	public BooleanBinding isunitTypeComboEmpty()
	{
		return unitTypeCombo.valueProperty().isNull();		
	}
	
	public void unitWeaponComboDisableBind(BooleanBinding property)
	{
		unitWeaponCombo.disableProperty().bind(property);
		unitSecondWeaponCombo.disableProperty().bind(property);
	}
	
	public BooleanBinding isunitMemberSelectedComboEmpty()
	{
		return unitMemberSelectedCombo.valueProperty().isNull();		
	}
	
	public void upgradeUnitWeaponBtnDisableBind(BooleanBinding property)
	{
		upgradeUnitWeaponBtn.disableProperty().bind(property);
	}
	
	public BooleanBinding areWeaponUpgradeOptionsEmpty()
	{
		return unitMemberSelectedCombo.valueProperty().isNull().or(unitWeaponCombo.valueProperty().isNull());		
	}
	
    public void removeMemberBtnDisableBind(Boolean property)
	{
		removeUnitMemberBtn.setDisable(property);
	}
}
