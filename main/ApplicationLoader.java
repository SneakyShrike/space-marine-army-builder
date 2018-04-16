package main;

import controller.ArmyBuilderController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Army;
import view.ArmyBuilderRootPane;

public class ApplicationLoader extends Application 
{
	private ArmyBuilderRootPane view;
	
	@Override
	public void init()
	{
		Army model = new Army();
		view =  new ArmyBuilderRootPane(); 
		new ArmyBuilderController(view, model);		
	}
	
	@Override
	public void start(Stage stage) throws Exception 
	{
		stage.setTitle("Space Marine Army Builder");
		stage.setScene(new Scene(view));
		stage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}