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
 * @desciption : �Խ��� ���� ��Ʈ�ѷ�
 * 
 * �����ڹٷθ� ���� �Խ��� ���� ��Ʈ�ѷ�
 * ���α׷�����
 * 01. BorderPane ���̾ �׸���.
 * 02. Button , ChoiceBox�� TableView�� �׸���.
 * 03. Controller�� �����.
 * 03. Controller�� fxml�� ����� ���� ������´�.
 * 04. BoardVO.java �� ���� �����.
 * 05. List��ü�� �̿������� initList()�� �̿��Ͽ� �����͸� �ִ� �۾��� �Ѵ�.
 * 06. ��ü ��ȸ�� ���� �ϵ��� �Ѵ�.
 * 07. ��Ϲ�ư���� ȭ����ȯ�� �ϵ����Ѵٰ� �����Ѵ�.
 * 08. Test06JavaFxMainDetail.fxml ȭ���� ���������
 *    Test06JavaFxMainDetailController.java�� �����.
 * 09. Controller�� fxml�� ����� ���� ������´�.
 * 10. ��Ϲ�ư�� ���� �ڵ��� �Ѵ�. onCreatEvent()
 * 11. Test06JavaFxMainDetailController ���� �����ư�� onclickSave()�Լ��� �ڵ��Ѵ�.
 * 12. Test06JavaFxMainController.java���� ������ư�� ó���Ѵ�.
 * 13. ��ȸ�������� ��ȸ�� �Ǵ°��� �ڵ��Ѵ�. selectListData()�Լ��� �ڵ��Ѵ�.
 * 
 */
public class Test06JavaFxMainController implements Initializable {
			
	// ��ȸ���� ����
	@FXML private ChoiceBox<String> comboBoxSearchGubun;
	
	// ���̺���
	@FXML private TableView<BoardVO> tableView;
	
	// �˻���ư
	@FXML private Button btnSearch;
	
	// ������ư
	@FXML private Button btnDelete;
	
	// �ؽ�Ʈ �ʵ� ����
	@FXML private TextField txtNm;
	
	// ���̺�� �÷� ����
	@FXML private TableColumn<BoardVO, String> tableCol_boardId;
	@FXML private TableColumn<BoardVO, String> tableCol_boardTitle;
	@FXML private TableColumn<BoardVO, String> tableCol_boardWriter;
	
	
	// ���尴ü
	public static List<BoardVO> list = new ArrayList<BoardVO>();
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// ����Ʈ�� ������츸
		if(list.size() == 0){
			initList(); //����Ʈ�� �ʱ�ȭ
		}
		
		// ���̺�� ����
		setTableView(); 
		
		// �޺��ڽ� ����
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
		
