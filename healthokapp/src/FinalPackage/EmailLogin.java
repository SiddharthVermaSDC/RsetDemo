package FinalPackage;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
@Path("/EmailRegister")
public class EmailLogin 
{
	@Path("/Check")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String loginCheck(GetSetLogin gs)
	{
		  DatabaseConnectivity bb=new DatabaseConnectivity();
		  try {
			bb.conn = DriverManager.getConnection(bb.CONN_STRING,bb.USERNAME,bb.PASSWORD);
		    String query1="select * from login where email=\""+gs.getEmail()+"\"";
		    //String query2="insert into login values(\""+gs.getEmail()+"\",\""+gs.getPassword()+"\");";
		      
			PreparedStatement pstmt1 =(PreparedStatement)bb.conn.prepareStatement(query1);	 
			 bb.rs=pstmt1.executeQuery();
			 if(bb.rs.next()==true)
	    	 {
				 //PreparedStatement pstmt2 =(PreparedStatement)bb.conn.prepareStatement(query2);
				 //pstmt2.executeUpdate();
				 return "yes";
	    	 }
	     }
	     catch(Exception e)
	     {}
		return "no";
	}
}
