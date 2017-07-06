package test01.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @class : Test01_JDBC_STMT.java
 * @title : 
 * @author : Yoon
 * @desciption : JDBC Statment
 * JDBC Statment를 이용한 CRUD
 * 1.조회
 * 2.등록
 * 3.수정
 * 4.삭제
 */
public class Test01_JDBC_STMT {
	
	
	
	public static void main(String[] args) {

		selectData();
//		insertData();
//		updateData();
//		delete();
	 
		
	}





	/**
	 * @method : selectData
	 * @parmam : 
	 * @return : void
	 * @description : 데이터를 조회한다.
	 */
	private static void selectData() {
		// 오라클에서 제공하는 JDBC 드라이버의 경우 아래와 같이 JDBC URL을 사용한다.
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String DB_USER = "yoon";
		String DB_PASSWORD = "yoon";

		Connection conn = null;	// 특정 데이터베이스와의 연결 (세션). SQL.이 실행되고 결과는 연결 컨텍스트 내에서 리턴됩니다.
		Statement stmt = null;	// 정적 SQL 문을 실행하고 생성 된 결과를 리턴하는 데 사용되는 오브젝트.
		ResultSet rs = null;	// 일반적으로 데이터베이스에 쿼리 문을 실행함으로써 생성 된 데이터베이스 결과 세트를 나타내는 데이터의 테이블. 


		String query = "SELECT BOARD_ID "
				+ "		     , BOARD_TITLE	   "
				+ "		     , BOARD_WRITER    "
				+ "		FROM FX_BOARD          ";
		System.out.println(query);
		try {
			// 드라이버를 로딩한다. ojdbc.jar파일에 정보가 있다
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			// 데이터베이스의 연결을 설정한다.
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

			// Statement를 가져온다.
			stmt = conn.createStatement();
		 

			// SQL문을 실행한다.
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				String test_id = rs.getString("BOARD_ID");
				String test_name = rs.getString(2);
				String test_date = rs.getString(3);
				// 결과를 출력한다.
				System.out.println(test_id + " : " + test_name + " : " + test_date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// ResultSet를 닫는다.
				if(rs!=null){
					rs.close();
				}
				// Statement를 닫는다.
				if(stmt!=null){
					stmt.close();
				}
				// Connection를 닫는다.
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
		
	}
	
	
	
	private static void insertData() {
		// 오라클에서 제공하는 JDBC 드라이버의 경우 아래와 같이 JDBC URL을 사용한다.
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String DB_USER = "yoon";
		String DB_PASSWORD = "yoon";

		Connection conn = null;
		Statement stmt = null;
		int resultInt = 0;

  
		try {
			// 드라이버를 로딩한다. ojdbc.jar파일에 정보가 있다
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			// 데이터베이스의 연결을 설정한다.
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

			
			// Statement를 가져온다.
			stmt = conn.createStatement();

			String boardTitle = "boardTitle";
			String boardWriter = "me";
			String boardContent = "boardContent";
			
			String query = "INSERT INTO FX_BOARD "
					+ "("
					+ "	 BOARD_ID"
					+ ", BOARD_TITLE"
					+ ", BOARD_WRITER"
					+ ", BOARD_DATE"
					+ ", BOARD_CONTENT"
					+ ") "
					+ "VALUES "
					+ "((SELECT NVL(MAX(BOARD_ID),0)+1 FROM FX_BOARD)"
					+ ", '"+ boardTitle+"'"
					+ ", '"+ boardWriter+"'"
					+ ", SYSDATE"
					+ ", '"+ boardContent+ "' )";
			
			System.out.println(query);
			
			
			// SQL문을 실행한다.
			resultInt = stmt.executeUpdate(query);

			System.out.println("resultInt = "+resultInt);
			
			 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Statement를 닫는다.
				if(stmt!=null){
					stmt.close();
				}
				// Connection를 닫는다.
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
		
	}
	
	

	
	
	private static void updateData() {
		// 오라클에서 제공하는 JDBC 드라이버의 경우 아래와 같이 JDBC URL을 사용한다.
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String DB_USER = "yoon";
		String DB_PASSWORD = "yoon";

		Connection conn = null;
		Statement stmt = null;
		int resultInt = 0;

  
		try {
			// 드라이버를 로딩한다. ojdbc.jar파일에 정보가 있다
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			// 데이터베이스의 연결을 설정한다.
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

			
			// Statement를 가져온다.
			stmt = conn.createStatement();

			String boardTitle = "boardTitle";
			String boardWriter = "m1e";
			
			String query = "UPDATE FX_BOARD SET "
					+ "  BOARD_TITLE = '" + boardTitle + "'"
					+ ", BOARD_WRITER = '" + boardWriter + "' "
					+ "WHERE BOARD_ID = '3' ";
			
			System.out.println(query);
			
			
			// SQL문을 실행한다.
			resultInt = stmt.executeUpdate(query);

			System.out.println("resultInt = "+resultInt);
			
			 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Statement를 닫는다.
				if(stmt!=null){
					stmt.close();
				}
				// Connection를 닫는다.
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
		
	}

	
	private static void delete() {
		// 오라클에서 제공하는 JDBC 드라이버의 경우 아래와 같이 JDBC URL을 사용한다.
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String DB_USER = "yoon";
		String DB_PASSWORD = "yoon";

		Connection conn = null;
		Statement stmt = null;
		int resultInt = 0;

  
		try {
			// 드라이버를 로딩한다. ojdbc.jar파일에 정보가 있다
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			// 데이터베이스의 연결을 설정한다.
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

			
			// Statement를 가져온다.
			stmt = conn.createStatement();

			String boardId = "3";
			
			String query = "DELETE FROM  FX_BOARD "
					+ "WHERE BOARD_ID = '"+boardId+"' ";
			
			System.out.println(query);
			
			
			// SQL문을 실행한다.
			resultInt = stmt.executeUpdate(query);

			System.out.println("resultInt = "+resultInt);
			
			 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Statement를 닫는다.
				if(stmt!=null){
					stmt.close();
				}
				// Connection를 닫는다.
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
		
	}
	
	//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ 이건 몰라두되겠다. ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	static Connection conn = null;
	static Statement stmt = null;

	private static void commonConnection() {
		try {
			// 드라이버를 로딩한다. ojdbc.jar파일에 정보가 있다
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			// 데이터베이스의 연결을 설정한다.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "yoon", "yoon");
			stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}  
		
	}


	private static void selectDataCommon() {
		//커넥션
		commonConnection();
		
		ResultSet rs = null;
		String query = "SELECT BOARD_ID "
				+ "		     , BOARD_TITLE	   "
				+ "		     , BOARD_WRITER    "
				+ "		FROM FX_BOARD          ";
		System.out.println(query);
		
		// SQL문을 실행한다.
		try {
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				String test_id = rs.getString(1);
				String test_name = rs.getString(2);
				String test_date = rs.getString(3);
				// 결과를 출력한다.
				System.out.println(test_id + " : " + test_name + " : " + test_date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// ResultSet를 닫는다.
				if(rs!=null){
					rs.close();
				}
				// Statement를 닫는다.
				if(stmt!=null){
					stmt.close();
				}
				// Connection를 닫는다.
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
			}
		} 
	}



	
	

}
