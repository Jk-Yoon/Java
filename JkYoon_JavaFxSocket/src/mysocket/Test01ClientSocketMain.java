package mysocket;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @class : Test01ClientSocketMain.java
 * @title : 
 * @author : Yoon
 * @desciption : 
 */
public class Test01ClientSocketMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("Test01ClientSocketMain.fxml"));

		Scene scene = new Scene(root);
		
		primaryStage.setTitle("Test01ClientSocketMain");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
