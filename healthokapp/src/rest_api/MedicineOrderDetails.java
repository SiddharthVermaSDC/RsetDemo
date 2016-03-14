package rest_api;

import java.util.ArrayList;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/medicineorderdetails")
public class MedicineOrderDetails {
	
	@Path("/placeorder")
	@POST
	@Produces (MediaType.APPLICATION_JSON)
	@Consumes (MediaType.APPLICATION_JSON)
	public static model.Result medicineorderdetails(model.MedicineOrderDetails morder){
	//model.MedicineOrderDetails medicineorderdetails=new model.MedicineOrderDetails();
	model.Result res=new model.Result();
	
	
	 res.setStatus(dal.MedicineOrderDetails.insertMedicineOrderDetails(morder));
	 return res;
	}	
	 @Path("/{medicineorderid}")
		@GET
		@Produces (MediaType.APPLICATION_JSON)
		public static ArrayList<model.MedicineOrderDetails> responseMedicineOrderDetails(@PathParam("medicineorderid") int medicineorderid){
			ArrayList<model.MedicineOrderDetails> add=new ArrayList<model.MedicineOrderDetails>();
		//	add=dal.MedicineOrderDetails.responseMedicineOrderDetails(medicineorderdetailsid);
			
			return add;
		}
	
	
	}
	
	
	
	