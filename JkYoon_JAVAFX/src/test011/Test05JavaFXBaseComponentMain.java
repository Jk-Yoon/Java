package test011;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @class : Test05JavaFXBaseComponentMain.java
 * @title : 
 * @author : Yoon
 * @desciption : TextField, ToggleGroup, ComboBox, CheckBox, Label이용하기
 * 
 *  * 프로그램 순서
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
 */
public class Test05JavaFXBaseComponentMain extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Test05JavaFXBaseComponentMain.fxml"));
		
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("Test05JavaFXBaseComponentMain");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
