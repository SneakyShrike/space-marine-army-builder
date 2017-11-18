package gui.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;

public class ArmyBuilderMenuBar extends MenuBar 
{
	private MenuItem save, load, exit, info;
	
	public ArmyBuilderMenuBar()
	{
		Menu menu;
		
		menu = new Menu("File");
		
		save = new MenuItem("Save");
		save.setAccelerator(KeyCombination.keyCombination("SHORTCUT+S"));
		menu.getItems().add(save);
		
		load = new MenuItem("Load");
		load.setAccelerator(KeyCombination.keyCombination("SHORTCUT+L"));
		menu.getItems().add(load);
		
		exit = new MenuItem("Exit");
		exit.setAccelerator(KeyCombination.keyCombination("SHORTCUT+E"));
		menu.getItems().add(exit);
		
		this.getMenus().add(menu);
		
		menu = new Menu("Help");
		
		info = new MenuItem("Info");
		info.setAccelerator(KeyCombination.keyCombination("SHORTCUT+I"));
		menu.getItems().add(info);
		
		this.getMenus().add(menu);		
	}
	
	public void SaveHandler(EventHandler<ActionEvent> handler)
	{
		save.setOnAction(handler);
	}
	
	public void LoadHandler(EventHandler<ActionEvent> handler)
	{
		load.setOnAction(handler);
	}
	
	public void ExitHandler(EventHandler<ActionEvent> handler)
	{
		exit.setOnAction(handler);
	}
	
	public void InfoHandler(EventHandler<ActionEvent> handler)
	{
		info.setOnAction(handler);
	}
}
