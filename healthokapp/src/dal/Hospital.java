package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import rest_api.DatabaseConnectivity;

public class Hospital {

	static Connection connection;
	static PreparedStatement ps;
	static ResultSet rs;
	
	public static int addHospital(model.Hospital hsptl) {
		int result=0;
		try
		{
			connection = DatabaseConnectivity.getInstance().getConnection();
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); 
			java.sql.Date d= new java.sql.Date(format.parse(hsptl.getRegDate()).getTime());
			String query="Insert Into Hospital(Name,AddressId,HasER,Facilities,OPDFees,Beds,AddressLine1,AddressLine2,AddressLine3,CityId,PinCode,RegistrationDate,Website,Hospitalphonenumber,Hasradiology,Hasdiagnistics,Hasambulance,AdmissionProcess) Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=connection.prepareStatement(query);
			ps.setString(1, hsptl.getHospitalname());
			ps.setInt(2, hsptl.getAddressId());
			ps.setBoolean(3,hsptl.isHasER());
			ps.setString(4,hsptl.getFacilities());
			ps.setInt(5,hsptl.getOpdFees());
			System.out.println("Opd Fees"+hsptl.getOpdFees());
			ps.setInt(6,hsptl.getBed());
			ps.setString(7,hsptl.getAddressLine1());
			ps.setString(8,hsptl.getAddressLine2());
			ps.setString(9,hsptl.getAddressLine3());
			ps.setInt(10,hsptl.getCityId());
			ps.setString(11,hsptl.getPincode());
			ps.setDate(12,(java.sql.Date) d);
		//	ps.setDate(12,hsptl.getRegDate());
			ps.setString(13,hsptl.getWebsite());
			ps.setString(14,hsptl.getPhonenumber());
			ps.setBoolean(15,hsptl.isHasRadiology());
			ps.setBoolean(16,hsptl.isHasDiagnistics());
			ps.setBoolean(17,hsptl.isHasAmbulance());
			ps.setString(18,hsptl.getAddmissionProcess());
			
			ps.executeUpdate();
			result = 1;
		}
		catch(Exception e)
		{
			System.out.println(e);
			result=500;
		}
		return result;
	}


	public static int updateHospital(int id,model.Hospital hsptl1) {
	  
		int result1=0;
		try
		{
			Connection connection1 = DatabaseConnectivity.getInstance().getConnection();
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); 
			java.sql.Date d= new java.sql.Date(format.parse(hsptl1.getRegDate()).getTime());
			String query="Update Hospital set (Name,AddressId,HasER,Facilities,OPDFees,Beds,AddressLine1,AddressLine2,AddressLine3,CityId,PinCode,RegistrationDate,Website,Hospitalphonenumber,Hasradiology,Hasdiagnistics,Hasambulance,AdmissionProcess) Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) where HospitalId=\""+id+"\"";
			ps=connection1.prepareStatement(query);
			ps.setString(1, hsptl1.getHospitalname());
			ps.setInt(2, hsptl1.getAddressId());
			ps.setBoolean(3,hsptl1.isHasER());
			ps.setString(4,hsptl1.getFacilities());
			ps.setInt(5,hsptl1.getOpdFees());
			System.out.println("Opd Fees"+hsptl1.getOpdFees());
			ps.setInt(6,hsptl1.getBed());
			ps.setString(7,hsptl1.getAddressLine1());
			ps.setString(8,hsptl1.getAddressLine2());
			ps.setString(9,hsptl1.getAddressLine3());
			ps.setInt(10,hsptl1.getCityId());
			ps.setString(11,hsptl1.getPincode());
			ps.setDate(12,(java.sql.Date) d);
		//	ps.setDate(12,hsptl.getRegDate());
			ps.setString(13,hsptl1.getWebsite());
			ps.setString(14,hsptl1.getPhonenumber());
			ps.setBoolean(15,hsptl1.isHasRadiology());
			ps.setBoolean(16,hsptl1.isHasDiagnistics());
			ps.setBoolean(17,hsptl1.isHasAmbulance());
			ps.setString(18,hsptl1.getAddmissionProcess());
			
			ps.executeUpdate();
			result1 = 1;
		}
		catch(Exception e)
		{
			System.out.println(e);
			result1=500;
		}
		return result1;
	}

}
