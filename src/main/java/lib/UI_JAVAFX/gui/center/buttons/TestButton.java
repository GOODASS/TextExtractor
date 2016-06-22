package lib.UI_JAVAFX.gui.center.buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;

@SuppressWarnings("restriction")
public class TestButton extends Button{
	public TestButton(final ImageView imageView){
		this.setText("getImage");
		
		
		this.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(final ActionEvent e) {
            	Clipboard clipBoard = Clipboard.getSystemClipboard();
            	if(clipBoard.hasImage()){
            		System.out.println("has image");
            		System.out.println(clipBoard.getImage().getWidth()+"X"+clipBoard.getImage().getHeight());

            		
            		imageView.setImage(clipBoard.getImage());
            	}
            	else{
            		System.out.println("has not image");
            	}
            }
        });
	}
}
