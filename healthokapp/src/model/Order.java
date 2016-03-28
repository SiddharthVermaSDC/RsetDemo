package model;

import java.util.Date;

public class Order extends OrderBase {
private String comments; // This is entered by admin 
private int totalCost;
private int discount;
private int cashbackBonusApplied;
private int netAmount;
private Date orderFulfillDate;

public Order()
{

}
public Order(int orderId,int userId,
		OrderType orderType,Date orderDate,OrderStatusType orderStatusType,
		Date orderCompletionDate,String comments,
		int totalCost,int discount,
		int cashbackBonusApplied,int netAmount,Date orderFulfillDate
		,String orderDescription)
{
	super(userId, orderType, orderDate, orderStatusType,
			 orderCompletionDate, orderFulfillDate,  orderDescription);
	
	this.comments = comments;
	this.totalCost=totalCost;
	this.discount=discount;
	this.cashbackBonusApplied=cashbackBonusApplied;
	this.netAmount=netAmount;
	this.orderFulfillDate=orderFulfillDate;
}

public String getComments() {
	return comments;
}
public void setComments(String comments) {
	this.comments = comments;
}
public int getTotalCost() {
	return totalCost;
}
public void setTotalCost(int totalCost) {
	this.totalCost = totalCost;
}
public int getDiscount() {
	return discount;
}
public void setDiscount(int discount) {
	this.discount = discount;
}
public int getCashbackBonusApplied() {
	return cashbackBonusApplied;
}
public void setCashbackBonusApplied(int cashbackBonusApplied) {
	this.cashbackBonusApplied = cashbackBonusApplied;
}
public int getNetAmount() {
	return netAmount;
}
public void setNetAmount(int netAmount) {
	this.netAmount = netAmount;
}

public void setOrderFulfillDate(Date orderFulfillDate){
	this.orderFulfillDate=orderFulfillDate;
}
public Date getOrderFulfillDate(){
	
	return orderFulfillDate;
}



}