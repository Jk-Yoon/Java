package test97_AnchorPaneChange;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @class : AnchorPaneMain.java
 * @title : 
 * @author : Yoon
 * @desciption : AnchorPane �޴��� �����ϸ� ������ Pane�� ����ǵ����ϱ�
 */
public class AnchorPaneMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("AnchorPaneMain.fxml"));
		
		Scene scense = new Scene(root);
		
		primaryStage.setTitle("AnchorPaneMain");
		primaryStage.setScene(scense);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
