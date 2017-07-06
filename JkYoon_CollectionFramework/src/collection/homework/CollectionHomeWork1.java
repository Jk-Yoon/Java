package collection.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import collection.homework.vo.StudentVo;
 
/**
 * @class : CollectionHomeWork1.java
 * @title : 
 * @author : Yoon
 * @desciption : 
 * 예제) 1. 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수을 멤버로 갖는 Student클래스를 만든다.
	    2. 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수 만  매개변수로 받아서 처리한다.
	    3. 이 StudentVo객체들은 List에 저장하여 관리한다.
	    4. 등수를 매기는 메소드 구현
	    5. List에 저장된 데이터들을 학번의 오름차순으로 정렬하여 출력한다.				[Comparable 인터페이스사용]
	    6. 총점으로 내림차순으로 정렬한다.											[Comparator 인터페이스 사용]
	 
 */
public class CollectionHomeWork1 {
	
	
	public static void main(String[] args) {
		CollectionHomeWork1 collectionHomeWork1 = new CollectionHomeWork1();
		
		ArrayList<StudentVo> stdList = new ArrayList<StudentVo>();
		
		stdList.add(new StudentVo(1, "홍길동", 90,95,80));
		stdList.add(new StudentVo(3, "성춘향", 90,75,70));
		stdList.add(new StudentVo(7, "강감찬", 95,95,80));
		stdList.add(new StudentVo(5, "변학도", 80,95,90));
		stdList.add(new StudentVo(2, "일지매", 100,85,80));
		stdList.add(new StudentVo(4, "이순신", 60,65,60));
		stdList.add(new StudentVo(6, "이몽룡", 90,100,90));
		// 등수 매기기
		collectionHomeWork1.setRanking(stdList);
		
		
		System.out.println("=========================기본조회 Start=============================");
		for(int i = 0 ; i < stdList.size() ; i++){
			
			System.out.println(stdList.get(i));
		}
		System.out.println("=========================기본조회 End=============================");
		
		
		// 학번으로 오름차순정렬
		Collections.sort(stdList);
		
		System.out.println("===========================오름차순정렬 Start===========================");
		for(int i = 0 ; i < stdList.size() ; i++){
			
			System.out.println(stdList.get(i));
		}
		System.out.println("===========================오름차순정렬 End===========================");
		
		 
		
		// 총점으로 내림차순 정렬
		//Collections.sort(stdList, new SortByTotal());
		Collections.sort(stdList, new Comparator<StudentVo>() {
			@Override
			public int compare(StudentVo std1, StudentVo std2) {
				return Integer.compare(std1.getTot(), std2.getTot()) * -1;
			}
		});
		System.out.println("======================================================");
		
		for(int i = 0 ; i < stdList.size() ; i++){
			
			System.out.println(stdList.get(i));
		}
		
		System.out.println("======================================================");
		
	}

	/**
	 * @method : setRanking
	 * @parmam : 
	 * @return : void
	 * @description : 등수를 매기는 메소드
	 */
	private void setRanking(ArrayList<StudentVo> stdList) {
		for(int i = 0 ; i < stdList.size() ; i ++){
			int rank = 1;
			for(int j = 0 ; j < stdList.size() ; j++){
				
				if(stdList.get(i).getTot() < stdList.get(j).getTot()){
					rank ++;
				}
				
			}
			stdList.get(i).setRank(rank);
		}
		
	}
}


/**
 * @class : CollectionHomeWork1.java
 * @title : 
 * @author : Yoon
 * @desciption : 총점의 역순(내림차순)으로 정렬
 */
class SortByTotal implements Comparator<StudentVo>{
	 
	@Override
	public int compare(StudentVo std1, StudentVo std2) {
	 
		return Integer.compare(std1.getTot(), std2.getTot()) * -1;
		 
	}
}