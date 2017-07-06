package collection.remove;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @class : Test01ArrayListLinkedListTest.java
 * @title : ArrayList VS LinkedList 시간테스트
 * @author : Yoon
 * @desciption : 
 */
public class Test031ArrayListLinkedListTest {
	
	static int value= 2000000;
	
	public static void main(String[] args) {
		ArrayList arrayList = new ArrayList(value);
		LinkedList linkedList = new LinkedList();
		
		 System.out.println("= 순차적으로 추가하기 ="); 
         System.out.println("ArrayList :"+add1(arrayList)); 
         System.out.println("LinkedList :"+add1(linkedList)); 
         System.out.println("================================================"); 
         System.out.println("= 중간에 추가하기 ="); 
         System.out.println("ArrayList :"+add2(arrayList)); 
         System.out.println("LinkedList :"+add2(linkedList)); 
         System.out.println("================================================"); 
         System.out.println(); 
         System.out.println("= 중간에서 삭제하기 ="); 
         System.out.println("ArrayList :"+remove2(arrayList)); 
         System.out.println("LinkedList :"+remove2(linkedList)); 
         System.out.println("================================================"); 
         System.out.println(); 
         System.out.println("= 순차적으로 삭제하기 ="); 
         System.out.println("ArrayList :"+remove1(arrayList)); 
         System.out.println("LinkedList :"+remove1(linkedList)); 
         System.out.println("================================================"); 
         
         
         
	}

	/**
	 * @method : add1
	 * @parmam : 
	 * @return : long
	 * @description : 순차적으로 추가하기
	 */
	private static long add1(List list) {
		long start = System.currentTimeMillis();
		for(int i = 0 ; i < value ; i ++ ){
			list.add(i+""); 
		}
		long end = System.currentTimeMillis(); 
		
		return end - start;
		// TODO Auto-generated method stub
		
	}
	
	
	/**
	 * @method : add2
	 * @parmam : 
	 * @return : long
	 * @description : 중간에 추가하기
	 */
	private static long add2(List list) {
		long start = System.currentTimeMillis();
		for(int i = 0 ; i < value ; i ++ ){
			list.add(500,i+""); 
		}
		long end = System.currentTimeMillis(); 
		
		return end - start;
	}
	
	 /**
	 * @method : remove1
	 * @parmam : 
	 * @return : long
	 * @description : 순차적으로 삭제하기
	 */
	public static long remove1(List list) { 
		System.out.println("list.size() 111111111111= "+ list.size());
         long start = System.currentTimeMillis(); 
         for(int i=list.size()-1; i >= 0;i--){
        	 list.remove(i); 
         }
         long end = System.currentTimeMillis();
         
         System.out.println("list.size() 222222222222= "+ list.size());
         return end - start; 
   } 

	 /**
	 * @method : remove2
	 * @parmam : 
	 * @return : long
	 * @description : 중간에서 삭제하기
	 */
	public static long remove2(List list) { 
		System.out.println("list.size() = "+ list.size());
         long start = System.currentTimeMillis(); 
         for(int i=5000; i<10000;i++) {
        	 list.remove(i); 
         }
         long end = System.currentTimeMillis(); 
         return end - start; 
   } 
	

}
