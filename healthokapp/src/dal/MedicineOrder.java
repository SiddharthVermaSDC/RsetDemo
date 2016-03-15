package dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import servlet.Crudoperation;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class MedicineOrder{
//for insert order
	static Connection con=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
	static Connection con3=null;
	static PreparedStatement ps3=null;
	static ResultSet rs3=null;
  
	public static int insertMedicineOrder(model.Order order){
		int result=0;
		Crudoperation crudoperation = new Crudoperation();
		con=(Connection) crudoperation.createConnection();
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
	Crudoperation crudoperation = new Crudoperation();
	con=(Connection) crudoperation.createConnection();
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
 	Crudoperation crudoperation = new Crudoperation();
		con3=(Connection) crudoperation.createConnection();
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
	
