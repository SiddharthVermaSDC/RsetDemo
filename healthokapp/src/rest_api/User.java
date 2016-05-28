package rest_api;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/users")
public class User {
	
//	@Path("/all")
	//@POST
	//@Consumes(MediaType.APPLICATION_JSON)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public ArrayList<model.UserFull> allUsers()
	{
		
		return new biz.User().getAllUsers();
		
		
	}
}
	
	
