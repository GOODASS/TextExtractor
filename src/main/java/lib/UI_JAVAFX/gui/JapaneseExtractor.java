package lib.UI_JAVAFX.gui;

import javafx.application.Application;
import javafx.stage.Stage;
import lib.UI_JAVAFX.gui.root.RootPane;
import javafx.scene.Scene;

@SuppressWarnings("restriction")
public class JapaneseExtractor extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		double width = 1200;
		double height = 900;
		
		
		Scene scene = new Scene(new RootPane());
		stage.setScene(scene);
		stage.setHeight(height);
        stage.setWidth(width);
		stage.setTitle("TextExtractor "+Double.toString(width)+"X"+Double.toString(height));
		stage.show();
	}
	
	public static void main(String[] args){
		Application.launch(args);
	}

}
