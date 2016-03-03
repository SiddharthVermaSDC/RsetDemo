package rest_api;

//import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//import model.Result;


@Path("/laborderdetails")

public class Laborderdetails {
	
	//create laborder healthok
	
	@Path("/create/{LabOrderId}/{TestName}/{Price}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static model.Result createlaborder(@PathParam("LabOrderId") int laborderid,@PathParam("TestName") String testname,@PathParam("Price") float price){
	model.Laborderdetails laborderdetails=new model.Laborderdetails();
	model.Result res=new model.Result();
	
	laborderdetails.setLaborderId(laborderid);
	laborderdetails.setTestname(testname);
	laborderdetails.setPrice(price);
    res.setStatus(biz.LabOrderDetails.placeLabOrderd(laborderdetails));
	 return res;
	}	
	
	//updating laboder after report image healthok
	
	@Path("/update/{LabOrderId}/{ResultImage}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static model.Result updatelaborder(@PathParam("LabOrderId") int laborderid,@PathParam("ResultImage") String image){
		model.ImageData image1 = new model.ImageData(3,image);
		
		int resultimageid = dal.ImageData.imageupload(image1);
		
	    model.Result res=new model.Result();
	
	
	 res.setStatus(biz.Laborder.updateLabOrder(laborderid,resultimageid));
	 return res;
	}	
	 // deleting laborder healthok
	@Path("/delete/{LabOrderId}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static model.Result deletelaborder(@PathParam("LabOrderId") int laborderid){
		
	    model.Result res=new model.Result();
	
	
	 res.setStatus(biz.LabOrderDetails.deleteLabOrder(laborderid));
	 return res;
	}	
	
  // updating info laborderdetails by healthok
	
	@Path("/update/{LabOrderId}/{TestName}/{Price}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static model.Result updatelaborder(@PathParam("LabOrderId") int laborderid,@PathParam("TestName") String testname,@PathParam("Price") float price){
	model.Laborderdetails laborderdetails=new model.Laborderdetails();
	model.Result res=new model.Result();
	
	laborderdetails.setLaborderId(laborderid);
	laborderdetails.setTestname(testname);
	laborderdetails.setPrice(price);
    res.setStatus(biz.LabOrderDetails.updateLabOrder(laborderdetails));
	 return res;
	}	
	

	
}
