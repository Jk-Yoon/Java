package test05fileupload;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @class : FileUploadMain.java
 * @title : 
 * @author : Yoon
 * @desciption : 파일업로드
 */
public class FileUploadMain extends Application  {
	@Override
	public void start(Stage primaryStage) throws Exception {
		 
	        
		Parent root = FXMLLoader.load(getClass().getResource("FileUploadMain.fxml"));
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("FileUploadMain");
		primaryStage.setScene(scene);
		primaryStage.show();
	        
	        
	     
	   }

		
	
	public static void main(String[] args) {
		launch(args);
	}

}
