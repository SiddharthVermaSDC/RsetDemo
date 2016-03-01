package biz;

public class Order {

	public static int sendOrder(model.Order order){
		
		return dal.Order.createOrder(order);
	
	
	
	
	}
	
}
