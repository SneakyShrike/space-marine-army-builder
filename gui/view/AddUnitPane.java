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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import troops.scout.Scout;
import troops.tactical.Tactical;
import wargear.weapon.Weapon;

public class AddUnitPane extends GridPane
{
	private Label unitTypeLbl, unitLbl, unitSizeLbl, unitWeaponLbl, unitSecondWeaponLbl, unitNameLbl;
	private ComboBox<Unit_Type> unitTypeCombo; 
	private ComboBox<Unit> unitCombo;
	private ComboBox<Integer> unitSizeCombo, unitMemberSelectedCombo;
	private ComboBox<Weapon> unitWeaponCombo, unitSecondWeaponCombo;
	private TextField unitNameTf;
	private Button addUnitBtn, addUnitMemberBtn, removeUnitMemberBtn, upgradeUnitWeaponBtn;
	private ListView<UnitSquad> lv;
	private ObservableList<UnitSquad> armyList;
	
	private Unit_Type HQ, troops, elites, fast_attack, heavy_support;
	
	public AddUnitPane()
	{
		this.setVgap(15);
		this.setHgap(20);
		this.setAlignment(Pos.CENTER);
		
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setHalignment(HPos.RIGHT);
		
		this.getColumnConstraints().add(col1);
		
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
        ObservableList<Integer> unitMemberSelectedOlist = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9);	
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
							
		unitTypeLbl = new Label("Select The Unit Type: "); //Initialise all of the labels
		unitLbl = new Label("Select The Unit: ");
		unitSizeLbl = new Label("Select The Unit Size: ");
		unitWeaponLbl = new Label("Select The Unit Members Weapon Upgrade: ");
		unitSecondWeaponLbl = new Label("Select The Unit Members Second Weapon Upgrade: ");
		unitNameLbl = new Label("Type The Unit Name: ");
		
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
				    		
		unitSizeCombo = new ComboBox<>(); //Initialise the unit unitSizeCombo (third ComboBox)
		
		//unitAmountSelectedCombo = new ComboBox<>();
	    //unitAmountSelectedCombo.setItems(unitAmountSelectedOlist);
		unitWeaponCombo = new ComboBox<>();
		unitSecondWeaponCombo = new ComboBox<>();
		
		unitCombo.valueProperty().addListener(new ChangeListener<Unit>() //unitSizeCombo (third ComboBox) based on the Unit Chosen
		{
			@Override
			public void changed(ObservableValue<? extends Unit> observable, Unit oldValue, Unit newValue) 
			{												
				unitSizeCombo.setItems(newValue == null ? FXCollections.emptyObservableList() : newValue.getUnitSize());
				unitSizeCombo.getSelectionModel().selectFirst(); //Selects the first size value of the unitSizeCombo (third ComboBox)
				unitWeaponCombo.setItems(newValue == null ? FXCollections.emptyObservableList() : newValue.getUnitWeapons());
				unitSecondWeaponCombo.setItems(newValue == null ? FXCollections.emptyObservableList() : newValue.getUnitSecondWeapons());
				unitWeaponCombo.getSelectionModel().selectFirst();
				unitSecondWeaponCombo.getSelectionModel().selectFirst();
				//unitAmountSelectedCombo.setItems(newValue == null ? FXCollections.emptyObservableList() 
						//: newValue.getWeaponUpgradeAmount(unitSizeCombo.getSelectionModel().getSelectedItem()));
				//unitAmountSelectedCombo.getSelectionModel().selectFirst(); //Selects the first size value of the unitSizeCombo (third ComboBox)
		    }			
		});
		
				
		/*unitSizeCombo.valueProperty().addListener(new ChangeListener<Integer>() //unitSizeCombo (third ComboBox) based on the Unit Chosen
		{
			@Override
			public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) 
			{												
				unitAmountSelectedCombo.setItems(unitAmountSelectedOlist);
				unitAmountSelectedCombo.getSelectionModel().selectFirst(); //Selects the first size value of the unitSizeCombo (third ComboBox)
			}			
		});*/
		
					
		unitNameTf = new TextField(); //Initialise the unit name TextField
						
		addUnitBtn = new Button("Add Unit");
		
		armyList = FXCollections.observableArrayList();
		lv = new ListView<>(armyList);
		lv.setEditable(false); //ensures a user can't edit the TextArea
		lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		lv.setPrefSize(400, 400);
		
		addUnitMemberBtn = new Button("Add Unit Member (+)");
		removeUnitMemberBtn = new Button("Remove Unit Member (-)");
		unitMemberSelectedCombo = new ComboBox<>();
		unitMemberSelectedCombo.setItems(unitMemberSelectedOlist);
		upgradeUnitWeaponBtn = new Button("Upgrade Unit Weapon");
	
		this.add(unitTypeLbl, 0, 1);
		this.add(unitTypeCombo, 1, 1);
		
		this.add(unitLbl, 0, 2);
		this.add(unitCombo, 1, 2);
		
		this.add(unitSizeLbl, 0, 3);
		this.add(unitSizeCombo, 1, 3);
			
		//this.add(unitAmountSelectedLbl, 0, 4);
		//this.add(unitAmountSelectedCombo, 1, 4);
		
		this.add(unitNameLbl, 0, 4);
		this.add(unitNameTf, 1, 4);
				
		this.add(new HBox(), 0, 5);
		this.add(addUnitBtn, 1, 5);	
		
		this.add(lv, 0, 7);
		
		this.add(new HBox(), 0, 8);
		this.add(addUnitMemberBtn, 1, 8);	
		
		this.add(new HBox(), 0, 9);
		this.add(removeUnitMemberBtn, 1, 9);
		
		//this.add(unitWeaponLbl, 0, 10);
		this.add(unitMemberSelectedCombo, 1, 10);
		
		this.add(unitWeaponLbl, 0, 11);
		this.add(unitWeaponCombo, 1, 11);
		
		this.add(unitSecondWeaponLbl, 0, 12);
		this.add(unitSecondWeaponCombo, 1, 12);
		
		this.add(new HBox(), 1, 12);
		this.add(upgradeUnitWeaponBtn, 2, 12);
		
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
		return unitSizeCombo.getSelectionModel().getSelectedItem();
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
		//unitWeaponCombo.setOnAction(handler);
	}
	
	public UnitSquad getUnitSquad()
	{
		return new UnitSquad(unitNameTf.getText());
		
	}
	
	/*public void setunitAmountSelected()
	{
		for (int i = 1; i < unitSizeCombo.getSelectionModel().getSelectedItem(); i++)
		{
			unitAmountSelectedCombo.setI
			
		}
		
	}*/
	public void setDefaultValues() //clears the combo boxes when the add button is pressed
	{
		unitTypeCombo.getSelectionModel().clearSelection();
		unitNameTf.clear();		
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
		//unitWeaponCombo.setOnAction(handler);
	}
}
