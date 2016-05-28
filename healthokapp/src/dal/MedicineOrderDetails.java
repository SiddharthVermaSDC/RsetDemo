package dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class MedicineOrderDetails{
//for insert order
	static Connection con=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
	static Connection con3;
	static PreparedStatement ps3=null;
	static ResultSet rs3=null;
public static int insertMedicineOrderDetails(model.MedicineOrderDetails medicineorderdetails){
		int result = 0;
		Database database = new Database();
		con=(Connection) database.createConnection();
		String str1="insert into MedicineOrderDetails(MedicineOrderId,MedicineName,Dosage,Quantity,Price) values (?,?,?,?,?)";
		try{
			 ps=(PreparedStatement) con.prepareStatement(str1);
		//	   ps.setInt(1, medicineorderdetails.getMedicineOrderDetailsId());
			   ps.setInt(1, medicineorderdetails.getMedicineOrderId());
			   ps.setString(2, medicineorderdetails.getMedicineName());
			   ps.setString(3, medicineorderdetails.getDosage());
			   ps.setInt(4, medicineorderdetails.getQuantity());
			   ps.setFloat(5, medicineorderdetails.getPrice());
			   int rw=ps.executeUpdate();
			  
			   if(rw>0)
			   {
				   result = 1;
			   }
			   else{
				   result=-1;
			   }
		}
		catch(SQLException se)
		   {
			   System.out.println(se);
		   }
		return result; 
	}
public static ArrayList<model.MedicineOrderDetails> responseMedicineOrderDetails(int medicineorderdetailsid)
{
	ArrayList<model.MedicineOrderDetails> medicineorderdetails=new ArrayList<model.MedicineOrderDetails>();
	long i=1;
	Database database = new Database();
	con=(Connection) database.createConnection();
	String str3="select * from address where MedicineOrderDetailsId=?";
	try{
		ps3=(PreparedStatement) con.prepareStatement(str3); 
		ps3.setInt(1,medicineorderdetailsid);
		rs3=ps3.executeQuery();
		while(rs3.next()){
        int medicineorderdetailsid1=rs3.getInt("MedicineOrderDetailsId");
        int medicineorderid=rs3.getInt("MedicineOrderId");
        String medicinename=rs3.getString("MedicineName");
        String dosage=rs3.getString("Dosage");
        int quantity=rs3.getInt("Quantity");
        float price=rs3.getFloat("Price");
        medicineorderdetails.add(new model.MedicineOrderDetails(medicineorderdetailsid1,medicineorderid,medicinename,dosage,quantity,price));
        
		}
		
	}
	catch(SQLException se)
	   {
		   
	   }
	return medicineorderdetails; 
}

	 }
	
