package rest_api;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Hospital")
public class Hospital {

	@Path("/Add")
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
	/*
	@Path("/{hospitalId}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static model.Result hospitalUpdate(@PathParam("hospitalId") int id, model.Hospital hsptl1)
	{	
		model.Result rs1=new model.Result();
	//	hsptl1.setHospitalId(id);
		int result1=biz.Hospital.updateHospital(hsptl1,id);
		rs1.setStatus(result1);
		return rs1;
	}           */
}
