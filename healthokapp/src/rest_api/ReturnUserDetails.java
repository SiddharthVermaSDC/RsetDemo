package rest_api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dal.Database;
import model.GetSetMemberRegistration;
import util.Logging;

@Path("/ReturnUserDetails")
public class ReturnUserDetails {
	
	/*Connection connection = null;
    Statement statement = null;
    ResultSet resultset = null;
    PreparedStatement preparedStatement=null;
	*/
	
	@Path("/userDetails/{id}")
	//@POST
	//@Consumes(MediaType.APPLICATION_JSON)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public model.UserFull returnDetail(@PathParam("id") String id)
	{
		
		Logging.Debug("RESTAPI", ""+Integer.parseInt(id));
		return new biz.User().getUserDetails (Integer.parseInt(id));
		
		
	}
}
	
	
	
	
	
	
	/*
	public String userDetails(GetSetMemberRegistration userId) 
	{
		 JSONArray arr;
		 JSONObject uj,ju,error = null;
		 /*Connection connection = null;
	       Statement statement = null;
	       ResultSet resultset = null;
	       PreparedStatement preparedStatement=null;
		 
		 
		 
		 
	     GetSetMemberRegistration gss=new GetSetMemberRegistration();
	     String query1,query2;
	     try
	     {
	    	 uj = new JSONObject();
	    	 ju = new JSONObject();
	    	 error = new JSONObject();
	    	 arr = new JSONArray();
	   	     error.put("error","-1");
			 
	    	 connection=Database.createConnection();		 
			 query1="Select * from User where UserId="+userId.getUserId()+";";
			 query2="Select * from MemberDetails where UserId="+userId.getUserId()+";";
			 
			 preparedStatement = (PreparedStatement)connection.prepareStatement(query1);
			 resultset=preparedStatement.executeQuery();
			 
			 if(resultset.next()==true)
			 {
				 uj.put("UserId", resultset.getInt("UserId"));
				 uj.put("MemberID",resultset.getString("MemberID"));
				 uj.put("MembershipTypeId",resultset.getInt("MembershipTypeId"));
				 uj.put("FirstName",resultset.getString("FirstName"));
				 uj.put("LastName", resultset.getString("LastName"));
				 //uj.put("AddressId", resultset.getInt("AdressId"));
				 uj.put("EmailId",resultset.getString("EmailId"));
				 uj.put("Mobile",resultset.getString("Mobile"));
				 uj.put("Password",resultset.getString("Password"));
				 uj.put("PrimaryDoctor",resultset.getInt("PrimaryDoctor"));
				 //uj.put("DoctorGenerallyVisited", resultset.getString("DoctorGenerallyVisited"));
				 uj.put("Comments",resultset.getString("Comments"));
				 uj.put("PrepaidBalance",resultset.getInt("PrepaidBalance"));
				 //uj.put("CashBousBalance", resultset.getInt("CashBousBalance"));
				 uj.put("TotalDiscount",resultset.getInt("TotalDiscount"));
				 uj.put("AddressLine1",resultset.getString("AddressLine1"));
				 uj.put("AddressLine2",resultset.getString("AddressLine2"));
				 uj.put("AddressLine3",resultset.getString("AddressLine3"));
				 uj.put("CityId",resultset.getInt("CityId"));
				 uj.put("PinCode",resultset.getString("PinCode"));
				 
				// preparedStatement=null;
				 
				 preparedStatement = (PreparedStatement)connection.prepareStatement(query2);
				 resultset=preparedStatement.executeQuery();
			 
				 while(resultset.next()==true)	
				 {
					 ju.put("MemberdetailId", resultset.getInt("MemberdetailId"));
					 ju.put("UserId", resultset.getInt("UserId"));
					 ju.put("FirstName", resultset.getString("FirstName"));
					 ju.put("LastName", resultset.getString("LastName"));
					 ju.put("Sex", resultset.getString("Sex"));
					 ju.put("DOB", resultset.getString("DOB"));
					 ju.put("BloodGroup", resultset.getString("BloodGroup"));
					 ju.put("Diabetic", resultset.getInt("Diabetic"));
					 ju.put("BP", resultset.getInt("BP"));
					 ju.put("HeartProblems", resultset.getInt("HeartProblems"));
					 ju.put("Allergies", resultset.getString("Allergies"));
					 ju.put("recurringTests", resultset.getString("recurringTests"));
					// ju.put("LongtermCareNeed", resultset.getString("LongtermCareNeed"));
					 ju.put("Comments", resultset.getString("Comments"));
					 ju.put("CityId", resultset.getInt("CityId"));

					 arr.put(ju);
				 }
				 
				 uj.put("Family", arr);
			 }
			 else
			 {
				 return error.toString();
			 }
			 
			 return uj.toString();
			 
	     }
	     
	     catch(Exception e)
	     {    
	    	 util.Logging.Debug("Return User Details", e.getMessage());
	    	 return e.getMessage();
	     }
	     finally 
	     { Database.closeConnection(connection);   }
	     
	     }
	     
	}
*/
