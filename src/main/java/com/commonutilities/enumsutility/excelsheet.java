package com.commonutilities.enumsutility;
/**
 * enum sheet of excel 
 * @author nagarjuna m
 *
 */
public enum excelsheet
{
	
ADMINMODULE("Adminmodule"),GROWLIFE("growlife details");
	String key;
	/**
	 * this function gives the key value
	 * @param key
	 */
	private excelsheet(String key)
	{
		this.key=key;
	}
	/**
	 * this method return the sheet name
	 * @return
	 */
	public String getsheetname()
	{
		return key;
		
	}

}
