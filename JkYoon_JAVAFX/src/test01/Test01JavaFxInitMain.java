package test01;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @class : Test01JavaFxInitMain.java
 * @title : JavaFX01 Test
 * @author : Yoon
 * @desciption : javaFx�� ���� �帧 ó�� main - > ������ - > lunch() - > init() - > start()	 - > stop �Լ� ������ ó���ȴٴ� ����
 *             �����ִ� ����
 */
public class Test01JavaFxInitMain extends Application {


 
	/**
	 * ������
	 */
	public Test01JavaFxInitMain() {
		System.out.println(Thread.currentThread().getName() + ": Test01JavaFxInitMain() ȣ��");

	}

	/**
	 * init
	 */
	@Override
	public void init() throws Exception {
		System.out.println(Thread.currentThread().getName() + ": init() ȣ��");

	}

	/**
	 * start �Լ�
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println(Thread.currentThread().getName() + ": start() ȣ��");
		primaryStage.show();
	}

	@Override
	public void stop() throws Exception {
		System.out.println(Thread.currentThread().getName() + ": stop() ȣ��");

	}

	public static void main(String[] args) {

		System.out.println(Thread.currentThread().getName() + ": main() ȣ��");

		launch(args);

	}

}
