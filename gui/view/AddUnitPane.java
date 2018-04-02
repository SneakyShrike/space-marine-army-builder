package gui.view;

import elites.centurion_assault.Centurion_Assault;

import elites.command.Command;
import elites.deadnought.Dreadnought;
import elites.honour_guard.Honour_Guard;
import elites.ironclad_dreadnought.Ironclad_Dreadnought;
import elites.sternguard_veteran.Sternguard_Veteran;
import elites.terminator.Terminator;
import elites.terminator_assault.Terminator_Assault;
import elites.vanguard_veteran.Vanguard_Veterans;
import elites.venerable_dreadnought.Venerable_Dreadnought;
import fast_attack.assault.Assault;
import fast_attack.attack_bike.Attack_Bike;
import fast_attack.bike.Bike;
import fast_attack.drop_pod.Drop_Pod;
import fast_attack.land_speeder.Land_Speeder;
import fast_attack.land_speeder_storm.Land_Speeder_Storm;
import fast_attack.razorback.Razorback;
import fast_attack.rhino.Rhino;
import fast_attack.scout_bike.Scout_Bike;
import fast_attack.stormhawk_interceptor.Stormhawk_Interceptor;
import fast_attack.stormtalon_gunship.Stormtalon_Gunship;
import gui.model.Unit;
import gui.model.UnitSquad;
import gui.model.Unit_Type;
import heavy_support.centurion_devastator.Centurion_Devastator;
import heavy_support.devastator.Devastator;
import heavy_support.hunter.Hunter;
import heavy_support.land_raider.Land_Raider;
import heavy_support.land_raider_crusader.Land_Raider_Crusader;
import heavy_support.land_raider_redeemer.Land_Raider_Redeemer;
import heavy_support.predator.Predator;
import heavy_support.stalker.Stalker;
import heavy_support.stormraven_gunship.Stormraven_Gunship;
import heavy_support.thunderfire_cannon.Thunderfire_Cannon;
import heavy_support.vindicator.Vindicator;
import heavy_support.whirlwind.Whirlwind;
import hq.captain.Captain;
import hq.chaplain.Chaplain;
import hq.librarian.Librarian;
import hq.techmarine.Techmarine;
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
import troops.scout.Scout;
import troops.tactical.Tactical;
import wargear.weapon.Weapon;

public class AddUnitPane extends BorderPane
{
	private Label totalPoints, unitTypeLbl, unitLbl, unitNameLbl, unitMemberSelectedLbl, unitWeaponLbl, unitSecondWeaponLbl, weaponsCheckMessage, sizeCheckMessage;
	private ComboBox<Unit_Type> unitTypeCombo; 
	private ComboBox<Unit> unitCombo;
	private ComboBox<Integer> unitMemberSelectedCombo;
	private ListView<UnitSquad> lv;
	private ObservableList<UnitSquad> armyList;
	private ComboBox<Weapon> unitWeaponCombo, unitSecondWeaponCombo;
	private TextField unitNameTf;
	private Button addUnitBtn, addUnitMemberBtn, removeUnitMemberBtn, upgradeUnitWeaponBtn, removeSquadBtn, clearArmyBtn;

	private Unit_Type HQ, troops, elites, fast_attack, heavy_support;
	
	public AddUnitPane()
	{
		setStyle("-fx-text-fill: #FFFFFF;");
		
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
				 new Vanguard_Veterans(), new Venerable_Dreadnought());
		
		fast_attack = new Unit_Type("Fast Attack", new Assault(), new Attack_Bike(), new Bike(), new Drop_Pod(), 
				      new Land_Speeder(), new Land_Speeder_Storm(), new Razorback(), new Rhino(), new Scout_Bike(),  
				      new Stormhawk_Interceptor(), new Stormtalon_Gunship()); 
		
		heavy_support = new Unit_Type("Heavy Support", new Centurion_Devastator(), new Devastator(), new Hunter(), 
				        new Land_Raider(), new Land_Raider_Crusader(), new Land_Raider_Redeemer(), new Predator(), 
				        new Stalker(), new Stormraven_Gunship(), new Thunderfire_Cannon(), new Vindicator(),
				        new Whirlwind());
		
	
			
				
		ObservableList<Unit_Type> unitTypeOList = FXCollections.observableArrayList(HQ, troops, elites, fast_attack, heavy_support); //create an observable list of unit types
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
		//unitTypeCombo.getSelectionModel().selectFirst(); //automatically select the first item from the UnitTypeOList
		
		unitCombo = new ComboBox<Unit>(); //Initialise the unitCombo (second ComboBox)
		
		unitTypeCombo.valueProperty().addListener(new ChangeListener<Unit_Type>() //populates the unitCombo (second ComboBox) based on the unit type chosen
		{
		    @Override
		    public void changed(ObservableValue<? extends Unit_Type> observable, Unit_Type oldValue, Unit_Type newValue) 
		    {
		        unitCombo.setItems(newValue == null ? FXCollections.emptyObservableList() : newValue.getUnitsForType());
		        unitCombo.getSelectionModel().selectFirst(); //Selects the first unit in the unitCombo (second ComboBox)
		    }
		});
				    				
		unitWeaponCombo = new ComboBox<>();
		unitSecondWeaponCombo = new ComboBox<>();
		
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
				unitWeaponCombo.setItems(newValue == null ? FXCollections.emptyObservableList() : newValue.getUnit(1).getUnitWeapons());
				unitSecondWeaponCombo.setItems(newValue == null ? FXCollections.emptyObservableList() : newValue.getUnit(1).getUnitSecondWeapons());
				unitWeaponCombo.getSelectionModel().selectFirst();
				unitSecondWeaponCombo.getSelectionModel().selectFirst();
		    }			
		});*/
							
		unitNameTf = new TextField(); //Initialise the unit name TextField
						
		addUnitBtn = new Button("Add Unit");
		
		armyList = FXCollections.observableArrayList();
		lv = new ListView<>(armyList);
		lv.setEditable(false); //ensures a user can't edit the TextArea
		lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		lv.setPrefSize(500, 750);
		//lv.setStyle("-fx-background-color: ;");
		
		addUnitMemberBtn = new Button("Add Unit Member (+)");
		removeUnitMemberBtn = new Button("Remove Unit Member (-)");
		unitMemberSelectedCombo = new ComboBox<>();
		unitMemberSelectedCombo.setItems(unitMemberSelectedOlist);
		upgradeUnitWeaponBtn = new Button("Upgrade Unit Weapon");
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
	
	public Unit_Type getUnitType() //returns the selected unit type from the unitTypeCombo (first ComboBox)
	{
		return unitTypeCombo.getSelectionModel().getSelectedItem();		
	}
	
	public Unit getUnit() //returns the selected unit from the unitCombo (second ComboBox)
	{
		return unitCombo.getSelectionModel().getSelectedItem();
	}
		
	public Integer getUnitSize() //returns the selected unit size from the unitSizeCombo (third ComboBox)
	{
		return null;
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
	public void setDefaultValues() //clears the combo boxes when the add button is pressed
	{
		unitTypeCombo.getSelectionModel().clearSelection();
		unitNameTf.clear();		
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
}
