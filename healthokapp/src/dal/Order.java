package dal;

import java.sql.SQLException;

import servlet.Crudoperation;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.util.ArrayList;
import java.sql.Date;
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
			ps=(PreparedStatement) con.prepareStatement(str);
			ps.setInt(1, order.getUserId());
		    ps.setInt(2, order.getOrderTypeId());
			//ps1.setDate(3, order.getOrderDate());
			ps.setInt(3, order.getOrderStatusTypeId());
			ps.setString(4, order.getOrderDescription());
			int rw=ps.executeUpdate();

			   if(rw>0)
			   {
				  // rs = ps.getGeneratedKeys();
	                //if(rs.next())
	                    result =3;//rs.getInt(1);
	 }
			   else{
				   result=-1;
			   }
		
		}
		catch(SQLException se)
		{
			result=10;
		}
		return result;
	}
	
	public static ArrayList<model.Order> getOrderDetail(int orderid){
		ArrayList<model.Order> order=new ArrayList<model.Order>();
		Crudoperation crudoperation = new Crudoperation();
		con=(Connection) crudoperation.createConnection();
		String str1="select * from Order where OrderId=?";
		try{
			ps2=(PreparedStatement) con.prepareStatement(str1);
			ps2.setInt(1,orderid);
			rs2=ps2.executeQuery();
		while(rs2.next()){
				int OrderId= rs2.getInt("OrderId");
				int UserId=rs2.getInt("UserId");
				int OrderTypeId=rs2.getInt("OrderTypeId");
				Date OrderDate=rs2.getDate("OrderDate");
			    int	OrderStatusTypeId=rs2.getInt("OrderStatusTypeId");
				Date OrderCompletionDate=rs2.getDate("OrderCompletionDate");
			    String OrderDescription=rs2.getString("OrderDescription");
			    int TotalCost=rs2.getInt("TotalCost");
			    int Discount=rs2.getInt("Discount");
			    int CashbackBonusApplied=rs2.getInt("CashbackBonusApplied");
			    int NetAmount=rs2.getInt("NetAmount");
				order.add(new model.Order(OrderId,UserId,OrderTypeId,OrderDate,OrderStatusTypeId,OrderCompletionDate,OrderDescription,TotalCost, Discount,CashbackBonusApplied,NetAmount));
			}
		}
		catch(SQLException se)
		{
			
		}
		return order;
	}



}
