package application.member.dao;

import ibatis.config.SqlMapConfig;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import application.member.vo.MemberVO;

/**
 * @class : MemberDao.java
 * @title : 
 * @author : Yoon
 * @desciption : �ɹ� Dao
 */
public class MemberDao {

	SqlMapClient sqlMap = null;
	
	public MemberDao(){
		sqlMap = SqlMapConfig.getSqlMapInstance(); 
	}
	
			
	
	/**
	 * @method : selectListMember
	 * @parmam : 
	 * @return : List<MemberVO>
	 * @description : �����͸� ��ȸ�Ѵ�.
	 */
	public List<MemberVO> selectListMember(MemberVO memberVO) throws SQLException {
		// TODO Auto-generated method stub
		return sqlMap.queryForList("memberDao.selectListMember", memberVO);
	}

 
	/**
	 * @method : insertMember
	 * @parmam : 
	 * @return : int
	 * @description : �����͸� ����Ѵ�.
	 */
	public int insertMember(MemberVO memberVO) throws SQLException {
		// TODO Auto-generated method stub
		return sqlMap.update("memberDao.insertMember", memberVO);
	}

	/**
	 * @method : updateMember
	 * @parmam : 
	 * @return : int
	 * @description : �����͸� �����Ѵ�.
	 */
	public int updateMember(MemberVO memberVO) throws SQLException {
		// TODO Auto-generated method stub
		return sqlMap.update("memberDao.updateMember", memberVO);
	}


	/**
	 * @method : deleteMember
	 * @parmam : 
	 * @return : int
	 * @description : �����͸� �����Ѵ�.
	 */
	public int deleteMember(MemberVO memberVO) throws SQLException {
		// TODO Auto-generated method stub
		return sqlMap.update("memberDao.deleteMember", memberVO);
	}

}
