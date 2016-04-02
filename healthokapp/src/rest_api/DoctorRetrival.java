package rest_api;

import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/doctor")
public class DoctorRetrival {
	// Searching doctor by name
	@Path("/search/{searchstring}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public  ArrayList<model.Doctor> getDoctor(@PathParam("searchstring") String searchString) {
	
		return new biz.DoctorRetrival().searchDoctor(searchString);
	}

	// searching doctor by speciality
	@Path("/Specialityid/{specialityid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static ArrayList<model.DoctorRetrival> getDoctorBySpeciality(@PathParam("specialityid") int speciality) {
		ArrayList<model.DoctorRetrival> doc1 = new ArrayList<model.DoctorRetrival>();
		doc1 = biz.DoctorRetrival.getDoctorBySpeciality(speciality);
		return doc1;
	}

}
