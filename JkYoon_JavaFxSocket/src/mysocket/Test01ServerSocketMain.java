package mysocket;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test01ServerSocketMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		Parent root = FXMLLoader.load(getClass().getResource("Test01ServerSocketMain.fxml"));

		 
     	
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("Test01ServerSocketMain");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
