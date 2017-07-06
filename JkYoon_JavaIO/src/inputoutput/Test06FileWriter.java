package inputoutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

/**
 * @class : Test06FileWriter.java
 * @title : FileWriter
 * @author : Yoon
 * @desciption : FileWriter클래스를 이용하여 파일 만들기
 */
public class Test06FileWriter {
	
	public static void main(String[] args) {
		
		// 날짜관련 객체
		Calendar calendar = Calendar.getInstance();	// 추상클래스이므로 직접객체를 생성할 수 없다.
		long startTimeMilli = calendar.getTimeInMillis();
		
		File file = new File("src/inputoutput/Test06FileWriter.txt");
		
		// 파일이 존재하는 체크
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		FileWriter fw = null;
		
		
		try {
			fw = new FileWriter(file);
			String newline = "\r\n";
			String content1 = "555555555555555";
			String content2 = "666666666666666";
			String content3 = "777777777777777";
			
			for(int i = 0 ; i < 30000; i++){
				fw.write(content1);
				fw.write(newline);
				fw.write(content2);
				fw.write(newline);
				fw.write(content3);
			}
		 
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fw != null){ 
				try {
					fw.close();
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
