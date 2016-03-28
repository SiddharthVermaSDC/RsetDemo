package dal;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.Hospital;
import util.Logging;

public class HospitalRetrival {


	public  model.Hospital responseHospital(int hospitalId) {
		
		 Connection connection;
		 PreparedStatement ps;
		 ResultSet rs;

		try {
				connection = Database.createConnection();
			String sql = "Select * from hospital where HospitalId=\"" + HospitalId + "\"";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				int dbHospitalId = rs.getInt("HospitalId"); // this is useless as this is same as passed in hospitalId
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
				Date regDate = rs.getDate("RegistrationDate");
				String website = rs.getString("Website");
				String phonenumber = rs.getString("Hospitalphonenumber");
				boolean hasRadiology = rs.getBoolean("Hasradiology");
				boolean hasDiagnistics = rs.getBoolean("Hasdiagnistics");
				boolean hasAmbulance = rs.getBoolean("Hasambulance");
				String addmissionProcess = rs.getString("AdmissionProcess");
				return new model.Hospital(hospitalId, hospitalname, addressId, hasER, facilities, opdFees, bed,
						addressLine1, addressLine2, addressLine3, cityId, pincode, regDate, website, phonenumber,
						hasRadiology, hasDiagnistics, hasAmbulance, addmissionProcess);

				// hosptl.add(new model.Hospital(cityId, hospitalname,addressId,
				// hasER, facilities, opdFees, bed, addressLine1, addressLine2,
				// addressLine3, cityId, pincode, regDate, website, phonenumber,
				// hasRadiology, hasDiagnistics, hasAmbulance,
				// addmissionProcess));
			}
		} catch (SQLException e) {
			Logging.Exception("HOSPITALDAL", "SQL Error " + e.getMessage());

		}
		finally
		{
			Database.closeConnection(connection);
		}
		return null;
	}

	// return all hospitals - Needs to be fixed to return arraylist of all hospitals. 
/*	
	public  ArrayList<Hospital> allHospitals() {
		ArrayList<model.Hospital> hosptl1 = new ArrayList<model.Hospital>();

		 Connection connection;
		 PreparedStatement ps;
		 ResultSet rs;

		try {
			connection1 = Database.createConnection();
			String sql1 = "Select HospitalId from hospital";
			ps1 = connection.prepareStatement(sql1);
			rs1 = ps1.executeQuery();
			System.out.println(rs1);
			while (rs1.next()) {
				int hospitalId = rs1.getInt("HospitalId");
				hosptl1.add(new model.Hospital(hospitalId));
			}
		} catch (SQLException  e) {
			System.out.println("SQL EXCEPTION**2");
		}
		return hosptl1;
	}
*/
}
