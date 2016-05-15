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

			// SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		//	java.sql.Date d = new java.sql.Date((hospital.getRegDate()).getTime());

			String query = "Insert Into Hospital(Name,AddressId,HasER,Facilities,OPDFees,Beds,AddressLine1,AddressLine2,AddressLine3,CityId,PinCode,RegistrationDate,Website,Hasradiology,Hasdiagnistics,Hasambulance,AdmissionProcess) Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			System.out.println("Statement Is Created");
			ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, hospital.getHospitalname());
			ps.setInt(2, hospital.getAddressId());
			ps.setBoolean(3, hospital.isHasER());
			ps.setString(4, hospital.getFacilities());
			ps.setInt(5, hospital.getOpdFees());
			System.out.println("Opd Fees" + hospital.getOpdFees());
			ps.setInt(6, hospital.getBed());
			ps.setString(7, hospital.getAddressLine1());
			ps.setString(8, hospital.getAddressLine2());
			ps.setString(9, hospital.getAddressLine3());
			ps.setInt(10, hospital.getCityId());
			ps.setString(11, hospital.getPincode());
		//	ps.setDate(12, (java.sql.Date) d);
			 ps.setString(12,null);
			ps.setString(13, hospital.getWebsite());
			//ps.setString(14, hospital.getPhonenumber());
			ps.setBoolean(14, hospital.isHasRadiology());
			ps.setBoolean(15, hospital.isHasDiagnistics());
			ps.setBoolean(16, hospital.isHasAmbulance());
			ps.setString(17, hospital.getAddmissionProcess());

			rw = ps.executeUpdate();
			if (rw > 0) {
				rs = ps.getGeneratedKeys();
				if (rs.next())
					// result =rs.getInt(1);
					hospital.setHospitalId(rs.getInt(1));
				System.out.println("Hospital Id =" + hospital.getHospitalId());
			}
			
			if(hospital.getHospitalPhoneNumbers()!=null)
			{
				String q1=new String("insert into HospitalPhoneNumbers(HospitalId,PhoneNumber,PhoneNumberType,Contact,Comments)"+"values(?,?,?,?,?);");
				for(model.HospitalPhoneNumber hospitalphonenumber: hospital.getHospitalPhoneNumbers())
				{
					ps = connection.prepareStatement(q1);
	              //  System.out.println(doctorphonenumber.getPhoneNumber());
	              //  System.out.println(doctorphonenumber.getDoctorPhoneNumberId());

					//ps = connection.prepareStatement(q1);
					ps.setInt(1, hospital.getHospitalId());
					
					ps.setInt(2, hospitalphonenumber.getPhoneNumberType());
					ps.setString(3, hospitalphonenumber.getPhoneNumber());
					System.out.println("DoctorPhone =" + hospital.getPhonenumber());
					ps.setString(4, hospitalphonenumber.getContact());
					ps.setString(5, hospitalphonenumber.getComments());
					ps.executeUpdate();
					result = 1;
				}
			}
			
			 if(hospital.getDoctorHospitalAffiliation()!=null)
	            {
				String q2 = "insert into doctorhospitalaffiliation(DoctorId,HospitalId,AdditionalDetails) values(?,?,?)";
				for (model.DoctorHospitalAffiliation dochosappl : hospital.getDoctorHospitalAffiliation()) {
					ps = connection.prepareStatement(q2);

					ps = connection.prepareStatement(q2);
					ps.setInt(1, dochosappl.getDoctorId() );
					// System.out.println("DoctorPhone ="+dochosappl.getDoctorId());
					ps.setInt(2, dochosappl.getHospitalId());
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
