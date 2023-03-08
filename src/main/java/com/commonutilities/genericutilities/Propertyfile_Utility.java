package com.commonutilities.genericutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Propertyfile_Utility
{
	private Properties pro;
public void initializepropertydata(String filepath)
{
	FileInputStream fisproperty = null;
	try {
		fisproperty = new FileInputStream(filepath);
	}
	catch (FileNotFoundException e)
	{
		e.printStackTrace();
	}
	pro=new Properties();
	try
	{
		pro.load(fisproperty);
	}
	catch (IOException e) 
	{
		e.printStackTrace();
	}
}
public String getpropertydata(String key)
{
	pro.getProperty(key,"").trim();
	return key;
}
}
