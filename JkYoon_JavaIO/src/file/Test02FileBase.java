package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @class : Test02FileBase.java
 * @title : 
 * @author : Yoon
 * @desciption : File의 속성, 생성, 삭제, 목록
 */
public class Test02FileBase {
	
 
	/** 
	 * 1. 파일생성
	 * 2. 파일리스트
	 * 3. 파일삭제
	 * 4. 파일내용읽기
	 * */
	
	public static void main(String[] args) throws IOException {
		
		String fileDir = "src"+File.separator+"file"+File.separator; // src/file/
		String fileName = "Test02FileBase.txt";
		
		// 파일생성
		//creatFile(fileDir+fileName);
		
		File dir = new File(fileDir);
		// 파일리스트
		printFileList(dir);
		
		
		// 파일삭제
		//deleteFile(fileDir+fileName);
		
		// 파일내용읽기
		//readContentsPrint(fileDir+fileName);
	}
	
 
	/**
	 * @method : creatFile
	 * @parmam : 
	 * @return : void
	 * @descripttion : 파일생성
	 */
	public static void creatFile(String fileName) throws IOException{
		File f = new File(fileName);
		f.createNewFile();
		System.out.println("파일생성");
	}
 
	
	/**
	 * @method : printFileList
	 * @parmam : 파일리스트 출력
	 * @return : void
	 * @descripttion
	 */
	public static void printFileList(File dir) throws IOException{
		System.out.println(dir.getAbsolutePath()+" 디렉토리"); // D:\JkYoon\workspace\JkYoon_JavaIO\src\file 디렉토리
		File[] files = dir.listFiles();
		for(int i=0; i < files.length; i++) {
			String filename  = files[i].getName();

			filename = dir.getAbsolutePath() + File.separator + filename;
			System.out.println(" fileName = "+ filename);

		}
	}
	
	/**
	 * @method : deleteFile
	 * @parmam : 
	 * @return : void
	 * @description : 파일삭제
	 */
	public static void deleteFile(String fileName) throws IOException{
		File f = new File(fileName);
		f.delete();
		System.out.println("파일삭제");
	}
	
	
	/**
	 * @method : inContentsPrint
	 * @parmam : 
	 * @return : void
	 * @description : 파일 내용읽기
	 */
	public static void readContentsPrint(String fileName) throws IOException{
		File f = new File(fileName);
		
		// 문자기반 스트림
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);	// 속도 향상을 위해서 씀
		
		String data = "";
		while ( (data = br.readLine()) != null ) {
			System.out.println("fileName : " + data);
		}
		br.close();
 
		System.out.println("파일 내용읽기");
	}
	
	
	
 
}


