    package dal;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	import com.mysql.jdbc.Connection;
	import com.mysql.jdbc.PreparedStatement;
	import com.mysql.jdbc.Statement;

	public class LabOrderDetails {
		static Connection con=null;
		static PreparedStatement ps=null;
		static ResultSet rs=null;
	   
		static Connection con1=null;
		static PreparedStatement ps1=null;
		
		static Connection con2=null;
		static PreparedStatement ps2=null;
		static ResultSet rs2=null;
	   

		
	    public static int placeLabOrderd(model.Laborderdetails laborderd){
	    	int  rw=0;
	    	int result=0;
	    	Crudoperation crudoperation = new Crudoperation();
			String str1="insert into LabOrderDetails(LabOrderId,TestName,Price) values (?,?,?)";
			try{

				 con=(Connection) crudoperation.createConnection(); 
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
					   
		            }else{
					   result=-1;
				  con.close(); 
				  }
		       }catch(SQLException se)
			   {
				//System.out.print(se.getMessage());
				result = 500;
			   }finally{
				  
			   }
			return result;
			
	    }
	 
	    
	    public static int deleteLabOrder(int id){
	    	int  rw=0;
	    	int result=0;
	    	Crudoperation crudoperation = new Crudoperation();
			
			String str2="delete from LabOrderDetails where LabOrderId =?";
			try{
				con1=(Connection) crudoperation.createConnection();
				 ps1=(PreparedStatement) con1.prepareStatement(str2);
				   ps1.setInt(1,id);
				  
				   
				   rw=ps1.executeUpdate();
				  
				   if(rw>0)
				   {
					  result = 1;
		            }else{
					   result=-1;
				          }
				   con1.close();
		       }catch(SQLException se)
			   {
				//System.out.print(se.getMessage());
				result = 500;
			   }
			return result;
	    }

	    public static int updateLabOrderd(model.Laborderdetails laborderd){
	    	int  rw=0;
	    	int result=0;
	    	Crudoperation crudoperation = new Crudoperation();
			String str2="update LabOrderDetails set TestName =?, Price=? where LabOrderId = ?";
			try{
				con2=(Connection) crudoperation.createConnection();
				
				 ps2=(PreparedStatement) con2.prepareStatement(str2);
				 ps2.setInt(3,laborderd.getLaborderId());
				 ps2.setString(1,laborderd.getTestname());
				 ps2.setFloat(2,laborderd.getPrice());
				// ps2.setInt(4,laborderd.getLaborderdetailId());
					 
				   
				   rw=ps2.executeUpdate();
				  
				   if(rw>0)
				   {
					   result=1;
				   }else{
					   result=-1;
				          }
				   con2.close();
		       }catch(SQLException se)
			   {
				//System.out.print(se.getMessage());
				result = 500;
			   }
			return result;
	    }
	 
	}

 

