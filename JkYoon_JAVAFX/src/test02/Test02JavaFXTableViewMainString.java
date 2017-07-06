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
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Test02JavaFXTableViewMainString extends Application {
	


	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// ���̺�� ����
		TableView table = new TableView();
		
		// ���̺� editable �Ҽ��ֵ��� ������ �̰͸����δ� ����Ҽ� ����. �Ʒ��� �ڵ��� ���� ����ؾ��Ѵ�. 
		// lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
	    table.setEditable(true);

	    // ���̺�信 �߰��� ���̺��÷�
	    TableColumn firstNameCol = new TableColumn("First Name");
	   
	    
	    
	    // ���̺��÷��� �����Ϳ� ���ε� - ������Ƽ ��� ���丮�� ���� BoardVO�� String���� boardId�� �� �÷��� ��Ī���� ���ε� �Ѵ�.
	    firstNameCol.setCellValueFactory(new PropertyValueFactory<String, String>("firstName"));
	    
	    // ������ ���̺� �÷����� ���̺�信 �߰��Ѵ�.        
	    table.getColumns().addAll(firstNameCol);
	    
	    List<String> list = new ArrayList<String>();
	    
	    list.add("aaaaaaaa");
	    
	     
	    for(int i = 0 ; i <list.size() ; i ++){
	    	
	    	System.out.println(list.get(i));
	    	
	    }
	    // �÷��� MinWidth�� �����Ѵ�.
	    firstNameCol.setMinWidth(100);
	  
	    
	    //���̺�信 ���ε� �� ����������Ʈ  �ҷ��� �����͸� FXCollections�� ���� ����������Ʈ�� ��ȯ
	    ObservableList<String> observableList = FXCollections.observableArrayList(list);
	    table.setItems(observableList);
	    
	    
	    StackPane root = new StackPane();
	    root.getChildren().add(table);
	    primaryStage.setScene(new Scene(root, 300, 250));
	    primaryStage.show();

	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	



}
