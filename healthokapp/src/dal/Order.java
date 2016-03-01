package dal;

import java.sql.SQLException;

import servlet.Crudoperation;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.util.Date;
//import com.mysql.jdbc.ResultSet;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
public class Order {
	
	static Connection con=null;
	static PreparedStatement ps=null;
	/*
	static Connection con2=null;
	static PreparedStatement ps2=null;
	*/static ResultSet rs=null;
	public static int createOrder(model.Order order){
		int result=0;
		Crudoperation crudoperation = new Crudoperation();
		con=(Connection) crudoperation.createConnection();
	/*	Date date = new Date();
	    SimpleDateFormat sdf;
	    sdf = new SimpleDateFormat("MMM dd yyyy");
	    System.out.println(sdf.format(date));
	 */ 
		String str="insert into Order(UserId,OrderTypeId,OrderStatusTypeId,OrderDescription) values (?,?,?,?)";
		
		try{
			ps=(PreparedStatement) con.prepareStatement(str,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, order.getUserId());
		    ps.setInt(2, order.getOrderTypeId());
			//ps1.setDate(3, order.getOrderDate());
			ps.setInt(3, order.getOrderStatusTypeId());
			ps.setString(4, order.getOrderDescription());
			int rw=ps.executeUpdate();

			   if(rw>0)
			   {
				   rs = ps.getGeneratedKeys();
	                if(rs.next())
	                    result =rs.getInt(1);
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
	
	/*public static model.Order getOrderDetail(int orderid){
		model.Order order=new model.Order();
		Crudoperation crudoperation = new Crudoperation();
		con=(Connection) crudoperation.createConnection();
		String str1="select * from healthok.order where orderId=?";
		try{
			ps2=(PreparedStatement) con.prepareStatement(str1);
			ps2.setInt(1,orderid);
			rs2=(ResultSet) ps2.executeQuery();
			if(rs2.next()){
				order.setAddress( rs2.getString("Address"));
				order.setAmount(rs2.getFloat("amount"));
				order.setOrderId(rs2.getInt("orderid"));
				order.setShippingcost(rs2.getInt("ShippingCost"));
				order.setStatus(rs2.getInt("status"));
				order.setTax(rs2.getInt("tax"));
				order.setUserid(rs2.getInt("userid"));
			}
		}
		catch(SQLException se)
		{
			
		}
		return order;
	}*/

}
