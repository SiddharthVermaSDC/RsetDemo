package dal;

import java.sql.ResultSet;
import java.sql.SQLException;
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
public static int insertMedicineOrder(model.MedicineOrder medicineorder, int orderId){
		int result=0;
		Crudoperation crudoperation = new Crudoperation();
		con=(Connection) crudoperation.createConnection();
		String str1="insert into MedicineOrder(MedicineOrderId,OrderId,PrescriptionImageId,Comments) values (?,?,?,?)";
		try{
			 ps=(PreparedStatement) con.prepareStatement(str1);
			   ps.setInt(1, medicineorder.getMedicineOrderId());
			   ps.setInt(2, medicineorder.getOrderId());
			   ps.setInt(3, medicineorder.getPrescriptionImageId());
			   ps.setString(4, medicineorder.getComments());
			   int rw=ps.executeUpdate();
			  
			   if(rw>0)
			   {
				   result = 2;
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
public static ArrayList<model.MedicineOrder> responseMedicineOrder(int orderid)
{
	ArrayList<model.MedicineOrder> medicineorder=new ArrayList<model.MedicineOrder>();
	Crudoperation crudoperation = new Crudoperation();
	con=(Connection) crudoperation.createConnection();
	String str3="select * from MedicineOrder where OrderId=?";
	try{
		ps3=(PreparedStatement) con.prepareStatement(str3); 
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

	 }
	
