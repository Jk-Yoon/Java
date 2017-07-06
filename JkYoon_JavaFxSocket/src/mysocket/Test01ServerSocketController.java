package mysocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
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

/**
 * @class : Test01ServerSocketController.java
 * @title : 
 * @author : Yoon
 * @desciption :
 * 1. 클라이언트관리하는 변수를 먼저 만든다.	HashMap<String, Socket> clients;
 * 2. Test01ServerSocketController() 생성자를 만든다.
 * 3. Test01ServerSocketMain.fxml 화면구성한다.
 * - Server Start 버튼에 fx:id ="btnServerStart"	onAction="#onClickServerStart"
 * - 채팅창 : fx:id="textArea"
 * - 접속정보 확인창 : fx:id="textConnection"
 * - 입력창 :  	fx:id= "inputField" onKeyPressed="#onPressedStart"
 * 4. onClickServerStart()클릭 이벤트에  serverStart()함수불러주는것을 만든다.
 * 5. serverStart()함수를 구현한다.
 * 6. ConnectThread 클래스를 구성한다.
 * 7. ServerReceive 클래스 구성 [메시지를에받는 클래스를 구성한다.]
 * 8. ServerReceive 클래스 구성중에 sendToAll() 함수를 구성한다.
 * ----------------------------------------클라이언트로 이동----------------------------------------------------
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
 * 
 */
public class Test01ServerSocketController implements Initializable{

	
	/** 
	 * 3. Test01ServerSocketMain.fxml 화면구성한다.
	 */
	 @FXML
	 private Button btnServerStart;

	 @FXML
	 private TextField inputField;

	 @FXML
	 private Label labelCnt;
	 
	 // 서버가 시작되어 있는지 알려주는 라벨
	 @FXML
	 private TextField textConnection;
	 
	 @FXML
	 private TextArea textArea;
	
	// 1. 클라이언트관리하는 변수를 먼저 만든다.	HashMap<String, Socket> clients;
	HashMap<String, Socket> clients;
	
	
	// 2. Test01ServerSocketController() 생성자를 만든다.
	public Test01ServerSocketController(){
		System.out.println("Test01ServerSocketController()");
		clients = new HashMap<String, Socket>();
		
		//동기화처리를 해준다.
		Collections.synchronizedMap(clients);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
 
    /**
     * @method : onClickServerStart
     * @parmam : 
     * @return : void
     * @description : 서버스타트
     */
    @FXML
    void onClickServerStart(ActionEvent event) {
    	serverStart();
    }
    
    
    ServerSocket serverSocket = null;
	Socket socket = null;
    
	/**
	 * @method : serverStart
	 * @parmam : 
	 * @return : void
	 * @description : 서버 Start메소드
	 */
    private void serverStart() {
		
		try {
			serverSocket = new ServerSocket(4040);
			textConnection.setText("서버가 시작되었습니다.");
			
			// 쓰레드 구현 [쓰레드로 구현하지 않으면 화면이 멈추는 현상이 발생합니다.]
			// - > 꼭 기억할것 javaFx는 별도의 쓰레드에서 돌기때문에 serverSocket.acept()함수를 사용할시 별도의 쓰레드로 할것 
			// Socket socket = serverSocket.accept();
			
			ConnectThread connectThread = new ConnectThread(serverSocket);
            connectThread.start();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    /**
     * @class : Test01ServerSocketController.java
     * @title : 
     * @author : Yoon
     * @desciption :  접속 클래스 만들기
     */
    class ConnectThread extends Thread {
        ServerSocket mainServerSocket = null;
 
        ConnectThread(ServerSocket mainServerSocket) {
            this.mainServerSocket = mainServerSocket;
        }
 
        @Override
        public void run() {
            try {
                while (true) {
                	// 접속자가 들어올때 까지 대기한다.
                    Socket socket = mainServerSocket.accept();
                    textConnection.setText("사용자 접속!");
 
                    // 메시지를 받는 클래스를 구성한다.   
                    ServerReceiver thread = new ServerReceiver(socket);
					thread.start();
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
	 * @method : sendToAll
	 * @parmam : 
	 * @return : void
	 * @description : 클라이언트들에게 메시지를 전달해준다.
	 */
	void sendToAll(String msg){
		// 클라이언트의 정보를 받아온다.
		Iterator<String> it = clients.keySet().iterator();
		//값이 있으면.
		while(it.hasNext()){
			Socket socket = new Socket();
			socket = clients.get(it.next());
			try {
				// 클라이언트 소켓으로 메시지를 전송하기위한 OutputStream생성
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				out.writeUTF(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
 
	/**
     * @method : onPressedStart
     * @parmam : 
     * @return : void
     * @description : 입력창
     */
    @FXML
    void onPressedStart(javafx.scene.input.KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		sendToAll("[서버] = "+inputField.getText());
    	}
    }

    
    /**
	 * @class : ServerReceiver
	 * @title : 
	 * @author : Yoon
	 * @desciption : Server 메시지 받는 Class 
	 */
	class ServerReceiver extends Thread {
		
		Socket socket;			// 소켓
		DataInputStream in;		// 받기
		DataOutputStream out;	// 보내기
		
		/**
		 * 생성자
		 */
		public ServerReceiver(Socket socket) {
			
			this.socket = socket;
			
			try {
				// 클라이언트 소켓에서 보내온 메시지를 받을 InputStream생성
				in = new DataInputStream(socket.getInputStream());
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			String name = "";
			try {
				
				// 닉네임을 받고 클라이언트의 소켓정보를 clients변수에 담는다.
				name = in.readUTF();
				// 클라이언트를 추가한다.
				clients.put(name, socket);
				
				// Not on FX application thread; currentThread = Thread-4 가 발생하기 때문에 Platform.runLater를 사용함.
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						labelCnt.setText("현재 서버접속자 수는 "+ clients.size()+"입니다.");
						
					}
				});
				
				textArea.appendText("#"+name+"님이 들어오셨습니다.\n");
				// 서버로 들어온정보를 클라이언트에게 보내는 메소드를 구성한다.
				sendToAll("#"+name+"님이 들어오셨습니다.\n");
				 
				String str = "";
				while(in != null){
					str = in.readUTF(); // readUTF는 한번쓰면 없어진다.
					// 서버로 들어온정보를 클라이언트에게 보내는 메소드를 구성한다.
					sendToAll(str);
					textArea.appendText(str+"\n");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// Socket 종료는 일반적으로 finally Block에서 처리
				textArea.appendText("#"+name+"님이 나가셨습니다.");
				sendToAll("#"+name+"님이 나가셨습니다.");// 서버로 들어온정보를 클라이언트에게 보내는 메소드를 구성한다.
				clients.remove(name);
				
				textArea.appendText("["+socket.getInetAddress() + ":" + socket.getPort()+"]에서 접속을 종료하였습니다.");
				labelCnt.setText("현재 서버접속자 수는 "+ clients.size()+"입니다.");
				
			}
		}
		
	}

}
