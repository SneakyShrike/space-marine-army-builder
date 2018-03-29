package gui.controller;


import java.io.FileInputStream;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import elites.centurion_assault.Centurion_Assault;
import elites.centurion_assault.Centurion_AssaultSquad;
import elites.command.Command;
import elites.command.CommandSquad;
import elites.deadnought.Dreadnought;
import elites.deadnought.DreadnoughtSquad;
import elites.honour_guard.Honour_Guard;
import elites.honour_guard.Honour_GuardSquad;
import elites.ironclad_dreadnought.Ironclad_Dreadnought;
import elites.ironclad_dreadnought.Ironclad_DreadnoughtSquad;
import elites.sternguard_veteran.Sternguard_Veteran;
import elites.sternguard_veteran.Sternguard_VeteranSquad;
import elites.terminator.Terminator;
import elites.terminator.TerminatorSquad;
import elites.terminator_assault.Terminator_Assault;
import elites.terminator_assault.Terminator_AssaultSquad;
import elites.venerable_dreadnought.Venerable_Dreadnought;
import elites.venerable_dreadnought.Venerable_DreadnoughtSquad;
import gui.model.Army;
import gui.model.Unit;
import gui.model.UnitSquad;
import gui.view.AddUnitPane;
import gui.view.ArmyBuilderMenuBar;
import gui.view.ArmyBuilderRootPane;
import gui.view.CreateProfilePane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import troops.scout.Scout;
import troops.scout.ScoutSquad;
import troops.tactical.Tactical;
import troops.tactical.TacticalSquad;

public class ArmyBuilderController 
{
	private ArmyBuilderRootPane view;
	private ArmyBuilderMenuBar mb;
	private CreateProfilePane cp;
	private AddUnitPane au;
	
	private Army model;
	
	public ArmyBuilderController(ArmyBuilderRootPane view, Army model)
	{
		this.view = view;
		this.model = model;
		
		mb = view.getArmyBuilderMenuBar();
		cp = view.getCreateProfilePane();
		au = view.getAddUnitPane();
		
		cp.populateMaxPointsComboBox(setupAndGetMaxPoints());
		
		this.attachEventHandlers();	
		this.attachBindings();
	}
	
	private void attachEventHandlers()
	{
		mb.SaveHandler(new SaveHandler());
		mb.LoadHandler(new LoadHandler());
		mb.InfoHandler(new InfoHandler());
		cp.CreateProfileHandler(new CreateProfileHandler());
		au.AddUnitHandler(new AddUnitHandler());
		au.removeSquadHandler(new removeSquadHandler());
		au.clearArmyHandler(new clearArmyHandler());
		au.addUnitMemberBtn(new addUnitMemberBtn());
		au.removeUnitMemberBtn(new removeUnitMemberBtn());
		au.upgradeUnitWeaponHandler(new upgradeUnitWeaponHandler());
		
	}
	
