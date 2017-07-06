package application.board.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.board.vo.BoardVO;

/**
 * @class : BoardService.java
 * @title : 
 * @author : Yoon
 * @desciption : 게시판 인터페이스
 */
public interface BoardService {
	
	/**
	 * @method : selectListBoard
	 * @parmam : 
	 * @return : List<BoardVO>
	 * @description : 데이터를 조회한다.
	 */
	public List<BoardVO> selectListBoard(BoardVO boardVO) throws SQLException;

	 
	/**
	 * @method : insertBoard
	 * @parmam : 
	 * @return : int
	 * @description : 데이터를 등록한다.
	 */
	public int insertBoard(BoardVO boardVO) throws SQLException;
	
	
	
	/**
	 * @method : updateBoard
	 * @parmam : 
	 * @return : int
	 * @description : 데이터를 수정한다.
	 */
	public int updateBoard(BoardVO boardVO) throws SQLException;

	/**
	 * @return 
	 * @method : deleteBoard
	 * @parmam : 
	 * @return : void
	 * @throws SQLException 
	 * @description : 데이터를 삭제한다.
	 */
	public int deleteBoard(BoardVO boardVO) throws SQLException;
	
	
	/**
	 * @method : selectListHashMapBoard
	 * @parmam : 
	 * @return : List<HashMap<String,String>>
	 * @description : HashMap파라미터와 List<HashMap> 결과를 조회
	 */
	public List<HashMap<String, String>> selectListHashMapBoard(HashMap<String, String> boardMap) throws SQLException;
}
