package test02.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/*
	db.properties의 내용으로 설정하는 방법1
	
	방법 1) Properties객체 이용하기
*/
public class DBUtil2 {
	// static 초기화 블럭에서 jdbc드라이버 로딩을 구성한다.
		static Properties prop; //Properties객체변수 선언
		
		static{
			prop = new Properties();	//객체생성
			File f = new File("res/db.properties");
			try {
				FileInputStream fin = new FileInputStream(f);
				prop.load(fin);
//					Class.forName("oracle.jdbc.driver.OracleDriver");
				Class.forName(prop.getProperty("driver"));
			} catch (ClassNotFoundException e) {
				System.out.println("드라이버 로딩 실패!!");
				e.printStackTrace();
			} catch(FileNotFoundException e){
				System.out.println("파일이 없습니다.");
				e.printStackTrace();
			} catch(IOException e){
				System.out.println("입출력 오류입니다.");
				e.printStackTrace();
			}
		}
			
		// Connection객체를 구성하는 메서드
		public static Connection getConnection(){
			try {
//					return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","pc05","java");
				return DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("pass"));
				
			} catch (SQLException e) {
				System.out.println("오라클 연결 실패!");
				return null;
			}
		}
}
