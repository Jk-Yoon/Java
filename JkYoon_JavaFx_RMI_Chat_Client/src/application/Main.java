package application;
	
import java.rmi.server.UnicastRemoteObject;

import com.rmi.chat.ChatServerService;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


/**
 * @class : Main.java
 * @title : 
 * @author : Yoon
 * @desciption : 채팅클라이언트
 * D:\JkYoon\JavaFxworkspace\JkYoon_JavaFx_RMI_Chat_Server\bin> rmic  -keepgenerated application.chat.server.serviceImpl.ChatServerServiceImpl
 * 	
 * - JavaFx_RMI_Chat_Server프로젝트를 만든다.
 * - JavaFx_RMI_Chat_Client프로젝트를 만든다.	
 * - Client 에 필요한 파일을 복사시킨다.	D:\JkYoon\workspace\JkYoon_JavaFx_RMI_Chat_Client\src\ 밑에 복사한다. javafx.zip
 * - Server 프로젝트에서 ChatServerService.java을 만들어서 extends Remote를 상속받게 한다.
 * - Server 프로젝트에서 ChatServerServiceImpl.java을 만들어서 extends UnicastRemoteObject implements ChatServerService를 구현한다.
 * - Server 프로젝트에서 Main문을 먼저 만든다.
 * - Main.java를 작성한다.
 * - Main.fxml을 그린다.
 * - 접속버튼을 구현한다.		onclickConnect
 * - 새로고침버튼을 구현한다.	onclickRefresh
 * - ChatServerService.java, ChatServerServiceImpl.java		getChatList()함수를 구현한다.
 *   [client부분에 ChatServerService.java과 ChatServerServiceImpl_Stub.java를 같은 위치에 복사한다.]
 * - 새채팅방버튼을 구현한다.	onclickMakeChat
 * - ChatServerService.java, ChatServerServiceImpl.java 	makeNewRoom() 함수를 구현한다.
 *   [client부분에 ChatServerService.java과 ChatServerServiceImpl_Stub.java를 같은 위치에 복사한다.]
 * - MainController.java에서	initialize() 함수쪽에 tableView정보에 대한 정보(tableView 초기화, tableView 이벤트)를 구현한다.
 * - ChatServerService.java, ChatServerServiceImpl.java	joinChat() 함수를 구현한다.
 *   [client부분에 ChatServerService.java과 ChatServerServiceImpl_Stub.java를 같은 위치에 복사한다.]
 * - 위에서 구현도중 Chat.fxml과 ChatController.java 를 구현한다.
 * - MainController.java에서 ChatController.java를 호출하는 setChatEnv()함수를 구현한다.
 * - ChatController.java에서 onclickSend() 함수 호출 구현중에 setMessage()함수가 필요하므로 ChatServerService.java, ChatServerServiceImpl.java 를 구현한다. 
 *   [client부분에 ChatServerService.java과 ChatServerServiceImpl_Stub.java를 같은 위치에 복사한다.]
 * - 위에서 구현 도중 ChatClientService.java에서 setMessage()함수를 구현한다.
 * - MainController.java에서 setOnMousePressed()함수에서 stage.setOnCloseRequest()를 구현한다.
 * - ChatController.java에서 closeChat()함수를 구현한다.
 * - ChatServerService.java, ChatServerServiceImpl.java exitChat()함수를 구현한다. 
 *    [client부분에 ChatServerService.java과 ChatServerServiceImpl_Stub.java를 같은 위치에 복사한다.]
 * 
 * 
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
			
			BorderPane root = (BorderPane) loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
