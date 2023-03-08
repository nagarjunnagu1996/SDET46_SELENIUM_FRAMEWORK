package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBC_acticity {

	public static void main(String[] args) throws SQLException
	{
		Connection connect=null;
		try {
	Driver dbdriver= new Driver();
	DriverManager.registerDriver(dbdriver);
	connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/SDET46", "root", "root");
	Statement statem = connect.createStatement();
	ResultSet res = statem.executeQuery("select* from employee");
	while(res.next())
	{
		String emp_name = res.getString(2);
		System.out.println(emp_name);
		
	}
		}
		finally {
			
	connect.close();
	}
	}

}
