package rest_api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/EmailRegister")
public class EmailLogin 
{
	@Path("/Check")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String loginCheck(GetSetLogin gs)
	{     String s=null;
		  Connection connection = null;
		  PreparedStatement preparedStatement=null;
		  ResultSet resultSet=null;
		  Message mg=new Message();
		  GetSetMemberRegistration gss=new GetSetMemberRegistration();
		  ReturnUserDetails r=new ReturnUserDetails();
		  JSONObject  error = new JSONObject();
		  
		  try {
			connection = DatabaseConnectivity.getInstance().getConnection();
		    String query1="select UserId from User where EmailId=\""+gs.getEmail()+"\" and Password=\""+gs.getPassword()+"\";";
		    String query2="select UserId from User where Mobile=\""+gs.getPhone()+"\" and Password=\""+gs.getPassword()+"\";";
		   if(gs.getEmail()==null)
		   {   preparedStatement = (PreparedStatement)connection.prepareStatement(query2);	
		   }
		   else
		   {   preparedStatement =(PreparedStatement)connection.prepareStatement(query1);
		   }
			 resultSet=preparedStatement.executeQuery();

			 if(resultSet.next()==true)
			 {   
				 gss.UserId=resultSet.getInt("UserId");
				 s=r.userDetails(gss);
			     return s; 
				   
			 }
			 else{
				 error.put("error","-1");
			     return error.toString();     }
	     }
	     catch(Exception e)
	     {
	    	 try{
	    	      error.put("error","-500");
	    	      return error.toString();
	    	     }
	    	 catch(Exception e1)
	    	 {   return " {\"error\":\"-100\"}" ;
	    	    }
	     }
		  
		
		 finally 
	     { 
			 DatabaseConnectivity.closeDatabase(connection); 
	      }
	//	return s;
	}
	
	
	
	/*
	
	@Path("/PathCheck/{email}/{password}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message loginCheck(@PathParam("email") String email,@PathParam("password") String password)
	{
		  Connection connection = null;
		  PreparedStatement preparedStatement=null;
		  ResultSet resultSet=null;
		  Message mg=new Message();
		  try {
			connection = DatabaseConnectivity.getInstance().getConnection();
		    String query1="select UserId from User where EmailId=\""+email+"\" and password=\""+password+"\"";
		    //String query2="select UserId from User where Mobile=\""+phone()+"\" and password=\""+password()+"\"";
		   //if(gs.getEmail()==null)
		  // {
			  // preparedStatement = (PreparedStatement)connection.prepareStatement(query2);	
		  // }
		   //else
		   {
			   preparedStatement =(PreparedStatement)connection.prepareStatement(query1);
		   }
			 resultSet=preparedStatement.executeQuery();

			 if(resultSet.next()==true)
			 {
				 mg.setStatus(1);
			 }
			 else
				 mg.setStatus(-1);
	     }
	     catch(Exception e)
	     {
	    	 mg.setStatus(500);
	     }
		  
		  finally 
		     { 
				 DatabaseConnectivity.closeDatabase(connection); 
		         return mg; 
		      }
	}
	*/
	
	
	@Path("/s")
	@GET
	@Produces (MediaType.TEXT_PLAIN)
	public String rTurn(){
		
		return "hello second latest new with pom";
	}
	          
	
	
}
