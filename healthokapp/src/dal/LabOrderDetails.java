    package dal;
	import java.sql.*;
import java.util.ArrayList;

import model.LabOrderDetail;
import util.Logging;
import util.StatusCode;


	public class LabOrderDetails {
		

		
		// Use this to add lab order details or update existing
		
	    public StatusCode placeLabOrderdetails(ArrayList<model.LabOrderDetail> labOrderDetails){
	    	int  rw=0;
	    	int result=0;
	    	Database database = new Database();
	    	
			String insert="insert into LabOrderDetails(LabOrderId,TestName,Price) values (?,?,?)";
			String update ="update LabOrderDetails set TestName = ?, Price = ? where LabOrderDetailId = ?";
			
			Connection connection= null;
			PreparedStatement psInsert = null;
			PreparedStatement psUpdate = null;
			ResultSet rs = null;
			StatusCode status = StatusCode.UnknownError;

			
			try{

				connection =  Database.createConnection();
				psInsert=connection.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
				psUpdate=connection.prepareStatement(update);

				for ( model.LabOrderDetail labOrderDetail : labOrderDetails )
					
				{
					
					if ( labOrderDetail.getLaborderdetailId() > 0) // existing record do an update
					{
						psUpdate.setString(1,labOrderDetail.getTestname());
						psUpdate.setFloat(2,labOrderDetail.getPrice());
						psUpdate.setInt(3, labOrderDetail.getLaborderdetailId());

						
						   rw=psInsert.executeUpdate();
							  
						   if(rw>0) // record not found to update. 
						   {
							   rs = psInsert.getGeneratedKeys();
				               if(rs.next())
				                   labOrderDetail.setLaborderdetailId(rs.getInt(1));
							   
						   }
						   else
						   {
							   // no idea what to do. IN a proper setup this entire operation will be in a single transaction. 
							   
						   }

						
						
					}
					else // new record, do an insert
					{
						psInsert.setInt(1,labOrderDetail.getLaborderId());
						 psInsert.setString(2,labOrderDetail.getTestname());
						 psInsert.setFloat(3,labOrderDetail.getPrice());

						   rw=psInsert.executeUpdate();
							  
						   if(rw>0) // no rows inserted. 
						   {
							   rs = psInsert.getGeneratedKeys();
				               if(rs.next())
				                   labOrderDetail.setLaborderdetailId(rs.getInt(1));
							   
						   }
						   else
						   {
							   // no idea what to do. IN a proper setup this entire operation will be in a single transaction. 
							   
						   }
						 
					}
				}
				   
			status = StatusCode.Success;
			return status; 
		       }
			
			catch(SQLException se)
			   {

				status = StatusCode.UnknownError;
				Logging.Exception("LabOrderDetailDal", "Put Lab Order details failed " + se.getMessage());
			   }finally{
				   Database.closeConnection(connection);
			   }
			return status;
			
	    }
	 
	    
	    public static int deleteLabOrder(int id){
	    	int  rw=0;
	    	int result=0;

			Connection con1= null;
			PreparedStatement ps1 = null;
			ResultSet rs = null;

	    	
			String str2="delete from LabOrderDetails where LabOrderId =?";
			try{
				con1=Database.createConnection();
				 ps1=(PreparedStatement) con1.prepareStatement(str2);
				   ps1.setInt(1,id);
				  
				   
				   rw=ps1.executeUpdate();
				  
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
			finally {
				Database.closeConnection(con1);
			}
			return result;
	    }

	    public int updateLabOrderdetail(LabOrderDetail laborderd){
	    	int  rw=0;
	    	int result=0;

			Connection con2= null;
			PreparedStatement ps2 = null;

	    	
	    	String str2="update LabOrderDetails set TestName =?, Price=? where LabOrderId = ?";
			try{
				con2=Database.createConnection();
				
				 ps2= con2.prepareStatement(str2);
				 ps2.setString(1,laborderd.getTestname());
				 ps2.setFloat(2,laborderd.getPrice());
				 ps2.setInt(3,laborderd.getLaborderId());
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
	 
	    
	    public ArrayList<LabOrderDetail> getLabOrderDetails (int labOrderId)
	    {

			Connection connection= null;
			PreparedStatement ps = null;
			ResultSet rs = null;

			ArrayList<LabOrderDetail> labOrderDetails = null;
			LabOrderDetail labOrderDetail = new LabOrderDetail();
			
			String query = "Select LabOrderDetailId, labOrderId, TestName, Price from LabOrderDetail where labOrderid = ?";
	    	
					try{
						
						connection = Database.createConnection();
						ps = connection.prepareStatement(query);
						ps.setInt(1, labOrderId);
						
						rs = ps.executeQuery();
			labOrderDetails = new ArrayList<model.LabOrderDetail>();			
						while ( rs.next())
						{
							labOrderDetail = new model.LabOrderDetail();
							labOrderDetail.setLaborderdetailId(rs.getInt("LabOrderDetail"));
							labOrderDetail.setLaborderId(rs.getInt("LabOrderId"));
							labOrderDetail.setPrice(rs.getFloat("Price"));
							labOrderDetail.setTestname(rs.getString("TestName"));
labOrderDetails.add(labOrderDetail)	;						
						}
						
						return labOrderDetails;
					}
			catch ( SQLException se)
			{
				Logging.Exception("LabOrderDetailDal", "unable to get lab order details " + se.getMessage());
			}
			finally
			{
				Database.closeConnection(connection);
			}
					return labOrderDetails;
	    }
	    
	}

 

