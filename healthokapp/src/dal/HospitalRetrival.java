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

	public model.Hospital responseHospital(int hospitalId) {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "Select * from hospital where HospitalId=\"" + hospitalId + "\"";
		model.Hospital hospital = null;

		try {
			connection = Database.createConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, hospitalId);
			rs = ps.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				
				hospital=new model.Hospital(hospitalId);
				hospital.setHospitalId(hospitalId);
				hospital.setHospitalname(rs.getString("hospitalname"));
				hospital.setRegDate(rs.getDate("RegDate"));
				hospital.setWebsite(rs.getString("website"));
				hospital.setHasRadiology(rs.getBoolean("HasRadiology"));
				hospital.setHasDiagnistics(rs.getBoolean("Hasdiagnistics"));

			}
		} catch (SQLException e) {
			Logging.Exception("HOSPITALDAL", "SQL Error " + e.getMessage());

		} finally {
			Database.closeConnection(connection);
		}
		return null;
	}

	// return all hospitals - Needs to be fixed to return arraylist of all
	// hospitals.

	public ArrayList<Hospital> allHospitals() {
		ArrayList<model.Hospital> hosptl1 = new ArrayList<model.Hospital>();

		Connection connection;
		PreparedStatement ps;
		ResultSet rs;

		try {
			connection = Database.createConnection();
			String sql = "Select * from hospital";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			// System.out.println(rs1);
			while (rs.next()) {
				int hospitalId = rs.getInt("HospitalId");
				hosptl1.add(new model.Hospital(hospitalId));
				// add code to fill all details of hospital
			}
		} catch (SQLException e) {
			System.out.println("SQL EXCEPTION**2");
		}
		return hosptl1;
	}

}
