package test011;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @class : Test05JavaFXBaseComponentController.java
 * @title : 
 * @author : Yoon
 * @desciption :  TextField, ToggleGroup, ComboBox, CheckBox, Label이용하기
 * 
 * 프로그램 순서
1. 성명 + input을 그린다. fx:id = "txtName"
2. 성별 + 라디오버튼 남자, 여자를 그린다.			fx:id="radioMan" fx:id="radiowoMan"	
	ToggleGroup 은 JavaFX Scence Builder 에서 Properties - > specific에 Toggle Group으로 설정
3. 지역 + 콤보박스를 그린다.			fx:id="areaCombo"
4. 취미 + 체크박스를 그린다.			fx:id="chkA" fx:id="chkB"
																					5. pane위에 treeView를 그린다.			fx:id="treeView"
6. 버튼을 그린다.				onAction="#onClickEvent"
7. txtArea를 그린다.				fx:id="txtArea"
8. 버튼 이벤트 onClickEvent()함수에 TextArea에 넣는 구문을 String str에 담는다.
 - txtName.getText()  - > TextField값가져오기 
 - radioGroup.getSelectedToggle().getUserData().toString()	- > ToggleGroup의 선택된 값 가져오기
 - areaCombo.getSelectionModel().getSelectedItem()=" + areaCombo.getSelectionModel().getSelectedItem() - > combo박스 값가져오기
 - areaCombo.getSelectionModel().getSelectedIndex()=" + areaCombo.getSelectionModel().getSelectedIndex() - > combo박스 index값가 져오기
 - chkA.getText()	- > 체크박스의 값가져오기
 - chkB.getText()   - > 체크박스의 값가져오기
 * 
 * 
 * 
 * 
 */
public class Test05JavaFXBaseComponentController implements Initializable {
	
	// 성명
	@FXML private TextField txtName;
	
	// ToggleGroup 은 JavaFX Scence Builder 에서 Properties - > specific에 Toggle Group으로 설정한다.
	@FXML private ToggleGroup radioGroup;
 
	// 지역
	@FXML private ComboBox<String> areaCombo;
	
	// 등산 체크박스
	@FXML private CheckBox chkA;
	
	// 독서 체크박스
	@FXML private CheckBox chkB;
	
	// 등산 라벨
	@FXML private Label labelA;
	
	// 독서 라벨
	@FXML private Label labelB;
	
	// TextArea
	@FXML private TextArea txtArea;
	
	// TreeView
//	@FXML private TreeView<String> treeView;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		// ComboBox박스 초기화
		areaCombo.setValue("서울");
		
		
		// ComboBox박스 
		areaCombo.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// 콤보박스의 선택된값을 알수있다.
				System.out.println(areaCombo.getSelectionModel().getSelectedItem());
				System.out.println("조회이벤트");
				
			}}
				 
		);
		
