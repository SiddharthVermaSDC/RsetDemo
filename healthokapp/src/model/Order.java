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
private int CashbackBonusApplied;
private int NetAmount;
public Order(int OrderId,int UserId,
		int OrderTypeId,Date OrderDate,int OrderStatusTypeId,
		Date OrderCompetionDate,String OrderDescription,
		int TotalCost,int Discount,
		int CashbackBonusApplied,int NetAmount)
{
	super();
	this.OrderId = OrderId;
	this.UserId=UserId;
	this.OrderTypeId = OrderTypeId;
	this.OrderDate = OrderDate;
	this.OrderStatusTypeId = OrderStatusTypeId;
	this.OrderCompetionDate = OrderCompetionDate;
	this.OrderDescription = OrderDescription;
	this.TotalCost=TotalCost;
	this.Discount=Discount;
	this.CashbackBonusApplied=CashbackBonusApplied;
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
public Date getOrderDate() {
	return OrderDate;
}
public void setOrderDate(Date orderDate) {
	OrderDate = orderDate;
}
public int getOrderStatusTypeId() {
	return OrderStatusTypeId;
}
public void setOrderStatusTypeId(int orderStatusTypeId) {
	OrderStatusTypeId = orderStatusTypeId;
}
public Date getOrderCompetionDate() {
	return OrderCompetionDate;
}
public void setOrderCompetionDate(Date orderCompetionDate) {
	OrderCompetionDate = orderCompetionDate;
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



=======

	private int orderId;
	private float amount;
	private int tax;
	private int status;
	private int shippingcost;
	private int userid;
	private String address;
>>>>>>> 25d06dcb8354e431bb80b75d5c380d39a934eb4f

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getShippingcost() {
		return shippingcost;
	}
	public void setShippingcost(int shippingcost) {
		this.shippingcost = shippingcost;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
