package util;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellCopyPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellFill;

public class ReadXls {
	public  FileInputStream fis = null;
	private XSSFWorkbook workbook = null;
	private static XSSFSheet sheet = null;
	public XSSFCell cell = null;
	public String[] cellMas = new String[50];
	
	public ReadXls() {
	
		try {
			fis = new FileInputStream("D:\\Test.xlsx");
			workbook = new XSSFWorkbook(fis);
		    sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	public String[] getCellData()  {
		int x=0; 
		do {
		   XSSFCell cell = sheet.getRow(x).getCell(0);	
		   cellMas[x] = cell.getStringCellValue();
		   x++;
		}
	    while (sheet.getRow(x)!= null);	
		return cellMas;
	}
}



