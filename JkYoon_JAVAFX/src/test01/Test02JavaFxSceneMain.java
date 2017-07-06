package test01;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @class : Test02JavaFxScene.java
 * @title : 
 * @author : Yoon
 * @desciption : Main���� ����� 
 */
public class Test02JavaFxSceneMain extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}
	
	Label label = new Label(); 		// ��
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		
		
		VBox root = new VBox();   //Parent ���� ��ü�� VBox ����
		root.setPrefWidth(350);	// VBox�� ���� ����
		root.setPrefHeight(350);// VBox�� ���� ����
		root.setAlignment(Pos.CENTER);
		
		
		label.setText("start JavaFx");	// text �Ӽ� ����
		label.setFont(new Font(60));	// font �Ӽ�����
		
		Button btn = new Button();
		btn.setText("Ȯ��");
		btn.setOnAction(new EventHandler<ActionEvent>() { // Ŭ���̺�Ʈó��
            @Override public void handle(ActionEvent e) {
            	// Platform.exit(); Application ����
            	label.setText("setOnAction�̺�Ʈ");
	            	
            }
        });
		
		
		root.getChildren().add(label);	// vbox�� label��Ʈ�� �߰�
		root.getChildren().add(btn);	// vbox�� button��Ʈ�� �߰�
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("Test02JavaFxScene");
		primaryStage.setScene(scene);
		primaryStage.show();
	 
	}

}
