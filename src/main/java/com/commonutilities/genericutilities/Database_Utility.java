package com.commonutilities.genericutilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Database_Utility 
{
	public void fetchdatafromdb(String DBSERVER,String DBUSERNAME,String DBPASSWORD,String querry,String column_index) throws SQLException
	{
	Driver databdriver=new Driver();
	DriverManager.registerDriver(databdriver);
	Connection conn=null;
	 try {
	 conn = DriverManager.getConnection(DBSERVER, DBUSERNAME, DBPASSWORD);
		Statement state = conn.createStatement();
		ResultSet resu = state.executeQuery(querry);
		while(resu.next())
		{
			int country = resu.getInt(3);
			String coun = resu.getString(column_index);
			System.out.println(country+" "+coun);
		}
		
	} 
	 finally 
	 {
		conn.close();
	}
}
	
	public void updatedtaintodb(String DBSERVER,String DBUSERNAME,String DBPASSWORD,String querry)
	{
		Connection conn=null;
		try{
				Driver batabdriver =new Driver();
			DriverManager.registerDriver(batabdriver);
			conn = DriverManager.getConnection(DBSERVER,DBUSERNAME,DBPASSWORD);
			Statement state = conn.createStatement();
			int resu = state.executeUpdate(querry);
			if(resu==1)
			{
				System.out.println("data inserted successfully");
			}
			}
		catch(Exception e)
		{
			System.out.println("exception is handaled");
		}
		finally 
			
		  
			{
				try {
					conn.close();
				} catch (Exception e)
				{
					
				}
				
			} 
			
	}
}