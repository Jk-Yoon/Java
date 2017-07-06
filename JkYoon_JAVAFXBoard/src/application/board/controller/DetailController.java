package application.board.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import application.board.serviceimpl.BoardServiceImpl;
import application.board.vo.BoardVO;

/**
 * @class : DetailController.java
 * @title : 
 * @author : Yoon
 * @desciption : 
 */
public class DetailController implements Initializable {
	
	//데이터를 불러오기 위한 DAO
	private BoardServiceImpl boardService = new BoardServiceImpl();
		
	// 글번호
	@FXML private TextField txtNo;
	
	// 제목
	@FXML private TextField txtTitle;
	
	// 작성자
	@FXML private TextField txtWriter;
	
	// 내용
	@FXML private TextArea txtAreaContent;
	
	// 저장
	@FXML private Button btnSave;
	
	// 취소
	@FXML private Button btnCancel;
	
	
	// 부모창 컨트롤러
	private MainController parentController;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @method : onclickList
	 * @parmam : 
	 * @return : void
	 * @throws IOException 
	 * @throws SQLException 
	 * @description : 
	 */
	public void onclickCancel() throws IOException, SQLException {
		//부모창을 조회하게 한다.
		parentController.selectListData();
		// 자신의 창을 닫는다.
		Stage stage = (Stage) btnCancel.getScene().getWindow();
		stage.close();
	}
	
	/**
	 * @method : onclickSave
	 * @parmam : 
	 * @return : void
	 * @throws IOException 
	 * @throws SQLException 
	 * @description : 저장 이벤트
	 */
	public void onclickSave() throws IOException, SQLException {
		System.out.println("onclickSave()");
 
		BoardVO boardVO = new BoardVO();
		boardVO.setBoardId(txtNo.getText());
		boardVO.setBoardTitle(txtTitle.getText());
		boardVO.setBoardWriter(txtWriter.getText());
		boardVO.setBoardContent(txtAreaContent.getText());
		
		int result = 0;
		
		// 글번호가 있을시 update
		if(!"".equals(txtNo.getText())){
			result = boardService.updateBoard(boardVO);
		}else{		// 글번호가 없을시 inert
			boardService.insertBoard(boardVO);
			  
		}
	
		System.out.println(" result = " + result);
		
		//부모창을 전체 조회하기
		parentController.selectListData();
		
		// 자신의 창을 닫는다.
		Stage stage = (Stage) txtNo.getScene().getWindow();
		stage.close();
	}
	
	/**
	 * @method : setBoarderData
	 * @parmam : 
	 * @return : void
	 * @description : 바인딩시킨다.
	 */
	public void setBoardData(BoardVO boardVo) {
		
		txtNo.setText(boardVo.getBoardId());
		txtTitle.setText(boardVo.getBoardTitle());
		txtWriter.setText(boardVo.getBoardWriter());
		txtAreaContent.setText(boardVo.getBoardContent());
		System.out.println(" = setBoarderData =");
		
	}
	
	public void setParentController(MainController parentController){
		this.parentController = parentController;
	}

}
