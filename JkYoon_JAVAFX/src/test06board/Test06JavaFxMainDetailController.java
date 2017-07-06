package test06board;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import test06board.vo.BoardVO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @class : Test06JavaFxMainDetailController.java
 * @title : 
 * @author : Yoon
 * @desciption : 등록/수정/수정/ Controller
 */
public class Test06JavaFxMainDetailController implements Initializable {
	
	// 글번호
	@FXML private TextField txtNo;
	
	// 제목
	@FXML private TextField txtTitle;
	
	// 작성자
	@FXML private TextField txtName;
	
	// 저장
	@FXML private Button btnSave;
	
	// 목록
	@FXML private Button btnList;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @method : onclickList
	 * @parmam : 
	 * @return : void
	 * @throws IOException 
	 * @description : 
	 */
	public void onclickList() throws IOException {
		// 중요 새로운 Stage를 만들기때문에 기존에 쓴 Stage를 버리고 새로운것을 만들기때문에 새로운 Controller의 selectListData()함수를 실행시킨다.
		Stage stage = (Stage) txtNo.getScene().getWindow();
		// Test06JavaFxMain.fxml로 부터 컴포넌트를 불러와서 Scene에 배치
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Test06JavaFxMain.fxml"));
		BorderPane root = (BorderPane) loader.load();
		
		//fxmml에서 불러온 패널을 씬에 설정함.
		Scene scene = new Scene(root);
		stage.setTitle("Test06JavaFxMain");
		// 스테이지에 씬을 붙임
		stage.setScene(scene);
		// 스테이지를 보여줌
		stage.show();
	}
	
	/**
	 * @method : onclickSave
	 * @parmam : 
	 * @return : void
	 * @throws IOException 
	 * @description : 저장 이벤트
	 */
	public void onclickSave() throws IOException {
		System.out.println("onclickSave()");
		//String str = ((Button)e.getTarget()).getText(); 이벤트를 하나로 할때 이런방법도 있다.
 
		String boardId = txtNo.getText();
		BoardVO boardVO = new BoardVO();
		 
		// 신규 글 추가
		if("".equals(boardId)){
			int nextSize = Test06JavaFxMainController.list.size() + 1;
			String nextSizeIndex = String.valueOf(nextSize);
			
			
			boardVO.setBoardId(nextSizeIndex);
			boardVO.setBoardTitle(txtTitle.getText());
			boardVO.setBoardWriter(txtTitle.getText());
			boardVO.setBoardContent(txtName.getText());
			
			//객체추가
			Test06JavaFxMainController.list.add(boardVO);
		}else{ // 수정하기
			boardVO.setBoardId(txtNo.getText());
			boardVO.setBoardTitle(txtTitle.getText());
			boardVO.setBoardWriter(txtTitle.getText());
			boardVO.setBoardContent(txtName.getText());
			BoardVO tmpBoardVO = new BoardVO();
			for( int i = 0 ; i < Test06JavaFxMainController.list.size(); i++ ){
				tmpBoardVO = new BoardVO();
				
				tmpBoardVO = Test06JavaFxMainController.list.get(i);
				if(tmpBoardVO.getBoardId().equals(txtNo.getText())){
					Test06JavaFxMainController.list.set(i, boardVO);
				}
				
			}
			
			
		}
		 
		
		// 중요 새로운 Stage를 만들기때문에 기존에 쓴 Stage를 버리고 새로운것을 만들기때문에 새로운 Controller의 selectListData()함수를 실행시킨다.
		Stage stage = (Stage) txtNo.getScene().getWindow();
		// Test06JavaFxMain.fxml로 부터 컴포넌트를 불러와서 Scene에 배치
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Test06JavaFxMain.fxml"));
		BorderPane root = (BorderPane) loader.load();
		
		// 메인창의 컨트롤러를 가져와서
		Test06JavaFxMainController mainController = loader.getController();
		
		//fxmml에서 불러온 패널을 씬에 설정함.
		Scene scene = new Scene(root);
		stage.setTitle("Test06JavaFxMain");
		// 스테이지에 씬을 붙임
		stage.setScene(scene);
		// 스테이지를 보여줌
		stage.show();
		
		mainController.selectListData();
	
	}
	
	/**
	 * @method : setBoarderData
	 * @parmam : 
	 * @return : void
	 * @description : 바인딩시킨다.
	 */
	public void setBoarderData(BoardVO boardVo) {
		
		txtNo.setText(boardVo.getBoardId());
		txtTitle.setText(boardVo.getBoardTitle());
		txtName.setText(boardVo.getBoardWriter());
		
		System.out.println(" = setBoarderData =");
		
	}

}
