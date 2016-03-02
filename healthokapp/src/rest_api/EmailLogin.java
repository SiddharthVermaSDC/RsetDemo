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
		    String query1="select * from User where EmailId=\""+gs.getEmail()+"\" and password=\""+gs.getPassword()+"\"";
		    String query2="select * from User where Mobile=\""+gs.getPhone()+"\" and password=\""+gs.getPassword()+"\"";
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
<<<<<<< HEAD
			 {
				 //cognito.put(gsmr.setUserId(resultSet.getInt("UserId")));
				gsmr.setUserId(resultSet.getInt("UserId"));
				gsmr.setMembershipTypeId(resultSet.getInt("MembershipTypeId"));
				gsmr.setMemberID(resultSet.getString("MemberID"));
				gsmr.setFirstName(resultSet.getString("FirstName"));
				gsmr.setLastName(resultSet.getString("LastName"));
				gsmr.setAddressId(resultSet.getInt("AddressId"));
				gsmr.setEmailId(resultSet.getString("EmailId"));
				gsmr.setPassword(resultSet.getString("Password"));
				gsmr.setMobile(resultSet.getString("Mobile"));
				gsmr.setPrimaryDoctor(resultSet.getInt("PrimaryDoctor"));
				gsmr.setDoctorGenerallyVisited(resultSet.getString("DoctorGenerallyVisited"));
				gsmr.setOtherCare(resultSet.getString("Comment"));
				gsmr.setAddressLine1(resultSet.getString("AddressLine1"));
				gsmr.setAddressLine2(resultSet.getString("AddressLine2"));
				gsmr.setCashBonousBalance(resultSet.getInt("CashBonousBalance"));
				gsmr.setCityId(resultSet.getInt("CityId"));
				gsmr.setPinCode(resultSet.getInt("PinCode"));
				gsmr.setPrepaidBalance(resultSet.getInt("PrepaidBalance"));
				gsmr.setTotalDiscount(resultSet.getInt("TotalDiscount"));
				
				 //mg.setMessage("Logged in successfully! "+id);
			 }

=======
				 mg.setMessage("Logged in successfully!");
>>>>>>> parent of 866520b... commit
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
	{
	    String s="bbb";
		return s;
}
}
