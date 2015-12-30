package de.rpfr.abt7.dms76.gui;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class SearchfilterPane extends GridPane {
	
	private MainPane mainpanel;

	public SearchfilterPane(MainPane mainpanel) {
		super();
		setId("searchfilter");
		this.mainpanel = mainpanel;
		
		setHgap(10);
	    setVgap(10);
	    
	    Label labErsteller = new Label("Ersteller:");
	    labErsteller.getStyleClass().add("formlabel");
	    setConstraints(labErsteller, 0, 0);
	    
	    TextField tfErsteller = new TextField();
	    tfErsteller.getStyleClass().add("forminput");
	    setConstraints(tfErsteller, 1, 0);

	    Label labErstellerImg = new Label();
	    labErstellerImg.getStyleClass().add("formimage");
	    labErstellerImg.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/res/ersteller.png"))));
	    labErstellerImg.setContentDisplay(ContentDisplay.TOP);
	    labErstellerImg.setAlignment(Pos.CENTER);
	    setConstraints(labErstellerImg, 5, 0);
	    
	    
	    Label labVon = new Label("Von / Bis:");
	    labVon.getStyleClass().add("formlabel");
	    setConstraints(labVon, 0, 1);

	    DatePicker dpVon = new DatePicker();
	    dpVon.getStyleClass().add("forminput");
	    setConstraints(dpVon, 1, 1);
	    
	    DatePicker dpBis = new DatePicker();
	    dpBis.getStyleClass().add("forminput");
	    setConstraints(dpBis, 2, 1);
	    
	    Label labVonBisImg = new Label();
	    labVonBisImg.getStyleClass().add("formimage");
	    labVonBisImg.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/res/zeitraum.png"))));
	    labVonBisImg.setContentDisplay(ContentDisplay.TOP);
	    labVonBisImg.setAlignment(Pos.CENTER);
	    setConstraints(labVonBisImg, 5, 1);
	    setRowSpan(labVonBisImg, 2);
	    
	    ComboBox<String> cbDateShortcut = new ComboBox<>(FXCollections.observableArrayList(
	    	    "", "kompletter Zeitraum", "heute", "seit gestern", "seit dieser Woche", "seit letzter Woche", "seit den letzen zwei Wochen", "diesen Monat", "seit dem letzten Monat", "seit den letzten drei Monate", "seit Jahresbeginn")
	    		);
	    cbDateShortcut.getStyleClass().add("forminput");
	    cbDateShortcut.setPrefWidth(380);
	    setConstraints(cbDateShortcut, 1, 2);
	    setColumnSpan(cbDateShortcut, 3);
	    
	    Label labDateityp = new Label("Dateityp:");
	    labDateityp.getStyleClass().add("formlabel");
	    setConstraints(labDateityp, 0, 3);
	    
	    ComboBox<String> cbDateityp = new ComboBox<>(FXCollections.observableArrayList(
	    	    "", "pdf", "doc(x)", "xls(x)", "ppt(x)", "txt", "eml", "html")
	    		);
	    cbDateityp.getStyleClass().add("forminput");
	    setConstraints(cbDateityp, 1, 3);

	    Label labDateitypImg = new Label();
	    labDateitypImg.getStyleClass().add("formimage");
	    labDateitypImg.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/res/dateityp.png"))));
	    labDateitypImg.setContentDisplay(ContentDisplay.TOP);
	    labDateitypImg.setAlignment(Pos.CENTER);
	    setConstraints(labDateitypImg, 5, 3);

	    
	    Label labSuche = new Label("Suchbegriffe:");
	    labSuche.getStyleClass().add("formlabel");
	    setConstraints(labSuche, 0, 4);
	    
	    TextField tfSuche = new TextField();
	    tfSuche.getStyleClass().add("forminput");
	    setConstraints(tfSuche, 1, 4);
	    setColumnSpan(tfSuche, 3);

	    Label labSucheImg = new Label();
	    labSucheImg.getStyleClass().add("formimage");
	    labSucheImg.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/res/suche.png"))));
	    labSucheImg.setContentDisplay(ContentDisplay.TOP);
	    labSucheImg.setAlignment(Pos.CENTER);
	    setConstraints(labSucheImg, 5, 4);


	    CheckBox cbUnd = new CheckBox();
	    cbUnd.setText("UND-Verknüpfung");
	    cbUnd.setSelected(false);
	    cbUnd.getStyleClass().add("forminput");
	    setConstraints(cbUnd, 1, 5);

	    CheckBox cbFuzzy = new CheckBox();
	    cbFuzzy.setText("Ähnliche Treffer finden");
	    cbFuzzy.setSelected(false);
	    cbFuzzy.getStyleClass().add("forminput");
	    setConstraints(cbFuzzy, 2, 5);

	    Label labEinstellungenImg = new Label();
	    labEinstellungenImg.getStyleClass().add("formimage");
	    labEinstellungenImg.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/res/einstellungen.png"))));
	    labEinstellungenImg.setContentDisplay(ContentDisplay.TOP);
	    labEinstellungenImg.setAlignment(Pos.CENTER);
	    setConstraints(labEinstellungenImg, 5, 5);
	    
	    
	    getChildren().addAll(labErsteller, tfErsteller, labVon, dpVon, dpBis, cbDateShortcut, labErstellerImg, labVonBisImg, labDateityp, cbDateityp, labDateitypImg, labSuche, tfSuche, labSucheImg, cbUnd, cbFuzzy, labEinstellungenImg);
	    

	}

}
