package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import util.StatusCode;

public class Doctor {

	public static int insertDoctor(model.Doctor doctor) {
		int result = 0;

		Connection connection = null;
		PreparedStatement ps;
		ResultSet rs;
	//	StatusCode status = StatusCode.UnknownError;

		try {
			connection = Database.createConnection();

			String q = "insert into doctor (FirstName,MiddleName,LastName,EmailId,SpecialityId,Degree,DoctorRegistrationDate,ClinicTiming,offDay,Fees,EmergencyFees,IsPharmacy,IsProvideHomeCare,IsBelongToAnyHospital,InPanel,IsAppointmentEnabled,isVirtualReceptionistEnabled,IsPostCareEnabled,DoctorImageId,YearsofExperience,AddressLine1,AddressLine2,AddressLine3,CityId,PinCode,ProvideEmergencyCare,IsTeleMedicineEnabled,HasOwnHospital,Website) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = connection.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, doctor.getFirstName());
			ps.setString(2, doctor.getMiddleName());
			ps.setString(3, doctor.getLastName());
		//	System.out.println("DoctorFrist name" + doctor.getFirstName());
			ps.setString(4, doctor.getEmailId());
			ps.setInt(5, doctor.getSpecialityId());
			ps.setString(6, doctor.getDegree());
			System.out.println("Degree=" + doctor.getDegree());
			// doctor.getDoctorRegistrationDate().getTime()));
			ps.setDate(7, null);
		//	System.out.println("Date =" + doctor.getDoctorRegistrationDate());
			ps.setString(8, doctor.getClinicTiming());
		//	System.out.println("Clinic Time =" + doctor.getClinicTiming());
			ps.setString(9, doctor.getOffDay());
			ps.setInt(10, doctor.getFees());
			ps.setInt(11, doctor.getEmergencyFees());
			ps.setBoolean(12, doctor.isPharmacy());
			ps.setBoolean(13, doctor.isProvideHomecare());
			ps.setBoolean(14, doctor.isBelongToAnyHospital());
			ps.setBoolean(15, doctor.isInPanel());
			ps.setBoolean(16, doctor.isAppointmnet());
			ps.setBoolean(17, doctor.isVirtualReceptionist());
			ps.setBoolean(18, doctor.isPostcare());
			ps.setInt(19, doctor.getDoctorImageid());
			// System.out.println("ImageId="+doctor.getImageid());
			ps.setInt(20, doctor.getYearofExperience());
			ps.setString(21, doctor.getAddressLine1());
			ps.setString(22, doctor.getAddressLine2());
			ps.setString(23, doctor.getAddressLine3());
			ps.setInt(24, doctor.getCityId());
			ps.setString(25, doctor.getPincode());
			ps.setBoolean(26, doctor.isProvideEmergencyCare());
			ps.setBoolean(27, doctor.isTaleMedicineEnabled());
			ps.setInt(28, doctor.getHasOwnHospital());
			ps.setString(29, doctor.getWebSite());
			System.out.println("Pin Code= " + doctor.getPincode());
			result = 1;
			int row1 = ps.executeUpdate();
			if (row1 == 1) {
				rs = ps.getGeneratedKeys();
                 
				if (rs.next())
					doctor.setDoctorId(rs.getInt(1));
				System.out.println(doctor.getDoctorId());
			}

			if(doctor.getDoctorPhoneNumbers()!=null)
			{
			String q1= new String("insert into DoctorPhoneNumbers(DoctorId,PhoneNumberTypeId,PhoneNumber,Contact,Comments)" + "values(?,?,?,?,?);");
			for (model.DoctorPhoneNumber doctorphonenumber : doctor.getDoctorPhoneNumbers()) {
				ps = connection.prepareStatement(q1);
                System.out.println(doctorphonenumber.getPhoneNumber());
                System.out.println(doctorphonenumber.getDoctorPhoneNumberId());

				//ps = connection.prepareStatement(q1);
				ps.setInt(1, doctor.getDoctorId());
				System.out.println("DoctorPhone =" + doctor.getDoctorId());
				ps.setInt(2, doctorphonenumber.getPhoneNumberType());
				ps.setString(3, doctorphonenumber.getPhoneNumber());
				ps.setString(4, doctorphonenumber.getContact());
				ps.setString(5, doctorphonenumber.getComments());
				ps.executeUpdate();
				result = 1;
				
			}
		//	status= StatusCode.Success;
			}
            if(doctor.getDoctorHospitalAffiliation()!=null)
            {
			String q2 = "insert into doctorhospitalaffiliation(DoctorId,HospitalId,AdditionalDetails) values(?,?,?)";
			for (model.DoctorHospitalAffiliation dochosappl : doctor.getDoctorHospitalAffiliation()) {
				ps = connection.prepareStatement(q2);

				ps = connection.prepareStatement(q2);
				ps.setInt(1, doctor.getDoctorId());
				// System.out.println("DoctorPhone ="+dochosappl.getDoctorId());
				ps.setInt(2, dochosappl.getHospitalId());
				ps.setString(3, dochosappl.getAdditionalDetails());

				ps.executeUpdate();
			}
            }
		} catch (Exception e) {
			System.out.println(e);
			result = 500;

		}

		 finally 
	     { 
			 Database.closeConnection(connection);  
	      }
		return result;
		
	//	return status;
	//	return result;

	}

}
