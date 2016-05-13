package rest_api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import dal.Database;
import model.GetSetLogin;
import model.GetSetMemberRegistration;
import sun.util.logging.resources.logging;
import util.Logging;

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
	
	public model.UserFull loginCheck1(GetSetLogin gs)
	{     

		return new biz.User().loginCheck(gs);
		  
	}
	
}
	









/*
 * 
 * 
 * 
 * 
 * 
 * 
 * @Path("/s")
	@GET
	@Produces (MediaType.TEXT_PLAIN)
	public String rTurn(){
		
		return "hello 2";
	}
 * 
 * 
 * 
@Path("/Check")
@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public String loginCheck(GetSetLogin gs)
{     String s=null;
	  Connection connection = null;
	  PreparedStatement preparedStatement=null;
	  ResultSet resultSet=null;
	  GetSetMemberRegistration gss=new GetSetMemberRegistration();
	  
	 // model.UserFull uf=new model.UserFull();
	  
	  
	  ReturnUserDetails r=new ReturnUserDetails();
	  JSONObject  error = new JSONObject();
	  
	  try {

			 error.put("UserId","-1");
			 s = error.toString();

		connection = Database.createConnection();
	    String query="select UserId from User where (EmailId=\""+gs.getLoginId()+"\" or Mobile=\""+gs.getLoginId()+"\") and Password=\""+gs.getPassword()+"\";";
	    //String query2="select UserId from User where Mobile=\""+gs.getPhone()+"\" and Password=\""+gs.getPassword()+"\";";
	   //if(gs.getEmail()==null)
	   //{   preparedStatement = (PreparedStatement)connection.prepareStatement(query2);	
	   //}
	   //else
	   //{   preparedStatement =(PreparedStatement)connection.prepareStatement(query1);
	   //}
	   
	    Logging.Debug("Login", query);
	   preparedStatement =(PreparedStatement)connection.prepareStatement(query);
		 resultSet=preparedStatement.executeQuery();

		 if(resultSet.next()==true)
		 {   
			 Logging.Debug("Login","Found matching record " + resultSet.getInt("UserId")  );
			 gss.UserId=resultSet.getInt("UserId");
			// s=r.userDetails(gss);
		       
		 }
		 else
		 {
			 
			 Logging.Debug("Login","Found no matching record for " + query);
			 
		 }
     }
     catch(Exception e)
     {
    		 util.Logging.Debug("Login", e.getMessage());
     }
	  
	
	 finally 
     { 
		 Database.closeConnection(connection); 
      }
	     
	  return s;   
	  
	  
}


*/

