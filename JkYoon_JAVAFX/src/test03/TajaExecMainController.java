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
 * @desciption : 타자연습
 * 1. FXML에 있는 fx:id를 Controller 자바에  변수 선언한다.
 * 2. UI 초기화 intiUI();
 * 3. 이벤트초기화	intiEvent();
 * 
 * 
 */
public class TajaExecMainController implements Initializable{

	// 단어나오는곳
	@FXML Label labelWord;
	// 점수
	@FXML Label labelScore;
	// 입력하는곳
	@FXML TextField txtInput;
	// 시작버튼
	@FXML Button btnStart;
	// 종료버튼
	@FXML Button btnFinish;
	// textArea 문자열 넣기
	String textAreaStr = "";
	// 텍스트 area
	@FXML TextArea txtAreaList;
	// 단어
	String comWord = "";
	// 점수
	int score = 0;
	
	
	// 단어입력
	@FXML Label labelA;
	
	// 컴퓨터의 단어를 얻어 온다.
	ComputerWord cpWord = new ComputerWord();	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// UI 초기 설정
		intiUI(false);
		
		// 초기 이벤트 설정하기
		intiEvent();
		 
	}
	
	/**
	 * @method : intiUI
	 * @parmam : 
	 * @return : void
	 * @description : UI 초기 설정
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
	 * @description : 초기 이벤트 설정하기
	 */
	private void intiEvent() {
		// 게임스타트 이벤트
		btnStart.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				intiUI(true);
				startGame();
				
			}
		});
		
		// input 박스 이벤트
		txtInput.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if(event.getCode()==KeyCode.ENTER){
//					System.out.println("Key Pressed: " + txtInput.getText());
//					System.out.println("["+labelWord+"]" + "["+txtInput.getText()+"]");
					// 라벨에서 나온 글자와 텍스트필드input에서 나온 글자가 같을경우
					if(labelWord.getText().equals(txtInput.getText())){
						
						System.out.println("wwwwwwwwww");
						score += 100;
						labelScore.setText("정답 점수 : " + score);
					}else{
						score -= 100;
						labelScore.setText("오답 점수 : " + score);
					}
					
					textAreaStr += "당신이 친단어는 : " + txtInput.getText() + "\n\n"; 
					
					txtAreaList.setText(textAreaStr);
					
					nextWord();
					txtInput.setText(""); // TextField 초기화
					
					if(score == -300){
						Stage myDialog = new Stage();
						//스테이지 양식을 지정한다.
						// APPLICATION_MODAL부모창으로 못가게 하는것
			            myDialog.initModality(Modality.WINDOW_MODAL  ); 
						// java1.7에는 Aerlt이 없기때문에 Scene으로 대체함. //			 Alert alert = new Alert(AlertType.INFORMATION);
			            Scene myDialogScene = new Scene(VBoxBuilder.create().children(new Text("게임종료"))
			                    .alignment(Pos.CENTER)
			                    .padding(new javafx.geometry.Insets(30))
			                    .build());
			            myDialog.setScene(myDialogScene);
			            myDialog.show();
						
					}
				}
			}
		});
		
		// 종료버튼 이벤트
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
	 * @description : 게임시작함수
	 */
	private void startGame() {
		System.out.println("StartGame");
		
		// 포커스
		txtInput.setFocusTraversable(true);	
		
		// 다음단어 가져오는 함수
		nextWord();
		
		System.out.println( comWord );
		
	}
	
	
	/**
	 * @method : nextWord
	 * @parmam : 
	 * @return : void
	 * @description : 다음단어 라벨에 넣기
	 */
	private void nextWord() {
		
		comWord	= cpWord.getComWord();
		labelWord.setText(comWord);
		labelWord.setFont(new Font("Arial", 15)); // 폰트사이즈 설정
		
		textAreaStr += "이번단어는 : " +comWord + "\n"; 
		txtAreaList.setText(textAreaStr);
		
		// 스크롤 맨밑으로 보내는 속성
		txtAreaList.setScrollTop(Double.MAX_VALUE);  
	}


	

	
	


}
