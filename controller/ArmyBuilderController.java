package controller;


import java.io.FileInputStream;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Army;
import model.Unit;
import model.UnitSquad;
import model.elites.centurion_assault.Centurion_Assault;
import model.elites.centurion_assault.Centurion_AssaultSquad;
import model.elites.command.Command;
import model.elites.command.CommandSquad;
import model.elites.deadnought.Dreadnought;
import model.elites.deadnought.DreadnoughtSquad;
import model.elites.honour_guard.Honour_Guard;
import model.elites.honour_guard.Honour_GuardSquad;
import model.elites.ironclad_dreadnought.Ironclad_Dreadnought;
import model.elites.ironclad_dreadnought.Ironclad_DreadnoughtSquad;
import model.elites.sternguard_veteran.Sternguard_Veteran;
import model.elites.sternguard_veteran.Sternguard_VeteranSquad;
import model.elites.terminator.Terminator;
import model.elites.terminator.TerminatorSquad;
import model.elites.terminator_assault.Terminator_Assault;
import model.elites.terminator_assault.Terminator_AssaultSquad;
import model.elites.vanguard_veteran.Vanguard_Veteran;
import model.elites.vanguard_veteran.Vanguard_VeteranSquad;
import model.elites.venerable_dreadnought.Venerable_Dreadnought;
import model.elites.venerable_dreadnought.Venerable_DreadnoughtSquad;
import model.fast_attack.assault.Assault;
import model.fast_attack.assault.AssaultSquad;
import model.fast_attack.attack_bike.Attack_Bike;
import model.fast_attack.attack_bike.Attack_BikeSquad;
import model.fast_attack.bike.Bike;
import model.fast_attack.bike.BikeSquad;
import model.fast_attack.drop_pod.Drop_Pod;
import model.fast_attack.drop_pod.Drop_PodSquad;
import model.fast_attack.land_speeder.Land_Speeder;
import model.fast_attack.land_speeder.Land_SpeederSquad;
import model.fast_attack.land_speeder_storm.Land_Speeder_Storm;
import model.fast_attack.land_speeder_storm.Land_Speeder_StormSquad;
import model.fast_attack.razorback.Razorback;
import model.fast_attack.razorback.RazorbackSquad;
import model.fast_attack.rhino.Rhino;
import model.fast_attack.rhino.RhinoSquad;
import model.fast_attack.scout_bike.Scout_Bike;
import model.fast_attack.scout_bike.Scout_BikeSquad;
import model.fast_attack.stormhawk_interceptor.Stormhawk_Interceptor;
import model.fast_attack.stormhawk_interceptor.Stormhawk_InterceptorSquad;
import model.fast_attack.stormtalon_gunship.Stormtalon_Gunship;
import model.fast_attack.stormtalon_gunship.Stormtalon_GunshipSquad;
import model.heavy_support.centurion_devastator.Centurion_Devastator;
import model.heavy_support.centurion_devastator.Centurion_DevastatorSquad;
import model.heavy_support.devastator.Devastator;
import model.heavy_support.devastator.DevastatorSquad;
import model.heavy_support.hunter.Hunter;
import model.heavy_support.hunter.HunterSquad;
import model.heavy_support.land_raider.Land_Raider;
import model.heavy_support.land_raider.Land_RaiderSquad;
import model.heavy_support.land_raider_crusader.Land_Raider_Crusader;
import model.heavy_support.land_raider_crusader.Land_Raider_CrusaderSquad;
import model.heavy_support.land_raider_redeemer.Land_Raider_Redeemer;
import model.heavy_support.land_raider_redeemer.Land_Raider_RedeemerSquad;
import model.heavy_support.predator.Predator;
import model.heavy_support.predator.PredatorSquad;
import model.heavy_support.stalker.Stalker;
import model.heavy_support.stalker.StalkerSquad;
import model.heavy_support.stormraven_gunship.Stormraven_Gunship;
import model.heavy_support.stormraven_gunship.Stormraven_GunshipSquad;
import model.heavy_support.thunderfire_cannon.Thunderfire_Cannon;
import model.heavy_support.thunderfire_cannon.Thunderfire_CannonSquad;
import model.heavy_support.vindicator.Vindicator;
import model.heavy_support.vindicator.VindicatorSquad;
import model.heavy_support.whirlwind.Whirlwind;
import model.heavy_support.whirlwind.WhirlwindSquad;
import model.hq.captain.Captain;
import model.hq.captain.CaptainSquad;
import model.hq.chaplain.Chaplain;
import model.hq.chaplain.ChaplainSquad;
import model.hq.librarian.Librarian;
import model.hq.librarian.LibrarianSquad;
import model.hq.techmarine.Techmarine;
import model.hq.techmarine.TechmarineSquad;
import model.troops.scout.Scout;
import model.troops.scout.ScoutSquad;
import model.troops.tactical.Tactical;
import model.troops.tactical.TacticalSquad;
import view.AddUnitPane;
import view.ArmyBuilderMenuBar;
import view.ArmyBuilderRootPane;
import view.CreateProfilePane;

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
		mb.TextFileHandler(new TextFileHandler());
		mb.PrintHandler(new PrintHandler());
		mb.InfoHandler(new InfoHandler());
		cp.CreateProfileHandler(new CreateProfileHandler());
		au.AddUnitHandler(new AddUnitHandler());
		au.removeSquadHandler(new removeSquadHandler());
		au.clearArmyHandler(new clearArmyHandler());
		au.addUnitMemberBtn(new addUnitMemberBtn());
		au.removeUnitMemberBtn(new removeUnitMemberBtn());
		au.upgradeUnitWeaponHandler(new upgradeUnitWeaponHandler());		
	}
	
	private void attachBindings() 
	{
		model.bindContentBidirectional(au.getContents());
		
		cp.createBtnDisableBind(cp.isProfileNameEmpty());
		au.addUnitBtnDisableBind(au.areAddUnitOptionsEmpty());
		au.unitComboDisableBind(au.isunitTypeComboEmpty());
		au.unitWeaponComboDisableBind(au.isunitMemberSelectedComboEmpty());
		au.upgradeUnitWeaponBtnDisableBind(au.areWeaponUpgradeOptionsEmpty());	
	}
	
	private ArrayList<Integer> setupAndGetMaxPoints()
	{
		ArrayList<Integer> points = new ArrayList<>();
		
		for (int i = 250; i <=5000; i = i + 250)
			points.add(i);
				
		return points;
	}
	
	private ArrayList<Integer> getUnitSize()
	{
		ArrayList<Integer> member = new ArrayList<>();
		
		for (int i = 1; i <= au.getSelectedUnitSquad().getLastIndex() + 1; i++)
			member.add(i);
				
		return member;
	}
	
	private void alertPrompt(AlertType type, String title, String header, String sentence) 
	{
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(sentence);
		alert.showAndWait();
	}
	
	private void pointsValueCheck()
	{
		if (model.getCurrentPoints() > model.getTotalPoints())
        {
			alertPrompt(AlertType.WARNING, "Warning Prompt", "Points Limit Exceeded", "Saving, saving to a text file and printing have been disabled. \n\n"
					+ "The current points value exceeds the set maximum points limit, please reduce it before proceeding.");
            au.setTotalPointsColour("-fx-text-fill: #E53935;");
            mb.disableMenuItems(true);
        }
	    
		else 
		{
			au.setTotalPointsColour("-fx-text-fill: #FFFFFF;");
		    mb.disableMenuItems(false);		    	
		}
	}
			
	private class SaveHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e) 
		{
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("armyObj.dat"));) {

				for (UnitSquad n : model) 
				{ 
					oos.writeObject(model);
				}

				oos.flush();

				alertPrompt(AlertType.INFORMATION, "Information Prompt", "Save success", "Register saved to armyObj.dat");
			}
			catch (IOException ioExcep)
			{
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

			alertPrompt(AlertType.INFORMATION, "Information Prompt", "Load success", "Register loaded from armyObj.dat");
									
		}		
	}
	
	private class PrintHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e) 
		{
									
		}		
	}
	
	private class TextFileHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e) 
		{
			String armyList = "";
			
			armyList += cp.getProfileName()+":" + " Space Marine Army Roster\n\n";
			armyList += "Date Of Creation: " + cp.getprofileDate() + "\n\n";
			armyList += "Total Army Points Cost: " + model.getCurrentPoints() + "\n\n";
			armyList += model.getArmyUnits();
			
			  try 
			  {
				  PrintWriter pw = new PrintWriter(cp.getProfileName()+".txt");

			      pw.print(armyList);

			      pw.flush();
			      alertPrompt(AlertType.INFORMATION, "Information Prompt", "Text File Succesfully Saved", "A copy of your army roster has been saved into " + cp.getProfileName()+".txt");
			  } 
			    
			  catch (Exception ex) 
			  {
				  ex.printStackTrace();
			  }										
		}		
	}
		
	private class InfoHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e) 
		{
			alertPrompt(AlertType.INFORMATION, "Information Prompt", "7th Edition Space Marine Army Roster Builder V1.0", "This program allows you to build an army roster for a 7th Edition Space Marine Army. \n\n"
					+ "First give your army roster a name and choose the maximum points for your army, and then press the Create Profile button which will take you to the next stage \n\n"
					+ "Next you can choose a unit type, and then a unit which you can give a custom name. You can then add the unit to the army roster which will be displayed in the centre panel \n\n"
					+ "From there you can modify a units size by selecting on the unit and pressing the add or remove unit member buttons to add or remove members from the unit. Otherwise you can select a unit"
					+ "member on the right hand side, and choose a weapon upgrade. \n\n"
					+ "Changing both the size and weapons of a unit will be updated in real time on the centre display, and the points at the top will also be updated \n\n"
					+ "Once all the units have been added, you can remove an entire unit from the army roster by selecting the remove unit button at the bottom of the centre display, alternatively"
					+ "you can clear all of the units in an army roster by selecting the clear army button \n\n"
					+ "Finally in the file menu (top left) you can save the army roster and load it back in later, save to an external .txt file, or print out a physical copy of the army roster \n\n"
					+ "Updates can be found on the GitHub page at: https://github.com/GR412/space-marine-army-builder");								
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
			   case "Vanguard Veteran Squad" : squad = new Vanguard_VeteranSquad(au.getUnitName());
			   break;
			   case "Venerable Dreadnought Squad" : squad = new Venerable_DreadnoughtSquad(au.getUnitName());
			   break;
			   case "Assault Squad" : squad = new AssaultSquad(au.getUnitName());
			   break;
			   case "Attack Bike Squad" : squad = new Attack_BikeSquad(au.getUnitName());
			   break;	
			   case "Bike Squad" : squad = new BikeSquad(au.getUnitName());
			   break;
			   case "Drop Pod" : squad = new Drop_PodSquad(au.getUnitName());
			   break;
			   case "Land Speeder Squad" : squad = new Land_SpeederSquad(au.getUnitName());
			   break;
			   case "Land Speeder Storm" : squad = new Land_Speeder_StormSquad(au.getUnitName());
			   break;
			   case "Razorback" : squad = new RazorbackSquad(au.getUnitName());
			   break;
			   case "Rhino" : squad = new RhinoSquad(au.getUnitName());
			   break;
			   case "Scout Bike Squad" : squad = new Scout_BikeSquad(au.getUnitName());
			   break;
			   case "Stormhawk Interceptor" : squad = new Stormhawk_InterceptorSquad(au.getUnitName());
			   break;
			   case "Stormtalon Gunship" : squad = new Stormtalon_GunshipSquad(au.getUnitName());
			   break;
			   case "Centurion Devastator Squad" : squad = new Centurion_DevastatorSquad(au.getUnitName());
			   break;
			   case "Devastator Squad" : squad = new DevastatorSquad(au.getUnitName());
			   break;
			   case "Hunter Squad" : squad = new HunterSquad(au.getUnitName());
			   break;
			   case "Land Raider" : squad = new Land_RaiderSquad(au.getUnitName());
			   break;
			   case "Land Raider Crusader" : squad = new Land_Raider_CrusaderSquad(au.getUnitName());
			   break;
			   case "Land Raider Redeemer" : squad = new Land_Raider_RedeemerSquad(au.getUnitName());
			   break;
			   case "Predator Squad" : squad = new PredatorSquad(au.getUnitName());
			   break;
			   case "Stalker Squad" : squad = new StalkerSquad(au.getUnitName());
			   break;
			   case "Stormraven Gunship" : squad = new Stormraven_GunshipSquad(au.getUnitName());
			   break;			   			   
			   case "Thunderfire Cannon Squad" : squad = new Thunderfire_CannonSquad(au.getUnitName());
			   break;
			   case "Vindicator Squad" : squad = new VindicatorSquad(au.getUnitName());
			   break;
			   case "Whirlwind Squad" : squad = new WhirlwindSquad(au.getUnitName());
			   break;
			   case "Captain" : squad = new CaptainSquad(au.getUnitName());
			   break;
			   case "Chaplain" : squad = new ChaplainSquad(au.getUnitName());
			   break;
			   case "Librarian" : squad = new LibrarianSquad(au.getUnitName());
			   break;
			   case "Techmarine" : squad = new TechmarineSquad(au.getUnitName());
			   break;  
			   case "Scout Squad" : squad = new ScoutSquad(au.getUnitName()); //create a new scoutSquad with the inputed name
			   break;
			   case "Tactical Squad" : squad = new TacticalSquad(au.getUnitName());
			   break;
			}
			
			squad.addUnitSquad();
			model.addUnitSquad(squad); //I THINK THIS CAUSES THE SAVE ISSUE
			//au.populateUnitMemberComboBox(getUnitSize());
			model.setCurrentPoints(squad.getSquadPoints());
            au.setMaxpoints(model.getCurrentPoints(), model.getTotalPoints());
            pointsValueCheck();	    	
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
			pointsValueCheck();			
		}		
	}
	
	private class clearArmyHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e) 
		{
			au.clearArmyList();
			model.setCurrentPoints(0);
			au.setMaxpoints(0, model.getTotalPoints());
			pointsValueCheck();
		}		
	}
		
	private class addUnitMemberBtn implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e) 
		{
			UnitSquad squad = au.getSelectedUnitSquad();
			Unit member = new Unit();
			switch(au.getUnit().toString()) 
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
			   case "Vanguard Veteran Squad" : member = new Vanguard_Veteran();
			   break;
			   case "Venerable Dreadnought Squad" : member = new Venerable_Dreadnought();
			   break;
			   case "Assault Squad" : member = new Assault();
			   break;
			   case "Attack Bike Squad" : member = new Attack_Bike();
			   break;
			   case "Bike Squad" : member = new Bike();
			   break;
			   case "Drop Pod" : member = new Drop_Pod();
			   break;
			   case "Land Speeder Squad" : member = new Land_Speeder();
			   break;
			   case "Land Speeder Storm" : member = new Land_Speeder_Storm();
			   break;
			   case "Razorback" : member = new Razorback();
			   break;
			   case "Rhino" : member = new Rhino();
			   break;
			   case "Scout Bike Squad" : member = new Scout_Bike();
			   break;
			   case "Stormhawk Interceptor" : member = new Stormhawk_Interceptor();
			   break;
			   case "Stormtalon Gunship" : member = new Stormtalon_Gunship();
			   break;
			   case "Centurion Devastator Squad" : member = new Centurion_Devastator();
			   break;
			   case "Devastator Squad" : member = new Devastator();
			   break;
			   case "Hunter Squad" : member = new Hunter();
			   break;
			   case "Land Raider" : member = new Land_Raider();
			   break;
			   case "Land Raider Crusader" : member = new Land_Raider_Crusader();
			   break;
			   case "Land Raider Redeemer" : member = new Land_Raider_Redeemer();
			   break;
			   case "Predator Squad" : member = new Predator();
			   break;
			   case "Stalker Squad" : member = new Stalker();
			   break;
			   case "Stormraven Gunship" : member = new Stormraven_Gunship();
			   break;				   			   
			   case "Thunderfire Cannon Squad" : member = new Thunderfire_Cannon();
			   break;	
			   case "Vindicator Squad" : member = new Vindicator();
			   break;
			   case "Whirlwind Squad" : member = new Whirlwind();
			   break;
			   case "Captain" : member = new Captain();
			   break;
			   case "Chaplain" : member = new Chaplain();
			   break;
			   case "Librarian" : member = new Librarian();
			   break;
			   case "Techmarine" : member = new Techmarine();
			   break;		   
			   case "Scout Squad" : member = new Scout(); 		                             
			   break;
			   case "Tactical Squad" : member = new Tactical();				
			}
			
			squad.addUnit(member);
			au.setSizeCheckMessage(squad.SquadSizeCheck());
			model.updatUnitSquad(au.getSelectedUnitSquadIndex(), squad);
			model.setCurrentPoints(squad.getSquadPoints());
            au.setMaxpoints(model.getCurrentPoints(), model.getTotalPoints());
            pointsValueCheck();
            //au.populateUnitMemberComboBox(getUnitSize());
            //System.out.println(model.getArmy());
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
			pointsValueCheck();
		}		
	}
	
	private class upgradeUnitWeaponHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e) 
		{
			
			UnitSquad selectedSquad = au.getSelectedUnitSquad();
	        selectedSquad.weaponUpgrade(au.getUnitWeapon(), au.getunitMemberSelected()-1);
	        
	        switch(au.getUnit().toString()) //for all the units that have two weapons
			{
			   case "Centurion Assault Squad" : 	   
			   case "Dreadnought Squad" :
			   case "Ironclad Dreadnought Squad" :
			   case "Terminator Squad" :
			   case "Venerable Dreadnought Squad" :
			   case "Attack Bike Squad" :
			   case "Bike Squad" :
			   case "Land Speeder Squad" :
			   case "Land Speeder Storm" :
			   case "Scout Bike Squad" :
			   case "Stormhawk Interceptor" : 
			   case "Stormtalon Gunship" :	
			   case "Centurion Devastator Squad" :
			   case "Predator Squad" :	
			   case "Stormraven Gunship" :
			   case "Captain" :
			   case "Chaplain" :
			   case "Librarian" :	
			   case "Techmarine" :	
			   case "Vanguard Veteran Squad" :
			   case "Assault Squad" :
				   selectedSquad.secondWeaponUpgrade(au.getUnitSecondWeapon(), au.getunitMemberSelected()-1);
			  break;				
		}

	        model.updatUnitSquad(au.getSelectedUnitSquadIndex(), selectedSquad);
	        au.setweaponsCheckMessage(selectedSquad.SquadWeaponsCheck());        
	        model.setCurrentPoints(selectedSquad.getSquadPoints());
            au.setMaxpoints(model.getCurrentPoints(), model.getTotalPoints());	
            selectedSquad.getUnit(au.getSelectedUnitSquadIndex()).resetUnitPoints();
            pointsValueCheck();
		}		
	}		
}
