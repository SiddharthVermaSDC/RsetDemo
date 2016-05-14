package model;

public enum MembershipType {
	
	
	REGISTERED(1),
	CAREPLUS(2),
	CAREGOLD(3);
	
	
	private final int membershipType;
	
	MembershipType( int membershipType)
	{
		
		this.membershipType = membershipType; 
	}
	
	public int getmembershipType()
	{
		
		return this.membershipType;
	}
	
	
	public static MembershipType item (int id)
	{
		return values()[id-1];
	}
	

}