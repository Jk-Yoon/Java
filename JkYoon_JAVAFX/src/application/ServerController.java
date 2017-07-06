package application;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;


public class ServerController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea server_area;

    @FXML
    private Button btn_on;

    @FXML
    private Button btn_off;
 
    Thread thread;
    ServerSocket serverSock = null;
    Socket  clientSock = null;
   
    @FXML
    void ServerOffClick(MouseEvent event) throws IOException {
    	thread.interrupt();
    	if(clientSock != null){
    		clientSock.close();
    	}
    	
    	serverSock.close();
    }

    @FXML
    void ServerOnClick(MouseEvent event) throws IOException {
    	
    	creatThread();
    		
    	
    }

 

	private void creatThread() {
		thread = new Thread(new Runnable() {
			
			
			InputStream is =null;
			FileOutputStream fis= null;
			String path="C:/bbb/Wildlife.wmv";
			@Override
			public void run() {
				try {
					serverSock = new ServerSocket(8888);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			while(true){
				try {
					
					clientSock = serverSock.accept();
					is = clientSock.getInputStream();
					fis = new FileOutputStream(new File(path));
					byte[] tmp = new byte[1024];
					int size = 0;
					while((size = is.read(tmp)) != -1){
						fis.write(tmp, 0, size);						
					}
					System.out.println("server end");
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
		               if(fis != null){
			                  try {
			                     fis.close();
			                  } catch (IOException e) {
			                     e.printStackTrace();
			                  }
			               }
			               if(is != null){
			                  try {
			                	  is.close();
			                  } catch (IOException e) {
			                     e.printStackTrace();
			                  }
			               }
			                
			               
			            }	  
				
				}
			}
    		});		
		thread.start();
		
	}

	@FXML
    void initialize() {
        assert server_area != null : "fx:id=\"server_area\" was not injected: check your FXML file 'ServerOn.fxml'.";
        assert btn_on != null : "fx:id=\"btn_on\" was not injected: check your FXML file 'ServerOn.fxml'.";
        assert btn_off != null : "fx:id=\"btn_off\" was not injected: check your FXML file 'ServerOn.fxml'.";
        server_area.setText("占쎄퐣甕곌쑴�뿯占쎈빍占쎈뼄.");
        
    }

 

}


