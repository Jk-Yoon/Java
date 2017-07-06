package test01;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @class : Test03JavaFxFXML.java
 * @title : 
 * @author : Yoon
 * @desciption : FXML로 화면 로드하는 방법
 */
public class Test03JavaFxFXMLMain extends Application {

	
	@Override
	public void start(Stage primaryStage) throws IOException {
		// fxml파일을 읽어와 현재 Stage에 적용하는 방법
		// Parent객체 -> 컨트롤 객체들 중 최상위 추상 클래스
		
		/** 방법1
		Parent root = FXMLLoader.load(getClass().getResource("Test03JavaFxFXML.fxml"));
		**/
		
		// 방법 2
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Test03JavaFxFXML.fxml"));
		Parent root = (Parent) loader.load();		
	
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("Test03JavaFxFXMLMain.css").toExternalForm());
		
		
		primaryStage.setTitle("Test03JavaFxFXML");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
