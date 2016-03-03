package biz;

public class LabOrderDetails {

	public static int deleteLabOrder(int laborderid) {
		// TODO Auto-generated method stub
		return dal.LabOrderDetails.deleteLabOrder(laborderid);
	}

	public static int placeLabOrderd(model.Laborderdetails laborderdetails) {
		// TODO Auto-generated method stub
		return dal.LabOrderDetails.placeLabOrderd(laborderdetails);
	}

	public static int updateLabOrder(model.Laborderdetails laborderdetails) {
		// TODO Auto-generated method stub
		return dal.LabOrderDetails.updateLabOrderd(laborderdetails);
	}

	
}
