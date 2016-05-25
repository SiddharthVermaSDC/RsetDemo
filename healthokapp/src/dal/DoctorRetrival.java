package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import util.Logging;

public class DoctorRetrival {

	public ArrayList<model.Doctor> searchDoctor(String searchString) {

		Connection connection = null;
		// private Statement st=null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		ArrayList<model.Doctor> results = null;
		model.Doctor doctor = null;

		try {
			connection = Database.createConnection();

			System.out.println("Connection Is Created");
			String sql = null;

			// split the string and add* after each searchText

			StringTokenizer st = new StringTokenizer(searchString);
			StringBuilder sb = new StringBuilder();
			while (st.hasMoreTokens()) {
				sb.append(st.nextToken());
				sb.append("* ");
			}

			String fulltextSearchString = sb.toString();

			String query = "select match(firstname, lastname ) against ( ? ) score1 , Doctor.*, Speciality.*"
					+ " ,match(Speciality.SpecialityText ) against ( ? ) score2" + " from Doctor"
					+ " left join Speciality on Speciality.SpecialityId = Doctor.SpecialityId"
					+ " where match(firstname, lastname ) against ( ? IN BOOLEAN MODE )  > 0 or"
					+ " match(Speciality.SpecialityText ) against ( ? IN BOOLEAN MODE ) > 0"
					+ " order by score1 desc, score2 desc";

			ps = connection.prepareStatement(query);
			ps.setString(1, fulltextSearchString);
			ps.setString(2, fulltextSearchString);
			ps.setString(3, fulltextSearchString);
			ps.setString(4, fulltextSearchString);

			rs = ps.executeQuery();

			results = new ArrayList<model.Doctor>();
			while (rs.next()) {
				doctor = this.populateDoctor(rs);

				results.add(doctor);

			}
			return results;
		} catch (SQLException se) {
			Logging.Exception("DoctorDal", "Error in query " + se.getMessage());
		}

		finally

		{
			Database.closeConnection(connection);

		}
		return results;
	}

	// for search by specialty

	public ArrayList<model.Doctor> searchDoctorBySpeciality(int specialityId) {

		Connection connection1;
		PreparedStatement ps = null;
		ResultSet rs = null;

		ArrayList<model.Doctor> results = new ArrayList<model.Doctor>();
		model.Doctor doctor = null;
		try {

			connection1 = Database.createConnection();
			String query = "select Doctor.*, Speciality.* from Doctor Join  Speciality on Doctor.SpecialityId = Speciality.SpecialityId where Doctor.SpecialityId= ?";
			ps = connection1.prepareStatement(query);
			ps.setInt(1, specialityId);

			rs = ps.executeQuery();
			System.out.println(rs);
			while (rs.next()) {

				doctor = this.populateDoctor(rs);

				results.add(doctor);
			}
			return results;

		} catch (Exception e) {
			System.out.println("SQL Exception");
		}
		return null;
	}

	private model.Doctor populateDoctor(ResultSet rs) {
		model.Doctor doctor = new model.Doctor();

		try {
			doctor.setDoctorId(rs.getInt("DoctorId"));
			doctor.setEmergencyFees(rs.getInt("EmergencyFees"));
			doctor.setIsBelongToAnyHospital(rs.getString("IsBelongToAnyHospitals"));
			doctor.setDoctorRegistrationDate(rs.getDate("DoctorRegistrationDate"));
			doctor.setEmailId(rs.getString("EmailId"));
			doctor.setProvideHomecare(rs.getBoolean("IsProvideHomeCare"));
			doctor.setPharmacy(rs.getBoolean("IsPharmacy"));
			doctor.setFirstName(rs.getString("FirstName"));
			doctor.setMiddleName(rs.getString("MiddleName"));
			doctor.setLastName(rs.getString("LastName"));
			doctor.setSpecialityId(rs.getInt("SpecialityId"));
			doctor.setDoctorImageid(rs.getInt("DoctorImageId"));
			doctor.setSpecialityId(rs.getInt("SpecialityId"));
			doctor.setSpeciality(rs.getString("Specialization"));
			
			doctor.setDegree(rs.getString("Degree"));
			doctor.setClinicTiming(rs.getString("ClinicTiming"));
			doctor.setOffDay(rs.getString("OffDay"));
			doctor.setFees(rs.getInt("Fees"));
			doctor.setInPanel(rs.getBoolean("InPanel"));
			doctor.setAppointmnet(rs.getBoolean("IsAppointmentEnabled"));
			doctor.setVirtualReceptionist(rs.getBoolean("isVirtualReceptionistEnabled"));
			doctor.setPostcare(rs.getBoolean("IsProvidePostCareEnabled"));
			doctor.setYearofExperience(rs.getInt("YearOfExperience"));
			doctor.setAddressLine1(rs.getString("AddressLine1"));
			doctor.setAddressLine2(rs.getString("AddressLine2"));
			doctor.setAddressLine3(rs.getString("AddressLine3"));
			doctor.setCityId(rs.getInt("CityId"));
			doctor.setPincode(rs.getString("PinCode"));
			doctor.setProvideEmergencyCare(rs.getBoolean("ProvideEmergencyCare"));
			doctor.setTaleMedicineEnabled(rs.getBoolean("IsTeleMedicineEnabled"));
			doctor.setHasOwnHospital(rs.getString("HasOwnHospital"));
			doctor.setWebSite(rs.getString("Website"));
			doctor.setProvideHomeConsultationFees(rs.getBoolean("IsProvideHomeConsultationFees"));
			doctor.setIsDiagnostics(rs.getBoolean("IsDiagnostics"));
			doctor.setIsProvideAnsweringService(rs.getBoolean("IsProvideAnsweringService"));
			doctor.setIsProvidePostCallFollowup(rs.getBoolean("IsProvidePostCallFollowup"));
			doctor.setHealth_panel(rs.getBoolean("Health_panel"));
			
			return doctor;

		} catch (SQLException se) {
			Logging.Exception("FillDocModel", "Error Populating Doctor Model " + se.getMessage());

		}

		return doctor;
	}

	// TODO Add methods to get ArrayList for DoctorPhoneNumbers and
	// DoctorHospitalAssociation given DoctorId.

}
