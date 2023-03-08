package practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.commonutilities.genericutilities.Calender_Utilities;
import com.commonutilities.genericutilities.Java_Utility;

public class hiddencredentials 
{
public static void main(String[] args)  
{
Java_Utility javautility=new Java_Utility();//MTIzNDU=
String s="YWRtaW5AZ21haWwuY29t";
String decode = javautility.decodestring(s);
System.out.println(decode);
}
}
