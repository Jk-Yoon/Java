package application.board;

import java.sql.SQLException;
import java.util.List;

import ibatis.config.SqlMapConfig;

import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @class : BoardDao.java
 * @title : 
 * @author : Yoon
 * @desciption : 게시판 DAO
 */
public class BoardDao {
	
	SqlMapClient sqlMap = null;
	
	public BoardDao() {
		sqlMap = SqlMapConfig.getSqlMapInstance();
		
	}
	

	/**
	 * @method : selectListBoard
	 * @parmam : 
	 * @return : List<BoardVO>
	 * @throws SQLException 
	 * @description : 데이터를 조회한다.
	 */
	public List<BoardVO> selectListBoard() throws SQLException  {
		
		
		return sqlMap.queryForList("board.selectListBoard");
	}
	
	/**
	 * @method : insertBoard
	 * @parmam : 
	 * @return : int
	 * @description : 데이터를 등록한다.
	 */
	public int insertBoard(BoardVO boardVO) throws SQLException {
		
	 
		 return sqlMap.update("board.insertBoard", boardVO);
	}
	
	
	
	/**
	 * @method : updateBoard
	 * @parmam : 
	 * @return : int
	 * @description : 데이터를 수정한다.
	 */
	public int updateBoard(BoardVO boardVO) throws SQLException {
		
		return (int) sqlMap.update("board.updateBoard", boardVO);
	}

	/**
	 * @return 
	 * @method : deleteBoard
	 * @parmam : 
	 * @return : void
	 * @throws SQLException 
	 * @description : 데이터를 삭제한다.
	 */
	public int deleteBoard(BoardVO boardVO) throws SQLException {
		
		return (int) sqlMap.update("board.deleteBoard", boardVO);
		
	}

	
}
