package mysocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * @class : Test01ClientSocketController.java
 * @title : 
 * @author : Yoon
 * @desciption : 클라이언트
 * 
 * 1. 클라이언트를 구성한다. Test01ClientSocketMain.java 파일을 만든다.
 * 2. Test01ClientSocketMain.fxml 화면구성한다.
 * - 접속버튼 : fx:id="btnClientConn" onAction="#onClientConnect" text="Connection" 
 * - 접속정보 라벨 : fx:id="labelConnect"
 * - 채팅창 : fx:id="textArea"
 * - 닉네임 : fx:id="nickName"
 * - 채팅입력창 : fx:id="txtField"	onKeyPressed="#onClientKeyPressed"
 * 3. Socket clientSocket = null; 변수생성
 * 4. onClientConnect()함수를 구성한다.
 * 5. ClientReceiver 클래스를 구성한다.
 * 6. onClientKeyPressed() 이벤트를 구성한다.
 * 
 */
public class Test01ClientSocketController implements Initializable{
	
	
 
		
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	// 접속 버튼
	@FXML
    private Button btnClientConn;

	// 접속정보 알림 라벨
    @FXML
    private Label labelConnect;

    // 닉네임입력란
    @FXML
    private TextField nickName;

    // 입력창
    @FXML
    private TextField txtField;
    
    @FXML 
    private TextArea textArea;
    
    // Socket변수
    Socket clientSocket = null;

    /**
     * @method : onClientKeyPressed
     * @parmam : 
     * @return : void
     * @description : 입력창엔터 이벤트
     */
    @FXML
    void onClientKeyPressed(KeyEvent event) throws IOException {
    	
    	if(event.getCode() == KeyCode.ENTER){    	
    		
    		String sendMessage = "[" + nickName.getText() + "] = " + txtField.getText();
    		DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
    		out.writeUTF(sendMessage);
    		
    		txtField.clear();
    	}
 
    	
    }

    /**
     * @method : onClientConnect
     * @parmam : 
     * @return : void
     * @description : 접속버튼 이벤트
     */
    @FXML
    void onClientConnect(ActionEvent event) throws UnknownHostException, IOException {
    	
    	
    	if(nickName.getText().equals("")){
    		labelConnect.setText("닉네임을 입력하세요.");
    		return;
    	}
    	
    	
    	clientSocket = new Socket("127.0.0.1" ,4040);
    	
    	if(clientSocket != null){
    		labelConnect.setText("접속되었습니다.");
    		// 닉네임을 변경 못하게 한다.
    		nickName.setEditable(false); 
    		
    		// 버튼의 라벨을 JOIN으로 바꾼다.
    		btnClientConn.setText("JOIN");
    	}
    	
    	// 소켓의 출력스트림을 얻어서 보낸다.
    	DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
    	out.writeUTF(nickName.getText());
    	

    	// 5. ClientReceiver 클래스를 구성한다.
    	Thread receiver = new Thread(new ClientReceiver(clientSocket));
    	receiver.start();
    	
    }
   
    
    /**
     * @class : Test01ClientSocketController.java
     * @title : 
     * @author : Yoon
     * @desciption : ClientReceiver 클래스
     */
    class ClientReceiver extends Thread{
    	Socket socket = null;
    	DataInputStream in;
    	
    	public ClientReceiver(Socket socket) throws IOException {
			this.socket = socket;
			
			in = new DataInputStream(socket.getInputStream());
		}
    	
    	@Override
    	public void run() {
    		while(in != null){
    			
					try {
						textArea.appendText(in.readUTF()+"\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						
						// 소켓이 닫혀있을때
						if(clientSocket.isClosed()){
							labelConnect.setText("서버프로그램이 종료되었습니다.");
						}
						
					}
    		}
    	}
    	
    }
    
    

}
