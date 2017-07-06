package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * @class : Test09TreeMap.java
 * @title : 
 * @author : Yoon
 * @desciption : TreeMap을 이용하기 
 * 1. TreeMap은 데이터의 key값과 value값으로 이루어 진다는것을 보여준다.
 * 2. Iterator를 이용하여 while문으로 출력한다.
 * 3. HashMap을 이용하여 출력문을 보여주고 TreeMap이 정렬된 형태로 출력됨을 보여준다.
 * 	
 */
public class Test09TreeMap {
	
	
	public static void main(String[] args) {
		TreeMap<String, String> treeMap = new TreeMap<String, String>();
		
		treeMap.put("aaa", "aaa");
		treeMap.put("bbb", "bbb");
		treeMap.put("ccc", "ccc");
		treeMap.put("ddd", "ddd");
		
		Iterator it = treeMap.keySet().iterator();		///  Iterator로 Key들을 뽑아낸다.
		
		String key = "";
		while(it.hasNext()){	// Key를 뽑아낸 Iterator를 돌려가며
			key = (String) it.next();	//  key를 뽑는다.
			
			System.out.println("key = " + key + " value = " + treeMap.get(key));
		}
		
		System.out.println("============================================");
		
		HashMap<String, String> hashMap = new HashMap<String, String>();
		
		hashMap.put("aaa", "aaa");
		hashMap.put("bbb", "bbb");
		hashMap.put("ccc", "ccc");
		hashMap.put("ddd", "ddd");
		
		Iterator it1 = hashMap.keySet().iterator();		///  Iterator로 Key들을 뽑아낸다.
		
		String key1 = "";
		while(it1.hasNext()){	// Key를 뽑아낸 Iterator를 돌려가며
			key1 = (String) it1.next();	//  key를 뽑는다.
			
			System.out.println("key1 = " + key1 + " value = " + treeMap.get(key1));
		}
		
		
		
	}
}
