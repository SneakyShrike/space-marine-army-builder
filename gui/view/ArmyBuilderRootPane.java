package gui.view;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;

import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ArmyBuilderRootPane extends BorderPane
{
	private ArmyBuilderMenuBar mb;
	private TabPane tp;
	private Tab tab1, tab2, tab3, tab4;
	private Label totalPoints;
	private CreateProfilePane cp;
	private AddUnitPane au;
	private UpdateUnitPane uu;
	private ArmyDisplayPane ad;
	
	public ArmyBuilderRootPane()
	{
		mb = new ArmyBuilderMenuBar();
		cp = new CreateProfilePane();
		au = new AddUnitPane();
		uu = new UpdateUnitPane();
		ad = new ArmyDisplayPane();
		
		tp = new TabPane();
		tab1 = new Tab("Create Profile", cp);
		tab2 = new Tab("Add Unit", au);
		tab3 = new Tab("Update Unit", uu);
		tab4 = new Tab("Army Display", ad);
		
		tp.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE); //ensures user can't close tabs
		tp.getTabs().addAll(tab1, tab2, tab3, tab4);
		
		totalPoints = new Label("test");
		
		VBox globalSection = new VBox(mb, totalPoints);
		
		this.setTop(globalSection);
		this.setCenter(tp);
	}
	
	public void nextTab(int index) 
	{
		tp.getSelectionModel().select(index);
	}
	
	public ArmyBuilderMenuBar getArmyBuilderMenuBar()
	{
		return mb;
	}
	
	public CreateProfilePane getCreateProfilePane()
	{
		return cp;
	}
	
	public AddUnitPane getAddUnitPane()
	{
		return au;
	}
	
	public UpdateUnitPane getUpdateUnitPane()
	{
		return uu;
	}
	
	public ArmyDisplayPane getArmyDisplayPane()
	{
		return ad;
	}
	
	public void setMaxpoints(int currentPoints, int totalPoints)
	{
		this.totalPoints.textProperty().bind(new SimpleIntegerProperty(currentPoints).asString()
		.concat("/")
		.concat(new SimpleIntegerProperty(totalPoints).asString()));
	}	
}
