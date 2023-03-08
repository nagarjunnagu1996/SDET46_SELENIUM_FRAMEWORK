package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class validata_present_in_db {

	public static void main(String[] args) throws SQLException 
	{
	Driver dbdriver=new Driver();
	DriverManager.registerDriver(dbdriver);
	Connection conne=null;
	try {
	 conne = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
	Statement state = conne.createStatement();
	ResultSet res = state.executeQuery("select * from project where created_by='arjun'");
	while(res.next())
	{
		String created = res.getString("created_by");
		String projectid = res.getString("project_id");
		String created_date = res.getString("created_on");
		String status = res.getString("status");
		String tsize = res.getString("team_size");
		System.out.println(created+"  "+projectid+"    "+created_date+"    "+status+"    "+tsize);
	}
	}
	finally {
	conne.close();

	}
	}

}
