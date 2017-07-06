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
 * @desciption : �Խ��� �������̽�
 */
public interface BoardService {
	
	/**
	 * @method : selectListBoard
	 * @parmam : 
	 * @return : List<BoardVO>
	 * @description : �����͸� ��ȸ�Ѵ�.
	 */
	public List<BoardVO> selectListBoard(BoardVO boardVO) throws SQLException;

	 
	/**
	 * @method : insertBoard
	 * @parmam : 
	 * @return : int
	 * @description : �����͸� ����Ѵ�.
	 */
	public int insertBoard(BoardVO boardVO) throws SQLException;
	
	
	
	/**
	 * @method : updateBoard
	 * @parmam : 
	 * @return : int
	 * @description : �����͸� �����Ѵ�.
	 */
	public int updateBoard(BoardVO boardVO) throws SQLException;

	/**
	 * @return 
	 * @method : deleteBoard
	 * @parmam : 
	 * @return : void
	 * @throws SQLException 
	 * @description : �����͸� �����Ѵ�.
	 */
	public int deleteBoard(BoardVO boardVO) throws SQLException;
	
	
	/**
	 * @method : selectListHashMapBoard
	 * @parmam : 
	 * @return : List<HashMap<String,String>>
	 * @description : HashMap�Ķ���Ϳ� List<HashMap> ����� ��ȸ
	 */
	public List<HashMap<String, String>> selectListHashMapBoard(HashMap<String, String> boardMap) throws SQLException;
}
