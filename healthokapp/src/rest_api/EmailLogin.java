package rest_api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
@Path("/EmailRegister")
public class EmailLogin 
{
	@Path("/Check")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message loginCheck(GetSetLogin gs)
	{
		  Connection connection = null;
		  PreparedStatement preparedStatement=null;
		  ResultSet resultSet=null;
		  Message mg=new Message();
		  try {
			connection = DatabaseConnectivity.getInstance().getConnection();
		    String query1="select * from user where EmailId=\""+gs.getEmail()+"\" and password=\""+gs.getPassword()+"\"";
		    String query2="select * from user where Mobile=\""+gs.getPhone()+"\" and password=\""+gs.getPassword()+"\"";
		   if(gs.getEmail()==null)
		   {
			   preparedStatement = (PreparedStatement)connection.prepareStatement(query2);	
		   }
		   else
		   {
			   preparedStatement =(PreparedStatement)connection.prepareStatement(query1);
		   }
			 resultSet=preparedStatement.executeQuery();
			 if(resultSet.next()==true)
				 mg.setMessage("Logged in successfully!");
			 else
				 mg.setMessage("New User. Please register first.");
	     }
	     catch(Exception e)
	     {
	    	 mg.setMessage(e.getMessage());
	     }
		return mg;
	}
	
	@Path("/msg")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMethod()
<<<<<<< HEAD
	{
		return "hgkjh";
=======
	{String s="bbb";
		return s;
>>>>>>> origin/master
	}
}
