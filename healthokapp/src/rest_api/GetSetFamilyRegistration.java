package rest_api;

public class GetSetFamilyRegistration {

	public String name=null;
	public String age=null;
	public String bloodGroup=null;
	public String allergies=null;
	public String medicalCondition=null;
	public String currentMedicalCondition=null;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	public String getMedicalCondition() {
		return medicalCondition;
	}
	public void setMedicalCondition(String medicalCondition) {
		this.medicalCondition = medicalCondition;
	}
	public String getCurrentMedicalCondition() {
		return currentMedicalCondition;
	}
	public void setCurrentMedicalCondition(String currentMedicalCondition) {
		this.currentMedicalCondition = currentMedicalCondition;
	}
}
