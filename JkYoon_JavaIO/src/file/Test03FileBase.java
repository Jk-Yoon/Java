package file;

import java.io.File;

/**
 * @class : Test03FileBase.java
 * @title : 
 * @author : Yoon
 * @desciption : 디렉토리만드는것
 * 
 */
public class Test03FileBase {

	public static void main(String[] args) {
		// 디렉토리(폴더) 만들기
		// 1. mkdir() ==> File 객체의 경로 중 마지막 위치의 디렉토리를 만든다.
		//				  중간의 경로가 모두 미리 만들어져 있어야 마지막 위치의 경로를 만들 수 있다.
		// 2. mkdirs() ==> 중간의 경로가 없으면 중간의 경로도 새롭게 만든 후 마지막 위치의 경로를 만들어 준다.
		
		File file1 = new File("D:\\AAA");
		if(file1.mkdir()){	// 만들기 성공이면 true
			System.out.println(file1.getName() + " 만들기 성공!");
		}else{
			System.out.println(file1.getName() + " 만들기 실패!");
		}
		System.out.println();
		
		File file2 = new File("D:\\AAA\\BBB\\CCC");
		if(file2.mkdirs()){	//mkdirs()는 중간 경로도 만들어 준다!
			System.out.println(file2.getName() + " 만들기 성공!");
		}else{
			System.out.println(file2.getName() + " 만들기 실패!");
		}
		System.out.println();
		
		
	}
}
