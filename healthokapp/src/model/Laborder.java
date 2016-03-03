package model;

import java.sql.Date;

public class Laborder {
	private int labresultimageId;
	private int prescriptionimageId;
	private String disription;
	private int orderId;
	private int laborderId;
	
	public Laborder(){}
	public Laborder(  int laborderId,int orderId,int prescriptionimageId,int labresultimageId,String disription)
	{
		super();
		this.labresultimageId = labresultimageId;
		this.prescriptionimageId=prescriptionimageId;
		this.disription = disription;
		this.orderId=orderId;
		this.laborderId=laborderId;
		//this.CashbackBonusApplied=CashbackBonusApplied;
		}

	
	public int getLabresultimageId() {
		return labresultimageId;
	}
	public void setLabresultimageId(int labresultimageId) {
		this.labresultimageId = labresultimageId;
	}
	public int getPrescriptionimageId() {
		return prescriptionimageId;
	}
	public void setPrescriptionimageId(int prescriptionimageId) {
		this.prescriptionimageId = prescriptionimageId;
	}
	public String getDisription() {
		return disription;
	}
	public void setDisription(String disription) {
		this.disription = disription;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getLaborderId() {
		return laborderId;
	}
	public void setLaborderId(int laborderId) {
		this.laborderId = laborderId;
	}
	

}
