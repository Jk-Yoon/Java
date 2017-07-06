package inputoutput;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
 
/**
 * @class : Test03BufferedOutputStream.java
 * @title : BufferedInputStream
 * @author : Yoon
 * @desciption : BufferedOutputStream을 이용하여 파일쓰기
 */
public class Test03BufferedOutputStream {
	
	public static void main(String[] args) {
		// 날짜관련 객체
		Calendar calendar = Calendar.getInstance();	// 추상클래스이므로 직접객체를 생성할 수 없다.
		long startTimeMilli = calendar.getTimeInMillis();
		
		File file = new File("src/inputoutput/Test03BufferedOutputStream.txt");
		
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
		// 입출력의 성능 향상을 위해 Buffered 스트림을 이용한다.
		BufferedOutputStream bos = null;
		
		
		try {
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			String newline = "\r\n";
			String content1 = "44444444444";
			String content2 = "55555555555";
			String content3 = "66666666666";
			
			for(int i = 0 ; i < 30000; i++){
				bos.write(content1.getBytes());
				bos.write(newline.getBytes());
				bos.write(content2.getBytes());
				bos.write(newline.getBytes());
				bos.write(content3.getBytes());
			}
		 
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bos != null){ 
				try {
					bos.close();
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
