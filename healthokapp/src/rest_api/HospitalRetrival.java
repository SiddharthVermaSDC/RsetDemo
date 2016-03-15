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
	public static ArrayList<model.Hospital> getHospital(@PathParam("HospitalId") String HospitalId) {
		ArrayList<model.Hospital> hosptl = new ArrayList<model.Hospital>();
		hosptl= biz.HospitalRetrival.responseHospital(HospitalId);
		return hosptl;
		
	}

	// for retrieving just the hospital ids in the hospital table
	@Path("/Retrieval")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static ArrayList<model.Hospital> getHospitalId() {
		ArrayList<model.Hospital> hosptl1 = new ArrayList<model.Hospital>();
		hosptl1= biz.HospitalRetrival.responseHospitalId();
		return hosptl1;
	}
	
	
	
}
