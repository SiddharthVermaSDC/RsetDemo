/**
 * 
 */
package model;

/**
 * @author Abhay-Jaiswal
 *
 */
public enum OrderType {
	
	MEDICINE(1),
	LAB(2),
	APPT(3),
	AMBULANCE(4),
	NURSE(5);

	
	private final int orderType;
	
	OrderType( int orderType)
	{
		
		this.orderType = orderType; 
	}
	
	public int getOrderType()
	{
		
		return this.orderType;
	}
	
	
	public static OrderType item (int id)
	{
		return values()[id-1];
	}
	
}

