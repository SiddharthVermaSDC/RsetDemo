package rest_api;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import util.StatusCode;


@Path("/order")
public class Order {

	@Path("/new")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	// new order needs the following fields
	// userId, orderType, fulfillDate, description, image, doctorId
	public model.Result placeOrder(model.OrderBase order)
	{
		model.Result result=new model.Result();
		biz.Order orderBiz = new biz.Order();
	
		StatusCode status = orderBiz.createOrder(order);
		
		result.setStatus(status.getStatusCode());
		
		return result;
		
	}
	
	

	@Path("/setStatus")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	// new order needs the following fields
	// userId, orderType, fulfillDate, description, image, doctorId
	public model.Result setOrderStatus(model.OrderBase order)
	{
		model.Result result=new model.Result();
		biz.Order orderBiz = new biz.Order();
	
		StatusCode status = orderBiz.setOrderStatus(order);
		
		result.setStatus(status.getStatusCode());
		
		return result;
		
	}
	

	
	
	
	
	 @Path("/fetch/{OrderId}")
		@GET
		@Produces (MediaType.APPLICATION_JSON)
		public  model.Order responsorder(@PathParam("OrderId") int orderid){
			return new biz.Order().respondOrder(orderid);
		}
	

	 
	 @Path("/getuserorders/{userId}")
		@GET
		@Produces (MediaType.APPLICATION_JSON)
		public  ArrayList<model.OrderBase> getOrdersForUser (@PathParam("userId") int userId){
			return new biz.Order().getUserOrders(userId);
		}
	

	 
	 
	 
	@Path("/s")
	@GET
	@Produces (MediaType.TEXT_PLAIN)
	public String rTurn(){
		
		return "hello second";
	}
	
	
	
	// who is the consumer? what is the use case? Porbably not needed now. 
	@Path("/update/{orderid}/{totalcost}/{discount}/{cashbackbonusapplied}/{netamount}")
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public  model.Result uporder(@PathParam("orderid") int orderid,@PathParam("totalcost") int totalcost,@PathParam("discount") int discount,@PathParam("cashbackbonusapplied") int cashbackbonusapplied,@PathParam("netamount") int netamount)
	{
		model.Order order=new model.Order();
		model.Result result=new model.Result();
		order.setTotalCost(totalcost);
		order.setDiscount(discount);
		order.setCashbackBonusApplied(cashbackbonusapplied);
		order.setNetAmount(netamount);
		dal.Order orderDal = new dal.Order();
		
		result.setStatus(orderDal.updateOrder(order,orderid).getStatusCode());
		return result;
		
	}
	

}