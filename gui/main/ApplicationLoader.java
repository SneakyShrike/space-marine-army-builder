package gui.main;

import java.util.Scanner;

import gui.controller.ArmyBuilderController;
import gui.model.ArmyBuilderProfile;
import gui.view.ArmyBuilderRootPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import troops.scout.Scout;
import troops.scout.ScoutSergeant;
import troops.scout.ScoutSquad;

public class ApplicationLoader extends Application 
{
	private ArmyBuilderRootPane view;
	
	@Override
	public void init() throws Exception
	{
		ArmyBuilderProfile model = new ArmyBuilderProfile();
		view =  new ArmyBuilderRootPane(); 
		new ArmyBuilderController(view, model);		
	}
	
	@Override
	public void start(Stage stage) throws Exception 
	{
		stage.setMinWidth(600);
		stage.setMinHeight(600);
		stage.setTitle("Space Marine Army Builder");
		stage.setScene(new Scene(view));
		stage.show();				
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}