package rest_api;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/users")
public class User {
	
	//@Path("/all")
	//@POST
	//@Consumes(MediaType.APPLICATION_JSON)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public ArrayList<model.UserFull> allUsers()
	{
		return new biz.User().getAllUsers();
	}
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public model.UserFull userDetail(@PathParam("id") String id)
	{
			return new biz.User().getUserDetails(Integer.parseInt(id));
	}
	
	
	@Path("/{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public  model.Result update(@PathParam("id") int userid, model.UserFull user) {
		model.Result rs = new model.Result();
		int rsult = biz.UpdateUser.update(user, userid);
		rs.setStatus(rsult);
		return rs;
		
		
	}
	

}
	
	
