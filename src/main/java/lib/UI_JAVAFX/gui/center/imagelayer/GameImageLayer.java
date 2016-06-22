package lib.UI_JAVAFX.gui.center.imagelayer;

import javafx.scene.Group;
import lib.UI_JAVAFX.gui.center.imagelayer.imageviews.GameImageView;

@SuppressWarnings("restriction")
public class GameImageLayer extends Group{
	private GameImageView gameImageView;
	
	public GameImageLayer(){
		gameImageView = new GameImageView();
		
		this.getChildren().add(gameImageView);
	}
	
	public GameImageView getGameImageView(){
		return gameImageView;
	}
}
