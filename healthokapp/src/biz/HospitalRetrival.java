package biz;

import java.util.ArrayList;

import model.Hospital;

public class HospitalRetrival {

	public Hospital responseHospital(int hospitalId) {

		return new dal.HospitalRetrival().responseHospital(hospitalId);
	}

	public ArrayList<Hospital> allHospitals() {
		ArrayList<model.Hospital> hosptl1;
		hosptl1 = new dal.HospitalRetrival().allHospitals();
		return hosptl1;
	}

}
