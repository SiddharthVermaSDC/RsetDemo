/**
 * 
 */
package model;

/**
 * @author Abhay-Jaiswal
 *
 */
public class DoctorPhoneNumber {
	
	private int doctorPhoneNumberId;
	private PhoneNumberType phoneNumberTypeId;
	private int doctorId;
	private String phoneNumber;
	private String contact;
	private String comments;
	private String phoneNumberType;
	
	public int getDoctorPhoneNumberId() {
		return doctorPhoneNumberId;
	}
	public void setDoctorPhoneNumberId(int doctorPhoneNumberId) {
		this.doctorPhoneNumberId = doctorPhoneNumberId;
	}
	public PhoneNumberType getPhoneNumberTypeId() {
		return phoneNumberTypeId;
	}
	public void setPhoneNumberTypeId(PhoneNumberType phoneNumberTypeId) {
		this.phoneNumberTypeId = phoneNumberTypeId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getPhoneNumberType() {
		return phoneNumberType;
	}
	public void setPhoneNumberType(String phoneNumberType) {
		this.phoneNumberType = phoneNumberType;
	}

}