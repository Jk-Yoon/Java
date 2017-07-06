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
 * @desciption : TextField, ToggleGroup, ComboBox, CheckBox, Label�̿��ϱ�
 * 
 *  * ���α׷� ����
1. ���� + input�� �׸���. fx:id = "txtName"
2. ���� + ������ư ����, ���ڸ� �׸���.			fx:id="radioMan" fx:id="radiowoMan"	
	ToggleGroup �� JavaFX Scence Builder ���� Properties - > specific�� Toggle Group���� ����
3. ���� + �޺��ڽ��� �׸���.			fx:id="areaCombo"
4. ��� + üũ�ڽ��� �׸���.			fx:id="chkA" fx:id="chkB"
5. pane���� treeView�� �׸���.			fx:id="treeView"
6. ��ư�� �׸���.				onAction="#onClickEvent"
7. txtArea�� �׸���.				fx:id="txtArea"
8. ��ư �̺�Ʈ onClickEvent()�Լ��� TextArea�� �ִ� ������ String str�� ��´�.
 - txtName.getText()  - > TextField���������� 
 - radioGroup.getSelectedToggle().getUserData().toString()	- > ToggleGroup�� ���õ� �� ��������
 - areaCombo.getSelectionModel().getSelectedItem()=" + areaCombo.getSelectionModel().getSelectedItem() - > combo�ڽ� ����������
 - areaCombo.getSelectionModel().getSelectedIndex()=" + areaCombo.getSelectionModel().getSelectedIndex() - > combo�ڽ� index���� ������
 - chkA.getText()	- > üũ�ڽ��� ����������
 - chkB.getText()   - > üũ�ڽ��� ����������
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
