package test04;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @class : TajaExec2Main.java
 * @title : 
 * @author : Yoon
 * @desciption : 타자연습메인
 */
public class TajaExec2Main extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("TajaExec2Main.fxml"));
		
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("TajaExec2Main");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
