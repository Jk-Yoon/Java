package application.board.service;

import java.sql.SQLException;
import java.util.List;

import application.board.vo.BoardVO;

/**
 * @class : BoardService.java
 * @title : 
 * @author : Yoon
 * @desciption : 게시판 인터페이스
 */
public interface BoardService {
	
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
}
