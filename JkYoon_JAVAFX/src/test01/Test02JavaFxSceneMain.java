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
 * @desciption : Main문에 만들기 
 */
public class Test02JavaFxSceneMain extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}
	
	Label label = new Label(); 		// 라벨
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		
		
		VBox root = new VBox();   //Parent 하위 객체인 VBox 생성
		root.setPrefWidth(350);	// VBox의 넓이 설정
		root.setPrefHeight(350);// VBox의 높이 설정
		root.setAlignment(Pos.CENTER);
		
		
		label.setText("start JavaFx");	// text 속성 설정
		label.setFont(new Font(60));	// font 속성설정
		
		Button btn = new Button();
		btn.setText("확인");
		btn.setOnAction(new EventHandler<ActionEvent>() { // 클릭이벤트처리
            @Override public void handle(ActionEvent e) {
            	// Platform.exit(); Application 종료
            	label.setText("setOnAction이벤트");
	            	
            }
        });
		
		
		root.getChildren().add(label);	// vbox에 label컨트롤 추가
		root.getChildren().add(btn);	// vbox에 button컨트롤 추가
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("Test02JavaFxScene");
		primaryStage.setScene(scene);
		primaryStage.show();
	 
	}

}
