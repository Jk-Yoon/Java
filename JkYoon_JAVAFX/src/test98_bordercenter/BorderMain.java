package test98_bordercenter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @class : BorderMain.java
 * @title : 
 * @author : Yoon
 * @desciption : 
 * 
 * borderPane을 가지고 Left메뉴에서 버튼 클릭시 Center를 변경시켜주는 연습 
 */
public class BorderMain extends Application{


	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane root = FXMLLoader.load(getClass().getResource("Main.fxml"));

		 
     	
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("BorderMain");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch();
	}

}
