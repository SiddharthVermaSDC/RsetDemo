package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.GetSetLogin;
import model.MedicalCondition;
import model.MemberDetail;
import model.UserFull;
import util.Logging;
import util.StatusCode;

public class UpdateUser {

	public int update(model.UserFull user, int userid) {

		PreparedStatement preparedstatement = null;
		PreparedStatement ps = null;
		Connection connection = null;
		String queryToUpdate;
		String memberdetails;
		String phonenumber;
		int status = 0;
		try {

			connection = Database.createConnection();
			queryToUpdate = new String(
					"update user set MemberID=?,FirstName=?,LastName=?,Mobile=?,EmailId=?,AddressLine1=?,AddressLine2=?,CityId=?,PinCode=?,DoctorsGenerallyVisited=?,MembershipTypeId=?,"
							+ " Password=?,PrimaryDoctor=?,PrepaidBalance=?,CashbackBonusBalance=?,TotalDiscount=?,Comments=?"
							+ " where UserId=" + userid);
			preparedstatement = (PreparedStatement) connection.prepareStatement(queryToUpdate);

			preparedstatement.setString(1, user.getMemberId());
			preparedstatement.setString(2, user.getFirstName());
			preparedstatement.setString(3, user.getLastName());
			preparedstatement.setString(4, user.getMobile());
			preparedstatement.setString(5, user.getEmailId());
			preparedstatement.setString(6, user.getAddressLine1());
			preparedstatement.setString(7, user.getAddressLine2());
			preparedstatement.setInt(8, user.getCityId());
			preparedstatement.setString(9, user.getPinCode());
			preparedstatement.setString(10, user.getDoctorGenerallyVisited());
			preparedstatement.setInt(11, user.getMembershipTypeId().getmembershipType());
			preparedstatement.setString(12, user.getPassword());
			preparedstatement.setInt(13, user.getPrimaryDoctor());
			preparedstatement.setInt(14, user.getPrepaidBalance());
			preparedstatement.setInt(15, user.getCashbackBonusBalance());
			preparedstatement.setInt(16, user.getTotalDiscount());
			preparedstatement.setString(17, user.getComments());

			preparedstatement.executeUpdate();

			if (user.getUserPhoneNumber() != null) {
				phonenumber = "update Useradditionalphonenumber set AdditionalPhoneNumber1=?,AdditionalPhoneNumber2=?,AdditionalPhoneNumber3=? where UserId=\""
						+ userid + "\"";
				for (model.UserPhoneNumber userphonenumber : user.getUserPhoneNumber()) {
					ps = connection.prepareStatement(phonenumber);
					ps.setString(1, userphonenumber.getAdditionalPhoneNumber1());
					ps.setString(2, userphonenumber.getAdditionalPhoneNumber2());
					ps.setString(3, userphonenumber.getAdditionalPhoneNumber3());
					ps.executeUpdate();

				}
			}

			memberdetails = "update memberdetails set FirstName=?,LastName=?,Sex=?,DOB=?,BloodGroup=?,"
					+ "Allergies=?,CurrentMedications=?,Diabetic=?,BP=?,HeartProblems=?,RecurringTests=?,"
					+ "LongTermCareNeeds=?,Comments=? where UserId=\"" + userid + "\"";

			for (model.MemberDetail memberdetail : user.getMemberDetail()) {

				preparedstatement = (PreparedStatement) connection.prepareStatement(memberdetails);

				preparedstatement.setString(1, memberdetail.getFirstName());
				preparedstatement.setString(2, memberdetail.getLastName());
				preparedstatement.setString(3, memberdetail.getSex());
				preparedstatement.setDate(4, new java.sql.Date(memberdetail.getDateOfBirth().getTime()));
				preparedstatement.setString(5, memberdetail.getBloodGroup());
				preparedstatement.setString(6, memberdetail.getAllergies());
				preparedstatement.setString(7, memberdetail.getCurrentMedications());
				preparedstatement.setInt(8, memberdetail.getDiabetic().getMedicalCondition());
				preparedstatement.setInt(9, memberdetail.getBP().getMedicalCondition());
				preparedstatement.setInt(10, memberdetail.getHeartProblems().getMedicalCondition());
				preparedstatement.setString(11, memberdetail.getRecurringTests());
				preparedstatement.setString(12, memberdetail.getLongTermCareNeeds());
				preparedstatement.setString(13, memberdetail.getComments());
			//	preparedstatement.setInt(14, userid);
				preparedstatement.executeUpdate();
				return status = 1;
			}
		}

		catch (Exception e) {
			Logging.Debug("UserFullregistration", e.getMessage());
			return status = 500;
		}

		finally {

			Database.closeConnection(connection);

		}

		return status;

	}

}
