package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.commonutilities.genericutilities.ExcelUtilitiesnew;
import com.commonutilities.genericutilities.Framework_Constatnts;

public class dataproviderpractice 
{
@Test(dataProvider = "dataprovide")
public void admintest(String state, String capitalcity,String status)
{
	System.out.println(state+"  "+capitalcity+"  "+status);
	
	
}
@DataProvider
public String[][] dataprovide()
{
	ExcelUtilitiesnew excelutility=new ExcelUtilitiesnew(Framework_Constatnts.EXCEL_FILE_PATH);
	return excelutility.getdatatodataprovider("datas");
}

}
