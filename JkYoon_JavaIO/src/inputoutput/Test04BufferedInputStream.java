package inputoutput;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @class : Test03BufferedOutputStream.java
 * @title : BufferedInputStream 
 * @author : Yoon
 * @desciption : BufferedInputStream을 이용하여 파일 읽기
 */
public class Test04BufferedInputStream {
	
	public static void main(String[] args) {
		File file = new File("src/inputoutput/Test03BufferedOutputStream.txt");
		
		FileInputStream fis = null;
		// 입출력의 성능 향상을 위해 Buffered 스트림을 이용한다.
		BufferedInputStream bis = null;
		
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			byte[] tmp = new byte[2];
			
			int size = 0;
			int totalSize = 0;	// 전체사이즈
		 
			// int read(byte[] b) -- > 배열b의 크기만큼 읽어서 배열을 채우고 읽어 온 데이터의 수를 반환한다.
			while( bis.read(tmp)> 0){	// 
				size = bis.read();
				String str = new String(tmp);
				System.out.println(str);
				totalSize += size;
				
			}
			
		 
			System.out.println("totalSize = " + totalSize);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
