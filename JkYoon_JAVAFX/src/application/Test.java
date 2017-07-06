package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent pa = FXMLLoader.load(getClass().getResource("ServerOn.fxml"));
		
		Scene scene = new Scene(pa);
		primaryStage.setScene(scene);
		primaryStage.setTitle("�뿰�뒿");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
