package test012;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @class : Test012JavaFxCalculatorMain.java
 * @title : 
 * @author : Yoon
 * @desciption : °è»ê±â
 */
public class Test013JavaFxCalculatorMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Test013JavaFxCalculatorMain.fxml"));
		BorderPane root = (BorderPane) loader.load();
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
	}
	
	/**
	 * @method : main
	 * @parmam : 
	 * @return : void
	 * @description : 
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
