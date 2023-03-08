package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

public class fetch_data_from_excel_full_activity 
{
public static void main(String[] args) throws EncryptedDocumentException, IOException 
{
	String tc_name="adding_student";
	String erq_value="address";
	DataFormatter df=new DataFormatter();
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testData.xlsx");
	Workbook workb = WorkbookFactory.create(fis);
	Sheet sheet = workb.getSheet("grow_life_details");
	for(int i=0;i<sheet.getLastRowNum();i++)
	{
		String key = df.formatCellValue(sheet.getRow(i).getCell(0));
		if(key.equals(tc_name))
		{
	for(int j=0;j<sheet.getRow(i).getLastCellNum();j++)
			{
				String values = df.formatCellValue(sheet.getRow(i).getCell(j));
				if(values.equals(erq_value))
				{
					//for(int k=0; ;k++)
				//	{
				String data=df.formatCellValue(sheet.getRow(i+1).getCell(j));
					System.out.println(data);
					//}
				}
					break;
			}
		}
	break;
	}
	}
	
}

