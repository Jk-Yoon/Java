package test03;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @class : TajaExecMain.java
 * @title : 
 * @author : Yoon
 * @desciption : 타자연습
 */
public class TajaExecMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("TajaExecMain.fxml"));
		
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("TajaExecMain");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch();
	}

}
