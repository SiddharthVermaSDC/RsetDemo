package rest_api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Result;

@Path("/medicineorderdetails")
public class MedicineOrderDetails {
	
	@Path("/{MedicineOrderDetailsId}/{MedicineOrderId}/{MedicineName}/{Dosage}/{Quantity}/{Price}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static model.Result medicineorderdetails(@PathParam("MedicineOrderDetailsId") int medicineorderdetailsid,@PathParam("MedicineOrderId") int medicineorderid,@PathParam("MedicineName") String medicinename,@PathParam("Dosage") String dosage,@PathParam("Quantity") int quantity,@PathParam("Price") int price){
	model.MedicineOrderDetails medicineorderdetails=new model.MedicineOrderDetails();
	model.Result res=new model.Result();
	
	medicineorderdetails.setMedicineOrderDetailsId(medicineorderid);
	medicineorderdetails.setMedicineOrderId(medicineorderid);
    medicineorderdetails.setMedicineName(medicinename);
	medicineorderdetails.setDosage(dosage);
	medicineorderdetails.setQuantity(quantity);
	medicineorderdetails.setPrice(price);
	 res.setStatus(dal.MedicineOrderDetails.insertMedicineOrderDetails(medicineorderdetails));
	 return res;
	}	
	 @Path("/{medicineorderid}")
		@GET
		@Produces (MediaType.APPLICATION_JSON)
		public static ArrayList<model.MedicineOrderDetails> responseMedicineOrderDetails(@PathParam("medicineorderid") int medicineorderid){
			ArrayList<model.MedicineOrderDetails> add=new ArrayList<model.MedicineOrderDetails>();
			add=dal.MedicineOrderDetails.responseMedicineOrderDetails(medicineorderdetailsid);
			
			return add;
		}
	
	
	}
	
	
	
	