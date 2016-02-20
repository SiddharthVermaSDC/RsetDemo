package rest_api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.ResultSetMetaData;

@Path("/EmailRegistration")
public class EmailRegistration {

	@Path("/access")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message access(GetSetLogin gs)
	{
		Message mg=new Message();
		Connection connection=null;
		PreparedStatement preparedstatement=null;
		ResultSet resultSet=null;
		String query2;
		if(gs.getPhone()==null );
			//return "empty";
		
		try{
		  connection = DatabaseConnectivity.getInstance().getConnection();
		  String query1="select Mobile from user where Mobile=?";
		  String s1="insert into user(FirstName,LastName,EmailId,Mobile,Password) values("
		  		+ "\'"+gs.getFirstName()+"\',"+
		  		"\'"+gs.getLastName()+"\',"+
		  		"\'"+gs.getEmail()+"\',"+
		  		"\'"+gs.getPhone()+"\',"+
		  		"\'"+gs.getPassword()+"\');";
		    preparedstatement=(PreparedStatement) connection.prepareStatement(query1);
	    	preparedstatement.setString(1,gs.getPhone());
	    	resultSet=preparedstatement.executeQuery();
	    	if(resultSet.next()==true)
	    	{
	    		mg.setMessage("Already registered");
	    	}
	    	else
	    	{
	    		preparedstatement=null;
	    		preparedstatement=(PreparedStatement) connection.prepareStatement(s1);
	    		preparedstatement.executeUpdate();
	    	   	mg.setMessage("successfully registered "+gs.getEmail());
	    	}	
		}
		catch(Exception e)
	     {
			mg.setMessage("can't register!!!....\nError\n"+ e.getMessage());
	     }
		return mg;
	 }
}