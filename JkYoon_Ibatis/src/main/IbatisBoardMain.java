package main;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import application.board.serviceimpl.BoardServiceImpl;
import application.board.vo.BoardVO;
 
/**
 * @class : TestMain.java
 * @title : 
 * @author : Yoon
 * @desciption : ibatis에대한 설정과 조회까지만 하고 넘어가야함.
 * 라이브러리가 
 * ibatis-2.3.4.726.jar
 * ojdbc6.jar
 * log4j-1.2.17.jar
 * 가필요하다.
 * 
 * 조회, 등록만 하고 나머지는 숙제 
 */
public class IbatisBoardMain {
	//데이터를 불러오기 위한 DAO
	private BoardServiceImpl boardService = new BoardServiceImpl();
 
	/**
	 * @method : selectListBoard
	 * @parmam : 
	 * @return : void
	 * @description : 데이터 조회
	 */
	private void selectListBoard() throws SQLException {
		
		
		BoardVO boardVO = new BoardVO();
		
		List<BoardVO> list = boardService.selectListBoard(boardVO);
		
		for(int i = 0 ; i < list.size() ; i++){
			System.out.println("BoardId = "+list.get(i).getBoardId() 
								+ " BoardTitle = "+list.get(i).getBoardTitle() 
								+ " BoardContent = " +list.get(i).getBoardContent());
			 
		}
		
	}

	/**
	 * @method : insertTest
	 * @parmam : 
	 * @return : void
	 * @throws SQLException 
	 * @description : 데이터 등록
	 */
	private void insertTest() throws SQLException {
		BoardVO boardVO = new BoardVO();
		
 
				
		
		boardVO.setBoardTitle("terter1");
		boardVO.setBoardWriter("terter2");
		boardVO.setBoardContent("terter3");
		
		int cnt = boardService.insertBoard(boardVO);
		
		System.out.println("cnt= " + cnt);
	}
	
	

	/**
	 * @method : updateTest
	 * @parmam : 
	 * @return : void
	 * @throws SQLException 
	 * @description : 데이터 수정
	 */
	private void updateTest() throws SQLException {
		BoardVO boardVO = new BoardVO();
		
 
				
		boardVO.setBoardId("41");
		boardVO.setBoardTitle("terter1");
		boardVO.setBoardWriter("terter2");
		boardVO.setBoardContent("terter3");
		
		int cnt = boardService.updateBoard(boardVO);
		
		System.out.println("cnt= " + cnt);
		
	}
	
	

	/**
	 * @method : deleteTest
	 * @parmam : 
	 * @return : void
	 * @throws SQLException 
	 * @description : 데이터 삭제
	 */
	private void deleteTest() throws SQLException {
		BoardVO boardVO = new BoardVO();
		 
		boardVO.setBoardId("41");
		 
		int cnt = boardService.deleteBoard(boardVO);
		
		System.out.println("cnt= " + cnt);
		
	}
	
 
	/**
	 * @method : selectListBoard
	 * @parmam : 
	 * @return : void
	 * @description : 데이터 조회
	 */
	private void selectListHashMapBoard() throws SQLException {
		
		HashMap<String, String> boardMap = new HashMap<String, String>();
		
		boardMap.put("boardTitle", "dd");
		
		List<HashMap<String, String>> list = boardService.selectListHashMapBoard(boardMap);
		

		
		
		// DB가 오라클일 경우 HashMap을 사용시 대문자를 사용해야한다.
		// DB 컬럼 타입이 number일경우 hashMap을 사용할경우 java.math.BigDecimal로 가져오기때문에 형변환이 필요하다.
		for(int i = 0 ; i < list.size() ; i++){
			System.out.println("BoardId = "+ String.valueOf(list.get(i).get("BOARDID"))
								+ " BoardTitle = "+list.get(i).get("BOARDTITLE") 
								+ " BoardContent = " +list.get(i).get("BOARDCONTENT") );
			 
		}
		
	}
	
	

	public static void main(String[] args) throws SQLException {
		IbatisBoardMain obj = new IbatisBoardMain();
	
		// 조회
		//obj.selectListBoard();
		
		// 등록
		// obj.insertTest();
		
		// 수정
		//obj.updateTest();
		 
		// 삭제
		//obj.deleteTest(); 
		 
		obj.selectListHashMapBoard();
	}
 

 
	 
}
