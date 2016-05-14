package rest_api;

//import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Hospital")
public class Hospital {

	@Path("/Add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static model.Result hospital(model.Hospital hospital) {
		model.Result rs = new model.Result();
		int result = biz.Hospital.addHospital(hospital);
		rs.setStatus(result);
		return rs;

	}

}
