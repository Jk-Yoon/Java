package application.member.service;

import java.sql.SQLException;
import java.util.List;

import application.member.vo.MemberVO;


/**
 * @class : MemberService.java
 * @title : 
 * @author : Yoon
 * @desciption : 맴버 인터페이스
 */
public interface MemberService {
	
	/**
	 * @class : MemberService.java
	 * @title : 
	 * @author : Yoon
	 * @desciption : 데이터를 조회한다.
	 */
	public List<MemberVO> selectListMember(MemberVO memberVO) throws SQLException;

	 
	/**
	 * @method : insertMember
	 * @parmam : 
	 * @return : int
	 * @description : 데이터를 등록한다.
	 */
	public int insertMember(MemberVO memberVO) throws SQLException;
	
	
	
	/**
	 * @method : updateMember
	 * @parmam : 
	 * @return : int
	 * @description : 데이터를 수정한다.
	 */
	public int updateMember(MemberVO memberVO) throws SQLException;

	/**
	 * @return 
	 * @method : deleteMember
	 * @parmam : 
	 * @return : void
	 * @throws SQLException 
	 * @description : 데이터를 삭제한다.
	 */
	public int deleteMember(MemberVO memberVO) throws SQLException;
}
