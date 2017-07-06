package collection.remove;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @class : Test05Queue.java
 * @title : 
 * @author : Yoon
 * @desciption : Queue객체 테스트
 */
public class Test05Queue {
	public static void main(String[] args) {
		/*
		 * Queue는 가장 먼저 넣은 데이터가 가장 먼저 나오는 구조
		 * */
		Queue que = new LinkedList();
		
		que.add("A");
		que.add("B");
		que.add("C");
		
		que.offer("D");
		que.offer("E");
		que.offer("F");
		
		
	
		
		Iterator<String> it = que.iterator();
		String str = ""; 
				
		while(it.hasNext()){ //이터레이터가 다음 아이템을 가지고 있는동안 반복
			
			str = it.next();
			System.out.println("str = " + str);	
		 
		}
		
		
		Iterator<String> it1 = que.iterator();
		String str1 = ""; 
		for( int i = 0 ; i < que.size() ; i++ ){
			str1 = it1.next();
			System.out.println("str1 = " + str1);	
		}
		
		while(!que.isEmpty()){
			System.out.println(que.poll());	 // poll은 가장 첫번째 데이터를 뽑아내고 리스트에서 삭제한다. poll과 pop은 같은기능이다.
			
		}
		
		 
		
		
	}
}
