package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class fetch_data_fromdb {

	public static void main(String[] args) throws SQLException 
	{
Driver databdriver=new Driver();
DriverManager.registerDriver(databdriver);
Connection conn=null;
 try {
 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SDET46", "root", "root");
	Statement state = conn.createStatement();
	ResultSet resu = state.executeQuery("select* from states");
	while(resu.next())
	{
		int country = resu.getInt(3);
		String coun = resu.getString(2);
		System.out.println(country+" "+coun);
	}
	
} 
 finally 
 {
	conn.close();
}

	}

}
