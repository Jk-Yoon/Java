package application;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialogs;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import com.rmi.chat.ChatServerService;
import com.rmi.chat.client.ChatClientServiceImpl;
import com.rmi.chat.vo.ChatVo;

public class MainController  implements Initializable{
	
	  
	@FXML private Button btnConnect;	//접속버튼	
	  
	@FXML private Button btnNewRoom;	//새채팅방버튼

	@FXML private Button btnReload;		//새로고침버튼
	  
	@FXML private TableView<ChatVo> tableView;	// 테이블뷰
	
	@FXML private Label labelConnected;	// 커넥션 라벨
	
	//채팅 서버 
	private ChatServerService server;
	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		TableColumn<ChatVo, String> col = new TableColumn<ChatVo, String>("채팅방목록");
		col.setCellValueFactory(new PropertyValueFactory<ChatVo, String>("chatRoomName"));
		
		col.setMinWidth(400);
		
		tableView.getColumns().add(col);
		
		tableView.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				//이벤트가 마우스 주버튼 클릭이고, 마우스 클릭 수가 두번이면 더블클릭이라고 판단하도록 설정
				if(event.isPrimaryButtonDown() && event.getClickCount() == 2){
					System.out.println("setOnMousePressed()");
					//클릭한 채팅방 정보를 가져오고
					ChatVo vo = tableView.getSelectionModel().getSelectedItem();
					
					try {
						//채팅 클라이언트를 신규 생성하여
						ChatClientServiceImpl client = new ChatClientServiceImpl();
						
						//서버에 채팅 참여 요청을 보냄
						server.joinChat(vo.getChatRoomName(), client);
						
						 final FXMLLoader loader = new FXMLLoader(getClass().getResource("Chat.fxml"));
						 BorderPane pane = (BorderPane) loader.load();
						
						 
						//채팅환경 정보 설정을 하기 위해 loader로부터 컨트롤러 객체를 가져온다.
						 ChatController chatController = loader.getController();
						//컨트롤러의 setChatEnv 메서드에 매개변수를 ChatServer, ChatClient, 채팅방이름을 보내 채팅방 환경설정
						 chatController.setChatEnv(server, client, vo.getChatRoomName());
						 
						//씬 설정
						Scene scene = new Scene(pane);
						
						Stage stage = new Stage();
						//스테이지에 씬을 붙인다
						stage.setScene(scene);
						
						//채팅방 팝업을 채팅방 리스트 윈도우에 종속되도록(채팅방 팝업을 끄기 전까지 접근되지 않도록)
						stage.initModality(Modality.APPLICATION_MODAL);
						
						//채팅방이 꺼질 때 채팅종료 메서드를 호출되도록 이벤트를 설정한다.
						stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
							
							@Override
							public void handle(WindowEvent event) {
								ChatController chatController = loader.getController();
								chatController.closeChat();
								
							}
						});
						
						//스테이지를 show 하면 채팅방 팝업이 생성된다.
						stage.show();
						
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
		});
		
		
	}
	
	// 접속 버튼 클릭
	@FXML
	void onclickConnect(ActionEvent event) throws RemoteException, NotBoundException {
		
		Registry registry = LocateRegistry.getRegistry(1099);
		server = (ChatServerService) registry.lookup("chat");
		
		labelConnected.setText("접속되었습니다.");
		System.out.println("접속되었습니다.");
		
	}
	
	
	// 새로고침 버튼 클릭
	@FXML
	void onclickRefresh(ActionEvent event) throws RemoteException {
		
		List<String> chatList = server.getChatList(); //서버로부터 채팅리스트를 가져온다
		
		List<ChatVo> chatVoList = new ArrayList<ChatVo>();
		
		//단순 String 리스트로는 테이블뷰인 채팅방 목록에 내용을 표시할 수 없어
		//ChatVO 객체에 각각 옮겨 담아 새로운 리스트를 만든다.
		ChatVo chatVo = new ChatVo();
		for(int i = 0 ; i < chatList.size() ; i++ ){
			chatVo = new ChatVo();
			chatVo.setChatRoomName(chatList.get(i));
			chatVoList.add(chatVo);
		}
		
		//테이블뷰에 데이터를 넣기 위해서는 리스트를 옵저버블리스트로 변환하여야 한다.
		ObservableList<ChatVo> tableViewList = FXCollections.observableArrayList(chatVoList);
		//변환한 옵저저블리스트를 테이블뷰에 셋팅한다.
		tableView.setItems(tableViewList);
		
	}
	
	// 새채팅방 클릭
	@FXML
	void onclickMakeChat(ActionEvent event) throws RemoteException {
		//채팅방 관련 메시지 팝업을 띄우기 위해 메시지 팝업이 띄워질 스테이지를 가져온다.
		Stage stage = (Stage) btnConnect.getScene().getWindow();
		String chatRoomName = Dialogs.showInputDialog(stage, "새로 만들 채팅방 이름을 입력하세요");
		
		while(chatRoomName == null || "".equals(chatRoomName)){
			chatRoomName = Dialogs.showInputDialog(stage, "잘못 입력하였습니다. \n 새로 만들 채팅방 이름을 입력하세요");
			
		}
		System.out.println("chatRoomName " + chatRoomName);
		// 방을 만들기위해서
		boolean isMake = server.makeNewRoom(chatRoomName);
		
		//새로 채팅방이 생성되었다면 새로운 채팅방이 개설되었다고 알리고 
		//생성되지 않았다면 실패하였다는 메시지를 표시한다.
		
		if(isMake){ 
			Dialogs.showInformationDialog(stage, "새로운 채팅방이 개설되었습니다.");
			
		}else{
			Dialogs.showWarningDialog(stage, "이미 존재하는 채팅방 이름입니다.");
		}
		
		// 채팅방을 새로 생성 후 채팅방 리스트를 새로고침 한다.
		onclickRefresh(null);
		
	}
	


}
