package collection;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @class : Test07TreeSet.java
 * @title : TreeSet
 * @author : Yoon
 * @desciption : TreeSet객체사용하기
 * 
 * 
 * 1. TreeSet을 이용하여 add()함수를 사용할수있음을 보여준다 
 * 2. add()함수를 이용하여 중복처리가 안됨을 보여준다.
 * 3. headSet()함수를 이용하여 주어진값보다 앞의 값이 출력됨을 보여준다.
 * 4. tailSet()함수를 이용하여 주어진값보다 뒤의 값을 출력됨을 보여준다.
 * 
 * 
 */
public class Test07TreeSet {
	public static void main(String[] args) {
		
		
		
		TreeSet ts = new TreeSet();
		for(char chr = 'A';chr<='Z';chr++){
			String tmp = String.valueOf(chr);
			ts.add(tmp);
		}
		 
		System.out.println(ts.add("K"));// set은 데이터의 중복처리가 안되기때문에 false를 출력한다.
		System.out.println(ts);
		
		System.out.println("============================ts.headSet(K) Start ==============================");
		//headSet은 주어진 값보다 앞에 있는 값 즉 주어진 값보다 작은 값의 SortSet을 가져온다
		System.out.println(ts.headSet("K"));
		System.out.println("============================ts.headSet(K) End ==============================");
		
		
		System.out.println("============================ts.tailSet(K) Start ==============================");
		//tailSet은 주어진 값보다 뒤에 있는 값 즉 주어진 값을 포함한 큰 값의 SortSet을 가져온다
		System.out.println(ts.tailSet("K"));
		System.out.println("============================ts.tailSet(K) End ==============================");
		
		
		System.out.println("============================ts.headSet(K) Start ==============================");
		//headSet을 호출할때 매개변수로 기준값의 포함여부를 함께 보낼 수 있다.
		//true면 포함 false면 미포함
		System.out.println(ts.headSet("K", true));
		System.out.println("============================ts.headSet(K) End ==============================");
		
		
		System.out.println("============================ ts.tailSet Start ==============================");
		//tailSet도 마찬가지
		System.out.println(ts.tailSet("K", false));
		System.out.println("============================ ts.tailSet End ==============================");
		
		System.out.println("============================ ts.headSet(K).iterator() Start ==============================");
		// K다음부터 가져오게한다.
		Iterator it = ts.headSet("K").iterator();
		while(it.hasNext()){
			
			System.out.println(it.next());
		}
		System.out.println("============================ ts.headSet(K).iterator() End ==============================");
	}

}
