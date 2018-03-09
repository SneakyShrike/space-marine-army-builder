package gui.controller;


import java.util.ArrayList;


import gui.model.ArmyBuilderProfile;
import gui.view.AddUnitPane;
import gui.view.ArmyBuilderMenuBar;
import gui.view.ArmyBuilderRootPane;
import gui.view.ArmyDisplayPane;
import gui.view.CreateProfilePane;
import gui.view.UpdateUnitPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	
	private ArmyBuilderProfile model;
	
	public ArmyBuilderController(ArmyBuilderRootPane view, ArmyBuilderProfile model)
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
			
									
		}		
	}
	
	private class LoadHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e) 
		{
									
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
			model.setProfileName(cp.getProfileName());
			model.setMaxPoints(cp.getSelectedMaxPoints());  
			model.setDate(cp.getprofileDate());
		
			view.nextTab(1);			
		}		
	}
	
	private class AddUnitHandler implements EventHandler<ActionEvent> //AddUnit Button handler
	{
		public void handle(ActionEvent e) 
		{
			ScoutSquad scouts;
			TacticalSquad tactical;
			
			switch(au.getUnit().toString()) //gets the selected unit from the unitCombo (second ComboBox)
			{
			case "Scout Squad" : scouts = new ScoutSquad(au.getUnitName()); //create a new scoutSquad with the inputed name
			                     scouts.addScout(new ScoutSergeant()); //add a scout sergeant to the scout squad
			                     scouts.addScoutSquad(au.getUnitSize()-1);	/*then add as many scouts as specified by the user, then -1 to compensate for the scout sergeant*/	  										
			                     scouts.weaponUpgrade(au.getUnitWeapon(), au.getUnitAmountSelected());
			                     dp.setDisplayInput(scouts.getScoutSquad()); //display the results of the newly created scout squad to the display pane
			                     

			break;
			case "Tactical Squad" : tactical = new TacticalSquad(au.getUnitName());
			                        tactical.addTacticalSquad(new Tactical(), au.getUnitSize());
			                        dp.setDisplayInput(tactical.getTacticalSquad());

			}
			
			
		
			au.setDefaultValues();			
			//view.nextTab(2);
						
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
}
