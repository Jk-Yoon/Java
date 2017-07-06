package application.board.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import application.board.serviceimpl.BoardServiceImpl;
import application.board.vo.BoardVO;

/**
 * @class : MainController.java
 * @title : 
 * @author : Yoon
 * @desciption : ibatis로 만든 게시판 메인 컨트롤러
 * 프로그램순서
 * 01. BorderPane 레이어를 그린다.
 * 02. Button , ChoiceBox와 TableView를 그린다.
 * 03. Controller를 만든다.
 * 03. Controller에 fxml을 명시한 값을 적어놓는다.
 * 04. BoardVO.java 를 먼저 만든다.
 * 05. List객체를 이용함으로 initList()를 이용하여 데이터를 넣는 작업을 한다.
 * 06. 전체 조회가 먼저 하도록 한다.
 * 07. 등록버튼으로 화면전환을 하도록한다고 설명한다.
 * 08. Detail.fxml 화면을 먼저만들고
 *     DetailController.java를 만든다.
 * 09. Controller에 fxml을 명시한 값을 적어놓는다.
 * 10. 등록버튼에 대한 코딩을 한다. onCreatEvent()
 * 11. DetailController.java 에서 저장버튼을 onclickSave()함수를 코딩한다.
 * 12. DetailController.java 에서 삭제버튼을 처리한다.
 * 13. 조회조건으로 조회가 되는것을 코딩한다. selectListData()함수를 코딩한다.
 */
public class MainController implements Initializable {
	 
	
	
	//데이터를 불러오기 위한 DAO
	private BoardServiceImpl boardService = new BoardServiceImpl();
		
	
	// 조회조건 구분
	@FXML private ChoiceBox<String> comboBoxSearchGubun;
	
	// 테이블뷰어
	@FXML private TableView<BoardVO> tableView;
	
	// 검색버튼
	@FXML private Button btnSearch;
	
	// 삭제버튼
	@FXML private Button btnDelete;
	
	// 텍스트 필드 설정
	@FXML private TextField txtNm;
	
	 
	
	//디테일 컨트롤러로 넘겨줄 자신 컨트롤러
	private MainController mainController = this;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// 테이블뷰 설정
		setTableView(); 
		
