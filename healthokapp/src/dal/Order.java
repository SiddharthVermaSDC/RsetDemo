package dal;

import java.sql.*;



import java.util.ArrayList;
import java.util.Date;

import model.OrderStatusType;
import model.OrderType;
import util.Logging;
import util.StatusCode;

import java.io.Console;
import java.text.SimpleDateFormat;

public class Order {
	
	
	
    public  int createOrder(model.OrderBase order){
		int orderId = -1;

		Connection connection= null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
     	//for date
		java.sql.Date orderDate = new java.sql.Date(order.getOrderDate().getTime());
		java.sql.Date orderFulfillDate = new java.sql.Date(order.getOrderFulfillDate().getTime());
		
		
		try
		{
			String str="insert into `Order`(UserId,OrderTypeId,OrderDate,OrderStatusTypeId,OrderFulfillDate) values (?,?,?,?,?)";

			connection =  Database.createConnection();

			ps=(PreparedStatement) connection.prepareStatement(str,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1,order.getUserId());
		    ps.setInt(2, order.getOrderType().getOrderType());
			ps.setDate(3, orderDate);
			ps.setInt(4,order.getOrderStatusType().getOrderStatusType());
			//ps.setString(5,order.getOrderDescription());
			ps.setDate(5, orderFulfillDate );
			int rw=ps.executeUpdate();

			   if(rw>0)
			   {
				  rs = ps.getGeneratedKeys();
	                if(rs.next())
	                    orderId =rs.getInt(1);
	 }
		
	
		}
		catch(SQLException se)
		{
			Logging.Exception("OrderDAL", "Error Creating Order " + ps.toString() + " Exception " + se.getMessage());
		}
		finally{
			Database.closeConnection(connection);
		}
		return orderId;
	}

	
	
	
	
    public  int createOrder(model.Order order){
		int result=0;

		Connection connection= null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
     	//for date
		java.sql.Date orderDate = new java.sql.Date(order.getOrderDate().getTime());
		java.sql.Date orderFulfillDate = new java.sql.Date(order.getOrderFulfillDate().getTime());
		
	    SimpleDateFormat sdf;
	    sdf = new SimpleDateFormat("yyyy-MM-dd");
	 //   System.out.println(sdf.format(date));
	    
		
		try
		{
			String str="insert into `Order`(UserId,OrderTypeId,OrderDate,OrderStatusTypeId,OrderDescription,OrderFulfillDate) values (?,?,?,?,?,?)";

			connection =  Database.createConnection();

			ps=(PreparedStatement) connection.prepareStatement(str,Statement.RETURN_GENERATED_KEYS);result=1;
			ps.setInt(1,order.getUserId());result=2;
		    ps.setInt(2, order.getOrderType().getOrderType());
		    result=3;
			ps.setDate(3, orderDate);
			ps.setInt(4,order.getOrderStatusType().getOrderStatusType());
					result=4;
			ps.setString(5,order.getOrderDescription());
			result=5;
			ps.setDate(6, orderFulfillDate );
			int rw=ps.executeUpdate();result=6;

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
			result=40;
		}
		finally{
			Database.closeConnection(connection);
		}
		return result;
	}
	
	public  model.Order getOrderDetail(int orderid) {
		model.Order order=null;
		Connection connection= null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try{
			String str1="select * from `Order` where OrderId=?";
			
			connection =  Database.createConnection();
			ps=(PreparedStatement) connection.prepareStatement(str1);
			ps.setInt(1,orderid);
			rs=ps.executeQuery();
		     rs.next();
				int orderId= rs.getInt("OrderId");
				int userId=rs.getInt("UserId");
				OrderType orderType=OrderType.item(rs.getInt("OrderTypeId"));
				Date orderDate=rs.getDate("OrderDate");
			    OrderStatusType orderStatusType= OrderStatusType.item( rs.getInt("OrderStatusTypeId"));
				Date orderCompletionDate=rs.getDate("OrderCompletionDate");
			    String comments=rs.getString("Comments");
			    int totalCost=rs.getInt("TotalCost");
			    int discount=rs.getInt("Discount");
			    int cashbackBonusApplied=rs.getInt("CashbackBonusApplied");
			    int netAmount=rs.getInt("NetAmount");
			    Date orderFulfillDate=rs.getDate("OrderFulfillDate");
			    
				 order =  new model.Order(orderId,userId,orderType,orderDate,orderStatusType,orderCompletionDate, comments,totalCost, discount,cashbackBonusApplied,netAmount,orderFulfillDate,null);
			
		}
		catch(SQLException se)
		{
			Logging.Error("ORDERDAL","Error in get order details" + se.getMessage());
	  	    // Dont send a fake order object order = new model.Order(1,1,1,null,1,null,"as",1,1,1,1,"0000-00-00");	
		}
		finally{
			Database.closeConnection(connection);
		}

		return order;
	}
	
