package model;

public class MedicineOrder {

private int MedicineOrderId;
private int OrderId;
private int PrescriptionImageId;
private String Comments;
public MedicineOrder(){}

public MedicineOrder(int MedicineOrderId,int OrderId,int PrescriptionImageId,String Comments){
	super();
	this.MedicineOrderId = MedicineOrderId;
	this.Comments = Comments;
	this.PrescriptionImageId = PrescriptionImageId;
	this.OrderId=OrderId;
}

public int getMedicineOrderId() {
	return MedicineOrderId;
}

public void setMedicineOrderId(int medicineOrderId) {
	MedicineOrderId = medicineOrderId;
}

public int getOrderId() {
	return OrderId;
}

public void setOrderId(int orderId) {
	OrderId = orderId;
}

public int getPrescriptionImageId() {
	return PrescriptionImageId;
}

public void setPrescriptionImageId(int prescriptionImageId) {
	PrescriptionImageId = prescriptionImageId;
}

public String getComments() {
	return Comments;
}

public void setComments(String comments) {
	Comments = comments;
}

}
