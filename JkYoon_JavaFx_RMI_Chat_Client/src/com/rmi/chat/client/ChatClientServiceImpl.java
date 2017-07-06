package com.rmi.chat.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javafx.scene.control.TextArea;

import com.rmi.chat.ChatClientService;

/**
 * @class : ChatClientServiceImpl.java
 * @title : 
 * @author : Yoon
 * @desciption : 클라이언트 impl
 */
public class ChatClientServiceImpl extends UnicastRemoteObject implements ChatClientService{
	public ChatClientServiceImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	//채팅을 표시할 텍스트에어리어 - 실제로는 Chat.fxml에 있는 텍스트 에어리어의 주소값
	private TextArea textArea;
	
 
	public void setTextArea(TextArea textArea) {
		this.textArea = textArea;
	}



	@Override
	public void setMessage(String msg) throws RemoteException {
		System.out.println("msg = " + msg);
		if(this.textArea != null){
			this.textArea.setText(this.textArea.getText()+"\n"+msg);
		}
		
	}

}
