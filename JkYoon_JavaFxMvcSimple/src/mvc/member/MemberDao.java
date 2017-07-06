package mvc.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/*
	실제 DB와 연결해서 SQL문을 수행하여 결과를 작성하여 Service에 전달하는 역할을 수행한다.
*/
public class MemberDao {
	// MemberVO에 담겨진 자료를 DB에 insert하는 메서드
	
	private static MemberDao md;
	
	private MemberDao(){
		
	}
	
	public static MemberDao getInstance(){
		if(md == null){
			md = new MemberDao();
		}
		return md;
	}
	
	public int insertMember(MemberVO mv){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "insert into mymember(mem_id, mem_name, mem_tel, mem_addr) values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getMem_id());
			pstmt.setString(2, mv.getMem_name());
			pstmt.setString(3, mv.getMem_tel());
			pstmt.setString(4, mv.getMem_addr());
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			cnt = -1;
			e.printStackTrace();
		} finally{
			if(pstmt != null) try{pstmt.close();}catch(SQLException e2){}
			if(conn != null) try{conn.close();}catch(SQLException e2){}
		}
		
		return cnt;
	}
	// 회원ID를 이용하여 회원 정보를 삭제하는 메서드
	public int deleteMember(String mem_id) {
		Connection conn = null;
		Statement stmt = null;
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			stmt = conn.createStatement();
			String sql = "delete from mymember where mem_id = '" + mem_id + "'";
			cnt = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			cnt = -1;
			e.printStackTrace();
		}finally{
			if(stmt != null) try{stmt.close();}catch(SQLException e2){}
			if(conn != null) try{conn.close();}catch(SQLException e2){}
		}
		return cnt;
	}
	
	//MemberVO의 정보를 이용하여 회원정보를 수정하는 메서드
	public int updateMember(MemberVO mv) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			pstmt = conn.prepareStatement(
						"update mymember set mem_name = ?, mem_tel = ? , mem_addr = ? where mem_id = ?"
					);
			pstmt.setString(1, mv.getMem_name());
			pstmt.setString(2, mv.getMem_tel());
			pstmt.setString(3, mv.getMem_addr());
			pstmt.setString(4, mv.getMem_id());
			
			cnt = pstmt.executeUpdate();
			

		} catch (SQLException e) {
			cnt = -1;
			e.printStackTrace();
		}finally{
			if(pstmt != null) try{pstmt.close();}catch(SQLException e2){}
			if(conn != null) try{conn.close();}catch(SQLException e2){}
		}
		return cnt;
	}

	public int displayMember() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from mymember";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				String memId = rs.getString("mem_id");
				String memName = rs.getString("mem_name");
				String memTel = rs.getString("mem_tel");
				String memAddr = rs.getString("mem_addr");
				System.out.println(memId + "	" + memName +"	" + memTel + "	" + memAddr);
				System.out.println();
			}
		} catch (SQLException e) {
			cnt = -1;
		}finally{			
			if(rs != null) try{rs.close();}catch(SQLException e2){}
			if(stmt != null) try{stmt.close();}catch(SQLException e2){}
			if(conn != null) try{conn.close();}catch(SQLException e2){}
		}
	
		return cnt;
	}
	
	//mymember테이블의 전체 레코드를 가져와서 
	//각각의 레코드틑 MemberVO에 담고, 이 MemberVO를 다시 
	//List에 담아서 반환하는 레코드
	public List<MemberVO> getAllMemberList(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<MemberVO> memList = new ArrayList<MemberVO>();
		
		try {
			conn = DBUtil3.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from mymember";
			
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				// 각각의 레코드 정보를 MemberVO에 넣은 후 이 MemberVO를 ArrayList에 추가한다.
				MemberVO mv = new MemberVO();
				mv.setMem_id(rs.getString("mem_id"));
				mv.setMem_name(rs.getString("mem_name"));
				mv.setMem_tel(rs.getString("mem_tel"));
				mv.setMem_addr(rs.getString("mem_addr"));
				memList.add(mv);
			}
			
			
		} catch (SQLException e) {
			memList = null;
			e.printStackTrace();
		} finally {
			if(rs != null) try{rs.close();}catch(SQLException e2){}
			if(stmt != null) try{stmt.close();}catch(SQLException e2){}
			if(conn != null) try{conn.close();}catch(SQLException e2){}
		}
		
		return memList;
	}
	
	// 회원 정보 검색하는 메서드
	// 회원ID, 회원이름, 회원주소 정보를 구분해서 검색을 실시한다.
	
//	public List<MemberVO> dataSearch(int subChoice, String input) {
	public List<MemberVO> dataSearch(String input, String fieldname) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<MemberVO> memList = new ArrayList<MemberVO>();
		
		try {
			conn = DBUtil3.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from mymember where " + fieldname + " like '" + input + "' ";
			rs = stmt.executeQuery(sql);
//			switch (subChoice) {		
//			case 1:
////				sql = "select * from mymember where mem_id = '" + input + "'";
////				rs = stmt.executeQuery(sql);
//				break;
//				
//			case 2:
////				sql = "select * from mymember where mem_name = '" + input + "'";
////				rs = stmt.executeQuery(sql);
//				break;
//			case 3:
////				sql = "select * from mymember where mem_addr like '" + input + "%'";
//				rs = stmt.executeQuery(sql);
//				break;
//
//			default:
//				break;
//			}
			
			while(rs.next()){
				MemberVO mv = new MemberVO();
				mv.setMem_id(rs.getString("mem_id"));
				mv.setMem_name(rs.getString("mem_name"));
				mv.setMem_tel(rs.getString("mem_tel"));
				mv.setMem_addr(rs.getString("mem_addr"));
				memList.add(mv);
			}
			
		} catch (SQLException e) {
			memList = null;
			e.printStackTrace();
		} finally {
			if(rs != null) try{rs.close();}catch(SQLException e2){}
			if(stmt != null) try{stmt.close();}catch(SQLException e2){}
			if(conn != null) try{conn.close();}catch(SQLException e2){}
		}
		

		return memList;
	}
	
	
	
	
	
	
	
	
	
}
















