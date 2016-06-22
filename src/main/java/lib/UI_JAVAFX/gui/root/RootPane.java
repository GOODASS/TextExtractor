package lib.UI_JAVAFX.gui.root;

import javafx.scene.layout.BorderPane;
import lib.UI_JAVAFX.gui.center.CenterContainer;
import lib.UI_JAVAFX.gui.top.TopContainer;

@SuppressWarnings("restriction")
public class RootPane extends BorderPane{
	public RootPane(){
		TopContainer topContainer = new TopContainer();
		CenterContainer centerContainer = new CenterContainer();
		this.setTop(topContainer);
		this.setCenter(centerContainer);
	}
}
