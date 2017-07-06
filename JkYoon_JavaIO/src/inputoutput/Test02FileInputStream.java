package inputoutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @class : Test02FileInputStream
 * @title :  FileInputStream 이용
 * @author : Yoon
 * @desciption : FileInputStream을 이용하여 파일 읽어오기
 */
public class Test02FileInputStream {
	
	
	public static void main(String[] args) {
		File file = new File("src/inputoutput/Test01FileOutputStream.txt");
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			byte[] tmp = new byte[2];
			
			int size = 0;
			int totalSize = 0;	// 전체사이즈
		 
			// int read(byte[] b) -- > 배열b의 크기만큼 읽어서 배열을 채우고 읽어 온 데이터의 수를 반환한다.
			while( fis.read(tmp)> 0){	// 
				size = fis.read();
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
