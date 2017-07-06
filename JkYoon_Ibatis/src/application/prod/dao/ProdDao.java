package application.prod.dao;

import ibatis.config.SqlMapConfig;

import java.sql.SQLException;
import java.util.List;

import application.prod.vo.ProdVO;

import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @class : ProdDao.java
 * @title : 
 * @author : Yoon
 * @desciption : 상품 Dao
 */
public class ProdDao {
	
	SqlMapClient sqlMap = null;
	
	public ProdDao() {
		sqlMap = SqlMapConfig.getSqlMapInstance(); 
	}
	

	/**
	 * @method : selectListProd
	 * @parmam : 
	 * @return : List<ProdVO>
	 * @description : 데이터를 조회한다.
	 */
	public List<ProdVO> selectListProd(ProdVO prodVO) throws SQLException {
		// TODO Auto-generated method stub
		return sqlMap.queryForList("prodDao.selectListProd", prodVO);
	}

 
	/**
	 * @method : insertProd
	 * @parmam : 
	 * @return : int
	 * @description : 데이터를 등록한다.
	 */
	public int insertProd(ProdVO prodVO) throws SQLException {
		// TODO Auto-generated method stub
		return sqlMap.update("prodDao.insertProd", prodVO);
	}

	/**
	 * @method : updateProd
	 * @parmam : 
	 * @return : int
	 * @description : 데이터를 수정한다.
	 */
	public int updateProd(ProdVO prodVO) throws SQLException {
		// TODO Auto-generated method stub
		return sqlMap.update("prodDao.updateProd", prodVO);
	}


	/**
	 * @method : deleteProd
	 * @parmam : 
	 * @return : int
	 * @description : 데이터를 삭제한다.
	 */
	public int deleteProd(ProdVO prodVO) throws SQLException {
		// TODO Auto-generated method stub
		return sqlMap.update("prodDao.deleteProd", prodVO);
	}
	
	

}
