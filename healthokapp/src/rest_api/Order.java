package rest_api;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




@Path("/order")
public class Order {

	@Path("/1/{UserId}/{commnent}/{image}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static model.Result order(@PathParam("UserId") int userid){
		model.Order order=new model.Order();
		model.Result result=new model.Result();
		order.setUserId(userid);
		order.setTax(tax);
		order.setShippingcost(shcost);
		order.setStatus(1);
		String add=dal.Address.getAddressById(addid);
		order.setAddress(add);
		result.setStatus(biz.Order.sendOrder(order, username));
		return result;
		
	}
	
	@Path("/2/{UserId}/{Description}/{Image}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public static model.Order getOrderedItems(@PathParam("orderid") int orderid){
		model.Order order=new model.Order();
		order=dal.Order.getOrderDetail(orderid);
		return order;
		
		
	}
}