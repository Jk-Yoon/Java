package socketnetwork;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @class : AddressClient.java
 * @title : 
 * @author : Yoon
 * @desciption :ObjectInputStream을 이용한 Socket연결을 통해서 Address객체를 전달함.
 * 
 */
public class AddressClient {

	 public static void main(String[] args) throws IOException {
		 
		 Socket socket = null; 
		 ObjectInputStream ois = null; 

		 ObjectOutputStream oos = null; 

		 Scanner sc = new Scanner(System.in); 

		 System.out.println("이름, 주소, 전화번호를 입력하세요."); 

		 System.out.print("이름 : "); 

		 String name = sc.nextLine(); 

		 System.out.print("주소 : "); 

		 String addr = sc.nextLine(); 

		 System.out.print("전화 번호 : "); 

		 String tel = sc.nextLine(); 

		 Address address = new Address(name, addr, tel); 

		 try { 

		    socket = new Socket("127.0.0.1", 50000); 

		    oos = new ObjectOutputStream( socket.getOutputStream() ); 

		    ois = new ObjectInputStream( socket.getInputStream() ); 

		    oos.writeObject( address ); // address객체를 보낸다.
		    //oos.flush(); // stream에 남이있는 데이터를 강제로 내보내는 역할을 한다.
		    String str = (String)ois.readObject(); //읽어온다.
		    System.out.println( str ); 

		    } catch(Exception e){
		    	
		    	e.printStackTrace();
		    } finally { 
		       if( oos != null ) oos.close(); 
		       if( ois != null ) ois.close(); 
		       if( socket != null ) socket.close(); 
		    } 

		 } 



}
