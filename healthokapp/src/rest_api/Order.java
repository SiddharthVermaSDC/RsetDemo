package rest_api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Date;


@Path("/order")
public class Order {

	@Path("/{OrderTypeId}/{UserId}/{comment}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static model.Result order(@PathParam("OrderTypeId") int ordertypeid,@PathParam("UserId") int userid,@PathParam("comment") String comment)
	{
		model.Order order=new model.Order();
		model.Result result=new model.Result();
		order.setUserId(userid);
		switch(ordertypeid)
		{
		case 1:order.setOrderTypeId(1);break;
		case 2:order.setOrderTypeId(2);break;
		case 3:order.setOrderTypeId(3);break;
		case 4:order.setOrderTypeId(4);break;
		default:order.setOrderTypeId(5);
		}
		order.setOrderDescription(comment);
		order.setOrderStatusTypeId(1);
		result.setStatus(biz.Order.sendOrder(order));
		return result;
		
	}
	 @Path("/gt/{OrderId}")
		@GET
		@Produces (MediaType.APPLICATION_JSON)
		public static model.Order responsorder(@PathParam("OrderId") int orderid){
		    //model.Order ord=new model.Order();
			//ord=biz.Order.respondOrder(orderid);
			
			return biz.Order.respondOrder(orderid);
		}
	

	@Path("/s")
	@GET
	@Produces (MediaType.TEXT_PLAIN)
	public String rTurn(){
		
		return "hello second";
	}
	

}