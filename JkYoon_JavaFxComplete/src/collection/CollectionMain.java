package collection;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @class : CollectionMain.java
 * @title : 
 * @author : Yoon
 * @desciption : Collection 객체만들기
 */
public class CollectionMain extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("CollectionMain.fxml"));
		
		Scene scense = new Scene(root);
		
		primaryStage.setTitle("CollectionMain");
		primaryStage.setScene(scense);
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
