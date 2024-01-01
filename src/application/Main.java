package application;
	
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
private static final Logger logger = Logger.getLogger("ToyStoreLog");

	/**
	 * 
	 * @author Pasha & Emilio
	 * 
	 * 
	 */

	
	@Override
	public void start(Stage primaryStage) {
		try {
			FileHandler fh = new FileHandler("doc/ToyLogFile.log", true);
	        logger.addHandler(fh);	
			Parent root = FXMLLoader.load(getClass().getResource("../view/interface.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../model/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}


}