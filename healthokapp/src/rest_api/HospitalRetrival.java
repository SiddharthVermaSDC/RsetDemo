package rest_api;

import java.util.ArrayList;

//import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Hospital")

// for retrieving whole data on giving hospitalid
public class HospitalRetrival {
	@Path("/Retrieval/{HospitalId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static model.Hospital getHospital(@PathParam("HospitalId") int hospitalId) {
		model.Hospital hospital = null;
		hospital = new biz.HospitalRetrival().responseHospital(hospitalId);
		return hospital;

	}

	// for retrieving all hospitals
	@Path("/Retrieval")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static ArrayList<model.Hospital> getHospitals() {
		ArrayList<model.Hospital> hospitals = null;
		hospitals = new biz.HospitalRetrival().allHospitals();
		return hospitals;
	}

}
