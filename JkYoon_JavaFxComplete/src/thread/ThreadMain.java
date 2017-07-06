package thread;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @class : ThreadMain.java
 * @title : 
 * @author : Yoon
 * @desciption : 
 */
public class ThreadMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("ThreadMain.fxml"));
		
		Scene scense = new Scene(root);
		
		primaryStage.setTitle("ThreadMain");
		primaryStage.setScene(scense);
		primaryStage.show(); 
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
