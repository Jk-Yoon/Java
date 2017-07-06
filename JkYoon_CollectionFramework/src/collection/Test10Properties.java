package collection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

/**
 * @class : Test10Properties.java
 * @title : Properties
 * @author : Yoon
 * @desciption : Properties 사용예제
 * 
 * 1. Test10Properties_1()함수에서는 Properties를 이용하여 key값과 value값을 가짐을 보여준다. setProperty , getProperty 사용
 * 2. Test10Properties_2()함수에서는 Properties와  FileOutputStream 를 이용하여 파일을 만든다. 
 * 2. Test10Properties_3()함수에서는 Properties와  FileInputStream 를 이용하여 파일을 읽어온다. 
 */
public class Test10Properties {
	
	public static void main(String[] args) throws IOException {
		Test10Properties test09Properties = new Test10Properties();
		test09Properties.Test10Properties_1();
	}

	
	public void Test10Properties_1() {
		Properties pro = new Properties();
		pro.setProperty("A", "A1");
		pro.setProperty("B", "B1");
		pro.setProperty("C", "C1");
		pro.setProperty("D", "D1");
		pro.setProperty("E", "E1");
		
		
		String str = pro.getProperty("A");
		System.out.println(str);
		
		Iterator it1 = pro.keySet().iterator();		///  Iterator로 Key들을 뽑아낸다.
		
		String key1 = "";
		while(it1.hasNext()){	// Key를 뽑아낸 Iterator를 돌려가며
			key1 = (String) it1.next();	//  key를 뽑는다.
			
			System.out.println("key = "+ key1 +" value = " + pro.get(key1));
		}
		
		
		
	}
	/**
	 * @method : Test10Properties_2
	 * @parmam : 
	 * @return : void
	 * @description : Properties에 있는 정보를 파일로 만든다.
	 */
	public void Test10Properties_2() throws IOException {
		Properties pro = new Properties();
		pro.setProperty("A", "A1");
		pro.setProperty("B", "B1");
		pro.setProperty("C", "C1");
		pro.setProperty("D", "D1");
		pro.setProperty("E", "E1");
		
		File file = new File("src/collection/Test10Properties.txt");
		FileOutputStream fos = new FileOutputStream(file);
		
		// pro에 있는 정보를 파일로 저장한다.
		pro.store(fos, "파일넣기");
		
		System.out.println(pro.getProperty("A"));
		
	}
	/**
	 * @method : Test10Properties_3
	 * @parmam : 
	 * @return : void
	 * @description : 파일에 있는 정보를 불러와서 Properties에 저장하기
	 */
	public void Test10Properties_3() throws IOException {
		Properties pro = new Properties();
		
		File file = new File("src/collection/Test10Properties.txt");
		FileInputStream fis = new FileInputStream(file);
		
		// 파일을 읽어와서 Properties객체에 저장 
		pro.load(fis);
		
		System.out.println(pro.getProperty("A"));
		
	}
}
