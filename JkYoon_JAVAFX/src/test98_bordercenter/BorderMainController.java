package test98_bordercenter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class BorderMainController implements Initializable {

	@FXML BorderPane Main;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 
		try {
			intiUI();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
	}

	private void intiUI() throws IOException {
		
		FXMLLoader loaderLeft = new FXMLLoader(getClass().getResource("Left.fxml"));
     	Pane leftPane = (Pane) loaderLeft.load();
     	Main.setLeft(leftPane);
		
		FXMLLoader loaderCenter = new FXMLLoader( getClass().getResource("Center1.fxml"));
     	Pane centerPane = (Pane) loaderCenter.load();
     	Main.setCenter(centerPane);
		
	}

}
