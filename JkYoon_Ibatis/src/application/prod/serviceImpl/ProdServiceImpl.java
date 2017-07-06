package application.prod.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import application.prod.dao.ProdDao;
import application.prod.service.ProdService;
import application.prod.vo.ProdVO;

/**
 * @class : ProdServiceImpl.java
 * @title : 
 * @author : Yoon
 * @desciption : ªÛ«∞ ServiceImpl
 */
public class ProdServiceImpl implements ProdService{
	private ProdDao dao = new ProdDao();
	
	
	@Override
	public List<ProdVO> selectListProd(ProdVO prodVO) throws SQLException {
		return dao.selectListProd(prodVO);
	}

	@Override
	public int insertProd(ProdVO prodVO) throws SQLException {
		return dao.insertProd(prodVO);
	}

	@Override
	public int updateProd(ProdVO prodVO) throws SQLException {
		return dao.updateProd(prodVO);
	}

	@Override
	public int deleteProd(ProdVO prodVO) throws SQLException {
		return dao.deleteProd(prodVO);
	}

}
