package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;

public class ArmyBuilderMenuBar extends MenuBar 
{
	private MenuItem save, load, saveToText, print, info;
	
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
		
		saveToText = new MenuItem("Save To Text File");
		saveToText.setAccelerator(KeyCombination.keyCombination("SHORTCUT+T"));
		menu.getItems().add(saveToText);
		
		print = new MenuItem("Print");
		print.setAccelerator(KeyCombination.keyCombination("SHORTCUT+P"));
		menu.getItems().add(print);
				
		this.getMenus().add(menu);
		
		menu = new Menu("Help");
		
		info = new MenuItem("Info");
		info.setAccelerator(KeyCombination.keyCombination("SHORTCUT+I"));
		menu.getItems().add(info);
		
		this.getMenus().add(menu);		
	}
	
	public void disableMenuItems(Boolean value)
	{
		save.setDisable(value);
		saveToText.setDisable(value);	
		print.setDisable(value);
	}
	
	public void SaveHandler(EventHandler<ActionEvent> handler)
	{
		save.setOnAction(handler);
	}
	
	public void LoadHandler(EventHandler<ActionEvent> handler)
	{
		load.setOnAction(handler);
	}
	
	public void TextFileHandler(EventHandler<ActionEvent> handler)
	{
		saveToText.setOnAction(handler);
	}
	
	public void PrintHandler(EventHandler<ActionEvent> handler)
	{
		print.setOnAction(handler);
	}
	
	public void InfoHandler(EventHandler<ActionEvent> handler)
	{
		info.setOnAction(handler);
	}
}
