package biz;

import java.util.ArrayList;

public class MedicineOrderDetails {

	public int medicineOrderDetail(ArrayList<model.MedicineOrderDetails> medicineOrderDetails) {
		return new dal.MedicineOrderDetails().insertMedicineOrderDetails(medicineOrderDetails);

	}

	public ArrayList<model.MedicineOrderDetails> responseMedicineOrderDetails(int medicineorderid) {
		// TODO Auto-generated method stub
		return dal.MedicineOrderDetails.responseMedicineOrderDetails(medicineorderid);
	}

}
