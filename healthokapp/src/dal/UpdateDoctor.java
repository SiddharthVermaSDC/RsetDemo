package dal;
    import java.io.FileInputStream;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.text.SimpleDateFormat;

	import rest_api.DatabaseConnectivity;

	public class UpdateDoctor {

		static Connection connection;
		static PreparedStatement ps;
		static ResultSet rs;

		public static int update(model.Doctor doctor,int val) {
			int result = 0;

			try {
				connection = DatabaseConnectivity.getInstance().getConnection();
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				java.sql.Date d = new java.sql.Date(format.parse(doctor.getDoctorRegDate()).getTime());
			/*	 FileInputStream fin = new FileInputStream(doctor.getImages());
				String sql = "INSERT INTO Images (ImageTypeId,Image) values (?,?)";
				ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, doctor.getImageTypeId());
				ps.setBinaryStream(2, fin, fin.available());
				int row = ps.executeUpdate();
				if (row == 1)
					rs = ps.getGeneratedKeys();
				if (rs.next())
					doctor.setImageid(rs.getInt(1));
				// String q1 = "insert into doctor(PinCode) values(?);"; */
				String q = "update doctor set (EmergencyFees,IsBelongToAnyHospital,DoctorRegistrationDate,EmailId,IsProvideHomeCare,IsPharmacy,FirstName,MiddleName,LastName,Speciality,Degree,ClinicTiming,OffDay,Fees,InPanel,IsAppointmentEnabled,isVirtualReceptionistEnabled,IsPostCareEnabled,DoctorImageId,YearsOfExperience,AddressLine1,AddressLine2,AddressLine3,CityId,PinCode) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) where DoctorId=\""+val+"\"";              
				ps = connection.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);
				// ps.setString(1,doctor.getPincode());
				ps.setString(7, doctor.getFirstName());
				ps.setString(8, doctor.getMiddleName());
				ps.setString(9, doctor.getLastName());
				System.out.println("DoctorFrist name" + doctor.getFirstName());
				ps.setString(4, doctor.getEmailId());
				ps.setInt(10, doctor.getSpeciality());
				ps.setString(11, doctor.getDegree());
				
				ps.setDate(3, (java.sql.Date) d);
				System.out.println("Date=" + doctor.getDoctorRegDate());
				ps.setString(12, doctor.getClinicTiming());
				ps.setString(13, doctor.getOffDay());
				ps.setInt(14, doctor.getFees());
				ps.setInt(1, doctor.getEmergencyFees());
				ps.setBoolean(6, doctor.isPharamacy());
				ps.setBoolean(5, doctor.isProvideHomecare());
				ps.setBoolean(2, doctor.isBelongToHospital());
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


