package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;




public class HospitalUpdate {


	public static int updateHospital(model.Hospital hsptl1) {
		 Connection connection;
		 PreparedStatement ps3;

		int result1 = 0;
		try {
			connection = Database.createConnection();
//			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		//	java.sql.Date d = new java.sql.Date(hsptl1.getRegDate().getTime());
			String query = "Update Hospital set Name=?,AddressId=?,HasER=?,Facilities=?,OPDFees=?,Beds=?,AddressLine1=?,AddressLine2=?,AddressLine3=?,CityId=?,PinCode=?,RegistrationDate=?,Website=?,Hospitalphonenumber=?,Hasradiology=?,Hasdiagnistics=?,Hasambulance=?,AdmissionProcess=? where HospitalId=?";
			ps3 = connection.prepareStatement(query);
			ps3.setString(1, hsptl1.getHospitalname());
			ps3.setBoolean(3, hsptl1.isHasER());
			ps3.setString(4, hsptl1.getFacilities());
			ps3.setInt(5, hsptl1.getOpdFees());
			System.out.println("Opd Fees" + hsptl1.getOpdFees());
			ps3.setInt(6, hsptl1.getBed());
			ps3.setString(7, hsptl1.getAddressLine1());
			ps3.setString(8, hsptl1.getAddressLine2());
			ps3.setString(9, hsptl1.getAddressLine3());
			ps3.setInt(10, hsptl1.getCityId());
			ps3.setString(11, hsptl1.getPincode());
		//	ps3.setDate(12, (java.sql.Date) d);
		    ps3.setDate(12,null);
			ps3.setString(13, hsptl1.getWebsite());
			ps3.setString(14, hsptl1.getPhonenumber());
			ps3.setBoolean(15, hsptl1.isHasRadiology());
			ps3.setBoolean(16, hsptl1.isHasDiagnistics());
			ps3.setBoolean(17, hsptl1.isHasAmbulance());
			ps3.setString(18, hsptl1.getAddmissionProcess());
			ps3.setInt(19, hsptl1.getHospitalId());

			ps3.executeUpdate();// fix code to use standard template. Check for rows updated > 0
			result1 = 1;
		} catch (Exception e) {
			System.out.println(e);
			result1 = 500;
		}
		return result1;
	}
}
