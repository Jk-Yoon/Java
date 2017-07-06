package application.member.dao;

import ibatis.config.SqlMapConfig;

import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @class : MemberDao.java
 * @title : 
 * @author : Yoon
 * @desciption : 회원 DAO
 */
public class MemberDao {
	

	SqlMapClient sqlMap = null;
	
	public MemberDao() {
		sqlMap = SqlMapConfig.getSqlMapInstance();
		
	}

}
