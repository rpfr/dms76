package de.rpfr.abt7.dms76;

import java.util.Map;

import de.rpfr.abt7.dms76.gui.EinstellenPane;
import de.rpfr.abt7.dms76.gui.HeaderPane;
import de.rpfr.abt7.dms76.gui.MainPane;
import de.rpfr.abt7.dms76.gui.StatisticPane;
import de.rpfr.abt7.dms76.gui.StatusPane;
import de.rpfr.abt7.dms76.util.DMSFileHandler;
import de.rpfr.abt7.dms76.util.DMSUtil;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class DMS76 extends Application {

	public final static String TITLE = "DMS76 - V1.0";

	private DMSUtil dmsUtil;
	private DMSFileHandler dmsFh;
	private StatusPane paneStatus;


	@Override
	public void init() throws Exception {
		super.init();
		Parameters p = getParameters();
		Map<String, String> named = p.getNamed();

		try {
			dmsUtil = DMSUtil.getInstance(named.get("initfile"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			dmsFh = DMSFileHandler.getInstance(this);

			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,600,880);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle(TITLE);
			primaryStage.setScene(scene);

			root.setTop(new HeaderPane(TITLE, 3000));
			
			TabPane tabPane = new TabPane();
			
			Tab searchTab = new Tab("Suche");
			searchTab.getStyleClass().add("tabpane");
			searchTab.setClosable(false);
			searchTab.setContent(new MainPane(this));
			tabPane.getTabs().add(searchTab);
			
			Tab uploadPane = new Tab("Neu");
			uploadPane.getStyleClass().add("tabpane");
			uploadPane.setClosable(false);
			uploadPane.setContent(new EinstellenPane(this));
			tabPane.getTabs().add(uploadPane);
			
			Tab statisticPane = new Tab("Statistik");
			statisticPane.getStyleClass().add("tabpane");
			statisticPane.setClosable(false);
			statisticPane.setContent(new StatisticPane(this, scene));
			tabPane.getTabs().add(statisticPane);
			
			root.setCenter(tabPane);

			paneStatus = new StatusPane();
			root.setBottom(paneStatus);

			primaryStage.show();

			setStatus("Alles wird gut :)"); 

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void stop() throws Exception {
		super.stop();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public DMSUtil getDMSUtil(){
		return dmsUtil;
	}

	public DMSFileHandler getDMSFh(){
		return dmsFh;
	}

	public void setStatus(String newStatus){
		Platform.runLater(()->paneStatus.setText(newStatus));
	}
}
