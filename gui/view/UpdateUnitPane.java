package gui.view;

import gui.model.Unit;
import gui.model.Unit_Type;
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
	
	private Unit_Type infantryCharacater, infantry, vehicleWalker, bike, vehicleTransport, vehicleSkimmer, 
	artillery, vehicleTank, vehicleFlyer;
	
	private ObservableList<String> unitNames;
	
	public UpdateUnitPane()
	{
		this.setVgap(15);
		this.setHgap(20);
		this.setAlignment(Pos.CENTER);
		
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setHalignment(HPos.RIGHT);
		
		this.getColumnConstraints().add(col1);
		
		//----------------------------------------------------------------------------------------------------
		
		infantryCharacater = new Unit_Type("Infantry (Characater)", new Unit("Captain"), new Unit("Librarian"), 
        		new Unit("Techmarine"), new Unit("Chaplin"), new Unit("Marneus Calgar"));
        
       /* infantry = new Unit_Type("Infantry", new Unit("Tactical Squad"), new Unit("Scout Squad", 10), 
        		new Unit("Crusader Squad", 10), new Unit("Command Squad", 5), new Unit("Honour Guard", 10),
        		new Unit("Centurion Assault Squad", 6), new Unit("Vanguard Veteran Squad", 10), new Unit("Sternguard Veteran Squad", 10),
        		new Unit("Legion Of The Damned", 10), new Unit("Terminator Squad", 10), new Unit("Terminator Assault Squad", 10),
        		new Unit("Assault Squad", 10), new Unit("Devastator Squad", 10), new Unit("Centurion Devastator Squad", 6));
        
        vehicleWalker = new Unit_Type("Vehicle (Walker)", new Unit("Dreadnoughts", 3), new Unit("Venerable Dreadnoughts", 3),
        		new Unit("Ironclad Dreadnoughts", 3));
        
        bike = new Unit_Type("Bike", new Unit("Scout Bike Squad", 10), new Unit("Bike Squad", 8),
        		new Unit("Attack Bike Squad", 3));
        
        vehicleTransport = new Unit_Type("Vehicle (Transport)", new Unit("Drop Pod"));
        
        vehicleSkimmer = new Unit_Type("Vehicle (Skimmer)", new Unit("Land Speeders", 3), new Unit("Land Speeder Storm"));
        
        vehicleFlyer = new Unit_Type("Vehicle (Flyer)", new Unit("Stormraven Gunship"), new Unit("Stormtalon Gunship"));
                
        artillery = new Unit_Type("Artillery", new Unit("Thunderfire Cannons", 3));
        
        vehicleTank = new Unit_Type("Vehicle (Tank)", new Unit("Predators", 3), new Unit("Whirlwinds", 3), 
        		new Unit("Vindicators", 3), new Unit("Predators", 3), new Unit("Hunters", 3), 
        		new Unit("Stalkers", 3), new Unit("Land Raider"), new Unit("Land Raider Crusader"),
        		new Unit("Land Raider Redeemer"), new Unit("Rhino"), new Unit("Razorback"));*/
	
		ObservableList<Unit_Type> unitTypeOList = FXCollections.observableArrayList(infantryCharacater, infantry, vehicleWalker, 
				bike, vehicleTransport, vehicleSkimmer, vehicleFlyer, artillery, vehicleTank);
		
		//--------------------------------------------------------------------------------------------------------------------
		
		unitNames = FXCollections.observableArrayList();
		//ObservableList<String> unitNameList = FXCollections.observableArrayList(unitName);
		
		unitTypeLbl = new Label("Select Unit Type: ");
		unitLbl = new Label("Select The Unit ");
		unitNameLbl = new Label("Select The Unit Name: ");
		unitMemberLbl = new Label("Select a Unit Member To Upgrade:");
		WeaponLbl = new Label("Select A Weapon Upgrade: ");
		
		unitTypeCombo = new ComboBox<>();
		unitTypeCombo.setItems(unitTypeOList);	
		
		unitCombo = new ComboBox<>();
		
		unitTypeCombo.valueProperty().addListener(new ChangeListener<Unit_Type>() //populates the unitCombo (second ComboBox) based on the unit type chosen
				{
				    @Override
				    public void changed(ObservableValue<? extends Unit_Type> observable, Unit_Type oldValue, Unit_Type newValue) 
				    {
				        unitCombo.setItems(newValue == null ? FXCollections.emptyObservableList() : newValue.getUnitsForType());
				        unitCombo.getSelectionModel().selectFirst();
				    }
				});
		
		unitNameCombo = new ComboBox<String>(unitNames);
		//unitNameCombo.setItems(unitName);
		
		
		unitMemberCombo = new ComboBox<>();	
		weaponCombo = new ComboBox<>();
		
		unitCombo.valueProperty().addListener(new ChangeListener<Unit>() //populates the unitCombo (second ComboBox) based on the unit type chosen
				{
				    @Override
				    public void changed(ObservableValue<? extends Unit> observable, Unit oldValue, Unit newValue) 
				    {
				    	//unitNameCombo.setItems(newValue == null ? FXCollections.emptyObservableList() : newValue.toString());
				        //unitNameCombo.getSelectionModel().selectFirst();

                        //unitMemberCombo.setItems(newValue == null ? FXCollections.emptyObservableList() : newValue.getUnitSize());
				    	//weaponCombo.setItems(newValue == null ? FXCollections.emptyObservableList() : newValue.);
				    	
				    	
				    	
				    }
				});
				
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
		return unitNameCombo.getSelectionModel().getSelectedItem();
	}
	
	public Weapon geWeapon()
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
