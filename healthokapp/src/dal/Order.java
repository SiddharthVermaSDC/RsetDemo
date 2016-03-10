package dal;

import java.sql.SQLException;

import servlet.Crudoperation;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.util.ArrayList;
import java.util.Date;
//import com.mysql.jdbc.ResultSet;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
public class Order {
	
	static Connection con=null;
	static PreparedStatement ps=null;
	
	static Connection con2=null;
	static PreparedStatement ps2=null;
	static ResultSet rs=null;
	static ResultSet rs2=null;
	
	static PreparedStatement ps4=null;
	static Connection con3=null;
    public static int createOrder(model.Order order){
		int result=0;
		Crudoperation crudoperation = new Crudoperation();
		con=(Connection) crudoperation.createConnection();
     	//for date
		Date date = new Date();
	    SimpleDateFormat sdf;
	    sdf = new SimpleDateFormat("yyyy-MM-dd");
	 //   System.out.println(sdf.format(date));
	    
		String str="insert into Order(UserId,OrderTypeId,OrderDate,OrderStatusTypeId,OrderDescription,OrderFulfillDate) values (?,?,?,?,?,?)";
		
		try
		{
			ps=(PreparedStatement) con.prepareStatement(str);result=1;
			ps.setInt(1,order.getUserId());result=2;
		    ps.setInt(2, order.getOrderTypeId());
		    result=3;
			ps.setString(3, sdf.format(date));
			ps.setInt(4,order.getOrderStatusTypeId());
					result=4;
			ps.setString(5,order.getOrderDescription());
			result=5;
			ps.setString(6, "2018-05-15");
			int rw=ps.executeUpdate();result=6;

			   if(rw>0)
			   {
				  // rs = ps.getGeneratedKeys();
	                //if(rs.next())
	                    result =7;//rs.getInt(1);
	 }
			   else{
				   result=-1;
			   }
		
		}
		catch(SQLException se)
		{
			result=40;
		}
		return result;
	}
	
	public static model.Order getOrderDetail(int orderid){
		model.Order order=null;
		Crudoperation crudoperation = new Crudoperation();
		con2=(Connection) crudoperation.createConnection();
		String str1="select * from Order where OrderId=?";
		try{
			ps2=(PreparedStatement) con2.prepareStatement(str1);
			ps2.setInt(1,orderid);
			rs2=ps2.executeQuery();
		     rs2.next();
				int OrderId= rs2.getInt("OrderId");
				int UserId=rs2.getInt("UserId");
				int OrderTypeId=rs2.getInt("OrderTypeId");
				String OrderDate=rs2.getString("OrderDate");
			    int	OrderStatusTypeId=rs2.getInt("OrderStatusTypeId");
				String OrderCompletionDate=rs2.getString("OrderCompletionDate");
			    String OrderDescription=rs2.getString("OrderDescription");
			    int TotalCost=rs2.getInt("TotalCost");
			    int Discount=rs2.getInt("Discount");
			    int CashbackBonusApplied=rs2.getInt("CashbackBonusApplied");
			    int NetAmount=rs2.getInt("NetAmount");
			    String OrderFulfillDate=rs2.getString("OrderFulfillDate");
				 order =  new model.Order(OrderId,UserId,OrderTypeId,OrderDate,OrderStatusTypeId,OrderCompletionDate,OrderDescription,TotalCost, Discount,CashbackBonusApplied,NetAmount,OrderFulfillDate);
			
		}
		catch(SQLException se)
		{
		order = new model.Order(1,1,1,null,1,null,"as",45,65,40,78,"2017-04-12");	
		}
		return order;
	}
	 public static void updateOrder(model.Order order,int orderid){
			Crudoperation crudoperation = new Crudoperation();
			con3=(Connection) crudoperation.createConnection();
		 String str3="update address set TotalCost=?,Discount=?,CashbackBonusApplied=?,NetAmount=? where OrderId=?";
		 try{
			 ps4=(PreparedStatement) con3.prepareStatement(str3);
			 ps4.setInt(1,order.getTotalCost());
			 ps4.setInt(1,order.getDiscount());
			 ps4.setInt(1,order.getCashbackBonusApplied());
			 ps4.setInt(1,order.getNetAmount());
			 ps4.setInt(1,orderid);
			 ps4.executeUpdate();
		 }
		 catch(SQLException se)
		 {
			 
		 }
	 }
}