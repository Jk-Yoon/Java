package socketnetwork;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

 
/**
 * @class : AddressServer.java
 * @title : 
 * @author : Yoon
 * @desciption : ObjectInputStream을 이용한 Socket연결을 통해서 Address객체를 전달함.
 */
public class AddressServer {
	public static void main(String[] args) throws IOException {
		//클라이언트
		Socket socket = null;
		// 받는 Stream
		ObjectInputStream ois = null;
		// 보내는 Stream
		ObjectOutputStream oos = null;
	 
		// 서버소켓을 생성하여 50001번 포트와 결합(bind)시킨다.
		ServerSocket serversocket = new ServerSocket(50001);
		// accept()메서드는 client에서 연결 요청이 올 때까지 계속 기다린다.
		socket = serversocket.accept();
		
		// 소켓의 입력 스트림을 얻어온다.
		ois = new ObjectInputStream(socket.getInputStream());
		
		// 소켓의 출력 스트림을 얻어온다.
		oos = new ObjectOutputStream(socket.getOutputStream());



		Object obj;
		try {
			
			obj = ois.readObject();
			Address addr = (Address) obj;
			Calendar cal = Calendar.getInstance();
			oos.writeObject(String.format("입력하신 이름111111111111은 %s, 주소는 %s, 전화번호는 %s이며 \n " +
							" 현재 서버의 시간은 %Tp %s:%s분입니다.\n" ,addr.getName(),addr.getAddr(),addr.getTel(),cal,cal.get(cal.HOUR),cal.get(cal.MINUTE)));
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{//자원을 해제하기 위해서 사용해준다.
			
			//ObjectOutputStream 자원해제
			if (oos != null) oos.close();
	
			//ObjectInputStream 자원해제
			if (ois != null) ois.close();
			
			//Socket 자원해제
			if (socket != null) socket.close();

		}
	
	}
}
	 
			
/**
 * 
			ois.readObject()를 사용할시 null 객체를 반환하지 않기때문에 EOFException이 발생한다.
			
			try {
				while ((obj = ois.readObject()) != null){
					Address addr = (Address) obj;
					Calendar cal = Calendar.getInstance();
					oos.writeObject(String.format("입력하신 이름111111111111은 %s, 주소는 %s, 전화번호는 %s이며 \n " +
									" 현재 서버의 시간은 %Tp %s:%s분입니다.\n" ,addr.getName(),addr.getAddr(),addr.getTel(),cal,cal.get(cal.HOUR),cal.get(cal.MINUTE)));
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
			catch (EOFException e) {
				// 일반적으로 직렬화된 파일을 읽을때 얼마나 많은 객체가 해당 파일에 쓰여 졌는지 알지 못할 수 있으므로
				// EOFException 예외를 처리에서 아무작업을 하지않으면됩니다.
			}
 */		
	
