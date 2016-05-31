package rest_api;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
//import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//import model.Result;


@Path("/laborderdetails")

public class Laborderdetails {
	
	@Path("/placeorder")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public model.Result laborderdetails(ArrayList<model.LabOrderDetail> labOrderDetails) {
		model.Result res = new model.Result();
		res.setStatus(new biz.LabOrderDetails().placeLabOrderdetails(labOrderDetails));
		// ADD BIZ METHOD TO GET THE ARRAY LIST AND DO INSERT / UPDATE BASED ON
		// IF MedicineOrderDetailId > 0
		// EXACT SAME LOGIC IS NEEDED FOR LAB ORDERS
		// res.setStatus(dal.MedicineOrderDetails.insertMedicineOrderDetails(morder));
		return res;
	}
	
	@Path("/update/{LabOrderId}/{ResultImage}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static model.Result updatelaborder(@PathParam("LabOrderId") int laborderid,@PathParam("ResultImage") String image){
		model.ImageData image1 = new model.ImageData(3,image);
		
		int resultimageid = dal.ImageData.imageupload(image1);
		
	    model.Result res=new model.Result();
	
	
//	 res.setStatus(biz.Laborder.updateResultLabOrder(laborderid,resultimageid));
	 return res;
	}	
	 // deleting laborderdetails healthok
	
	// CHANGE THIS TO A POST. NEED SIMILAR METHOD FOR MEDICIENORDERDETAIL
	@Path("/delete/{LabOrderId}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public  model.Result deletelaborder(@PathParam("LabOrderId") int laborderid){
		
	    model.Result res=new model.Result();
	
	
	 res.setStatus(biz.LabOrderDetails.deleteLabOrder(laborderid));
	 return res;
	}	
	
	
	
  // updating info laborderdetails by healthok
	
// PROBABLY NOT NEEDED.
	
	@Path("/update/{LabOrderId}/{TestName}/{Price}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static model.Result updatelaborder(@PathParam("LabOrderId") int laborderid,@PathParam("TestName") String testname,@PathParam("Price") float price){
	model.LabOrderDetail labOrderDetail=new model.LabOrderDetail();
	model.Result res=new model.Result();
	
	labOrderDetail.setLaborderId(laborderid);
	labOrderDetail.setTestname(testname);
	labOrderDetail.setPrice(price);
    res.setStatus(biz.LabOrderDetails.updateLabOrder(labOrderDetail));
	 return res;
	}	
	

	
}