	private void attachBindings() {
		//attaches a binding such that the add button in the view will be disabled whenever either of the text fields in the NamePane are empty
		//bp.addBtnDisableBind(np.isEitherFieldEmpty());

		//Binds model's register collection and view's listview display bidirectionally.
		//If either is updated then the other will automatically mirror these updates.
		//In this case it means we can remove the submit button and all associated functionality.
		model.bindContentBidirectional(au.getContents());
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
				//for (UnitSquad n : model) {
					///oos.writeObject(n);
				oos.writeObject(model);
				//}

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

				//dp.clearArmyList(); //THIS CAUSES ISSUES WITH LOADING
				
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
			au.setMaxpoints(model.getCurrentPoints(), model.getTotalPoints());
			
					
			view.nextTab(1);			
		}		
	}
	
	private class AddUnitHandler implements EventHandler<ActionEvent> //AddUnit Button handler
	{
		public void handle(ActionEvent e) 
		{
			UnitSquad squad = au.getUnitSquad();
			
			switch(au.getUnit().toString()) //gets the selected unit from the unitCombo (second ComboBox)
			{
			   case "Centurion Assault Squad" : squad = new Centurion_AssaultSquad(au.getUnitName());
			   break;
			   case "Command Squad" : squad = new CommandSquad(au.getUnitName());
			   break;			   
			   case "Dreadnought Squad" : squad = new DreadnoughtSquad(au.getUnitName());
			   break;
			   case "Honour Guard Squad" : squad = new Honour_GuardSquad(au.getUnitName());
			   break;
			   case "Ironclad Dreadnought Squad" : squad = new Ironclad_DreadnoughtSquad(au.getUnitName());
			   break;
			   case "Sternguard Veteran Squad" : squad = new Sternguard_VeteranSquad(au.getUnitName());
			   break;
			   case "Terminator Squad" : squad = new TerminatorSquad(au.getUnitName());
			   break;
			   case "Terminator Assault Squad" : squad = new Terminator_AssaultSquad(au.getUnitName());
			   break;
			   case "Venerable Dreadnought Squad" : squad = new Venerable_DreadnoughtSquad(au.getUnitName());
			   break;	
			   case "Scout Squad" : squad = new ScoutSquad(au.getUnitName()); //create a new scoutSquad with the inputed name		                            //squad.addUnit(new ScoutSergeant()); //add a scout sergeant to the scout squad
			   break;
			   case "Tactical Squad" : squad = new TacticalSquad(au.getUnitName());				
			}
			
			squad.addUnitSquad();			
					
			model.addUnitSquad(squad);
			model.setCurrentPoints(squad.getSquadPoints());
            au.setMaxpoints(model.getCurrentPoints(), model.getTotalPoints());					
			//au.setDefaultValues();
					
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
			int value = model.getCurrentPoints() - au.getSelectedUnitSquad().getSquadPoints();
			au.removeSelectedUnitSquad();
			model.setCurrentPoints(value);
			au.setMaxpoints(model.getCurrentPoints(), model.getTotalPoints());
		}		
	}
	
	private class clearArmyHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e) 
		{
			au.clearArmyList();
			model.setCurrentPoints(0);
			au.setMaxpoints(0, model.getTotalPoints());
		}		
	}
		
	private class addUnitMemberBtn implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e) 
		{
			UnitSquad squad = au.getSelectedUnitSquad();
			Unit member = new Unit();
			switch(au.getUnit().toString()) //gets the selected unit from the unitCombo (second ComboBox)
			{
			   case "Centurion Assault Squad" : member = new Centurion_Assault();
			   break;
			   case "Command Squad" : member = new Command();
			   break;			   
			   case "Dreadnought Squad" : member = new Dreadnought();
			   break;
			   case "Honour Guard Squad" : member = new Honour_Guard();
			   break;
			   case "Ironclad Dreadnought Squad" : member = new Ironclad_Dreadnought();
			   break;
			   case "Sternguard Veteran Squad" : member = new Sternguard_Veteran();
			   break;
			   case "Terminator Squad" : member = new Terminator();
			   break;
			   case "Terminator Assault Squad" : member = new Terminator_Assault();
			   break;
			   case "Venerable Dreadnought Squad" : member = new Venerable_Dreadnought();
			   break;	
			   case "Scout Squad" : member = new Scout(); //create a new scoutSquad with the inputed name		                            //squad.addUnit(new ScoutSergeant()); //add a scout sergeant to the scout squad
			   break;
			   case "Tactical Squad" : member = new Tactical();				
			}
			squad.addUnit(member);
			au.setSizeCheckMessage(squad.SquadSizeCheck());
			model.updatUnitSquad(au.getSelectedUnitSquadIndex(), squad);
			model.setCurrentPoints(squad.getSquadPoints());
            au.setMaxpoints(model.getCurrentPoints(), model.getTotalPoints());
		}		
	}
	
	private class removeUnitMemberBtn implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e) 
		{
			UnitSquad squad = au.getSelectedUnitSquad();
			squad.removeUnit(squad.getLastIndex());
			au.setSizeCheckMessage(squad.SquadSizeCheck());
			model.updatUnitSquad(au.getSelectedUnitSquadIndex(), squad);
			int value = model.getCurrentPoints() - squad.getUnit(squad.getLastIndex()).getUnitPoints();
			model.setCurrentPoints(value);
			au.setMaxpoints(model.getCurrentPoints(), model.getTotalPoints());
		}		
	}
	
	private class upgradeUnitWeaponHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e) 
		{
			
			UnitSquad selectedSquad = au.getSelectedUnitSquad();
	        selectedSquad.weaponUpgrade(au.getUnitWeapon(), au.getunitMemberSelected()-1);
	        
	        switch(au.getUnit().toString())
			{
			   case "Centurion Assault Squad" : 
			   case "Command Squad" : 		   
			   case "Dreadnought Squad" :
			   case "Ironclad Dreadnought Squad" :
			   case "Terminator Squad" :
			   case "Venerable Dreadnought Squad" :
			
				   selectedSquad.secondWeaponUpgrade(au.getUnitSecondWeapon(), au.getunitMemberSelected()-1);
			  break;				
			}

	        model.updatUnitSquad(au.getSelectedUnitSquadIndex(), selectedSquad);
	        au.setweaponsCheckMessage(selectedSquad.SquadWeaponsCheck());        
	        model.setCurrentPoints(selectedSquad.getSquadPoints());
            au.setMaxpoints(model.getCurrentPoints(), model.getTotalPoints());	
            selectedSquad.getUnit(au.getSelectedUnitSquadIndex()).resetUnitPoints();

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
