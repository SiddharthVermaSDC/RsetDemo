package dal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import util.Logging;

 
public class DoctorRetrival {

	
	
	
	public ArrayList<model.Doctor> searchDoctor ( String searchString)
	{

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
					while ( st.hasMoreTokens())
					{
						sb.append(st.nextToken());
						sb.append("* ");
					}
					
					String fulltextSearchString = sb.toString(); 
					
					String query = "select match(firstname, lastname ) against ( ? ) score1 , Doctor.*, Speciality.*"
							 	+ " ,match(Speciality.SpecialityText ) against ( ? ) score2" 
							 	+ " from Doctor"
							 	+ " left join Speciality on Speciality.SpecialityId = Doctor.Speciality"
							 	+ " where match(firstname, lastname ) against ( ? IN BOOLEAN MODE )  > 0 or" 
							    + " match(Speciality.SpecialityText ) against ( ? IN BOOLEAN MODE ) > 0"
							    + " order by score1 desc, score2 desc";

					ps = connection.prepareStatement(query);
					ps.setString(1,fulltextSearchString );
					ps.setString(2,fulltextSearchString );
					ps.setString(3,fulltextSearchString );
					ps.setString(4,fulltextSearchString );

					rs = ps.executeQuery();
					
					results = new ArrayList<model.Doctor>();
					while (rs.next())
					{
						doctor = new model.Doctor();
						doctor.setDoctorId(rs.getInt("DoctorId"));
						doctor.setEmergencyFees(rs.getInt("EmergencyFees"));
						doctor.setIsBelongToAnyHospital(rs.getBoolean("IsBelongToAnyHospital"));
						doctor.setDoctorRegistrationDate(rs.getDate("DoctorRegistrationDate"));
						doctor.setEmailId(rs.getString("EmailId"));
						doctor.setIsProvideHomecare(rs.getBoolean("IsProvideHomeCare"));
						doctor.setIsPharmacy(rs.getBoolean("IsPharmacy"));
						doctor.setFirstName(rs.getString("FirstName"));
						doctor.setMiddleName(rs.getString("MiddleName"));
						doctor.setLastName(rs.getString("LastName"));
						doctor.setSpecialityId(rs.getInt("SpecialityId"));
						doctor.setDoctorImageid(rs.getInt("doctorImageId"));
/* fill in the rest.
  						String degree = rs.getString("Degree");
 
						String clinicTiming = rs.getString("ClinicTiming");
						String offDay = rs.getString("OffDay");
						int fees = rs.getInt("Fees");
						boolean inPanel = rs.getBoolean("InPanel");
						boolean appointmnet = rs.getBoolean("IsAppointmentEnabled");
						boolean virtualReceptionist = rs.getBoolean("isVirtualReceptionistEnabled");
						boolean postcare = rs.getBoolean("IsPostCareEnabled");
						int yearofExperience = rs.getInt("YearsOfExperience");
						String addressLine1 = rs.getString("AddressLine1");
						String addressLine2 = rs.getString("AddressLine2");
						String addressLine3 = rs.getString("AddressLine3");
*/					
						results.add(doctor);
						
					}
					return results;
				}
				catch ( SQLException se)
				{
					Logging.Exception("DoctorDal", "Error in query " + se.getMessage());	
				}
				
				finally 
				
