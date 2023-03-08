package com.commonutilities.genericutilities;

import java.util.Base64;
import java.util.Map;
import java.util.Random;

public class Java_Utility 
{
	/**
	 * this method is used to generate random number
	 * @param boundryvalue
	 */
public int getrandomnumber(int boundryvalue)
{
	return new Random().nextInt(boundryvalue);
}
/**
 * this method is used to print normal output
 * @param output
 */
public void consoleprint(String output)
{
	System.out.println(output);
}
/**
 * this method is used to print key and value pair
 * @param map
 */
public void consoleprintmap(Map<String, String> map)
{
	System.out.println(map);
}
/**
 * in this method we are using to convert from string to integer value
 * @param Strategy
 * @return
 */
public int parsenumber(String Strategy)
{
	return Integer.parseInt(Strategy);
}
/**
 * in this method we are using to split the string
 * @param s
 * @param strategy
 * @return
 */
public String[] split(String s,String strategy)
{
	return s.split(strategy);
}
public void pausewebaction(long timeout)
{
	try {
		Thread.sleep(timeout);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public String decodestring(String s)
{
	return new String(Base64.getDecoder().decode(s.getBytes()));
}
public String encodestring(String s)
{
	return new String(Base64.getEncoder().encode(s.getBytes()));
}
}
