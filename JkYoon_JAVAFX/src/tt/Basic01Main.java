package tt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Basic01Main extends Application{

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("BasicMain.fxml"));
		
		AnchorPane root = (AnchorPane) loader.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Basic01");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
