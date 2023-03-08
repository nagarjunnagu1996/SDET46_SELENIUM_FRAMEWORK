package com.commonutilities.genericutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.commonutilities.enumsutility.propertkeys;
/**
 * in this class we have property file utilities like getdata from property file
 * @author nagarjuna m
 *
 */
public class Propertyfile_Utilitiesnew
{
	private Properties prop;
	FileInputStream fispro;
	/**
	 * this constructor will initialize the property file
	 * @param fileinputpath
	 * @throws IOException
	 */
public Propertyfile_Utilitiesnew(String fileinputpath)
{
	
	try {
		fispro = new FileInputStream(fileinputpath);
	} catch (FileNotFoundException e) {
		
	}
	 prop=new Properties();
	try {
		prop.load(fispro);
	} catch (IOException e) {
		
	}
	try {
		fispro.close();
	} catch (IOException e) {
		
	}
}
/**
 * this constructor is used foR create object for class
 */
public Propertyfile_Utilitiesnew()
{
	
}
@Deprecated
public void initializepropertyfile(String fileinputpath) throws IOException
{
	FileInputStream fispro=new FileInputStream(fileinputpath);
	Properties prop=new Properties();
	prop.load(fispro);
	fispro.close();
}
/**
 * this method is used to fetch the data from property file based on the key
 * @param key
 * @return
 */
public String getpropertyfiledata(propertkeys key)
{
	String keystring = key.name().toUpperCase();
	String value = prop.getProperty(keystring,"plese give proper key"+keystring+" ").trim();
	return value;

}
public void closeproperty()
{
	try {
		fispro.close();
	} catch (IOException e) 
	{
		
	}
}

}
