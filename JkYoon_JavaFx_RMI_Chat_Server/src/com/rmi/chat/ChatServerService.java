package com.rmi.chat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.rmi.chat.vo.ChatVo;

public interface ChatServerService extends Remote{
	
	//채팅방목록 리스트
	public List<String> getChatList() throws RemoteException;

	// 방만들기
	public boolean makeNewRoom(String chatRoomName) throws RemoteException;
	
	// 채팅방참석
	public void joinChat(String chatRoomName, ChatClientService client) throws RemoteException;
	
	// 메시지 전송
	public void setMessage(String chatRoomName, String msg) throws RemoteException;
	
	// 채팅방 나가기
	public void exitChat(String chatRoomName, ChatClientService client) throws RemoteException;
	
	
	
	public void sys(ChatVo chatVo) throws RemoteException;
}
