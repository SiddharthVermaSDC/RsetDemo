package model;

import java.util.ArrayList;

public class UserFull {

private int id;
		public int getId() {
	return UserId;
}
public void setId(int id) {
	this.id = id;
	this.UserId = id;
}
		private int UserId;
		private String MemberId=null;
		private MembershipType MembershipTypeId;
		private String FirstName=null;
		private String LastName=null;
		private int AddressId;
		private String EmailId=null;
		private String Mobile;
		private String Password=null;
		private int PrimaryDoctor;
		private String DoctorGenerallyVisited=null;
		private String Comments=null;
		private int PrepaidBalance;
		private int CashbackBonusBalance;
		private int TotalDiscount;
		private String AddressLine1=null;
		private String AddressLine2=null;
		private String AddressLine3=null;
		private int CityId;
		private String PinCode;
		
		private ArrayList<MemberDetail> memberDetail;
		private ArrayList<UserPhoneNumber> userPhoneNumber;
		
		public ArrayList<UserPhoneNumber> getUserPhoneNumber() {
			return userPhoneNumber;
		}
		public void setUserPhoneNumber(ArrayList<UserPhoneNumber> userPhoneNumber) {
			this.userPhoneNumber = userPhoneNumber;
		}
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
		public String getPinCode() {
			return PinCode;
		}
		public void setPinCode(String pinCode) {
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
		
		public int getUserId() {
			return UserId;
		}
		public void setUserId(int userId) {
			UserId = userId;
		}
		public String getMemberId() {
			return MemberId;
		}
		public void setMemberId(String memberId) {
			MemberId = memberId;
		}
		public MembershipType getMembershipTypeId() {
			return MembershipTypeId;
		}
		public void setMembershipTypeId(MembershipType membershipTypeId) {
			MembershipTypeId = membershipTypeId;
		}
		public int getAddressId() {
			return AddressId;
		}
		public void setAddressId(int addressId) {
			AddressId = addressId;
		}
		public String getPassword() {
			return Password;
		}
		public void setPassword(String password) {
			Password = password;
		}
		public int getPrimaryDoctor() {
			return PrimaryDoctor;
		}
		public void setPrimaryDoctor(int primaryDoctor) {
			PrimaryDoctor = primaryDoctor;
		}
		public String getComments() {
			return Comments;
		}
		public void setComments(String comments) {
			Comments = comments;
		}
		public int getPrepaidBalance() {
			return PrepaidBalance;
		}
		public void setPrepaidBalance(int prepaidBalance) {
			PrepaidBalance = prepaidBalance;
		}
		public int getCashbackBonusBalance() {
			return CashbackBonusBalance;
		}
		public void setCashbackBonusBalance(int CashbackBonusBalance) {
			this.CashbackBonusBalance = CashbackBonusBalance;
		}
		public int getTotalDiscount() {
			return TotalDiscount;
		}
		public void setTotalDiscount(int totalDiscount) {
			TotalDiscount = totalDiscount;
		}
		public String getAddressLine3() {
			return AddressLine3;
		}
		public void setAddressLine3(String addressLine3) {
			AddressLine3 = addressLine3;
		}
		public ArrayList<MemberDetail> getMemberDetail() {
			return memberDetail;
		}
		public void setMemberDetail(ArrayList<MemberDetail> memberDetail) {
			this.memberDetail = memberDetail;
		}
		
		
	}
	

