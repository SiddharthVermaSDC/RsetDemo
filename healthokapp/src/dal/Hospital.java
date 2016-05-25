package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class Hospital {

	public int addHospital(model.Hospital hospital) {
		int result = 0;
		int rw = 0;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			connection = Database.createConnection();
			System.out.println("Connection Is Created");
			java.sql.Date hospitalDate = new java.sql.Date(hospital.getRegDate().getTime());
			String query = "Insert Into Hospital(Name,HasER,Facilities,OPDFees,Beds,"
					+ "AddressLine1,AddressLine2,AddressLine3,CityId,PinCode,RegistrationDate,"
					+ "Website,Hasradiology,Hasdiagnistics,Hasambulance,AdmissionProcess) "
					+ "Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			System.out.println("Statement Is Created");
			ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, hospital.getHospitalname());
			// ps.setInt(2, hospital.getAddressId());
			ps.setBoolean(2, hospital.isHasER());
			ps.setString(3, hospital.getFacilities());
			ps.setInt(4, hospital.getOpdFees());
			System.out.println("Opd Fees" + hospital.getOpdFees());
			ps.setInt(5, hospital.getBed());
			ps.setString(6, hospital.getAddressLine1());
			ps.setString(7, hospital.getAddressLine2());
			ps.setString(8, hospital.getAddressLine3());
			ps.setInt(9, hospital.getCityId());
			ps.setString(10, hospital.getPincode());

			// ps.setDate(12, (java.sql.Date) d);
			ps.setDate(11, hospitalDate);
			ps.setString(12, hospital.getWebsite());
			// ps.setString(14, hospital.getPhonenumber());
			ps.setBoolean(13, hospital.isHasRadiology());
			ps.setBoolean(14, hospital.isHasDiagnistics());
			ps.setBoolean(15, hospital.isHasAmbulance());
			ps.setString(16, hospital.getAddmissionProcess());

			rw = ps.executeUpdate();
			if (rw > 0) {
				rs = ps.getGeneratedKeys();
				if (rs.next())
					// result =rs.getInt(1);
					hospital.setHospitalId(rs.getInt(1));
				System.out.println("Hospital Id =" + hospital.getHospitalId());
			}

			if (hospital.getHospitalPhoneNumbers() != null) {
				String q1 = new String(
						"insert into HospitalPhoneNumbers(HospitalId,PhoneNumber,PhoneNumberType,Contact,Comments)"
								+ "values(?,?,?,?,?);");
				for (model.HospitalPhoneNumber hospitalphonenumber : hospital.getHospitalPhoneNumbers()) {
					ps = connection.prepareStatement(q1);
					// System.out.println(doctorphonenumber.getPhoneNumber());
					// System.out.println(doctorphonenumber.getDoctorPhoneNumberId());

					// ps = connection.prepareStatement(q1);
					ps.setInt(1, hospital.getHospitalId());

					ps.setString(2, hospitalphonenumber.getPhoneNumber());
					ps.setInt(3, hospitalphonenumber.getPhoneNumberType());
					ps.setString(4, hospitalphonenumber.getContact());
					ps.setString(5, hospitalphonenumber.getComments());
					ps.executeUpdate();
					result = 1;
				}
			}

			if (hospital.getDoctorHospitalAffiliation() != null) {
				String q2 = "insert into DoctorHospitalAffiliation(DoctorId,HospitalId,AdditionalDetails) values(?,?,?)";
				for (model.DoctorHospitalAffiliation dochosappl : hospital.getDoctorHospitalAffiliation()) {
					ps = connection.prepareStatement(q2);

					ps = connection.prepareStatement(q2);
					ps.setInt(1, dochosappl.getDoctorId());
					// System.out.println("DoctorPhone
					// ="+dochosappl.getDoctorId());
					ps.setInt(2, hospital.getHospitalId());
					
					ps.setString(3, dochosappl.getAdditionalDetails());
					ps.executeUpdate();
				}
			}

		} catch (Exception e) {
			System.out.println(e);
			result = 500;
		} finally {
			Database.closeConnection(connection);

		}
		return result;
	}

}
