package collection;

import java.util.LinkedList;

/**
 * @class : Test03LinkedList.java
 * @title : 
 * @author : Yoon
 * @desciption :
 * 1. testLinkedList_1() 함수를 이용해서 List에서 사용하는 add함수를 쓸수있다는 것을 보여준다.
 * 	  추가로 addFirst 와 addLast 사용을 보여준다.
 * 2. testLinkedList_2() 함수를 이용해서 LinkedList는 스텍과 큐의 개념을 가지고있는것을 설명한다.
 * 
 * 
 */
public class Test05LinkedList {
	
	public void testLinkedList_1(){
		LinkedList<String> ll = new LinkedList<String>();
		
		//링크드리스트는 벡터나 어레이리스트와 기본적인 사용법은 같다
		//차이점은 링크드리스트는 앞 뒤 아이템이 연결되어 있어
		//첫번째 아이템과 마지막 아이템에 바로 접근이 가능하며
		//push와 pop이 가능하다는 것
		
		//기본적인 데이터 추가 방법은 같음
		ll.add("AAA");
		ll.add("BBB");
		ll.add("CCC");
		ll.add("DDD");
		ll.add("EEE");
		
		//getFirst, getLast 메소드로 처음 데이터와 마지막 데이터를 바로 가져올 수 있다.
//		System.out.println(ll.getFirst());
//		System.out.println(ll.getLast());
		
		//addFirst는 맨 앞자리에 데이터를 끼워넣고 나머지 데이터를 뒤로 한칸씩 밀어낸다
		//add(0,"XXX") 와는 같은 기능
		ll.addFirst("XXX");
//		ll.add(0,"XXX");
		for(String item:ll){
			System.out.println(item);
		}
		
		//addLast는 맨 뒷자리에 데이터를 넣는다. 그냥 add와 별 차이는 없다.
		ll.addLast("YYY");
//		for(String item:ll){
//			System.out.println(item);
//		}
		
	}
	 
	
	/**
	 * @method : testLinkedList_2
	 * @parmam : 
	 * @return : void
	 * @description : 
	 */
	private void testLinkedList_2() {
		/**
		 * 자바의 정석 p.613
		 * LinkedList는 덱(Deque) 이면서
		 * 덱은 스택과 큐를 하나로 합쳐놓은것
		 * 
		 */
		/** Stack 개념 : 마지막에 저장된것을 제일먼저 꺼내게 된다. */
		LinkedList<String> ll = new LinkedList<String>();
		ll.push("AAA");
		ll.push("BBB");
		ll.push("CCC");
		ll.push("DDD");
		ll.push("EEE");
		
		System.out.println(ll.pop());	//꺼내면서 없앤다.
		System.out.println(ll.pop());
		System.out.println(ll.pop());
		System.out.println(ll.pop());
		System.out.println(ll.pop());
		
		/** Queue 개념 : 제일먼저 저장된것을 제일 먼저 꺼내게 된다 */
		ll.offer("AAA");
		ll.offer("BBB");
		ll.offer("CCC");
		ll.offer("DDD");
		ll.offer("EEE");
		
		System.out.println(ll.poll());
		System.out.println(ll.poll());
		System.out.println(ll.poll());
		System.out.println(ll.poll());
		System.out.println(ll.poll());
		
	}
	
	public static void main(String[] args) {
		Test05LinkedList obj = new Test05LinkedList();
		obj.testLinkedList_2();
		
	}

	
}
