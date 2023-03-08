package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class property_file_activity {

	public static void main(String[] args) throws IOException 
	{

		FileInputStream fis=new FileInputStream("./src/test/resources/common_data/commondata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url1 = prop.getProperty("url");
		System.out.println(url1);
		fis.close();
		String browser = prop.getProperty("browser", " ");
		System.out.println(browser);
		prop.clear();




	}

}
