package test012;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * @class : Test013JavaFxCalculatorMainController.java
 * @title : 
 * @author : Yoon
 * @desciption : 
 * 1. 버튼을 그린다. 0~9 더하기 나누기 곱하기 빼기
 * 
 * // Java에서는 ScriptEngine이라는 클래스를 통해 스크립팅 기능을 기본적으로 제공하고있다.
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		System.out.println(aaa);
		
		System.out.println(engine.eval(aaa).toString());
 */
public class Test013JavaFxCalculatorMainController implements Initializable {
	@FXML private Button button_dot;
	@FXML private Button button_0;
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
	@FXML private TextField textFieldCalculator;
	
	// 처음부터다시
	private boolean isInitialize = true;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
	}
	
	/**
	 * @method : onclickButton
	 * @parmam : 
	 * @return : void
	 * @description : 버튼이벤트
	 */
	@FXML
	public void onclickButton(ActionEvent event){
		
		// 버튼의 텍스트를 가져온다.
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
			case ".":
			case "/":
			case "*":
			case "-":
			case "+":
				addNumber(btnText);
				break;
			case "=":
				calculate();
				break;
			case "C":
				clearCalculate();
				break;
		}
		
		
	}
	

	/**
	 * @method : clearCalculate
	 * @parmam : 
	 * @return : void
	 * @description : 변수 클리어
	 */
	public void clearCalculate(){
		textFieldCalculator.setText("");
		isInitialize = true;
	}
 
	/**
	 * @method : addNumber
	 * @parmam : 
	 * @return : void
	 * @description : 숫자추가함수 
	 */
	public void addNumber(String strNum){
		
		// 처음 추가할때
		if(isInitialize){
			
			textFieldCalculator.setText(textFieldCalculator.getText()+strNum);
			
		}else{
			// 기존에 계산된 값이 있을경우 사칙연산이면
			if(strNum.equals("/") || strNum.equals("*") || strNum.equals("-") || strNum.equals("+")){
				textFieldCalculator.setText(textFieldCalculator.getText()+strNum);
			}else{
				// 기존에 계산된 값이 있을 경우면서 숫자일경우
				textFieldCalculator.setText("");
				textFieldCalculator.setText(textFieldCalculator.getText()+strNum);
			}
			
			
			isInitialize = true;
		}
		
		
	}
	
	/**
	 * @method : calculate
	 * @parmam : 
	 * @return : void
	 * @description : 계산함수
	 * 		saveOperator 를 별도로 쓰는 이유는 숫자를 입력하고 연산자를 넣고 다시 숫자를 넣고 계산해야하기때문에 전역변수로 넣었음.
	 */
	public void calculate(){ 
		// Java에서는 ScriptEngine이라는 클래스를 통해 스크립팅 기능을 기본적으로 제공하고있다.	jdk 1.6에서 제공함.
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		
		try {
			textFieldCalculator.setText(engine.eval(textFieldCalculator.getText()).toString());
			isInitialize = false;
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
