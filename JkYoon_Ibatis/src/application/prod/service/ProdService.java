package application.prod.service;

import java.sql.SQLException;
import java.util.List;

import application.prod.vo.ProdVO;

/**
 * @class : ProdService.java
 * @title : 
 * @author : Yoon
 * @desciption : ��ǰ �������̽�
 */
public interface ProdService {
 
	/**
	 * @method : selectListProd
	 * @parmam : 
	 * @return : List<ProdVO>
	 * @description : �����͸� ��ȸ�Ѵ�.
	 */
	public List<ProdVO> selectListProd(ProdVO prodVO) throws SQLException;

	 
	/**
	 * @method : insertProd
	 * @parmam : 
	 * @return : int
	 * @description : �����͸� ����Ѵ�.
	 */
	public int insertProd(ProdVO prodVO) throws SQLException;
	
	
	
	/**
	 * @method : updateProd
	 * @parmam : 
	 * @return : int
	 * @description : �����͸� �����Ѵ�.
	 */
	public int updateProd(ProdVO prodVO) throws SQLException;

	/**
	 * @return 
	 * @method : deleteProd
	 * @parmam : 
	 * @return : void
	 * @throws SQLException 
	 * @description : �����͸� �����Ѵ�.
	 */
	public int deleteProd(ProdVO prodVO) throws SQLException;
}
