package de.rpfr.abt7.dms76.gui;

import javafx.scene.control.Label;

public class StatusPane extends Label {

	public StatusPane(){
		super();
		setId("status");
		setPrefSize(Double.MAX_VALUE, 1.0);
		setWrapText(false);
	}
	
	public void setStatus(String newStatus){
		setText(newStatus);
	}
	
}
