package dal;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import servlet.Crudoperation;

public class Laborderdetail {
	static Connection con=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;

	
    public static int placeLabOrderd(model.Laborderdetails laborderd){
    	int  rw=0;
    	int result=0;
    	Crudoperation crudoperation = new Crudoperation();
		con=(Connection) crudoperation.createConnection();
		String str1="insert into LabOrderDetails(LabOrderId,TestName,Price) values (?,?,?)";
		try{
			 ps=(PreparedStatement) con.prepareStatement(str1,Statement.RETURN_GENERATED_KEYS);
			   ps.setInt(1,laborderd.getLaborderId());
			   ps.setString(2,laborderd.getTestname());
			   ps.setFloat(3,laborderd.getPrice());
			   
			   
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
			System.out.print(se.getMessage());
			result = 10;
		   }
		return result;
    }


}
