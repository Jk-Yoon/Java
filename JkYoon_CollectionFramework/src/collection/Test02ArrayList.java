package collection;

import java.util.ArrayList;


/**
 * @class : Test01ArrayList.java
 * @title : ArrayList
 * @author : Yoon
 * @desciption : 
 * 
 * 1. ArrayList에서 add()를 쓸수 있다 를 보여준다.
 * 2. ArrayList에서 제네릭을 이용하여 추가함을 보여준다.
 * 3. ArrayList에서 TestVO를 이용하여 추가함을 보여준다.
 */
public class Test02ArrayList {

	public static void main(String[] args) {
		ArrayList l = new ArrayList();
		
		// 어레이리스트는 기본적인 사용법이 벡터와 같다.
		// add를 통해 데이터를 추가하면 추가여부를 boolean으로 반환 받는다.
		boolean isAdd_1 = l.add("aaa");
		boolean isAdd_2 = l.add("bbb");
		boolean isAdd_3 = l.add(111);
		boolean isAdd_4 = l.add('a');
		boolean isAdd_5 = l.add(true);
		
		//사이즈를 확인해 보면 추가한 데이터의 갯수를 확인할 수 있다.
		System.out.println(l.size());
		
		//벡터와 마찬가지로 인덱스로 데이터를 가져올 수 있다.
		System.out.println(l.get(0));
		
		//데이터를 끼워넣는 add도 벡터와 같다.
		l.add(0, "XXX");
		
		//데이터를 바꿔치기 하는 set도 마찬가지
		String yyy = (String)l.set(0, "YYY");
		
		//삭제도 같다
		String removeItem = (String)l.remove(0);
		
		//제네릭을 지정하여 선언할 수 있다.
		ArrayList<String> strL = new ArrayList<String>();
		strL.add("AAA");
		strL.add("BBB");
		strL.add("CCC");
		strL.add("DDD");
		strL.add("EEE");
//		strL.add(111);
		
		
		System.out.println("=============================for Start===================================");
		for(int i=0;i<strL.size();i++){
			System.out.println(strL.get(i));
		}
		System.out.println("=============================for End===================================");
		
		for(String item:strL){
			System.out.println(item);
		}
		
		ArrayList<TestVO> voL = new ArrayList<TestVO>();
		TestVO vo = new TestVO();
		vo.setStr1("AAA");
		vo.setInt1(111);
		vo.setChr1('x');
		voL.add(vo);
		voL.add(vo);
		voL.add(vo);
		
		
		for(TestVO item:voL){
			System.out.println(item.getStr1()+","+item.getInt1());
		}
		
		/*
		 * Vector와 ArrayList의 가장 큰 차이점은 Vector는 "무조건 동기화" ArrayList는 sychronized 선언했을때만 동기화
		 * */
	}
}
