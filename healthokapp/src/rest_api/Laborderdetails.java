package rest_api;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Result;


@Path("/laborder")

public class Laborderdetails {
	
	
	@Path("/{LabOrderId}/{TestName}/{Price}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static model.Result createlaborder(@PathParam("LaborderId") int laborderid,@PathParam("TestName") String testname,@PathParam("Price") float price){
	model.Laborderdetails laborderdetails=new model.Laborderdetails();
	model.Result res=new model.Result();
	
	laborderdetails.setLaborderId(laborderid);
	laborderdetails.setTestname(testname);
	laborderdetails.setPrice(price);
     res.setStatus(dal.Laborderdetail.placeLabOrderd(laborderdetails));
	 return res;
	}	
	 @Path("")
		@GET
		@Produces (MediaType.APPLICATION_JSON)
		public static ArrayList<model.MedicineOrderDetails> responseMedicineOrderDetails(@PathParam("medicineorderdetailsid") int medicineorderdetailsid){
			ArrayList<model.MedicineOrderDetails> add=new ArrayList<model.MedicineOrderDetails>();
			add=dal.MedicineOrderDetails.responseMedicineOrderDetails(medicineorderdetailsid);
			
			return add;
	

}
