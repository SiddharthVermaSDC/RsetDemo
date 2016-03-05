package rest_api;



import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("/profile")
public class test {
	@Path("/{userid}")
  @GET
  @Consumes (MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public static ArrayList<GetSetMemberRegistration> details(@PathParam("userid") int id)
	{    
		Connection connection = null;
		  PreparedStatement preparedStatement=null;
		  ArrayList<GetSetMemberRegistration> memberdetails=new ArrayList<GetSetMemberRegistration>();
		  ResultSet resultSet=null;
		  try {
				connection = DatabaseConnectivity.getInstance().getConnection();
			    String query1="select * from User where UserId=\""+id+"\"";
			    
			    
			    	preparedStatement =(PreparedStatement)connection.prepareStatement(query1);
			    	 resultSet=preparedStatement.executeQuery();
					while(resultSet.next()){
			        int user=resultSet.getInt("UserId");
			        String house=resultSet.getString("housenumber");
			        String street=resultSet.getString("Street");
			       String city=resultSet.getString("City");
			        String state=resultSet.getString("State");
			        String country=resultSet.getString("Country");
			       String pin=resultSet.getString("pincode");
			        int addid=resultSet.getInt("AddressId");
			        String fname=resultSet.getString("fullname");
			        String phone=resultSet.getString("phone");
			        //memberdetails.add(new model.Address(house, street, city, state, country, pin, addid, user, fname, phone));
			        
					}
		     }
		     catch(Exception e)
		     {
		    	 System.out.println(e);
		     }
		return memberdetails;
    }

}