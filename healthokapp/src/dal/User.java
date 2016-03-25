package dal;


import java.sql.*;

import util.Logging;
import util.StatusCode;





public class User {
	
	static Connection connection=null;
	static PreparedStatement ps=null;
  static ResultSet rs=null;
  

	public static int Save (model.User user)
	{
		int result=-1;
		
		connection=Database.createConnection();
	   String str="insert into User(emailid,firstName,phone,password,lastName) values (?,?,?,?,?)";
	   try
	   {
		   ps=connection.prepareStatement(str);
		   ps.setString(1,user.getEmailId());
		   ps.setString(2,user.getFirstName());
		   ps.setString(3,user.getPhone());
		   ps.setString(4,user.getPassword());
		   ps.setString(5,user.getLastName());
		   int rw=ps.executeUpdate();
		   if(rw>0)
		   {
			  result=1; 
		   }
		   
	   }
	   catch(SQLException se)
	   {
		   
	   }
		finally
		{
			Database.closeConnection(connection);
		}
	return result;
	}
	
	

	public static int ValidateCredentials(String username,String password){
		
		connection=Database.createConnection();
		int result=0;
		String str="select * from user where emailid=? and password=?";
		try
		{
			ps= connection.prepareStatement(str); 
			ps.setString(1,username);
			ps.setString(2,password);
			rs=ps.executeQuery();
			if(rs.next())
			{
				result=1;
			}
			else
			{
				result=-1;
			}
		}
		catch(SQLException se)
		{
			
		}
		finally
		{
			Database.closeConnection(connection);
		}
		return result;
		
	}
	
	public StatusCode RegisterDevice (int userId, String token)
	{
		
		
		connection=Database.createConnection();
		StatusCode result= StatusCode.UnknownError;
		
		String str="update User set GCMToken =? where userid = ?";
		try
		{
			ps=connection.prepareStatement(str); 
			ps.setString(1,token);
			ps.setInt(2,userId);
			
			Logging.Debug("UserDal", ps.toString());
			
			int updateStatus=ps.executeUpdate();
			if(updateStatus > 0)
			{
				result= StatusCode.Success;
			}
			else
			{
				result=StatusCode.Error;
				Logging.Error("UserDal-RegisterDevice", "No rows updated for userid" + userId);
			}
			
			Logging.Debug("USERDAL", "Successfully registered device for userid " + Integer.toString(userId));
		}
		catch(SQLException se)
		{
			Logging.Exception("UserDal-RegisterDevice", se.getMessage());
			result = StatusCode.UnknownError;
		}
		finally
		{
			Database.closeConnection(connection);
		}
		return result;
		
		
	}


	public String GetToken (int userId)
	{
		
		
		connection=Database.createConnection();
		
		String str="select GCMToken from User where userid = ?";
		String token = null;

		try
		{
			ps=connection.prepareStatement(str); 
			ps.setInt(1,userId);
			
			Logging.Debug("UserDal", ps.toString());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) {
				token = rs.getString("GCMToken");
			}
			
			Logging.Debug("User-Dal", "token retreived is " + token);
		}
		catch(SQLException se)
		{
			Logging.Exception("UserDal-GetToken", se.getMessage());
		}
		finally
		{
			Database.closeConnection(connection);
		}
		return token;
		
		
	}

}
