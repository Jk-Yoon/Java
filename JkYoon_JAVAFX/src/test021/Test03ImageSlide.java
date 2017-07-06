package test021;

import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @class : Test03ImageSlide.java
 * @title : 
 * @author : Yoon
 * @desciption : �̹��� �����̵�
 */
public class Test03ImageSlide extends Application{
	

	// �׸���ũ��
	public static final double D = 200;  // diameter.
	
	// �׸��� ũ�� * 6 = ����
	public static final double W = D*6; // canvas dimensions.
	// �׸��� ũ�� * 6 = �ʺ�
    public static final double H = D*6;

    DoubleProperty x  = new SimpleDoubleProperty();
    DoubleProperty y  = new SimpleDoubleProperty();
    
    DoubleProperty z = new SimpleDoubleProperty();

    final Canvas canvas = new Canvas(200, 200);
    
    @Override 
    public void start(Stage stage) {

        Pane pane = new Pane();
      
        Scene scene = new Scene(pane,400,400);
        pane.getChildren().add(canvas);
        
        stage.setScene(scene);
        stage.show();
        
        setAnimation();
        
    }
    
    public void setAnimation(){
    	 
    	
    	// Timeline ( ������(KeyFrame), ������(KeyFrame))
    	// KeyFrame (�ð�, KeyValue)
    	// KeyValue(����, ����)
    	Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(0),
            		new KeyValue(x, 0),
            		new KeyValue(y, 0)
            ),
            new KeyFrame(Duration.seconds(15),
            		 new KeyValue(x, D - W),
            		 new KeyValue(y, D - H)
            )
        );
    	
    	// �ǵ���������
        timeline.setAutoReverse(true);
        // ������ ���
        timeline.setCycleCount(Timeline.INDEFINITE);	
        
        

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                GraphicsContext gc = canvas.getGraphicsContext2D();
                Image image1 = new Image("test021/dice_1.jpg");
                Image image2 = new Image("test021/dice_2.jpg");
                Image image3 = new Image("test021/dice_3.jpg");
                Image image4 = new Image("test021/dice_4.jpg");
                Image image5 = new Image("test021/dice_5.jpg");
                Image image6 = new Image("test021/dice_6.jpg");
                
                System.out.println("x- " + x);
                System.out.println("y- " + y);
                
            	// drawImage(�̹���, ��������, ��������, �ʺ�, ����)
                gc.drawImage(image1,x.doubleValue(), 0, D, D);		
                gc.drawImage(image2,x.doubleValue()+D, 0, D, D);
                gc.drawImage(image3,x.doubleValue()+D*2, 0, D, D);
                gc.drawImage(image4,x.doubleValue()+D*3, 0, D, D);
                gc.drawImage(image5,x.doubleValue()+D*4, 0, D, D);
                gc.drawImage(image6,x.doubleValue()+D*5, 0, D, D);
                
//              y������ �̵��ϰ� �ϱ� ����
//              gc.drawImage(image1, 0, y.doubleValue(), D, D);		
//              gc.drawImage(image2,0, y.doubleValue()+D, D, D);
//              gc.drawImage(image3,0, y.doubleValue()+D*2, D, D);
//              gc.drawImage(image4,0, y.doubleValue()+D*3, D, D);
//              gc.drawImage(image5,0, y.doubleValue()+D*4, D, D);
//              gc.drawImage(image6,0, y.doubleValue()+D*5, D, D);
            }
                
        };
       
        timer.start();
        timeline.play();
    }

	public static void main(String[] args) {
		launch(args);
	}


}
