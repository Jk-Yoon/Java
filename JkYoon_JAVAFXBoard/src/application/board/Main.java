package application.board;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


/**
 * @class : Main.java
 * @title : 
 * @author : Yoon
 * @desciption : 게시판 예제
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("controller/Main.fxml"));
			
			BorderPane root = (BorderPane) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		 
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
