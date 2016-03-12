package model;

public class Doctor {
	private int doctorId;
	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	
	private String images;
	private int imageid;
	private int imageTypeId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String emailId;
	private int speciality;
	private String degree;
	private String doctorRegDate;
	private String clinicTiming;
	private String offDay;
	private int emergencyFees;
	private int fees;
	private boolean isPharamacy;
	private boolean isProvideHomecare;
	private boolean isBelongToHospital;
	private boolean inPanel;
	private boolean appointmnet;
	private boolean virtualReceptionist;
	private boolean postcare;
	private int yearofExperience;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private int cityId;
	private String pincode;
	private String phoneNumber;
	private int phoneNumberType;
	private String contact;
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getPhoneNumberType() {
		return phoneNumberType;
	}

	public void setPhoneNumberType(int phoneNumberType) {
		this.phoneNumberType = phoneNumberType;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	private String comment;

	public Doctor() {

	}

/*	public Doctor(String images,  int imageTypeId, String firstName, String middleName, String lastName,
			int speciality, String degree, String clinicTiming, String offDay, int fees, boolean inPanel,
			boolean appointmnet, boolean virtualReceptionist, boolean postcare, int yearofExperience,
			String addressLine1, String addressLine2, String addressLine3, int cityId, String pincode) {
		super();
		this.images = images;
		
		this.imageTypeId = imageTypeId;
		this.firstName = firstName ;
		this.middleName = middleName;
		this.lastName = lastName;
		this.speciality = speciality;
		this.clinicTiming = clinicTiming;
		this.offDay= offDay;
		this.fees = fees;
		this.inPanel = inPanel;
		this.appointmnet = appointmnet;
		this.virtualReceptionist = virtualReceptionist;
		this.postcare = postcare;
		this.yearofExperience = yearofExperience;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressLine3 = addressLine3;
		this.cityId = cityId;
		this.pincode = pincode;

	}*/

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getImageid() {
		return imageid;
	}

	public void setImageid(int imageid) {
		this.imageid = imageid;
	}

	public int getImageTypeId() {
		return imageTypeId;
	}

	public void setImageTypeId(int imageTypeId) {
		this.imageTypeId = imageTypeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSpeciality() {
		return speciality;
	}

	public void setSpeciality(int speciality) {
		this.speciality = speciality;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getClinicTiming() {
		return clinicTiming;
	}

	public void setClinicTiming(String clinicTiming) {
		this.clinicTiming = clinicTiming;
	}

	public String getOffDay() {
		return offDay;
	}

	public void setOffDay(String offDay) {
		this.offDay = offDay;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public boolean isInPanel() {
		return inPanel;
	}

	public void setInPanel(boolean inPanel) {
		this.inPanel = inPanel;
	}

	public boolean isAppointmnet() {
		return appointmnet;
	}

	public void setAppointmnet(boolean appointmnet) {
		this.appointmnet = appointmnet;
	}

	public boolean isVirtualReceptionist() {
		return virtualReceptionist;
	}

	public void setVirtualReceptionist(boolean virtualReceptionist) {
		this.virtualReceptionist = virtualReceptionist;
	}

	public boolean isPostcare() {
		return postcare;
	}

	public void setPostcare(boolean postcare) {
		this.postcare = postcare;
	}

	public int getYearofExperience() {
		return yearofExperience;
	}

	public void setYearofExperience(int yearofExperience) {
		this.yearofExperience = yearofExperience;
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
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDoctorRegDate() {
		return doctorRegDate;
	}

	public void setDoctorRegDate(String doctorRegDate) {
		this.doctorRegDate = doctorRegDate;
	}

	public int getEmergencyFees() {
		return emergencyFees;
	}

	public void setEmergencyFees(int emergencyFees) {
		this.emergencyFees = emergencyFees;
	}

	public boolean isPharamacy() {
		return isPharamacy;
	}

	public void setPharamacy(boolean isPharamacy) {
		this.isPharamacy = isPharamacy;
	}

	public boolean isProvideHomecare() {
		return isProvideHomecare;
	}

	public void setProvideHomecare(boolean isProvideHomecare) {
		this.isProvideHomecare = isProvideHomecare;
	}

	public boolean isBelongToHospital() {
		return isBelongToHospital;
	}

	public void setBelongToHospital(boolean isBelongToHospital) {
		this.isBelongToHospital = isBelongToHospital;
	}
}
