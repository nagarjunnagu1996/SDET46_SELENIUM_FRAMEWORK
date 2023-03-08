package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class fetch_particular_row_and_particular_cell_dat_fromexcel 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		String tc_name="Teachers_name";
		DataFormatter df=new DataFormatter();
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testData.xlsx");
		Workbook workb = WorkbookFactory.create(fis);
		Sheet sheet = workb.getSheet("admin_module");
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			String key = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(key.equals(tc_name))
			{
				for(int j=0;j<sheet.getRow(i).getLastCellNum();j++)
				{
					String expdata = df.formatCellValue(sheet.getRow(i).getCell(j));
					//System.out.println(expdata);
					if(expdata.equals("teacher2"))
					{
						String data = df.formatCellValue(sheet.getRow(i+1).getCell(j));
						System.out.println(data);
					}
		
				}
			}

		}
	}
}