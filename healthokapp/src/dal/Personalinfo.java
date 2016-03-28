package dal;

import java.sql.*;
import java.util.ArrayList;



public class Personalinfo {
	
	static Connection con=null;
	static PreparedStatement ps2=null;
	
	public static ArrayList<model.Order> getAllOrderDetail(String username){
		//model.Order order=new model.Order();
		ArrayList<model.Order> orders =new ArrayList<model.Order>();
		int userid=dal.GetUserId.userid(username);
ResultSet rs2 = null;
		con=Database.createConnection();
		String str1="select * from healthok.order where UserId=?";
		try{
			ps2=(PreparedStatement) con.prepareStatement(str1);
			ps2.setInt(1,userid);
			rs2=(ResultSet) ps2.executeQuery();
			while(rs2.next()){
				model.Order order=new model.Order();
				/*order.setAddress( rs2.getString("Address"));
				order.setAmount(rs2.getFloat("amount"));
				order.setOrderId(rs2.getInt("orderid"));
				order.setShippingcost(rs2.getInt("ShippingCost"));
				order.setStatus(rs2.getInt("status"));
				order.setTax(rs2.getInt("tax"));
				order.setUserid(rs2.getInt("userid"));*/
				//order.setDate(rs2.getDate("date"));
				orders.add(order);
			}
		}
		catch(SQLException se)
		{
			
		}
		return orders;
	}

}
