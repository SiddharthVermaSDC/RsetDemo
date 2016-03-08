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
	
	static Connection con4=null;
	static PreparedStatement ps4=null;
	static ResultSet rs4=null;
	
	
	//place  laborder
	
    public static int placeLabOrder(model.Order order){
    	int rw= 0;
    	int result=0;
    	Crudoperation crudoperation = new Crudoperation();
		String str1="insert into laborder(OrderId,PrescriptionImageId,Description) values (?,?,?)";
		try{
			   con=(Connection) crudoperation.createConnection();
			   ps=(PreparedStatement) con.prepareStatement(str1,Statement.RETURN_GENERATED_KEYS);
			   ps.setInt(1,order.getOrderId());
			   ps.setInt(2, 1);
			   ps.setString(3,order.getOrderDescription());
			   
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
			   con.close();
		}
		catch(SQLException se)
		   {
			   
		   }
		return result;
    }
   // Update lab Order 
    public static int updateResultLabOrder(int laborderid,int resultimage){
    	int rw= 0;
    	int result=0;
    	Crudoperation crudoperation = new Crudoperation();
		 String str2="update LabOrder set LabResultImageId=? Where LabOrderId = ?";
try{         
	         con1=(Connection) crudoperation.createConnection();
	
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
			   con1.close();
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
		 String str3="select * from LabOrder where OrderId IN(select OrderId from Order where OrderStatusTypeId=1 and OrderTypeId =2 )";
try{          
	         con2=(Connection) crudoperation.createConnection();
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
			   
			  con2.close();
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
		String str2="delete feom LabOrder where OrderId =?";
		try{  
			 con3=(Connection) crudoperation.createConnection();
		
			 ps3=(PreparedStatement) con3.prepareStatement(str2);
			   ps3.setInt(1,orderid);
			  
			   
			   rw=ps3.executeUpdate();
			  
			   if(rw>0)
			   {
				  result = 1;
	            }else{
				   result=-1;
			          }
			   con3.close();
	       }catch(SQLException se)
		   {
			//System.out.print(se.getMessage());
			result = 500;
		   }
		return result;
		}

	 
	public static int updateLabOrder(model.Laborder laborder){
    	int rw= 0;
    	int result=0;
    	Crudoperation crudoperation = new Crudoperation();
		 String str2="update LabOrder set OrderId = ?PrescriptionImageId= ?Description = ? Where LabOrderId = ?";
try{
	           con4=(Connection) crudoperation.createConnection();
	
	           ps4=(PreparedStatement) con4.prepareStatement(str2,Statement.RETURN_GENERATED_KEYS);
			   ps4.setInt(1,laborder.getOrderId());
			   ps4.setInt(2,laborder.getPrescriptionimageId());
			   ps4.setString(3,laborder.getDisription());
			   ps4.setInt(4,laborder.getLaborderId());
				  
			   rw=ps4.executeUpdate();
			  
			   if(rw>0)
			   {
				   rs4 = ps4.getGeneratedKeys();
	                if(rs4.next())
	                    result = rs4.getInt(1);
	     
	 
			   }
			   else{
				   
				   result=-1;
			   }
			   con4.close();
		
      }catch(SQLException se)
		   {
			   result = 500;
		   }
		return result;
}
}