package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.Buffer;



public class OrderedItems {
	//for add to ordered items
	static Connection con=null;
	static PreparedStatement ps=null;
	//for get all ordered items of order id
	static Connection con1=null;
	static PreparedStatement ps1=null;
	static ResultSet rs=null;
	
	
	public static void addToItems(String username){
		int userid=0;
		int orderid;
		ArrayList<model.Buffer> buffers=new ArrayList<>();
		buffers=dal.Buffer.getAllbufferItem(username);
		orderid=dal.GetOrderId.getRecentOrderid(username);
		Database database = new Database();
		con=(Connection) database.createConnection();
		try
		{
		for(model.Buffer buff: buffers)
		{
			String str="insert into ordereditems (medicineId,quantity,orderid) values ("+buff.getMedicineId()+","+buff.getQuantity()+","+orderid+")";
			ps=(PreparedStatement) con.prepareStatement(str);
			ps.executeUpdate();
		}	
		}
		catch(SQLException se)
		{
			
		}
	}
	
	public static Map<Long, model.Medicine> getOrderItems(int orderid){
		Map<Long, model.Medicine> medicine =new HashMap<>();
		long i=1;
		Database database = new Database();
		con=(Connection) database.createConnection();
		String str1="SELECT * FROM healthok.ordereditems,healthok.medicine where healthok.ordereditems.orderid=? and healthok.ordereditems.medicineid=healthok.medicine.medicineid";
		try{
		ps1=(PreparedStatement) con.prepareStatement(str1);
		ps1.setInt(1,orderid);
		rs=(ResultSet) ps1.executeQuery();
		while(rs.next()){
			String name=rs.getString("medicineName");
			int quant=rs.getInt("ordereditems.quantity");
			float price=rs.getFloat("price");
			medicine.put(i, new model.Medicine(name, quant, price));
			i++;
		}
		}
		catch(SQLException e)
		{
			System.out.print(e);
		}
		return medicine;
	}

}
