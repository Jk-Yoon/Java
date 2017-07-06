package collection_homework;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Stack;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import collection_homework.vo.CollectionVo1;

/**
 * @class : CollectionController.java
 * @title : 
 * @author : Yoon
 * @desciption : HashSet, Stack, HashMap는 숙제로 내도록한다.
 */
public class CollectionController implements Initializable {
	
	@FXML
    private Button addBtn;		// 추가 버튼

    @FXML
    private ComboBox<String> collectionCombo;	// 콤보박스

    @FXML
    private Label comformLabel;	// 확인라벨

    @FXML
    private Button printBtn;	// 출력버튼

    @FXML
    private TextArea textArea;	// 출력장소

    @FXML
    private TextField txtAge;	// 나이

    @FXML
    private TextField txtName;	// 이름
    
    // 11. ArrayList에 추가한다.
    ArrayList<CollectionVo1> arrayList = new ArrayList<CollectionVo1>();
    
    HashSet<CollectionVo1> hashSet = new HashSet<CollectionVo1>();
    
    Stack<CollectionVo1> stack = new Stack<CollectionVo1>();
    
    HashMap<Integer, CollectionVo1> hashMap = new HashMap<Integer, CollectionVo1>();
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 4. initCombo함수를 만들어서 구성하도록한다.
		initCombo();
		
		// 5. 이벤트 함수를 만든다.
		initEvent();
		
		
		
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
				
				// 12. CollectionVo1에 담아서 추가하도록한다.
				CollectionVo1 collectionVo = new CollectionVo1();
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
		
		// 7. 출력버튼 이벤트 구성한다.
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
					
					// 17. for문을 이용해서 tmpStr에 넣는다.
					for(int i = 0 ; i < arrayList.size() ; i++){
						tmpStr += "이름 : " + arrayList.get(i).getName() + "\n";
						tmpStr += "나이 : " + arrayList.get(i).getAge() + "\n";
					}
					
					
					
				}else if("HashSet".equals(collectionCombo.getSelectionModel().getSelectedItem())){
					Iterator<CollectionVo1> it = hashSet.iterator();
					
					CollectionVo1 collectionVo1 = new CollectionVo1();
					System.out.println("hashSet.size() = " + hashSet.size());
					for(int i = 0 ; i < hashSet.size() ; i++){
						 collectionVo1 = new CollectionVo1();
						 collectionVo1 = it.next();
						 tmpStr += "이름 : " + collectionVo1.getName() + "\n";
						 tmpStr += "나이 : " + collectionVo1.getAge() + "\n"; 
					}

				}else if("Stack".equals(collectionCombo.getSelectionModel().getSelectedItem())){
					for(int i = 0 ; i < stack.size() ; i++){
						tmpStr += "이름 : " + stack.get(i).getName() + "\n";
						tmpStr += "나이 : " + stack.get(i).getAge() + "\n";
					}
				}else if("HashMap".equals(collectionCombo.getSelectionModel().getSelectedItem())){
					
					CollectionVo1 collectionVo1 = new CollectionVo1();
					for(int i = 0 ; i < hashMap.size() ; i++){
						collectionVo1 = new CollectionVo1();
						collectionVo1 = hashMap.get(i);
						
						tmpStr += "이름 : " + collectionVo1.getName() + "\n";
						tmpStr += "나이 : " + collectionVo1.getAge() + "\n";
						
					}
				}
				
				
				// 18. TextArea에 setText 해준다.
				textArea.setText(tmpStr);
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
