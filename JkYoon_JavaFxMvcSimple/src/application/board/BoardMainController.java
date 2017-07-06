package application.board;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * @class : BoardMainController.java
 * @title : 
 * @author : Yoon
 * @desciption : 간단한 게시판
 * 
 * 1. 테이블 뷰 설정
 * 2. 데이터를 조회해서 가져올수있도록한다.
 */
public class BoardMainController implements Initializable {
	
	// BoardServiceImpl 만든다.
	private BoardServiceImpl boardServiceImpl = new BoardServiceImpl();
	
	// ObservableList
	private ObservableList<BoardVO> data;
	
	
	// 업무구분 : 추가, 수정, 삭제
	private String strWork = "";
	//
	@FXML
	private Button btnAdd;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnDel;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnOk;
    
    // 글번호
    @FXML
    private TextField txtNo;
    
    // 내용
    @FXML
    private TextField txtAreaContent;

    // 제목
    @FXML
    private TextField txtTitle;

    // 작성자
    @FXML
    private TextField txtWriter;
    
    // 테이블뷰어
 	@FXML private TableView<BoardVO> tableView;
 	
 	// 확인라벨
 	@FXML private Label labelConform;
 	
    // 추가 이벤트
    @FXML
    void dataAdd(ActionEvent event) {
    	
    	strWork = "Insert";
    	labelConform.setText(strWork);
    }

    // 취소 이벤트
    @FXML
    void cancel(ActionEvent event) {
    	strWork = "";
    	labelConform.setText(strWork);
    	
    	txtNo.setText("");// 글번호
    	txtAreaContent.setText("");// 내용
    	txtTitle.setText("");// 제목
    	txtWriter.setText("");// 작성자
    	
    }

    // 삭제 이벤트
    @FXML
    void dataDel(ActionEvent event) {
    	strWork = "Delete";
    	labelConform.setText(strWork);
    }

    // 수정 이벤트
    @FXML
    void dataEdit(ActionEvent event) {
    	
    	strWork = "Update";
    	labelConform.setText(strWork);
    }

    //확인 이벤트
    @FXML
    void run(ActionEvent event) throws SQLException {
    	
    	BoardVO boardVO = new BoardVO();
    	
    	// 추가 할때
    	if("Insert".equals(strWork)){	// 추가 작업 상태 인지 검사
 
    		boardVO.setBoardTitle(txtTitle.getText());			// 제목
    		boardVO.setBoardWriter(txtWriter.getText());		//작성자
    		boardVO.setBoardContent(txtAreaContent.getText());	// 글내용
    		boardServiceImpl.insertBoard(boardVO);
    		
    		labelConform.setText("추가되었습니다.");
    	//수정	
    	}else if("Update".equals(strWork)){
    		boardVO.setBoardId(txtNo.getText()); 				// 글번호
    		boardVO.setBoardTitle(txtTitle.getText());			// 제목
    		boardVO.setBoardWriter(txtWriter.getText());		// 작성자
    		boardVO.setBoardContent(txtAreaContent.getText());	// 글내용
    		boardServiceImpl.updateBoard(boardVO);
    		
    		labelConform.setText("수정되었습니다.");
    	}else if("Delete".equals(strWork)){
    		
    		
    		boardVO.setBoardId(txtNo.getText()); 				// 글번호
    		boardServiceImpl.deleteBoard(boardVO);
    		
    		labelConform.setText("삭제되었습니다.");
    	}
    	
    	
    	
    	
    	selectBoardData();
    }
    
    /**
     * @method : tableClick
     * @parmam : 
     * @return : void
     * @description : 테이블뷰클릭 Scene빌더에서 On Mouse Clicked에서 함수를 넣어준다. 
     */
    @FXML
    void tableClick(MouseEvent event) {
    	// 테이블 뷰에서 선택한정보를 넣어준다.
    	BoardVO boardVO = tableView.getSelectionModel().getSelectedItem();
    	
    	txtNo.setText(boardVO.getBoardId());
    	txtTitle.setText(boardVO.getBoardTitle());
    	txtWriter.setText(boardVO.getBoardWriter());
    	txtAreaContent.setText(boardVO.getBoardContent());
    	
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		

		// 1. 테이블 뷰 설정
		setTableview();
		// 2. 데이터를 조회해서 가져올수있도록한다.
		selectBoardData();
	}

	/**
	 * @method : selectBoardData
	 * @parmam : 
	 * @return : void
	 * @description : 조회하도록 함.
	 */
	private void selectBoardData() {

		// 2. 데이터를 조회해서 가져올수있도록한다.
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			 list = boardServiceImpl.selectListBoard();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("list = " + list);
		
		
		data = FXCollections.observableArrayList(list);
		
		tableView.setItems(data);
		
	}

	/**
	 * @method : setTableview
	 * @parmam : 
	 * @return : void
	 * @description : 테이블뷰 설정
	 */
	private void setTableview() {
		TableColumn<BoardVO, String> tableColBoardId = new TableColumn<BoardVO, String>("글번호");
		TableColumn<BoardVO, String> tableColBoardTitle = new TableColumn<BoardVO, String>("제목");
		TableColumn<BoardVO, String> tableColBoardWriter = new TableColumn<BoardVO, String>("작성자");
		TableColumn<BoardVO, String> tableColBoardDate = new TableColumn<BoardVO, String>("작성일자");
		
		
 
		// 테이블컬럼과 데이터와 바인드 - 프로퍼티 밸류 팩토리를 통해서 BoardVO 와 String값인 boardId를 이 컬럼과 매칭시켜 바인드 한다.
		tableColBoardId.setCellValueFactory(new PropertyValueFactory<BoardVO, String>("boardId"));
		tableColBoardTitle.setCellValueFactory(new PropertyValueFactory<BoardVO, String>("boardTitle"));
		tableColBoardWriter.setCellValueFactory(new PropertyValueFactory<BoardVO, String>("boardWriter"));
		tableColBoardDate.setCellValueFactory(new PropertyValueFactory<BoardVO, String>("boardDate"));
		
		//너비 설정
		tableColBoardId.setMinWidth(50);
		tableColBoardTitle.setMinWidth(200);
		tableColBoardWriter.setMinWidth(50);
		tableColBoardDate.setMinWidth(50);
		
		
		// 테이블뷰에 컬럼을 추가한다.
		tableView.getColumns().addAll(tableColBoardId, tableColBoardTitle, tableColBoardWriter, tableColBoardDate );
		
	}
}

