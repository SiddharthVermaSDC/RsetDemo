package model;

public enum OrderStatusType {

	NEW(1),
	INPROGRESS(2),
	ONHOLD(3),
	CANCELLED(4),
	DISPATCHED(5),
	COMPLETE(6);
	
	
	private final int orderStatusType;
	
	OrderStatusType( int orderStatusType)
	{
		
		this.orderStatusType = orderStatusType; 
	}
	
	public int getOrderStatusType()
	{
		
		return this.orderStatusType;
	}
	
	
	public static OrderStatusType item (int id)
	{
		return values()[id-1];
	}
	

}
