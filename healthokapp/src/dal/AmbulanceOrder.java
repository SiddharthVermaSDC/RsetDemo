package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



import util.Logging;

public class AmbulanceOrder{
	
	
	
	
	
	public int placeOrder(model.OrderBase order){

		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;

		int rw= 0;
		int ambulanceOrderId = -1;
		String str="insert into AmbulanceOrder(OrderId,Description) values (?,?)";

		try{


			connection=Database.createConnection();

			ps=(PreparedStatement) connection.prepareStatement(str,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1,order.getOrderId());
			ps.setString(2,order.getOrderDescription());

			rw=ps.executeUpdate();

			if(rw>0)
			{
				rs = ps.getGeneratedKeys();
				if(rs.next())
					ambulanceOrderId = rs.getInt(1);

			}
		}
		catch(SQLException se)
		{
			Logging.Exception("AmbulanceOrderDAL", "Error Creating Order " + ps.toString() + " Exception " + se.getMessage());
		}
		finally 
		{

			Database.closeConnection(connection);
		}

		return ambulanceOrderId;
	}
	
	
	}
	
