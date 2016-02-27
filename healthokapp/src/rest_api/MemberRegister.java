package rest_api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

@Path("/MemberRegistration")
public class MemberRegister 
{
	
	@Path("/register")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String register(String g)
	{
		Connection connection = null;
	     Statement statement = null;
	     ResultSet resultset = null;
	     PreparedStatement preparedstatement=null;
		try {
			JSONObject json = new JSONObject(g);
			connection = DatabaseConnectivity.getInstance().getConnection();
      	  	String  query2="insert into user(MemberID,FirstName,LastName,Mobile,EmailId,AddressLine1,AddressLine2,CityId,PinCode,DoctorsGenerallyVisited,MembershipTypeId,Comments)"
      	  			
      	  			+ " values(\""
      	  			 +json.getString("MemberID")+"\",\""
					 +json.getString("FirstName")+"\",\""
					 +json.getString("LastName")+"\",\""
					 +json.getInt("Mobile")+"\",\""
					 +json.getString("EmailId")+"\",\""
					 +json.getString("AddressLine1")+"\",\""
					 +json.getString("AddressLine2")+"\",\""
					 +json.getInt("CityId")+"\",\""
					 +json.getString("PinCode")+"\",\""
					 +json.getString("DoctorsGenerallyVisited")+"\",\""
					 +json.getString("MembershipTypeId")+"\",\""
	    	 		 +json.getString("OtherCare")+"\");";
			
      	  	 System.out.println(query2);
			 preparedstatement =(PreparedStatement)connection.prepareStatement(query2);	 
			 preparedstatement.executeUpdate();
			 
			 
			 
			 
			  return "You are Registered!"; 
	     }
	     catch(Exception e)
	     {
	    	 return e.getMessage();
	     }
		 //return "You are not Registered!";	 
	}
	
	/*public static void main(String arg[])
	{
		MemberRegister mr=new MemberRegister();
		String g=
			"{
					  "firstName" : "1",
					  "lastName" : "1",
					  "phone" : "1",
					  "memberEmail" : "1",
					  "addressLine1" : "1",
					  "addressLine2" : "1",
					  "city" : "1",
					  "state" : "1",
					  "pin" : "1",
					  "country" : "1",
					  "doctorVisit" : "1",
					  "labTest" : "1",
					  "longCare" : "1",
					  "otherCare" : "1"
					  "family" : [{
					  "name" : "a",
					  "age" : "a",
					  "bloodGroup" : "a",
					  "allergies" : "a",
					  "medicalCondition" : "a",
					  "currentMedicalCondition" : "a",
					  "familyId" : "A"
					}]
					}";
		mr.register(g);
	}*/
}
