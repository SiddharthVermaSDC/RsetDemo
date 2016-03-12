package rest_api;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Doctor")
public class Doctor {

	@Path("/Add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static model.Result doctor(model.Doctor doctor)
	{
	model.Result rs = new model.Result();
	int rsult=biz.Doctor.insertDoctor(doctor);
	System.out.println(doctor.getDoctorRegDate());
	rs.setStatus(rsult);
	return rs;
	}	
/*
	@Path("/{cityId}/{specilityId}/{appointment}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static model.Result appointment(model.Doctor apt)
	{	
		
		return null;
		
	}
	*/
}
