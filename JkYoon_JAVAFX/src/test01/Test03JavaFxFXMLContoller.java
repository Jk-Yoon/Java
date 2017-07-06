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
 * @desciption : FXML�� �̿��� �̺�Ʈ ����
 * 
 * 1. textField�� ����� ��ư�� �����.
 * 2. ��ư�� onAction="#onClickEvent"�� �߰��Ѵ�.
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
