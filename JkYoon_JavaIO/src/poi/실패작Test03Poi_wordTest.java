package poi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

/**
 * @class : Test03Poi_wordTest.java
 * @title : 
 * @author : Yoon
 * @desciption : POI를 이용한 WORD파일만들기
 */
public class 실패작Test03Poi_wordTest {
	
	public static void main(String[] args) {
		 //Blank Document
	      XWPFDocument document= new XWPFDocument();
	        
	        
	      //create table
	      XWPFTable table = document.createTable();
	      table.setWidth(1000000);
			
	      // 첫번째 로우생성
	      XWPFTableRow tableRow = table.getRow(0);	// 첫번째줄을 가져온다. 첫번째로우는 가져와야한다.
	      
	     
	      tableRow.getCell(0).setText("이름");
	      
//	      CTTblWidth width = table.getCTTbl().addNewTblPr().addNewTblW();
//	      width.setType(STTblWidth.DXA);
//	      width.setW(BigInteger.valueOf(9073));
	      
	      XWPFTableCell cell =  tableRow.addNewTableCell();
	      cell.setText("국어");
	      
	      cell.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(10000));
	      
	      tableRow.addNewTableCell().setText("영어");
	      tableRow.addNewTableCell().setText("수학");
	      
			
	      // 두번째 로우생성
	      tableRow = table.createRow();
	      tableRow.getCell(0).setText("김삼순");
	      tableRow.getCell(1).setText("100");
	      tableRow.getCell(2).setText("80");
	      tableRow.getCell(3).setText("70");
			
	      //세번째 로우생성
	      tableRow = table.createRow();
	      tableRow.getCell(0).setText("홍길동");
	      tableRow.getCell(1).setText("90");
	      tableRow.getCell(2).setText("81");
	      tableRow.getCell(3).setText("71");
	
	      
	      for(int x = 0 ; x < table.getNumberOfRows(); x ++){
	    	  XWPFTableRow row = table.getRow(x);
	    	  int numberOfcell = row.getTableCells().size();
	    	  for(int y = 0 ; y < numberOfcell; y++){
	    		  XWPFTableCell cell1 = row.getCell(y);
	    		  if(x == 0){
	    			  cell1.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(9000));  
	    		  }
	    		  
	    		  
	    	  }
	    	  
	      }
	      
	     
	      
//	      CTTblWidth width = table.getCTTbl().addNewTblPr().addNewTblW();
//
//	      width.setType(STTblWidth.DXA);
//	      width.setW(BigInteger.valueOf(9000));

	      
	      // excel 파일 저장
	        FileOutputStream fileOut = null;
	        try {

	            File xlsFile = new File("src/poi/Test03Poi_wordTest.doc");

	            fileOut = new FileOutputStream(xlsFile);

	            document.write(fileOut);

	            
	            
	        } catch (FileNotFoundException e) {

	            e.printStackTrace();

	        } catch (IOException e) {

	            e.printStackTrace();

	        }finally{
	        	//FileOutputStream 자원반납
	        	if(fileOut != null){ 
					try {
						fileOut.close();
						System.out.println("FileOutputStream 자원반납");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	        	// XWPFDocument 자원반납
	        	if(document != null){
	        		try {
	        			document.close();
	        			System.out.println("XWPFDocument 자원반납");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        		
	        	}
	        }
	      
	      
	     
	}

}
