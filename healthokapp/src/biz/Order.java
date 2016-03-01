package biz;

import java.util.ArrayList;

public class Order {

	public static int sendOrder(model.Order order){
		
		return dal.Order.createOrder(order);
	}
	public static ArrayList<model.Order> respondOrder(int orderid)
	{
		return dal.Order.getOrderDetail(orderid);
	}

}
