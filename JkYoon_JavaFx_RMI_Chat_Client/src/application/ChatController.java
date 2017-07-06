package application;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import com.rmi.chat.ChatServerService;
import com.rmi.chat.client.ChatClientServiceImpl;


/**
 * @class : ChatController.java
 * @title : 
 * @author : Yoon
 * @desciption : 채팅창 Controller
 */
public class ChatController implements Initializable{
	// 채팅방 이름
	@FXML Label labelChat;
	
	// 메시지 창
    @FXML
    private TextField txtMessage;

    // 닉네임 창
    @FXML
    private TextField txtNickName;

    // 전송 버튼
    @FXML
    private Button btnSend;

    // TextArea
    @FXML
    private TextArea textArea;
    
    // 채팅 클라이언트 Impl
    private ChatClientServiceImpl client;
    
    // 채팅 서버
    private ChatServerService server;
    
    // 채팅방명
    private String chatRoomName;
    

  
    // 전송버튼클릭시
    @FXML
    void onclickSend(ActionEvent event) {
    	// 서버가 null이 아니라면
    	if(server!=null){
    		
    		try {
    			// 메시지에 닉네임을 붙여 채팅메시지를 만들고
        		String message = "[" + txtNickName.getText() + "]" + txtMessage.getText();
        		//채팅 서버로 해당 채팅방의 이름과 채팅메시지를 보낸다.	
				server.setMessage(chatRoomName, message);
				
				//메시지를 보낸 후 채팅입력창 내용을 지운다.
				txtMessage.setText("");
				
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    }

    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// 메시지 키이벤트
		txtMessage.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.ENTER){
					// 서버가 null이 아니라면
			    	if(server!=null){
			    		
			    		try {
			    			// 메시지에 닉네임을 붙여 채팅메시지를 만들고
			        		String message = "[" + txtNickName.getText() + "]" + txtMessage.getText();
			        		//채팅 서버로 해당 채팅방의 이름과 채팅메시지를 보낸다.	
							server.setMessage(chatRoomName, message);
							
							//메시지를 보낸 후 채팅입력창 내용을 지운다.
							txtMessage.setText("");
							
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    	}
				}
			}
		});
		
	}
	
	//채팅방 환경 정보를 설정
	public void setChatEnv(ChatServerService server, ChatClientServiceImpl client, String chatRoomName ){
		this.server = server;
		this.client = client;
		this.chatRoomName = chatRoomName;
		this.client.setTextArea(textArea);
		this.labelChat.setText("채팅방이름: " + this.chatRoomName);
		
		
	}

	// 채팅창 종료시
	public void closeChat() {
		try {
			server.exitChat(chatRoomName, client);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
