package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



import util.Logging;

public class MedicineOrder{
	
	
	
	
	
	public int placeOrder(model.OrderBase order){

		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;

		int rw= 0;
		int medicineId = -1;
		String str="insert into MedicineOrder(OrderId,PrescriptionImageId,Description) values (?,?,?)";

		try{


			connection=Database.createConnection();

			ps=(PreparedStatement) connection.prepareStatement(str,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1,order.getOrderId());
			if ( order.getImageId() > 0 )
			{
			ps.setInt(2, order.getImageId());
			}
			else
			{
				ps.setNull(2, java.sql.Types.INTEGER);
			}
			ps.setString(3,order.getOrderDescription());

			rw=ps.executeUpdate();

			if(rw>0)
			{
				rs = ps.getGeneratedKeys();
				if(rs.next())
					medicineId = rs.getInt(1);

			}
		}
		catch(SQLException se)
		{
			Logging.Exception("MedicineOrderDAL", "Error Creating Order " + ps.toString() + " Exception " + se.getMessage());
		}
		finally 
		{

			Database.closeConnection(connection);
		}

		return medicineId;
	}
	

	
	
	
	
	
//for insert order
	static Connection con=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
	static Connection con3=null;
	static PreparedStatement ps3=null;
	static ResultSet rs3=null;
  
	public static int insertMedicineOrder(model.Order order){
		int result=0;
		Database database = new Database();
		con=(Connection) database.createConnection();
		String str1="insert into MedicineOrder(OrderId,PrescriptionImageId,Comments) values (?,?,?)";
		try{
			   ps=(PreparedStatement) con.prepareStatement(str1,Statement.RETURN_GENERATED_KEYS);
			   ps.setInt(1, order.getOrderId());
			   ps.setInt(2, 1);//order.getPrescriptionImageId());
			   ps.setString(3, order.getOrderDescription());
			   int rw=ps.executeUpdate();
			  
			   if(rw>0)
			   {
				   rs=ps.getGeneratedKeys();
				   if(rs.next())
				   {
					   result=rs.getInt(1);
				   }
			   }
			   else{
				   result=-1;
			   }
		}
		catch(SQLException se)
		   {
			   result=500;
		   }
		return result; 
	}
	
public static ArrayList<model.MedicineOrder> responseMedicineOrder(int orderid)
{
	ArrayList<model.MedicineOrder> medicineorder=new ArrayList<model.MedicineOrder>();
	Database database = new Database();
	con=(Connection) database.createConnection();
	String str2="select * from MedicineOrder where OrderId=?";
	try{
		ps3=(PreparedStatement) con.prepareStatement(str2); 
		ps3.setInt(1,orderid);
		rs3=ps3.executeQuery();
		while(rs3.next()){
        int medicineorderid=rs3.getInt("MedicineOrderId");
        int order=rs3.getInt("OrderId");
        int prescriptionimageid=rs3.getInt("PrescriptionImageId");
         String comments=rs3.getString("Comments");
        medicineorder.add(new model.MedicineOrder(medicineorderid,order,prescriptionimageid,comments));
        
		}
		
	}
	catch(SQLException se)
	   {
		   
	   }
	return medicineorder; 
}
//to delete medicine order 
	public static int deleteMedicineOrder(int orderid) {
		int  rw=0;
 	int result=0;
 	Database database = new Database();
		con3=(Connection) database.createConnection();
		String str3="delete from MedicineOrder where OrderId =?";
		try{
			 ps3=(PreparedStatement) con3.prepareStatement(str3);
			   ps3.setInt(1,orderid);
			  
			   
			   rw=ps3.executeUpdate();
			  
			   if(rw>0)
			   {
				  result = 1;
	            }else{
				   result=-1;
			          }
	       }catch(SQLException se)
		   {
			//System.out.print(se.getMessage());
			result = 5;
		   }
		return result;
		}
	}
	
