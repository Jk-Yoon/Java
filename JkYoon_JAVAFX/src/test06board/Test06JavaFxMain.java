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
 * @desciption :  �����ڹٷθ� ���� �Խ��� ���� ��Ʈ�ѷ�
 * ���α׷�����
 * 01. BorderPane ���̾ �׸���.
 * 02. Button , ChoiceBox�� TableView�� �׸���.
 * 03. Controller�� �����.
 * 03. Controller�� fxml�� ����� ���� ������´�.
 * 04. BoardVO.java �� ���� �����.
 * 05. List��ü�� �̿������� initList()�� �̿��Ͽ� �����͸� �ִ� �۾��� �Ѵ�.
 * 06. ��ü ��ȸ�� ���� �ϵ��� �Ѵ�.
 * 07. ��Ϲ�ư���� ȭ����ȯ�� �ϵ����Ѵٰ� �����Ѵ�.
 * 08. Test06JavaFxMainDetail.fxml ȭ���� ���������
 *     Test06JavaFxMainDetailController.java�� �����.
 * 09. Controller�� fxml�� ����� ���� ������´�.
 * 10. ��Ϲ�ư�� ���� �ڵ��� �Ѵ�. onCreatEvent()
 * 11. Test06JavaFxMainDetailController ���� �����ư�� onclickSave()�Լ��� �ڵ��Ѵ�.
 * 12. Test06JavaFxMainController.java���� ������ư�� ó���Ѵ�.
 * 13. ��ȸ�������� ��ȸ�� �Ǵ°��� �ڵ��Ѵ�. selectListData()�Լ��� �ڵ��Ѵ�.
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
