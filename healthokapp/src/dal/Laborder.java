package dal;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import servlet.Crudoperation;

public class Laborder {
	
	static Connection con=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
	
    public static int placeLabOrder(model.Laborder laborder){
    	int rw= 0;
    	int result=0;
    	Crudoperation crudoperation = new Crudoperation();
		con=(Connection) crudoperation.createConnection();
		String str1="insert into laborder(OrderId,PrescriptionImageId,Description) values (?,?,?)";
		try{
			 ps=(PreparedStatement) con.prepareStatement(str1,result);
			   ps.setInt(1,laborder.getOrderId());
			   ps.setInt(2, laborder.getPrescriptionimageId());
			   ps.setString(3,laborder.getDisription());
			   
			   rw=ps.executeUpdate();
			  
			   if(rw>0)
			   {
				   rs = ps.getGeneratedKeys();
	                if(rs.next())
	                    result = rs.getInt(1);
	 
			   }
			   else{
				   result=-1;
			   }
		}
		catch(SQLException se)
		   {
			   
		   }
		return result;
    }
}
