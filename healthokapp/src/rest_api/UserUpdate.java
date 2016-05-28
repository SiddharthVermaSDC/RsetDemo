package rest_api;
import javax.ws.rs.Consumes;
//import javax.ws.rs.GET;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/UserUpdate")
public class UserUpdate {

	@Path("/{userid}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static model.Result update(@PathParam("userid") int userid, model.UserFull user) {
		model.Result rs = new model.Result();
		int rsult = biz.UpdateUser.update(user, userid);
		rs.setStatus(rsult);
		return rs;
		
		
	}
	

}
