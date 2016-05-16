package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.Hospital;
import util.Logging;

public class HospitalRetrival {

	public ArrayList<Hospital> responseHospital(int hospitalId) {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		ArrayList<Hospital> results = null;
		model.Hospital hospital = null;

		try {
			connection = Database.createConnection();
			// String sql = "Select * from hospital where HospitalId=\"" +
			// hospitalId + "\"";
			String sql = "Select * from hospital where HospitalId=?";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, hospitalId);
			rs = ps.executeQuery();
			results = new ArrayList<model.Hospital>();
			while (rs.next()) {
				hospital = this.populateHospital(rs);
				results.add(hospital);

			}
			return results;
		} catch (SQLException e) {
			Logging.Exception("HOSPITALDAL", "SQL Error " + e.getMessage());

		} finally {
			Database.closeConnection(connection);
		}
		return results;

	}

	// return all hospitals - Needs to be fixed to return arraylist of all
	// hospitals.

	public ArrayList<Hospital> allHospitals() {
		ArrayList<Hospital> results1 = null;
		model.Hospital hospital1 = null;
		Connection connection;
		PreparedStatement ps;
		ResultSet rs;

		try {
			connection = Database.createConnection();
			String sql = "Select * from hospital";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();

			results1 = new ArrayList<model.Hospital>();
			while (rs.next()) {
				hospital1 = this.populateHospital(rs);
				results1.add(hospital1); // add code to fill all details of
											// hospital
			}
			return results1;
		} catch (SQLException e) {
			Logging.Exception("HOSPITALDAL", "SQL Error " + e.getMessage());
		}
		return results1;

	}

	private model.Hospital populateHospital(ResultSet rs) {
		model.Hospital hospital = new model.Hospital();
		try {

			hospital.setRegDate(rs.getDate("RegistrationDate"));
			hospital.setWebsite(rs.getString("Website"));
			hospital.setHasRadiology(rs.getBoolean("HasRadiology"));
			hospital.setHasDiagnistics(rs.getBoolean("Hasdiagnistics"));
			hospital.setHasAmbulance(rs.getBoolean("Hasambulance"));
			hospital.setAddmissionProcess(rs.getString("AdmissionProcess"));
			hospital.setHospitalname(rs.getString("Name"));
			hospital.setHasER(rs.getBoolean("HasER"));
			hospital.setFacilities(rs.getString("Facilities"));
			hospital.setOpdFees(rs.getInt("OPDFees"));
			hospital.setBed(rs.getInt("Beds"));
			hospital.setAddressLine1(rs.getString("AddressLine1"));
			hospital.setAddressLine2(rs.getString("AddressLine2"));
			hospital.setAddressLine3(rs.getString("AddressLine3"));
			hospital.setCityId(rs.getInt("CityId"));
			hospital.setPincode(rs.getString("PinCode"));
			return hospital;
		} catch (SQLException se) {
			Logging.Exception("FillDocModel", "Error Populating Hospital Model " + se.getMessage());

		}
		return hospital;

	}
}
