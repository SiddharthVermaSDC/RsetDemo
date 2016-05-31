package biz;

import java.util.ArrayList;

import util.StatusCode;

public class LabOrderDetails {

	public static int deleteLabOrder(int laborderid) {
		
		return dal.LabOrderDetails.deleteLabOrder(laborderid);
	}

	public int placeLabOrderdetails(ArrayList<model.LabOrderDetail> labOrderDetails) {
		
		return new dal.LabOrderDetails().placeLabOrderdetails(labOrderDetails);
	}

	public static int updateLabOrder(model.LabOrderDetail labOrderDetail) {
		
		return new dal.LabOrderDetails().updateLabOrderdetail(labOrderDetail);
	}

	
}
