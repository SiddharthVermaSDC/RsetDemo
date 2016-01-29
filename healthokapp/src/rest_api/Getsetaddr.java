package rest_api;

import java.sql.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.PreparedStatement;


@Path("/address") 
public class Getsetaddr  {
	
	Dbcon a=new Dbcon();
	
	// method for inserting new address
    @Path("/insert")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertAddress(Adrs st)	
	{  
    	a.createConnection();
    	//System.out.println("id="+st.id);
    	//String s="select s_id from student where name=?;";
    	String s1="insert into Address values(0,?,?,?,?,?);";
    	try
    	{
    	a.ps=(PreparedStatement) a.Con.prepareStatement(s1);
    	a.ps.setString(1,st.address1);
        a.ps.setString(2, st.address2);
        a.ps.setString(3, st.address3);
    	a.ps.setInt(4,st.cityid);
    	a.ps.setString(5, st.pincode);
    	a.ps.executeUpdate();
    	
    	}
    	
    catch(SQLException e)
		{ 
			System.out.println(e);
			  return"something wrong";
		}
	
	          return "inserted";
	}
    
  // method to update address
    @Path("/update")
    @POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateAddress(Adrs st)	
	{  
    	a.createConnection();
    	//System.out.println("id="+st.id);
    	//String s="select s_id from student where name=?;";
    	String s1="insert into student values(0,?,?,?,?,?);";
    	try
    	{
    	a.ps=(PreparedStatement) a.Con.prepareStatement(s1);
    	a.ps.setString(1,st.address1);
        a.ps.setString(2, st.address2);
        a.ps.setString(3, st.address3);
    	a.ps.setInt(4,st.cityid);
    	a.ps.setString(5, st.pincode);
    	a.ps.executeUpdate();
    	
    	}
    	
    catch(SQLException e)
		{ 
			System.out.println(e);
			  return"something wrong";
		}
    	return "inserted";
	}
    	 
    // method to send address to frontend
        @Path("/update")
        @POST
    	@Consumes(MediaType.TEXT_PLAIN)
    	@Produces(MediaType.APPLICATION_JSON)
    	public String sendAddress(String  s)	
    	{   Adrs q=new Adrs();
        	a.createConnection();
        	String n="select * from address where address id=;";
        	try
        	{  a.ps=(PreparedStatement) a.Con.prepareStatement(n);
        	   a.ps.setInt(1,returnAddressid(s));
        	   a.rs=a.ps.executeQuery();
        	   a.rs.next();
        	   q.address1=a.rs.getString("AddressLine1");
        	   q.address1=a.rs.getString("AddressLine2");
        	   q.address1=a.rs.getString("AddressLine3");
        	   q.address1=a.rs.getString("PinCode");
        }
        	
        catch(SQLException e)
    		{ 
    			System.out.println(e);
    			  return"something wrong";
    		}   	
	
	          return "inserted";
	}


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
	}
}
