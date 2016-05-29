package dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class MedicineOrderDetails {
	// for insert order
	public int insertMedicineOrderDetails(ArrayList<model.MedicineOrderDetails> medicineOrderDetails) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = (Connection) Database.createConnection();
			String str1 = "insert into MedicineOrderDetails(MedicineOrderId,MedicineName,Dosage,Quantity,Price) values (?,?,?,?,?)";

			ps = (PreparedStatement) con.prepareStatement(str1);
			for (model.MedicineOrderDetails ms : medicineOrderDetails) {
				// ps.setInt(1,
				// medicineorderdetails.getMedicineOrderDetailsId());
				ps.setInt(1, ms.getMedicineOrderDetailsId());
				System.out.println("MD Id= "+ms.getMedicineOrderDetailsId());
				ps.setString(2, ms.getMedicineName());
				System.out.println("MD Name= "+ ms.getMedicineName());
				ps.setString(3, ms.getDosage());
				System.out.println("MD Doage= "+ms.getDosage());
				ps.setInt(4, ms.getQuantity());
				System.out.println("MD Quantity= "+ms.getQuantity());
				ps.setFloat(5, ms.getPrice());
				System.out.println("MD Price= "+ms.getPrice());
				int rw = ps.executeUpdate();

				if (rw > 0) {
					result = 1;
				} else {
					result = -1;
				}
			}
		} catch (SQLException se) {
			System.out.println(se);
		}
		return result;
	}

	public static ArrayList<model.MedicineOrderDetails> responseMedicineOrderDetails(int medicineorderdetailsid) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		ArrayList<model.MedicineOrderDetails> medicineorderdetails = new ArrayList<model.MedicineOrderDetails>();
		Database database = new Database();
		con = (Connection) database.createConnection();
		String str = "select * from address where MedicineOrderDetailsId=?";
		try {
			ps = (PreparedStatement) con.prepareStatement(str);
			ps.setInt(1, medicineorderdetailsid);
			rs = ps.executeQuery();
			while (rs.next()) {
				int medicineorderdetailsid1 = rs.getInt("MedicineOrderDetailsId");
				int medicineorderid = rs.getInt("MedicineOrderId");
				String medicinename = rs.getString("MedicineName");
				String dosage = rs.getString("Dosage");
				int quantity = rs.getInt("Quantity");
				float price = rs.getFloat("Price");
				medicineorderdetails.add(new model.MedicineOrderDetails(medicineorderdetailsid1, medicineorderid,
						medicinename, dosage, quantity, price));

			}

		} catch (SQLException se) {

		}
		return medicineorderdetails;
	}

}
