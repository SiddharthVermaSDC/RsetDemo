package model;
import java.sql.Date;
public class Order {
private int OrderId;
private int UserId;
private int OrderTypeId;
private String OrderDate;
private int OrderStatusTypeId;
private String OrderCompletionDate;
private String OrderDescription;
private int TotalCost;
private int Discount;
private int CashbackBonusApplied;
private int NetAmount;
private String OrderFulfillDate;
public Order(){}
public Order(int OrderId,int UserId,
		int OrderTypeId,String OrderDate,int OrderStatusTypeId,
		String OrderCompletionDate,String OrderDescription,
		int TotalCost,int Discount,
		int CashbackBonusApplied,int NetAmount,String OrderFulfillDate)
{
	super();
	this.OrderId = OrderId;
	this.UserId=UserId;
	this.OrderTypeId = OrderTypeId;
	this.OrderDate = OrderDate;
	this.OrderStatusTypeId = OrderStatusTypeId;
	this.OrderCompletionDate = OrderCompletionDate;
	this.OrderDescription = OrderDescription;
	this.TotalCost=TotalCost;
	this.Discount=Discount;
	this.CashbackBonusApplied=CashbackBonusApplied;
	this.NetAmount=NetAmount;
	this.OrderFulfillDate=OrderFulfillDate;
}
public int getOrderId() {
	return OrderId;
}
public void setOrderId(int orderId) {
	OrderId = orderId;
}
public int getUserId() {
	return UserId;
}
public void setUserId(int userId) {
	UserId = userId;
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
public int getOrderStatusTypeId() {
	return OrderStatusTypeId;
}
public void setOrderStatusTypeId(int orderStatusTypeId) {
	OrderStatusTypeId = orderStatusTypeId;
}
public String getOrderCompletionDate() {
	return OrderCompletionDate;
}
public void setOrderCompletionDate(String orderCompletionDate) {
	OrderCompletionDate = orderCompletionDate;
}
public String getOrderDescription() {
	return OrderDescription;
}
public void setOrderDescription(String orderDescription) {
	OrderDescription = orderDescription;
}
public int getTotalCost() {
	return TotalCost;
}
public void setTotalCost(int totalCost) {
	TotalCost = totalCost;
}
public int getDiscount() {
	return Discount;
}
public void setDiscount(int discount) {
	Discount = discount;
}
public int getCashbackBonusApplied() {
	return CashbackBonusApplied;
}
public void setCashbackBonusApplied(int cashbackBonusApplied) {
	CashbackBonusApplied = cashbackBonusApplied;
}
public int getNetAmount() {
	return NetAmount;
}
public void setNetAmount(int netAmount) {
	NetAmount = netAmount;
}

public void setOrderFulfillDate(String orderFulfillDate){
	OrderFulfillDate=orderFulfillDate;
}
public String getOrderFulfillDate(){
	
	return OrderFulfillDate;
}
}