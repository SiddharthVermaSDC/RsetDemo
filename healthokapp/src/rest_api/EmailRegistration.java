package rest_api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.ResultSetMetaData;

import dal.Database;
import dal.DatabaseConnectivity;

@Path("/EmailRegistration")
public class EmailRegistration {

	@Path("/access")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message access(GetSetLogin gs)
	{
		Message mg=new Message();
		Connection connection=null;
		PreparedStatement preparedstatement=null;
		ResultSet resultSet=null;
		String query2;
		if(gs.getPhone()==null )
			mg.setStatus(-1);
			//return "empty";
		
		try{
		  connection = Database.createConnection();
		  String query1="select Mobile from User where Mobile=?";
		  String s1="insert into User(FirstName,LastName,EmailId,Mobile,Password) values("
		  		+ "\""+gs.getFirstName()+"\","+
		  		"\""+gs.getLastName()+"\","+
		  		"\""+gs.getEmail()+"\","+
		  		"\""+gs.getPhone()+"\","+
		  		"\""+gs.getPassword()+"\");";
		    preparedstatement=(PreparedStatement) connection.prepareStatement(query1);
	    	preparedstatement.setString(1,gs.getPhone());
	    	resultSet=preparedstatement.executeQuery();
	    	if(resultSet.next()==true)
	    	{
	    		mg.setStatus(-2);
	    	}
	    	else
	    	{
	    		preparedstatement=null;
	    		preparedstatement=(PreparedStatement) connection.prepareStatement(s1);
	    		preparedstatement.executeUpdate();
	    		mg.setStatus(1);
	    	}
		}
		catch(Exception e)
	     {
			mg.setStatus(-3);
	     }
		
		
		 finally 
	     { 
			 Database.closeConnection(connection); 
	         return mg;   
	      }
	     
	     }
	 }
