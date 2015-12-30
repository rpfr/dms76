package de.rpfr.abt7.dms76.gui;

import de.rpfr.abt7.dms76.DMS76;
import javafx.scene.layout.BorderPane;

public class MainPane extends BorderPane {
	
	private DMS76 dms;
	
	public MainPane(DMS76 dms){
		super();
		this.dms = dms;
		
		setTop(new SearchfilterPane(this));
		setCenter(new DoclistPane(this));
		
	}

}
