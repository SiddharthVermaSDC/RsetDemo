package dal;

import java.sql.*;
import java.util.ArrayList;

import util.Logging;
import util.StatusCode;



public class Laborder {


	public int placeOrder(model.OrderBase order){

		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;

		int rw= 0;
		int labOrderId = -1;
		String str="insert into LabOrder(OrderId,PrescriptionImageId,Description) values (?,?,?)";

		try{


			connection=Database.createConnection();

			ps=(PreparedStatement) connection.prepareStatement(str,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1,order.getOrderId());
			ps.setInt(2, order.getImageId());
			ps.setString(3,order.getOrderDescription());

			rw=ps.executeUpdate();

			if(rw>0)
			{
				rs = ps.getGeneratedKeys();
				if(rs.next())
					labOrderId = rs.getInt(1);

			}
		}
		catch(SQLException se)
		{
			Logging.Exception("LabOrderDAL", "Error Creating Order " + ps.toString() + " Exception " + se.getMessage());


		}
		finally 
		{

			Database.closeConnection(connection);
		}

		return labOrderId;
	}
	
	
	// Update lab Order 
	public StatusCode updateResultLabOrder(int laborderid,int resultimage){

		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		StatusCode statusCode = StatusCode.UnknownError;

		int rw= 0;
		String str="update LabOrder set LabResultImageId=? Where LabOrderId = ?";
		try{         

			connection=Database.createConnection();

			ps=(PreparedStatement) connection.prepareStatement(str,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1,resultimage);
			ps.setInt(2,laborderid);

			rw=ps.executeUpdate();

			if(rw>0)
			{
				statusCode = StatusCode.Success;	
			}
			else{
				statusCode = StatusCode.Error;	
			}
		}
		catch(SQLException se)
		{
			statusCode = StatusCode.UnknownError;	
			Logging.Exception("MedicineOrderDAL", "Error Creating Order " + ps.toString() + " Exception " + se.getMessage());
		}
		
		finally
		{
			
			Database.closeConnection(connection);
		}
		return statusCode;
	}

	// pending lab order or newly created


	public static ArrayList<model.Laborder> pendingLabOrders() {

		
		
		ArrayList<model.Laborder> lorder=new  ArrayList<model.Laborder>();
		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;

		String str3="select * from LabOrder where OrderId IN(select OrderId from Order where OrderStatusTypeId=1 and OrderTypeId =2 )";
		try{          
			connection=Database.createConnection();
			ps= connection.prepareStatement(str3);

			rs=ps.executeQuery();

			while(rs.next())
			{
				// TODO - FIx this to set properties instead of calling constructor. 
				int laborderid=rs.getInt("LabOrderId");
				int orderid=rs.getInt("OrderId");
				int pimageid=rs.getInt("PrescriptionImageId");
				int lrimageid=rs.getInt("LabResultImageId");
				String description=rs.getString("Description");

				lorder.add(new model.Laborder(laborderid,orderid,pimageid,lrimageid,description));


			}
		}
		catch(SQLException se)
		{
			lorder.add(new model.Laborder(0,0,0,0,"")); 
		}

finally 
{
Database.closeConnection(connection);	
}
		return lorder;
	}

	// delete lab order 
	public  util.StatusCode deleteLaborder(int orderid) {
		int  rw=0;

		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;

		StatusCode status = StatusCode.UnknownError;
		
		Database database = new Database();
		String str2="delete feom LabOrder where OrderId =?";
		try{  
			connection=Database.createConnection();

			ps=connection.prepareStatement(str2);
			ps.setInt(1,orderid);


			rw=ps.executeUpdate();

			if(rw>0)
			{
				status = StatusCode.Success;
			}else{
status = StatusCode.Error;

}
		}catch(SQLException se)
		{
status = StatusCode.UnknownError;		}
		
		finally {
			Database.closeConnection(connection);
		}
		
		return status;
	}


	public  int updateLabOrder(model.Laborder laborder){
		int rw= 0;
		int result=0;
		Database database = new Database();
		Connection con4=null;
		PreparedStatement ps4=null;
		ResultSet rs4=null;

		String str2="update LabOrder set OrderId = ?PrescriptionImageId= ?Description = ? Where LabOrderId = ?";
		try{
			con4=Database.createConnection();

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