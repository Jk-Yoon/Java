package application.board.serviceimpl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.board.dao.BoardDao;
import application.board.service.BoardService;
import application.board.vo.BoardVO;

/**
 * @class : BoardServiceImpl.java
 * @title : 
 * @author : Yoon
 * @desciption : 
 */
public class BoardServiceImpl implements BoardService {
	
	//데이터를 불러오기 위한 DAO
	private BoardDao dao = new BoardDao();
	
	/**
	 * @method : selectListBoard
	 * @parmam : 
	 * @return : List<BoardVO>
	 * @throws SQLException 
	 * @description : 데이터를 조회한다.
	 */
	public List<BoardVO> selectListBoard(BoardVO boardVO) throws SQLException {
		
		return dao.selectListBoard(boardVO);
	}
	
 
	/**
	 * @method : insertBoard
	 * @parmam : 
	 * @return : int
	 * @description : 데이터를 등록한다.
	 */
	public int insertBoard(BoardVO boardVO) throws SQLException {
		
		return dao.insertBoard(boardVO);
	}
	
	
	
	/**
	 * @method : updateBoard
	 * @parmam : 
	 * @return : int
	 * @description : 데이터를 수정한다.
	 */
	public int updateBoard(BoardVO boardVO) throws SQLException {
		
		return dao.updateBoard(boardVO);
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
		
		return  dao.deleteBoard( boardVO);
		
	}


	/**
	 * @method : selectListHashMapBoard
	 * @parmam : 
	 * @return : List<HashMap<String,String>>
	 * @throws SQLException 
	 * @description : HashMap파라미터와 List<HashMap> 결과를 조회
	 */
	public List<HashMap<String, String>> selectListHashMapBoard(HashMap<String, String> boardMap) throws SQLException {
		return dao.selectListMapBoard(boardMap);
	}



}
