package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @class : Test08HashMap.java
 * @title : HashMap
 * @author : Yoon
 * @desciption : HashMap 이용하기
 * 
 * 
 * 1. testHashMap_1()함수에서 제네릭타입이 아닐때
 * 	  맵은 데이터의 key값과 value값으로 이루어 진다는것을 보여준다. 
 * 	  중복된 키값으로 put을 했을경우 새로운되이터가 됨을 보여준다.
 * 2. testHashMap_2()함수에서는 제네릭타입일때
 * 3. testHashMap_3()함수에서는 
 * 		Set<String> keySet = hm.keySet();
		Iterator<String> itr = keySet.iterator(); 을 이용하여 키(key)값과 벨류(value)값을 가져온다.
 * 
 */
public class Test08HashMap {
	
	public void testHashMap_1(){
		HashMap hm = new HashMap();
		
		//맵은 데이터를 넣을때 키값,밸류값 으로 넣는다.
		//그리고 키값은 중복될 수 없지만 밸류값은 중복될 수 있다.
		//예를들어 주민등록번호를 기준으로 생일과 나이를 저장한다고 하면
		//주민등록번호는 중복될 수 없지만 생일과 나이가 같은 사람은 존재한다.
		hm.put("A", "AAA");
		hm.put(1, "BBB");
		hm.put("C", 333); 
		hm.put('D', 'D');
		
		//원래 java collection에 데이터를 넣을때는 Object 이어야 하기 때문에
		//int나 char 로 키값이나 밸류값을 직접 넣을수가 없어
		//Integer나 Character 같은 wrapper 클래스로 생성하여 넣어야 했다.
		//하지만 jdk1.5 버전부터는 int나 char 같은 기본형 데이터 타입으로 넣더라도 
		//알아서 변환이 되도록 개선되었다.
		//만약 jdk1.4 버전을 사용하는 환경이라면 고려해야 하는 부분이다
		
		//또 한가지 데이터를 넣을때는 키값과 밸류값을 기본형 데이터타입으로 넣어도 알아서 변환해주지만
		//데이터를 다시 가져올 때에는 제네릭을 선언해주지 않았다면 기본적으로 Object로 가져오기 때문에
		//데이터에 맞는 형변환이 필요해진다.
		int c = (int)hm.get("C");
		char d = (char)hm.get('D');
		
		//만약 이미 있는 키값으로 데이터를 put 했다면 기존에 있던 데이터를 반환하고 새로운 데이터를 덮어쓰게 된다.
		String a = (String)hm.put("A", "BBB");
		System.out.println(a);
		
		//맵에서 데이터를 삭제할 경우에는 
		//remove메소드를 이용하여 키값만 넘겨주면 키값에 해당하는 밸류값까지 삭제되게 된다.
		hm.remove(1);
		hm.remove("A");
		
	}
	
	public void testHashMap_2(){
		//맵에서 제네릭타입을 사용할 경우에는 키값과 밸류값의 클래스를 둘다 지정해 주어야 한다.
		//위에서 맵에 기본형 데이터 타입으로 데이터를 넣어도 자동으로 변환해준다고 하였으나
		//제네릭을 지정해 줄때는 기본형 데이터 타입으로 지정할 수 없기 때문에
		//어쩔수 없이 wrapper 클래스를 이용하게 된다.
		HashMap<String,String> hm2 = new HashMap<String,String>();
		HashMap<Integer,Integer> hm3 = new HashMap<>();
		HashMap<Character,Boolean> hm4 = new HashMap<Character, Boolean>();
		
		hm3.put(1, 1);
		int i = hm3.get(1);
		
		hm4.put('a', true);
		boolean a = hm4.get('a');
		
		//당연하게도 맵 안에 다른 객체를 밸류값으로 넣을 수도 있다.
		HashMap<String,TestVO> hm5 = new HashMap<String, TestVO>();
		TestVO vo = new TestVO();
		vo.setStr1("AAA");
		vo.setInt1(111);
		vo.setChr1('Z');
		hm5.put("vo", vo);
		
		TestVO vo2 = hm5.get("vo");
	}
	
	public void testHashMap_3(){
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("A", "AAA");
		hm.put("B", "BBB");
		hm.put("C", "CCC");
		hm.put("D", "DDD");
		hm.put("E", "EEE");
		
		//맵에 데이터를 넣었다면 키값을 알아야만 해당 데이터를 찾아올 수 있다.
		//그러나 많은 데이터를 넣었다면 어떤 데이터를 어떤 키값으로 넣었는지 일일히 기억하지 못할것이다.
		//이럴때 keySet 메소드로 맵의 키값 데이터들을 가져올 수 있다.
		
		Set<String> keySet = hm.keySet();
		Iterator<String> itr = keySet.iterator();
		while(itr.hasNext()){
			String key = itr.next();
			System.out.println(key+","+hm.get(key));
		}
		
	}
	
	public static void main(String[] args) {
		Test08HashMap obj = new Test08HashMap();
		obj.testHashMap_1();
	}
}
