package test02.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// JDBC드라이버를 로딩하고 Connection객체를 생성하는 메서드로 구성된 class이다.

public class DBUtil {
	// static 초기화 블럭에서 jdbc드라이버 로딩을 구성한다.
		static{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				System.out.println("드라이버 로딩 실패!!");
				e.printStackTrace();
			}
		}
		
		// Connection객체를 구성하는 메서드
		public static Connection getConnection(){
			try {
				return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","yoon","yoon");
						
			} catch (SQLException e) {
				System.out.println("오라클 연결 실패!");
				return null;
			}
		}

}
