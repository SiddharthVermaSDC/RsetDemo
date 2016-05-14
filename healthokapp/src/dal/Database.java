package dal;
import java.sql.*;


public class Database 
{
ResultSet rs=null;
PreparedStatement ps=null;
public  static  Connection createConnection()
{
	Connection connection=null; 
	try
	{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		// use this when you are connecting to a local database on your laptop
		
		// This is the connection string to use before you deploy to openshift
		

				String host="127.0.0.1"; // with port forwarding or localhost -- This is the host to use when you run using port forwarding
				
		//      String host="127.3.104.130"; // on Openshift
		
		 		String port ="3306";
				String dbname = "healthok";
				String username = "adminuzuSCxp";
				String password = "GQBXVWgreeuA";   
		
		// was trying this but didnt get it working. will need to see how to do this properly
				//
		//Context env = (Context) new InitialContext().lookup("java:comp/env");
//		String host =  context.getInitParameter("server");
//		String port = context.getInitParameter("port");
//		String username = context.getInitParameter("user");
//		String password = context.getInitParameter("password");
//		String dbname = context.getInitParameter("dbname");

//		try {
//			Context env = (Context)new InitialContext().lookup("java:comp/env");
//			String host = (String)env.lookup("server");
//			String port = (String)env.lookup("port");
//			String username = (String)env.lookup("user");
//			String password = (String)env.lookup("password");
//			String dbname = (String)env.lookup("dbname");
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//	}

	
		
		
		connection =DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+dbname,username,password);	}
	catch(SQLException se)
	{
		System.out.println(se);
	}
	catch(ClassNotFoundException cnf)
	{
		System.out.println(cnf);
	}
	return connection;
}

public static void closeConnection(Connection connection) {
	try {
		if (connection != null)
			connection.close();
	} catch (Exception e) {
	}
}

}