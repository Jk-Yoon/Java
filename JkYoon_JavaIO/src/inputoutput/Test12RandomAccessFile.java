package inputoutput;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @class : Test12RandomAccessFile.java
 * @title : RandomAccessFile
 * @author : Yoon
 * @desciption : RandomAccessFile을 이용하여 파일 읽고 쓰기
 */
public class Test12RandomAccessFile {
	
	
	public static void main(String[] args) throws IOException {

		  // "rw"모드로 파일을 생성하고 있다. 따라서 입력과 출력이 동시에 가능하다.
		  RandomAccessFile raf = new RandomAccessFile("src/inputoutput/Test12RandomAccessFile.txt", "rw");
		  System.out.println("Write.................................");
		  // getFilePointer 메소드를 통해서 현재의 입출력 위치를 확인하고 있다.
		  // 파일을 생성한 직후이므로 당연히 위치는 0이다(0은 맨 앞을 의미함)
		  System.out.printf("현재 입출력 위치 : %d 바이트 \n", raf.getFilePointer());
		  
		  // writelnt 메소드의 호출을 통해서 두 개의 정수를 저장한 다음에 다시 입출력 위치를
		  // 확인하고 있다. 4바이트씩 총 2개의 데이터가 삽입되었으므로 입출력 위치는 8로 증가된다.
		  // (입출력 위치가 맨 앞에서 8바이트 뒤로 이동하였으므로).
		  raf.writeInt(200);
		  raf.writeInt(500);
		  System.out.printf("현재 입출력 위치 : %d 바이트 \n", raf.getFilePointer());			// int형은 8바이트
		  
		  raf.writeDouble(48.65);															// double형은 16바이트	
		  raf.writeDouble(52.24);
		  System.out.printf("현재 입출력 위치 : %d 바이트 \n", raf.getFilePointer());
		  
		  System.out.println("Read.................................");
		  // 데이터 저장이 완료된 다음에 seek 메소드를 호출하면서 0을 인자로 전달하고 있다.
		  // 이는 0바이트의 위치로(맨앞) 입출력 위치를 변경하라는 의미이다. 즉 seek 메소드는
		  // 인자로 전달된 값에 해당하는 바이트 위치로 입출력의 위치를 변경시킨다.
		  raf.seek(0);   // 맨 앞으로 이동
		  System.out.printf("현재 입출력 위치 : %d 바이트 \n", raf.getFilePointer());
		  
		  // readInt 메소드의 호출을 통해서 두개의 정수를 읽어 들였으므로,
		  // 입출력 위치는 다시 8이 증가한다.
		  System.out.println(raf.readInt());
		  System.out.println(raf.readInt());
		  System.out.printf("현재 입출력 위치 : %d 바이트 \n", raf.getFilePointer());
		  raf.seek(8);   // 맨 앞으로 이동
		  System.out.println(raf.readDouble());
		  System.out.println(raf.readDouble());
		  System.out.printf("현재 입출력 위치 : %d 바이트 \n", raf.getFilePointer());
		  raf.close();


	}

}
