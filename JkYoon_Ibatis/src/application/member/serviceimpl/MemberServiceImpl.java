package application.member.serviceimpl;

import java.sql.SQLException;
import java.util.List;

import application.member.dao.MemberDao;
import application.member.service.MemberService;
import application.member.vo.MemberVO;

/**
 * @class : MemberServiceImpl.java
 * @title : 
 * @author : Yoon
 * @desciption : 맴버 ServiceImpl
 */
public class MemberServiceImpl implements MemberService {
	
	private MemberDao dao = new MemberDao();
	
	
	@Override
	public List<MemberVO> selectListMember(MemberVO memberVO)
			throws SQLException {
		return dao.selectListMember(memberVO);
	}

	@Override
	public int insertMember(MemberVO memberVO) throws SQLException {
		return dao.insertMember(memberVO);
	}

	@Override
	public int updateMember(MemberVO memberVO) throws SQLException {
		return dao.updateMember(memberVO);
	}

	@Override
	public int deleteMember(MemberVO memberVO) throws SQLException {
		return dao.deleteMember(memberVO);
	}

}