	 public  StatusCode updateOrder(model.Order order,int orderid) // seems limited use. Need to fix this to update all fields in order table. 
	 {

		 
			Connection connection= null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			StatusCode status = StatusCode.UnknownError;

		 try{
			 String str="update `Order` set TotalCost=?,Discount=?,CashbackBonusApplied=?,NetAmount=? where OrderId=?";

				connection =  Database.createConnection();
			 ps=(PreparedStatement) connection.prepareStatement(str);
			 ps.setInt(1,order.getTotalCost());
			 ps.setInt(2,order.getDiscount());
			 ps.setInt(3,order.getCashbackBonusApplied());
			 ps.setInt(4,order.getNetAmount());
			 ps.setInt(5,orderid);
			 ps.executeUpdate();
            status = StatusCode.Success;
            
		 }
		 catch(SQLException se)
		 {
				Logging.Error("ORDERDAL","Error in update order" + se.getMessage());
				status = StatusCode.UnknownError;
				
		 }
			finally{
				Database.closeConnection(connection);
			}
		 
		 return status;
		
	 }




		public  ArrayList<model.OrderBase> getUserOrders(int userId) {

			Connection connection= null;
			PreparedStatement ps = null;
			ResultSet rs = null;

			try{
				
						
				
				String str1="SELECT o.OrderId, o.OrderDate, o.OrderFulfillDate, o.OrderCompletionDate, o.OrderTypeId,o.OrderStatusTypeId,"
						    + " MO.PrescriptionImageId, MO.Description mdesc, LO.PrescriptionImageId labPrescription, LO.Description ldesc, DA.DoctorId, DA.Description ddesc, AO.Description adesc, NO.Description ndesc FROM `Order` "
						    + "  AS o Left Join (MedicineOrder AS MO, LabOrder as LO, AmbulanceOrder as AO, NurseOrder as NO, DoctorAppointment as DA) " 
				            + "  on MO.OrderId = o.orderId and LO.OrderId = o.OrderId and AO.OrderId = o.OrderId and   NO.OrderId = o.orderid and DA.OrderId = o.OrderId "
				            +  " WHERE userid = ?";
				
				Logging.Debug("ORDERDAL", str1);
				connection =  Database.createConnection();
				ps=(PreparedStatement) connection.prepareStatement(str1);
				ps.setInt(1,userId);
				rs=ps.executeQuery();

				ArrayList<model.OrderBase> orderList = new ArrayList<model.OrderBase>();
				model.OrderBase order = null;
				while ( rs.next())
				{
				order = new model.OrderBase();
					order.setOrderId(rs.getInt("OrderId"));
					order.setOrderDate(rs.getDate("OrderDate"));
					order.setOrderFulfillDate(rs.getDate("OrderFulfillDate"));
					order.setOrderCompletionDate(rs.getDate("OrderCompletionDate"));
					order.setOrderStatusType(OrderStatusType.item(rs.getInt("OrderStatusTypeId")));
					order.setOrderType(OrderType.item(rs.getInt("OrderTypeId")));
					order.setUserId(userId);
					order.setDoctorId(rs.getInt("DoctorId"));
				    
					switch ( order.getOrderType() )
					{
					case AMBULANCE:
						order.setOrderDescription(rs.getString("adesc"));
						break;
					case APPT:
						order.setOrderDescription(rs.getString("adesc"));
						break;
					case LAB:
						order.setOrderDescription(rs.getString("ldesc"));
						order.setImageId(rs.getInt("LabPrescription") );
						break;
					case MEDICINE:
						order.setOrderDescription(rs.getString("mdesc"));
						order.setImageId(rs.getInt("PrescriptionImageId") );
						break;
					case NURSE:
						break;
					default:
						break;
					
					
					}
					
					orderList.add(order);
					
				}
				
				return orderList;
			}
			catch(SQLException se)
			{
				Logging.Error("ORDERDAL","Error in get order details" + se.getMessage());
		  	    // Dont send a fake order object order = new model.Order(1,1,1,null,1,null,"as",1,1,1,1,"0000-00-00");
				return null;
			}
			finally{
				Database.closeConnection(connection);
			}

			//return null;
		}
		
