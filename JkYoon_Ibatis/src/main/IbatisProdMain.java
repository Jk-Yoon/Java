package main;

import java.sql.SQLException;
import java.util.List;

import application.prod.serviceImpl.ProdServiceImpl;
import application.prod.vo.ProdVO;

/**
 * @class : IbatisProdMain.java
 * @title : 
 * @author : Yoon
 * @desciption : ���� ��ǰ�� ���� ���/����/����/��ȸ�� �Ѵ�.
 */
public class IbatisProdMain {
	
	private ProdServiceImpl prodService = new ProdServiceImpl();
	
	/**
	 * @method : selectListProd
	 * @parmam : 
	 * @return : void
	 * @description : ������ ��ȸ
	 */
	private void selectListProd() throws SQLException {
		
		
		ProdVO prodVO = new ProdVO();
		
		List<ProdVO> list = prodService.selectListProd(prodVO);
		
		for(int i = 0 ; i < list.size() ; i++){
			System.out.println("prodId = "+list.get(i).getProdId() 
								+ " prodNm = "+list.get(i).getProdNm() 
								+ " prodPrice = " +list.get(i).getProdPrice()
								+ " prodBuyer = " +list.get(i).getProdBuyer()
								+ " prodDetail = " +list.get(i).getProdDetail()
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
	private void insertProd() throws SQLException {
		ProdVO prodVO = new ProdVO();
		
 
				
		
		prodVO.setProdNm("11111");
		prodVO.setProdPrice(100000);
		prodVO.setProdBuyer("19840215");
		prodVO.setProdDetail("��ǰ�� ���ƿ�1");
		
		int cnt = prodService.insertProd(prodVO);
		
		System.out.println("cnt= " + cnt);
	}
	
	

	/**
	 * @method : updateTest
	 * @parmam : 
	 * @return : void
	 * @throws SQLException 
	 * @description : ������ ����
	 */
	private void updateProd() throws SQLException {
		ProdVO prodVO = new ProdVO();
		
 
		prodVO.setProdId("1");	
		prodVO.setProdNm("11111");
		prodVO.setProdPrice(20000);
		prodVO.setProdBuyer("19840215");
		prodVO.setProdDetail("��ǰ�� ���ƿ�2");
		
		int cnt = prodService.updateProd(prodVO);
		
		System.out.println("cnt= " + cnt);
		
	}
	
	

	/**
	 * @method : deleteTest
	 * @parmam : 
	 * @return : void
	 * @throws SQLException 
	 * @description : ������ ����
	 */
	private void deleteProd() throws SQLException {
		ProdVO prodVO = new ProdVO();
		 
		prodVO.setProdId("1");
		 
		int cnt = prodService.deleteProd(prodVO);
		
		System.out.println("cnt= " + cnt);
		
	}
	

	public static void main(String[] args) throws SQLException {
		IbatisProdMain obj = new IbatisProdMain();
		// ���
		obj.insertProd();
		
		// ��ȸ
		obj.selectListProd();
		
		// ����
		obj.updateProd();
		
		// ����
		//obj.deleteProd();
		
	}
}
