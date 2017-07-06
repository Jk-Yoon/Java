package test03;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @class : TajaExecMainController.java
 * @title : 
 * @author : Yoon
 * @desciption : Ÿ�ڿ���
 * 1. FXML�� �ִ� fx:id�� Controller �ڹٿ�  ���� �����Ѵ�.
 * 2. UI �ʱ�ȭ intiUI();
 * 3. �̺�Ʈ�ʱ�ȭ	intiEvent();
 * 
 * 
 */
public class TajaExecMainController implements Initializable{

	// �ܾ���°�
	@FXML Label labelWord;
	// ����
	@FXML Label labelScore;
	// �Է��ϴ°�
	@FXML TextField txtInput;
	// ���۹�ư
	@FXML Button btnStart;
	// �����ư
	@FXML Button btnFinish;
	// textArea ���ڿ� �ֱ�
	String textAreaStr = "";
	// �ؽ�Ʈ area
	@FXML TextArea txtAreaList;
	// �ܾ�
	String comWord = "";
	// ����
	int score = 0;
	
	
	// �ܾ��Է�
	@FXML Label labelA;
	
	// ��ǻ���� �ܾ ��� �´�.
	ComputerWord cpWord = new ComputerWord();	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// UI �ʱ� ����
		intiUI(false);
		
		// �ʱ� �̺�Ʈ �����ϱ�
		intiEvent();
		 
	}
	
	/**
	 * @method : intiUI
	 * @parmam : 
	 * @return : void
	 * @description : UI �ʱ� ����
	 */
	private void intiUI(boolean booleanValue) {
		txtAreaList.setVisible(booleanValue);
		txtInput.setVisible(booleanValue);
		labelWord.setVisible(booleanValue);
		btnStart.setVisible(!booleanValue);
		labelA.setVisible(booleanValue);
	}
	
	
	/**
	 * @method : intiEvent
	 * @parmam : 
	 * @return : void
	 * @description : �ʱ� �̺�Ʈ �����ϱ�
	 */
	private void intiEvent() {
		// ���ӽ�ŸƮ �̺�Ʈ
		btnStart.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				intiUI(true);
				startGame();
				
			}
		});
		
		// input �ڽ� �̺�Ʈ
		txtInput.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if(event.getCode()==KeyCode.ENTER){
//					System.out.println("Key Pressed: " + txtInput.getText());
//					System.out.println("["+labelWord+"]" + "["+txtInput.getText()+"]");
					// �󺧿��� ���� ���ڿ� �ؽ�Ʈ�ʵ�input���� ���� ���ڰ� �������
					if(labelWord.getText().equals(txtInput.getText())){
						
						System.out.println("wwwwwwwwww");
						score += 100;
						labelScore.setText("���� ���� : " + score);
					}else{
						score -= 100;
						labelScore.setText("���� ���� : " + score);
					}
					
					textAreaStr += "����� ģ�ܾ�� : " + txtInput.getText() + "\n\n"; 
					
					txtAreaList.setText(textAreaStr);
					
					nextWord();
					txtInput.setText(""); // TextField �ʱ�ȭ
					
					if(score == -300){
						Stage myDialog = new Stage();
						//�������� ����� �����Ѵ�.
						// APPLICATION_MODAL�θ�â���� ������ �ϴ°�
			            myDialog.initModality(Modality.WINDOW_MODAL  ); 
						// java1.7���� Aerlt�� ���⶧���� Scene���� ��ü��. //			 Alert alert = new Alert(AlertType.INFORMATION);
			            Scene myDialogScene = new Scene(VBoxBuilder.create().children(new Text("��������"))
			                    .alignment(Pos.CENTER)
			                    .padding(new javafx.geometry.Insets(30))
			                    .build());
			            myDialog.setScene(myDialogScene);
			            myDialog.show();
						
					}
				}
			}
		});
		
		// �����ư �̺�Ʈ
		btnFinish.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				 Platform.exit();
				
			}
		});
		
	}
	
	
	/**
	 * @method : startGame
	 * @parmam : 
	 * @return : void
	 * @description : ���ӽ����Լ�
	 */
	private void startGame() {
		System.out.println("StartGame");
		
		// ��Ŀ��
		txtInput.setFocusTraversable(true);	
		
		// �����ܾ� �������� �Լ�
		nextWord();
		
		System.out.println( comWord );
		
	}
	
	
	/**
	 * @method : nextWord
	 * @parmam : 
	 * @return : void
	 * @description : �����ܾ� �󺧿� �ֱ�
	 */
	private void nextWord() {
		
		comWord	= cpWord.getComWord();
		labelWord.setText(comWord);
		labelWord.setFont(new Font("Arial", 15)); // ��Ʈ������ ����
		
		textAreaStr += "�̹��ܾ�� : " +comWord + "\n"; 
		txtAreaList.setText(textAreaStr);
		
		// ��ũ�� �ǹ����� ������ �Ӽ�
		txtAreaList.setScrollTop(Double.MAX_VALUE);  
	}


	

	
	


}
