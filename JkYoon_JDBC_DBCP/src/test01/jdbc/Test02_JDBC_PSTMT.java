package test01.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @class : Test02_JDBC_PSTMT.java
 * @title : 
 * @author : Yoon
 * @desciption : JDBC PreparedStatement
 * JDBC PreparedStatement를 이용한 CRUD
 * 장점 : PreparedStatement함수를 사용하면 DBMS(오라클은 미리 SQL을 분석해놓는다 그래서 쿼리실행 속도가 빠르다.)
 * 
 * 
 * executeQuery or executeUpdate 의 속성을 보면 Statement  와 PreparedStatement를 알수있다.
 * 1.조회
 * 2.등록
 * 3.수정
 * 4.삭제
 */
public class Test02_JDBC_PSTMT {
	
	public static void main(String[] args) {
		
		

		selectData();
//		insertData();
//		updateData();
//		deleteData();
	 
		
		
	} // main()의 끝

	/**
	 * @method : selectData
	 * @parmam : 
	 * @return : void
	 * @description : PreparedStatement를 이용한 조회
	 */
	private static void selectData() {
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String DB_USER = "yoon";
		String DB_PASSWORD = "yoon";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 드라이버를 로딩한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			// 데이터베이스의 연결을 설정한다.
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);


			String query = "SELECT BOARD_ID "
					+ "		     , BOARD_TITLE	   "
					+ "		     , BOARD_WRITER    "
					+ "		FROM FX_BOARD          ";
			
			
			// PreparedStatement를 가져온다.
			pstmt = conn.prepareStatement(query);
			
			//pstmt.setString(1, "0000000001");

			// SQL문을 실행한다.
			rs = pstmt.executeQuery();

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
				// PreparedStatement를 닫는다.
				if(pstmt!=null){
					pstmt.close();
				}
				// Connection를 닫는다.
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
		
	}
	
	
	/**
	 * @method : insertData
	 * @parmam : 
	 * @return : void
	 * @description : PreparedStatement를 이용한 등록
	 */
	private static void insertData() {
		// 오라클에서 제공하는 JDBC 드라이버의 경우 아래와 같이 JDBC URL을 사용한다.
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String DB_USER = "yoon";
		String DB_PASSWORD = "yoon";

		Connection conn = null;
		PreparedStatement pstmt = null;
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
					+ ", ? "
					+ ", ? "
					+ ", SYSDATE"
					+ ", ? )";
			
			System.out.println(query);
			
			// connection객체의 PreparedStatement를 가져온다.
			pstmt = conn.prepareStatement(query);
			
			//파라미터세팅
			pstmt.setString(1,boardTitle);			// ? 
			pstmt.setString(2,boardWriter);
			pstmt.setString(3,boardContent);
			
			// 쿼리를 실행하여 결과값을 받는다.
			resultInt = pstmt.executeUpdate();
			
			System.out.println("resultInt = "+resultInt);
			
			 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Statement를 닫는다.
				if(pstmt!=null){
					pstmt.close();
				}
				// Connection를 닫는다.
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
		
	}
	
	

	/**
	 * @method : updateData
	 * @parmam : 
	 * @return : void
	 * @description : PreparedStatement를 이용한 수정
	 */
	private static void updateData() {

		// 오라클에서 제공하는 JDBC 드라이버의 경우 아래와 같이 JDBC URL을 사용한다.
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String DB_USER = "yoon";
		String DB_PASSWORD = "yoon";

		Connection conn = null;
		PreparedStatement pstmt = null;
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
			
			String boardTitle = "boardTitle";
			String boardWriter = "m1e";
			String boardId = "3";
			
			String query = "UPDATE FX_BOARD SET "
					+ "  BOARD_TITLE = ? "
					+ ", BOARD_WRITER = ? "
					+ "WHERE BOARD_ID = ?  ";
			
			// Statement를 가져온다.
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1 , boardTitle);
			pstmt.setString(2 , boardWriter);
			pstmt.setString(3 , boardId);

			
			
			System.out.println(query);
			
			
			// SQL문을 실행한다.
			resultInt = pstmt.executeUpdate();

			System.out.println("resultInt = "+resultInt);
			
			 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Statement를 닫는다.
				if(pstmt!=null){
					pstmt.close();
				}
				// Connection를 닫는다.
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
		
	}
	

	/**
	 * @method : delete
	 * @parmam : 
	 * @return : void
	 * @description : PreparedStatement를 이용한 삭제
	 */
	private static void deleteData() {
		// 오라클에서 제공하는 JDBC 드라이버의 경우 아래와 같이 JDBC URL을 사용한다.
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String DB_USER = "yoon";
		String DB_PASSWORD = "yoon";

		Connection conn = null;
		PreparedStatement pstmt = null;
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

			String boardId = "3";
			
			String query = "DELETE FROM  FX_BOARD "
					+ "WHERE BOARD_ID = ? ";
			
			
			// prepareStatement를 가져온다.
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, boardId);
			System.out.println(query);
			
			
			// SQL문을 실행한다.
			resultInt = pstmt.executeUpdate();

			System.out.println("resultInt = "+resultInt);
			
			 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Statement를 닫는다.
				if(pstmt!=null){
					pstmt.close();
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
