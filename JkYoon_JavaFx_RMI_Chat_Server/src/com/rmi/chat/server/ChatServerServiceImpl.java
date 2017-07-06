package com.rmi.chat.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.rmi.chat.ChatClientService;
import com.rmi.chat.ChatServerService;
import com.rmi.chat.vo.ChatVo;

 
/**
 * @class : ChatServerServiceImpl.java
 * @title : 
 * @author : Yoon
 * @desciption : 채팅서버
 * rmic  -keepgenerated application.chat.server.serviceImpl.ChatServerServiceImpl
 */
public class ChatServerServiceImpl extends UnicastRemoteObject implements ChatServerService {

	// 채팅방번호, ArrayList<클라이언트>	한방에 여러명들어갈꺼니깐 리스트 
	private HashMap<String, ArrayList<ChatClientService>> chatListMap;
	
	protected ChatServerServiceImpl() throws RemoteException {
		chatListMap = new HashMap<String, ArrayList<ChatClientService>>();
		Collections.synchronizedMap(chatListMap);
	}

	
	@Override
	public List<String> getChatList() throws RemoteException {
		System.out.println("getChatList()");
		
		//채팅방 목록을 담아 반환할 리스트
		List<String> chatList = new ArrayList<String>();
		
		//채팅방리스트맵에서 키값들을 뽑아내면 채팅방 이름 목록이 됨
		Iterator<String> chatListIt = chatListMap.keySet().iterator();
		
		while(chatListIt.hasNext()){
			chatList.add(chatListIt.next());
			
		}
		System.out.println("chatList.size() = " + chatList.size());
		
		return chatList;
	}

	@Override
	public boolean makeNewRoom(String chatRoomName) throws RemoteException {
		System.out.println("makeNewRoom()");
		
		// 해당 이름의 채팅방이 이미 있는지 확인하기 위해 채팅리스트맵의 키셋에 포함되어있는지 확인
		boolean isExist = chatListMap.keySet().contains(chatRoomName);
		// 새로운 채팅방의 생성에 성공했는지 여부를 반환하기 위한 변수
		boolean result = false;
		
		if(isExist){// 이미 같은 이름의 채팅방이 있음
			result = false;
		}else{// 같은 이름의 채팅방이 없으므로 새로 생성함
			ArrayList<ChatClientService> chat = new ArrayList<ChatClientService>();
			// 채팅리스트맵에 채팅방 이름으로 채팅리스트를 넣음
			chatListMap.put(chatRoomName, chat);		// 채팅클래이언트 빈값을 넣는다[주소넣는거지라..]
			// 새로운 채팅방 생성에 성공하였으므로 결과값은 true를 반환함
			result = true;
		}
		
		
		
		
		return result;
	}

	@Override
	public void joinChat(String chatRoomName, ChatClientService client)
			throws RemoteException {
		System.out.println("joinChat()");
		//채팅방에 참가하기 위해 해당 채팅방 이름의 접속자 목록을 가져옴
		 ArrayList<ChatClientService> chatList = chatListMap.get(chatRoomName);
		 
		 chatList.add(client);
		
	}

	@Override
	public void exitChat(String chatRoomName, ChatClientService client)
			throws RemoteException {
		//채팅방에 참가하기 위해 해당 채팅방 이름의 접속자 목록을 가져옴
		 ArrayList<ChatClientService> chatList = chatListMap.get(chatRoomName);
		//접속자 목록에 삭제
		 chatList.remove(client);
		
	}

	@Override
	public void setMessage(String chatRoomName, String msg)
			throws RemoteException {
		
		System.out.println("setMessage()");
		
		// 채팅방에서 메시즈를 전송하기 위해 해당 채팅방 이름의 접속자 목록을 가져옴
		ArrayList<ChatClientService> chatList = chatListMap.get(chatRoomName);
		
		//채팅방에 있는 접속자들에게 메시지를 전송함
		ChatClientService client = null;
		for(int i = 0 ; i < chatList.size() ; i ++){
			
			client = chatList.get(i);
			client.setMessage(msg);
		}
	}
	
	/**
	 * @method : main
	 * @parmam : 
	 * @return : void
	 * @description : Main문
	 */
	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		
		Registry registry = LocateRegistry.createRegistry(1099);
		
		ChatServerServiceImpl server = new ChatServerServiceImpl();
		registry.bind("chat", server);
		System.out.println("Server Start");
		
	}


	@Override
	public void sys(ChatVo chatVo) throws RemoteException {
		System.out.println("sys");
		
	}

}
