package inputoutput;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Calendar;

/**
 * @class : Test09BufferedWriter.java
 * @title : BufferedWriter
 * @author : Yoon
 * @desciption : BufferedWriter클래스를 이용하여 파일쓰기
 */
public class Test10BufferedWriter {

	public static void main(String[] args) {

		// 날짜관련 객체
		Calendar calendar = Calendar.getInstance();	// 추상클래스이므로 직접객체를 생성할 수 없다.
		long startTimeMilli = calendar.getTimeInMillis();
		
		File file = new File("src/inputoutput/Test10BufferedWriter.txt");
		
		// 파일이 존재하는 체크
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		// BufferedWriter 이용하기
		BufferedWriter bw = null;
		
		
		try {
			
			// FileOutputStream - > OutputStreamWriter - > BufferedWriter
			fos = new FileOutputStream(file);
			osw = new OutputStreamWriter(fos);
			bw = new BufferedWriter(osw);
			
			String newline = "\r\n";
			String content1 = "한글2222222222";
			String content2 = "55555555555";
			String content3 = "66666666666";
			
			for(int i = 0 ; i < 30000; i++){
				//char[], int, String
				bw.write(content1);
				bw.write(newline);
				bw.write(content2);
				bw.write(newline);
				bw.write(content3);
			}
		 
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bw != null){ 
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		Calendar calendar1 = Calendar.getInstance();	// 추상클래스이므로 직접객체를 생성할 수 없다.
		long endTimeMilli = calendar1.getTimeInMillis();
		
		long totalTime = endTimeMilli-startTimeMilli;
		System.out.println("totalTime = "+String.valueOf(totalTime));

	
		
	}

}
