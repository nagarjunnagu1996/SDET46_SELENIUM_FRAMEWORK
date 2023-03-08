package com.commonutilities.genericutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * ExcelUtiloities class having utility methods like fetch the data and write the data 
 * @author nagarjuna m
 *
 */
public class ExcelUtilitiesnew
{
	Workbook wbook ;
	DataFormatter df;
	FileInputStream fisdata;
	/**
	 * this constructor is used to create object for class
	 */
	public ExcelUtilitiesnew()
	{

	}
	/**
	 * in this function initializing all the data
	 * @param excelfilepath
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public ExcelUtilitiesnew(String excelfilepath) 
	{
		try {
			initializedata(excelfilepath);
		} catch (EncryptedDocumentException e) {
			
		}
	}
	/**
	 * in this method we are initializing the data
	 * @param excelfilepath
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void initializedata(String excelfilepath) 
	{
		 df=new DataFormatter();
		
		
			try {
				fisdata = new FileInputStream(excelfilepath);
			} catch (FileNotFoundException e) {
				
			}
		
			try {
				wbook = WorkbookFactory.create(fisdata);
			} catch (EncryptedDocumentException e) {
				
			} catch (IOException e) {
			
			}
		
	}
	/**
	 * in this method we are fetching the data from excel based on test scripts
	 * @param sheetname
	 * @param exptestscriptname
	 * @return
	 */
	public Map<String, String> getdata(String sheetname,String exptestscriptname)
	{

		Sheet sheet = wbook.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		Map<String, String> map=new HashedMap<>();
		for(int i=0;i<rowcount;i++)
		{
			String tc_name = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(tc_name.equals(exptestscriptname))
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
		return map;
	}
	/**This method is used to fetching the data from excel based on key and value 
	 * 
	 */
	public String getdata(String sheetname,String exptestscriptname,String expkey)
	{
		Sheet sheet = wbook.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		String value="";
		int testscriptcounter=0;
		int keycounter=0;
		for(int i=0;i<rowcount;i++)
		{
			String tc_name = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(tc_name.equals(exptestscriptname))
			{
				testscriptcounter++;
				for(int j=1;j < sheet.getRow(i).getLastCellNum();j++) 
				{
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					if(key.equals(expkey))
					{
						keycounter++;	
						value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
						break;
					}
				}
				break;

			}
		}
		if(keycounter==0)
		{
			if(testscriptcounter==0)
			{
				value="please enter proper testscript key "+exptestscriptname+"";
			}
			else
			{
				value="please enter proper testscript key"+expkey+"";
			}
		}
		System.out.println("fetched value from excel--->"+value);
		return value;
	}


	/**
	 * in this function we can get particular cell value
	 * @param sheetname
	 * @param rowindex
	 * @param cellindex
	 * @return
	 */
	public String getdata(String sheetname,int rowindex,int cellindex)
	{
		String value = df.formatCellValue(wbook.getSheet(sheetname).getRow(rowindex).getCell(cellindex));
		return value;
	}
	/**
	 * in this function we are close the opened work book
	 * @throws IOException
	 */
	public void close()
	{
		try {
			wbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * in this function we are write the data into particular cell
	 * @param sheetname
	 * @param rowindex
	 * @param cellindex
	 * @return 
	 */
	public String setdata(String sheetname,int rowindex,int cellindex)
	{
		return df.formatCellValue(wbook.getSheet(sheetname).getRow(rowindex).createCell(cellindex));

	}
	/**
	 * this method is used get the data to dataprovider
	 * @param sheetname
	 * @return
	 */
	public String[][] getdatatodataprovider(String sheetname)
	{
		Sheet sheet = wbook.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		String[][] arr=new String [rowcount][sheet.getRow(0).getLastCellNum()];
		for (int i = 1; i <=rowcount; i++) 
		{
			for(int j=0;j<sheet.getRow(i).getLastCellNum();j++)
			{
			arr[i-1][j]=df.formatCellValue(sheet.getRow(i).getCell(j));	
			}
			
		}
		return arr;
	}
	
	
	
	
	
	
	
	/**
	 * in this method we are saving the data what we are entered
	 * @param fileoutputpath
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void savedata(String fileoutputpath) throws FileNotFoundException, IOException
	{
		wbook.write(new FileOutputStream(fileoutputpath));
	}
}


