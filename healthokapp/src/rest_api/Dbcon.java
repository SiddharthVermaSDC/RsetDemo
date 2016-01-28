package rest_api;

import java.sql.*;

//import javax.naming.InitialContext;


public class Dbcon
{
	 Connection Con; 
	 ResultSet rs;
	 PreparedStatement ps;
	
	Dbcon()
	{
 Con=null; 
rs=null;
ps=null;
	}

public  void createConnection()
{    int m=0;
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		String host="127.0.0.1";
		String port ="3307";
		String dbname = "healthok";
		String username = "adminuzuSCxp";
		String password = "GQBXVWgreeuA";
				
	
		Con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+dbname,username,password);	}
	catch(SQLException se)
	{
		System.out.println(se);
	}
	catch(ClassNotFoundException cnf)
	{
		System.out.println(cnf);
	}
	//return Con;
}
}