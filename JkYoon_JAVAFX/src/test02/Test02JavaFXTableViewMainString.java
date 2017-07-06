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
		
		// 테이블뷰 생성
		TableView table = new TableView();
		
		// 테이블 editable 할수있도록 하지만 이것만으로는 사용할수 없다. 아래의 코딩과 같이 사용해야한다. 
		// lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
	    table.setEditable(true);

	    // 테이블뷰에 추가할 테이블컬럼
	    TableColumn firstNameCol = new TableColumn("First Name");
	   
	    
	    
	    // 테이블컬럼과 데이터와 바인드 - 프로퍼티 밸류 팩토리를 통해 BoardVO의 String값인 boardId를 이 컬럼과 매칭시켜 바인드 한다.
	    firstNameCol.setCellValueFactory(new PropertyValueFactory<String, String>("firstName"));
	    
	    // 설정한 테이블 컬럼들을 테이블뷰에 추가한다.        
	    table.getColumns().addAll(firstNameCol);
	    
	    List<String> list = new ArrayList<String>();
	    
	    list.add("aaaaaaaa");
	    
	     
	    for(int i = 0 ; i <list.size() ; i ++){
	    	
	    	System.out.println(list.get(i));
	    	
	    }
	    // 컬럼의 MinWidth를 설정한다.
	    firstNameCol.setMinWidth(100);
	  
	    
	    //테이블뷰에 바인드 될 옵저버블리스트  불러온 데이터를 FXCollections를 통해 옵저버블리스트로 변환
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