		// 콤보박스 설정
		setComboBox();
		 
	}
	
	// ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ init Start■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■  
	
 
	
	/**
	* @method : setTableView
	* @parmam : 
	* @return : void
	* @description : 테이블뷰 설정 
	*/
	public void setTableView(){
		//tableView.setEditable(true);
		
		// 테이블뷰에 추가할 테이블컬럼
		TableColumn<BoardVO, String> tableColBoardId = new TableColumn<BoardVO, String>("글번호");
		TableColumn<BoardVO, String> tableColBoardTitle = new TableColumn<BoardVO, String>("제목");
		TableColumn<BoardVO, String> tableColBoardWriter = new TableColumn<BoardVO, String>("작성자");
		TableColumn<BoardVO, String> tableColBoardDate = new TableColumn<BoardVO, String>("작성일자");
		
		
		// 테이블컬럼과 데이터와 바인드 - 프로퍼티 밸류 팩토리를 통해서 BoardVO와 String값인 boardId를 이 컬럼과 매칭시켜 바인드 한다.
		tableColBoardId.setCellValueFactory(new PropertyValueFactory<BoardVO, String>("boardId"));
		tableColBoardTitle.setCellValueFactory(new PropertyValueFactory<BoardVO, String> ("boardTitle"));
		tableColBoardWriter.setCellValueFactory(new PropertyValueFactory<BoardVO, String> ("boardWriter"));
		tableColBoardDate.setCellValueFactory(new PropertyValueFactory<BoardVO, String> ("boardDate"));
		
	 
		
/*	 
		//가운데 정렬을 하기위해서
		Callback<TableColumn<BoardVO,String>, TableCell<BoardVO,String>> callback = new Callback<TableColumn<BoardVO,String>, TableCell<BoardVO,String>>() {
			
			//콜백에서 실제로 동작하게 되는 call 메서드
			@Override
			public TableCell<BoardVO, String> call(TableColumn<BoardVO, String> param) {
				TableCell<BoardVO, String> tc = new TableCell<BoardVO, String>(){
					@Override
                    public void updateItem(String item, boolean empty) {
                        if (item != null){
                        	System.out.println("item = " + item);
                            setText(item);
                        }
                    }
				};
			    tc.setAlignment(Pos.CENTER);
			    return tc;
			}
		};
		//테이블셀이 추가될 때 해당 콜백을 실행하도록 설정
		tableColBoardId.setCellFactory(callback);
		tableColBoardTitle.setCellFactory(callback);
*/		
		 
		
		// 너비설정
		tableColBoardId.setMinWidth(100);
		tableColBoardTitle.setMinWidth(300);
		tableColBoardWriter.setMinWidth(100);
		tableColBoardDate.setMinWidth(100);
		
		tableView.getColumns().addAll(tableColBoardId, tableColBoardTitle, tableColBoardWriter, tableColBoardDate );
		 
		
		// 테이블뷰에 마우스 클릭 이벤트를 추가한다 - 더블클릭하면 게시판 상세내용 팝업이 뜨도록 할 예정
		tableView.setOnMousePressed(new EventHandler<MouseEvent>() {
		
			@Override
			public void handle(MouseEvent event) {
				// 이벤트가 마우스 주버튼 클릭이고, 마우스 클릭 수가 두번이면 더블클릭이라고 판단하도록 설정
				if(event.isPrimaryButtonDown() && event.getClickCount() == 2){ // 왼쪽, 더블클릭일 경우
					
					try {
						// 테이블뷰에서 선택된 (더블클릭 한) 아이템을 가져온다.
						BoardVO boardVo = tableView.getSelectionModel().getSelectedItem();
						
						// 팝업창을 불러오기 위한 새로운 스테이지(윈도우)
						Stage stage = new Stage();
						
						// Detail.fxml로 부터 컴포넌트를 불러와서 Scene에 배치한다.
						FXMLLoader loader = new FXMLLoader(getClass().getResource("Detail.fxml"));
						BorderPane pane = (BorderPane) loader.load();
						
						
						//디테일 팝업창의 컨트롤러를 가져옴
						DetailController detailController = (DetailController)loader.getController();
						//디테일 컨트롤러에 게시판 아이디를 매개변수로 하여 게시판 상세정보를 셋팅
						detailController.setBoardData(boardVo);
						//디테일 팝업창에서 정보를 수정한 뒤 부모창에서도 바뀐 데이터가 갱신될 수 있도록 하기위해
						//메인 컨트롤러를 알려줌
						detailController.setParentController(mainController);
						
						//fxml에서 불러온 패널을 씬에 설정함
						Scene scene = new Scene(pane);
						
						//스테이지에 씬을 붙임
						stage.setScene(scene);
						//stage.initModality(Modality.WINDOW_MODAL);
						
						//스테이지를 보여줌 - 실제로 윈도우 창이 나타나는 부분
						stage.show();
					 
					 
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 
				}
				
			}
		});
		
		
	}
	
	
	/**
	* @method : setComboBox
	* @parmam : 
	* @return : void
	* @description : 콤보박스 설정
	*/
	public void setComboBox() {
		comboBoxSearchGubun.getItems().addAll("제목", "작성자");
		comboBoxSearchGubun.setValue("제목");
	
	}
	// ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ init End ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	
	

	// ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ Event Start ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■	
	/**
	* @method : onClickEvent
	* @parmam : 
	* @return : void
	 * @throws SQLException 
	* @description : 조회 이벤트
	*/
	public void onClickSearch() throws SQLException{
		BoardVO boardVO = new BoardVO(); 
		
		if(comboBoxSearchGubun.getValue().toString().equals("제목")){
			boardVO.setBoardTitle(txtNm.getText());
		}else if(comboBoxSearchGubun.getValue().toString().equals("작성자")){
			boardVO.setBoardWriter(txtNm.getText());
		}
		
		selectData(boardVO);
	}
	
	
	/**
	* @method : selectListData
	* @parmam : 
	* @return : void
	 * @throws SQLException 
	* @description : 조회 이벤트
	*/
	public void selectListData() throws SQLException{
		System.out.println("selectListData()");
		String searchText = txtNm.getText();
		BoardVO boardVo = new BoardVO();
		
		if(comboBoxSearchGubun.getValue().equals("제목")){
			// 검색조건으로 조회한다.
			System.out.println("boardVo.getBoardTitle() = "+boardVo.getBoardTitle());
			 
			boardVo.setBoardTitle(searchText);
			
			selectData(boardVo);
		}else if(comboBoxSearchGubun.getValue().equals("작성자")){
			System.out.println("boardVo.getBoardWriter() = "+boardVo.getBoardWriter());
			
			boardVo.setBoardWriter(searchText);
			
			selectData(boardVo);
		}
	
	}
	
	/**
	* @method : onDeleteEvent
	* @parmam : 
	* @return : void
	 * @throws SQLException 
	* @description : 삭제 이벤트
	*/
	public void onClickDelete(ActionEvent e) throws SQLException{
		
		BoardVO boardVO = tableView.getSelectionModel().getSelectedItem();
		
		if(boardVO == null){
			//숙제냈으면 좋은것
			Stage myDialog = new Stage();
			VBox vbox = new VBox();
			Text txt = new Text("선택된것이 없습니다.");
			 
			vbox.setPadding(new Insets(30));
			vbox.getChildren().add(txt);
			vbox.setAlignment(Pos.CENTER);
			 
			myDialog.setScene(new Scene(vbox));
			myDialog.show();
/**		
 * 위에꺼를 아래와같이 하였음.	
//            Stage myDialog = new Stage();
//            // java1.7에는 Aerlt이 없기때문에 Scene으로 대체함. //			 Alert alert = new Alert(AlertType.INFORMATION);
//            Scene myDialogScene = new Scene(VBoxBuilder.create().children(new Text("선택된게 없습니다."))
//                    .alignment(Pos.CENTER)
//                    .padding(new javafx.geometry.Insets(30))
//                    .build());
//            myDialog.setScene(myDialogScene);
//            myDialog.show();
**/            
            return;
		}
		
		// 테이블 뷰에서 삭제하기
		tableView.getItems().remove(boardVO);
		int result = boardService.deleteBoard(boardVO);
		System.out.println("result = " + result);
		
		
	 
	}
	
	/**
	* @method : onCreatEvent
	* @parmam : 
	* @return : void
	* @throws IOException 
	* @description : 등록 이벤트
	*/
	public void onCreatEvent(ActionEvent e) throws IOException{
 
		//Detail.fxml로 부터 컴포넌트를 불러와서 Scene에 배치한다.
		Stage stage = new Stage();
		
		BorderPane pane;
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Detail.fxml"));
		pane = (BorderPane) loader.load();
		
		DetailController detailController = loader.getController();
		detailController.setParentController(mainController);
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		
		stage.show();
	
	}
	// ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ Event End ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	
	
	// ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ Method Start ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	/**
	 * @method : selectData
	 * @parmam : 
	 * @return : void
	 * @description : 데이터 조회
	 */
	private void selectData(BoardVO boardVO) throws SQLException {  
		// dao를 통해 데이터를 불러옴
		List<BoardVO> list = boardService.selectListBoard(boardVO);
		// 테이블뷰에 바인드 될 옵저버블리스트 불러온 데이터를 FXCollections을 통해 옵저버블리스트로 변환
		ObservableList<BoardVO> boardList = FXCollections.observableArrayList(list);
		
		// 테이블뷰에 옵저버블 리스트를 바인드
		tableView.setItems(boardList);
	}
	// ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ Method End ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	
	

}
