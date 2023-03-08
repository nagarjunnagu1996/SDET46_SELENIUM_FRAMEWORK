package com.commonutilities.genericutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utilities 
{
	DataFormatter df=new DataFormatter();	
	 Workbook wbook;
public void intializedata(String filepath) throws EncryptedDocumentException, IOException
{
	FileInputStream fisdata=new FileInputStream(filepath);
	 Workbook wbook = WorkbookFactory.create(fisdata);
}
public void getdata(String sheet_name,String test_scriptname)
{
	Sheet sheet = wbook.getSheet(sheet_name);
	Map<String, String> map=new HashedMap<>();
	for(int i=0;i<sheet.getLastRowNum();i++)
	{
		String tc_name = df.formatCellValue(sheet.getRow(i).getCell(0));
		if(tc_name.equals(test_scriptname))
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
}
public String getdata_from_index(String sheet_name,int row_num,int cell_num)
{
	Sheet sheet = wbook.getSheet(sheet_name);
	String value = df.formatCellValue(sheet.getRow(row_num).getCell(cell_num));
	return value;

}
}
