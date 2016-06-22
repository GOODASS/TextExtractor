package lib.UI_JAVAFX.gui.center.scrollpane;

import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import lib.UI_JAVAFX.gui.center.imagelayer.GameImageLayer;

@SuppressWarnings("restriction")
public class ScrollImagePane extends ScrollPane{
	public ScrollImagePane(double h,double v, final GameImageLayer gameImageLayer){
	
		this.setHmax(h);
		this.setVmax(v);
		this.setPrefWidth(h);
		this.setPrefHeight(v);
		this.setContent(gameImageLayer);
	}
}
