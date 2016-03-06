package biz;

import java.util.ArrayList;

public class Laborder {

	public static int placeLabOrder(model.Laborder laborder ){ 
		
		
		return dal.Laborder.placeLabOrder( laborder);
	}

	public static ArrayList<model.Laborder> pendinglorder() {
		
		return dal.Laborder.pendinglorder();
	}

	public static int deleteLabOrder(int orderid) {
		
		return dal.Laborder.deleteLaborder(orderid);
	}

	public static int updateResultLabOrder(int laborderid, int resultimageid) {
		
		return dal.Laborder.updateResultLabOrder(laborderid,resultimageid);
	}
}
