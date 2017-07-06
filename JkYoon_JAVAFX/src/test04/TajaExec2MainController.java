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
 * 1. FXML에 있는 fx:id를 Controller 자바에  변수 선언한다.
 * 2. 이벤트 초기화	intiEvent()
 * 3. 다음단어 호출	setLabelTextSetting()
 * 4. 글자내려오는것을 먼저하였다.	setDownLabel()
 * 5. 맨마지막은 게임종료를 마지막으로한다.
 * 6. 진짜맨마지막은 UI정리 및 소스정리 
 */
public class TajaExec2MainController implements Initializable{
	
	// 게임 패넬
    @FXML Pane paneGame;
    
	// 점수
	@FXML Label labelScore;
	
    // 입력하는곳
 	@FXML TextField txtInput;
    
	// 글자 라벨
	Label labelWord;
	
	//게임시작 버튼
	@FXML Button btnStart;
	
	//게임종료 버튼
	@FXML Button btnEnd;
	
	// 단어
	String comWord = "";
	
	// 단어집 Class
	ComputerWord cpWord ;
	
	// 점수
	int score = 0;
	
	// 게임 오버 플래그
	boolean gameBoolean = false;
	
	
	/**
	 * 초기실행
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	 
		// 이벤트 초기화
		intiEvent();
		 
		// 다음단어 호출
		setLabelTextSetting();
		
		
	}


	/**
	 * @method : setLabelTextSetting
	 * @parmam : 
	 * @return : void
	 * @description : 다음단어 호출
	 */
	private void setLabelTextSetting() {
		cpWord = new ComputerWord();
		String str = cpWord.getComWord();
		
		// 좌우로 왔다갔다하게 하기위해서
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
	 * @description : 화면 UI초기화
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
	 * @description : 게임종료 메소드
	 */
	private void endGame() {
		
		System.out.println("endGame");
		
		if(score <= -300){
			//Platform.exit();
			
			Stage myDialog = new Stage();
            myDialog.initModality(Modality.WINDOW_MODAL);
           
            
            // java1.7에는 Aerlt이 없기때문에 Scene으로 대체함. //			 Alert alert = new Alert(AlertType.INFORMATION);
            Scene myDialogScene = new Scene(VBoxBuilder.create().children(new Text("게임종료"))
                    .alignment(Pos.CENTER)
                    .padding(new javafx.geometry.Insets(30))
                    .build());
            myDialog.setScene(myDialogScene);
            myDialog.show();
            
            // 게임종료플래그
            gameBoolean = true;
            
			return;
			
		}
		
	}
	
	/**
	 * @method : intiEvent
	 * @parmam : 
	 * @return : void
	 * @description : 초기 이벤트 설정하기
	 */
	private void intiEvent() { 
		
		// 게임시작 버튼 이벤트
		btnStart.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				//UI 초기화
				intiUI(true);
				
				// 포커스
				txtInput.setFocusTraversable(true);	
				
				// Label내려오게 하기
				setDownLabel();
			}
		});
		
		
		// 종료버튼 이벤트
		btnEnd.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				 Platform.exit();
				
			}
		});
		
		// TextField 박스 이벤트
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
						labelScore.setText("점수 : " + score);
						
						//다음단어 호출
						setLabelTextSetting();			  
					}else{
						score -= 100;
						labelScore.setText("점수 : " + score);
						//-300점 이하면 게임종료
						
					}
					
					//-300점 이하면 게임종료
					endGame();
					
					txtInput.setText(""); // TextField 초기화
					
				}
			}
			
		});
	}
	 
	/**
	 * @method : setDownLabel
	 * @parmam : 
	 * @return : void
	 * @description : Label내려오게 하기
	 */
	private void setDownLabel() {
		final Timeline tl = new Timeline();
		
		//무한루프로 돌게 할것인지
		tl.setCycleCount(Animation.INDEFINITE);
		
		
		// Timeline ( 어디부터(KeyFrame), 어디까지(KeyFrame))
    	// KeyFrame (시간, KeyValue)
    	// KeyValue(시작, 종료)
		KeyFrame keyFrameLabelWord = new KeyFrame(Duration.seconds(.0200),
				new EventHandler<ActionEvent>() {

					public void handle(ActionEvent event) {
						
						// Y좌표를 +1로이동 한다.
						labelWord.setTranslateY(labelWord.getTranslateY()+1);
				
						// 한글워드가 판넬의 높이-11 같거나 워드가 Y좌표가 클때 
						if(paneGame.getHeight()-11 <= labelWord.getTranslateY() ){
							
							System.out.println("1111111111");
							score -= 100;
							
							tl.impl_finished();// 타임라인 finished
							System.out.println("22222222222222");
							
							labelScore.setText("점수 : " + score);
							
							// 종료하기 위해서 score가 -300이하 일경우 gameBoolean을 true처리함.
							if(score <= -300){
								gameBoolean = true; 
							}
							
						}
						
			            // 게임종료플래그
						if(gameBoolean){
							tl.stop(); // 타임라인 stop
						}
						
					}
	    });
		
		// Timeline이 끝나면
		tl.setOnFinished(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("gameBoolean = " + gameBoolean);
	            // 게임종료플래그
				if(gameBoolean){
					System.out.println("33333333333333333");
					
					//-300점 이하면 게임종료
					endGame();
					// 타임라인 stop
					tl.stop();
					
				}else{ // gameBoolean이 false일경우
					
					// 다음단어 호출
					setLabelTextSetting();
					
					// 새로운 라벨을 내려오는 것을 실행 시키기 위해서
					setDownLabel(); // 이함수르 재귀함수로 사용하였다.
				}
			}
		});
		
        // 게임종료플래그
		if(gameBoolean == false){
			 System.out.println("4444444444444444444444");
			 tl.getKeyFrames().add(keyFrameLabelWord);
			 tl.play();
		}
	}


 
	
	

}
