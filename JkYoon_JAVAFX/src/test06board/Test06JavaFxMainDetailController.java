package test06board;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import test06board.vo.BoardVO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @class : Test06JavaFxMainDetailController.java
 * @title : 
 * @author : Yoon
 * @desciption : ���/����/����/ Controller
 */
public class Test06JavaFxMainDetailController implements Initializable {
	
	// �۹�ȣ
	@FXML private TextField txtNo;
	
	// ����
	@FXML private TextField txtTitle;
	
	// �ۼ���
	@FXML private TextField txtName;
	
	// ����
	@FXML private Button btnSave;
	
	// ���
	@FXML private Button btnList;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @method : onclickList
	 * @parmam : 
	 * @return : void
	 * @throws IOException 
	 * @description : 
	 */
	public void onclickList() throws IOException {
		// �߿� ���ο� Stage�� ����⶧���� ������ �� Stage�� ������ ���ο���� ����⶧���� ���ο� Controller�� selectListData()�Լ��� �����Ų��.
		Stage stage = (Stage) txtNo.getScene().getWindow();
		// Test06JavaFxMain.fxml�� ���� ������Ʈ�� �ҷ��ͼ� Scene�� ��ġ
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Test06JavaFxMain.fxml"));
		BorderPane root = (BorderPane) loader.load();
		
		//fxmml���� �ҷ��� �г��� ���� ������.
		Scene scene = new Scene(root);
		stage.setTitle("Test06JavaFxMain");
		// ���������� ���� ����
		stage.setScene(scene);
		// ���������� ������
		stage.show();
	}
	
	/**
	 * @method : onclickSave
	 * @parmam : 
	 * @return : void
	 * @throws IOException 
	 * @description : ���� �̺�Ʈ
	 */
	public void onclickSave() throws IOException {
		System.out.println("onclickSave()");
		//String str = ((Button)e.getTarget()).getText(); �̺�Ʈ�� �ϳ��� �Ҷ� �̷������ �ִ�.
 
		String boardId = txtNo.getText();
		BoardVO boardVO = new BoardVO();
		 
		// �ű� �� �߰�
		if("".equals(boardId)){
			int nextSize = Test06JavaFxMainController.list.size() + 1;
			String nextSizeIndex = String.valueOf(nextSize);
			
			
			boardVO.setBoardId(nextSizeIndex);
			boardVO.setBoardTitle(txtTitle.getText());
			boardVO.setBoardWriter(txtTitle.getText());
			boardVO.setBoardContent(txtName.getText());
			
			//��ü�߰�
			Test06JavaFxMainController.list.add(boardVO);
		}else{ // �����ϱ�
			boardVO.setBoardId(txtNo.getText());
			boardVO.setBoardTitle(txtTitle.getText());
			boardVO.setBoardWriter(txtTitle.getText());
			boardVO.setBoardContent(txtName.getText());
			BoardVO tmpBoardVO = new BoardVO();
			for( int i = 0 ; i < Test06JavaFxMainController.list.size(); i++ ){
				tmpBoardVO = new BoardVO();
				
				tmpBoardVO = Test06JavaFxMainController.list.get(i);
				if(tmpBoardVO.getBoardId().equals(txtNo.getText())){
					Test06JavaFxMainController.list.set(i, boardVO);
				}
				
			}
			
			
		}
		 
		
		// �߿� ���ο� Stage�� ����⶧���� ������ �� Stage�� ������ ���ο���� ����⶧���� ���ο� Controller�� selectListData()�Լ��� �����Ų��.
		Stage stage = (Stage) txtNo.getScene().getWindow();
		// Test06JavaFxMain.fxml�� ���� ������Ʈ�� �ҷ��ͼ� Scene�� ��ġ
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Test06JavaFxMain.fxml"));
		BorderPane root = (BorderPane) loader.load();
		
		// ����â�� ��Ʈ�ѷ��� �����ͼ�
		Test06JavaFxMainController mainController = loader.getController();
		
		//fxmml���� �ҷ��� �г��� ���� ������.
		Scene scene = new Scene(root);
		stage.setTitle("Test06JavaFxMain");
		// ���������� ���� ����
		stage.setScene(scene);
		// ���������� ������
		stage.show();
		
		mainController.selectListData();
	
	}
	
	/**
	 * @method : setBoarderData
	 * @parmam : 
	 * @return : void
	 * @description : ���ε���Ų��.
	 */
	public void setBoarderData(BoardVO boardVo) {
		
		txtNo.setText(boardVo.getBoardId());
		txtTitle.setText(boardVo.getBoardTitle());
		txtName.setText(boardVo.getBoardWriter());
		
		System.out.println(" = setBoarderData =");
		
	}

}
