package inputoutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

/**
 * @class : Test01FileOutputStream
 * @title : FileOutputStream 이용
 * @author : Yoon
 * @desciption : FileOutputStream을 이용하여 파일만들기.
 */
public class Test01FileOutputStream {
	public static void main(String[] args) {
		
		// 날짜관련 객체
		Calendar calendar = Calendar.getInstance();	// 추상클래스이므로 직접객체를 생성할 수 없다.
		long startTimeMilli = calendar.getTimeInMillis();
		
		File file = new File("src/inputoutput/Test01FileOutputStream.txt");
		
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
		
		
		try {
			fos = new FileOutputStream(file);
			String newline = "\r\n";
			String content1 = "1111111111111111";
			String content2 = "2222222222222222";
			String content3 = "뷁똵꿗";
			
			for(int i = 0 ; i < 30000; i++){
				fos.write(content1.getBytes());
				fos.write(newline.getBytes());
				fos.write(content2.getBytes());
				fos.write(newline.getBytes());
				fos.write(content3.getBytes());
			}
		 
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fos != null){ 
				try {
					fos.close();
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
