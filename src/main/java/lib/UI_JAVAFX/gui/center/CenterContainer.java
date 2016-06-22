package lib.UI_JAVAFX.gui.center;

import javafx.scene.layout.GridPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Button;
import javafx.scene.input.Clipboard;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import lib.UI_JAVAFX.gui.center.buttons.TestButton;
import lib.UI_JAVAFX.gui.center.imagelayer.GameImageLayer;
import lib.UI_JAVAFX.gui.center.imagelayer.areadrag.RubberBandSelection;
import lib.UI_JAVAFX.gui.center.imagelayer.imageviews.GameImageView;
import lib.UI_JAVAFX.gui.center.right.RightPane;
import lib.UI_JAVAFX.gui.center.scrollpane.ScrollImagePane;

@SuppressWarnings("restriction")
public class CenterContainer extends GridPane{
	private Scene sharedObject;
	
	public CenterContainer(){
		this.setVgap(6);
		this.setHgap(6);
		
		GameImageLayer gameImageLayer = new GameImageLayer();
		
		final GameImageView imageView = gameImageLayer.getGameImageView();
		
		//CenterContainer's Left and Right
		ScrollImagePane left = new ScrollImagePane(900, 800, gameImageLayer);
		RightPane right = new RightPane(imageView);
		
		RubberBandSelection areaSelection = new RubberBandSelection(gameImageLayer, imageView, right);
		
		//set positions of contents
		this.setConstraints(left, 0, 0);
		this.setConstraints(right, 1, 0);
		
		
		this.getChildren().addAll(left, right);
	}
}
