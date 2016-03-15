package model;

public class DoctorRetrival {

	private int rank;
	private String images;
	private int doctorId;
	private int emergencyFees;
	private int isBelongToAnyHospital;
	private String doctorRegistrationDate;
	private String emailId;
	private int isProvideHomeCare;
	private int isPharmacy;
	private int imageId;
	private int imageTypeId;
	private String firstName;
	private String middleName;
	private String lastName;
	private int speciality;
	private String degree;
	private String clinicTiming;
	private String offDay;
	private int fees;
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

	public DoctorRetrival() {

	}

	public DoctorRetrival(int rank, int doctorId, int emergencyFees, int isBelongToAnyHospital,
			String doctorRegistrationDate, String emailId, int isProvideHomeCare, int isPharmacy, String firstName,
			String middleName, String lastName, int speciality, String degree, String clinicTiming, String offDay,
			int fees, boolean inPanel, boolean appointmnet, boolean virtualReceptionist, boolean postcare,
			int yearofExperience, String addressLine1, String addressLine2, String addressLine3, int cityId,
			String pincode) {
		super();
		this.rank = rank;
		this.emergencyFees = emergencyFees;
		this.isBelongToAnyHospital = isBelongToAnyHospital;
		this.doctorRegistrationDate = doctorRegistrationDate;
		this.emailId = emailId;
		this.isProvideHomeCare = isProvideHomeCare;
		this.isPharmacy = isPharmacy;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.speciality = speciality;
		this.degree = degree;
		this.clinicTiming = clinicTiming;
		this.offDay = offDay;
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

	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getEmergencyFees() {
		return emergencyFees;
	}

	public void setEmergencyFees(int emergencyFees) {
		this.emergencyFees = emergencyFees;
	}

	public int getIsBelongToAnyHospital() {
		return isBelongToAnyHospital;
	}

	public void setIsBelongToAnyHospital(int isBelongToAnyHospital) {
		this.isBelongToAnyHospital = isBelongToAnyHospital;
	}

	public String getDoctorRegistrationDate() {
		return doctorRegistrationDate;
	}

	public void setDoctorRegistrationDate(String doctorRegistrationDate) {
		this.doctorRegistrationDate = doctorRegistrationDate;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getIsProvideHomeCare() {
		return isProvideHomeCare;
	}

	public void setIsProvideHomeCare(int isProvideHomeCare) {
		this.isProvideHomeCare = isProvideHomeCare;
	}

	public int getIsPharmacy() {
		return isPharmacy;
	}

	public void setIsPharmacy(int isPharmacy) {
		this.isPharmacy = isPharmacy;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
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

}