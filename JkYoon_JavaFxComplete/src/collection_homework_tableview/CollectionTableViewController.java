package collection_homework_tableview;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Stack;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @class : CollectionController.java
 * @title : 
 * @author : Yoon
 * @desciption : HashSet, Stack, HashMap는 숙제로 내도록한다.
 */
public class CollectionTableViewController implements Initializable {
	
	@FXML
    private Button addBtn;		// 추가 버튼

    @FXML
    private ComboBox<String> collectionCombo;	// 콤보박스

    @FXML
    private Label comformLabel;	// 확인라벨

    @FXML
    private Button printBtn;	// 출력버튼

    @FXML
    private TableView<CollectionTableVo> tableView;	// 출력장소

    @FXML
    private TextField txtAge;	// 나이

    @FXML
    private TextField txtName;	// 이름
    
    // 11. ArrayList에 추가한다.
    ArrayList<CollectionTableVo> arrayList = new ArrayList<CollectionTableVo>();
    
    HashSet<CollectionTableVo> hashSet = new HashSet<CollectionTableVo>();
    
    Stack<CollectionTableVo> stack = new Stack<CollectionTableVo>();
    
    HashMap<Integer, CollectionTableVo> hashMap = new HashMap<Integer, CollectionTableVo>();
    
    
  
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// #1 tableView를세팅한다.
		initTableView();
		
		
		// 4. initCombo함수를 만들어서 구성하도록한다.
		initCombo();
		
		// 5. 이벤트 함수를 만든다.
		initEvent();
		
		
		
	}


	/**
	 * @method : initTableView
	 * @parmam : 
	 * @return : void
	 * @description : 테이블뷰어 셋팅
	 */
	private void initTableView() {
		
		
		//#2 테이블뷰에 추가할 테이블컬럼
		TableColumn<CollectionTableVo, String> nameCol = new TableColumn<CollectionTableVo, String>();
		TableColumn<CollectionTableVo, String> ageCol = new TableColumn<CollectionTableVo, String>();
		
		//#3 테이블컬럼과 데이터와 바인드 - 프로퍼티벨류 팩토리를 통해서 CollectionTableVo의 String값인 name과 이컬럼을 매칭시켜 바인딩시킨다.
		nameCol.setCellValueFactory(new PropertyValueFactory<CollectionTableVo, String>("name"));
		ageCol.setCellValueFactory(new PropertyValueFactory<CollectionTableVo, String>("age"));
	
		//#4 설정한 테이블 컬럼들을 테이블 뷰에 추가한다.
		tableView.getColumns().addAll(nameCol, ageCol);
		
		nameCol.setMinWidth(100);
		ageCol.setMinWidth(100);
		
		
		
		
	}


	/**
	 * @method : initEvent
	 * @parmam : 
	 * @return : void
	 * @description : 이벤트함수
	 */
	private void initEvent() {
		
		// 6. 추가버튼이벤트 구성한다.
		addBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				// 8. System.out.println 를 출력해본다. 
				System.out.println("addBtn.setOnAction()");
				
				// 12. CollectionTableVo에 담아서 추가하도록한다.
				CollectionTableVo collectionVo = new CollectionTableVo();
				collectionVo.setName(txtName.getText());
				collectionVo.setAge(txtAge.getText());
				
				// 10. 콤보박스가 선택된것이 ArrayList이면 ArrayList에 추가하도록 한다.
				if("ArrayList".equals(collectionCombo.getSelectionModel().getSelectedItem())){
					
					arrayList.add(collectionVo);
					
				}else if("HashSet".equals(collectionCombo.getSelectionModel().getSelectedItem())){
					hashSet.add(collectionVo);
					
					
				}else if("Stack".equals(collectionCombo.getSelectionModel().getSelectedItem())){
					stack.add(collectionVo);
					
				}else if("HashMap".equals(collectionCombo.getSelectionModel().getSelectedItem())){
					hashMap.put(hashMap.size(), collectionVo);
					
				}
				
				// 13. comformLabel 라벨에 추가되었음을 보여준다.
				comformLabel.setText(collectionCombo.getSelectionModel().getSelectedItem() + "에 추가되었습니다.");
				
				// 14. 이름과 나이의 TextField를 지워 주는 작업을 한다.
				txtName.setText("");
				txtAge.setText("");
				
				
			}
		});
		
		// 7. 출력버튼 이벤트 구성한다. [테이블 뷰로 함으로써 필요없는기능] 
		printBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// 9. System.out.println 를 출력해본다. 
				System.out.println("printBtn.setOnAction()");
				
				// 16. String 값을 담을 tmpStr변수를 만든다.
				String tmpStr = "";
				System.out.println("collectionCombo.getSelectionModel().getSelectedItem() = " + collectionCombo.getSelectionModel().getSelectedItem());
				
				// 15. 콤보박스가 ArrayList이면 이라는 조건을 넣는다.
				if("ArrayList".equals(collectionCombo.getSelectionModel().getSelectedItem())){
					

					// #6 FXCollectios를 통해서 옵저러블 리스트에 추가한다.
				    ObservableList<CollectionTableVo> observableList = FXCollections.observableArrayList(arrayList);
				    
				    tableView.setItems(observableList);
					
					
					
				}else if("HashSet".equals(collectionCombo.getSelectionModel().getSelectedItem())){
					Iterator<CollectionTableVo> it = hashSet.iterator();
					
					CollectionTableVo tmpVo = new CollectionTableVo();
					
					ArrayList<CollectionTableVo> castList = new ArrayList<CollectionTableVo>();
					for (int i = 0 ; i < hashSet.size() ; i++) {
						tmpVo = new CollectionTableVo();
						tmpVo = it.next(); 
						
						castList.add(tmpVo);
					}

					 ObservableList<CollectionTableVo> observableList = FXCollections.observableArrayList(castList);
				 
					 tableView.setItems(observableList);

				}else if("Stack".equals(collectionCombo.getSelectionModel().getSelectedItem())){
					ObservableList<CollectionTableVo> observableList =  FXCollections.observableArrayList(stack);
					tableView.setItems(observableList);	
					
				}else if("HashMap".equals(collectionCombo.getSelectionModel().getSelectedItem())){
					
					CollectionTableVo tmpVo = new CollectionTableVo();
					
					ArrayList<CollectionTableVo> castList = new ArrayList<CollectionTableVo>();
					for (int i = 0 ; i < hashMap.size() ; i++) {
						tmpVo = new CollectionTableVo();
						tmpVo = hashMap.get(i); 
						
						castList.add(tmpVo);
					}
					System.out.println("castList.size() = "+castList.size());
					
					
					 ObservableList<CollectionTableVo> observableList = FXCollections.observableArrayList(castList);
					 tableView.setItems(observableList);
				}
				
				
				// 18. TextArea에 setText 해준다.
				//textArea.setText(tmpStr);
			}
		});
		
		
		
	}


	/**
	 * @method : initCombo
	 * @parmam : 
	 * @return : void
	 * @description : 콤보를 초기화한다.
	 */
	private void initCombo() {
		// 1. 기존에 있는 콤보에 있는 정보를 지운다.
		collectionCombo.getItems().removeAll("Item 1", "Item 2", "Item 3");
		
		// 2. ArrayList를 추가한다.
		collectionCombo.getItems().addAll("ArrayList", "HashSet", "Stack", "HashMap");
		
		// 3. 콤보박스가 디폴트로 선택되게 한다.
		collectionCombo.setValue("ArrayList");
			
		
	}

}
