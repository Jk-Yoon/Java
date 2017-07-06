package fail01;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Test04BounBall extends Application {
	
	static int dx = 1;
	static int dy = 1;

	Rectangle[] recArray = new Rectangle[10];

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Animation");
	    Group root = new Group();
	    Scene scene = new Scene(root, 400, 300, Color.WHITE);

	    primaryStage.setScene(scene);
	    addBouncyBall(scene); 
	    
	    intiEnemy(scene); 
		 
	    primaryStage.show();
		
	}
	
	//적그리기
	private void intiEnemy(final Scene scene) {
		
		Rectangle rec = new Rectangle(50, 50);
		final Group root = (Group) scene.getRoot();
		for(int i=0 ; i < 10 ; i++){
			rec = new Rectangle(50, 50);
			rec.setFill(Color.BLUE);
			rec.setX(i*65);
			
//			System.out.println("rec.getTranslateX()  = "+rec.getTranslateX());
//			System.out.println("rec.getTranslateY()  = "+rec.getTranslateY());
//			System.out.println("rec.getTranslateZ()  = "+rec.getTranslateZ());
			
			
			
//			System.out.println("rec.getScaleX() = " + rec.getScaleX());
//			System.out.println("rec.getScaleY() = " + rec.getScaleY());
//			
//			System.out.println("rec.getWidth() = " + rec.getWidth());
//			
//			
//			System.out.println("rec.getX() = " + rec.getX());
//			System.out.println("rec.getY() = " + rec.getY());
			
			recArray[i] = rec;
			
			root.getChildren().add(rec);
		}
		
		    
		
	}

	public static void main(String[] args) {
	    Application.launch(args);
	}
	
	
	private void addBouncyBall(final Scene scene) {
	    final Circle ball = new Circle(50, 50, 20);

	    final Group root = (Group) scene.getRoot();
	    root.getChildren().add(ball);

	    Timeline tl = new Timeline();
	    tl.setCycleCount(Animation.INDEFINITE);
	    KeyFrame moveBall = new KeyFrame(Duration.seconds(.0200),
	            new EventHandler<ActionEvent>() {

	                public void handle(ActionEvent event) {

	                    double xMin = ball.getBoundsInParent().getMinX();
	                    double yMin = ball.getBoundsInParent().getMinY();
	                    double xMax = ball.getBoundsInParent().getMaxX();
	                    double yMax = ball.getBoundsInParent().getMaxY();

	                    if (xMin < 0 || xMax > scene.getWidth()) {
	                        dx = dx * -1;
	                    }
	                    if (yMin < 0 || yMax > scene.getHeight()) {
	                        dy = dy * -1;
	                    }

	                    ball.setTranslateX(ball.getTranslateX() + dx);
	                    ball.setTranslateY(ball.getTranslateY() + dy);

//	                  System.out.println("ball.getBoundsInParent().getMinX() = " + ball.getBoundsInParent().getMinX());
//	                  System.out.println("ball.getBoundsInParent().getMiny() = " + ball.getBoundsInParent().getMinY());
//	                  
//	                  System.out.println("ball.getBoundsInParent().getMiny() = " + ball.getBoundsInParent().getMinY());
	                  for(int i = 0 ; i < recArray.length ; i++){
	                	  
//	                	  System.out.println("recArray[i].getX() = " + recArray[i].getX());
//	                	  System.out.println("recArray[i].getY() = " + recArray[i].getY());
//	                	  System.out.println(ball.getBoundsInParent().getMinX() <= recArray[i].getX() && ball.getBoundsInParent().getMaxX() >= recArray[i].getX() );
//	                	  System.out.println( ball.getBoundsInParent().getMinY() <= recArray[i].getY() && ball.getBoundsInParent().getMaxY() >= recArray[i].getY());
	                	  
	                	  
	                	  System.out.println("recArray[i].getY() = " + recArray[i].getY());
	                	  System.out.println("ball.getBoundsInParent().getMaxY() = " + ball.getBoundsInParent().getMaxY());
	                	  
	                	  if(ball.getBoundsInParent().getMinX() <= recArray[i].getX() && ball.getBoundsInParent().getMaxX() >= recArray[i].getX() ){
	                		  System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	                		  if(  ball.getBoundsInParent().getMaxY() == recArray[i].getY()+100){
	                			  System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
	                			  
	                			  recArray[i].setFill(Color.WHITE);
	                			 

	                		  }
	                		  
		                  }
	                  }
	                
	                  
	                  
	                  
	                }
	            });

	    tl.getKeyFrames().add(moveBall);
	    tl.play();
	}

	
}
