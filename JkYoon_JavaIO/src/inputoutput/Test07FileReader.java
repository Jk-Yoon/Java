package inputoutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @class : Test07FileReader.java
 * @title : FileReader를 이용하여 파일 읽기
 * @author : Yoon
 * @desciption : FileReader클래스를 이용하여 파일 만들기
 */
public class Test07FileReader {
	public static void main(String[] args) {
		File file = new File("src/inputoutput/Test06FileWriter.txt");
		
		FileReader fr = null;
		
		try {
			fr = new FileReader(file);
			char[] tmp = new char[2];
			
			int size = 0;
			int totalSize = 0;	// 전체사이즈
		 
			// int read(char[] b) -- > 배열b의 크기만큼 읽어서 배열을 채우고 읽어 온 데이터의 수를 반환한다.
			while( fr.read(tmp)> 0){	// 
				size = fr.read();
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
