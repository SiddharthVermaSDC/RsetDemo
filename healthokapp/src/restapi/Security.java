package restapi;

import model.Result;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/auth/{username}/{password}") 
//@Path("/auth")
public class Security {

	
	public static int Authenticate ( String username, String password)
	{
		int result = -1;
		
		result = dal.User.ValidateCredentials(username,password);
		
		return result; 	
	}
	
	

	
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static Result AuthenticateJSON ( @PathParam("username") String username, @PathParam("password") String password)
	{
	int result;	
		result = Authenticate (username, password);
		
		if ( result ==1)
		{
			Result res=new Result();
			res.setStatus(5);
			return res;
		}
		else
		{
			Result res=new Result();
			res.setStatus(-5);
			return res;
			
		}
		
	}

}
