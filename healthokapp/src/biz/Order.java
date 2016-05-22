package biz;

import java.util.ArrayList;
import java.util.Date;

import model.OrderBase;
import model.OrderStatusType;
import model.OrderType;
import notification.Notify;
import util.Logging;
import util.StatusCode;

public class Order {

	public  StatusCode createOrder(model.OrderBase order)
	
	{
		StatusCode status = StatusCode.UnknownError;
		int orderId = 0;
		
		try
		{
			// since this is new order, status should be new
		order.setOrderStatusType(OrderStatusType.NEW);	
		order.setOrderDate(new Date());
		dal.Order orderDal = new dal.Order();
		orderId = orderDal.createOrder(order);
		order.setOrderId(orderId);
		
		Logging.Debug("ORDERBIZ", order.getOrderType().toString());
		switch (order.getOrderType() )
		{
		case AMBULANCE:
			new dal.AmbulanceOrder().placeOrder(order);
			break;
		case APPT:
			new dal.DoctorAppointment().placeOrder(order);
			break;
		case LAB:
			new dal.Laborder().placeOrder(order);
			break;
		case MEDICINE:
			new dal.MedicineOrder().placeOrder(order);
			break;
		case NURSE:
			new dal.NurseOrder().placeOrder(order);
			break;
		default:
			break;
		
		}
		
		if (order.getOrderFulfillDate() == null )
		{
			order.setOrderFulfillDate(order.getOrderDate());
		}
		status = StatusCode.Success;

		}
		catch ( Exception ex)
		{
			Logging.Exception("ORDERBIZ", "Exception on save " + ex.getMessage());
			status = StatusCode.UnknownError;
			
		}
		return status;
		

	}

	
	
	public  StatusCode setOrderStatus(model.OrderBase order)
	
	{
		StatusCode status = StatusCode.UnknownError;
		int orderId = 0;
		
		try
		{

			
		if ( order.getOrderStatusType() == OrderStatusType.COMPLETE || order.getOrderStatusType() == OrderStatusType.CANCELLED) // set completion Date
		{
			order.setOrderCompletionDate(new Date()); // new Date is initialized with current date time. 
		}
		dal.Order orderDal = new dal.Order();
		orderId = orderDal.createOrder(order);
		order.setOrderId(orderId);
		
		switch (order.getOrderType() )
		{
		case AMBULANCE:
			new dal.AmbulanceOrder().placeOrder(order);
			break;
		case APPT:
			new dal.DoctorAppointment().placeOrder(order);
			break;
		case LAB:
			new dal.Laborder().placeOrder(order);
			break;
		case MEDICINE:
			new dal.MedicineOrder().placeOrder(order);
			break;
		case NURSE:
			new dal.NurseOrder().placeOrder(order);
			break;
		default:
			break;
		
		}
		
		// send notifications
		Notify notification = new Notify();
		notification.orderUpdate(order);
		
		status = StatusCode.Success;

		}
		catch ( Exception ex)
		{
			Logging.Exception("ORDERBIZ", "Exception on save " + ex.getMessage());
			status = StatusCode.UnknownError;
			
		}
		return status;
		

	}

	
	public  model.Order respondOrder(int orderid)
	{
		
		dal.Order orderDal = new dal.Order();
		return orderDal.getOrderDetail(orderid);
	}
	
	
	public ArrayList<model.OrderBase> getUserOrders(int userId) 
	{
		
		return new dal.Order().getUserOrders(userId);
	}



	public ArrayList<OrderBase> getUserAppointment(int userId) {
		// TODO Auto-generated method stub
		return new dal.Order(). getUserAppointment(userId);
	}

}
