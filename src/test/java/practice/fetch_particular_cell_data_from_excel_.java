package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class fetch_particular_cell_data_from_excel_ {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		DataFormatter df=new DataFormatter();
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testData.xlsx");
		Workbook workb = WorkbookFactory.create(fis);
		Sheet sheet = workb.getSheet("admin_module");
		String value=null;
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			String key = df.formatCellValue(sheet.getRow(i).getCell(0));
			//System.out.println(key);
			if(key.equals("grade"))
			{
				value = df.formatCellValue(sheet.getRow(i).getCell(1));
				break;
			}
		}
		System.out.println(value);

	}

}
