package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateDoctor {

	static Connection connection;
	static PreparedStatement ps5;
	static ResultSet rs;

	public static int update(model.Doctor doctor, int val) {
		int result = 0;

		try {
			connection = Database.createConnection();

			String q = "update doctor set EmergencyFees=?,IsBelongToAnyHospital=?,EmailId=?,IsProvideHomeCare=?,IsPharmacy=?,FirstName=?,MiddleName=?,LastName=?,SpecialityId=?,Degree=?,ClinicTiming=?,OffDay=?,Fees=?,InPanel=?,IsAppointmentEnabled=?,isVirtualReceptionistEnabled=?,IsPostCareEnabled=?,DoctorImageId=?,YearsOfExperience=?,AddressLine1=?,AddressLine2=?,AddressLine3=?,CityId=?,PinCode=? where DoctorId=\""
					+ val + "\"";
			ps5 = connection.prepareStatement(q);
			ps5.setInt(1, doctor.getEmergencyFees());
			System.out.println("EmergencyFees " + doctor.getEmergencyFees());
			ps5.setBoolean(2, doctor.isBelongToAnyHospital());
			// java.sql.Date(doctor.getDoctorRegistrationDate().getTime()));
			ps5.setString(3, doctor.getEmailId());
			System.out.println("EmailId " + doctor.getEmailId());
			ps5.setBoolean(4, doctor.isProvideHomecare());
			ps5.setBoolean(5, doctor.isPharmacy());
			ps5.setString(6, doctor.getFirstName());
			ps5.setString(7, doctor.getMiddleName());
			ps5.setString(8, doctor.getLastName());
			System.out.println("DoctorFrist Name " + doctor.getFirstName());
			ps5.setInt(9, doctor.getSpecialityId());
			ps5.setString(10, doctor.getDegree());
			ps5.setString(11, doctor.getClinicTiming());
			ps5.setString(12, doctor.getOffDay());
			ps5.setInt(13, doctor.getFees());
			ps5.setBoolean(14, doctor.isInPanel());
			ps5.setBoolean(15, doctor.isAppointmnet());
			ps5.setBoolean(16, doctor.isVirtualReceptionist());
			ps5.setBoolean(17, doctor.isPostcare());
			ps5.setInt(18, doctor.getDoctorImageid());
			System.out.println("ImageId=" + doctor.getDoctorImageid());
			ps5.setInt(19, doctor.getYearofExperience());
			ps5.setString(20, doctor.getAddressLine1());
			ps5.setString(21, doctor.getAddressLine2());
			ps5.setString(22, doctor.getAddressLine3());
			ps5.setInt(23, doctor.getCityId());
			ps5.setString(24, doctor.getPincode());
			System.out.println("PinCode = " + doctor.getPincode());
			result = 1;
			ps5.executeUpdate();

			if (new model.DoctorPhoneNumber().getDoctorPhoneNumberId() <= 1) {
				String q1 = "insert into DoctorPhoneNumbers(DoctorId,PhoneNumberTypeID,PhoneNumber,Contact,Comments) values(?,?,?,?,?)";
				for (model.DoctorPhoneNumber doctorphonenumber : doctor.getDoctorPhoneNumbers()) {
					ps5 = connection.prepareStatement(q1);

					ps5.setInt(1, doctorphonenumber.getDoctorId());
					ps5.setInt(2, doctorphonenumber.getPhoneNumberType());
					ps5.setString(3, doctorphonenumber.getPhoneNumber());
					ps5.setString(4, doctorphonenumber.getContact());
					ps5.setString(5, doctorphonenumber.getComments());
					ps5.executeUpdate();
					System.out.println("11111111 = ");
				}
			}

			else {
				System.out.println("aaaaa = ");
				String q1 = "Update DoctorPhoneNumbers set PhoneNumber=?,Contact=?,Comments=? where DoctorId = \"" + val + "\"";
				System.out.println("qi = " + q1);
				for (model.DoctorPhoneNumber doctorphonenumber : doctor.getDoctorPhoneNumbers()) {
					ps5 = connection.prepareStatement(q1);

					// ps5.setInt(1, doctorphonenumber.getDoctorId());
					// ps5.setInt(1, doctorphonenumber.getPhoneNumberType());
					ps5.setString(1, doctorphonenumber.getPhoneNumber());
					ps5.setString(2, doctorphonenumber.getContact());
					ps5.setString(3, doctorphonenumber.getComments());
					ps5.executeUpdate();
				}

				if (doctor.getDoctorHospitalAffiliation() != null) {
					String q2 = "update doctorhospitalaffiliation set HospitalId=?,AdditionalDetails=? ";
					for (model.DoctorHospitalAffiliation dochosappl : doctor.getDoctorHospitalAffiliation()) {
						ps5 = connection.prepareStatement(q2);
						ps5.setInt(1, dochosappl.getHospitalId());
						ps5.setString(2, dochosappl.getAdditionalDetails());
						ps5.executeUpdate();
					}
				}
			}

			Database.closeConnection(connection);
		} catch (Exception e) {
			System.out.println(e);
			result = 500;

		}
		return result;
	}

}
