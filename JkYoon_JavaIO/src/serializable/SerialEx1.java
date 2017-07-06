package serializable;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @class : SerialEx1.java
 * @title : 전송할 데이터를 바이트 단위로 변환하는 과정
 * @author : Yoon
 * @desciption : 객체 직렬화
 *  
 * 객체를 일정크기로 자르기때문에 SerialEx1.ser에 글자가 깨짐
 */
public class SerialEx1 {
	
	public static void main(String[] args) throws Exception {
		String fileName = "src/serializable/SerialEx1.ser"; 
		FileOutputStream fos = new FileOutputStream(fileName);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		ObjectOutputStream out = new ObjectOutputStream(bos);
		
		UserInfo u1 = new UserInfo("JavaMan", "1234", 30);
		UserInfo u2 = new UserInfo("JavaWoman", "4321", 26);
		
		ArrayList<UserInfo> list = new ArrayList<UserInfo>();
		list.add(u1);
		list.add(u2);
		
		
		out.writeObject(u1);
		out.writeObject(u2);
		out.writeObject(list);
		out.close();

		System.out.println("직렬화가 잘 끝났습니다.");
		
		
		FileInputStream fis = new FileInputStream(fileName);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		ObjectInputStream in = new ObjectInputStream(bis);
		
		
		UserInfo u3 = (UserInfo) in.readObject(); 
		UserInfo u4 = (UserInfo) in.readObject();
		
		ArrayList<UserInfo>	 outList = (ArrayList<UserInfo>) in.readObject();
		
		System.out.println("u3 = " + u3);
		System.out.println("u4 = " + u4);
		System.out.println("outList = " + outList);
		
				 
		
		
		
	}

}
