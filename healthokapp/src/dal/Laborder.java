package dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import servlet.Crudoperation;

public class Laborder {
	
	static Connection con=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
	
	static Connection con1=null;
	static PreparedStatement ps1=null;
	static ResultSet rs1=null;
	
	static Connection con2=null;
	static PreparedStatement ps2=null;
	static ResultSet rs2=null;
	
	static Connection con3=null;
	static PreparedStatement ps3=null;
	
	//place  laborder
	
    public static int placeLabOrder(model.Laborder laborder){
    	int rw= 0;
    	int result=0;
    	Crudoperation crudoperation = new Crudoperation();
		con=(Connection) crudoperation.createConnection();
		String str1="insert into laborder(OrderId,PrescriptionImageId,Description) values (?,?,?)";
		try{
			 ps=(PreparedStatement) con.prepareStatement(str1,Statement.RETURN_GENERATED_KEYS);
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
   // Update lab Order 
    public static int updateLabOrder(int laborderid,int resultimage){
    	int rw= 0;
    	int result=0;
    	Crudoperation crudoperation = new Crudoperation();
		con1=(Connection) crudoperation.createConnection();
		 String str2="update LabOrder set LabResultImageId=? Where LabOrderId = ?";
try{
			 ps1=(PreparedStatement) con1.prepareStatement(str2,Statement.RETURN_GENERATED_KEYS);
			   ps1.setInt(1,resultimage);
			   ps1.setInt(2,laborderid);
				  
			   rw=ps1.executeUpdate();
			  
			   if(rw>0)
			   {
				   rs1 = ps1.getGeneratedKeys();
	                if(rs1.next())
	                    result = rs1.getInt(1);
	     
	 
			   }
			   else{
				   result=-1;
			   }
		}
		catch(SQLException se)
		   {
			   result = 500;
		   }
		return result;
    }
   
    // pending lab order or newly created
    
    
	public static ArrayList<model.Laborder> pendinglorder() {
		 ArrayList<model.Laborder> lorder=new  ArrayList<model.Laborder>();
		//int i= 0;
    	//int result=0;
    	Crudoperation crudoperation = new Crudoperation();
		con2=(Connection) crudoperation.createConnection();
		 String str3="select * from LabOrder where OrderId IN(select OrderId from Order where OrderStatusTypeId=1 and OrderTypeId =2 )";
try{
			 ps2=(PreparedStatement) con2.prepareStatement(str3);
			 	  
			   rs2=ps2.executeQuery();
			   
			  while(rs2.next())
			   {
			        int laborderid=rs2.getInt("LabOrderId");
			        int orderid=rs2.getInt("OrderId");
			        int pimageid=rs2.getInt("PrescriptionImageId");
			        int lrimageid=rs2.getInt("LabResultImageId");
				    String description=rs2.getString("Description");
			      
			        lorder.add(new model.Laborder(laborderid,orderid,pimageid,lrimageid,description));
			        

                }
			   
			  
		}
		catch(SQLException se)
		   {
			  lorder.add(new model.Laborder(0,0,0,0,"")); 
		   }

		
		return lorder;
	}
	
	// delete lab order 
	public static int deleteLaborder(int orderid) {
		int  rw=0;
    	int result=0;
    	Crudoperation crudoperation = new Crudoperation();
		con3=(Connection) crudoperation.createConnection();
		String str2="delete feom LabOrder where OrderId =?";
		try{
			 ps3=(PreparedStatement) con3.prepareStatement(str2);
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
			result = 500;
		   }
		return result;
		}

	 
}
