package collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @class : Test06HashSet.java
 * @title : HashSet
 * @author : Yoon
 * @desciption : HashSet객체이용하기
 * 
 * 1. testHashSet_1() add 메소드를 사용할수있음을 보여주고 중복이 허용되지않음을 보여준다.
 * 2. testHashSet_2()  Iterator<String> it = hs.iterator();를 사용하여 값을 불러올수 있음을 보여준다.
 * 3. testHashSet_3() for(;it.hasNext();) 을  사용하여 값을 불러올수있음을 보여준다.
 * 4. testHashSet_4() for(int i=0;i<hs.size();i++)을 사용하여 값을 불러올수 있음을 보여준다.
 * 5. testHashSet_5() Arrays.toString(hs.toArray())을 사용할 수 있음을 보여준다.
 * 
 */
public class Test06HashSet {
	
	/**
	 * @method : testHashSet_1
	 * @parmam : 
	 * @return : void
	 * @description : HashSet에 객체추가
	 */
	public void testHashSet_1(){
		
		HashSet hs = new HashSet();
		
		//HashSet에 데이터를 추가할때도 add메소드를 사용한다.
		hs.add("A");
		hs.add("C");
		hs.add("B");
		hs.add("E");
		hs.add("E");
		hs.add(1);
		hs.add(2);
		hs.add(5);
		
		//해쉬셋은 데이터의 순서가 없고 중복을 허용하지 않는다.
		//따라서 이미 있는 데이터를 add하게 되면
		boolean isAdd = hs.add("A");
		
		//boolean 으로 false 값을 리턴하고 데이터는 추가되지 않는다.
		System.out.println(isAdd);
		
	}
	
	/**
	 * @method : testHashSet_2
	 * @parmam : iterator() 함수사용하기
	 * @return : void
	 * @description : 
	 */
	public void testHashSet_2(){
		HashSet<String> hs = new HashSet<String>();
		hs.add("A");
		hs.add("C");
		hs.add("B");
		hs.add("E");
		hs.add("D");
		
		//해쉬셋은 데이터에 순서가 없기 때문에 리스트처럼 인덱스로 데이터를 하나씩 불러올 수 없다
		//그래서 데이터를 하나씩 얻기 위해서는 Iterator로 변환해야 한다.
		Iterator<String> it = hs.iterator();
		
		//HashSet에 넣었던 데이터를 Iterator로 뽑을때 넣었던 순서와는 상관이 없이 나온다
		
		String str = "";
		//while문으로 데이터 추출할때
		while(it.hasNext()){ //이터레이터가 다음 아이템을 가지고 있는동안 반복
			
			str = it.next();
			if("A".contains(str)){
				System.out.println("str = " + str);	
			}else{
				System.out.println("str = " + str);
			}
		}
		
		
	}
	
	/**
	 * @method : testHashSet_3
	 * @parmam : 
	 * @return : void
	 * @description : for(;it.hasNext();) 이용하기
	 */
	public void testHashSet_3(){
		HashSet<String> hs = new HashSet<String>();
		hs.add("A");
		hs.add("C");
		hs.add("B");
		hs.add("E");
		hs.add("D");
		
		Iterator<String> it = hs.iterator();
		
		//for문으로 데이터 추출할때
		for(;it.hasNext();){
			System.out.println(it.next());
		}
	}
	
	/**
	 * @method : testHashSet_4
	 * @parmam : 
	 * @return : void
	 * @description : HashSet를 가지고 for문 돌리기
	 */
	public void testHashSet_4(){
		HashSet<String> hs = new HashSet<String>();
		hs.add("A");
		hs.add("C");
		hs.add("B");
		hs.add("E");
		hs.add("D");
		
		Iterator<String> it = hs.iterator();
		
		for(int i=0;i<hs.size();i++){
			System.out.println(it.next());
		}
	}
	
	
	/**
	 * @method : testHashSet_5
	 * @parmam : 
	 * @return : void
	 * @description : Arrays.toString(hs.toArray()) 이용하기
	 */
	public void testHashSet_5(){
		HashSet<String> hs = new HashSet<String>();
		hs.add("A");
		hs.add("C");
		hs.add("B");
		hs.add("E");
		hs.add("D");
		
		System.out.println(Arrays.toString(hs.toArray()));
		
		Iterator<String> it = hs.iterator();
		
		 
		for (String aa : hs) {
			System.out.println(it.next());
		}
		
//		for(int i=0;i<hs.size();i++){
//			System.out.println(it.next());
//		}
	}
	
	public static void main(String[] args) {
		Test06HashSet obj = new Test06HashSet();
		obj.testHashSet_1();
	}
}
