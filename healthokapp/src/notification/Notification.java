package notification;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.ws.rs.PathParam;

import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;

import util.Logging;
import util.StatusCode;

public class Notification {

	private static String[] ADMIN_EMAIL = {"gorakhpurhealthok@gmail.com" ,"healthok.in@gmail.com"};
	private static String[] ADMIN_PHONE = {"9794430208", "9971931767"};
	
	
	public StatusCode orderUpdate ( model.OrderBase order)
	{
		StatusCode status = StatusCode.UnknownError;
		
		String customerMessage= null, adminMessage = null, subject = null;
		
		switch ( order.getOrderStatusType())
		{
		case CANCELLED:
			subject = "Order Cancelled";
			customerMessage = "Your Order has been Cancelled for further details call HealthOk Toll Free at 1-800-3000-6588";
			adminMessage = "Order Id: " + Integer.toString(order.getOrderId()) + " " + order.getOrderType().name() +   " has been Cancelled.";
			break;
		case COMPLETE:
			subject = "Order Commplete";
			customerMessage = "Your Order has been Completed for further details call HealthOk Toll Free at 1-800-3000-6588";
			adminMessage = "Order Id: " + Integer.toString(order.getOrderId()) + " " + order.getOrderType().name() +  " has been Completed.";
			break;
		case DISPATCHED:
			subject = "Order Dispatched";
			customerMessage = "Your Order has been Dispatched for further details call HealthOk Toll Free at 1-800-3000-6588";
			adminMessage = "Order Id: " + Integer.toString(order.getOrderId()) + " " + order.getOrderType().name() +  " has been Dispatched.";
			break;
		case INPROGRESS:
			subject = "Order In Progress";
			customerMessage = "We have started processing your order. For further details call HealthOk Toll Free at 1-800-3000-6588";
			adminMessage = "Order Id: " + Integer.toString(order.getOrderId()) + " " + order.getOrderType().name() +  " is now In Progress.";
			break;
		case NEW:
			subject = "New Order Placed";
			customerMessage = "Thank you for your order at HEALTH-OK. We will continue to update you on order Status. For further details call HealthOk Toll Free at 1-800-3000-6588";
			adminMessage = "New Order Order Id: " + Integer.toString(order.getOrderId()) + " " + order.getOrderType().name() ;
			break;
		case ONHOLD:
			subject = "Order on Hold";
			customerMessage = "Your order has been placed on hold. For further details call HealthOk Toll Free at 1-800-3000-6588";
			adminMessage = "Order Id: " + Integer.toString(order.getOrderId()) + " " + order.getOrderType().name() +  " is on hold.";
			break;
		default:
			break;
		
		}
		
		this.sendMessageToAdmin(adminMessage, subject);
		this.sendMessageToUser(order.getUserId(), customerMessage, subject);
		
		return status;
		
		
	}
	
	
	
	private void sendMessageToAdmin ( String message, String subject)
	{
		
		sendSms (ADMIN_PHONE, message );
		sendMail(ADMIN_EMAIL, message, subject);
		
	}
	
	private void sendMessageToUser ( int userId, String message, String subject )
	{
		model.User user = null;
		dal.User userDal = new dal.User();
		
		user = userDal.getUser(userId);
		
		// send SMS
		
		sendSms ( new String[]{user.getPhone()},"Dear "+user.getFirstName()+"\n"+message );
		
		// send Email
		
		if (user.getEmailId() != null && user.getEmailId().length()>0) 
		{
			
		
		sendMail ( new String[]{ user.getEmailId()}, "Dear "+user.getFirstName()+"\n"+message, subject);
		
		}
		// send GCM
		
		biz.GCM gcm = new biz.GCM();
		gcm.SendMessage(userId, message);
		
	}
	
	
	
    public  StatusCode sendSms(String[] recipient,  String message)
	{     
    	String str;
    	StatusCode status = StatusCode.UnknownError;
    	
            try {
                    
                    String un = "2%*&^(113030233";
                    String p = "sddqdqw";
                    String originator = "HLTHOK";
                    
                    StringBuilder recipientList = new StringBuilder();
                    
int i = 0;
                    for ( String phone : recipient )
                    {
                    	if ( i> 1) recipientList.append(',');
                    	recipientList.append(phone);
                    	i++;
                    	
                    }
                    
                    String requestUrl  = "http://bhashsms.com/api/sendmsg.php?" +
        "&user=" + URLEncoder.encode(un, "UTF-8") +
        "&pass=" + URLEncoder.encode(p, "UTF-8") +
         "&sender=" + URLEncoder.encode(originator, "UTF-8") +
        "&phone=" + URLEncoder.encode(recipientList.toString(), "UTF-8") +
        
        "&text=" + URLEncoder.encode(message, "UTF-8") +
       "&priority=sdnd" +
        "&stype=normal";
      

        

                    URL url = new URL(requestUrl);
                    HttpURLConnection uc = (HttpURLConnection)url.openConnection();
                    str=uc.getResponseMessage();
                 

                    uc.disconnect();
                    status = StatusCode.Success;

            } catch(Exception ex) {
            	status = StatusCode.UnknownError;
                   str=ex.getMessage();
             	  Logging.Exception("NOTIFICATION", ex.getMessage());

            }
            return status;
    }

	
	
    public  StatusCode sendMail(String[] recipient,  String message, String subject)
    
    {
    	
    	return StatusCode.Success;
    	/*
        SendGrid sendgrid = null ;
         SendGrid.Email email = new SendGrid.Email();
        String str;
    	StatusCode status = StatusCode.UnknownError;
        
        StringBuilder recipientList = new StringBuilder();
        
int i = 0;
        for ( String emailId : recipient )
        {
        	if ( i> 1) recipientList.append(',');
        	recipientList.append(emailId);
        	i++;
        	
        }

        
        email.addTo(recipientList.toString());
        email.setFrom("info@health-ok.in");
        email.setFromName("HealthOK");
        email.setSubject(subject);
        email.setHtml(message);
        

        try {
            SendGrid.Response response = sendgrid.send(email);
            str=response.getMessage();
            status = StatusCode.Success;
          }
          catch (SendGridException e) {
        	  status = StatusCode.UnknownError;
        	  Logging.Exception("NOTIFICATION", e.getMessage());
            str=e.getMessage();
          }
        return status;
*/
      }
    
    
}
