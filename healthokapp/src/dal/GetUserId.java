package dal;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GetUserId {
	static Connection con=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
	public static int userid(String username){
		int userid=0;
		Database database = new Database();
		con =(Connection) database.createConnection();
		String str="select * from user where emailid=?";
		try{
			ps=(PreparedStatement) con.prepareStatement(str); 
			ps.setString(1,username);
			rs=ps.executeQuery();
			if(rs.next()){
	        userid=rs.getInt("UserId");
			}
			
		}
		catch(SQLException se)
		   {
			   
		   }
		return userid; 
		
		
	}

}
