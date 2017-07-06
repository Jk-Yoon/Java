package test01;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @class : Test04JavaFxEventTest.java
 * @title : 
 * @author : Yoon
 * @desciption : 버튼이벤트 처리방법 4가지 방법 설명
 * 
 */
public class Test04JavaFxEventTest extends Application {
	Button btn1 = new Button("첫번째");
	Button btn2 = new Button("두번째");
	
	TextArea txtArea = new TextArea();
	
	@Override
	public void start(Stage primaryStage) {
		
		// VBox를 루트로 준다.
		VBox root = new VBox(10);
		root.setPadding(new Insets(10));
		
		HBox hbox = new HBox(15);
		hbox.setPadding(new Insets(10));
		
		//-------------------------------------
		
		/*
			이벤트 처리 방법 1
			객체.setOn이벤트명() 메서드에 EventHandler인터페이스를 익명함수 형식으로 구현한다.
			(이 인터페이스에는 handle이라는 메서드가 있는데 이 메서드에 처리할 내용을 기술한다.)
		*/
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// 이곳에 처리할 내용을 기술한다.
				txtArea.setText("첫번째 버튼입니다.");
				
			}}
				 
		);
		
		//-------------------------------------------------------
		/*
			방법2
			객체.addEventHandler()메서드를 사용한다.
			==> 이 메서드의 첫번째 매개변수로 이벤트의 종류(이벤트명)를
				지정하고, 두번째 매개변수는 EventHandler인터페이스를
				구현한 객체를 지정한다.
		*/
		btn2.addEventHandler(ActionEvent.ACTION, 
			 	new EventHandler<Event>() {
					public void handle(Event event){
						txtArea.setText("두번째 버튼입니다.");
					}
				} 
		);
		
		Button btn3 = new Button("세번째");
		// 방법 3-2
		// setOnAction()메서드의 매개변수로 EventHandler인터페이스를
		// 구현한 객체를 생성해서 넣어준다.
		// btn3.setonAction(new MyEventHandler);
		
		//addEventHandler()메서드의 두번째 매개변수에EventHandler인터페이스를 구현한 객체를 생성해서 넣어준다.
		btn3.addEventFilter(ActionEvent.ACTION, new MyEventHandler());
		
		Button btn4 = new Button("네번째");
		// 방법 4-2
		btn4.setOnAction(new MyEventHandler2(txtArea));
		
		
		hbox.getChildren().addAll(btn1, btn2, btn3, btn4);
		root.getChildren().addAll(hbox, txtArea);
		
		Scene scene = new Scene(root, 320, 200);
		primaryStage.setTitle("Event설정 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
		//--------------------------------------
		/*
			방법3-1
			inner클래스로 EventHandler인터페이스를 구현한 클래스를 작성한다.
		*/
		class MyEventHandler implements EventHandler<ActionEvent>{

			@Override
			public void handle(ActionEvent event) {
				txtArea.setText("세번째 inner 클래스를 이용한 이벤트 처리");
			}
			
		}
	}

		//---------------------------------------
		/*
		  방법 4-1
		  외부의 독립된 형태의 객체를 이용하는 방법
		  --> 이 객체도 EventHandler인터페이스를 구현해야한다,
		*/
class MyEventHandler2 implements EventHandler<ActionEvent>{
	private TextArea txtArea;
	
	public MyEventHandler2(TextArea txtArea){
		this.txtArea = txtArea;
	}
	
	@Override
	public void handle(ActionEvent event) {
		txtArea.setText("네번째 외부클래스를 이용하는 방법");
	}
}
	
		
		
		
		
		


