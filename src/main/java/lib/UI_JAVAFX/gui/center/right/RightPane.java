package lib.UI_JAVAFX.gui.center.right;

import javafx.scene.layout.VBox;
import lib.UI_JAVAFX.gui.center.buttons.TestButton;
import lib.UI_JAVAFX.gui.center.imagelayer.GameImageLayer;
import lib.UI_JAVAFX.gui.center.imagelayer.imageviews.GameImageView;
import lib.UI_JAVAFX.gui.center.scrollpane.ScrollImagePane;

@SuppressWarnings("restriction")
public class RightPane extends VBox{
	private GameImageLayer gameImageLayer;
	private ResultTextPrinter resultTextPrinter;
	
	public RightPane(GameImageView imageView){
		gameImageLayer = new GameImageLayer();
		
		ScrollImagePane scrollImagePane = new ScrollImagePane(272, 200, gameImageLayer);
		TestButton testButton = new TestButton(imageView);
		resultTextPrinter = new ResultTextPrinter();
		
		this.getChildren().addAll(scrollImagePane, resultTextPrinter, testButton);
	}
	
	public GameImageLayer getGameImageLayer(){
		return gameImageLayer;
	}
	public ResultTextPrinter getResultTextPrinter(){
		return resultTextPrinter;
	}
}