//		areaCombo.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
//
//			public void changed(ObservableValue ov, Number value, Number new_value) {
//	            System.out.println("11111111111111");
//	            System.out.println("ov.getValue() = "+ov.getValue());
//	            System.out.println("value = "+value);
//	            System.out.println("new_value = "+new_value);
//	          }
//	          
//          
//          
//        });
		
		
		// 라디오그룹에 이벤트주기
		radioGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> observable,
					Toggle oldValue, Toggle newValue) {
				System.out.println(radioGroup.getSelectedToggle());
				if(radioGroup.getSelectedToggle() != null ){
					System.out.println("radioGroup.getSelectedToggle()= " + radioGroup.getSelectedToggle());
					System.out.println(radioGroup.getSelectedToggle().getUserData().toString());
				}
			}
			
		});
		 		
		
		
		// 체크박스 [등산] 이벤트
		chkA.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(chkA.isSelected()){
					labelA.setVisible(true);	
					labelA.setPrefHeight(28.0);
				}else{
					labelA.setVisible(false);
					labelA.setPrefHeight(0);
				}
			}
		});
		// 체크박스 [독서] 이벤트
		chkB.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(chkB.isSelected()){
					labelB.setVisible(true);	
					labelB.setPrefHeight(28.0);
				}else{
					labelB.setVisible(false);
					labelB.setPrefHeight(0);
					
				}
			}
		});
		//initTreeView();
	}
	
	/**
	 * @method : onClickEvent
	 * @parmam : 
	 * @return : void
	 * @description : 클릭 이벤트
	 */
	public void onClickEvent(ActionEvent e ){
		String str = "";
		
		if(txtName.getText().equals("")){

			
			Stage myDialog = new Stage();
            myDialog.initModality(Modality.WINDOW_MODAL);
           
            
            // java1.7에는 Aerlt이 없기때문에 Scene으로 대체함. //			 Alert alert = new Alert(AlertType.INFORMATION);
            Scene myDialogScene = new Scene(VBoxBuilder.create().children(new Text("성명을 입력하세요"))
                    .alignment(Pos.CENTER)
                    .padding(new javafx.geometry.Insets(30))
                    .build());
            myDialog.setScene(myDialogScene);
            myDialog.show();
			return;

		}
		
		// 라디오 버튼의 값을 가져오기 위해서 형번환을 함.
		RadioButton selectedRadio = (RadioButton) radioGroup.getSelectedToggle();
		
		str += "성명 = " + txtName.getText() + "\n";
		str += "성별 =[" + selectedRadio.getText() +"] "+ radioGroup.getSelectedToggle().getUserData().toString()+ "\n";
		str += "지역 = " + areaCombo.getSelectionModel().getSelectedItem() + " / " + areaCombo.getSelectionModel().getSelectedIndex()+"번째"  + "\n";
		str += "취미 = " + chkA.getText() + " / " + chkA.getUserData() + "\n";
		if(chkB.isSelected() == true){
			str += "취미 = " + chkB.getText() + " / " + chkB.getUserData() + "\n";
		}
		
		str += "\n";
		
		System.out.println( txtName.getText());
		System.out.println( radioGroup.getSelectedToggle().getUserData().toString());
		System.out.println( "areaCombo.getSelectionModel().getSelectedItem()=" + areaCombo.getSelectionModel().getSelectedItem());
		System.out.println( "areaCombo.getSelectionModel().getSelectedIndex()=" + areaCombo.getSelectionModel().getSelectedIndex());
		System.out.println( "chkA = " + chkA.getText());
		System.out.println( "chkB = " + chkB.getText());
		
		
//		txtArea.setText(str);
		txtArea.appendText(str);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	/**
//	 * @method : initTreeView
//	 * @parmam : 
//	 * @return : void
//	 * @description : TreeView
//	 */
//	private void initTreeView() {
//		TreeItem<String> rootItem = new TreeItem<String>("Root");
//		rootItem.setExpanded(true); // 확장여부
//		
//		TreeItem<String> item = new TreeItem<String>("A");
//		rootItem.getChildren().add(item);
//		
//		item = new TreeItem<String>("B");
//		rootItem.getChildren().add(item);
//		treeView.setRoot(rootItem);	// TreeView에 Setting Root시킨다.
//		
//		
//		// treeView 이벤트
//		treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
//
//            @Override
//            public void changed(
//                    ObservableValue<? extends TreeItem<String>> observable,
//                    TreeItem<String> old_val, TreeItem<String> new_val) {
//            	// 이 메서드의 oldValue는 이전 상태값이 기억되어 있고 
//				// newValue에는 변경된 상태값이 기억되어 있다.
//            	
//            	System.out.println("observable.getValue() = "+observable.getValue());
//            	System.out.println("observable.getValue().getValue() = "+observable.getValue().getValue());
//            	
//            	// 이전값을 알수있다.
//            	System.out.println(old_val.getValue());
//            	
//            	// 이후값을 알수있다.
//            	System.out.println(new_val.getValue());
//            	
//                TreeItem<String> selectedItem = new_val;
//                System.out.println("Selected Text : " + selectedItem.getValue());
//                // do what ever you want
//            }
//
//        });
//	  
//		 
//	}

 
}
