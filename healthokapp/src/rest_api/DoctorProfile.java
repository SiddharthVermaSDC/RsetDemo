package rest_api;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dal.Database;
import dal.DatabaseConnectivity;

@Path("/Add")
public class DoctorProfile {
	private Connection connection = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Path("/Doctor")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String GetData(GetSetDoctorProfile ds) {
		try {
			connection = Database.createConnection();;
			FileInputStream fin = new FileInputStream(ds.getImage());
			String sql = "INSERT INTO Images (ImageTypeId,Image) values (?,?)";
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, ds.getImageTypeId());
			ps.setBinaryStream(2, fin, fin.available());
			System.out.println("Image Inserted");
			int row = ps.executeUpdate();
			if (row == 1)
				rs = ps.getGeneratedKeys();
			if (rs.next())
				ds.id = rs.getInt(1);
			System.out.println(ds.id);
			String q = "insert into doctor (FirstName,MiddleName,LastName,Speciality,Degree,ClinicTiming,offDay,Fees,InPanel,IsAppointmentEnabled,isVirtualReceptionistEnabled,IsPostCareEnabled,DoctorImageId,YearsofExperience,AddressLine1,AddressLine2,AddressLine3,CityId,PinCode) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = connection.prepareStatement(q);
			ps.setString(1, ds.getFristName());
			ps.setString(2, ds.getMiddleName());
			ps.setString(3, ds.getLastName());
			ps.setInt(4, ds.getSpeciality());
			ps.setString(5, ds.getDegree());
			ps.setString(6, ds.getClinicTiming());
			ps.setString(7, ds.getOffDay());
			ps.setInt(8, ds.getFees());
			ps.setBoolean(9, ds.isInPanel());
			ps.setBoolean(10, ds.isAppointmnet());
			ps.setBoolean(11, ds.isVirtualReceptionist());
			ps.setBoolean(12, ds.isPostcare());
			ps.setInt(13, ds.id);
			ps.setInt(14, ds.getYearofExperience());
			ps.setString(15, ds.getAddressLine1());
			ps.setString(16, ds.getAddressLine2());
			ps.setString(17, ds.getAddressLine3());
			ps.setInt(18, ds.getCityId());
			ps.setString(19, ds.getPinCode());

			ps.executeUpdate();
			Database.closeConnection(connection);
			return "Doctor SuccessFully Registered";

		} catch (Exception e) {
			System.out.println(e);
			return "Not Successfull Registered";
		}

	}
}
