package rest_api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Add")
public class Hospital {

	@Path("/Hospital")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static model.Result hospital(model.Hospital hsptl)
	{	
		model.Result rs=new model.Result();
		int result=biz.Hospital.addHospital(hsptl);
		rs.setStatus(result);
		return rs;
		
	}
}
