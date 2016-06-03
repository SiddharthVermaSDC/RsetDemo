package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.DoctorHospitalAffiliation;
import model.Hospital;
import model.HospitalPhoneNumber;
import util.Logging;

public class HospitalRetrival {



	public Hospital responseHospital(int hospitalId) {

		model.Hospital hospital = null;

		Connection connection = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;

		
		
		//ArrayList<Hospital> results = null;
		String sql = "Select * from Hospital where HospitalId=?";
		String sql1 = "Select * from HospitalPhoneNumbers where HospitalId=?";
		String sql2 = "Select * from DoctorHospitalAffiliation where HospitalId=?";

		try {
			connection = Database.createConnection();
			// String sql = "Select * from hospital where HospitalId=\"" +
			// hospitalId + "\"";

			ps = connection.prepareStatement(sql);
			ps1 = connection.prepareStatement(sql1);
			ps2 = connection.prepareStatement(sql2);
			ps.setInt(1, hospitalId);
			rs = ps.executeQuery();

			//results = new ArrayList<model.Hospital>();
			while (rs.next()) {
				hospital = this.populateHospital(rs);

				Logging.Debug("Hospital-Dal", "Hospital is " + hospital.getHospitalname() + "");
				ps1.setInt(1, hospitalId);
				rs1 = ps1.executeQuery();
				ArrayList<model.HospitalPhoneNumber> phonenumber = new ArrayList<model.HospitalPhoneNumber>();
				HospitalPhoneNumber hospitalphnenumber = null;
				while (rs1.next()) {
					hospitalphnenumber = this.populateHospitalPhoneNumber(rs1);
					//
					phonenumber.add(hospitalphnenumber);

					ps2.setInt(1, hospitalId);
					rs2 = ps2.executeQuery();
					ArrayList<model.DoctorHospitalAffiliation> drhr = new ArrayList<model.DoctorHospitalAffiliation>();
					model.DoctorHospitalAffiliation Drhr = null;
					while (rs2.next()) {
						Drhr = this.populateDoctorHospitalAffiliation(rs2);
						drhr.add(Drhr);
					}

					hospital.setHospitalPhoneNumbers(phonenumber);
					hospital.setDoctorHospitalAffiliation(drhr);
				}

			}
		} catch (SQLException e) {
			Logging.Exception("HOSPITALDAL", "SQL Error " + e.getMessage());

		} finally {
			Database.closeConnection(connection);
		}
		return hospital;

	}

	// return all hospitals - Needs to be fixed to return arraylist of all
	// hospitals.

	public ArrayList<Hospital> allHospitals() {
		// Connection connection = null;

		model.Hospital hospital = null;

		Connection connection = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;

		ArrayList<Hospital> results = null;
		try {
			connection = Database.createConnection();
			String sql = "Select * from Hospital ";
			String sql1 = "Select * from HospitalPhoneNumbers where HospitalId=?";
			String sql2 = "Select * from DoctorHospitalAffiliation where HospitalId=?";

			ps = connection.prepareStatement(sql);
			ps1 = connection.prepareStatement(sql1);
			ps2 = connection.prepareStatement(sql2);
			rs = ps.executeQuery();

			results = new ArrayList<model.Hospital>();
			while (rs.next()) {
				hospital = this.populateHospital(rs);
				System.out.println("Hospital Name =" + hospital);
				results.add(hospital);
				ps1.setInt(1, hospital.getHospitalId());
				rs1 = ps1.executeQuery();
				ArrayList<model.HospitalPhoneNumber> phonenumber = new ArrayList<model.HospitalPhoneNumber>();
				HospitalPhoneNumber hospitalphnenumber = null;
				while (rs1.next()) {
					hospitalphnenumber = this.populateHospitalPhoneNumber(rs1);
					//
					phonenumber.add(hospitalphnenumber);

					ps2.setInt(1, hospital.getHospitalId());
					rs2 = ps2.executeQuery();
					ArrayList<model.DoctorHospitalAffiliation> drhr = new ArrayList<model.DoctorHospitalAffiliation>();
					model.DoctorHospitalAffiliation Drhr = null;
					while (rs2.next()) {
						Drhr = this.populateDoctorHospitalAffiliation(rs2);
						drhr.add(Drhr);
					}

					hospital.setHospitalPhoneNumbers(phonenumber);
					hospital.setDoctorHospitalAffiliation(drhr);
				}

			}
		} catch (SQLException e) {
			Logging.Exception("HOSPITALDAL", "SQL Error " + e.getMessage());

		} finally {
			Database.closeConnection(connection);
		}
		return results;

	}

	private model.Hospital populateHospital(ResultSet rs) {
		model.Hospital hospital = new model.Hospital();
		try {

			hospital.setHospitalId(rs.getInt("HospitalId"));
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
			// return hospital;
		} catch (SQLException se) {
			Logging.Exception("FillDocModel", "Error Populating Hospital Model " + se.getMessage());
			System.out.println("Error");

		}
		return hospital;
	}

	private HospitalPhoneNumber populateHospitalPhoneNumber(ResultSet rs1) {
		model.HospitalPhoneNumber phonenumber = new model.HospitalPhoneNumber();
		try {
			phonenumber.setHospitalPhoneNumberId(rs1.getInt("HospitalPhoneNumberId"));
			phonenumber.setHospitalId(rs1.getInt("HospitalId"));
			phonenumber.setPhoneNumber(rs1.getString("PhoneNumber"));
			phonenumber.setPhoneNumberType(rs1.getInt("PhoneNumberType"));
			phonenumber.setContact(rs1.getString("Contact"));
			phonenumber.setComments(rs1.getString("Comments"));
		}

		catch (SQLException se) {
			Logging.Exception("FillDocModel", "Error Populating Hospital Model " + se.getMessage());

		}
		return phonenumber;
	}

	private model.DoctorHospitalAffiliation populateDoctorHospitalAffiliation(ResultSet rs2) {
		model.DoctorHospitalAffiliation drhp = new model.DoctorHospitalAffiliation();
		try {
			drhp.setDoctorHospitalAffiliationId(rs2.getInt("DoctorHospitalAffiliationId"));
			drhp.setHospitalId(rs2.getInt("HospitalId"));
			drhp.setDoctorId(rs2.getInt("DoctorId"));
			drhp.setAdditionalDetails(rs2.getString("AdditionalDetails"));

		}

		catch (SQLException se) {
			Logging.Exception("FillDocModel", "Error Populating Hospital Model " + se.getMessage());

		}
		return drhp;

	}
}
