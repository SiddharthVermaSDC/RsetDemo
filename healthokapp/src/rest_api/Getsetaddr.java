package rest_api;

import java.sql.*;
import java.sql.Connection;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//import com.mysql.jdbc.PreparedStatement;

import dal.Database;


@Path("/address") 
public class Getsetaddr  {
	
	 Connection connection = null;
     Statement statement = null;
     ResultSet resultset = null;
     java.sql.PreparedStatement preparedstatement=null;
	//Dbcon a=new Dbcon();
	public enum Addressof {
	    DOCTOR,HOSPITAL,FAMILY, USER
	   }
	
	
	// method for inserting new address
    @Path("/insert/{adrs}/{userid}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertAddress(Adrs st,@PathParam("adrs") Addressof adrs,@PathParam("userid") int userid)	
	{  
    	try{
    		
    	}
    	catch(Exception e)
    	{ System.out.println(e);
    	}
    	
    	//a.createConnection();
    	//System.out.println("id="+st.id);
    	String s=null;
    	switch(adrs)
    	{ case USER :{ s="user"; break;}
    	  case DOCTOR:{ s="doctor"; break;}
    	  case FAMILY: {s="memberdetails"; break;}
    	  case HOSPITAL:{ s="hospital"; break;}
    	}
    	String s1="update "+s+" set AddressLine1=?,AddressLine2=?,AddressLine3=?,CityId=?,PinCode=? where UserId=?";
    	try
    	{
    	connection = Database.createConnection();		
    	preparedstatement=(PreparedStatement) connection.prepareStatement(s1);
    	preparedstatement.setString(1,st.addressline1);
    	preparedstatement.setString(2, st.addressline2);
    	preparedstatement.setString(3, st.addressline3);
    	preparedstatement.setInt(4,st.cityid);
    	preparedstatement.setString(5, st.pincode);
    	preparedstatement.setInt(6,userid);
    	preparedstatement.executeUpdate();
    	
    
    	}
    	
    catch(Exception e)
		{ 
			System.out.println(e);
			  return s+e.getMessage();
		}
	
	          return "inserted";
	}
    
    /*
 
  // method to update address
    @Path("/update")
    @POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateAddress(Adrs st)	
	{  
    	try{
    		connection = DatabaseConnectivity.getInstance().getConnection();
    	}
    	catch(Exception e)
    	{ System.out.println(e);
    	}
    	String s1="insert into student values(0,?,?,?,?,?);";
    	try
    	{
    	preparedstatement=(PreparedStatement) connection.prepareStatement(s1);
    	preparedstatement.setString(1,st.address1);
    	preparedstatement.setString(2, st.address2);
    	preparedstatement.setString(3, st.address3);
    	preparedstatement.setInt(4,st.cityid);
    	preparedstatement.setString(5, st.pincode);
    	preparedstatement.executeUpdate();
    	
    	}
    	
    catch(SQLException e)
		{ 
			System.out.println(e);
			  return"something wrong";
		}
    	return "inserted";
	}    */
    	 
    // method to send address to frontend
        @Path("/update")
        @POST
    	@Consumes(MediaType.TEXT_PLAIN)
    	@Produces(MediaType.APPLICATION_JSON)
    	public String sendAddress(String  s)	
    	{   Adrs q=new Adrs();
        	//a.createConnection();
        	String n="select * from address where address id=;";
        	try
        	{  connection = Database.createConnection();
        	   preparedstatement=(PreparedStatement) connection.prepareStatement(n);
        	  // preparedstatement.setInt(1,returnAddressid(s));
        	   resultset=preparedstatement.executeQuery();
        	   resultset.next();
        	   q.addressline1=resultset.getString("AddressLine1");
        	   q.addressline2=resultset.getString("AddressLine2");
        	   q.addressline1=resultset.getString("AddressLine3");
        	   q.addressline1=resultset.getString("PinCode");
        }
        	
        catch(Exception e)
    		{ 
    			System.out.println(e);
    			  return"something wrong";
    		}   	
	
	          return "inserted";
	}

/*
 public int returnAddressid(String s)
 {  a.createConnection();
    int k=0;
	String n="select addressid from user where emailid=;";
	try
	{  a.ps=(PreparedStatement) a.Con.prepareStatement(n);
	   a.rs=a.ps.executeQuery();
	   a.rs.next();
	   k=a.rs.getInt("AddressId");
}
	
catch(SQLException e)
	{ 
		System.out.println(e);
		  //return"something wrong";
	}   	
    
	return k;
	}           */
}
