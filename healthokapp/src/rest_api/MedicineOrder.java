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

@Path("/medicineorder")
public class MedicineOrder {
	
	@Path("/{MedicineOrderId}/{OrderId}/{PrescriptionImageId}/{Comments}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static model.Result medicineorder(@PathParam("MedicineOrderId") int medicineorderid,@PathParam("OrderId") int orderid,@PathParam("PrescriptionImageId") int prescriptionimageid,@PathParam("Comments") String comments){
	model.MedicineOrder medicineorder=new model.MedicineOrder();
	model.Result res=new model.Result();
	
	medicineorder.setMedicineOrderId(medicineorderid);
	medicineorder.setOrderId(orderid);
	medicineorder.setPrescriptionImageId(prescriptionimageid);
	medicineorder.setComments(comments);
	 res.setStatus(dal.MedicineOrder.insertMedicineOrder(medicineorder,orderid));
	 return res;
	}	
	 @Path("/{OrderId}")
		@GET
		@Produces (MediaType.APPLICATION_JSON)
		public static ArrayList<model.MedicineOrder> responseMedicineOrder(@PathParam("OrderId") int orderid){
			ArrayList<model.MedicineOrder> add=new ArrayList<model.MedicineOrder>();
			add=dal.MedicineOrder.responseMedicineOrder(orderid);
			
			return add;
		}
	
	
	}
	
	
	
	