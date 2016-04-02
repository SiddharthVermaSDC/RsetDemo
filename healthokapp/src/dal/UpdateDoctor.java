package dal;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class UpdateDoctor {

	static Connection connection;
	static PreparedStatement ps5;
	static ResultSet rs;

	public static int update(model.Doctor doctor, int val) {
		int result = 0;

		try {
			connection = Database.createConnection();;
			
			String q = "update doctor set EmergencyFees=?,IsBelongToAnyHospital=?,DoctorRegistrationDate=?,EmailId=?,IsProvideHomeCare=?,IsPharmacy=?,FirstName=?,MiddleName=?,LastName=?,SpecialityId=?,Degree=?,ClinicTiming=?,OffDay=?,Fees=?,InPanel=?,IsAppointmentEnabled=?,isVirtualReceptionistEnabled=?,IsPostCareEnabled=?,DoctorImageId=?,YearsOfExperience=?,AddressLine1=?,AddressLine2=?,AddressLine3=?,CityId=?,PinCode=?) where DoctorId=\""
					+ val + "\"";
			
			
			ps5 = connection.prepareStatement(q,Statement.RETURN_GENERATED_KEYS);
			
			ps5.setString(7, doctor.getFirstName());
			ps5.setString(8, doctor.getMiddleName());
			ps5.setString(9, doctor.getLastName());
			System.out.println("DoctorFrist name" + doctor.getFirstName());
			ps5.setString(4, doctor.getEmailId());
			ps5.setInt(10, doctor.getSpecialityId());
			ps5.setString(11, doctor.getDegree());

			ps5.setDate(3, new java.sql.Date(doctor.getDoctorRegistrationDate().getTime()));

			ps5.setString(12, doctor.getClinicTiming());
			ps5.setString(13, doctor.getOffDay());
			ps5.setInt(14, doctor.getFees());
			ps5.setInt(1, doctor.getEmergencyFees());
			ps5.setBoolean(6, doctor.isPharmacy());
			ps5.setBoolean(5, doctor.isProvideHomecare());
			ps5.setBoolean(2, doctor.isBelongToAnyHospital());
			ps5.setBoolean(15, doctor.isInPanel());
			ps5.setBoolean(16, doctor.isAppointmnet());
			ps5.setBoolean(17, doctor.isVirtualReceptionist());
			ps5.setBoolean(18, doctor.isPostcare());
			ps5.setInt(19, doctor.getDoctorImageid());
//		    System.out.println("ImageId="+doctor.getDoctorImageid());
			ps5.setInt(20, doctor.getYearofExperience());
			ps5.setString(21, doctor.getAddressLine1());
			ps5.setString(22, doctor.getAddressLine2());
			ps5.setString(23, doctor.getAddressLine3());
			ps5.setInt(24, doctor.getCityId());
			ps5.setString(25, doctor.getPincode());
			result = 1;
			int row1 = ps5.executeUpdate();
			if (row1 == 1)
				rs = ps5.getGeneratedKeys();
			if (rs.next())
				doctor.setDoctorId(rs.getInt(1));
			String q1 = "insert into DoctorPhoneNumbers(DoctorId,PhoneNumberType,PhoneNumber,Contact,Comments) values(?,?,?,?,?)";
			ps5 = connection.prepareStatement(q1);
			ps5.setInt(1, doctor.getDoctorId());
			ps5.setInt(2, doctor.getPhoneNumberType());
			ps5.setString(3, doctor.getPhoneNumber());
			ps5.setString(4, doctor.getContact());
			//ps5.setString(5, doctor.getComment());
			ps5.executeUpdate();

			Database.closeConnection(connection);
		} catch (Exception e) {
			System.out.println(e);
			result = 500;

		}
		return result;
	}

}
