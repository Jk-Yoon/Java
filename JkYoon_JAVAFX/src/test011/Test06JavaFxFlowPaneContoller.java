package test011;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

/**
 * @class : Test06JavaFxFlowPaneContoller.java
 * @title : 
 * @author : Yoon
 * @desciption : FlowPane을 이용하여 버튼 만들기.
 */
public class Test06JavaFxFlowPaneContoller implements Initializable{

	@FXML FlowPane flowPane;
	
  	@FXML
    private Button btn01;

    @FXML
    private Button btn02;

    @FXML
    private Button btn03;

    @FXML
    private Button btn04;

    @FXML
    private Button btn05;

    @FXML
    private Button btn06;

    @FXML
    private Button btn07;

    @FXML
    private Button btn08;

    @FXML
    private Button btn09;

    @FXML
    private Button btn10;


	  
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// 코딩으로 Btn 만드는 방법
		Button btn = new Button();

	    for (int i = 0; i < 8; i++) {

	      btn = new Button("Button");
	      btn.setPrefSize(100, 50);
	      flowPane.getChildren().add(btn);
	    }


	}

}
