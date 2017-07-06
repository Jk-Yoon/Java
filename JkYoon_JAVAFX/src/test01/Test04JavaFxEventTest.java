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
 * @desciption : ��ư�̺�Ʈ ó����� 4���� ��� ����
 * 
 */
public class Test04JavaFxEventTest extends Application {
	Button btn1 = new Button("ù��°");
	Button btn2 = new Button("�ι�°");
	
	TextArea txtArea = new TextArea();
	
	@Override
	public void start(Stage primaryStage) {
		
		// VBox�� ��Ʈ�� �ش�.
		VBox root = new VBox(10);
		root.setPadding(new Insets(10));
		
		HBox hbox = new HBox(15);
		hbox.setPadding(new Insets(10));
		
		//-------------------------------------
		
		/*
			�̺�Ʈ ó�� ��� 1
			��ü.setOn�̺�Ʈ��() �޼��忡 EventHandler�������̽��� �͸��Լ� �������� �����Ѵ�.
			(�� �������̽����� handle�̶�� �޼��尡 �ִµ� �� �޼��忡 ó���� ������ ����Ѵ�.)
		*/
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// �̰��� ó���� ������ ����Ѵ�.
				txtArea.setText("ù��° ��ư�Դϴ�.");
				
			}}
				 
		);
		
		//-------------------------------------------------------
		/*
			���2
			��ü.addEventHandler()�޼��带 ����Ѵ�.
			==> �� �޼����� ù��° �Ű������� �̺�Ʈ�� ����(�̺�Ʈ��)��
				�����ϰ�, �ι�° �Ű������� EventHandler�������̽���
				������ ��ü�� �����Ѵ�.
		*/
		btn2.addEventHandler(ActionEvent.ACTION, 
			 	new EventHandler<Event>() {
					public void handle(Event event){
						txtArea.setText("�ι�° ��ư�Դϴ�.");
					}
				} 
		);
		
		Button btn3 = new Button("����°");
		// ��� 3-2
		// setOnAction()�޼����� �Ű������� EventHandler�������̽���
		// ������ ��ü�� �����ؼ� �־��ش�.
		// btn3.setonAction(new MyEventHandler);
		
		//addEventHandler()�޼����� �ι�° �Ű�������EventHandler�������̽��� ������ ��ü�� �����ؼ� �־��ش�.
		btn3.addEventFilter(ActionEvent.ACTION, new MyEventHandler());
		
		Button btn4 = new Button("�׹�°");
		// ��� 4-2
		btn4.setOnAction(new MyEventHandler2(txtArea));
		
		
		hbox.getChildren().addAll(btn1, btn2, btn3, btn4);
		root.getChildren().addAll(hbox, txtArea);
		
		Scene scene = new Scene(root, 320, 200);
		primaryStage.setTitle("Event���� ����");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
		//--------------------------------------
		/*
			���3-1
			innerŬ������ EventHandler�������̽��� ������ Ŭ������ �ۼ��Ѵ�.
		*/
		class MyEventHandler implements EventHandler<ActionEvent>{

			@Override
			public void handle(ActionEvent event) {
				txtArea.setText("����° inner Ŭ������ �̿��� �̺�Ʈ ó��");
			}
			
		}
	}

		//---------------------------------------
		/*
		  ��� 4-1
		  �ܺ��� ������ ������ ��ü�� �̿��ϴ� ���
		  --> �� ��ü�� EventHandler�������̽��� �����ؾ��Ѵ�,
		*/
class MyEventHandler2 implements EventHandler<ActionEvent>{
	private TextArea txtArea;
	
	public MyEventHandler2(TextArea txtArea){
		this.txtArea = txtArea;
	}
	
	@Override
	public void handle(ActionEvent event) {
		txtArea.setText("�׹�° �ܺ�Ŭ������ �̿��ϴ� ���");
	}
}
	
		
		
		
		
		


