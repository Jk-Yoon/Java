package test06board;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @class : Test06JavaFxMain.java
 * @title : 
 * @author : Yoon
 * @desciption :  오직자바로만 만든 게시판 메인 컨트롤러
 * 프로그램순서
 * 01. BorderPane 레이어를 그린다.
 * 02. Button , ChoiceBox와 TableView를 그린다.
 * 03. Controller를 만든다.
 * 03. Controller에 fxml을 명시한 값을 적어놓는다.
 * 04. BoardVO.java 를 먼저 만든다.
 * 05. List객체를 이용함으로 initList()를 이용하여 데이터를 넣는 작업을 한다.
 * 06. 전체 조회가 먼저 하도록 한다.
 * 07. 등록버튼으로 화면전환을 하도록한다고 설명한다.
 * 08. Test06JavaFxMainDetail.fxml 화면을 먼저만들고
 *     Test06JavaFxMainDetailController.java를 만든다.
 * 09. Controller에 fxml을 명시한 값을 적어놓는다.
 * 10. 등록버튼에 대한 코딩을 한다. onCreatEvent()
 * 11. Test06JavaFxMainDetailController 에서 저장버튼을 onclickSave()함수를 코딩한다.
 * 12. Test06JavaFxMainController.java에서 삭제버튼을 처리한다.
 * 13. 조회조건으로 조회가 되는것을 코딩한다. selectListData()함수를 코딩한다.
 */
public class Test06JavaFxMain extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Test06JavaFxMain.fxml"));
		
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("Test06JavaFxMain");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
