package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class write_data_into_excel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testData.xlsx");
		Workbook workb = WorkbookFactory.create(fis);
		Sheet sheet = workb.getSheet("practice");
		Cell cel = sheet.getRow(1).createCell(2);
		cel.setCellValue("test case is pass");
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\testData.xlsx");
workb.write(fos);
		workb.close();
		fis.close();
	}

}


//switch to window
//	public void switchtowindowbyusingtitle()
	//{
		//driver.switchTo().window(null)
	//}