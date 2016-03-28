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

/*
	public static ArrayList<model.Laborder> pendinglorder() {
		ArrayList<model.Laborder> lorder=new  ArrayList<model.Laborder>();
		//int i= 0;
		//int result=0;
		Database database = new Database();
		String str3="select * from LabOrder where OrderId IN(select OrderId from Order where OrderStatusTypeId=1 and OrderTypeId =2 )";
		try{          
			con2=(Connection) database.createConnection();
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
		Database database = new Database();
		String str2="delete feom LabOrder where OrderId =?";
		try{  
			con3=(Connection) database.createConnection();

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
		Database database = new Database();
		String str2="update LabOrder set OrderId = ?PrescriptionImageId= ?Description = ? Where LabOrderId = ?";
		try{
			con4=(Connection) database.createConnection();

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
*/
}