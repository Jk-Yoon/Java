package mvc.member;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
/*
	db.properties의 내용으로 설정하는 방법1
	
	방법 1) ResourceBundle객체 이용하기
*/
public class DBUtil3 {
	// static 초기화 블럭에서 jdbc드라이버 로딩을 구성한다.
		static ResourceBundle bundle; //ResourceBundle객체변수 선언
			static{
				bundle = ResourceBundle.getBundle("db");		//객체생성
				File f = new File("res/db.properties");
				try {
//					Class.forName("oracle.jdbc.driver.OracleDriver");
					Class.forName(bundle.getString("driver"));
				} catch (ClassNotFoundException e) {
					System.out.println("드라이버 로딩 실패!!");
					e.printStackTrace();
				}
			}
			
			// Connection객체를 구성하는 메서드
			public static Connection getConnection(){
				try {
//					return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","pc05","java");
					return DriverManager.getConnection(bundle.getString("url"),bundle.getString("user"),bundle.getString("pass"));
					
				} catch (SQLException e) {
					System.out.println("오라클 연결 실패!");
					return null;
				}
			}
}
