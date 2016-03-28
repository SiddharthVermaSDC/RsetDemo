package biz;

import java.util.ArrayList;

public class Laborder {

	public static int placeLabOrder(model.Order order ){ 
		
		
		return new dal.Laborder().placeOrder( order);
	}
	
	/*

	public static ArrayList<model.Laborder> pendinglorder() {
		
		return new dal.Laborder().pendinglorder();
	}

	public static int deleteLabOrder(int orderid) {
		
		return dal.Laborder.deleteLaborder(orderid);
	}

	public static int updateResultLabOrder(int laborderid, int resultimageid) {
		
		return dal.Laborder.updateResultLabOrder(laborderid,resultimageid);
	}
	*/
}
