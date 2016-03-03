    package dal;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	import com.mysql.jdbc.Connection;
	import com.mysql.jdbc.PreparedStatement;
	import com.mysql.jdbc.Statement;

	import servlet.Crudoperation;

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
	 
	    
	    public static int deleteLabOrder(int id){
	    	int  rw=0;
	    	int result=0;
	    	Crudoperation crudoperation = new Crudoperation();
			con1=(Connection) crudoperation.createConnection();
			String str2="delete feom LabOrderDetails where id =?";
			try{
				 ps=(PreparedStatement) con.prepareStatement(str2);
				   ps.setInt(1,id);
				  
				   
				   rw=ps.executeUpdate();
				  
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

	    public static int updateLabOrderd(model.Laborderdetails laborderd){
	    	int  rw=0;
	    	int result=0;
	    	Crudoperation crudoperation = new Crudoperation();
			con2=(Connection) crudoperation.createConnection();
			String str2="update LabOrderDetails(LabOrderId,TestName,Price) values (?,?,?) where id = ?";
			try{
				 ps2=(PreparedStatement) con2.prepareStatement(str2,Statement.RETURN_GENERATED_KEYS);
				 ps2.setInt(1,laborderd.getLaborderId());
				 ps2.setString(2,laborderd.getTestname());
				 ps2.setFloat(3,laborderd.getPrice());
				 ps2.setInt(4,laborderd.getLaborderdetailId());
					 
				   
				   rw=ps2.executeUpdate();
				  
				   if(rw>0)
				   {
					   rs2 = ps2.getGeneratedKeys();
		               if(rs2.next())
		                   result = rs2.getInt(1);
					   
		            }else{
					   result=-1;
				          }
		       }catch(SQLException se)
			   {
				System.out.print(se.getMessage());
				result = 500;
			   }
			return result;
	    }
	 
	}

 

