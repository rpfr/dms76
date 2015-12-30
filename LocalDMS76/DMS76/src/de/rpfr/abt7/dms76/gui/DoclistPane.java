package de.rpfr.abt7.dms76.gui;

import de.rpfr.abt7.dms76.obj.Hit;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;

public class DoclistPane extends StackPane {

	private MainPane mainpanel;

	public DoclistPane(MainPane mainpanel) {
		super();
		setId("doclist");
		this.mainpanel = mainpanel;
		
		TableView<Hit> tabTreffer = new TableView<>();
		tabTreffer.setItems(FXCollections.observableArrayList(new Hit("Dok1")));
		
		TableColumn<Hit, String> colId = new TableColumn<>("ID");
		TableColumn<Hit, String> colDatei = new TableColumn<>("Datei");
		tabTreffer.getColumns().addAll(colId, colDatei);
		
		getChildren().add(tabTreffer);
	}
}
