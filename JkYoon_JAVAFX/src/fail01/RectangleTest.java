package fail01;

import com.sun.org.apache.bcel.internal.generic.LUSHR;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RectangleTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		 
		Rectangle rec = new Rectangle(100, 100);
		for(int i=0 ; i < 10 ; i++){
			
			rec.setX(0+(i*100));
			rec.setY(100+(i*100));
			
		}
		
		primaryStage.setTitle("Animation");
	    Group root = new Group();
	    Scene scene = new Scene(root, 400, 300, Color.WHITE);

	    primaryStage.setScene(scene);
	     
		 
	    primaryStage.show();
		
		
	}
	/**
	 * @method : main
	 * @parmam : 
	 * @return : void
	 * @description : 
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
