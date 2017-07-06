package socketnetwork;

import java.io.Serializable;

/**
 * @class : Address.java
 * @title : 주소 VO
 * @author : Yoon
 * @desciption : 
 * implements Serializable은 직렬화가 가능한 클래스 만드는 방법
 * VO에 implements Serializable을 하지 않았을 경우 java.io.WriteAbortedException: writing aborted; java.io.NotSerializableException: Address
 * 가 발생한다.
 */
public class Address implements Serializable {
	private String Name;
	private String Addr; 
	private String Tel;

	public Address(String name, String addr, String tel) {
		Name = name;
		Addr = addr;
		Tel = tel;
	}

	public String getName() {
		return Name;
	}

	public String getAddr() {
		return Addr;
	}

	public String getTel() {
		return Tel;
	}
}
