package tt;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BasicController implements Initializable{

    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnDelete;
    @FXML
    private CheckBox showHide;
    @FXML
    private Button btnModify;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnInsert;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private HBox imageHbox;
    @FXML
    private HBox btnGroup;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Basic01 시작~!");
		
		//쿼리질의
		VBox vb1 = new VBox(2);
		VBox vb2 = new VBox(2);
		
		vb1.setPrefWidth(100);
		vb1.setPrefHeight(300);
		
		vb2.setPrefWidth(100);
		vb2.setPrefHeight(300);
		
		Image im = new Image("/Koala.jpg");
		Image im2 = new Image("/Hydrangeas.jpg");
		
		ImageView iv = new ImageView();
		iv.setFitWidth(90);
		iv.setFitHeight(90);
		iv.setImage(im);
		
		ImageView iv2 = new ImageView();
		iv2.setFitWidth(90);
		iv2.setFitHeight(90);
		iv2.setImage(im2);
		
		Label lb = new Label();
		lb.setText("하이요");
		
		
		vb1.getChildren().add(iv);
		vb1.getChildren().add(lb);
		vb2.getChildren().add(iv2);
		imageHbox.getChildren().add(vb1);
		imageHbox.getChildren().add(vb2);
//		scAnco.getChildren().add(vb1);
//		scAnco.getChildren().add(vb2);
		
		//이벤트 핸들러를 이용한 이벤트 처리(글추가)
		btnModify.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//1.텍스트에 글쓰기
//				txtResult.setText("Modify Button Clicked.");
				//2.기존 텍스트에 추가하기
				txtResult.setText(txtResult.getText()+"\nModify Button Clicked.");
			}
		});
		
		//글삭제
		btnDelete.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				txtResult.setText("");
			}
		});
		
		btnCancel.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				VBox vb = new VBox(3);
				vb.setPrefWidth(200);
				vb.setPrefHeight(300);
				ImageView iv = new ImageView();
				Image im = new Image("/Koala.jpg");
				iv.setImage(im);
				vb.getChildren().add(iv);
				scrollPane.setContent(vb);
			}
		});
		
		
	}
	
	@FXML
    void showHide2(ActionEvent event) {
		System.out.println("showHide invoked.");
		if(showHide.isSelected()){
			btnGroup.setVisible(false);
//			btnInsert.setVisible(false);
//			btnCancel.setVisible(false);
//			btnDelete.setVisible(false);
//			btnModify.setVisible(false);
			
			showHide.setText("show");
		}else{
			btnGroup.setVisible(true);
//			btnInsert.setVisible(true);
//			btnCancel.setVisible(true);
//			btnDelete.setVisible(true);
//			btnModify.setVisible(true);
			
			showHide.setText("hide");
		}
    }

}
