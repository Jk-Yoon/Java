package test01;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * @class : Test03JavaFxFXMLContoller.java
 * @title : 
 * @author : Yoon
 * @desciption : FXML을 이용한 이벤트 적용
 * 
 * 1. textField을 만들고 버튼을 만든다.
 * 2. 버튼에 onAction="#onClickEvent"을 추가한다.
 * 
 */
public class Test03JavaFxFXMLContoller implements Initializable {

	@FXML
	private TextField txt;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

	@FXML
	public void onClickEvent(ActionEvent event){
		txt.setText("onClickEvent()");
	}
	
	

}
