package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class fetch_data_from_excel_and_othe_activity
{
public static void main(String[] args) throws EncryptedDocumentException, IOException 
{
	DataFormatter df=new DataFormatter();
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testData.xlsx");
	Workbook workb = WorkbookFactory.create(fis);
	Sheet sheet = workb.getSheet("admin_module");
	int rowcount = sheet.getLastRowNum();
	short celcount = sheet.getRow(0).getLastCellNum();
	System.out.println(rowcount+" "+celcount);
	for(int i=0;i<=rowcount;i++)
	{
		for(int j=0;j<celcount;j++)
		{
		//	System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());//if there is no data in the cell it will throw nullpointer exception
		String data = df.formatCellValue(sheet.getRow(i).getCell(j));//if there is no data in the cell it will not throw null pointer exception and it will print spaces in console
		System.out.println(data);
		}
	}
	
}
}
