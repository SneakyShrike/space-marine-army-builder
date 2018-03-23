package gui.controller;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import elites.centurion_assault.Centurion_AssaultSquad;
import elites.command.CommandSquad;
import elites.deadnought.DreadnoughtSquad;
import elites.terminator.TerminatorSquad;
import elites.terminator_assault.Terminator_AssaultSquad;
import gui.model.Army;
import gui.model.ArmyBuilderProfile;
import gui.model.Unit;
import gui.model.UnitSquad;
import gui.view.AddUnitPane;
import gui.view.ArmyBuilderMenuBar;
import gui.view.ArmyBuilderRootPane;
import gui.view.ArmyDisplayPane;
import gui.view.CreateProfilePane;
import gui.view.UpdateUnitPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import troops.scout.ScoutSergeant;
import troops.scout.ScoutSquad;
import troops.tactical.Tactical;
import troops.tactical.TacticalSquad;

public class ArmyBuilderController 
{
	private ArmyBuilderRootPane view;
	private ArmyBuilderMenuBar mb;
	private CreateProfilePane cp;
	private AddUnitPane au;
	private UpdateUnitPane uu;
	private ArmyDisplayPane dp;
	
	private Army model;
	
	public ArmyBuilderController(ArmyBuilderRootPane view, Army model)
	{
		this.view = view;
		this.model = model;
		
		mb = view.getArmyBuilderMenuBar();
		cp = view.getCreateProfilePane();
		au = view.getAddUnitPane();
		uu = view.getUpdateUnitPane();
		dp = view.getArmyDisplayPane();
		
		cp.populateMaxPointsComboBox(setupAndGetMaxPoints());
		
		this.attachEventHandlers();	
		this.attachBindings();
	}
	
	private void attachEventHandlers()
	{
		mb.SaveHandler(new SaveHandler());
		mb.LoadHandler(new LoadHandler());
		mb.ExitHandler(new ExitHandler());
		mb.InfoHandler(new InfoHandler());
		cp.CreateProfileHandler(new CreateProfileHandler());
		au.AddUnitHandler(new AddUnitHandler());
		uu.UpgradeUnitHandler(new UpgradeUnitHandler());
		dp.SaveArmyHandler(new SaveArmyHandler());
		dp.removeSquadHandler(new removeSquadHandler());
		dp.clearArmyHandler(new clearArmyHandler());

	}
	
	private void attachBindings() {
		//attaches a binding such that the add button in the view will be disabled whenever either of the text fields in the NamePane are empty
		//bp.addBtnDisableBind(np.isEitherFieldEmpty());

		//Binds model's register collection and view's listview display bidirectionally.
		//If either is updated then the other will automatically mirror these updates.
		//In this case it means we can remove the submit button and all associated functionality.
		model.bindContentBidirectional(dp.getContents());
	}
	
	private ArrayList<Integer> setupAndGetMaxPoints()
	{
		ArrayList<Integer> points = new ArrayList<>();
		
		for (int i = 500; i <=10000; i = i + 500)
		{
			points.add(i);
		}
				
		return points;
	}
			
	private class SaveHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e) 
		{
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("armyObj.dat"));) {

				//write name objects individually as cannot serialize the observable list in register
				for (UnitSquad n : model) {
					oos.writeObject(n);
				}

				oos.writeObject(null);

				oos.flush();

				alertDialogBuilder(AlertType.INFORMATION, "Information Dialog", "Save success", "Register saved to armyObj.dat");
			}
			catch (IOException ioExcep){
				System.out.println("Error saving");
			}												
		}		
	}
	
	private class LoadHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e) 
		{
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("armyObj.dat"));) {

				dp.clearArmyList(); //clear any existing names in view
				
				//read back in names objects individually
				UnitSquad n = null;

				while ((n = (UnitSquad) ois.readObject()) != null) {
					//model.addUnitSquad(n);
				}	

				ois.close(); 
			}
			catch (IOException ioExcep){
				System.out.println("Error loading");
			}
			catch (ClassNotFoundException c) {
				System.out.println("Class Not found");
			}

			alertDialogBuilder(AlertType.INFORMATION, "Information Dialog", "Load success", "Register loaded from armyObj.dat");
									
		}		
	}
	
	private class ExitHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e) 
		{
									
		}		
	}
	
	private class InfoHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e) 
		{
									
		}		
	}
	
	private class CreateProfileHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e) 
		{
			model.setTotalPoints(cp.getSelectedMaxPoints());
			view.setMaxpoints(model.getCurrentPoints(), model.getTotalPoints());
			
					
			view.nextTab(1);			
		}		
	}
	
	private class AddUnitHandler implements EventHandler<ActionEvent> //AddUnit Button handler
	{
		public void handle(ActionEvent e) 
		{
			//UnitSquad squad = new UnitSquad("");
			UnitSquad squad = au.getUnitSquad();
			
			switch(au.getUnit().toString()) //gets the selected unit from the unitCombo (second ComboBox)
			{
			   case "Centurion Assault Squad" : squad = new Centurion_AssaultSquad(au.getUnitName());
			   break;
			   case "Command Squad" : squad = new CommandSquad(au.getUnitName());
			   break;			   
			   case "Dreadnought Squad" : squad = new DreadnoughtSquad(au.getUnitName());
			   break;
			   case "Terminator Squad" : squad = new TerminatorSquad(au.getUnitName());
			   break;
			   case "Terminator Assault Squad" : squad = new Terminator_AssaultSquad(au.getUnitName());
			   break;	
			   case "Scout Squad" : squad = new ScoutSquad(au.getUnitName()); //create a new scoutSquad with the inputed name		                            //squad.addUnit(new ScoutSergeant()); //add a scout sergeant to the scout squad
			   break;
			   case "Tactical Squad" : squad = new TacticalSquad(au.getUnitName());
				
			}
			
			squad.addUnitSquad(au.getUnitSize());
			squad.weaponUpgrade(au.getUnitWeapon(), au.getUnitAmountSelected());
			switch(au.getUnit().toString())
			{
			   case "Centurion Assault Squad" : 
			   case "Command Squad" : 		   
			   case "Dreadnought Squad" : 
				   squad.secondWeaponUpgrade(au.getUnitSecondWeapon(), au.getUnitAmountSelected());
			  break;				
			}			
					
			model.addUnitSquad(squad);
			model.setCurrentPoints(squad.getSquadPoints());
            view.setMaxpoints(model.getCurrentPoints(), model.getTotalPoints());
					
			au.setDefaultValues();

			view.nextTab(3);
						
		}		
	}
	
	private class UpgradeUnitHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e) 
		{
			
			
									
		}		
	}
	
	private class SaveArmyHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e) 
		{
									
		}		
	}
	
	private class removeSquadHandler implements EventHandler<ActionEvent>
	{
		//UnitSquad squad = new UnitSquad("");
		
		public void handle(ActionEvent e) 
		{
			int value = model.getCurrentPoints() - dp.getSelectedUnitSquad().getSquadPoints();
			dp.removeSelectedUnitSquad();
			model.setCurrentPoints(value);
			view.setMaxpoints(model.getCurrentPoints(), model.getTotalPoints());
		}		
	}
	
	private class clearArmyHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e) 
		{
			dp.clearArmyList();
			model.setCurrentPoints(0);
			view.setMaxpoints(0, model.getTotalPoints());
		}		
	}
	
	private void alertDialogBuilder(AlertType type, String title, String header, String content) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}
}
