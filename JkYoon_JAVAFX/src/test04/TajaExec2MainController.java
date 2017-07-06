package test04;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import test03.ComputerWord;

/**
 * @class : TajaExec2MainController.java
 * @title : 
 * @author : Yoon
 * @desciption : 
 * 
 * 
 * 1. FXML�� �ִ� fx:id�� Controller �ڹٿ�  ���� �����Ѵ�.
 * 2. �̺�Ʈ �ʱ�ȭ	intiEvent()
 * 3. �����ܾ� ȣ��	setLabelTextSetting()
 * 4. ���ڳ������°��� �����Ͽ���.	setDownLabel()
 * 5. �Ǹ������� �������Ḧ �����������Ѵ�.
 * 6. ��¥�Ǹ������� UI���� �� �ҽ����� 
 */
public class TajaExec2MainController implements Initializable{
	
	// ���� �г�
    @FXML Pane paneGame;
    
	// ����
	@FXML Label labelScore;
	
    // �Է��ϴ°�
 	@FXML TextField txtInput;
    
	// ���� ��
	Label labelWord;
	
	//���ӽ��� ��ư
	@FXML Button btnStart;
	
	//�������� ��ư
	@FXML Button btnEnd;
	
	// �ܾ�
	String comWord = "";
	
	// �ܾ��� Class
	ComputerWord cpWord ;
	
	// ����
	int score = 0;
	
	// ���� ���� �÷���
	boolean gameBoolean = false;
	
	
	/**
	 * �ʱ����
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	 
		// �̺�Ʈ �ʱ�ȭ
		intiEvent();
		 
		// �����ܾ� ȣ��
		setLabelTextSetting();
		
		
	}


	/**
	 * @method : setLabelTextSetting
	 * @parmam : 
	 * @return : void
	 * @description : �����ܾ� ȣ��
	 */
	private void setLabelTextSetting() {
		cpWord = new ComputerWord();
		String str = cpWord.getComWord();
		
		// �¿�� �Դٰ����ϰ� �ϱ����ؼ�
		int width = ( int )( Math.random() * 500 );
		
		System.out.println(width);

		labelWord = new Label();
		labelWord.setText(str);
		labelWord.setLayoutX(width);
		
		paneGame.getChildren().add(labelWord);
		
		System.out.println(labelWord);
		
//		labelWordList.add(labelWord);
	}

	/**
	 * @method : intiUI
	 * @parmam : 
	 * @return : void
	 * @description : ȭ�� UI�ʱ�ȭ
	 */
	private void intiUI(boolean booleanValue) {
		txtInput.setVisible(booleanValue);
		labelWord.setVisible(booleanValue);
		btnStart.setVisible(!booleanValue);
		paneGame.setVisible(booleanValue);
		txtInput.setVisible(booleanValue);
	}
	
	
	/**
	 * @method : endGame
	 * @parmam : 
	 * @return : void
	 * @description : �������� �޼ҵ�
	 */
	private void endGame() {
		
		System.out.println("endGame");
		
		if(score <= -300){
			//Platform.exit();
			
			Stage myDialog = new Stage();
            myDialog.initModality(Modality.WINDOW_MODAL);
           
            
            // java1.7���� Aerlt�� ���⶧���� Scene���� ��ü��. //			 Alert alert = new Alert(AlertType.INFORMATION);
            Scene myDialogScene = new Scene(VBoxBuilder.create().children(new Text("��������"))
                    .alignment(Pos.CENTER)
                    .padding(new javafx.geometry.Insets(30))
                    .build());
            myDialog.setScene(myDialogScene);
            myDialog.show();
            
            // ���������÷���
            gameBoolean = true;
            
			return;
			
		}
		
	}
	
