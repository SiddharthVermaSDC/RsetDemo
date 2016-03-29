package rest_api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Hospital")
public class HospitalUpdate {

	@Path("/Update/{hospitalId}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static model.Result hospitalUpdate(@PathParam("hospitalId") int id, model.Hospital hsptl1) {
		model.Result rs = new model.Result();
		// hsptl1.setHospitalId(id);
		int result = biz.HospitalUpdate.updateHospital(hsptl1);
		rs.setStatus(result);
		return rs;
	}

}
