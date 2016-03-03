package rest_api;

public class GetSetFamilyRegistration {

	public int MemberdetailId;
	public int UserId;
	public String FirstName=null;
	public String LastName=null;
	public String sex=null;
	public String DOB=null;
	public String BloodGroup=null;
	public int Daibetic;
	public int BP;
	public int HeartProblems;
	public String CurrentMedication=null;
	public String Allergies=null;
	public String RecurringTests=null;
	public String LongTermCareNeed=null;
	public String Comments=null;
	public int CityId;
	
	
	public int getMemberdetailId() {
		return MemberdetailId;
	}
	public void setMemberdetailId(int memberdetailId) {
		MemberdetailId = memberdetailId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getBloodGroup() {
		return BloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		BloodGroup = bloodGroup;
	}
	public int getDaibetic() {
		return Daibetic;
	}
	public void setDaibetic(int daibetic) {
		Daibetic = daibetic;
	}
	public int getBP() {
		return BP;
	}
	public void setBP(int bP) {
		BP = bP;
	}
	public int getHeartProblems() {
		return HeartProblems;
	}
	public void setHeartProblems(int heartProblems) {
		HeartProblems = heartProblems;
	}
	public String getAllergies() {
		return Allergies;
	}
	public void setAllergies(String allergies) {
		Allergies = allergies;
	}
	public String getRecurringTests() {
		return RecurringTests;
	}
	public void setRecurringTests(String recurringTests) {
		RecurringTests = recurringTests;
	}
	public String getLongTermCareNeed() {
		return LongTermCareNeed;
	}
	public void setLongTermCareNeed(String longTermCareNeed) {
		LongTermCareNeed = longTermCareNeed;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	public int getCityId() {
		return CityId;
	}
	public void setCityId(int cityId) {
		CityId = cityId;
	}
	public String getCurrentMedication() {
		return CurrentMedication;
	}
	public void setCurrentMedication(String currentMedication) {
		CurrentMedication = currentMedication;
	}
}
