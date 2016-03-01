package rest_api;

public class GetSetMemberRegistration {

	public int UserId;
	public int MembershipTypeId;
	public int AddressId;
	public int PrimaryDoctor;
	public int PrepaidBalance;
	public int TotalDiscount;
	public int CashBonousBalance;
	public String MemberID=null;
	public String FirstName=null;
	public String LastName=null;
	public String Mobile;
	public String password;
	public int PinCode;
	public String EmailId=null;
	public String AddressLine1=null;
	public String AddressLine2=null;
	public int CityId;
	//public String state=null;
	//public String country=null;
	public String DoctorGenerallyVisited=null;
	//public String labTest=null;
	//public String longCare=null;
	public String otherCare=null;
	
	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public int getPinCode() {
		return PinCode;
	}
	public void setPinCode(int pinCode) {
		PinCode = pinCode;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public String getAddressLine1() {
		return AddressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return AddressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		AddressLine2 = addressLine2;
	}
	public int getCityId() {
		return CityId;
	}
	public void setCityId(int cityId) {
		CityId = cityId;
	}
	public String getDoctorGenerallyVisited() {
		return DoctorGenerallyVisited;
	}
	public void setDoctorGenerallyVisited(String doctorGenerallyVisited) {
		DoctorGenerallyVisited = doctorGenerallyVisited;
	}
	public String getOtherCare() {
		return otherCare;
	}
	public void setOtherCare(String otherCare) {
		this.otherCare = otherCare;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public int getMembershipTypeId() {
		return MembershipTypeId;
	}
	public void setMembershipTypeId(int membershipTypeId) {
		MembershipTypeId = membershipTypeId;
	}
	public int getAddressId() {
		return AddressId;
	}
	public void setAddressId(int addressId) {
		AddressId = addressId;
	}
	public int getPrimaryDoctor() {
		return PrimaryDoctor;
	}
	public void setPrimaryDoctor(int primaryDoctor) {
		PrimaryDoctor = primaryDoctor;
	}
	public int getPrepaidBalance() {
		return PrepaidBalance;
	}
	public void setPrepaidBalance(int prepaidBalance) {
		PrepaidBalance = prepaidBalance;
	}
	public int getTotalDiscount() {
		return TotalDiscount;
	}
	public void setTotalDiscount(int totalDiscount) {
		TotalDiscount = totalDiscount;
	}
	public int getCashBonousBalance() {
		return CashBonousBalance;
	}
	public void setCashBonousBalance(int cashBonousBalance) {
		CashBonousBalance = cashBonousBalance;
	}
	public String getMemberID() {
		return MemberID;
	}
	public void setMemberID(String memberID) {
		MemberID = memberID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
/*
{
	  "firstName" : "1",
	  "lastName" : "1",
	  "phone" : "1",
	  "memberEmail" : "1",
	  "addressLine1" : "1",
	  "addressLine2" : "1",
	  "city" : "1",
	  "state" : "1",
	  "pin" : "1",
	  "country" : "1",
	  "doctorVisit" : "1",
	  "labTest" : "1",
	  "longCare" : "1",
	  "otherCare" : "1"
	  "family" : [{
	  "name" : "a",
	  "age" : "a",
	  "bloodGroup" : "a",
	  "allergies" : "a",
	  "medicalCondition" : "a",
	  "currentMedicalCondition" : "a",
	  "familyId" : "A"
	}]
	}*/
