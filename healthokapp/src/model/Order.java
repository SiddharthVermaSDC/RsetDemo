package model;
import java.sql.Date;

public class Order {
private int OrderId;
private int UserId;
private int OrderTypeId;
private Date OrderDate;
private int OrderStatusTypeId;
private Date OrderCompetionDate;
private String OrderDescription;
private int TotalCost;
private int Discount;
private int CashBonusApplies
private String Comments;
public Order(int OrderId,int OrderTypeId,String OrderDate,String OrderCompetionDate,int OrderStatusTypeId,String Comments,int UserId){
	super();
	this.OrderId = OrderId;
	this.OrderTypeId = OrderTypeId;
	this.OrderDate = OrderDate;
	this.OrderCompetionDate = OrderCompetionDate;
	this.OrderStatusTypeId = OrderStatusTypeId;
	this.Comments = Comments;
	this.UserId = UserId;
	}




public int getOrderId() {
	return OrderId;
}
public void setOrderId(int orderId) {
	OrderId = orderId;
}
public int getOrderTypeId() {
	return OrderTypeId;
}
public void setOrderTypeId(int orderTypeId) {
	OrderTypeId = orderTypeId;
}
public String getOrderDate() {
	return OrderDate;
}
public void setOrderDate(String orderDate) {
	OrderDate = orderDate;
}
public String getOrderCompetionDate() {
	return OrderCompetionDate;
}
public void setOrderCompetionDate(String orderCompetionDate) {
	OrderCompetionDate = orderCompetionDate;
}
public int getOrderStatusTypeId() {
	return OrderStatusTypeId;
}
public void setOrderStatusTypeId(int orderStatusTypeId) {
	OrderStatusTypeId = orderStatusTypeId;
}
public String getComments() {
	return Comments;
}
public void setComments(String comments) {
	Comments = comments;
}
public int getUserId() {
	return UserId;
}
public void setUserId(int userId) {
	UserId = userId;
}

}
