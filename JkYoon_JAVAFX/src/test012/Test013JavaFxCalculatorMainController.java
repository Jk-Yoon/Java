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
 * @class : Test012JavaFxCalculatorMainController.java
 * @title : 
 * @author : Yoon
 * @desciption : 
 * 1. ��ư�� �׸���. 0~9 ���ϱ� ������ ���ϱ� ����
 * 
 * // Java������ ScriptEngine�̶�� Ŭ������ ���� ��ũ���� ����� �⺻������ �����ϰ��ִ�.
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
	
	// ó�����ʹٽ�
	private boolean isInitialize = true;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
	}
	
	/**
	 * @method : onclickButton
	 * @parmam : 
	 * @return : void
	 * @description : ��ư�̺�Ʈ
	 */
	@FXML
	public void onclickButton(ActionEvent event){
		
		// ��ư�� �ؽ�Ʈ�� �����´�.
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
	 * @description : ���� Ŭ����
	 */
	public void clearCalculate(){
		textFieldCalculator.setText("");
		isInitialize = true;
	}
 
	/**
	 * @method : addNumber
	 * @parmam : 
	 * @return : void
	 * @description : �����߰��Լ� 
	 */
	public void addNumber(String strNum){
		
		// ó�� �߰��Ҷ�
		if(isInitialize){
			
			textFieldCalculator.setText(textFieldCalculator.getText()+strNum);
			
		}else{
			// ������ ���� ���� ������� ��Ģ�����̸�
			if(strNum.equals("/") || strNum.equals("*") || strNum.equals("-") || strNum.equals("+")){
				textFieldCalculator.setText(textFieldCalculator.getText()+strNum);
			}else{
				// ������ ���� ���� ���� ���鼭 �����ϰ��
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
	 * @description : ����Լ�
	 * 		saveOperator �� ������ ���� ������ ���ڸ� �Է��ϰ� �����ڸ� �ְ� �ٽ� ���ڸ� �ְ� ����ؾ��ϱ⶧���� ���������� �־���.
	 */
	public void calculate(){ 
		// Java������ ScriptEngine�̶�� Ŭ������ ���� ��ũ���� ����� �⺻������ �����ϰ��ִ�.	jdk 1.6���� ������.
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
