package collection.remove;

import java.util.Stack;

/**
 * @class : Test04Stack.java
 * @title : Stack
 * @author : Yoon
 * @desciption : Stack객체 테스트
 * Last input First Out 으로 되어 있기때문에 마지막에 넣은게 처음으로 나온다.
 */
public class Test04Stack {
	
	public void testStack_1(){
		Stack<String> stack = new Stack<String>();
		
		//스택은 기본적으로 리스트의 형식으로 되어 있어 add와 get 메소드를 통해 데이터를 넣고빼고 할 수 있다.
		stack.add("A");
		stack.add("B");
		stack.add("C");
		stack.add("D");
		stack.add("E");
		
		System.out.println("stack.search(A) = " + stack.search("A"));	// 스텍의 맨위에서 가장 가까운 스택의 거리를 반환한다.
		System.out.println("stack.get(0) = " + stack.get(0));
		System.out.println("stack.search(E) = " + stack.search("E"));   // 스텍의 맨위에서 가장 가까운 스택의 거리를 반환한다.
		System.out.println(stack.toString());
		
		String a = stack.get(0);
		String b = stack.get(1);
		String c = stack.get(2);
		String d = stack.get(3);
		String e = stack.get(4);
		
		//스택이 일반 리스트와 다른 점은 push와 pop에 있다.
		//스택에서 push로 데이터를 넣게되면 데이터는 자동으로 마지막 인덱스에 추가해서 들어가게 된다.
		//pop 메소드로 데이터를 불러오게 되면 가장 마지막에 넣은 데이터가 가장 먼저 나오게 되는데
		//이때 pop으로 불러낸 데이터는 스택에서 사라지게 된다.
		stack.push("F");
		
		System.out.println("stack.indexOf(F) = "+stack.indexOf("F")); // push로 넣은 데이터가 마지막 인덱스로 추가되었음을 알수있다.
		
		
		//
		for(int i = 0 ; i < stack.size() ; i++ ){
			System.out.println(stack.get(i));
			
		}
		System.out.println("stack.pop:"+stack.pop()+", stack.size:"+stack.size());
		System.out.println("stack.pop:"+stack.pop()+", stack.size:"+stack.size());
		System.out.println("stack.pop:"+stack.pop()+", stack.size:"+stack.size());
		System.out.println("stack.pop:"+stack.pop()+", stack.size:"+stack.size());
		System.out.println("stack.pop:"+stack.pop()+", stack.size:"+stack.size());
		System.out.println("stack.pop:"+stack.pop()+", stack.size:"+stack.size());
		
		
		
	}
	
	public static void main(String[] args) {
		Test04Stack obj = new Test04Stack();
		obj.testStack_1();
		
	}
}
