package de.rpfr.abt7.dms76.gui;

import java.util.List;

import com.sun.syndication.feed.atom.Person;

import de.rpfr.abt7.dms76.obj.DMSIndexItem;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;

public class DoclistPane extends StackPane {

	private MainPane mainpanel;
	private TableView<DMSIndexItem> tabTreffer; 

	@SuppressWarnings("unchecked")
	public DoclistPane(MainPane mainpanel) {
		super();
		setId("doclist");
		this.mainpanel = mainpanel;
		
		tabTreffer = new TableView<>();
		tabTreffer.setPlaceholder(new Label("Keine Treffer!"));

		TableColumn<DMSIndexItem, String> colDatei = new TableColumn<>("Datei");
		colDatei.setCellValueFactory(new PropertyValueFactory<DMSIndexItem, String>("int_title"));
		
		colDatei.setCellFactory
		 (
		   column ->
		    {
		      return new TableCell<DMSIndexItem, String>()
		       {
		         @Override
		         protected void updateItem(String item, boolean empty)
		          {
		             super.updateItem(item, empty);
		             setText( item );
		             setTooltip(new Tooltip(item + "\nLive is short, make most of it..!"));
		          }
		       };
		    });		
		
		
		TableColumn<DMSIndexItem, String> colGroesse = new TableColumn<>("Größe");
		colGroesse.setCellValueFactory(new PropertyValueFactory<DMSIndexItem, String>("documentSize"));
		TableColumn<DMSIndexItem, String> colErsteller = new TableColumn<>("Ersteller");
		colErsteller.setCellValueFactory(new PropertyValueFactory<DMSIndexItem, String>("ersteller"));
		TableColumn<DMSIndexItem, String> colErstellungsdatum = new TableColumn<>("Erstellungsdatum");
		colErstellungsdatum.setCellValueFactory(new PropertyValueFactory<DMSIndexItem, String>("documentCreated"));
		TableColumn<DMSIndexItem, String> colLetzteAenderung = new TableColumn<>("Letzte Änderung");
		colLetzteAenderung.setCellValueFactory(new PropertyValueFactory<DMSIndexItem, String>("documentLastModified"));
		TableColumn<DMSIndexItem, String> colSuchbegriffe = new TableColumn<>("Suchbegriffe");
		colSuchbegriffe.setCellValueFactory(new PropertyValueFactory<DMSIndexItem, String>(DMSIndexItem.KEYS));
		tabTreffer.getColumns().addAll(colDatei, colErsteller, colGroesse, colErstellungsdatum, colLetzteAenderung, colSuchbegriffe);
		
		getChildren().add(tabTreffer);
	}

	public void setHits(List<DMSIndexItem> hits) {
		tabTreffer.setItems(FXCollections.observableArrayList(hits));
	}
}
