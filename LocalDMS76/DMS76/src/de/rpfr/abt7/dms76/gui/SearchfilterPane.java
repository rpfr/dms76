package de.rpfr.abt7.dms76.gui;

import java.util.List;

import de.rpfr.abt7.dms76.obj.DMSIndexItem;
import de.rpfr.abt7.dms76.obj.SearchfilterBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class SearchfilterPane extends GridPane {
	
	private MainPane mainpanel;
	private SearchfilterBean sfbean;
	
	private ComboBox<String> cbKategorie2;

	public SearchfilterPane(MainPane mainpanel) {
		super();
		
		try{
			
			setId("searchfilter");
			this.mainpanel = mainpanel;
			
			sfbean = new SearchfilterBean();
			
			setHgap(10);
		    setVgap(10);
		    
		    int ypos = 0;
		    
		    Label labErsteller = new Label("Ersteller:");
		    labErsteller.getStyleClass().add("formlabel");
		    setConstraints(labErsteller, 0, ypos);

		    /*
		    TextField tfErsteller = new TextField();
		    tfErsteller.getStyleClass().add("forminput");
		    setConstraints(tfErsteller, 1, ypos);
		    tfErsteller.textProperty().bindBidirectional(sfbean.erstellerProperty());
		    */

		    ComboBox<String> cbErsteller = new ComboBox<>(mainpanel.getDms().getDMSFh().getErsteller());
		    cbErsteller.getStyleClass().add("forminput");
		    setConstraints(cbErsteller, 1, ypos);
		    cbErsteller.valueProperty().bindBidirectional(sfbean.erstellerProperty());
		    
	
		    Label labErstellerImg = new Label();
		    labErstellerImg.getStyleClass().add("formimage");
		    labErstellerImg.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/../res/ersteller.png"))));
		    labErstellerImg.setContentDisplay(ContentDisplay.TOP);
		    labErstellerImg.setAlignment(Pos.CENTER);
		    setConstraints(labErstellerImg, 5, ypos);
		    
		    ypos++;
		    
		    final Separator sepHor1 = new Separator();
		    sepHor1.getStyleClass().add("formseparator");
	        sepHor1.setValignment(VPos.CENTER);
	        GridPane.setConstraints(sepHor1, 0, ypos);
	        GridPane.setColumnSpan(sepHor1, 7);

	        ypos++;
		    
		    Label labVon = new Label("Von / Bis:");
		    labVon.getStyleClass().add("formlabel");
		    setConstraints(labVon, 0, ypos);
	
		    DatePicker dpVon = new DatePicker();
		    dpVon.getStyleClass().add("forminput");
		    setConstraints(dpVon, 1, ypos);
		    dpVon.valueProperty().bindBidirectional(sfbean.vonProperty());
		    
		    DatePicker dpBis = new DatePicker();
		    dpBis.getStyleClass().add("forminput");
		    setConstraints(dpBis, 2, ypos);
		    dpBis.valueProperty().bindBidirectional(sfbean.bisProperty());
		    
		    Label labVonBisImg = new Label();
		    labVonBisImg.getStyleClass().add("formimage");
		    labVonBisImg.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/../res/zeitraum.png"))));
		    labVonBisImg.setContentDisplay(ContentDisplay.TOP);
		    labVonBisImg.setAlignment(Pos.CENTER);
		    setConstraints(labVonBisImg, 5, ypos);
		    //setRowSpan(labVonBisImg, 2);
		    
	        ypos++;
		    
		    ComboBox<String> cbDateShortcut = new ComboBox<>(FXCollections.observableArrayList(
		    	    "", "kompletter Zeitraum", "heute", "seit gestern", "seit dieser Woche", "seit letzter Woche", "seit den letzen zwei Wochen", "diesen Monat", "seit dem letzten Monat", "seit den letzten drei Monate", "seit Jahresbeginn")
		    		);
		    cbDateShortcut.getStyleClass().add("forminput");
		    cbDateShortcut.setPrefWidth(380);
		    setConstraints(cbDateShortcut, 1, ypos);
		    setColumnSpan(cbDateShortcut, 3);
		    
	        ypos++;
		    
		    final Separator sepHor2 = new Separator();
		    sepHor2.getStyleClass().add("formseparator");
	        sepHor2.setValignment(VPos.CENTER);
	        GridPane.setConstraints(sepHor2, 0, ypos);
	        GridPane.setColumnSpan(sepHor2, 7);

	        ypos++;

	        Label labDateityp = new Label("Dateiname/-typ:");
		    labDateityp.getStyleClass().add("formlabel");
		    setConstraints(labDateityp, 0, ypos);
		    
		    TextField tfDateityp = new TextField();
		    tfDateityp.getStyleClass().add("forminput");
		    setConstraints(tfDateityp, 1, ypos);
		    tfDateityp.textProperty().bindBidirectional(sfbean.titleProperty());
		    
		    ComboBox<String> cbDateityp = new ComboBox<>(mainpanel.getDms().getDMSFh().getFileTyps());
		    cbDateityp.getStyleClass().add("forminput");
		    setConstraints(cbDateityp, 2, ypos);
		    cbDateityp.valueProperty().bindBidirectional(sfbean.dateitypProperty());
	
		    Label labDateitypImg = new Label();
		    labDateitypImg.getStyleClass().add("formimage");
		    labDateitypImg.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/../res/dateityp.png"))));
		    labDateitypImg.setContentDisplay(ContentDisplay.TOP);
		    labDateitypImg.setAlignment(Pos.CENTER);
		    setConstraints(labDateitypImg, 5, ypos);
	
		    ypos++;
		    
		    final Separator sepHor3 = new Separator();
		    sepHor3.getStyleClass().add("formseparator");
	        sepHor3.setValignment(VPos.CENTER);
	        GridPane.setConstraints(sepHor3, 0, ypos);
	        GridPane.setColumnSpan(sepHor3, 7);

	        ypos++;
		    
		    Label labKategorien = new Label("Kategorien:");
		    labKategorien.getStyleClass().add("formlabel");
		    setConstraints(labKategorien, 0, ypos);
		    
		    ComboBox<String> cbKategorie1 = new ComboBox<>(mainpanel.getDms().getDMSFh().getKategorie1());
		    cbKategorie1.getStyleClass().add("forminput");
		    cbKategorie1.setPrefWidth(180);
		    setConstraints(cbKategorie1, 1, ypos);
		    cbKategorie1.valueProperty().bindBidirectional(sfbean.kategorie1Property());
		    cbKategorie1.setOnAction((event)->setKategorie2(cbKategorie1.getValue()));
	
		    cbKategorie2 = new ComboBox<>(FXCollections.observableArrayList(
		    	    "", "pdf", "doc(x)", "xls(x)", "ppt(x)", "txt", "eml", "html")
		    		);
		    cbKategorie2.getStyleClass().add("forminput");
		    cbKategorie2.setPrefWidth(180);
		    setConstraints(cbKategorie2, 2, ypos);
		    cbKategorie2.valueProperty().bindBidirectional(sfbean.kategorie2Property());
	
		    Label labKategorieImg = new Label();
		    labKategorieImg.getStyleClass().add("formimage");
		    labKategorieImg.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/../res/kategorien.png"))));
		    labKategorieImg.setContentDisplay(ContentDisplay.TOP);
		    labKategorieImg.setAlignment(Pos.CENTER);
		    setConstraints(labKategorieImg, 5, ypos);
	
		    ypos++;
		    
		    final Separator sepHor4 = new Separator();
		    sepHor4.getStyleClass().add("formseparator");
	        sepHor4.setValignment(VPos.CENTER);
	        GridPane.setConstraints(sepHor4, 0, ypos);
	        GridPane.setColumnSpan(sepHor4, 7);

	        ypos++;
		    
		    Label labSuche = new Label("Suchbegriffe:");
		    labSuche.getStyleClass().add("formlabel");
		    setConstraints(labSuche, 0, ypos);
		    
		    TextField tfSuche = new TextField();
		    tfSuche.getStyleClass().add("forminput");
		    setConstraints(tfSuche, 1, ypos);
		    setColumnSpan(tfSuche, 3);
		    tfSuche.textProperty().bindBidirectional(sfbean.suchbegriffProperty());
	
		    Label labSucheImg = new Label();
		    labSucheImg.getStyleClass().add("formimage");
		    labSucheImg.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/../res/suche.png"))));
		    labSucheImg.setContentDisplay(ContentDisplay.TOP);
		    labSucheImg.setAlignment(Pos.CENTER);
		    setConstraints(labSucheImg, 5, ypos);
	
		    ypos++;
	
		    CheckBox cbUnd = new CheckBox();
		    cbUnd.setDisable(true);
		    cbUnd.setText("UND-Verknüpfung");
		    cbUnd.setSelected(false);
		    cbUnd.getStyleClass().add("forminput");
		    setConstraints(cbUnd, 1, ypos);
		    cbUnd.selectedProperty().bindBidirectional(sfbean.undVerknuepfungProperty());
	
		    CheckBox cbFuzzy = new CheckBox();
		    cbFuzzy.setDisable(true);
		    cbFuzzy.setText("Ähnliche Begriffe suchen");
		    cbFuzzy.setSelected(false);
		    cbFuzzy.getStyleClass().add("forminput");
		    setConstraints(cbFuzzy, 2, ypos);
		    cbFuzzy.selectedProperty().bindBidirectional(sfbean.aehnlicheTrefferProperty());
	
/*
		    Label labEinstellungenImg = new Label();
		    labEinstellungenImg.getStyleClass().add("formimage");
		    labEinstellungenImg.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/../res/einstellungen.png"))));
		    labEinstellungenImg.setContentDisplay(ContentDisplay.TOP);
		    labEinstellungenImg.setAlignment(Pos.CENTER);
		    setConstraints(labEinstellungenImg, 5, ypos);
*/		    
		    
		    ypos++;
		    
		    final Separator sepHor5 = new Separator();
		    sepHor5.getStyleClass().add("formseparator");
	        sepHor5.setValignment(VPos.CENTER);
	        GridPane.setConstraints(sepHor5, 0, ypos);
	        GridPane.setColumnSpan(sepHor5, 6);
	        
	        ypos++;
	        
		    Button btnGo = new Button();
		    btnGo.setId("btnGo");
		    btnGo.setText("Suche starten");
		    btnGo.setPrefWidth(380);
		    setConstraints(btnGo, 1, ypos);
		    setColumnSpan(btnGo, 3);
		    btnGo.setOnAction((e)->readyToSearch());
		    
		    getChildren().addAll(sepHor1, sepHor2, sepHor3, sepHor4, sepHor5, labErsteller, /*tfErsteller*/cbErsteller, labVon, dpVon, dpBis, cbDateShortcut, labErstellerImg, labVonBisImg, labDateityp, tfDateityp, cbDateityp, labDateitypImg, labKategorien, cbKategorie1, cbKategorie2, labKategorieImg, labSuche, tfSuche, labSucheImg, cbUnd, cbFuzzy, btnGo);
		    
		}catch(Exception e){
			e.printStackTrace();
		}
	    

	}

	private void setKategorie2(String kat1) {
		try {
			cbKategorie2.getItems().clear();
			ObservableList<String> c = mainpanel.getDms().getDMSFh().getKategorie2(kat1);
			if(c != null){
				cbKategorie2.getItems().addAll(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private List<DMSIndexItem> readyToSearch() {
		List<DMSIndexItem> hits = null;
		StringBuffer querystring = new StringBuffer();
		if(sfbean.getErsteller() != null && sfbean.getErsteller().length()>0){
			querystring.append(DMSIndexItem.ERSTELLER + ":\"" + sfbean.getErsteller() + "\" ");
		}
		if(sfbean.getTitle() != null && sfbean.getTitle().length()>0){
			if(querystring.length() > 0){
				querystring.append("AND ");
			}
			querystring.append(DMSIndexItem.INT_TITLE + ":\"" + sfbean.getTitle() + "\" ");
		}
		if(sfbean.getDateityp() != null && sfbean.getDateityp().length()>0){
			if(querystring.length() > 0){
				querystring.append("AND ");
			}
			querystring.append(DMSIndexItem.TYPE + ":\"" + sfbean.getDateityp() + "\" ");
		}
		if(sfbean.getKategorie1() != null && sfbean.getKategorie1().length()>0){
			if(querystring.length() > 0){
				querystring.append("AND ");
			}
			querystring.append(DMSIndexItem.KAT1 + ":\"" + sfbean.getKategorie1() + "\" ");
		}
		if(sfbean.getKategorie2() != null && sfbean.getKategorie2().length()>0){
			if(querystring.length() > 0){
				querystring.append("AND ");
			}
			querystring.append(DMSIndexItem.KAT2 + ":\"" + sfbean.getKategorie2() + "\" ");
		}
		if(sfbean.getSuchbegriff() != null && sfbean.getSuchbegriff().length()>0){
			if(querystring.length() > 0){
				querystring.append("AND ");
			}
			querystring.append("(" + sfbean.getSuchbegriff() + ")");
		}
		System.out.println(querystring);
		hits = mainpanel.getDms().getDMSFh().search(querystring.toString());
		
		mainpanel.getDoclistPanel().setHits(hits);
		
		return hits;
	}

}
