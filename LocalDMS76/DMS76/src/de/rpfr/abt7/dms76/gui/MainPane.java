package de.rpfr.abt7.dms76.gui;

import de.rpfr.abt7.dms76.DMS76;
import javafx.scene.layout.BorderPane;

public class MainPane extends BorderPane {
	
	private DMS76 dms;
	private DoclistPane doclistpane;
	
	public MainPane(DMS76 dms){
		super();
		this.dms = dms;
		setId("mainpane");
		
		setTop(new SearchfilterPane(this));
		
		doclistpane = new DoclistPane(this);
		setCenter(doclistpane);
		
	}

	public DMS76 getDms() {
		return dms;
	}

	public DoclistPane getDoclistPanel() {
		return doclistpane;
	}

}
