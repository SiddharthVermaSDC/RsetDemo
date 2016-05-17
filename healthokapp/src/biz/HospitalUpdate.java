package biz;

public class HospitalUpdate {

	public static int updateHospital(model.Hospital hsptl1, int id) {
		return dal.HospitalUpdate.updateHospital(hsptl1,id);
	}
}
