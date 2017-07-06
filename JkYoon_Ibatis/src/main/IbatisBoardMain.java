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
 * @desciption : ibatis������ ������ ��ȸ������ �ϰ� �Ѿ����.
 * ���̺귯���� 
 * ibatis-2.3.4.726.jar
 * ojdbc6.jar
 * log4j-1.2.17.jar
 * ���ʿ��ϴ�.
 * 
 * ��ȸ, ��ϸ� �ϰ� �������� ���� 
 */
public class IbatisBoardMain {
	//�����͸� �ҷ����� ���� DAO
	private BoardServiceImpl boardService = new BoardServiceImpl();
 
	/**
	 * @method : selectListBoard
	 * @parmam : 
	 * @return : void
	 * @description : ������ ��ȸ
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
	 * @description : ������ ���
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
	 * @description : ������ ����
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
	 * @description : ������ ����
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
	 * @description : ������ ��ȸ
	 */
	private void selectListHashMapBoard() throws SQLException {
		
		HashMap<String, String> boardMap = new HashMap<String, String>();
		
		boardMap.put("boardTitle", "dd");
		
		List<HashMap<String, String>> list = boardService.selectListHashMapBoard(boardMap);
		

		
		
		// DB�� ����Ŭ�� ��� HashMap�� ���� �빮�ڸ� ����ؾ��Ѵ�.
		// DB �÷� Ÿ���� number�ϰ�� hashMap�� ����Ұ�� java.math.BigDecimal�� �������⶧���� ����ȯ�� �ʿ��ϴ�.
		for(int i = 0 ; i < list.size() ; i++){
			System.out.println("BoardId = "+ String.valueOf(list.get(i).get("BOARDID"))
								+ " BoardTitle = "+list.get(i).get("BOARDTITLE") 
								+ " BoardContent = " +list.get(i).get("BOARDCONTENT") );
			 
		}
		
	}
	
	

	public static void main(String[] args) throws SQLException {
		IbatisBoardMain obj = new IbatisBoardMain();
	
		// ��ȸ
		//obj.selectListBoard();
		
		// ���
		// obj.insertTest();
		
		// ����
		//obj.updateTest();
		 
		// ����
		//obj.deleteTest(); 
		 
		obj.selectListHashMapBoard();
	}
 

 
	 
}
