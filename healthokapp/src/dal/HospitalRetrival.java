package dal;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Hospital;
import rest_api.DatabaseConnectivity;

public class HospitalRetrival {
	static Connection connection;
	// private Statement st=null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	static Connection connection1;
	static PreparedStatement ps1 = null;
	static ResultSet rs1 = null;

	public static ArrayList<Hospital> responseHospital(String HospitalId) {
		ArrayList<model.Hospital> hosptl = new ArrayList<model.Hospital>();
		try {
			try {
				connection = DatabaseConnectivity.getInstance().getConnection();
			} catch (SQLException | IOException | PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sql = "Select * from hospital where HospitalId=\"" + HospitalId + "\"";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				int hospitalId = rs.getInt("HospitalId");
				String hospitalname = rs.getString("Name");
				int addressId = rs.getInt("AddressId");
				boolean hasER = rs.getBoolean("HasER");
				String facilities = rs.getString("Facilities");
				int opdFees = rs.getInt("OPDFees");
				int bed = rs.getInt("Beds");
				String addressLine1 = rs.getString("AddressLine1");
				String addressLine2 = rs.getString("AddressLine2");
				String addressLine3 = rs.getString("AddressLine3");
				int cityId = rs.getInt("CityId");
				String pincode = rs.getString("PinCode");
				String regDate = rs.getString("RegistrationDate");
				String website = rs.getString("Website");
				String phonenumber = rs.getString("Hospitalphonenumber");
				boolean hasRadiology = rs.getBoolean("Hasradiology");
				boolean hasDiagnistics = rs.getBoolean("Hasdiagnistics");
				boolean hasAmbulance = rs.getBoolean("Hasambulance");
				String addmissionProcess = rs.getString("AdmissionProcess");
				hosptl.add(new model.Hospital(hospitalId, hospitalname, addressId, hasER, facilities, opdFees, bed,
						addressLine1, addressLine2, addressLine3, cityId, pincode, regDate, website, phonenumber,
						hasRadiology, hasDiagnistics, hasAmbulance, addmissionProcess));

				// hosptl.add(new model.Hospital(cityId, hospitalname,addressId,
				// hasER, facilities, opdFees, bed, addressLine1, addressLine2,
				// addressLine3, cityId, pincode, regDate, website, phonenumber,
				// hasRadiology, hasDiagnistics, hasAmbulance,
				// addmissionProcess));
			}
		} catch (SQLException e) {
			System.out.println("SQL EXCEPTION**1");

		}
		return hosptl;
	}

	public static ArrayList<Hospital> responseHospitalId() {
		ArrayList<model.Hospital> hosptl1 = new ArrayList<model.Hospital>();

		try {
			connection1 = DatabaseConnectivity.getInstance().getConnection();
			String sql1 = "Select HospitalId from hospital";
			ps1 = connection.prepareStatement(sql1);
			rs1 = ps1.executeQuery();
			System.out.println(rs1);
			while (rs1.next()) {
				int hospitalId = rs1.getInt("HospitalId");
				hosptl1.add(new model.Hospital(hospitalId));
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			System.out.println("SQL EXCEPTION**2");
		}
		return hosptl1;
	}

}
