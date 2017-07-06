package file;

import java.io.File;
import java.net.MalformedURLException;

/**
 * @class : Test01FileBase.java
 * @title : File 객체
 * @author : Yoon
 * @desciption : File 객체의 기본메소드
 */
public class Test01FileBase {

	public static void main(String[] args) throws MalformedURLException {
		
		File f = new File("src/file/Test01FileBase.java");
		 
		System.out.println("파일존재체크 = " + f.exists());
		
		String fileName = f.getName();
		int pos = fileName.lastIndexOf(".");

		System.out.println("경로를 제외한 파일이름 		== > " + f.getName());
		System.out.println("확장자를 제외한 파일이름 		== > " + fileName.substring(0,pos));
		System.out.println("확장자 - 					== > " + fileName.substring(pos+1));
		
		System.out.println("f.toURI() = "+f.toURI());
		System.out.println("f.toURL() = "+f.toURL());
		
		System.out.println("경로를 포함한 파일이름 		== > "	+ f.getPath());
		System.out.println("파일의 절대경로        		== > "	+ f.getAbsolutePath());
		System.out.println("파일이 속해 있는 디렉토리 		== > "	+ f.getParent());
		System.out.println();
		System.out.println("File.pathSeparator 			== > "		+ File.pathSeparator);
		System.out.println("File.pathSeparatorChar 		== > "  + File.pathSeparatorChar);
		System.out.println("File.separator 				== > "		+ File.separator);
		System.out.println("File.separatorChar 			== > "	+ File.separatorChar);
		System.out.println();
		System.out.println("user.dir					== > " + System.getProperty("user.dir"));
		System.out.println("sun.boot.class.path			== > " + System.getProperty("sun.boot.class.path"));		// C:\Program Files\Java\jre7\lib\	
		System.out.println("java.io.tmpdir				== > " + System.getProperty("java.io.tmpdir"));				// 임시디렉토리
		
	}
}
