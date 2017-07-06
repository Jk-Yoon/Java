package com.rmi.chat.vo;

import java.io.Serializable;


/**
 * @class : ChatVO.java
 * @title : 
 * @author : Yoon
 * @desciption : 채팅방이름 VO
 */
public class ChatVo implements Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private String chatRoomName;

	public String getChatRoomName() {
		return chatRoomName;
	}

	public void setChatRoomName(String chatRoomName) {
		this.chatRoomName = chatRoomName;
	}
	
	
	

}
