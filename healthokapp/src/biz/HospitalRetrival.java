package biz;

import java.util.ArrayList;

import model.Hospital;

public class HospitalRetrival {

	public  ArrayList<Hospital> responseHospital(int hospitalId) {
		ArrayList<model.Hospital> hospitals;
		hospitals = dal.HospitalRetrival.responseHospital(HospitalId);
		return hosptl;
	}

	public static ArrayList<Hospital> responseHospitalId() {
		ArrayList<model.Hospital> hosptl1;
		hosptl1 = dal.HospitalRetrival.responseHospitalId();
		return hosptl1;
	}

}
