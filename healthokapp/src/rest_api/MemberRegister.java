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

import dal.Database;

@Path("/MemberRegistration")
public class MemberRegister 
{
	
	@Path("/register")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message register(String g)
	{      Message m=new Message(); 
	    //   m.setMessage("j");
	    //   m.setStatus(1);
	    //    return m;    
          FinalRegistration  f=new FinalRegistration();
		Connection connection = null;
	     Statement statement = null;
	     ResultSet resultset = null;
	     PreparedStatement preparedstatement=null;
	   		try {
			JSONObject json = new JSONObject(g);
			connection = Database.createConnection();
      	  	String  query2="insert into user(MemberID,FirstName,LastName,Mobile,EmailId,AddressLine1,AddressLine2,CityId,PinCode,DoctorsGenerallyVisited,MembershipTypeId,"
      	  			+ "Password,PrimaryDoctor,PrepaidBalance,CashbackBousBalance,TotalDiscount,Comments)"
      	  			
      	  			+ " values(\""
      	  			 +json.getInt("MemberID")+"\",\""
					 +json.getString("FirstName")+"\",\""
					 +json.getString("LastName")+"\",\""
					 +json.getString("Mobile")+"\",\""
					 +json.getString("EmailId")+"\",\""
					 +json.getString("AddressLine1")+"\",\""
					 +json.getString("AddressLine2")+"\",\""
					 +json.getInt("CityId")+"\",\""
					 +json.getString("PinCode")+"\",\""
					 +json.getString("DoctorsGenerallyVisited")+"\",\""
					 +json.getInt("MembershipTypeId")+"\",\""
					 +json.getString("Password")+"\",\""
					 +json.getInt("PrimaryDoctor")+"\",\""
					 +json.getInt("PrepaidBalance")+"\",\""
					 +json.getInt("CashbackBousBalance")+"\",\""
					 +json.getInt("TotalDiscount")+"\",\""
	    	 		 +json.getString("OtherCare")+"\");";
			
      	  	 System.out.println(query2);
			 preparedstatement =(PreparedStatement)connection.prepareStatement(query2);	 
			 preparedstatement.executeUpdate();
			 
			 
			m=(f.accept(g));
	   }
	     catch(Exception e)
	     {
	    	 m.setStatus(-1);
	    	 m.setMessage(e.getMessage());
	     }
		
		finally 
	     { 
			Database.closeConnection(connection);
			return m;
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
