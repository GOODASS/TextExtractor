package lib.UI_JAVAFX.gui.top;

import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class Menubar extends MenuBar{
	@SuppressWarnings("restriction")
	public Menubar(){
		Menu menu = new Menu("option");
		menu.getItems().add(new MenuItem("Preference"));
		this.getMenus().add(menu);
	}
}
