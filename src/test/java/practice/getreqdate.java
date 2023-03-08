package practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Locale;

import com.commonutilities.genericutilities.Calender_Utilities;

public class getreqdate {

	public static void main(String[] args)
	{
		
			Calender_Utilities clutility=new Calender_Utilities();
			System.out.println(clutility.getmonthnumber("Jan", "MMM"));
			System.out.println(clutility.getrequiredafterdate("25_05_1996", 6));
		
		}

	}

