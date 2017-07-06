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
 * 1. ��ư�� �׸���. 0~9 ���ϱ� ������ ���ϱ� ����
 * 
 * // Java������ ScriptEngine�̶�� Ŭ������ ���� ��ũ���� ����� �⺻������ �����ϰ��ִ�.
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
	
	// ���� ���庯��
	private double saveNumber = 0.0f;
	
	// ���� ���庯��
	private String saveOperator = "";
	
	// ��������? ��������? üũ ������
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
	 * @description : ���� Ŭ����
	 */
	private void clearCalculate() {
		// ���� ���庯��
		saveNumber = 0.0f;
		
		// ���� ���庯��
		saveOperator = "";
		
		// ��������? ��������? üũ ������
		isInitialize = true;
		
		//����â Ŭ����
		textFieldCalculator.setText("");
		
	}

	/**
	 * @method : addNumber
	 * @parmam : 
	 * @return : void
	 * @description : �����߰��Լ� 
	 */
	public void addNumber(String strNum){
		System.out.println("addNumber() = " +strNum );
		if(isInitialize){
			textFieldCalculator.setText(strNum);
		}else{
			textFieldCalculator.setText(textFieldCalculator.getText()+strNum);
		}
		isInitialize = false;
		
//		// ����������������������������� ���� ���� Start ����������������������������������������������
//		if(textFieldCalculator.getText().indexOf(".") > 1){
//			System.out.println(".�� �ϳ��� �����Ͽ��� �մϴ�.");
//		}
//		
//		
//		// . �� 1���� ���
//		if(textFieldCalculator.getText().indexOf(".") == 1){
//			
//			String[] strTmp = textFieldCalculator.getText().split("\\.");
//			System.out.println("strTmp[0] = " + strTmp[0]);
//			// ������ϰ��
//			if(strTmp[0].equals("")){
//				textFieldCalculator.setText("0.");
//			}
//			
//		}
//		// ����������������������������� ���� ���� End ����������������������������������������������
		
		
	}
	
	/**
	 * @method : calculate
	 * @parmam : 
	 * @return : void
	 * @description : ����Լ�
	 * 		saveOperator �� ������ ���� ������ ���ڸ� �Է��ϰ� �����ڸ� �ְ� �ٽ� ���ڸ� �ְ� ����ؾ��ϱ⶧���� ���������� �־���.
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
			
			// �̺κ��� = �̴�.
			textFieldCalculator.setText(saveNumber+"");
			System.out.println("saveNumber = " + saveNumber);
			
		} else {
			
			saveNumber = Double.parseDouble(textFieldCalculator.getText());
			
		}
		
		saveOperator = opt;
		isInitialize = true;
	}
}
