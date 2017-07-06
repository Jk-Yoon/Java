package test06board;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import test06board.vo.BoardVO;


/**
 * @class : Test06JavaFxMainController.java
 * @title : 
 * @author : Yoon
 * @desciption : 게시판 메인 컨트롤러
 * 
 * 오직자바로만 만든 게시판 메인 컨트롤러
 * 프로그램순서
 * 01. BorderPane 레이어를 그린다.
 * 02. Button , ChoiceBox와 TableView를 그린다.
 * 03. Controller를 만든다.
 * 03. Controller에 fxml을 명시한 값을 적어놓는다.
 * 04. BoardVO.java 를 먼저 만든다.
 * 05. List객체를 이용함으로 initList()를 이용하여 데이터를 넣는 작업을 한다.
 * 06. 전체 조회가 먼저 하도록 한다.
 * 07. 등록버튼으로 화면전환을 하도록한다고 설명한다.
 * 08. Test06JavaFxMainDetail.fxml 화면을 먼저만들고
 *    Test06JavaFxMainDetailController.java를 만든다.
 * 09. Controller에 fxml을 명시한 값을 적어놓는다.
 * 10. 등록버튼에 대한 코딩을 한다. onCreatEvent()
 * 11. Test06JavaFxMainDetailController 에서 저장버튼을 onclickSave()함수를 코딩한다.
 * 12. Test06JavaFxMainController.java에서 삭제버튼을 처리한다.
 * 13. 조회조건으로 조회가 되는것을 코딩한다. selectListData()함수를 코딩한다.
 * 
 */
public class Test06JavaFxMainController implements Initializable {
			
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
	
	// 테이블뷰 컬럼 설정
	@FXML private TableColumn<BoardVO, String> tableCol_boardId;
	@FXML private TableColumn<BoardVO, String> tableCol_boardTitle;
	@FXML private TableColumn<BoardVO, String> tableCol_boardWriter;
	
	
	// 저장객체
	public static List<BoardVO> list = new ArrayList<BoardVO>();
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// 리스트가 없을경우만
		if(list.size() == 0){
			initList(); //리스트값 초기화
		}
		
		// 테이블뷰 설정
		setTableView(); 
		
