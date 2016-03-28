package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class Hospital {


	public  int addHospital(model.Hospital hospital) {
		int result = 0;
		int rw = 0;
		 Connection connection = null;
		 PreparedStatement ps = null;
ResultSet rs = null;

		
		try {
			connection = Database.createConnection();

			//SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			java.sql.Date d = new java.sql.Date((hospital.getRegDate()).getTime());
			
			String query = "Insert Into Hospital(Name,AddressId,HasER,Facilities,OPDFees,Beds,AddressLine1,AddressLine2,AddressLine3,CityId,PinCode,RegistrationDate,Website,Hospitalphonenumber,Hasradiology,Hasdiagnistics,Hasambulance,AdmissionProcess) Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			ps.setDate(12, (java.sql.Date) d);
			// ps.setDate(12,hsptl.getRegDate());
			ps.setString(13, hospital.getWebsite());
			ps.setString(14, hospital.getPhonenumber());
			ps.setBoolean(15, hospital.isHasRadiology());
			ps.setBoolean(16, hospital.isHasDiagnistics());
			ps.setBoolean(17, hospital.isHasAmbulance());
			ps.setString(18, hospital.getAddmissionProcess());

			rw = ps.executeUpdate();
			   if(rw>0)
			   {
				  rs = ps.getGeneratedKeys();
	                if(rs.next())
	                    result =rs.getInt(1);
	 }
		
			   else{
				   result=-1;
			   }
			
			
return result; 

		} catch (Exception e) {
			System.out.println(e);
			result = -1;
		}
		finally 
		{
			Database.closeConnection(connection);

			
		}
		return result;
	}

}
