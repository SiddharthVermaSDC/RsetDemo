package biz;

public class Hospital {

	public static int addHospital(model.Hospital hsptl) {
		return new dal.Hospital().addHospital(hsptl);
	}

}
