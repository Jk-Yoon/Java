package inputoutput;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
 
/**
 * @title : BufferedOutputStream의 중요성
 * @author : Yoon
 * @description :  
 * bos.close(); BufferedOutputStream의 close()를 호출해 주어야 버퍼에 남아있던 모든 내용이 출력된다.
 * 
 */
public class BufferedOutputStreamEx1 {
	public static void main(String args[]) {
		try {
			
		     FileOutputStream fos = new FileOutputStream("1111.txt");
		 
		     // BufferedOutputStream의 버퍼 크기를 5로 한다.
		     BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
		     // 파일 123.txt에  1 부터 9까지 출력한다.
		     for(int i='1'; i <= '9'; i++) {
		    	 System.out.println(i);
			     bos.write(i);
			    
		     }
		     // bos.close(); BufferedOutputStream의 close()를 호출해 주어야 버퍼에 남아있던 모든 내용이 출력된다.
		     fos.close();
		    
		} catch (IOException e) {
		     e.printStackTrace();		
		}
	}
}
