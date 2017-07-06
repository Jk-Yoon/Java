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
 * @desciption :  TextField, ToggleGroup, ComboBox, CheckBox, Label�̿��ϱ�
 * 
 * ���α׷� ����
1. ���� + input�� �׸���. fx:id = "txtName"
2. ���� + ������ư ����, ���ڸ� �׸���.			fx:id="radioMan" fx:id="radiowoMan"	
	ToggleGroup �� JavaFX Scence Builder ���� Properties - > specific�� Toggle Group���� ����
3. ���� + �޺��ڽ��� �׸���.			fx:id="areaCombo"
4. ��� + üũ�ڽ��� �׸���.			fx:id="chkA" fx:id="chkB"
																					5. pane���� treeView�� �׸���.			fx:id="treeView"
6. ��ư�� �׸���.				onAction="#onClickEvent"
7. txtArea�� �׸���.				fx:id="txtArea"
8. ��ư �̺�Ʈ onClickEvent()�Լ��� TextArea�� �ִ� ������ String str�� ��´�.
 - txtName.getText()  - > TextField���������� 
 - radioGroup.getSelectedToggle().getUserData().toString()	- > ToggleGroup�� ���õ� �� ��������
 - areaCombo.getSelectionModel().getSelectedItem()=" + areaCombo.getSelectionModel().getSelectedItem() - > combo�ڽ� ����������
 - areaCombo.getSelectionModel().getSelectedIndex()=" + areaCombo.getSelectionModel().getSelectedIndex() - > combo�ڽ� index���� ������
 - chkA.getText()	- > üũ�ڽ��� ����������
 - chkB.getText()   - > üũ�ڽ��� ����������
 * 
 * 
 * 
 * 
 */
public class Test05JavaFXBaseComponentController implements Initializable {
	
	// ����
	@FXML private TextField txtName;
	
	// ToggleGroup �� JavaFX Scence Builder ���� Properties - > specific�� Toggle Group���� �����Ѵ�.
	@FXML private ToggleGroup radioGroup;
 
	// ����
	@FXML private ComboBox<String> areaCombo;
	
	// ��� üũ�ڽ�
	@FXML private CheckBox chkA;
	
	// ���� üũ�ڽ�
	@FXML private CheckBox chkB;
	
	// ��� ��
	@FXML private Label labelA;
	
	// ���� ��
	@FXML private Label labelB;
	
	// TextArea
	@FXML private TextArea txtArea;
	
	// TreeView
//	@FXML private TreeView<String> treeView;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		// ComboBox�ڽ� �ʱ�ȭ
		areaCombo.setValue("����");
		
		
		// ComboBox�ڽ� 
		areaCombo.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// �޺��ڽ��� ���õȰ��� �˼��ִ�.
				System.out.println(areaCombo.getSelectionModel().getSelectedItem());
				System.out.println("��ȸ�̺�Ʈ");
				
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
		
		
		// �����׷쿡 �̺�Ʈ�ֱ�
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
		 		
		
		
		// üũ�ڽ� [���] �̺�Ʈ
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
		// üũ�ڽ� [����] �̺�Ʈ
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
	 * @description : Ŭ�� �̺�Ʈ
	 */
	public void onClickEvent(ActionEvent e ){
		String str = "";
		
		if(txtName.getText().equals("")){

			
			Stage myDialog = new Stage();
            myDialog.initModality(Modality.WINDOW_MODAL);
           
            
            // java1.7���� Aerlt�� ���⶧���� Scene���� ��ü��. //			 Alert alert = new Alert(AlertType.INFORMATION);
            Scene myDialogScene = new Scene(VBoxBuilder.create().children(new Text("������ �Է��ϼ���"))
                    .alignment(Pos.CENTER)
                    .padding(new javafx.geometry.Insets(30))
                    .build());
            myDialog.setScene(myDialogScene);
            myDialog.show();
			return;

		}
		
		// ���� ��ư�� ���� �������� ���ؼ� ����ȯ�� ��.
		RadioButton selectedRadio = (RadioButton) radioGroup.getSelectedToggle();
		
		str += "���� = " + txtName.getText() + "\n";
		str += "���� =[" + selectedRadio.getText() +"] "+ radioGroup.getSelectedToggle().getUserData().toString()+ "\n";
		str += "���� = " + areaCombo.getSelectionModel().getSelectedItem() + " / " + areaCombo.getSelectionModel().getSelectedIndex()+"��°"  + "\n";
		str += "��� = " + chkA.getText() + " / " + chkA.getUserData() + "\n";
		if(chkB.isSelected() == true){
			str += "��� = " + chkB.getText() + " / " + chkB.getUserData() + "\n";
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
//		rootItem.setExpanded(true); // Ȯ�忩��
//		
//		TreeItem<String> item = new TreeItem<String>("A");
//		rootItem.getChildren().add(item);
//		
//		item = new TreeItem<String>("B");
//		rootItem.getChildren().add(item);
//		treeView.setRoot(rootItem);	// TreeView�� Setting Root��Ų��.
//		
//		
//		// treeView �̺�Ʈ
//		treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
//
//            @Override
//            public void changed(
//                    ObservableValue<? extends TreeItem<String>> observable,
//                    TreeItem<String> old_val, TreeItem<String> new_val) {
//            	// �� �޼����� oldValue�� ���� ���°��� ���Ǿ� �ְ� 
//				// newValue���� ����� ���°��� ���Ǿ� �ִ�.
//            	
//            	System.out.println("observable.getValue() = "+observable.getValue());
//            	System.out.println("observable.getValue().getValue() = "+observable.getValue().getValue());
//            	
//            	// �������� �˼��ִ�.
//            	System.out.println(old_val.getValue());
//            	
//            	// ���İ��� �˼��ִ�.
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
