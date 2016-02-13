package FinalPackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
class DatabaseConnectivity
{
	public  final String USERNAME ="root";
	public  final String PASSWORD ="9559287622";
	public   String CONN_STRING ="jdbc:mysql://localhost:3306/myhealthok";
	public  Connection conn = null;
	public  Statement stmt = null;
	public  ResultSet rs=null;
	DatabaseConnectivity()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
	    catch(Exception e){}
	}
}