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
		TableColumn<Hit, String> colGroesse = new TableColumn<>("Größe");
		TableColumn<Hit, String> colErsteller = new TableColumn<>("Ersteller");
		TableColumn<Hit, String> colErstellungsdatum = new TableColumn<>("Erstellungsdatum");
		TableColumn<Hit, String> colLetzteAenderung = new TableColumn<>("Letzte Änderung");
		TableColumn<Hit, String> colSuchbegriffe = new TableColumn<>("Suchbegriffe");
		tabTreffer.getColumns().addAll(colId, colDatei, colErsteller, colGroesse, colErstellungsdatum, colLetzteAenderung, colSuchbegriffe);
		
		getChildren().add(tabTreffer);
	}
}
