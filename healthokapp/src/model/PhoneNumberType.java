package model;

public enum PhoneNumberType {

	Personal(1),
	Assistant(2),
	ER(3),
	APPT(4),
	ADMISSIONS(5);

	
	private final int phoneNumberType;
	
	PhoneNumberType( int phoneNumberType)
	{
		
		this.phoneNumberType = phoneNumberType; 
	}
	
	public int getPhoneNumberType()
	{
		
		return this.phoneNumberType;
	}
	
	
	public static PhoneNumberType item (int id)
	{
		return values()[id-1];
	}
	
}
