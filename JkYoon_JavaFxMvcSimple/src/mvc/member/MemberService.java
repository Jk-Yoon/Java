package mvc.member;

import java.util.List;


public class MemberService {
	private static MemberService ms;
	
	private MemberService(){
		dao = MemberDao.getInstance();
	}
	
	public static MemberService getInstance(){
		if(ms == null){
			ms = new MemberService();
		}
		return ms;
	}
	
	
	private MemberDao dao; //MemberDao객체 변수 선언
//
//	public MemberService() {
//		dao = new MemberDao(); // MemberDao객체 생성
//	}
	
	public int insertMember(MemberVO mv){
		return dao.insertMember(mv);
	}

	public int deleteMember(String mem_id) {
		return dao.deleteMember(mem_id);
	}

	public int updateMember(MemberVO mv) {
		return dao.updateMember(mv);
	}

	public int displayMember() {
		return dao.displayMember();
	}	
	
	public List<MemberVO> getAllMemberList(){
		return dao.getAllMemberList();
	}

//	public List<MemberVO> dataSerach(int subChoice, String input, String fieldname) {
	public List<MemberVO> dataSerach(String input, String fieldname) {
//		return dao.dataSearch(subChoice, input);
		return dao.dataSearch(input, fieldname);
	}

	
	
}
