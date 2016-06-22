package lib.UI_JAVAFX.gui.center.imagelayer.areadrag;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.shape.Rectangle;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.input.Clipboard;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import lib.UI_JAVAFX.gui.center.Tesseract4Text;
import lib.UI_JAVAFX.gui.center.imagelayer.imageviews.GameImageView;
import lib.UI_JAVAFX.gui.center.right.RightPane;

@SuppressWarnings("restriction")
public class RubberBandSelection {
	private Group group;
	private GameImageView imageViewToSubrectangle;
	private RightPane right;
	private GameImageView imageViewToProjectASelectedArea;
	
	final DragContext dragContext = new DragContext();
    Rectangle rect = new Rectangle();

    


    public Bounds getBounds() {
        return rect.getBoundsInParent();
    }

    public RubberBandSelection(Group group,GameImageView imageViewToSubrectangle, RightPane right) {
        this.group = group;
        this.imageViewToSubrectangle = imageViewToSubrectangle;
        this.right = right;
        this.imageViewToProjectASelectedArea = right.getGameImageLayer().getGameImageView();

        rect = new Rectangle( 0,0,0,0);
        rect.setStroke(Color.BLUE);
        rect.setStrokeWidth(1);
        rect.setStrokeLineCap(StrokeLineCap.ROUND);
        rect.setFill(Color.LIGHTBLUE.deriveColor(0, 1.2, 1, 0.6));

        group.addEventHandler(MouseEvent.MOUSE_PRESSED, onMousePressedEventHandler);
        group.addEventHandler(MouseEvent.MOUSE_DRAGGED, onMouseDraggedEventHandler);
        group.addEventHandler(MouseEvent.MOUSE_RELEASED, onMouseReleasedEventHandler);

    }

    EventHandler<MouseEvent> onMousePressedEventHandler = new EventHandler<MouseEvent>() {

        public void handle(MouseEvent event) {

            if( event.isSecondaryButtonDown())
                return;

            // remove old rect
            rect.setX(0);
            rect.setY(0);
            rect.setWidth(0);
            rect.setHeight(0);

            group.getChildren().remove( rect);


            // prepare new drag operation
            dragContext.mouseAnchorX = event.getX();
            dragContext.mouseAnchorY = event.getY();

            rect.setX(dragContext.mouseAnchorX);
            rect.setY(dragContext.mouseAnchorY);
            rect.setWidth(0);
            rect.setHeight(0);

            group.getChildren().add( rect);

        }
    };

    EventHandler<MouseEvent> onMouseDraggedEventHandler = new EventHandler<MouseEvent>() {

        public void handle(MouseEvent event) {

            if( event.isSecondaryButtonDown())
                return;

            double offsetX = event.getX() - dragContext.mouseAnchorX;
            double offsetY = event.getY() - dragContext.mouseAnchorY;

            if( offsetX > 0)
                rect.setWidth( offsetX);
            else {
                rect.setX(event.getX());
                rect.setWidth(dragContext.mouseAnchorX - rect.getX());
            }

            if( offsetY > 0) {
                rect.setHeight( offsetY);
            } else {
                rect.setY(event.getY());
                rect.setHeight(dragContext.mouseAnchorY - rect.getY());
            }
        }
    };


    EventHandler<MouseEvent> onMouseReleasedEventHandler = new EventHandler<MouseEvent>() {

        public void handle(MouseEvent event) {
        	if( event.isSecondaryButtonDown()){
            	
            	
            	return;
            }
        	try{
        		Bounds bounds = rect.getBoundsInParent();
        		
        		int width = (int) bounds.getWidth();
        		int height = (int) bounds.getHeight();
        		
        		System.out.println(bounds.getMinX()+ ","+bounds.getMinY()+" | "+width + "," + height);
        		
        		SnapshotParameters parameters = new SnapshotParameters();
        		parameters.setFill(Color.TRANSPARENT);
        		parameters.setViewport(new Rectangle2D( bounds.getMinX(), bounds.getMinY(), width, height));
        		
        		WritableImage wi = new WritableImage( width, height);
        		WritableImage wi2 = imageViewToSubrectangle.snapshot(parameters, wi);
          
                ImageView imView = new ImageView(wi2);

                imageViewToProjectASelectedArea.setImage(imView.getImage());
                
                BufferedImage bufImageARGB = SwingFXUtils.fromFXImage(wi, null);
//                BufferedImage bufImageRGB = new BufferedImage(bufImageARGB.getWidth(), bufImageARGB.getHeight(), BufferedImage.OPAQUE);
                
                
                String resultText = Tesseract4Text.getText(bufImageARGB);
                System.out.println("Result"+resultText);
                right.getResultTextPrinter().setText(resultText);
        		
        	}
        	catch (Exception e){
        		System.out.println("Fault selected area");
        	}
            
            

            // remove rectangle
            // note: we want to keep the ruuberband selection for the cropping => code is just commented out

            rect.setX(0);
            rect.setY(0);
            rect.setWidth(0);
            rect.setHeight(0);

            group.getChildren().remove( rect);

        }
    };
    private static final class DragContext {

        public double mouseAnchorX;
        public double mouseAnchorY;


    }
}
