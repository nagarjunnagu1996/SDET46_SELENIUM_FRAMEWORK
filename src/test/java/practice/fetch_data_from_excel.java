package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class fetch_data_from_excel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		DataFormatter df=new DataFormatter();
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testData.xlsx");
	Workbook workb = WorkbookFactory.create(fis);
	Double data = workb.getSheet("ADMINMODULE").getRow(10).getCell(0).getNumericCellValue();
	System.out.println(df.formatCellValue(data));
	
	}

}
