package rest_api;

import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Doctor")
public class DoctorRetrival {
	// Searching doctor by name
	@Path("/Name/{username}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static ArrayList<model.DoctorRetrival> getDoctor(@PathParam("username") String user) {
		String[] temp = new String[3];
		// String delimiter = " ";
		// temp = user.split(delimiter);*/
		StringTokenizer st = new StringTokenizer(user);
		System.out.println("tokens count: " + st.countTokens());
		int count = st.countTokens();
		// iterate through st object to get more tokens from it
		int i = 0;
		while (st.hasMoreElements()) {
			temp[i] = st.nextElement().toString();
			System.out.println("token = " + temp[i]);
			i++;
		}
		ArrayList<model.DoctorRetrival> doc = new ArrayList<model.DoctorRetrival>();
		doc = biz.DoctorRetrival.getDoctor(temp[0], temp[1], temp[2], count);
		System.out.println(temp[0] + temp[1] + temp[2]);
		return doc;
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
