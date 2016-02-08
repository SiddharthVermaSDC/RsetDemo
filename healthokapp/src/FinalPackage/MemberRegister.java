package FinalPackage;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;
//@Path("/MemberRegistration")
public class MemberRegister 
{
	/*
	@Path("/register")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	*/
	public String register(String g)
	{
		try {
			JSONObject json = new JSONObject(g);
			json.getString("firstName");
			DatabaseConnectivity bb=new DatabaseConnectivity();
			bb.conn = DriverManager.getConnection(bb.CONN_STRING,bb.USERNAME,bb.PASSWORD);
		    String  query2="insert into memberregistration values(0,\""
					 +json.getString("firstName")+"\",\""
					 +json.getString("lastName")+"\",\""
					 +json.getInt("phone")+"\",\""
					 +json.getString("memberEmail")+"\",\""
					 +json.getString("addressLine1")+"\",\""
					 +json.getString("addressLine2")+"\",\""
					 +json.getString("city")+"\",\""
					 +json.getString("state")+"\",\""
					 +json.getString("pin")+"\",\""
					 +json.getString("country")+"\",\""
	    	 		 +json.getString("doctorVisit")+"\",\""
	    	 		 +json.getString("labTest")+"\",\""
	    	 		 +json.getString("longCare")+"\",\""
	    	 		 +json.getString("otherCare")+"\");";
			 System.out.println(query2);
		    PreparedStatement pstmt =(PreparedStatement)bb.conn.prepareStatement(query2);	 
			  pstmt.executeUpdate();
			  return "You are Registered!"; 
	     }
	     catch(Exception e)
	     {}
		 return "You are not Registered!";	 
	}
}
