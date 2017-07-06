package application;

import java.net.URL;
import java.util.ResourceBundle;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * @class : MainController.java
 * @title : 
 * @author : Yoon
 * @desciption : JavaFx 계산기
 * 
 * 
 * 
 * 
 * // Java에서는 ScriptEngine이라는 클래스를 통해 스크립팅 기능을 기본적으로 제공하고있다.
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		System.out.println(aaa);
		
		System.out.println(engine.eval(aaa).toString());
 */
public class MainController implements Initializable {
	
//	@FXML private Button button_0;
	
	@FXML private Button button_1;
	@FXML private Button button_2;
	@FXML private Button button_3;
	@FXML private Button button_4;
	@FXML private Button button_5;
	@FXML private Button button_6;
	@FXML private Button button_7;
	@FXML private Button button_8;
	@FXML private Button button_9;
	@FXML private Button button_divide;
	@FXML private Button button_multiple;
	@FXML private Button button_minus;
	@FXML private Button button_plus;
	@FXML private Button button_clear;
	@FXML private Button button_equal;
	@FXML private TextField textField_calculator;
	
	// 숫자 저장변수
	private double saveNumber;
	
	// 연산 저장변수
	private String saveOperator;
	
	// 숫자인지? 연산인지 체크 구분자
	private boolean isInitialize = true;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	@FXML
	public void onclickButton(ActionEvent event){
		
		String btnText = ((Button)event.getTarget()).getText();
		
		switch(btnText){
		case "0":
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":
			addNumber(btnText);
			break;
		case "/":
		case "*":
		case "-":
		case "+":
		case "=":
			calculate(btnText);
			break;
		case "C":
			break;
		}
	}
	
	/**
	 * @method : addNumber
	 * @parmam : 
	 * @return : void
	 * @description : 숫자추가함수
	 */
	public void addNumber(String strNum){
		if(isInitialize){
			textField_calculator.setText(strNum);
		}else{
			textField_calculator.setText(textField_calculator.getText()+strNum);
		}
		isInitialize = false;
	}
	
	/**
	 * @method : calculate
	 * @parmam : 
	 * @return : void
	 * @description : 연산자 함수
	 */
	public void calculate(String opt){
		
		if(saveOperator!=null){
			switch(saveOperator){
			case "/":
				saveNumber = saveNumber/Double.parseDouble(textField_calculator.getText());
				break;
			case "*":
				saveNumber = saveNumber*Double.parseDouble(textField_calculator.getText());
				break;
			case "-":
				saveNumber = saveNumber-Double.parseDouble(textField_calculator.getText());
				break;
			case "+":
				saveNumber = saveNumber+Double.parseDouble(textField_calculator.getText());
				break;
			}
			textField_calculator.setText(saveNumber+"");
		}else{
			saveNumber = Double.parseDouble(textField_calculator.getText());
		}
		
		saveOperator = opt;
		isInitialize = true;
	}
}
