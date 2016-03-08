package model;

import java.sql.Date;

public class Hospital {

	
	private String hospitalname;
	private int addressId;
	private boolean hasER;
	private String facilities;
	private int opdFees;
	private int bed;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private int cityId;
	private String pincode;
	private String regDate;
	private String website;
	private int phonenumber;
	private boolean hasRadiology;
	private boolean hasDiagnistics;
	private boolean hasAmbulance;
	private String addmissionProcess;
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	public boolean isHasRadiology() {
		return hasRadiology;
	}
	public void setHasRadiology(boolean hasRadiology) {
		this.hasRadiology = hasRadiology;
	}
	public boolean isHasDiagnistics() {
		return hasDiagnistics;
	}
	public void setHasDiagnistics(boolean hasDiagnistics) {
		this.hasDiagnistics = hasDiagnistics;
	}
	public boolean isHasAmbulance() {
		return hasAmbulance;
	}
	public void setHasAmbulance(boolean hasAmbulance) {
		this.hasAmbulance = hasAmbulance;
	}
	public String getAddmissionProcess() {
		return addmissionProcess;
	}
	public void setAddmissionProcess(String addmissionProcess) {
		this.addmissionProcess = addmissionProcess;
	}
	public String getHospitalname() {
		return hospitalname;
	}
	public void setHospitalname(String hospitalname) {
		this.hospitalname = hospitalname;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public boolean isHasER() {
		return hasER;
	}
	public void setHasER(boolean hasER) {
		this.hasER = hasER;
	}
	public String getFacilities() {
		return facilities;
	}
	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}
	public int getOpdFees() {
		return opdFees;
	}
	public void setOpdFees(int opdFees) {
		this.opdFees = opdFees;
	}
	public int getBed() {
		return bed;
	}
	public void setBed(int bed) {
		this.bed = bed;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getAddressLine3() {
		return addressLine3;
	}
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
}
