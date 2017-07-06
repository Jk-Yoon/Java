package pdf;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @class : Test01PdfTest.java
 * @title : 
 * @author : Yoon
 * @desciption : D:\JkYoon\workspace\javaToddler_library\itextpdf-5.1.2.jar 필요하다.
 */
public class Test01PdfTest {
	public static void main(String[] args) throws IOException, DocumentException {
		createPdf("src/pdf/Test01PdfTest.pdf");
	}

	public static void createPdf(String filename) throws IOException,
			DocumentException {
		// step 1
		Document document = new Document();
		// step 2
		PdfWriter.getInstance(document, new FileOutputStream(filename));
		// step 3
		document.open();
		// step 4
		document.add(createFirstTable());
		// step 5
		document.close();
	}

	/**
	 * Creates our first table
	 * 
	 * @return our first table
	 */
	public static PdfPTable createFirstTable() {
		// a table with three columns
		PdfPTable table = new PdfPTable(3);
		// the cell object

		PdfPCell cell;
		// we add a cell with colspan 3
		cell = new PdfPCell();
		cell.setFixedHeight(44);
		// cell.setColspan(3);
		table.addCell(cell);
		// now we add a cell with rowspan 2
		cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
		cell.setRowspan(2);
		table.addCell(cell);
		// we add the four remaining cells with addCell()
		table.addCell("row 1; cell 1");
		table.addCell("row 1; cell 2");
		table.addCell("row 2; cell 1");
		table.addCell("row 2; cell 2");
		System.out.println("테이블생성완료");
		return table;
	}

}
