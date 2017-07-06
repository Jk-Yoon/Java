package application.member.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * @class : MainController.java
 * @title : 
 * @author : Yoon
 * @desciption : 회원관리 메인화면
 */
public class MainController implements Initializable{


	// 등록버튼
	@FXML private Button btnInsert;	

	// 조회버튼
	@FXML private Button btnSearch;

	// 조회조건 콤보 박스
	@FXML private ComboBox<String> comboBoxSearch;

    // 조회조건
	@FXML private TextField txtSearch;

	// 테이블 view
	
	@FXML private TableView tableView;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// 화면 초기화
		initUI();
		
		// 이벤트 초기화
		initEvent();
		
	}


	
	
	/**
	 * @method : initEvent
	 * @parmam : 
	 * @return : void
	 * @description : 이벤트 초기화 
	 */
	private void initEvent() {
		
		// 조회 이벤트
		btnSearch.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				 
				System.out.println("조회이벤트");
				
			}}
				 
		);
		
		// 등록 이벤트
		btnInsert.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				System.out.println("등록이벤트");
				
			}
		});
		
		//  콤보박스
		comboBoxSearch.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				 
				System.out.println("조회이벤트");
				
			}}
				 
		);
		
	}




	/**
	 * @method : initUI
	 * @parmam : 
	 * @return : void
	 * @description : 화면 초기화
	 */
	private void initUI() {
//		comboBoxSearchGubun.getItems().addAll("제목", "작성자");
//		comboBoxSearchGubun.setValue("제목");
		// ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ 콤보박스 초기화 Start ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		comboBoxSearch.getItems().addAll("회원ID", "성명");
		comboBoxSearch.setValue("회원ID");
		// ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ 콤보박스 초기화 End ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■		
		
		
		
	}
	
	
	

}
