package rest_api;



//THIS CODE IS NOT NEEDED AND COULD BE DELETED.

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
//import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/laborder")
public class LabOrder {
	
	  //pending laborder
	@Path("/pendinglaborder")
	@GET
	//@POST
	@Produces (MediaType.APPLICATION_JSON)
	public static ArrayList<model.Laborder> pendinglaborder(){
		ArrayList<model.Laborder> add=new ArrayList<model.Laborder>();
		add=biz.Laborder.pendingLabOrders();
		
		return add;
		
	}	
	
	// delete laborder
	@Path("/delete/{OrderId}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static model.Result deletelaborder(@PathParam("OrderId") int orderid){
		
	    model.Result res=new model.Result();
	
	
//	 res.setStatus(biz.Laborder.deleteLabOrder(orderid));
	 return res;
	}	
	
   
}
