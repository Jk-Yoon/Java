package inputoutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

/**
 * @class : Test10BufferedReader.java
 * @title : BufferedReader
 * @author : Yoon
 * @desciption : BufferedReader를 이용한 파일 읽기
 */
public class Test11BufferedReader {
	public static void main(String[] args) {

		Calendar calendar = Calendar.getInstance();
		long startTimeMilli = calendar.getTimeInMillis();
		
		

		File file = new File("src/inputoutput/Test10BufferedWriter.txt");
		
		FileInputStream fis = null;
		InputStreamReader bis = null;
		BufferedReader br = null;
		try {
			fis = new FileInputStream(file);
			bis = new InputStreamReader(fis);
			br = new BufferedReader(bis,2);
			char[] tmp = new char[2];
			
			int size = 0;
			int totalSize = 0;	// 전체사이즈
		 
			// int read(byte[] b) -- > 배열b의 크기만큼 읽어서 배열을 채우고 읽어 온 데이터의 수를 반환한다.
//			while( br.read(tmp)> 0){	// 
//				size = br.read();
//				String str = new String(tmp);
//				System.out.println(str);
//				totalSize += size;
//			}
		 
			System.out.println("totalSize = " + totalSize);
		
			// 또는 아래와 같이해도 된다.
			String line = null;
			while((line=br.readLine())!=null){
				totalSize += size;
				size = br.read();
				System.out.println(line);
			}
			 
			
			System.out.println("totalSize = " + totalSize);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Calendar calendar2 = Calendar.getInstance();
		long endTimeMilli = calendar2.getTimeInMillis();
		
		System.out.println(endTimeMilli - startTimeMilli);
		
		
	
		
	
	}
}
