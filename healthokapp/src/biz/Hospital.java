package biz;

public class Hospital {

	public static int addHospital(model.Hospital hsptl) {
		return dal.Hospital.addHospital(hsptl);
	}
	

	public static int updateHospital(model.Hospital hsptl1, int id) {
		return  dal.Hospital.updateHospital(hsptl1,id);
	}

}