		// 콤보박스 설정
		setComboBox();
		 
	}
	
	/**
	 * @method : initList
	 * @parmam : 
	 * @return : void
	 * @description : initList()
	 */
	public void initList(){
		BoardVO boardVO = new BoardVO();
		boardVO.setBoardId("1");
		boardVO.setBoardTitle("setBoardTitle1");
		boardVO.setBoardWriter("setBoardWriter1");
		boardVO.setBoardContent("setBoardContent1");
		
		list.add(boardVO);
		
		boardVO = new BoardVO();
		boardVO.setBoardId("2");
		boardVO.setBoardTitle("setBoardTitle2");
		boardVO.setBoardWriter("setBoardWriter2");
		boardVO.setBoardContent("setBoardContent2");
		list.add(boardVO);
		
		boardVO = new BoardVO();
		boardVO.setBoardId("3");
		boardVO.setBoardTitle("setBoardTitle3");
		boardVO.setBoardWriter("setBoardWriter3");
		boardVO.setBoardContent("setBoardContent3");
		list.add(boardVO);
		
		// List 동기화
		Collections.synchronizedList(list);
	}
	
	/**
	 * @method : setTableView
	 * @parmam : 
	 * @return : void
	 * @description : 테이블뷰 설정 
	 */
	public void setTableView(){
		
		// 테이블 컬럼설정
		tableCol_boardId.setCellValueFactory(new PropertyValueFactory<BoardVO, String>("boardId"));
		tableCol_boardTitle.setCellValueFactory(new PropertyValueFactory<BoardVO, String> ("boardTitle"));
		tableCol_boardWriter.setCellValueFactory(new PropertyValueFactory<BoardVO, String> ("boardWriter"));
		
		// 더블클릭 이벤트
		tableView.setOnMousePressed(new EventHandler<MouseEvent>() {
		
			@Override
			public void handle(MouseEvent event) {
				if(event.isPrimaryButtonDown() && event.getClickCount() == 2){ // 왼쪽, 더블클릭일 경우
					
					try {
						
						BoardVO boardVo = tableView.getSelectionModel().getSelectedItem();
						Stage stage = (Stage) tableView.getScene().getWindow();
						
						FXMLLoader loader = new FXMLLoader(getClass().getResource("Test06JavaFxMainDetail.fxml"));
						BorderPane pane = (BorderPane) loader.load();
					
						Scene scene = new Scene(pane);
						stage.setTitle("상세/수정");
						stage.setScene(scene);
						stage.show();
	
						// 순서가 뭐가 있는것같음. loader.load()를 해야  loader.getController()를 가져올수있다.
						Test06JavaFxMainDetailController detailController = loader.getController();
						detailController.setBoarderData(boardVo);
					 
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
		comboBoxSearchGubun.getItems().removeAll("Item 1", "Item 2", "Item 3");
		comboBoxSearchGubun.getItems().addAll("제목", "작성자");
		comboBoxSearchGubun.setValue("제목");
		
	}
	
	
	/**
	 * @method : onClickEvent
	 * @parmam : 
	 * @return : void
	 * @description : 조회 이벤트
	 */
	public void onClickEvent(){
		selectListData();
	}
	
	/**
	 * @method : selectListData
	 * @parmam : 
	 * @return : void
	 * @description : 조회 이벤트
	 */
	public void selectListData(){
		System.out.println("selectListData()");
		ObservableList<BoardVO> data;
		String searchText = txtNm.getText();
		if(!"".equals(searchText)){
			
			BoardVO boardVo = new BoardVO();
			
			// 검색결과가 있을경우
			List<BoardVO> searchResultList = new ArrayList<BoardVO>();
			//searchResultList.addAll(list);	//list객체를 복사한다.

			
			for(int i = 0 ; i < list.size() ; i++){
				boardVo = new BoardVO();
				boardVo = list.get(i);
				
				System.out.println("comboBoxSearchGubun.getValue() = " + comboBoxSearchGubun.getValue());
				if(comboBoxSearchGubun.getValue().equals("제목")){
					// 검색조건으로 조회한다.
					if(boardVo.getBoardTitle().contains(searchText)){
						System.out.println("boardVo.getBoardTitle() = "+boardVo.getBoardTitle());
						searchResultList.add(boardVo);
						
					}
				}else if(comboBoxSearchGubun.getValue().equals("작성자")){
					if(boardVo.getBoardWriter().contains(searchText)){
						System.out.println("boardVo.getBoardWriter() = "+boardVo.getBoardWriter());
						searchResultList.add(boardVo);
					}
				}
			}
		 
			
			data = FXCollections.observableArrayList(searchResultList);
			
		}else{
			System.out.println("else");
			//불러온 데이터를 FXCollections를 통해 옵저버블리스트로 변환
			data = FXCollections.observableArrayList(list);
			
			for(int i = 0 ; i < list.size(); i++){
				System.out.println(list.get(i).toString());
			}
			
		}
		 
		//테이블뷰에 옵저버블 리스트를 바인드
		tableView.setItems(data);
		
	}
	
	/**
	 * @method : onDeleteEvent
	 * @parmam : 
	 * @return : void
	 * @description : 삭제 이벤트
	 */
	public void onDeleteEvent(ActionEvent e){
		BoardVO boardVO = tableView.getSelectionModel().getSelectedItem();
		
		//리스트 객체 삭제
		list.remove(boardVO);
		// 테이블 뷰에서 삭제하기
		tableView.getItems().remove(boardVO);
		 
	}
	
	/**
	 * @method : onCreatEvent
	 * @parmam : 
	 * @return : void
	 * @throws IOException 
	 * @description : 등록 이벤트
	 */
	public void onCreatEvent(ActionEvent e) throws IOException{
		
		for(int i = 0 ; i < list.size() ; i++){
			System.out.println(" getBoardContent = "+list.get(i).getBoardContent());
		}
		
		//String str = ((Button)e.getTarget()).getText(); 이벤트를 하나로 할때 이런방법도 있다.
		Stage stage = (Stage) tableView.getScene().getWindow();
		
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Test06JavaFxMainDetail.fxml"));
		BorderPane pane = (BorderPane) loader.load();	
		
		Scene scene = new Scene(pane);
		stage.setTitle("Test06JavaFxMainDetail");
		stage.setScene(scene);
		stage.show();
		
	}
	 

}
