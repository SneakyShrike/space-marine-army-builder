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
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import troops.scout.Scout;
import troops.tactical.Tactical;
import wargear.weapon.Weapon;


public class UpdateUnitPane extends GridPane 
{
	private Label unitTypeLbl, unitLbl, unitNameLbl, unitMemberLbl, WeaponLbl;

	private ComboBox<Unit_Type> unitTypeCombo; 
	private ComboBox<Unit> unitCombo;
	private ComboBox<String> unitNameCombo;
	private ComboBox<Integer> unitMemberCombo;
	private ComboBox<Weapon> weaponCombo;
	private Button applyUpgradeBtn;
	
	private Unit_Type HQ, troops, elites, fast_attack, heavy_support;
			
	private ObservableList<String> unitNames;
	
	public UpdateUnitPane()
	{
		this.setVgap(15);
		this.setHgap(20);
		this.setAlignment(Pos.CENTER);
		
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setHalignment(HPos.RIGHT);
		
		this.getColumnConstraints().add(col1);
		
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
		
		ObservableList<Unit_Type> unitTypeOList = FXCollections.observableArrayList(HQ, troops, elites, fast_attack, heavy_support);
				
		unitNames = FXCollections.observableArrayList();
		//ObservableList<String> unitNameList = FXCollections.observableArrayList(unitName);
		
		//ObservableList<Weapon> WeaponOList = FXCollections.observableArrayList(WeaponList.getRanged("Boltgun")); //create an observable list of unit types

		
		unitTypeLbl = new Label("Select The Unit Type: "); //Initialise all of the labels
		unitLbl = new Label("Select The Unit: ");
		unitNameLbl = new Label("Select The Unit Name: ");
		unitMemberLbl = new Label("Select a Unit Member To Upgrade:");
		WeaponLbl = new Label("Select A Weapon Upgrade: ");
		
		unitTypeCombo = new ComboBox<Unit_Type>(); //Initialise the unitTypeCombo (first ComboBox)
		unitTypeCombo.setItems(unitTypeOList);		

		
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


				
		unitNameCombo = new ComboBox<String>(unitNames);
		//unitNameCombo.setItems(unitName);
			
		unitMemberCombo = new ComboBox<>();	
		
		weaponCombo = new ComboBox<Weapon>();
		
		unitCombo.valueProperty().addListener(new ChangeListener<Unit>() //unitSizeCombo (third ComboBox) based on the Unit Chosen
				{
					@Override
					public void changed(ObservableValue<? extends Unit> observable, Unit oldValue, Unit newValue) 
					{												
						weaponCombo.setItems(newValue == null ? FXCollections.emptyObservableList() : newValue.getUnitWeapons());
						weaponCombo.getSelectionModel().selectFirst(); //Selects the first size value of the unitSizeCombo (third ComboBox) 		
				    }			
				});
		
		unitCombo.valueProperty().addListener(new ChangeListener<Unit>() //unitSizeCombo (third ComboBox) based on the Unit Chosen
				{
					@Override
					public void changed(ObservableValue<? extends Unit> observable, Unit oldValue, Unit newValue) 
					{												
						//unitNameCombo.setItems(newValue == null ? FXCollections.emptyObservableList() : newValue.getUnitWeapons());
						unitNameCombo.getSelectionModel().selectFirst(); //Selects the first size value of the unitSizeCombo (third ComboBox) 		
				    }			
				});
		
				
		//weaponCombo.setItems(WeaponOList);
		
				
		applyUpgradeBtn = new Button("Apply Upgrade");

		
		this.add(unitTypeLbl, 0, 0);
		this.add(unitTypeCombo, 1, 0);
		
		this.add(unitLbl, 0, 1);
		this.add(unitCombo, 1, 1);
		
		this.add(unitNameLbl, 0, 2);
		this.add(unitNameCombo, 1, 2);
		
		this.add(unitMemberLbl, 0, 3);
		this.add(unitMemberCombo, 1, 3);
		
		this.add(WeaponLbl, 0, 4);
		this.add(weaponCombo, 1, 4);
		
		this.add(new HBox(), 0, 5);
		this.add(applyUpgradeBtn, 1, 5);
						
	}
		
	public String getUnitName()
	{
		return unitNameCombo.getSelectionModel().getSelectedItem();
	}
	
	public Weapon getWeapon()
	{
		return weaponCombo.getSelectionModel().getSelectedItem();
	}
	
	public void setUnitNameCombo(String name)
	{
		unitNames.add(name);
	}
	
	public void getUniNameCombo()
	{
		System.out.println("unitNamme is " + unitNames);
	}
		
	public void UpgradeUnitHandler(EventHandler<ActionEvent> handler)
	{
		applyUpgradeBtn.setOnAction(handler);		
	}
}
