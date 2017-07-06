package application.board;

import java.sql.SQLException;
import java.util.List;



/**
 * @class : BoardServiceImpl.java
 * @title : 
 * @author : Yoon
 * @desciption : 
 */
public class BoardServiceImpl {

	//데이터를 불러오기 위한 DAO
	private BoardDao dao = new BoardDao();

	/**
	 * @method : selectListBoard
	 * @parmam : 
	 * @return : List<BoardVO>
	 * @description : 게시판조회
	 */
	public List<BoardVO> selectListBoard() throws SQLException {
		// TODO Auto-generated method stub
		return dao.selectListBoard();
	}

	/**
	 * @method : insertBoard
	 * @parmam : 
	 * @return : int
	 * @description : 게시판 등록
	 */
	public int insertBoard(BoardVO boardVO) throws SQLException {
		return dao.insertBoard(boardVO);
		
	}

	/**
	 * @return 
	 * @method : upadetBoard
	 * @parmam : 
	 * @return : void
	 * @throws SQLException 
	 * @description : 게시판 수정
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
	 * @description : 게시판삭제 
	 */
	public int deleteBoard(BoardVO boardVO) throws SQLException {
		return dao.deleteBoard(boardVO);
		
	}
	
	
}