				{
					Database.closeConnection(connection);
					
				}
				return results;
	}

	
	// this query is supposed to be like google search. Look at the next method. 
	public  ArrayList<model.DoctorRetrival> responseDoctor(String fname, String mname, String lname, int count) {
		ArrayList<model.DoctorRetrival> doc = new ArrayList<model.DoctorRetrival>();
		// long i=1;
		// connection = DatabaseConnectivity.getInstance().getConnection();

		 Connection connection;
			// private Statement st=null;
			 PreparedStatement ps = null;
			 ResultSet rs = null;

		
		try {
				connection = Database.createConnection();
			
			System.out.println("Connection Is Created");
			String sql = null;
			if (count == 3) {
				sql = "select * from doctor where DoctorId IN (select DoctorId from doctor where FirstName=\"" + fname
						+ "\" OR MiddleName=\"" + fname + "\" OR LastName=\"" + fname + "\" OR FirstName=\"" + mname
						+ "\" OR MiddleName=\"" + mname + "\" OR LastName=\"" + mname + "\" OR FirstName=\"" + lname
						+ "\" OR MiddleName=\"" + lname + "\" OR LastName=\"" + lname + "\" ) ";
			} else if (count == 2) {
				sql = "select * from doctor where DoctorId IN (select DoctorId from doctor where FirstName=\"" + fname
						+ "\" OR MiddleName=\"" + fname + "\" OR LastName=\"" + fname + "\" OR FirstName=\"" + mname
						+ "\" OR MiddleName=\"" + mname + "\" OR LastName=\"" + mname + "\" ) ";
			} else if (count == 1) {
				sql = "select * from doctor where DoctorId IN (select DoctorId from doctor where FirstName=\"" + fname
						+ "\" OR MiddleName=\"" + fname + "\" OR LastName=\"" + fname + "\" ) ";
			}

			// ps=(PreparedStatement) connection.prepareStatement(sql);
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			// st = connection.createStatement();
			// rs = st.executeQuery(sql);

			System.out.println(rs);
			while (rs.next()) {
				System.out.println(rs.getRow());
				int rank = 0;
				int doctorId = rs.getInt("DoctorId");
				int emergencyFees = rs.getInt("EmergencyFees");
				int isBelongToAnyHospital = rs.getInt("IsBelongToAnyHospital");
				String doctorRegistrationDate = rs.getString("DoctorRegistrationDate");
				String emailId = rs.getString("EmailId");
				int isProvideHomeCare = rs.getInt("IsProvideHomeCare");
				int isPharmacy = rs.getInt("IsPharmacy");
				String firstName = rs.getString("FirstName");
				String middleName = rs.getString("MiddleName");
				String lastName = rs.getString("LastName");
				int speciality = rs.getInt("Speciality");
				String degree = rs.getString("Degree");
				String clinicTiming = rs.getString("ClinicTiming");
				String offDay = rs.getString("OffDay");
				int fees = rs.getInt("Fees");
				boolean inPanel = rs.getBoolean("InPanel");
				boolean appointmnet = rs.getBoolean("IsAppointmentEnabled");
				boolean virtualReceptionist = rs.getBoolean("isVirtualReceptionistEnabled");
				boolean postcare = rs.getBoolean("IsPostCareEnabled");
				int yearofExperience = rs.getInt("YearsOfExperience");
				String addressLine1 = rs.getString("AddressLine1");
				String addressLine2 = rs.getString("AddressLine2");
				String addressLine3 = rs.getString("AddressLine3");
				int cityId = rs.getInt("CityId");
				String pincode = rs.getString("PinCode");
				System.out.println(fname);
				System.out.println(mname);
				System.out.println(lname);
				doc.add(new model.DoctorRetrival(rank, doctorId, emergencyFees, isBelongToAnyHospital,
						doctorRegistrationDate, emailId, isProvideHomeCare, isPharmacy, firstName, middleName, lastName,
						speciality, degree, clinicTiming, offDay, fees, inPanel, appointmnet, virtualReceptionist,
						postcare, yearofExperience, addressLine1, addressLine2, addressLine3, cityId, pincode));
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception **");
		}
		return doc;

	}

	
	
	// this query is supposed to be like google search. 
	public  ArrayList<model.DoctorRetrival> doctorSearch (String fname, String mname, String lname, int count) {
		ArrayList<model.DoctorRetrival> doc = new ArrayList<model.DoctorRetrival>();
		// long i=1;
		// connection = DatabaseConnectivity.getInstance().getConnection();

		 Connection connection;
			// private Statement st=null;
			 PreparedStatement ps = null;
			 ResultSet rs = null;

		
		try {
				connection = Database.createConnection();
			
			System.out.println("Connection Is Created");
			String sql = null;
			if (count == 3) {
				sql = "select * from doctor where DoctorId IN (select DoctorId from doctor where FirstName=\"" + fname
						+ "\" OR MiddleName=\"" + fname + "\" OR LastName=\"" + fname + "\" OR FirstName=\"" + mname
						+ "\" OR MiddleName=\"" + mname + "\" OR LastName=\"" + mname + "\" OR FirstName=\"" + lname
						+ "\" OR MiddleName=\"" + lname + "\" OR LastName=\"" + lname + "\" ) ";
			} else if (count == 2) {
				sql = "select * from doctor where DoctorId IN (select DoctorId from doctor where FirstName=\"" + fname
						+ "\" OR MiddleName=\"" + fname + "\" OR LastName=\"" + fname + "\" OR FirstName=\"" + mname
						+ "\" OR MiddleName=\"" + mname + "\" OR LastName=\"" + mname + "\" ) ";
			} else if (count == 1) {
				sql = "select * from doctor where DoctorId IN (select DoctorId from doctor where FirstName=\"" + fname
						+ "\" OR MiddleName=\"" + fname + "\" OR LastName=\"" + fname + "\" ) ";
			}

			// ps=(PreparedStatement) connection.prepareStatement(sql);
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			// st = connection.createStatement();
			// rs = st.executeQuery(sql);

			System.out.println(rs);
			while (rs.next()) {
				System.out.println(rs.getRow());
				int rank = 0;
				int doctorId = rs.getInt("DoctorId");
				int emergencyFees = rs.getInt("EmergencyFees");
				int isBelongToAnyHospital = rs.getInt("IsBelongToAnyHospital");
				String doctorRegistrationDate = rs.getString("DoctorRegistrationDate");
				String emailId = rs.getString("EmailId");
				int isProvideHomeCare = rs.getInt("IsProvideHomeCare");
				int isPharmacy = rs.getInt("IsPharmacy");
				String firstName = rs.getString("FirstName");
				String middleName = rs.getString("MiddleName");
				String lastName = rs.getString("LastName");
				int speciality = rs.getInt("Speciality");
				String degree = rs.getString("Degree");
				String clinicTiming = rs.getString("ClinicTiming");
				String offDay = rs.getString("OffDay");
				int fees = rs.getInt("Fees");
				boolean inPanel = rs.getBoolean("InPanel");
				boolean appointmnet = rs.getBoolean("IsAppointmentEnabled");
				boolean virtualReceptionist = rs.getBoolean("isVirtualReceptionistEnabled");
				boolean postcare = rs.getBoolean("IsPostCareEnabled");
				int yearofExperience = rs.getInt("YearsOfExperience");
				String addressLine1 = rs.getString("AddressLine1");
				String addressLine2 = rs.getString("AddressLine2");
				String addressLine3 = rs.getString("AddressLine3");
				int cityId = rs.getInt("CityId");
				String pincode = rs.getString("PinCode");
				System.out.println(fname);
				System.out.println(mname);
				System.out.println(lname);
				doc.add(new model.DoctorRetrival(rank, doctorId, emergencyFees, isBelongToAnyHospital,
						doctorRegistrationDate, emailId, isProvideHomeCare, isPharmacy, firstName, middleName, lastName,
						speciality, degree, clinicTiming, offDay, fees, inPanel, appointmnet, virtualReceptionist,
						postcare, yearofExperience, addressLine1, addressLine2, addressLine3, cityId, pincode));
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception **");
		}
		return doc;

	}

	
	
	
	// for search by specialty

	public static ArrayList<model.DoctorRetrival> responseDoctorBySpeciality(int searchSpeciality) {

		 Connection connection1;
		 PreparedStatement ps1 = null;
		 ResultSet rs1 = null;

		ArrayList<model.DoctorRetrival> doc1 = new ArrayList<model.DoctorRetrival>();
		try {
			connection1 = Database.createConnection();
			System.out.println("Connection Is Created");
			// int temp1= new int();
			// temp1 = searchSpeciality;
			String query = "select * from doctor where Speciality=\"" + searchSpeciality + "\");";
			ps1 = connection1.prepareStatement(query);
			rs1 = ps1.executeQuery();
			System.out.println(rs1);
			while (rs1.next()) {
				System.out.println("in while of rs1.next() ");
				int rank = 0;
				int doctorId = rs1.getInt("DoctorId");
				int emergencyFees = rs1.getInt("EmergencyFees");
				int isBelongToAnyHospital = rs1.getInt("IsBelongToAnyHospital");
				String doctorRegistrationDate = rs1.getString("DoctorRegistrationDate");
				String emailId = rs1.getString("EmailId");
				int isProvideHomeCare = rs1.getInt("IsProvideHomeCare");
				int isPharmacy = rs1.getInt("IsPharmacy");
				String firstName = rs1.getString("FirstName");
				String middleName = rs1.getString("MiddleName");
				String lastName = rs1.getString("LastName");
				int speciality = rs1.getInt("Speciality");
				String degree = rs1.getString("Degree");
				String clinicTiming = rs1.getString("ClinicTiming");
				String offDay = rs1.getString("OffDay");
				int fees = rs1.getInt("Fees");
				boolean inPanel = rs1.getBoolean("InPanel");
				boolean appointmnet = rs1.getBoolean("IsAppointmentEnabled");
				boolean virtualReceptionist = rs1.getBoolean("isVirtualReceptionistEnabled");
				boolean postcare = rs1.getBoolean("IsPostCareEnabled");
				int yearofExperience = rs1.getInt("YearsOfExperience");
				String addressLine1 = rs1.getString("AddressLine1");
				String addressLine2 = rs1.getString("AddressLine2");
				String addressLine3 = rs1.getString("AddressLine3");
				int cityId = rs1.getInt("CityId");
				String pincode = rs1.getString("PinCode");
				doc1.add(new model.DoctorRetrival(rank, doctorId, emergencyFees, isBelongToAnyHospital,
						doctorRegistrationDate, emailId, isProvideHomeCare, isPharmacy, firstName, middleName, lastName,
						speciality, degree, clinicTiming, offDay, fees, inPanel, appointmnet, virtualReceptionist,
						postcare, yearofExperience, addressLine1, addressLine2, addressLine3, cityId, pincode));
			}
		} catch (Exception e) {
			System.out.println("SQL Exception");
		}
		return doc1;
	}

}
