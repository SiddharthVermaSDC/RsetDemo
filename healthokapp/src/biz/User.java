package biz;

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
	
}
