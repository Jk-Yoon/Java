package test011;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @class : Test06JavaFxFlowPaneMain.java
 * @title : 
 * @author : Yoon
 * @desciption : FlowPane을 설명하기 위해서 버튼을 나열함.
 */
public class Test06JavaFxFlowPaneMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Test06JavaFxFlowPaneMain.fxml"));
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("Test06JavaFxFlowPaneMain");
		primaryStage.setScene(scene);
		primaryStage.show(); 
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
