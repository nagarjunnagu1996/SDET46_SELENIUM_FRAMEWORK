package com.commonutilities.genericutilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import com.mysql.cj.jdbc.Driver;
/**
 * this class having all common database related utility actions
 * @author nagarjuna m
 *
 */
public class Database_Utilitynew 
{
	Driver dbdriver;
	Connection conne;
	Statement state;
	/**
	 * this method is used to open the database and initialize the connection and statement
	 * @param DBurl
	 * @param DBusername
	 * @param DBpassword
	 * @throws SQLException
	 */
	public Database_Utilitynew(String DBurl,String DBusername,String DBpassword) throws SQLException
	{
		dbdriver=new Driver();
		DriverManager.registerDriver(dbdriver);
		conne = DriverManager.getConnection(DBurl,DBusername,DBpassword);
		state = conne.createStatement();

	}
	/**
	 * this method is used to fetch the data from database OR to do DQL actions
	 * @param querry
	 * @param columname
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<String> getdatafromDB(String querry,String columname) throws SQLException
	{
		ArrayList<String> arlis=new ArrayList<>();
		ResultSet result = state.executeQuery(querry);
		while(result.next())
		{
			arlis.add(result.getString(columname));

		}
		return arlis;
	}
	/**
	 * this method is used to check the data weather present in database or not
	 * @param querry
	 * @param columname
	 * @param expdata
	 * @return
	 * @throws SQLException
	 */
	public boolean validatedatainDB(String querry,String columname,String expdata) throws SQLException
	{
		ArrayList<String> arlis = getdatafromDB(querry, columname);
		boolean flag = false;
		for(String actualdata:arlis)
		{
			if(actualdata.equalsIgnoreCase(expdata))
			{
				flag=true;
				break;
			}
		}
		return flag;
	}
	/**
	 * this method is used to store /update/modify/delete the data in data base
	 * @param querry
	 * @throws SQLException
	 */
	public void setdatainDB(String querry) throws SQLException
	{
		int result = state.executeUpdate(querry);
		if(result==1)
		{
			System.out.println("data added successfully");
		}
	}
	/**
	 * this method is used to close the database comnnection
	 */
	public void closeDB()
	{
		try {
			conne.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("while closing the data base connection we get exception");
		}
	}
}

