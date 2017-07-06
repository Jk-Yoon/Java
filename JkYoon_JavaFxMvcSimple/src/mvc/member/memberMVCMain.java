package mvc.member;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class memberMVCMain extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("memberMVCMain.fxml"));
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("MemberMVCMain");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
