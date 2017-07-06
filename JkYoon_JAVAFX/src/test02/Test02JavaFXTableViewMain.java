package test02;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @class : Test02JavaFXTableView.java
 * @title : 
 * @author : Yoon
 * @desciption : Table view�̿��ϱ�
 */
public class Test02JavaFXTableViewMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// ���̺�� ����
		TableView table = new TableView();
		
		// ���̺� editable �Ҽ��ֵ��� ������ �̰͸����δ� ����Ҽ� ����. �Ʒ��� �ڵ��� ���� ����ؾ��Ѵ�. 
		// lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
	    table.setEditable(true);

	    // ���̺�信 �߰��� ���̺��÷�
	    TableColumn firstNameCol = new TableColumn("First Name");
	    TableColumn lastNameCol = new TableColumn("Last Name");
	    TableColumn addressCol = new TableColumn("Email");
	    
	    
	    // ���̺��÷��� �����Ϳ� ���ε� - ������Ƽ ��� ���丮�� ���� BoardVO�� String���� boardId�� �� �÷��� ��Ī���� ���ε� �Ѵ�.
	    firstNameCol.setCellValueFactory(new PropertyValueFactory<DataVo, String>("firstName"));
	    lastNameCol.setCellValueFactory(new PropertyValueFactory<DataVo, String>("lastName"));
	    addressCol.setCellValueFactory(new PropertyValueFactory<DataVo, String>("email"));
	    
	    // ������ ���̺� �÷����� ���̺�信 �߰��Ѵ�.        
	    table.getColumns().addAll(firstNameCol, lastNameCol, addressCol);
	    
	    List<DataVo> list = new ArrayList<DataVo>();
	    DataVo dataVo = new DataVo();
	    
	    dataVo.setFirstName("A1");
	    dataVo.setLastName("A2");
	    dataVo.setEmail("A3");
	    
	    list.add(dataVo);
	    
	    dataVo = new DataVo();
	    
	    dataVo.setFirstName("A4");
	    dataVo.setLastName("A5");
	    dataVo.setEmail("A6");
	  
	    list.add(dataVo);
	    
	     
	    for(int i = 0 ; i <list.size() ; i ++){
	    	
	    	System.out.println(list.get(i).getFirstName());
	    	
	    }
	    // �÷��� MinWidth�� �����Ѵ�.
	    firstNameCol.setMinWidth(100);
	    lastNameCol.setMinWidth(100);
	    addressCol.setMinWidth(100);
	    
	    //���̺�信 ���ε� �� ����������Ʈ  �ҷ��� �����͸� FXCollections�� ���� ����������Ʈ�� ��ȯ
	    ObservableList<DataVo> observableList = FXCollections.observableArrayList(list);
	    table.setItems(observableList);
	    
	    
	    Pane root = new Pane();
	    root.getChildren().add(table);
	    primaryStage.setScene(new Scene(root, 300, 250));
	    primaryStage.show();

	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	

}
 
	 