	/**
	 * @method : intiEvent
	 * @parmam : 
	 * @return : void
	 * @description : �ʱ� �̺�Ʈ �����ϱ�
	 */
	private void intiEvent() { 
		
		// ���ӽ��� ��ư �̺�Ʈ
		btnStart.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				//UI �ʱ�ȭ
				intiUI(true);
				
				// ��Ŀ��
				txtInput.setFocusTraversable(true);	
				
				// Label�������� �ϱ�
				setDownLabel();
			}
		});
		
		
		// �����ư �̺�Ʈ
		btnEnd.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				 Platform.exit();
				
			}
		});
		
		// TextField �ڽ� �̺�Ʈ
		txtInput.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if(event.getCode()==KeyCode.ENTER){
					System.out.println("txtInput.getText() " + txtInput.getText());
					System.out.println("labelWord.getText() " + labelWord.getText());
//							System.out.println("Key Pressed: " + txtInput.getText());
//							System.out.println("["+labelWord+"]" + "["+txtInput.getText()+"]");
					if(labelWord.getText().equals(txtInput.getText())){
						
						System.out.println("wwwwwwwwww");
						score += 100;
						
						paneGame.getChildren().remove(labelWord);
						labelScore.setText("���� : " + score);
						
						//�����ܾ� ȣ��
						setLabelTextSetting();			  
					}else{
						score -= 100;
						labelScore.setText("���� : " + score);
						//-300�� ���ϸ� ��������
						
					}
					
					//-300�� ���ϸ� ��������
					endGame();
					
					txtInput.setText(""); // TextField �ʱ�ȭ
					
				}
			}
			
		});
	}
	 
	/**
	 * @method : setDownLabel
	 * @parmam : 
	 * @return : void
	 * @description : Label�������� �ϱ�
	 */
	private void setDownLabel() {
		final Timeline tl = new Timeline();
		
		//���ѷ����� ���� �Ұ�����
		tl.setCycleCount(Animation.INDEFINITE);
		
		
		// Timeline ( ������(KeyFrame), ������(KeyFrame))
    	// KeyFrame (�ð�, KeyValue)
    	// KeyValue(����, ����)
		KeyFrame keyFrameLabelWord = new KeyFrame(Duration.seconds(.0200),
				new EventHandler<ActionEvent>() {

					public void handle(ActionEvent event) {
						
						// Y��ǥ�� +1���̵� �Ѵ�.
						labelWord.setTranslateY(labelWord.getTranslateY()+1);
				
						// �ѱۿ��尡 �ǳ��� ����-11 ���ų� ���尡 Y��ǥ�� Ŭ�� 
						if(paneGame.getHeight()-11 <= labelWord.getTranslateY() ){
							
							System.out.println("1111111111");
							score -= 100;
							
							tl.impl_finished();// Ÿ�Ӷ��� finished
							System.out.println("22222222222222");
							
							labelScore.setText("���� : " + score);
							
							// �����ϱ� ���ؼ� score�� -300���� �ϰ�� gameBoolean�� trueó����.
							if(score <= -300){
								gameBoolean = true; 
							}
							
						}
						
			            // ���������÷���
						if(gameBoolean){
							tl.stop(); // Ÿ�Ӷ��� stop
						}
						
					}
	    });
		
		// Timeline�� ������
		tl.setOnFinished(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("gameBoolean = " + gameBoolean);
	            // ���������÷���
				if(gameBoolean){
					System.out.println("33333333333333333");
					
					//-300�� ���ϸ� ��������
					endGame();
					// Ÿ�Ӷ��� stop
					tl.stop();
					
				}else{ // gameBoolean�� false�ϰ��
					
					// �����ܾ� ȣ��
					setLabelTextSetting();
					
					// ���ο� ���� �������� ���� ���� ��Ű�� ���ؼ�
					setDownLabel(); // ���Լ��� ����Լ��� ����Ͽ���.
				}
			}
		});
		
        // ���������÷���
		if(gameBoolean == false){
			 System.out.println("4444444444444444444444");
			 tl.getKeyFrames().add(keyFrameLabelWord);
			 tl.play();
		}
	}


 
	
	

}
