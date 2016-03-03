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
		// TODO Auto-generated method stub
		
		return dal.Laborder.deleteLaborder(orderid);
	}

	public static int updateLabOrder(int laborderid, int resultimageid) {
		
		return dal.Laborder.updateLabOrder(laborderid,resultimageid);
	}
}
