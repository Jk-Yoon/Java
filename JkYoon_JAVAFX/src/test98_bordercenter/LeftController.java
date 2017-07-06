package test98_bordercenter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * @class : LeftController.java
 * @title : 
 * @author : Yoon
 * @desciption : 레프트 메뉴
 */
public class LeftController implements Initializable {

	@FXML Button testBtn1;
	
	@FXML Button testBtn2;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		eventInit();
		
	}
	
	
	private void eventInit() {
		// 버튼1
		testBtn1.setOnAction(new EventHandler<ActionEvent>() {
	         @Override 
	         public void handle(ActionEvent e) {
	        	 
	        	BorderPane root = (BorderPane) testBtn1.getScene().getRoot();
	        	Pane pane;
		     	FXMLLoader loader = new FXMLLoader(getClass().getResource("Center1.fxml"));
		     		 
				try {
					pane = (Pane) loader.load();
					root.setCenter(pane);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
 
	         }
	     });
		
		// 버튼2
		testBtn2.setOnAction(new EventHandler<ActionEvent>() {
	         @Override 
	         public void handle(ActionEvent e) {
	        	 
	        	BorderPane root = (BorderPane) testBtn1.getScene().getRoot();
	        	Pane pane;
		     	FXMLLoader loader = new FXMLLoader(getClass().getResource("Center2.fxml"));
		     		 
				try {
					pane = (Pane) loader.load();
					root.setCenter(pane);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

	         }
	     });
		
		
	}

}
