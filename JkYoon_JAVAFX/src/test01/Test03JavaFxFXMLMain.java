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
 * @desciption : FXML�� ȭ�� �ε��ϴ� ���
 */
public class Test03JavaFxFXMLMain extends Application {

	
	@Override
	public void start(Stage primaryStage) throws IOException {
		// fxml������ �о�� ���� Stage�� �����ϴ� ���
		// Parent��ü -> ��Ʈ�� ��ü�� �� �ֻ��� �߻� Ŭ����
		
		/** ���1
		Parent root = FXMLLoader.load(getClass().getResource("Test03JavaFxFXML.fxml"));
		**/
		
		// ��� 2
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
