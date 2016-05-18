package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.Doctor;
import util.Logging;

public class DoctorAppointment {

	public int placeOrder(model.OrderBase order) {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		int rw = 0;
		int doctorAppoinntmentId = -1;
		String str = "insert into DoctorAppointment(OrderId,DoctorId,AppointmentDate,Description) values (?,?,?,?)";

		try {

			connection = Database.createConnection();

			ps = (PreparedStatement) connection.prepareStatement(str, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, order.getOrderId());
			ps.setInt(2, order.getDoctorId());
			ps.setDate(3, new java.sql.Date(order.getOrderFulfillDate().getTime()));
			ps.setString(3, order.getOrderDescription());

			rw = ps.executeUpdate();

			if (rw > 0) {
				rs = ps.getGeneratedKeys();
				if (rs.next())
					doctorAppoinntmentId = rs.getInt(1);

			}

			// int rw1 = 0;

		}

		catch (SQLException se) {
			Logging.Exception("AmbulanceOrderDAL",
					"Error Creating Order " + ps.toString() + " Exception " + se.getMessage());
		} finally {

			Database.closeConnection(connection);
		}

		return doctorAppoinntmentId;

		/*
		 * public model.Doctor accessDoctorName(model.Doctor doctor) {
		 * 
		 * Connection connection = null; PreparedStatement ps1 = null; ResultSet
		 * rs1 = null; model.Doctor doc=null; try { connection =
		 * Database.createConnection(); String q =
		 * "select FirstName,MiddleName,LastName from Doctor where DoctorId=?";
		 * ps1 = connection.prepareStatement(q); ps1.setInt(1,
		 * doctor.getDoctorId()); rs1 = ps1.executeQuery(); while(rs1.next()) {
		 * doc=new model.Doctor(); doc.setDoctorId(doctor.getDoctorId());
		 * doc.setFirstName(rs1.getString("FirstName"));
		 * doc.setFirstName(rs1.getString("MiddleName"));
		 * doc.setFirstName(rs1.getString("LastName"));
		 * 
		 * } }
		 * 
		 * catch (SQLException se) { Logging.Exception("DoctorDAL",
		 * "Error Creating Order " + ps1.toString() + " Exception " +
		 * se.getMessage()); }
		 */

		// return doc;

	}

}
