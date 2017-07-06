package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * @class : Test04SynCollectionTest.java
 * @title : 
 * @author : Yoon
 * @desciption : Collections.synchronizedList함수를 사용했을때와 사용안했을때를 보여주는 예제
 * 	Vector, Hashtable 등의 예전부터 존재하던 Collection들은 
	내부에 동기화 처리가 되어 있다.
	
	그런데, 최근에 새로 구성된 Collection들은 동기화 처리가 되어있지 않다.
	그래서 동기화가 필요한 프로그램에서 이런 Collection들을 사용하려면 
	동기화 처리를 한 후에 사용해야 한다.
	
	- 멀티쓰레드 프로그래밍이 아닌경우에는 불필요한 기능이 되어 성능을 떨어뜨리는 요인이기 때문에 
	  자체적으로 동기화 처리를 하지않는다. [ArrayList, HashMap은 동기화를 자체적으로 처리하지 않고 있다.]
	
	
	
	
	list1과 list2를 주석처리하면서 처리해줘서 테스트해야한다.
	
	
 */
public class Test04SynCollectionTest {
	
	// 동기화를 하지 않을 경우
	private static List<Integer> list1 = new ArrayList<Integer>();
	
	// 동기화를 하는 경우
	private static List<Integer> list2 = Collections.synchronizedList(new ArrayList<Integer>());
	
	private static Vector<Integer> vector = new Vector<Integer>();
	
	public static void main(String[] args) {
		try {
			//익명 클래스로 쓰레드 구현
			Runnable r = new Runnable() {
				
				@Override
				public void run() {
					for (int i = 0; i < 10000; i++) {
//						list1.add(i);
						list2.add(i);
						vector.add(i);
					}
					
				}
			};
			
			Thread[] ths = new Thread[]{
					new Thread(r), new Thread(r),new Thread(r), new Thread(r),new Thread(r)
			};

			for(int i = 0 ; i < ths.length ; i++){
				ths[i].start();
				
			}
			
			
			for(int i = 0 ; i < ths.length ; i++){
				ths[i].join(); // 다른쓰레드 끝날때까지 기다린다. [모든쓰레드가 종료된후에 main문을 종료할수있도록한다.]
				
			}
			
//			System.out.println("list1.size() = " + list1.size());
			System.out.println("list2.size() = " + list2.size());
			System.out.println("vector.size() = " + vector.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println("e.getMessage() = "+e.getMessage());
		}
	}

}
