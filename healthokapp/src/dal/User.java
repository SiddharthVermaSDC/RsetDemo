package dal;


import java.sql.*;

import util.Logging;
import util.StatusCode;





public class User {
	
  

	public static int Save (model.User user)
	{

		 Connection connection=null;
		 PreparedStatement ps=null;
	   ResultSet rs=null;

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

		 Connection connection=null;
		 PreparedStatement ps=null;
	   ResultSet rs=null;

		int result=0;
		String str="select * from user where emailid=? and password=?";
		try
		{
			connection=Database.createConnection();
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
		

		 Connection connection=null;
		 PreparedStatement ps=null;
	   ResultSet rs=null;

		StatusCode result= StatusCode.UnknownError;
		
		String str="update User set GCMToken =? where userid = ?";
		try
		{
			connection=Database.createConnection();
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
		
		 Connection connection=null;
		 PreparedStatement ps=null;
	   ResultSet rs=null;
		
		
		String str="select GCMToken from User where userid = ?";
		String token = null;

		try
		{
			connection=Database.createConnection();
			ps=connection.prepareStatement(str); 
			ps.setInt(1,userId);
			
			Logging.Debug("UserDal", ps.toString());
			 rs = ps.executeQuery(); 
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

	
	public model.User getUser (int userId)
	{
		
		 Connection connection=null;
		 PreparedStatement ps=null;
	   ResultSet rs=null;
		
		
		String str="select * from User where userid = ?";
		String token = null;

		model.User user = null;
		
		try
		{
			connection=Database.createConnection();
			ps=connection.prepareStatement(str); 
			ps.setInt(1,userId);
			
			Logging.Debug("UserDal", ps.toString());
			
			 rs = ps.executeQuery(); 
			
			while (rs.next()) {
				
				user = new model.User(); // since this is query by PK will get only one row. 
				
				user.setUserId(userId);
				user.setFirstName(rs.getString("FirstName"));
				user.setLastName(rs.getString("LastName"));
				user.setEmailId(rs.getString("EmailId"));
				user.setPhone(rs.getString("Mobile"));
				user.setPassword(rs.getString("Password"));
						
			}
			
			Logging.Debug("User-Dal", "user is " + user.getFirstName() + " " + user.getLastName());
		}
		catch(SQLException se)
		{
			Logging.Exception("UserDal-GetToken", se.getMessage());
			return null;
		}
		finally
		{
			Database.closeConnection(connection);
		}
		
		return user;
		
		
	}
	
	}
