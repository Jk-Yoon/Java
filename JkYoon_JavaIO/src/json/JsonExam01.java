package json;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @class : JsonExam01.java
 * @title : 
 * @author : Yoon
 * @desciption : 
 */
public class JsonExam01 {
	//	예제1 
//	1. Json 문자열을 저장하기 위한 변수 선언
	private String jsonData;
	
	public String getJsonData() {
		return jsonData;
	}
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
//	----------------------------------------------- 간단한 변수 선언과 게터세터 생성

//	예제2
//	Json형식의 String을 Java방식의 String으로 변환
//	1. Json형식의 String의 값들을 저장하기 위한 변수를 만들어줄 Class생성(JsonExam01.class) 및 변수 선언
//	2. 문자의 변환을 실행할 run()생성
	private void run() {
//		3. 값을 받아오고 변환하는 작업에서 발생할 Exception 방지를 위해 try-catch 사용
		try {
			//Jackson ObjectMapper선언
			ObjectMapper mapper = new ObjectMapper();
			//Jackson데이터(String형식)와 변환할 Class를 파라미터에 입력한다.
			JsonExamVo obj = mapper.readValue(jsonData, JsonExamVo.class);

//			JsonExam01 json = new JsonExam01();
//			json.setResult1("값");
//			json.setResult2("");
//			
//			mapper.writeValueAsString(json);
			
			//변환된 값 확인
			System.out.println("result1 : " + obj.getResult1());
			System.out.println("result2 : " + obj.getResult2());
			//json에 배열로 저장된 result3의 값을 향상된 for문으로 출력
			for (String listItem : obj.getResult3()) {
				System.out.println("listitem : " + listItem);
			}
			
			//result4번 내부의 내용 중 key값을 사용하여 그 value를 출력한다.
			for (String key : obj.getResult4().keySet()) {
				System.out.println("Map key (" + key + ") : " + obj.getResult4().get(key));
			}
			
			//이렇게도 할수있다.
//			Set<String> keySet = obj.getResult4().keySet();
//			Iterator<String> itr = keySet.iterator();
//			while(itr.hasNext()){
//				String key = itr.next();
//				System.out.println("Map key (" + key + ") : " + obj.getResult4().get(key));
//			}
			
			
			
//			결과값
//			result1:test1
//			result2:test2
//			listitem:test3
//			listitem:test4
//			Map key (subresult3):test3
//			Map key (subresult4):test4
			
//			예제3
//			Java형식의 String을 Json형식의 String으로 변환
//			class 값을 Json형식의 String으로 변환
			String jsonData = mapper.writeValueAsString(obj);
			//결과값
			//{"result" : "test1", "result2" : "test2", "result3" : ["test3", "test4"], "result4" : {"subresult3" : "test3", "subresult4" : "test4"}}
			System.out.println(jsonData);
			
//			예제4
//			json을 File로 저장하고 저장된 json파일을 불러와서 출력.
			//저장된 json의 파일 생성
			mapper.writeValue(new File("src/json/test.json"), obj);
			//저장된 json파일을 불러와서 Map으로 받는다.
			Map<String, Object> map = mapper.readValue(new File("src/json/test.json"), new TypeReference<Map<String, Object>>(){});
			//Map으로 받은 json의 내용을 key값으로 식별하여 출력한다.
			System.out.println(map.get("result1"));
			//json에 들어있는 내용중 배열 부분을 list에 담는다.
			ArrayList<String> list = (ArrayList<String>) map.get("result3");
			//list에 담긴 배열의 내용을 향상된 for문을 사용하여 출력한다.
			for (String string : list) {
				System.out.println(string);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		//클래스 선언
		JsonExam01 ex = new JsonExam01();
		
		//예제 1
		//Json데이터 담기
		//1. Json의 내용은 {}(중괄호)안에 담는다.
		//2. 중괄호 안에는 "key" : "value"의 형식으로 Map과 같은 방식으로 내용을 입력한다. *Java에서 문자열로 담을 시 ""(더블 포테이션)은 \" \" <--- 이렇게 사용한다.
		//3. 각 내용들의 구분은 , 로 구분한다.
		//4. 배열의 내용은 [](대괄호)로 표현한다. 예) "test1" : ["key1":"value1", "key2":"value2"]
		//위에서 선언한 jsonData에 Json형식의 String을 담는다.
		ex.setJsonData("{\"result1\" : \"test1\","
						+ "\"result2\" : \"test2\","
						+ "\"result3\" : [\"test3\", \"test4\"],"
						+ "\"result4\" : {\"subresult3\" : \"test3\", \"subresult4\" : \"test4\"}" +"}");
		
		ex.run();
	}
}