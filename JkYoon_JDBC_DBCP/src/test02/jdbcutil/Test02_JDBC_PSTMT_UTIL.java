package test02.jdbcutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import test02.util.DBUtil3;

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
public class Test02_JDBC_PSTMT_UTIL {
	
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;	// 일반적으로 데이터베이스에 쿼리 문을 실행함으로써 생성 된 데이터베이스 결과 세트를 나타내는 데이터의 테이블. 

	/**
	 * @method : selectData
	 * @parmam : 
	 * @return : void
	 * @description : PreparedStatement를 이용한 조회
	 */
	private void selectData() {
		 

		try {
			// 데이터베이스의 연결을 설정한다.
			conn = DBUtil3.getConnection();	// 특정 데이터베이스와의 연결 (세션). SQL.이 실행되고 결과는 연결 컨텍스트 내에서 리턴됩니다.


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
	private void insertData() {
		int resultInt = 0;

   
		try {
			// 데이터베이스의 연결을 설정한다.
			conn = DBUtil3.getConnection();	// 특정 데이터베이스와의 연결 (세션). SQL.이 실행되고 결과는 연결 컨텍스트 내에서 리턴됩니다.

			 
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
	private void updateData() {
 
		int resultInt = 0;

   
		try {
			// 데이터베이스의 연결을 설정한다.
			conn = DBUtil3.getConnection();	// 특정 데이터베이스와의 연결 (세션). SQL.이 실행되고 결과는 연결 컨텍스트 내에서 리턴됩니다.
			
			String boardTitle = "boardTitle";
			String boardWriter = "m1e";
			String boardId = "3";
			
			String query = "UPDATE FX_BOARD SET "
					+ "  BOARD_TITLE = ? "
					+ ", BOARD_WRITER = ? "
					+ "  WHERE BOARD_ID = ?  ";
			
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
	private void deleteData() {
		int resultInt = 0;

   
		try {
			// 데이터베이스의 연결을 설정한다.
			conn = DBUtil3.getConnection();	// 특정 데이터베이스와의 연결 (세션). SQL.이 실행되고 결과는 연결 컨텍스트 내에서 리턴됩니다.

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
	
	
	public static void main(String[] args) {
		
		Test02_JDBC_PSTMT_UTIL test02_JDBC_PSTMT_UTIL = new Test02_JDBC_PSTMT_UTIL();

		test02_JDBC_PSTMT_UTIL.selectData();
		test02_JDBC_PSTMT_UTIL.insertData();
		test02_JDBC_PSTMT_UTIL.updateData();
		test02_JDBC_PSTMT_UTIL.deleteData();
	 
		
		
	} // main()의 끝



}
