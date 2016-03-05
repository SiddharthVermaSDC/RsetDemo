package biz;

public class LabOrderDetails {

	public static int deleteLabOrder(int laborderid) {
		
		return dal.LabOrderDetails.deleteLabOrder(laborderid);
	}

	public static int placeLabOrderd(model.Laborderdetails laborderdetails) {
		
		return dal.LabOrderDetails.placeLabOrderd(laborderdetails);
	}

	public static int updateLabOrder(model.Laborderdetails laborderdetails) {
		
		return dal.LabOrderDetails.updateLabOrderd(laborderdetails);
	}

	
}
