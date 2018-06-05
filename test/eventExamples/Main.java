package eventExamples;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Main class to start the application.
 * 
 * @author Marco Jakob
 */
public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Event Handling");
		
		try {
//			FXMLLoader loader = new FXMLLoader(Main.class.getResource("EventHandling.fxml"));
//			AnchorPane page = (AnchorPane) loader.load();
                        Parent root = FXMLLoader.load(getClass().getResource("EventHandling.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
                        //System.exit(0);
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
