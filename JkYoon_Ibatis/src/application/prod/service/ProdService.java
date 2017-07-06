package application.prod.service;

import java.sql.SQLException;
import java.util.List;

import application.prod.vo.ProdVO;

/**
 * @class : ProdService.java
 * @title : 
 * @author : Yoon
 * @desciption : 상품 인터페이스
 */
public interface ProdService {
 
	/**
	 * @method : selectListProd
	 * @parmam : 
	 * @return : List<ProdVO>
	 * @description : 데이터를 조회한다.
	 */
	public List<ProdVO> selectListProd(ProdVO prodVO) throws SQLException;

	 
	/**
	 * @method : insertProd
	 * @parmam : 
	 * @return : int
	 * @description : 데이터를 등록한다.
	 */
	public int insertProd(ProdVO prodVO) throws SQLException;
	
	
	
	/**
	 * @method : updateProd
	 * @parmam : 
	 * @return : int
	 * @description : 데이터를 수정한다.
	 */
	public int updateProd(ProdVO prodVO) throws SQLException;

	/**
	 * @return 
	 * @method : deleteProd
	 * @parmam : 
	 * @return : void
	 * @throws SQLException 
	 * @description : 데이터를 삭제한다.
	 */
	public int deleteProd(ProdVO prodVO) throws SQLException;
}
