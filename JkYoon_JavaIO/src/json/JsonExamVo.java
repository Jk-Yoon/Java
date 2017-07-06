package json;

import java.util.List;
import java.util.Map;
//예제2
//Json형식의 String을 Java방식의 String으로 변환 
//1. Json형식의 String의 값들을 저장하기 위한 변수를 만들어줄 Class생성 및 변수 선언

/**
 * @class : JsonExamVo.java
 * @title : 
 * @author : Yoon
 * @desciption : jackson-annotations-2.7.0.jar
jackson-core-2.6.6.jar
jackson-databind-2.5.5.jar
를 이용하기
 */
public class JsonExamVo {
//	예)(Json) "key" : "value"
//	  (Java) String key = value;
//	json에 입력된 key값과 그걸 저장할 Java의 변수 이름은 같아야한다.
	private String result1; 
	private String result2;
	private List<String> result3;
	private Map<String, String> result4;
	
	public String getResult1() {
		return result1;
	}
	public void setResult1(String result1) {
		this.result1 = result1;
	}
	
	public String getResult2() {
		return result2;
	}
	public void setResult2(String result2) {
		this.result2 = result2;
	}
	
	public List<String> getResult3() {
		return result3;
	}
	public void setResult3(List<String> result3) {
		this.result3 = result3;
	}
	
	public Map<String, String> getResult4() {
		return result4;
	}
	public void setResult4(Map<String, String> result4) {
		this.result4 = result4;
	}
}
