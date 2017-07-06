package application.member.vo;

/**
 * @class : MemberVo.java
 * @title : 
 * @author : Yoon
 * @desciption : 회원정보 Vo
 */
public class MemberVO {
	
	// 회원ID
	private String memId;
	
	// 회원비밀번호
	private String memPass;
	
	// 회원성명
	private String memName;
	
	// 회원 생일
	private String memBir;
	
	// 회원 주소
	private String memAdd;

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPass() {
		return memPass;
	}

	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemBir() {
		return memBir;
	}

	public void setMemBir(String memBir) {
		this.memBir = memBir;
	}

	public String getMemAdd() {
		return memAdd;
	}

	public void setMemAdd(String memAdd) {
		this.memAdd = memAdd;
	}
	
	
	
}
