package com.commonutilities.genericutilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.text.DateFormatter;
/**
 * in this class all calender utility methods are present
 * @author nagarjuna m
 *
 */
public class Calender_Utilities 
{
	/**
	 * this method is used to get current date and time
	 * @return 
	 */
	public String getcurrentdatetime()
	{
		SimpleDateFormat date = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		return  date.format(new Date());

	}
	/**
	 * this method is used to get current date
	 * @param pattern
	 * @return
	 */
	public String getcurrentdatetime(String pattern)
	{
		SimpleDateFormat date = new SimpleDateFormat(pattern);
		return date.format(new Date());

	}
	/**
	 * this method os used to get current date with time
	 * @return
	 */
	public Date getsystemdate()
	{
		return new Date();

	}
	/**
	 * by using this method we can get get after date from current date
	 * @param days
	 * @return
	 */
	public String addtocurrentdate(int days)
	{
		SimpleDateFormat sdft = new SimpleDateFormat("dd_MM_yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		return sdft.format(cal.getTime());
	}
	/**
	 * by using this method we can get get before date from current date
	 * days------> we should enter negative value
	 * @param days
	 * @return
	 */
	public String substracttocurrentdate(int days)
	{
		SimpleDateFormat sdft = new SimpleDateFormat("dd_MM_yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		return sdft.format(cal.getTime());
	}
	/**
	 * this method is used to get required before date from specified date
	 * require date should be as in below shown format
	 * dd_MMM_yyyy
	 * @return 
	 */
	public String getrequiredafterdate(String enterreqdate,int days)
	{
		
		SimpleDateFormat df = new SimpleDateFormat("dd_MMM_yyyy");
		Calendar cal = Calendar.getInstance();
		try 
		{
			cal.setTime(df.parse(enterreqdate));

		}
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		cal.add(Calendar.DAY_OF_MONTH,days);
		return	df.format(cal.getTime());

	}
	/**
	 * this method is used to get required after date from specified date
	 * require date should be as in below shown format
	 * dd_MMM_yyyy
	 */
	public String getrequiredpreviousdate(String enterreqdate,int days)
	{
		SimpleDateFormat df = new SimpleDateFormat("DD_MM_yyyy");
		Calendar cal = Calendar.getInstance();
		try 
		{
			cal.setTime(df.parse(enterreqdate));

		}
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		cal.add(Calendar.DAY_OF_MONTH,days);
		return df.format(cal.getTime());
		
	}
	/**
	 * this method is used to convert from month name to month number
	 * please specify the pattern as below specified
	 * MMMM---->month full name
	 * MMM---->month short name
	 * month name should be start with capital letter
	 * @param monthname
	 * @param pattern
	 */
	public int getmonthnumber(String monthname,String pattern)
	{
		int monthnumber=DateTimeFormatter.ofPattern(pattern)
				.withLocale(Locale.ENGLISH).parse(monthname)
				.get(ChronoField.MONTH_OF_YEAR);
		return monthnumber;
	}


}
