package test012;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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
 * 1. 버튼을 그린다. 0~9 더하기 나누기 곱하기 빼기
 * 
 * // Java에서는 ScriptEngine이라는 클래스를 통해 스크립팅 기능을 기본적으로 제공하고있다.
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		System.out.println(aaa);
		
		System.out.println(engine.eval(aaa).toString());
 */
public class Test012JavaFxCalculatorMainController implements Initializable {
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
	
	// 숫자 저장변수
	private double saveNumber = 0.0f;
	
	// 연산 저장변수
	private String saveOperator = "";
	
	// 숫자인지? 연산인지? 체크 구분자
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
	private void clearCalculate() {
		// 숫자 저장변수
		saveNumber = 0.0f;
		
		// 연산 저장변수
		saveOperator = "";
		
		// 숫자인지? 연산인지? 체크 구분자
		isInitialize = true;
		
		//계산기창 클리어
		textFieldCalculator.setText("");
		
	}

	/**
	 * @method : addNumber
	 * @parmam : 
	 * @return : void
	 * @description : 숫자추가함수 
	 */
	public void addNumber(String strNum){
		System.out.println("addNumber() = " +strNum );
		if(isInitialize){
			textFieldCalculator.setText(strNum);
		}else{
			textFieldCalculator.setText(textFieldCalculator.getText()+strNum);
		}
		isInitialize = false;
		
//		// ■■■■■■■■■■■■■■■■■■■■■■■■■■■■ 숙제 영역 Start ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
//		if(textFieldCalculator.getText().indexOf(".") > 1){
//			System.out.println(".은 하나만 존재하여야 합니다.");
//		}
//		
//		
//		// . 이 1개일 경우
//		if(textFieldCalculator.getText().indexOf(".") == 1){
//			
//			String[] strTmp = textFieldCalculator.getText().split("\\.");
//			System.out.println("strTmp[0] = " + strTmp[0]);
//			// 빈공간일경우
//			if(strTmp[0].equals("")){
//				textFieldCalculator.setText("0.");
//			}
//			
//		}
//		// ■■■■■■■■■■■■■■■■■■■■■■■■■■■■ 숙제 영역 End ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		
		
	}
	
	/**
	 * @method : calculate
	 * @parmam : 
	 * @return : void
	 * @description : 계산함수
	 * 		saveOperator 를 별도로 쓰는 이유는 숫자를 입력하고 연산자를 넣고 다시 숫자를 넣고 계산해야하기때문에 전역변수로 넣었음.
	 */
	public void calculate(String opt){
		
		if(!"".equals(saveOperator)){
			
			switch(saveOperator){
			
				case "/":
					saveNumber = saveNumber/Double.parseDouble(textFieldCalculator.getText());
					break;
					
				case "*":
					
					saveNumber = saveNumber*Double.parseDouble(textFieldCalculator.getText());
					break;
					
				case "-":
					
					saveNumber = saveNumber-Double.parseDouble(textFieldCalculator.getText());
					break;
					
				case "+":
					
					saveNumber = saveNumber+Double.parseDouble(textFieldCalculator.getText());
					break;
					
			}
			
			// 이부분은 = 이다.
			textFieldCalculator.setText(saveNumber+"");
			System.out.println("saveNumber = " + saveNumber);
			
		} else {
			
			saveNumber = Double.parseDouble(textFieldCalculator.getText());
			
		}
		
		saveOperator = opt;
		isInitialize = true;
	}
}
