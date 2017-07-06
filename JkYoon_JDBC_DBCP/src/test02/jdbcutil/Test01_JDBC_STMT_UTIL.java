package test02.jdbcutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import test02.util.DBUtil3;

/**
 * @class : Test01_JDBC_STMT.java
 * @title : 
 * @author : Yoon
 * @desciption : JDBC Statment
 * DBUtil3이용하여 JDBC Statment를 이용한 CRUD
 * 1.조회
 * 2.등록
 * 3.수정
 * 4.삭제
 */
public class Test01_JDBC_STMT_UTIL {
	Connection conn = null;	// 특정 데이터베이스와의 연결 (세션). SQL.이 실행되고 결과는 연결 컨텍스트 내에서 리턴됩니다.
	Statement stmt = null;	// 정적 SQL 문을 실행하고 생성 된 결과를 리턴하는 데 사용되는 오브젝트.
	ResultSet rs = null;	// 일반적으로 데이터베이스에 쿼리 문을 실행함으로써 생성 된 데이터베이스 결과 세트를 나타내는 데이터의 테이블. 
		
	 

	/**
	 * @method : selectData
	 * @parmam : 
	 * @return : void
	 * @description : 데이터를 조회한다.
	 */
	private void selectData() {
 
		String query = "SELECT BOARD_ID "
				+ "		     , BOARD_TITLE	   "
				+ "		     , BOARD_WRITER    "
				+ "		FROM FX_BOARD          ";
		System.out.println(query);

		try {
			
			conn = DBUtil3.getConnection();	// 특정 데이터베이스와의 연결 (세션). SQL.이 실행되고 결과는 연결 컨텍스트 내에서 리턴됩니다.
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
	
	
	
	private void insertData() {
		int resultInt = 0;

   
		try {
			conn = DBUtil3.getConnection();	// 특정 데이터베이스와의 연결 (세션). SQL.이 실행되고 결과는 연결 컨텍스트 내에서 리턴됩니다.
			
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
	
	

	
	
	/**
	 * @method : updateData
	 * @parmam : 
	 * @return : void
	 * @description : 데이터 수정
	 */
	private void updateData() {
		int resultInt = 0;

		try {
			conn = DBUtil3.getConnection();	// 특정 데이터베이스와의 연결 (세션). SQL.이 실행되고 결과는 연결 컨텍스트 내에서 리턴됩니다.

			
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

	
	/**
	 * @method : delete
	 * @parmam : 
	 * @return : void
	 * @description : 데이터 삭제 
	 */
	private void deleteData() {
		
		int resultInt = 0;

  
	 
		try {
			conn = DBUtil3.getConnection();	// 특정 데이터베이스와의 연결 (세션). SQL.이 실행되고 결과는 연결 컨텍스트 내에서 리턴됩니다.

			
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
	
	


	public static void main(String[] args) {

		Test01_JDBC_STMT_UTIL test01_JDBC_STMT_UTIL = new Test01_JDBC_STMT_UTIL();
//		test01_JDBC_STMT_UTIL.selectData();
//		test01_JDBC_STMT_UTIL.insertData();
		test01_JDBC_STMT_UTIL.updateData();
		test01_JDBC_STMT_UTIL.deleteData();
	 
		
	}


	
	

}
