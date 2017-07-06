package collection;

import java.util.Vector;

/**
 * @class : Test01Vector.java
 * @title : Vector
 * @author : Yoon
 * @desciption : Vector 연습
 * 
 * 1 . Vector에서 add()를 쓸수 있다는 것과 addElement()를 쓸수있다 를 보여준다.
 * 2 . Vector에서 remove()를 사용하여 Vector의 값을 삭제할수 있음을 보여준다.
 * 
 */
public class Test01Vector {
	
	public static void main(String[] args) {
		
		Vector v = new Vector();
		
		// Vector는 add명령을 이용하여 데이터를 추가할 수 있다.
		v.add("111111111111");
		v.add("222222222222");
		v.add("333333333333");
		v.add("444444444444");
		v.add("555555555555");
		
		// addElement()를 이용하여 추가할 수도 있는데 add는 리턴값을 반환하지만 addElement는 리턴값을 반환하지않는다.
		v.addElement("ccc");
		
		
		for(int i = 0 ; i < v.size() ; i ++){
			
			System.out.println(v.get(i).toString());
			
		}
		// set(index, 데이터);  ==> 벡터의 index번째 값을 주어진 '데이터'로 덮어쓴다.
		//					    ==> 반환값 : 원래의 데이터
		String v0 = (String)v.set(0, "eee");
		
		
		// add(index, 데이터);  ==> 벡터의 index번째에 '데이터'를 끼워넣는다.
		//                     ==> index는 0부터 시작한다.
		v.add(2, "2222222222222222");
		//System.out.println("v0:"+v0);
		
		
		// remove(index) ==> 벡터의 index번째 자료를 삭제한다.
		//       ==> 자료가 삭제되면 index번째 다음번째의 데이터들이 앞으로 자동으로
		//           당겨져서 채워진다.
		//       ==> 반환값 : 삭제된 데이터
		
		// remove(삭제할데이터) ==> '삭제할데이터'를 찾아 삭제한다.
		//                    ==> 삭제할데이터가 여러개이면 앞에서 부터 삭제된다.
		// 삭제할 데이터가 '정수형'이거나 'char형'일 경우 객체로 변환해서 사용해야 한다.
		String removeItem = (String)v.remove(0); 
		
		boolean  aboolean =  v.remove("555555555555");
		
		
		System.out.println("removeItem:"+removeItem);
		System.out.println("aboolean:"+aboolean);
		
		for(int i = 0 ; i < v.size() ; i ++){
			
			System.out.println(v.get(i).toString());
			
		}
		
	}

}

