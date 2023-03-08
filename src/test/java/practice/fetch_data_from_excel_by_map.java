package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Format;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class fetch_data_from_excel_by_map {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		String test_scripname="Adding_Grade_Student_Teacher";
		Map<String, String> map=new HashedMap<>();
		DataFormatter df=new DataFormatter();
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testData.xlsx");
		Workbook wbook = WorkbookFactory.create(fis);
		Sheet sheet = wbook.getSheet("Adminmodule");
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			String tc_name = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(tc_name.equals(test_scripname))
			{
				for(int j=1;j < sheet.getRow(i).getLastCellNum();j++) 
				{
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					String value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
					map.put(key, value);
				}
				break;
			}
			
		}
		System.out.println(map.get("act_admin_dashb_text"));

	}

}
