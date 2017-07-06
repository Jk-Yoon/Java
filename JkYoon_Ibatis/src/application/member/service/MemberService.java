package application.member.service;

import java.sql.SQLException;
import java.util.List;

import application.member.vo.MemberVO;


/**
 * @class : MemberService.java
 * @title : 
 * @author : Yoon
 * @desciption : �ɹ� �������̽�
 */
public interface MemberService {
	
	/**
	 * @class : MemberService.java
	 * @title : 
	 * @author : Yoon
	 * @desciption : �����͸� ��ȸ�Ѵ�.
	 */
	public List<MemberVO> selectListMember(MemberVO memberVO) throws SQLException;

	 
	/**
	 * @method : insertMember
	 * @parmam : 
	 * @return : int
	 * @description : �����͸� ����Ѵ�.
	 */
	public int insertMember(MemberVO memberVO) throws SQLException;
	
	
	
	/**
	 * @method : updateMember
	 * @parmam : 
	 * @return : int
	 * @description : �����͸� �����Ѵ�.
	 */
	public int updateMember(MemberVO memberVO) throws SQLException;

	/**
	 * @return 
	 * @method : deleteMember
	 * @parmam : 
	 * @return : void
	 * @throws SQLException 
	 * @description : �����͸� �����Ѵ�.
	 */
	public int deleteMember(MemberVO memberVO) throws SQLException;
}
