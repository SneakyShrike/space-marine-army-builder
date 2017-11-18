package gui.view;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import elites.Dreadnought;
import elites.Ironclad_Dreadnought;
import elites.Venerable_Dreadnought;
import elites.assault_terminator.Assault_Terminator;
import elites.centurion_assault.Centurion_Assault;
import elites.command.Command;
import elites.honour_guard.Honour_Guard;
import elites.sternguard.Sternguard_Veteran;
import elites.terminator.Terminator;
import elites.vanguard.Vanguard_Veterans;
import fast_attack.Attack_Bike;
import fast_attack.Stormhawk_Interceptor;
import fast_attack.Stormtalon_Gunship;
import fast_attack.assault.Assault;
import fast_attack.bike.Bike;
import fast_attack.land_speeder.Land_Speeder;
import fast_attack.scout_bike.Scout_Bike;
import gui.model.Unit;
import gui.model.Unit_Type;
import heavy_support.Hunter;
import heavy_support.Land_Raider;
import heavy_support.Land_Raider_Crusader;
import heavy_support.Land_Raider_Redeemer;
import heavy_support.Predator;
import heavy_support.Stalker;
import heavy_support.Stormraven_Gunship;
import heavy_support.Vindicator;
import heavy_support.Whirlwind;
import heavy_support.centurion_devastator.Centurion_Devastator;
import heavy_support.devastator.Devastator;
import heavy_support.thunderfire_cannon.Thunderfire_Cannon;
import hq.Captain;
import hq.Chaplain;
import hq.Librarian;
import hq.Techmarine;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import troops.scout.Scout;
import troops.tactical.Tactical;

public class AddUnitPane extends GridPane
{
	private Label unitTypeLbl, unitLbl, squadNameLbl, squadSizeLbl;
	private ComboBox<Unit_Type> unitTypeCombo; 
	private ComboBox<Unit> unitCombo;
	private ComboBox<Integer> unitSizeCombo;
	private TextField unitNameTf;
	private Button addUnitBtn;
	
	private Unit_Type infantryCharacater, infantry, vehicleWalker, bike, vehicleTransport, vehicleSkimmer, 
	artillery, vehicleTank, vehicleFlyer, HQ, troops, elites, fast_attack, heavy_support;
	
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
		
		elites = new Unit_Type("Elites", new Dreadnought(), new Ironclad_Dreadnought(), new Venerable_Dreadnought(), new Assault_Terminator(),
				new Terminator(), new Sternguard_Veteran(), new Vanguard_Veterans(), new Centurion_Assault(), new Command(), new Honour_Guard());
		
		fast_attack = new Unit_Type("Fast Attack", new Stormhawk_Interceptor(), new Stormtalon_Gunship(), new Land_Speeder(), new Bike(), 
				new Scout_Bike(), new Attack_Bike(), new Assault()); 
		
		heavy_support = new Unit_Type("Heavy Support", new Hunter(), new Stalker(), new Whirlwind(), new Vindicator(), new Predator(), 
				new Stormraven_Gunship(), new Land_Raider(), new Land_Raider_Crusader(), new Land_Raider_Redeemer(), new Centurion_Devastator(),
				new Devastator(), new Thunderfire_Cannon());
		
		//initialise all the Unit types, by naming them and populating them with Units
		
        /*infantryCharacater = new Unit_Type("Infantry (Characater)", new Unit("Captain"), new Unit("Librarian"), 
        		new Unit("Techmarine"), new Unit("Chaplin"), new Unit("Marneus Calgar"));
        
        infantry = new Unit_Type("Infantry", new Unit("Tactical Squad"), new Unit("Scout Squad"), 
        		new Unit("Crusader Squad"), new Unit("Command Squad"), new Unit("Honour Guard"),
        		new Unit("Centurion Assault Squad"), new Unit("Vanguard Veteran Squad"), new Unit("Sternguard Veteran Squad"),
        		new Unit("Legion Of The Damned"), new Unit("Terminator Squad"), new Unit("Terminator Assault Squad"),
        		new Unit("Assault Squad"), new Unit("Devastator Squad"), new Unit("Centurion Devastator Squad"));
        
        vehicleWalker = new Unit_Type("Vehicle (Walker)", new Unit("Dreadnoughts"), new Unit("Venerable Dreadnoughts"),
        		new Unit("Ironclad Dreadnoughts"));
        
        bike = new Unit_Type("Bike", new Unit("Scout Bike Squad"), new Unit("Bike Squad"),
        		new Unit("Attack Bike Squad"));
        
        vehicleTransport = new Unit_Type("Vehicle (Transport)", new Unit("Drop Pod"));
        
        vehicleSkimmer = new Unit_Type("Vehicle (Skimmer)", new Unit("Land Speeders"), new Unit("Land Speeder Storm"));
        
        vehicleFlyer = new Unit_Type("Vehicle (Flyer)", new Unit("Stormraven Gunship"), new Unit("Stormtalon Gunship"));
                
        artillery = new Unit_Type("Artillery", new Unit("Thunderfire Cannons"));
        
        vehicleTank = new Unit_Type("Vehicle (Tank)", new Unit("Predators"), new Unit("Whirlwinds"), 
        		new Unit("Vindicators"), new Unit("Predators"), new Unit("Hunters"), 
        		new Unit("Stalkers"), new Unit("Land Raider"), new Unit("Land Raider Crusader"),
        		new Unit("Land Raider Redeemer"), new Unit("Rhino"), new Unit("Razorback"));
	
		ObservableList<Unit_Type> unitTypeOList = FXCollections.observableArrayList(infantryCharacater, infantry, vehicleWalker, 
				bike, vehicleTransport, vehicleSkimmer, vehicleFlyer, artillery, vehicleTank); //add each Unit_Type to an Observable List*/
		
