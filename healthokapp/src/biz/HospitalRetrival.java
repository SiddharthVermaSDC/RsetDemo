package biz;

import java.util.ArrayList;

import model.Hospital;

public class HospitalRetrival {

	public  model.Hospital responseHospital(int hospitalId) {
		model.Hospital hospital;
		hospital = new dal.HospitalRetrival().responseHospital(hospitalId);
		return hospital;
	}

	public  ArrayList<Hospital> allHospitals() {
		ArrayList<model.Hospital> hosptl1;
		hosptl1 = new dal.HospitalRetrival().allHospitals();
		return hosptl1;
	}

}
