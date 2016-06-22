package lib.UI_JAVAFX.gui.top;

import javafx.scene.layout.VBox;

public class TopContainer extends VBox{
	public TopContainer(){
		Menubar menuBar = new Menubar();
		this.getChildren().add(menuBar);
	}
}
