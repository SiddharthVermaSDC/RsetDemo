package rest_api;

import java.util.ArrayList;

//import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Hospital")
public class Hospital {

	@Path("/{HospitalId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public model.Hospital getHospital(@PathParam("HospitalId") int hospitalId) {
		return new biz.HospitalRetrival().responseHospital(hospitalId);
	}

	// for Retrieving all Hospitals Data
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public  ArrayList<model.Hospital> getHospitals() {
		ArrayList<model.Hospital> hospitals = null;
		hospitals = new biz.HospitalRetrival().allHospitals();
		return hospitals;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static model.Result hospital(model.Hospital hospital) {
		model.Result rs = new model.Result();
		int result = biz.Hospital.addHospital(hospital);
		rs.setStatus(result);
		return rs;

	}

	@Path("/{hospitalId}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static model.Result hospitalUpdate(@PathParam("hospitalId") int id, model.Hospital hsptl1) {
		model.Result rs = new model.Result();
		// hsptl1.setHospitalId(id);
		int result = biz.HospitalUpdate.updateHospital(hsptl1, id);
		rs.setStatus(result);
		return rs;
	}

}
