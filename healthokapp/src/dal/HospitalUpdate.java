package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Hospital;
import model.HospitalPhoneNumber;




public class HospitalUpdate {


	public static int updateHospital(model.Hospital hsptl1, int id) {
		 Connection connection;
		 PreparedStatement ps3;

		int result1 = 0;
		try {
			connection = Database.createConnection();
//			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		//	java.sql.Date d = new java.sql.Date(hsptl1.getRegDate().getTime());
			String query = "Update Hospital set Name=?,HasER=?,Facilities=?,OPDFees=?,Beds=?,AddressLine1=?,AddressLine2=?,AddressLine3=?,CityId=?,PinCode=?,RegistrationDate=?,Website=?,Hasradiology=?,Hasdiagnistics=?,Hasambulance=?,AdmissionProcess=? where HospitalId=\""
					+ id + "\"";
			ps3 = connection.prepareStatement(query);
			ps3.setString(1, hsptl1.getHospitalname());
			ps3.setBoolean(2, hsptl1.isHasER());
			ps3.setString(3, hsptl1.getFacilities());
			ps3.setInt(4, hsptl1.getOpdFees());
			System.out.println("Opd Fees" + hsptl1.getOpdFees());
			ps3.setInt(5, hsptl1.getBed());
			ps3.setString(6, hsptl1.getAddressLine1());
			ps3.setString(7, hsptl1.getAddressLine2());
			ps3.setString(8, hsptl1.getAddressLine3());
			ps3.setInt(9, hsptl1.getCityId());
			ps3.setString(10, hsptl1.getPincode());
		    ps3.setDate(11,null);
			ps3.setString(12, hsptl1.getWebsite());
			ps3.setBoolean(13, hsptl1.isHasRadiology());
			ps3.setBoolean(14, hsptl1.isHasDiagnistics());
			ps3.setBoolean(15, hsptl1.isHasAmbulance());
			ps3.setString(16, hsptl1.getAddmissionProcess());

			ps3.executeUpdate();// fix code to use standard template. Check for rows updated > 0
			result1 = 1;
			
			if (new model.HospitalPhoneNumber().getHospitalPhoneNumberId() <= 1) {
				String q1 = "insert into HospitalPhoneNumbers(HospitalId,PhoneNumberType,PhoneNumber,Contact,Comments) values(?,?,?,?,?)";
				for (model.HospitalPhoneNumber hospitalphonenumber : hsptl1.getHospitalPhoneNumbers()) {
					ps3 = connection.prepareStatement(q1);

					ps3.setInt(1, hsptl1.getHospitalId());
					ps3.setInt(2, hospitalphonenumber.getPhoneNumberType());
					ps3.setString(3, hospitalphonenumber.getPhoneNumber());
					ps3.setString(4, hospitalphonenumber.getContact());
					ps3.setString(5, hospitalphonenumber.getComments());
					ps3.executeUpdate();
					System.out.println("11111111 = ");
				}
			}

			else {
				System.out.println("aaaaa = ");
				String q1 = "Update HospitalPhoneNumbers set PhoneNumber=?,Contact=?,Comments=? where HospitalId \"" + id + "\"";
				for (model.HospitalPhoneNumber Hospitalphonenumber : hsptl1.getHospitalPhoneNumbers()) {
					ps3 = connection.prepareStatement(q1);

					// ps5.setInt(1, doctorphonenumber.getDoctorId());
					// ps5.setInt(1, doctorphonenumber.getPhoneNumberType());
					ps3.setString(1, Hospitalphonenumber.getPhoneNumber());
					ps3.setString(2, Hospitalphonenumber.getContact());
					ps3.setString(3, Hospitalphonenumber.getComments());
					ps3.executeUpdate();
				}

				if (hsptl1.getDoctorHospitalAffiliation() != null) {
					String q2 = "update doctorhospitalaffiliation set DoctorId=?,AdditionalDetails=? ";
					for (model.DoctorHospitalAffiliation dochosappl : hsptl1.getDoctorHospitalAffiliation()) {
						ps3 = connection.prepareStatement(q2);
						ps3.setInt(1, dochosappl.getDoctorId());
						ps3.setString(2, dochosappl.getAdditionalDetails());
						ps3.executeUpdate();
					}
				}
			}
		}
				
		 catch (Exception e) {
			System.out.println(e);
			result1 = 500;
		}
		return result1;
	}

	
}
