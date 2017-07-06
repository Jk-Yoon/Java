package test01;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @class : Test01JavaFxInitMain.java
 * @title : JavaFX01 Test
 * @author : Yoon
 * @desciption : javaFx에 대한 흐름 처리 main - > 생성자 - > lunch() - > init() - > start()	 - > stop 함수 순으로 처리된다는 것을
 *             보여주는 예제
 */
public class Test01JavaFxInitMain extends Application {


 
	/**
	 * 생성자
	 */
	public Test01JavaFxInitMain() {
		System.out.println(Thread.currentThread().getName() + ": Test01JavaFxInitMain() 호출");

	}

	/**
	 * init
	 */
	@Override
	public void init() throws Exception {
		System.out.println(Thread.currentThread().getName() + ": init() 호출");

	}

	/**
	 * start 함수
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println(Thread.currentThread().getName() + ": start() 호출");
		primaryStage.show();
	}

	@Override
	public void stop() throws Exception {
		System.out.println(Thread.currentThread().getName() + ": stop() 호출");

	}

	public static void main(String[] args) {

		System.out.println(Thread.currentThread().getName() + ": main() 호출");

		launch(args);

	}

}
