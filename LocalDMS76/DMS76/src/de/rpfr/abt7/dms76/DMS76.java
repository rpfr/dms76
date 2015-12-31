package de.rpfr.abt7.dms76;

import java.util.Map;

import de.rpfr.abt7.dms76.gui.HeaderPane;
import de.rpfr.abt7.dms76.gui.MainPane;
import de.rpfr.abt7.dms76.gui.StatusPane;
import de.rpfr.abt7.dms76.util.DMSFileHandler;
import de.rpfr.abt7.dms76.util.DMSUtil;
import javafx.application.Application;
import javafx.scene.Scene;
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
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,550,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle(TITLE);
			primaryStage.setScene(scene);

			root.setTop(new HeaderPane(TITLE, 3000));
			root.setCenter(new MainPane(this));
			
			paneStatus = new StatusPane();
			root.setBottom(paneStatus);

			primaryStage.show();
			
			setStatus("Alles wird gut :)"); 
			
			
			dmsFh = DMSFileHandler.getInstance(this);
			dmsFh.checkDirectory(dmsUtil.getProperty(DMSUtil.PROP_TARGETDIR));
			

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

	public void setStatus(String newStatus){
		paneStatus.setText(newStatus);
	}
}
