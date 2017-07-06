package com.rmi.chat;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @class : ChatClientService.java
 * @title : 
 * @author : Yoon
 * @desciption : Client 인터페이스 
 */
public interface ChatClientService extends Remote{

	public void setMessage(String msg) throws RemoteException;
}
