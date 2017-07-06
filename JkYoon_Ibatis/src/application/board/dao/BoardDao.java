package application.board.dao;

import ibatis.config.SqlMapConfig;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.board.vo.BoardVO;

import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @class : BoardDAO.java
 * @title : 
 * @author : Yoon
 * @desciption : �Խ��� DAO
 */
public class BoardDao {
	
	SqlMapClient sqlMap = null;
	
	// �̱��� ���
	public BoardDao() {
		sqlMap = SqlMapConfig.getSqlMapInstance();
		
	}

	/**
	 * @method : selectListBoard
	 * @parmam : 
	 * @return : List<BoardVO>
	 * @throws SQLException 
	 * @description : �����͸� ��ȸ�Ѵ�.
	 */
	public List<BoardVO> selectListBoard(BoardVO boardVO) throws SQLException {
		
		
		return sqlMap.queryForList("boardDao.selectListBoard", boardVO);
	}

	 
	
	/**
	 * @method : insertBoard
	 * @parmam : 
	 * @return : int
	 * @description : �����͸� ����Ѵ�.
	 */
	public int insertBoard(BoardVO boardVO) throws SQLException {
		
	 
		 return sqlMap.update("boardDao.insertBoard", boardVO);
	}
	
	
	
	/**
	 * @method : updateBoard
	 * @parmam : 
	 * @return : int
	 * @description : �����͸� �����Ѵ�.
	 */
	public int updateBoard(BoardVO boardVO) throws SQLException {
		
		return (int) sqlMap.update("boardDao.updateBoard", boardVO);
	}

	/**
	 * @return 
	 * @method : deleteBoard
	 * @parmam : 
	 * @return : void
	 * @throws SQLException 
	 * @description : �����͸� �����Ѵ�.
	 */
	public int deleteBoard(BoardVO boardVO) throws SQLException {
		
		return (int) sqlMap.update("boardDao.deleteBoard", boardVO);
		
	}

	/**
	 * @method : selectListMapBoard
	 * @parmam : 
	 * @return : List<HashMap<String,String>>
	 * @throws SQLException 
	 * @description : 
	 */
	public List<HashMap<String, String>> selectListMapBoard(HashMap<String, String> boardMap) throws SQLException {
		// TODO Auto-generated method stub
		return sqlMap.queryForList("boardDao.selectListMapBoard", boardMap);
	}

	
}
