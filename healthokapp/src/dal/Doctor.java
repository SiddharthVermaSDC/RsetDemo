package dal;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import rest_api.DatabaseConnectivity;

public class Doctor {

	static Connection connection;
	static PreparedStatement ps;
	static ResultSet rs;

	public static int insertDoctor(model.Doctor doctor) {
		int result = 0;

		try {
			connection = DatabaseConnectivity.getInstance().getConnection();
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			java.sql.Date d = new java.sql.Date(format.parse(doctor.getDoctorRegDate()).getTime());
			FileInputStream fin = new FileInputStream(doctor.getImages());
			String sql = "INSERT INTO Images (ImageTypeId,Image) values (?,?)";
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, doctor.getImageTypeId());
			ps.setBinaryStream(2, fin, fin.available());
			int row = ps.executeUpdate();
			if (row == 1)
				rs = ps.getGeneratedKeys();
			if (rs.next())
				doctor.setImageid(rs.getInt(1));
			// String q1 = "insert into doctor(PinCode) values(?);";
			String q = "insert into doctor (FirstName,MiddleName,LastName,EmailId,Speciality,Degree,DoctorRegistrationDate,ClinicTiming,offDay,Fees,EmergencyFees,IsPharmacy,IsProvideHomeCare,IsBelongToAnyHospital,InPanel,IsAppointmentEnabled,isVirtualReceptionistEnabled,IsPostCareEnabled,DoctorImageId,YearsofExperience,AddressLine1,AddressLine2,AddressLine3,CityId,PinCode) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = connection.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);
			// ps.setString(1,doctor.getPincode());
			ps.setString(1, doctor.getFirstName());
			ps.setString(2, doctor.getMiddleName());
			ps.setString(3, doctor.getLastName());
			System.out.println("DoctorFrist name" + doctor.getFirstName());
			ps.setString(4, doctor.getEmailId());
			ps.setInt(5, doctor.getSpeciality());
			ps.setString(6, doctor.getDegree());
			// ps.setInt(7, doctor.getDoctorPhoneId());
			// ps.setDate(7,doctor.getDoctorRegDate());
			ps.setDate(7, (java.sql.Date) d);
			System.out.println("Date=" + doctor.getDoctorRegDate());
			ps.setString(8, doctor.getClinicTiming());
			ps.setString(9, doctor.getOffDay());
			ps.setInt(10, doctor.getFees());
			ps.setInt(11, doctor.getEmergencyFees());
			ps.setBoolean(12, doctor.isPharamacy());
			ps.setBoolean(13, doctor.isProvideHomecare());
			ps.setBoolean(14, doctor.isBelongToHospital());
			ps.setBoolean(15, doctor.isInPanel());
			ps.setBoolean(16, doctor.isAppointmnet());
			ps.setBoolean(17, doctor.isVirtualReceptionist());
			ps.setBoolean(18, doctor.isPostcare());
			ps.setInt(19, doctor.getImageid());
			// System.out.println("ImageId="+doctor.getImageid());
			ps.setInt(20, doctor.getYearofExperience());
			ps.setString(21, doctor.getAddressLine1());
			ps.setString(22, doctor.getAddressLine2());
			ps.setString(23, doctor.getAddressLine3());
			ps.setInt(24, doctor.getCityId());
			ps.setString(25, doctor.getPincode());
			result = 10;
			int row1 = ps.executeUpdate();
			if (row1 == 1)
				rs = ps.getGeneratedKeys();
			if (rs.next())
				doctor.setDoctorId(rs.getInt(1));
			String q1 = "insert into DoctorPhoneNumbers(DoctorId,PhoneNumberType,PhoneNumber,Contact,Comments) values(?,?,?,?,?)";
			ps = connection.prepareStatement(q1);
			ps.setInt(1,doctor.getDoctorId() );
			ps.setInt(2, doctor.getPhoneNumberType());
			ps.setString(3, doctor.getPhoneNumber());
			ps.setString(4, doctor.getContact());
			ps.setString(5, doctor.getComment());
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
			result = 500;

			
		}
		return result;
	}
	
}
