package lib.UI_JAVAFX.gui.center;

import java.awt.image.BufferedImage;
import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Tesseract4Text {
	private static ITesseract instance = null;
	
	protected Tesseract4Text(){
		
	}

//	public static ITesseract getInstance(){
//		if(instance == null){
//			instance = new Tesseract();
//			instance.setLanguage("jpn");
//		}
//		return instance;
//	}
//	
	public static String getText(BufferedImage imageFile) throws TesseractException{
		if(instance == null){
			instance = new Tesseract();
			instance.setLanguage("jpn");
		}
		return instance.doOCR(imageFile);
	}
	
	public static void main(String[] args) {
        File imageFile = new File("test.JPG");
        ITesseract instance = new Tesseract();  // JNA Interface Mapping
        instance.setLanguage("jpn");
        // ITesseract instance = new Tesseract1(); // JNA Direct Mapping

        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}
