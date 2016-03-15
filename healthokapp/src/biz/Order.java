package biz;

import java.util.ArrayList;

import javax.ws.rs.PathParam;

public class Order {

	public static int sendOrder(model.Order order){
		int x;
		int y2=90;
		x=dal.Order.createOrder(order);
		order.setOrderId(x);
		if(order.getOrderTypeId()==1){
		int y1=dal.MedicineOrder.insertMedicineOrder(order);
		}
		if(order.getOrderTypeId()==2){
		y2=dal.Laborder.placeLabOrder(order);
		}
		return y2; 
	}
	public static model.Order respondOrder(int orderid)
	{
		return dal.Order.getOrderDetail(orderid);
	}

}
