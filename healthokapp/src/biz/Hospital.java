package biz;

public class Hospital {

	public static int addHospital(model.Hospital hospital) {
		return new dal.Hospital().addHospital(hospital);
	}

}
