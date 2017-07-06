package inputoutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @class : Test08InputStreamReader.java
 * @title : Test08InputStreamReader
 * @author : Yoon
 * @desciption : InputStreamReader클래스를 이용하여 파일 읽기
 */
public class Test09InputStreamReader {

	public static void main(String[] args) {
		

		File file = new File("src/inputoutput/Test08OutputStreamWriter.txt");
		
		FileInputStream fis = null;
		InputStreamReader bis = null;
		
		try {
			fis = new FileInputStream(file);
			/*
			InputStreamReader객체는 파일의 인코딩 방식을 지정할 수 있다.
			MS949 ==> 윈도우의 기본 한글 인코딩 방식(ANSI)
			UTF-8 ==> 유니코드 UTF-8 인코딩 방식
			US-ASCII ==> 영문 전용 인코딩 방식
			
			*/
			bis = new InputStreamReader(fis, "MS949");
			char[] tmp = new char[2];
			
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
