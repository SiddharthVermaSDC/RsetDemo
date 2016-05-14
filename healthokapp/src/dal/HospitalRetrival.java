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


	public  model.Hospital responseHospital(int hospitalId) {
		
		 Connection connection = null;
		 PreparedStatement ps  = null;
		 ResultSet rs  = null;

		try {
				connection = Database.createConnection();
			String sql = "Select * from hospital where HospitalId=\"" + hospitalId + "\"";
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
//				return new model.Hospital(hospitalId, hospitalname, addressId, hasER, facilities, opdFees, bed,
//						addressLine1, addressLine2, addressLine3, cityId, pincode, regDate, website, phonenumber,
//						hasRadiology, hasDiagnistics, hasAmbulance, addmissionProcess);
return null;
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
	
	public  ArrayList<Hospital> allHospitals() {
		ArrayList<model.Hospital> hosptl1 = new ArrayList<model.Hospital>();

		 Connection connection;
		 PreparedStatement ps;
		 ResultSet rs;

		try {
			connection = Database.createConnection();
			String sql = "Select * from hospital";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			//System.out.println(rs1);
			while (rs.next()) {
				int hospitalId = rs.getInt("HospitalId");
				//hosptl1.add(new model.Hospital(hospitalId));
				// add code to fill all details of hospital
			}
		} catch (SQLException  e) {
			System.out.println("SQL EXCEPTION**2");
		}
		return hosptl1;
	}

}
