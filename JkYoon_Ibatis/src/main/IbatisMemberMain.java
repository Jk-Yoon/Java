package main;

import java.sql.SQLException;
import java.util.List;

import application.member.serviceimpl.MemberServiceImpl;
import application.member.vo.MemberVO;

/**
 * @class : IbatisMemberMain.java
 * @title : 
 * @author : Yoon
 * @desciption : ���� �ɹ��� ���� ���/����/����/��ȸ�� �Ѵ�.
 */
public class IbatisMemberMain {
	
	
	private MemberServiceImpl memberService = new MemberServiceImpl();
	
	
	/**
	 * @method : selectListMember
	 * @parmam : 
	 * @return : void
	 * @description : ������ ��ȸ
	 */
	private void selectListMember() throws SQLException {
		
		
		MemberVO memberVO = new MemberVO();
		
		List<MemberVO> list = memberService.selectListMember(memberVO);
		
		for(int i = 0 ; i < list.size() ; i++){
			System.out.println("memId = "+list.get(i).getMemId() 
								+ " memPass = "+list.get(i).getMemPass() 
								+ " memName = " +list.get(i).getMemName()
								+ " memBir = " +list.get(i).getMemBir()
								+ " memAdd = " +list.get(i).getMemAdd()
								);
		}
		
	}

	/**
	 * @method : insertTest
	 * @parmam : 
	 * @return : void
	 * @throws SQLException 
	 * @description : ������ ���
	 */
	private void insertMember() throws SQLException {
		MemberVO memberVO = new MemberVO();
		
 
				
		
		memberVO.setMemPass("11111");
		memberVO.setMemName("������");
		memberVO.setMemBir("19840215");
		memberVO.setMemAdd("���������� ����");
		
		int cnt = memberService.insertMember(memberVO);
		
		System.out.println("cnt= " + cnt);
	}
	
	

	/**
	 * @method : updateTest
	 * @parmam : 
	 * @return : void
	 * @throws SQLException 
	 * @description : ������ ����
	 */
	private void updateMember() throws SQLException {
		MemberVO memberVO = new MemberVO();
		
 
		memberVO.setMemId("1");	
		memberVO.setMemPass("11111");
		memberVO.setMemName("������");
		memberVO.setMemBir("19840215");
		memberVO.setMemAdd("���������� ����");
		
		int cnt = memberService.updateMember(memberVO);
		
		System.out.println("cnt= " + cnt);
		
	}
	
	

	/**
	 * @method : deleteTest
	 * @parmam : 
	 * @return : void
	 * @throws SQLException 
	 * @description : ������ ����
	 */
	private void deleteMember() throws SQLException {
		MemberVO memberVO = new MemberVO();
		 
		memberVO.setMemId("1");
		 
		int cnt = memberService.deleteMember(memberVO);
		
		System.out.println("cnt= " + cnt);
		
	}
	
  
	
	public static void main(String[] args) throws SQLException {
		IbatisMemberMain obj = new IbatisMemberMain();
		// ���
		obj.insertMember();
		// ��ȸ
		obj.selectListMember();
		// ����
		obj.updateMember();
//		// ����
//		obj.deleteMember();
		
		
		
	}

}
