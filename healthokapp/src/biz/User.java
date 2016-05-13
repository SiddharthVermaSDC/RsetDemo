package biz;


import model.GetSetLogin;
import model.GetSetMemberRegistration;
import rest_api.ReturnUserDetails;
import util.StatusCode;

public class User {

	
	
	public static int Save (model.User user)
	{
	 
		return dal.User.Save(user);
		
	}

	
	
	
	public StatusCode RegisterDevice (int userId, String token)
	{
		dal.User userDal = new dal.User();
		
		return userDal.RegisterDevice(userId, token);	
	}
	
	
	
		
	
	public model.User GetUser ( int userId)
	{
		
		dal.User userDal = new dal.User();		
		
		return userDal.getUser(userId);	
		
	}
	
	
	public model.UserFull loginCheck(GetSetLogin gs)
	{
				  
		  dal.User userDal = new dal.User();
		  
		  int userId = -1;
		  
		  userId = userDal.loginCheck(gs);
		  
		  if ( userId > 0 )
		  {
			  
				return new dal.User().getUserDetails(userId);

		  }
		  else
		  {
			  return null;
		  }
		  
	}
	
	
	
	
	public model.UserFull getUserDetails (int userId)

	{
		
		return new dal.User().getUserDetails(userId);
	}
	
	
	
	
	
	public  int quickEmailRegister(model.GetSetLogin gs)
	{
		return new  dal.User().quickEmailRegister(gs);
	}
	
	
	
	
	
	
	public  StatusCode fullRegister(model.UserFull us)
	{
		
		return new  dal.User().fullRegister(us);
	}
	
}
