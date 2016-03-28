package rest_api;

import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;

import model.Result;
import notification.Notification;
import util.StatusCode;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("/sendMail")

	
public class sendMail {
	@Path("/new/{recipient}/{message}")
	  @GET
	  @Consumes (MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)

  public  Result sendMailMessage(@PathParam("recipient") String r,@PathParam("message") String m) {
  
		StatusCode status = StatusCode.UnknownError;
		
		Notification notification = new Notification();
		
		status = notification.sendMail(new String[]{r}, m, "Important Message From Health-OK");
		
		Result result =  new Result();
		result.setStatus(status.getStatusCode());
		return result;

	
	}
}