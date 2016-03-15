package dal;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import rest_api.DatabaseConnectivity;

public class DoctorRetrival {

	static Connection connection;
	// private Statement st=null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	static Connection connection1;
	static PreparedStatement ps1 = null;
	static ResultSet rs1 = null;

	public static ArrayList<model.DoctorRetrival> responseDoctor(String fname, String mname, String lname, int count) {
		ArrayList<model.DoctorRetrival> doc = new ArrayList<model.DoctorRetrival>();
		// long i=1;
		// connection = DatabaseConnectivity.getInstance().getConnection();

		try {
			try {
				connection = DatabaseConnectivity.getInstance().getConnection();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
		ArrayList<model.DoctorRetrival> doc1 = new ArrayList<model.DoctorRetrival>();
		try {
			connection1 = DatabaseConnectivity.getInstance().getConnection();
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
