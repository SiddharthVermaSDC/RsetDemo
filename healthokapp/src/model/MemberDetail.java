package model;

import java.sql.Date;

public class MemberDetail {
private int userid;
private int memberDetailId;
private String firstName;
private String lastName;
private String sex;
private Date dateOfBirth;
private String bloodGroup;
private MedicalCondition diabetic;
private MedicalCondition BP;
private MedicalCondition heartProblems;
private String allergies;
private String currentMedications;
private String recurringTests;
private String longTermCareNeeds;
private String comments;


public int getUserid() {
	return userid;
}

public void setUserid(int userid) {
	this.userid = userid;
}
public int getMemberDetailId() {
	return memberDetailId;
}

public void setMemberDetailId(int memberDetailId) {
	this.memberDetailId = memberDetailId;
}

public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public Date getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public String getBloodGroup() {
	return bloodGroup;
}
public void setBloodGroup(String bloodGroup) {
	this.bloodGroup = bloodGroup;
}
public MedicalCondition getDiabetic() {
	return diabetic;
}
public void setDiabetic(MedicalCondition diabetic) {
	this.diabetic = diabetic;
}
public MedicalCondition getBP() {
	return BP;
}
public void setBP(MedicalCondition bP) {
	BP = bP;
}
public MedicalCondition getHeartProblems() {
	return heartProblems;
}
public void setHeartProblems(MedicalCondition heartProblems) {
	this.heartProblems = heartProblems;
}
public String getAllergies() {
	return allergies;
}
public void setAllergies(String allergies) {
	this.allergies = allergies;
}
public String getCurrentMedications() {
	return currentMedications;
}
public void setCurrentMedications(String currentMedications) {
	this.currentMedications = currentMedications;
}
public String getRecurringTests() {
	return recurringTests;
}
public void setRecurringTests(String recurringTests) {
	this.recurringTests = recurringTests;
}
public String getLongTermCareNeeds() {
	return longTermCareNeeds;
}
public void setLongTermCareNeeds(String longTermCareNeeds) {
	this.longTermCareNeeds = longTermCareNeeds;
}
public String getComments() {
	return comments;
}
public void setComments(String comments) {
	this.comments = comments;
}

}
