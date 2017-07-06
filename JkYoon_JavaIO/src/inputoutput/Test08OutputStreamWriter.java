package inputoutput;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Calendar;

/**
 * @class : Test08OutputStreamWriter.java
 * @title : OutputStreamWriter
 * @author : Yoon
 * @desciption : OutputStreamWriter클래스를 이용하여 파일만들기
 */
public class Test08OutputStreamWriter {
	
	
	public static void main(String[] args) {

		// 날짜관련 객체
		Calendar calendar = Calendar.getInstance();	// 추상클래스이므로 직접객체를 생성할 수 없다.
		long startTimeMilli = calendar.getTimeInMillis();
		
		File file = new File("src/inputoutput/Test08OutputStreamWriter.txt");
		
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
		// BufferedOutputStream 이용하기
		OutputStreamWriter osw = null;
		
		
		try {
			fos = new FileOutputStream(file);
			osw = new OutputStreamWriter(fos);
			String newline = "\r\n";
			String content1 = "한글";
			String content2 = "55555555555";
			String content3 = "66666666666";
			
			for(int i = 0 ; i < 30000; i++){
				osw.write(content1);
				osw.write(newline);
				osw.write(content2);
				osw.write(newline);
				osw.write(content3);
			}
		 
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(osw != null){ 
				try {
					osw.close();
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
