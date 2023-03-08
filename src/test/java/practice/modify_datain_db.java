package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class modify_datain_db {

	public static void main(String[] args)  
	{
		Connection conn=null;
		try{
				Driver batabdriver =new Driver();
			DriverManager.registerDriver(batabdriver);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SDET46", "root", "root");
			Statement state = conn.createStatement();
			int resu = state.executeUpdate("insert into states values('goa','india',1,90,940,'panajin');");
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
				System.out.println("database is closed");
			} 
			
	}
	
}



