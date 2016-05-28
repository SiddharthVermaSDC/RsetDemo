package biz;

public class UpdateUser {

	public static  int update(model.UserFull user,int userid)  {
		  return new dal.UpdateUser().update(user,userid);
	}


}
