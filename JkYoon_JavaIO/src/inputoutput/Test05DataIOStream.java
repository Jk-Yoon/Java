package inputoutput;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @class : Test05DataIOStream.java
 * @title : 
 * @author : Yoon
 * @desciption :  DataOutputStream은 출력용 데이터를 자료형에 맞게 출력해 준다.
 */
public class Test05DataIOStream {
	
	public static void main(String[] args) throws IOException {
		
		
		
		FileOutputStream fout = new FileOutputStream("src/inputoutput/Test05DataIOStream.txt");
		
		// DataOutputStream은 출력용 데이터를 자료형에 맞게 출력해 준다. Data[객체형태]로 읽고 쓰기때문에 글자가 깨짐
		// DataOutputStream이 출력하는 형식의 각 기본 자료형 값을 16진수로 표현하여 저장하기때문에 한글이 깨짐으로 보인다.
		DataOutputStream dout = new DataOutputStream(fout);
		
		dout.writeInt(200);
		dout.writeFloat(131.4f);
		dout.writeBoolean(false);
		
		System.out.println("출력완료");
		
		dout.close();
		fout.close();
		
		//================================================================
		
		
		//===============================================
		//출력한 자료 읽어오기
		FileInputStream fin = new FileInputStream("src/inputoutput/Test05DataIOStream.txt");
		DataInputStream din = new DataInputStream(fin);
		
		System.out.println("정수형 자료 : " + din.readInt());
		System.out.println("실수형 자료 : " + din.readFloat());
		System.out.println("논리형 자료 : " + din.readBoolean());
		
		din.close();
		fin.close();
	}

}
