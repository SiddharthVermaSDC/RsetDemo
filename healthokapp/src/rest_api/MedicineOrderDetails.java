package rest_api;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import util.Logging;

@Path("/medicineorderdetails")
public class MedicineOrderDetails {

	@Path("/placeorder")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public model.Result medicineorderdetails(ArrayList<model.MedicineOrderDetails> medicineOrderDetails) {
		model.Result res = new model.Result();
		res.setStatus(new biz.MedicineOrderDetails().medicineOrderDetail(medicineOrderDetails));
		return res;
	}

	@Path("/{medicineorderid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static ArrayList<model.MedicineOrderDetails> responseMedicineOrderDetails(
			@PathParam("medicineorderid") int medicineorderid) {

		return new biz.MedicineOrderDetails().responseMedicineOrderDetails(medicineorderid);

	}

}
