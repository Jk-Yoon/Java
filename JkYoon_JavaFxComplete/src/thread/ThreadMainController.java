package thread;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * @class : ThreadMainController.java
 * @title : 
 * @author : Yoon
 * @desciption : Thread를 이용한 JavaFx
 * 
 */
public class ThreadMainController implements Initializable{
	
	// 
	@FXML
	private AnchorPane anchorPane;
	//1. Rectangle 객체를 선언한다.
	Rectangle rectangle = new Rectangle();
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		//2. Rectangle 객체의 X,Y좌표를 만들어준다.
		rectangle.setX(10);
		rectangle.setY(10);
		
		
		//3. Rectangle 객체의 너비와 높이를 설정한다.
		rectangle.setWidth(20);
		rectangle.setHeight(20);
		
		//4. 색상을 넣는다
		rectangle.setFill(Color.rgb(255, 0, 0));
		
		// AnchorPane에 Rectangle추가한다.
		anchorPane.getChildren().add(rectangle);
		
		/**
		 * JavaFx UI는 쓰레드에 안전하지 않기 때문에 UI를 생성하고 
		 * 변경하는 작업은 JavaFX Application Tread가 담당
		 */
		
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0 ; i < 500 ; i ++){
					rectangle.setX(rectangle.getX()+1);

				 
					System.out.println("rectangle.getX() = " + rectangle.getX());

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		
	}
	 
}

