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
 * @desciption : 맴버 Dao
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
	 * @description : 데이터를 조회한다.
	 */
	public List<MemberVO> selectListMember(MemberVO memberVO) throws SQLException {
		// TODO Auto-generated method stub
		return sqlMap.queryForList("memberDao.selectListMember", memberVO);
	}

 
	/**
	 * @method : insertMember
	 * @parmam : 
	 * @return : int
	 * @description : 데이터를 등록한다.
	 */
	public int insertMember(MemberVO memberVO) throws SQLException {
		// TODO Auto-generated method stub
		return sqlMap.update("memberDao.insertMember", memberVO);
	}

	/**
	 * @method : updateMember
	 * @parmam : 
	 * @return : int
	 * @description : 데이터를 수정한다.
	 */
	public int updateMember(MemberVO memberVO) throws SQLException {
		// TODO Auto-generated method stub
		return sqlMap.update("memberDao.updateMember", memberVO);
	}


	/**
	 * @method : deleteMember
	 * @parmam : 
	 * @return : int
	 * @description : 데이터를 삭제한다.
	 */
	public int deleteMember(MemberVO memberVO) throws SQLException {
		// TODO Auto-generated method stub
		return sqlMap.update("memberDao.deleteMember", memberVO);
	}

}