		public  ArrayList<model.OrderBase> getUserAppointment(int userId) {

			Connection connection= null;
			PreparedStatement ps1 = null;
			ResultSet rs1,rs2 = null;

			try{
				
				String str2="SELECT o.OrderId, o.OrderDate, o.OrderFulfillDate, o.OrderCompletionDate, o.OrderTypeId,o.OrderStatusTypeId,"
						+"DA.DoctorId, DA.Description ddesc FROM `Order` "
					    +" AS o Left Join (DoctorAppointment as DA)"  
			            +" on O.OrderId=o.orderId and DA.OrderId = o.OrderId "
			            +" WHERE userid = ?";

				
				
				connection =  Database.createConnection();
				ps1=(PreparedStatement) connection.prepareStatement(str2);
				ps1.setInt(1,userId);
				rs1=ps1.executeQuery();

				ArrayList<model.OrderBase> orderList1 = new ArrayList<model.OrderBase>();
				model.OrderBase order = null;
				while ( rs1.next())
				{
				order = new model.OrderBase();
					order.setOrderId(rs1.getInt("OrderId"));
					order.setOrderDate(rs1.getDate("OrderDate"));
					order.setOrderFulfillDate(rs1.getDate("OrderFulfillDate"));
					order.setOrderCompletionDate(rs1.getDate("OrderCompletionDate"));
					order.setOrderStatusType(OrderStatusType.item(rs1.getInt("OrderStatusTypeId")));
					order.setOrderType(OrderType.item(rs1.getInt("OrderTypeId")));
					order.setUserId(userId);
					order.setDoctorId(rs1.getInt("DoctorId"));
				    order.setOrderDescription(rs1.getString("ddesc"));
					orderList1.add(order);
					
				model.Doctor doctor = new model.Doctor();
				String q1="Select * from Doctor where DoctorId=?";
				ps1=(PreparedStatement) connection.prepareStatement(q1);
				ps1.setInt(1,order.getDoctorId());
				rs2=ps1.executeQuery();
				if(rs2.next())
				{
				doctor.setDoctorId(rs2.getInt("DoctorId"));
				doctor.setEmergencyFees(rs2.getInt("EmergencyFees"));
				doctor.setBelongToAnyHospital(rs2.getBoolean("IsBelongToAnyHospital"));
				doctor.setDoctorRegistrationDate(rs2.getDate("DoctorRegistrationDate"));
				doctor.setEmailId(rs2.getString("EmailId"));
				doctor.setProvideHomecare(rs2.getBoolean("IsProvideHomeCare"));
				doctor.setPharmacy(rs2.getBoolean("IsPharmacy"));
				doctor.setFirstName(rs2.getString("FirstName"));
				doctor.setMiddleName(rs2.getString("MiddleName"));
				doctor.setLastName(rs2.getString("LastName"));
				doctor.setSpecialityId(rs2.getInt("SpecialityId"));
				doctor.setDoctorImageid(rs2.getInt("doctorImageId"));
				doctor.setSpecialityId(rs2.getInt("SpecialityId"));
				//doctor.setSpeciality(rs2.getString("SpecialityText"));
				doctor.setDegree(rs2.getString("Degree"));
				doctor.setClinicTiming(rs2.getString("ClinicTiming"));
				doctor.setOffDay(rs2.getString("OffDay"));
				doctor.setFees(rs2.getInt("Fees"));
				doctor.setInPanel(rs2.getBoolean("InPanel"));
				doctor.setAppointmnet(rs2.getBoolean("IsAppointmentEnabled"));
				doctor.setVirtualReceptionist(rs2.getBoolean("isVirtualReceptionistEnabled"));
				doctor.setPostcare(rs2.getBoolean("IsPostCareEnabled"));
				doctor.setYearofExperience(rs2.getInt("YearsOfExperience"));
				doctor.setAddressLine1(rs2.getString("AddressLine1"));
				doctor.setAddressLine2(rs2.getString("AddressLine2"));
				doctor.setAddressLine3(rs2.getString("AddressLine3"));
				doctor.setCityId(rs2.getInt("CityId"));
				doctor.setPincode(rs2.getString("PinCode"));
				
				order.setDoctor(doctor);
				}
				
			//	orderList1.add(order);
				}
				
				return orderList1;
			}
			catch(SQLException se)
			{
				Logging.Error("ORDERDAL","Error in get order details" + se.getMessage());
				return null;
		  	    // Dont send a fake order object order = new model.Order(1,1,1,null,1,null,"as",1,1,1,1,"0000-00-00");	
			}
			finally{
				Database.closeConnection(connection);
			}

			
		}    


}