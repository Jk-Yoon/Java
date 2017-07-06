package collection.homework.vo;

/**
 * @class : StudentVo.java
 * @title : 
 * @author : Yoon
 * @desciption : StudentVo
 * 
 * 
 * Comparable 인터페이스 객체의 비교를 위한 인터페이스로 객체간의 순서나 정렬을 하기 위해서 Comparable 인터페이스를 구현한다.
 * 
 */
public class StudentVo implements Comparable<StudentVo>{
	
	// 학생 순번
	private int stdNum;
	
	// 학생 이름
	private String name;
	
	// 국어
	private int kor;
	
	// 영어
	private int eng;
	
	// 수학
	private int mat;
	
	// 총점
	private int tot;
	
	// 랭킹
	private int rank;
	public int getStdNum() {
		return stdNum;
	}
	public void setStdNum(int stdNum) {
		this.stdNum = stdNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
	/**
	 * 생성자
	 * @param stdNum
	 * @param name
	 * @param kor
	 * @param eng
	 * @param mat
	 */
	public StudentVo(int stdNum, String name, int kor, int eng, int mat) {
		this.stdNum = stdNum;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = kor + eng + mat;
	}
	
	@Override
	public int compareTo(StudentVo std) {
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("name = " + name + "   std.name = " + std.name );
		System.out.println("stdNum = " + stdNum + "   std.stdNum = " + std.stdNum );
		System.out.println(" Integer.compare(stdNum, std.stdNum) : " + Integer.compare(stdNum, std.stdNum));
		System.out.println("---------------------------------------------------------------------------");
		/**
		 * 1. 현재의 객체가 다른객체와 비교하여 최종 반환되는 값이 0이면 순서가 같음을 의미
		 * 2. 반환되는 값이 양수이면 순서가 뒤에 위치함을 의미 stdNum > std.stdNum
		 * 3. 반환되는 값이 음수이면 순서가 앞에 있음을 의미	stdNum < std.stdNum
		 */
		
		
		return Integer.compare(stdNum, std.stdNum);
		
	}
	
	@Override
	public String toString(){
		return "[stdNum = " + stdNum +" , name = "+  name + " , kor = " + kor + " , eng = " + eng + " , mat = " + mat + " , tot = " + tot +
				" rank = " + rank;
		
	}
	
	
	
}
