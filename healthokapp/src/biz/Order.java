package biz;

import java.util.ArrayList;

public class Order {

	public static int sendOrder(model.Order order){
		int x;
		x=dal.Order.createOrder(order);
		return x; 
	}
	public static model.Order respondOrder(int orderid)
	{
		return dal.Order.getOrderDetail(orderid);
	}

}
