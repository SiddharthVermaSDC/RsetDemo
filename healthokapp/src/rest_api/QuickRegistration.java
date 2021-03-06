package rest_api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Result;

@Path("/QuickEmailRegistration")
public class QuickRegistration {
	
	
	@Path("/Register")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public model.Result quickEmailRegister(model.GetSetLogin gs)
	{
		
		Result result = new Result();
		
		result.setStatus(new biz.User().quickEmailRegister(gs));
		
		return result;
		
	}
	
	
}
	















	/*@Path("/access")
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
		if(gs.getPhone()==null )
			mg.setStatus(-1);
			//return "empty";
		
		try{
			  
			connection = Database.createConnection();

		  String query1="select EmailId, Mobile from User where Mobile=? or EmailId = ?";
		  String s1="insert into User(FirstName,LastName,EmailId,Mobile,Password) values("
		  		+ "\""+gs.getFirstName()+"\","+
		  		"\""+gs.getLastName()+"\","+
		  		"\""+gs.getEmail()+"\","+
		  		"\""+gs.getPhone()+"\","+
		  		"\""+gs.getPassword()+"\");";
		    preparedstatement=(PreparedStatement) connection.prepareStatement(query1);
	    	preparedstatement.setString(1,gs.getPhone());
	    	preparedstatement.setString(1,gs.getEmail());
	    	
	    	resultSet=preparedstatement.executeQuery();
	    	if(resultSet.next()==true)
	    	{
	    		Logging.Debug("QuickRegister", "Email or mobile already exists" + gs.getEmail() + ":"+ gs.getPhone());
	    		mg.setStatus(-2);
	    	}
	    	else
	    	{
	    		preparedstatement=null;
	    		preparedstatement=(PreparedStatement) connection.prepareStatement(s1);
	    		preparedstatement.executeUpdate();
	    		mg.setStatus(1);
	    	}
		}
		catch(Exception e)
	     {
			Logging.Debug("Registration", e.getMessage());
			mg.setStatus(1);
	     }
		
		
		 finally 
	     { 
			 Database.closeConnection(connection); 
 
	      }

		return mg;
	     }
	     */
	