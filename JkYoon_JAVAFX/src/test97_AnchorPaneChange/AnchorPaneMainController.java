package test97_AnchorPaneChange;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * @class : AnchorPaneMainController.java
 * @title : 
 * @author : Yoon
 * @desciption : AnchorPane 메뉴를 선택하면 오른쪽 Pane이 변경되도록하기
 */
public class AnchorPaneMainController implements Initializable {
	
	
	@FXML
    private Pane mainPane;
	
	@FXML
    private Button btn1;

    @FXML
    private Button btn2;
	
	@FXML
    private Pane paneLeft;

    @FXML
    private Pane paneRight;
    // 448, 558
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		initEvent();
		
		
	}
	
	
	/**
	 * @method : initEvent
	 * @parmam : 
	 * @return : void
	 * @description : 이벤트 init()
	 */
	private void initEvent() {
		// btn 이벤트
		btn1.addEventHandler(ActionEvent.ACTION,  new EventHandler<Event>() {
			public void handle(Event event){
				System.out.println("11111111111111");
				
				
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("RightPane1.fxml"));
			     	Pane rightPan = (Pane) loader.load();
			     	paneRight.getChildren().clear();
			     	paneRight.getChildren().add(rightPan);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
		});
		
		// btn 이벤트
		btn2.addEventHandler(ActionEvent.ACTION,  new EventHandler<Event>() {
			public void handle(Event event){
				System.out.println("11111111111111");
				
				
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("RightPane2.fxml"));
			     	Pane rightPan = (Pane) loader.load();
			     	paneRight.getChildren().clear();
			     	paneRight.getChildren().add(rightPan);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
		} );
		
	}

}
