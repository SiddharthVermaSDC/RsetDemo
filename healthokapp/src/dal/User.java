package dal;


import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

import model.GetSetLogin;
import model.MedicalCondition;
import model.MemberDetail;
import model.MembershipType;
import util.Logging;
import util.StatusCode;



public class User {
	
	
	public  StatusCode fullRegister(model.UserFull us)
	{     
		
		PreparedStatement preparedstatement=null;
		PreparedStatement preparedstatementCheck=null;
		Connection connection = null;
	    Statement statement = null;
	    ResultSet resultset = null;
	    String  queryToInsert;
	    
	    int userid;
	    
	    StatusCode status = StatusCode.UnknownError;
	    try {
	    	
	    	connection = Database.createConnection();
	    	
	    	
	    	String whereToInsert="select UserId from user where Mobile=? and Password=?";
      	  	
      	  	
      	  	
      	  	 preparedstatementCheck =(PreparedStatement)connection.prepareStatement(whereToInsert);
      	  	Logging.Debug("got first execution","line no 46");
      	  	 preparedstatementCheck.setString(1,us.getMobile());
      	  	Logging.Debug("got first execution","line no 48");
      	  	 preparedstatementCheck.setString(2,us.getPassword());
      	  	 
      	  	 resultset=preparedstatementCheck.executeQuery(); 
      	  	 
      	  	 if(resultset.next())
      	  		 
      	  	 {
      	  		Logging.Debug("got first execution","line no 54");
      	  		 
      	  		queryToInsert=new String("insert into user(MemberID,FirstName,LastName,Mobile,EmailId,AddressLine1,AddressLine2,CityId,PinCode,DoctorsGenerallyVisited,MembershipTypeId,"
          	  			+ "Password,PrimaryDoctor,PrepaidBalance,CashbackBonusBalance,TotalDiscount,Comments)"
          	  			
          	  			+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) where UserId="+resultset.getInt("USerId"));
      	  		
      	  		preparedstatement =(PreparedStatement)connection.prepareStatement(queryToInsert);
      	  		 
      	  	 }
      	  	 
      	  	 else
      	  	 {
      	  		 
      	  		Logging.Debug("got 2 execution","line no 68");
      	  		 
      	  		queryToInsert=new String("insert into user(MemberID,FirstName,LastName,Mobile,EmailId,AddressLine1,AddressLine2,CityId,PinCode,DoctorsGenerallyVisited,MembershipTypeId,"
          	  			+ "Password,PrimaryDoctor,PrepaidBalance,CashbackBonusBalance,TotalDiscount,Comments)"
          	  			
          	  			+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
      	  		
      	  		
      	  		preparedstatement =(PreparedStatement)connection.prepareStatement(queryToInsert, Statement.RETURN_GENERATED_KEYS);	
      	  		 
      	  	 }
      	  			
						 
			 preparedstatement.setString(1,us.getMemberID());
			 preparedstatement.setString(2,us.getFirstName());
			 preparedstatement.setString(3,us.getLastName());
			 preparedstatement.setString(4,us.getMobile());
			 preparedstatement.setString(5,us.getEmailId());
			 preparedstatement.setString(6,us.getAddressLine1());
			 preparedstatement.setString(7,us.getAddressLine2());
			 preparedstatement.setInt(8,us.getCityId());
			 preparedstatement.setString(9,us.getPinCode());
			 preparedstatement.setString(10,us.getDoctorGenerallyVisited());
			 preparedstatement.setInt(11,us.getMembershipTypeId().getmembershipType());
			 preparedstatement.setString(12,us.getPassword());
			 preparedstatement.setInt(13,us.getPrimaryDoctor());
			 preparedstatement.setInt(14,us.getPrepaidBalance());
			 preparedstatement.setInt(15,us.getCashbackBonusBalance());
			 preparedstatement.setInt(16,us.getTotalDiscount());
			 preparedstatement.setString(17,us.getComments());
			 
			 
			 preparedstatement.executeUpdate();  
			 Logging.Debug("got 3 execution","line no 101");
			 if(resultset.next())
			 {
				 Logging.Debug("got 4 execution","line no 104");
				 userid = resultset.getInt("UserId");
				 
			 }
			 
			 else
			 {
				 
				 ResultSet keys = preparedstatement.getGeneratedKeys();    
				 keys.next();  
				 userid = keys.getInt(1);
				 
			 }
			 
			 
			// status=familyRegister(us,userid);
			 status= StatusCode.Success;
			 return status;
	    }
	  
	     catch(Exception e)
	     {   
	    	 Logging.Debug("UserFullregistration",e.getMessage());
	    	 status = StatusCode.UnknownError;
	     }
		
		finally 
		{ 
			Database.closeConnection(connection);
			
		}  
	    
	    return status;
	    
	}	
	
	
  
	public StatusCode familyRegister(model.UserFull us,int userid)
	{
		
		 PreparedStatement preparedstatement=null;
		 Connection connection = null;
		 StatusCode status = StatusCode.UnknownError;
	     
		try {
			
			connection = Database.createConnection();
			
			String queryToInsert;

			 queryToInsert=new String("insert into memberdetails(FirstName,LastName,Sex,DOB,BloodGroup,Allergies,CurrentMedications,Diabetic,BP,HeartProblems,RecurringTests,LongTermCareNeeds,Comments,UserId)"
				 		+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?);");

			  for (model.MemberDetail memberdetail : us.getMemberDetail())
			  { 
						 
				preparedstatement =(PreparedStatement)connection.prepareStatement(queryToInsert);	
				
				preparedstatement.setString(1,memberdetail.getFirstName());
				preparedstatement.setString(2,memberdetail.getLastName());
				preparedstatement.setString(3,memberdetail.getSex());
				preparedstatement.setDate(4,new java.sql.Date(memberdetail.getDateOfBirth().getTime()));
				preparedstatement.setString(5,memberdetail.getBloodGroup());
				preparedstatement.setString(6,memberdetail.getAllergies());
				preparedstatement.setString(7,memberdetail.getCurrentMedications());
				preparedstatement.setInt(8,memberdetail.getDiabetic().getMedicalCondition());
				preparedstatement.setInt(9,memberdetail.getBP().getMedicalCondition());
				preparedstatement.setInt(10,memberdetail.getHeartProblems().getMedicalCondition());
				preparedstatement.setString(11,memberdetail.getRecurringTests());
				preparedstatement.setString(12,memberdetail.getLongTermCareNeeds());
				preparedstatement.setString(13,memberdetail.getComments());
				preparedstatement.setInt(14,userid);
				
				preparedstatement.executeUpdate();
				
			  }  
			
			status= StatusCode.Success;
			  
		   	} 
		catch (Exception e)
		{   
			Logging.Debug("MemberFullregistration",e.getMessage());
			status= StatusCode.UnknownError;
		}
		
		 finally 
	     { 
			 Database.closeConnection(connection);  
	      }
		
		return status;
	}
	
	
	
	public int quickEmailRegister(model.GetSetLogin gs)
	{
		
		PreparedStatement preparedstatement=null;
		Connection connection=null;
		ResultSet resultSet=null;
		int status;
		
		try{
			
			connection = Database.createConnection();

			String queryToCheck="select EmailId, Mobile from User where Mobile=? or EmailId = ?";
			String queryToInsert="insert into User(FirstName,LastName,EmailId,Mobile,Password) values(?,?,?,?,?);";
		  	
		    preparedstatement=(PreparedStatement) connection.prepareStatement(queryToCheck);
	    	preparedstatement.setString(1,gs.getPhone());
	    	preparedstatement.setString(2,gs.getEmail());
	    	resultSet=preparedstatement.executeQuery();
	    	
	    	if(resultSet.next()==true)
	    	{
	    		Logging.Debug("QuickRegister", "Email or mobile already exists" + gs.getEmail() + ":"+ gs.getPhone());
	    		status=-1;
	    	}
	    	
	    	else
	    	{
	    		preparedstatement=null;
	    		preparedstatement=(PreparedStatement) connection.prepareStatement(queryToInsert);
	    		preparedstatement.setString(1,gs.getFirstName());	    		
	    		preparedstatement.setString(2,gs.getLastName());	    		
	    		preparedstatement.setString(3,gs.getEmail());	    			
	    		preparedstatement.setString(4,gs.getPhone());	    			
	    		preparedstatement.setString(5,gs.getPassword());
	    		preparedstatement.executeUpdate();
	    		
	    		status=1;
	    	}
	    	
		}
		
		catch(Exception e)
	     {
			Logging.Debug("Registration", e.getMessage());
			status=-500;
	     }
		
		 finally 
	     { 
			 Database.closeConnection(connection); 
	     }
	
		return status;
		
	}
	
	
	
	

	public static int Save (model.User user)
	{

		 Connection connection=null;
		 PreparedStatement ps=null;
	   ResultSet rs=null;

		int result=-1;
		
		connection=Database.createConnection();
	   String str="insert into User(emailid,firstName,phone,password,lastName) values (?,?,?,?,?)";
	   try
	   {
		   ps=connection.prepareStatement(str);
		   ps.setString(1,user.getEmailId());
		   ps.setString(2,user.getFirstName());
		   ps.setString(3,user.getPhone());
		   ps.setString(4,user.getPassword());
		   ps.setString(5,user.getLastName());
		   int rw=ps.executeUpdate();
		   if(rw>0)
		   {
			  result=1; 
		   }
		   
	   }
	   catch(SQLException se)
	   {
		   
	   }
		finally
		{
			Database.closeConnection(connection);
		}
	return result;
	}
	
	
	
	

	public static int ValidateCredentials(String username,String password){

		 Connection connection=null;
		 PreparedStatement ps=null;
	   ResultSet rs=null;

		int result=0;
		String str="select * from user where emailid=? and password=?";
		try
		{
			connection=Database.createConnection();
			ps= connection.prepareStatement(str); 
			ps.setString(1,username);
			ps.setString(2,password);
			rs=ps.executeQuery();
			if(rs.next())
			{
				result=1;
			}
			else
			{
				result=-1;
			}
		}
		catch(SQLException se)
		{
			
		}
		finally
		{
			Database.closeConnection(connection);
		}
		return result;
		
	}
	
	public StatusCode RegisterDevice (int userId, String token)
	{
		

		 Connection connection=null;
		 PreparedStatement ps=null;
	   ResultSet rs=null;

		StatusCode result= StatusCode.UnknownError;
		
		String str="update User set GCMToken =? where userid = ?";
		try
		{
			connection=Database.createConnection();
			ps=connection.prepareStatement(str); 
			ps.setString(1,token);
			ps.setInt(2,userId);
			
			Logging.Debug("UserDal", ps.toString());
			
			int updateStatus=ps.executeUpdate();
			if(updateStatus > 0)
			{
				result= StatusCode.Success;
			}
			else
			{
				result=StatusCode.Error;
				Logging.Error("UserDal-RegisterDevice", "No rows updated for userid" + userId);
			}
			
			Logging.Debug("USERDAL", "Successfully registered device for userid " + Integer.toString(userId));
		}
		catch(SQLException se)
		{
			Logging.Exception("UserDal-RegisterDevice", se.getMessage());
			result = StatusCode.UnknownError;
		}
		finally
		{
			Database.closeConnection(connection);
		}
		return result;
		
		
	}


	public String GetToken (int userId)
	{
		
		 Connection connection=null;
		 PreparedStatement ps=null;
	   ResultSet rs=null;
		
		
		String str="select GCMToken from User where userid = ?";
		String token = null;

		try
		{
			connection=Database.createConnection();
			ps=connection.prepareStatement(str); 
			ps.setInt(1,userId);
			
			Logging.Debug("UserDal", ps.toString());
			 rs = ps.executeQuery(); 
			while (rs.next()) {
				token = rs.getString("GCMToken");
			}
			
			Logging.Debug("User-Dal", "token retreived is " + token);
		}
		catch(SQLException se)
		{
			Logging.Exception("UserDal-GetToken", se.getMessage());
		}
		finally
		{
			Database.closeConnection(connection);
		}
		return token;
		
		
	}

	
	public model.User getUser (int userId)
	{
		
		 Connection connection=null;
		 PreparedStatement ps=null;
	   ResultSet rs=null;
		
		
		String str="select * from User where userid = ?";
		String token = null;

		model.User user = null;
		
		try
		{
			connection=Database.createConnection();
			ps=connection.prepareStatement(str); 
			ps.setInt(1,userId);
			
			Logging.Debug("UserDal", ps.toString());
			
			 rs = ps.executeQuery(); 
			
			while (rs.next()) {
				
				user = new model.User(); // since this is query by PK will get only one row. 
				
				user.setUserId(userId);
				user.setFirstName(rs.getString("FirstName"));
				user.setLastName(rs.getString("LastName"));
				user.setEmailId(rs.getString("EmailId"));
				user.setPhone(rs.getString("Mobile"));
				user.setPassword(rs.getString("Password"));
						
			}
			
			Logging.Debug("User-Dal", "user is " + user.getFirstName() + " " + user.getLastName());
		}
		catch(SQLException se)
		{
			Logging.Exception("UserDal-GetToken", se.getMessage());
			return null;
		}
		finally
		{
			Database.closeConnection(connection);
		}
		
		return user;
		
		
	}
	

public int  loginCheck (GetSetLogin gs)
{
	Connection connection = null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
	
	int userId = -1;
	
	try {
		
		connection = Database.createConnection();
		String query="select UserId from User where (EmailId=\""+gs.getLoginId()+"\" or Mobile=\""+gs.getLoginId()+"\") and Password=\""+gs.getPassword()+"\";";
		
		Logging.Debug("Login", query);
		
		preparedStatement =(PreparedStatement)connection.prepareStatement(query);
		resultSet=preparedStatement.executeQuery();
		
		if(resultSet.next()==true)
		{
			
			Logging.Debug("Login","Found matching record " + resultSet.getInt("UserId")  );
			userId = resultSet.getInt("UserId");
			
		}
		
		else
		{
			
			Logging.Debug("Login","Found no matching record for " + query);
			userId = -1;
		 
		}
	}
	
	catch(Exception e)
	{
		
		util.Logging.Debug("Login", e.getMessage());
		
	}
	
	finally 
	{
		
		Database.closeConnection(connection);
		
	}
	
	return userId;  
	
}






public model.UserFull getUserDetails ( int userId)
{

	 Connection connection=null;
	 PreparedStatement psUser=null;
	 PreparedStatement psMemberDetail=null;
	 ResultSet rs=null;
    
	 
	 String queryUser="select * from User where userid = ?";
	 String queryMemberDetail ="select * from MemberDetails where userid = ?";
	
	 model.UserFull user = null;
	 
	 try
	 {
		 
		 connection=Database.createConnection();
		 psUser=connection.prepareStatement(queryUser); 
		 psUser.setInt(1,userId);
		 psMemberDetail=connection.prepareStatement(queryMemberDetail); 
		 psMemberDetail.setInt(1,userId);
		 
		 Logging.Debug("UserDal", psUser.toString());
		 
		 rs = psUser.executeQuery(); 
		 
		 
		 while (rs.next()) {
			 
			 			
			user = new model.UserFull(); // since this is query by PK will get only one row. 
			
			user.setUserId(userId);
			user.setMemberID(rs.getString("MemberId"));
			user.setFirstName(rs.getString("FirstName"));
			user.setLastName(rs.getString("LastName"));
			user.setEmailId(rs.getString("EmailId"));
			user.setAddressLine1(rs.getString("Addressline1"));
			user.setAddressLine2(rs.getString("Addressline2"));
			user.setAddressLine3(rs.getString("Addressline3"));
			user.setCashbackBonusBalance(rs.getInt("CashbackBonusBalance"));
			user.setCityId(rs.getInt("CityId"));
			user.setComments(rs.getString("Comments"));
			user.setDoctorGenerallyVisited(rs.getString("DoctorsGenerallyVisited"));
			user.setMobile(rs.getString("Mobile"));
			user.setPinCode(rs.getString("PinCode"));
			user.setPrepaidBalance(rs.getInt("PrepaidBalance"));
			user.setPrimaryDoctor(rs.getInt("PrimaryDoctor"));
			user.setTotalDiscount(rs.getInt("TotalDiscount"));
			user.setMembershipTypeId(model.MembershipType.item(rs.getInt("MembershipTypeId")));
						
		}
		 
		 
		 Logging.Debug("User-Dal", "user is " + user.getFirstName() + " " + user.getLastName());
		 
		 rs = psMemberDetail.executeQuery(); 
		
		 ArrayList<model.MemberDetail> memberDetails = new ArrayList<model.MemberDetail>();
		 
		 model.MemberDetail memberDetail = null;
		 
		 while (rs.next()) {
			 
			memberDetail = new MemberDetail ();
			
			memberDetail.setMemberDetailId(rs.getInt("MemberDetailId"));
			memberDetail.setUserid(rs.getInt("Userid"));
			memberDetail.setFirstName(rs.getString("FirstName"));
			memberDetail.setAllergies(rs.getString("Allergies"));
			memberDetail.setBloodGroup(rs.getString("BloodGroup"));
			memberDetail.setBP(MedicalCondition.item(rs.getInt("BP")));
			memberDetail.setComments(rs.getString("Comments"));
			memberDetail.setCurrentMedications(rs.getString("CurrentMedications"));
			memberDetail.setDateOfBirth(rs.getDate("DOB"));
			memberDetail.setDiabetic(MedicalCondition.item(rs.getInt("Diabetic")));
			memberDetail.setHeartProblems(MedicalCondition.item(rs.getInt("HeartProblems")));
			memberDetail.setLastName(rs.getString("LastName"));
			memberDetail.setLongTermCareNeeds(rs.getString("LongTermCareNeeds"));
			memberDetail.setRecurringTests(rs.getString("RecurringTests"));
			memberDetail.setSex(rs.getString("Sex"));
			
			memberDetails.add(memberDetail);
						
		}
		
		user.setMemberDetail(memberDetails); // Assign member details array to user object
		
		return user;
		
	}
	catch(SQLException se)
	{
		Logging.Exception("UserDal-GetToken", se.getMessage());
		user = null;

	}
	finally
	{
		Database.closeConnection(connection);
	}
	
	return user;
}

}