		// List ����ȭ
		Collections.synchronizedList(list);
	}
	
	/**
	 * @method : setTableView
	 * @parmam : 
	 * @return : void
	 * @description : ���̺�� ���� 
	 */
	public void setTableView(){
		
		// ���̺� �÷�����
		tableCol_boardId.setCellValueFactory(new PropertyValueFactory<BoardVO, String>("boardId"));
		tableCol_boardTitle.setCellValueFactory(new PropertyValueFactory<BoardVO, String> ("boardTitle"));
		tableCol_boardWriter.setCellValueFactory(new PropertyValueFactory<BoardVO, String> ("boardWriter"));
		
		// ����Ŭ�� �̺�Ʈ
		tableView.setOnMousePressed(new EventHandler<MouseEvent>() {
		
			@Override
			public void handle(MouseEvent event) {
				if(event.isPrimaryButtonDown() && event.getClickCount() == 2){ // ����, ����Ŭ���� ���
					
					try {
						
						BoardVO boardVo = tableView.getSelectionModel().getSelectedItem();
						Stage stage = (Stage) tableView.getScene().getWindow();
						
						FXMLLoader loader = new FXMLLoader(getClass().getResource("Test06JavaFxMainDetail.fxml"));
						BorderPane pane = (BorderPane) loader.load();
					
						Scene scene = new Scene(pane);
						stage.setTitle("��/����");
						stage.setScene(scene);
						stage.show();
	
						// ������ ���� �ִ°Ͱ���. loader.load()�� �ؾ�  loader.getController()�� �����ü��ִ�.
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
	 * @description : �޺��ڽ� ����
	 */
	public void setComboBox() {
		comboBoxSearchGubun.getItems().removeAll("Item 1", "Item 2", "Item 3");
		comboBoxSearchGubun.getItems().addAll("����", "�ۼ���");
		comboBoxSearchGubun.setValue("����");
		
	}
	
	
	/**
	 * @method : onClickEvent
	 * @parmam : 
	 * @return : void
	 * @description : ��ȸ �̺�Ʈ
	 */
	public void onClickEvent(){
		selectListData();
	}
	
	/**
	 * @method : selectListData
	 * @parmam : 
	 * @return : void
	 * @description : ��ȸ �̺�Ʈ
	 */
	public void selectListData(){
		System.out.println("selectListData()");
		ObservableList<BoardVO> data;
		String searchText = txtNm.getText();
		if(!"".equals(searchText)){
			
			BoardVO boardVo = new BoardVO();
			
			// �˻������ �������
			List<BoardVO> searchResultList = new ArrayList<BoardVO>();
			//searchResultList.addAll(list);	//list��ü�� �����Ѵ�.

			
			for(int i = 0 ; i < list.size() ; i++){
				boardVo = new BoardVO();
				boardVo = list.get(i);
				
				System.out.println("comboBoxSearchGubun.getValue() = " + comboBoxSearchGubun.getValue());
				if(comboBoxSearchGubun.getValue().equals("����")){
					// �˻��������� ��ȸ�Ѵ�.
					if(boardVo.getBoardTitle().contains(searchText)){
						System.out.println("boardVo.getBoardTitle() = "+boardVo.getBoardTitle());
						searchResultList.add(boardVo);
						
					}
				}else if(comboBoxSearchGubun.getValue().equals("�ۼ���")){
					if(boardVo.getBoardWriter().contains(searchText)){
						System.out.println("boardVo.getBoardWriter() = "+boardVo.getBoardWriter());
						searchResultList.add(boardVo);
					}
				}
			}
		 
			
			data = FXCollections.observableArrayList(searchResultList);
			
		}else{
			System.out.println("else");
			//�ҷ��� �����͸� FXCollections�� ���� ����������Ʈ�� ��ȯ
			data = FXCollections.observableArrayList(list);
			
			for(int i = 0 ; i < list.size(); i++){
				System.out.println(list.get(i).toString());
			}
			
		}
		 
		//���̺�信 �������� ����Ʈ�� ���ε�
		tableView.setItems(data);
		
	}
	
	/**
	 * @method : onDeleteEvent
	 * @parmam : 
	 * @return : void
	 * @description : ���� �̺�Ʈ
	 */
	public void onDeleteEvent(ActionEvent e){
		BoardVO boardVO = tableView.getSelectionModel().getSelectedItem();
		
		//����Ʈ ��ü ����
		list.remove(boardVO);
		// ���̺� �信�� �����ϱ�
		tableView.getItems().remove(boardVO);
		 
	}
	
	/**
	 * @method : onCreatEvent
	 * @parmam : 
	 * @return : void
	 * @throws IOException 
	 * @description : ��� �̺�Ʈ
	 */
	public void onCreatEvent(ActionEvent e) throws IOException{
		
		for(int i = 0 ; i < list.size() ; i++){
			System.out.println(" getBoardContent = "+list.get(i).getBoardContent());
		}
		
		//String str = ((Button)e.getTarget()).getText(); �̺�Ʈ�� �ϳ��� �Ҷ� �̷������ �ִ�.
		Stage stage = (Stage) tableView.getScene().getWindow();
		
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Test06JavaFxMainDetail.fxml"));
		BorderPane pane = (BorderPane) loader.load();	
		
		Scene scene = new Scene(pane);
		stage.setTitle("Test06JavaFxMainDetail");
		stage.setScene(scene);
		stage.show();
		
	}
	 

}
