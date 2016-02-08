package FinalPackage;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/e1")
public class EmailRegistration {

	@Path("/e2")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String access(GetSetLogin gs)
	{
		String query2;
		try{
		  DatabaseConnectivity bb=new DatabaseConnectivity();
		  bb.conn = DriverManager.getConnection(bb.CONN_STRING,bb.USERNAME,bb.PASSWORD);
		  query2="insert into login values(\""+gs.getEmail()+"\",\""+gs.getPassword()+"\");";
	      PreparedStatement pstmt =(PreparedStatement)bb.conn.prepareStatement(query2);	 
		  pstmt.executeUpdate();
		  return "suc "+gs.getEmail();
	    	}	     
		catch(Exception e)
	     {}
		return "unsuc "+gs.getEmail();
	 }
}