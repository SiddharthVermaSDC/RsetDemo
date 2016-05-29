package biz;

import java.util.ArrayList;

public class MedicineOrderDetails {

	public int medicineOrderDetail(ArrayList<model.MedicineOrderDetails> medicineOrderDetails) {
		
		new dal.MedicineOrderDetails().insertMedicineOrderDetails(medicineOrderDetails);// TODO Auto-generated method stub
		return 1;
	}

}
