package model;

import java.util.Date;

public class OrderBase {
private int orderId;
private int userId;
private OrderType orderType;
private Date orderDate;
private OrderStatusType orderStatusType;
private Date orderCompletionDate;
private Date orderFulfillDate;
private String orderDescription; // this is entered when placing the order. 
private int imageId; // this is id of image stored in database.
private int doctorId; // used when ordering Doctor Appointment
private Doctor doctor;

public Doctor getDoctor() {
	return doctor;
}


public void setDoctor(Doctor doctor) {
	this.doctor = doctor;
}

public OrderBase(int userId, OrderType orderType, Date orderDate, OrderStatusType orderStatusType,
		Date orderCompletionDate, Date orderFulfillDate, String orderDescription) {
	super();
	this.userId = userId;
	this.orderType = orderType;
	this.orderDate = orderDate;
	this.orderStatusType = orderStatusType;
	this.orderCompletionDate = orderCompletionDate;
	this.orderFulfillDate = orderFulfillDate;
	this.orderDescription = orderDescription;
}


public OrderBase() {
	// TODO Auto-generated constructor stub
}


public int getOrderId() {
	return orderId;
}


public void setOrderId(int orderId) {
	this.orderId = orderId;
}


public int getUserId() {
	return userId;
}


public void setUserId(int userId) {
	this.userId = userId;
}


public OrderType getOrderType() {
	return orderType;
}


public void setOrderType(OrderType orderType) {
	this.orderType = orderType;
}


public Date getOrderDate() {
	return orderDate;
}


public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}


public OrderStatusType getOrderStatusType() {
	return orderStatusType;
}


public void setOrderStatusType(OrderStatusType orderStatusType) {
	this.orderStatusType = orderStatusType;
}


public Date getOrderCompletionDate() {
	return orderCompletionDate;
}


public void setOrderCompletionDate(Date orderCompletionDate) {
	this.orderCompletionDate = orderCompletionDate;
}


public Date getOrderFulfillDate() {
	return orderFulfillDate;
}


public void setOrderFulfillDate(Date orderFulfillDate) {
	this.orderFulfillDate = orderFulfillDate;
}


public String getOrderDescription() {
	return orderDescription;
}


public void setOrderDescription(String orderDescription) {
	this.orderDescription = orderDescription;
}


public int getImageId() {
	return imageId;
}


public void setImageId(int imageId) {
	this.imageId = imageId;
}


public int getDoctorId() {
	return doctorId;
}


public void setDoctorId(int doctorId) {
	this.doctorId = doctorId;
}


}