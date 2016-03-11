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

	@Path("/DoctorUpdate")
	public class UpdateDoctor {

		@Path("/{var}")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public static model.Result update(@PathParam("var") int var,model.Doctor doctor)
		{
		model.Result rs = new model.Result();
		int rsult=biz.UpdateDoctor.update(doctor,var);
		System.out.println(doctor.getDoctorRegDate());
		rs.setStatus(rsult);
		return rs;
		}	

		
		
	}
