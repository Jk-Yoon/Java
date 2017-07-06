package collection;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @class : Test02ArrayList1.java
 * @title : 
 * @author : Yoon
 * @desciption : Collections의 reverse와 shuffle 이용하기
 * 
 * 1. Collections.reverse을 이용하여 역정렬을 보여준다.
 * 2. Collections.shuffle을 이용하여 섞어줌을 보여준다.
 */
public class Test03ArrayListSort {

	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>();
		
		arrayList.add("1");
		arrayList.add("2");
		arrayList.add("3");
		arrayList.add("4");
		arrayList.add("5");
		
		System.out.println("======================================================");
		for(int i = 0 ; i < arrayList.size(); i++){
			System.out.println(arrayList.get(i));
		}
		System.out.println("======================================================");
		
		System.out.println("=========================역정렬 Start========================");
		// 역 정렬
		Collections.reverse(arrayList);
		for(int i = 0 ; i < arrayList.size(); i++){
			System.out.println(arrayList.get(i));
		}
		System.out.println("=========================역정렬 End==========================");
		
		
		System.out.println("========================shuffle Start==============================");
		// Shuffle하기
		Collections.shuffle(arrayList);
		for(int i = 0 ; i < arrayList.size(); i++){
			System.out.println(arrayList.get(i));
		}
		System.out.println("========================shuffle End==============================");
		
		
		
	}
}