		ObservableList<Unit_Type> unitTypeOList = FXCollections.observableArrayList(HQ, troops, elites, fast_attack, heavy_support);
			
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
							
		unitTypeLbl = new Label("Select The Unit Type: "); //Initialise all of the labels
		unitLbl = new Label("Select The Unit: ");
		squadNameLbl = new Label("Type The Unit Name: ");
		squadSizeLbl = new Label("Select The Unit Size");
		
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
				        
		unitTypeCombo = new ComboBox<Unit_Type>(); //Initialise the unitTypeCombo (first ComboBox)
		unitTypeCombo.setItems(unitTypeOList); //Populate the unitTypeCombo with the UnitTypeOList (observable list) from line 84
		//unitTypeCombo.getSelectionModel().selectFirst();
		
		unitCombo = new ComboBox<>(); //Initialise the unitCombo (second ComboBox)
		
		unitTypeCombo.valueProperty().addListener(new ChangeListener<Unit_Type>() //populates the unitCombo (second ComboBox) based on the unit type chosen
		{
		    @Override
		    public void changed(ObservableValue<? extends Unit_Type> observable, Unit_Type oldValue, Unit_Type newValue) 
		    {
		        unitCombo.setItems(newValue == null ? FXCollections.emptyObservableList() : newValue.getUnitsForType());
		        unitCombo.getSelectionModel().selectFirst();
		    }
		});
				    	
		unitNameTf = new TextField(); //Initialise the unit name TextField
		
		unitSizeCombo = new ComboBox<>(); //Initialise the unit size ComboBox (third ComboBox)
		
		unitCombo.valueProperty().addListener(new ChangeListener<Unit>() //size ComboBox (third ComboBox) based on the Unit Chosen
		{
			@Override
			public void changed(ObservableValue<? extends Unit> observable, Unit oldValue, Unit newValue) 
			{												
				unitSizeCombo.setItems(newValue == null ? FXCollections.emptyObservableList() : newValue.getUnitSize());
				unitSizeCombo.getSelectionModel().selectFirst();
		    }
		});
		
		addUnitBtn = new Button("Add Unit");
	
		this.add(unitTypeLbl, 0, 1);
		this.add(unitTypeCombo, 1, 1);
		
		this.add(unitLbl, 0, 2);
		this.add(unitCombo, 1, 2);
		
		this.add(squadNameLbl, 0, 3);
		this.add(unitNameTf, 1, 3);
		
		this.add(squadSizeLbl, 0, 4);
		this.add(unitSizeCombo, 1, 4);
		
		this.add(new HBox(), 0, 5);
		this.add(addUnitBtn, 1, 5);		
	}
	
	public Unit_Type getUnitType()
	{
		return unitTypeCombo.getSelectionModel().getSelectedItem();		
	}
	
	public Unit getUnit()
	{
		return unitCombo.getSelectionModel().getSelectedItem();
	}
	
	public String getUnitName()
	{
		return unitNameTf.getText();
	}
	
	public Integer getUnitSize()
	{
		return unitSizeCombo.getSelectionModel().getSelectedItem();
	}
		
	public void AddUnitHandler(EventHandler<ActionEvent> handler)
	{
		addUnitBtn.setOnAction(handler);		
	}
	
	public void setDefaultValues()
	{
		unitTypeCombo.getSelectionModel().clearSelection();
		unitNameTf.clear();
		
	}
}
