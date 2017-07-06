package poi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @class : Test02Poi_XlsxTest.java
 * @title : 
 * @author : Yoon
 * @desciption : 
 * 1. poi를 사용하기 위해서 필요한 라이브러리 (http://poi.apache.org/download.html)
 * 	- xlsx파일을 만들기 위해서는
 * 		poi-3.16.jar
 *		xmlbeans-2.6.0.jar
 *		commons-collections4-4.1.jar
 *		poi-ooxml-3.16.jar
 *		poi-ooxml-schemas-3.16.jar	가필요함.
 * 라이브러리가 필요함.
 * 화면예시)
 *  이름	국어	영어	수학
	김삼순	100	80	70
 */
public class Test02Poi_XlsxTest {

	public static void main(String[] args) {
		// Workbook 생성
		Workbook xlsxWb = new XSSFWorkbook(); // Excel 2007 이상


        // *** Sheet-------------------------------------------------

        // Sheet 생성

        XSSFSheet sheet1 =  (XSSFSheet) xlsxWb.createSheet("firstSheet");

 

        // 컬럼 너비 설정
        sheet1.setColumnWidth(0, 5000);	// setColumnWidth (몇번째열, 너비)

        // ----------------------------------------------------------

         

        // *** Style--------------------------------------------------

        // Cell 스타일 생성
        CellStyle cellStyle = xlsxWb.createCellStyle();
        
        // 가운데정렬
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        // 선칠하기
        cellStyle.setBorderBottom(BorderStyle.THIN);	// 바닥
        cellStyle.setBorderTop(BorderStyle.THIN);		// 위
        cellStyle.setBorderRight(BorderStyle.THIN);		// 오른쪽
        cellStyle.setBorderLeft(BorderStyle.THIN);		// 왼쪽
        // 자동 줄 바꿈
        cellStyle.setWrapText(true);


        Row row = null;

        Cell cell = null;

        //----------------------------------------------------------
        // 첫 번째 줄
        row = sheet1.createRow(0);
        
        // 첫 번째 줄에 Cell 설정하기-------------
        
        cell = row.createCell(0);
        cell.setCellValue("이름2222222222222222222222222222222222222222");
        cell.setCellStyle(cellStyle); // 셀 스타일 적용
      
        cell = row.createCell(1);
        cell.setCellValue("국어");
        cell.setCellStyle(cellStyle); // 셀 스타일 적용
         

        cell = row.createCell(2);
        cell.setCellValue("영어");
        cell.setCellStyle(cellStyle); // 셀 스타일 적용

        cell = row.createCell(3);
        cell.setCellValue("수학");
        cell.setCellStyle(cellStyle); // 셀 스타일 적용

        //---------------------------------

        // 두 번째 줄
        row = sheet1.createRow(1);
        
        cell = row.createCell(0);
        cell.setCellValue("김삼순");
        cell.setCellStyle(cellStyle); // 셀 스타일 적용
        

        // 두 번째 줄에 Cell 설정하기-------------
        cell = row.createCell(1);
        cell.setCellValue("100");
        cell.setCellStyle(cellStyle); // 셀 스타일 적용

        cell = row.createCell(2);
        cell.setCellValue("80");
        cell.setCellStyle(cellStyle); // 셀 스타일 적용

        cell = row.createCell(3);
        cell.setCellValue("70");
        cell.setCellStyle(cellStyle); // 셀 스타일 적용

        //---------------------------------
        
        // ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■List에서 가져오기 Start■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
        List<TestVo> list = new ArrayList<TestVo>();
        
        
        
        TestVo testVo = new TestVo();
        testVo.set이름("김말짜");
        testVo.set국어("100");
        testVo.set영어("10");
        testVo.set수학("20");
        list.add(testVo);
        
        
        testVo = new TestVo();
        testVo.set이름("홍길동");
        testVo.set국어("99");
        testVo.set영어("11");
        testVo.set수학("21");
        list.add(testVo);
        
        for(int i = 0 ; i < list.size() ; i++){
        	row = sheet1.createRow(2+i);
        	  
        	cell = row.createCell(0);
            cell.setCellValue(list.get(i).get이름());
            cell.setCellStyle(cellStyle); // 셀 스타일 적용
            

            // 두 번째 줄에 Cell 설정하기-------------
            cell = row.createCell(1);
            cell.setCellValue(list.get(i).get국어());
            cell.setCellStyle(cellStyle); // 셀 스타일 적용

            cell = row.createCell(2);
            cell.setCellValue(list.get(i).get영어());
            cell.setCellStyle(cellStyle); // 셀 스타일 적용

            cell = row.createCell(3);
            cell.setCellValue(list.get(i).get수학());
            cell.setCellStyle(cellStyle); // 셀 스타일 적용
               
        	
        	
        }
        
     // ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■List에서 가져오기 End■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
        
        

        // excel 파일 저장
        FileOutputStream fileOut = null;
        try {

            File xlsFile = new File("src/poi/Test02Poi_XlsxTest.xlsx");

            fileOut = new FileOutputStream(xlsFile);

            xlsxWb.write(fileOut);

            
            
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
        	// Workbook 자원반납
        	if(xlsxWb != null){
        		try {
        			xlsxWb.close();
        			System.out.println("Workbook 자원반납");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		
        	}
        }
	}
}
