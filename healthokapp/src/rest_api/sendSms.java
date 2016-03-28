package rest_api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Result;
import notification.Notification;
import util.StatusCode;



@Path("/sendSms")
public class sendSms {
	@Path("/new/{recipient}/{message}")
  @GET
  @Consumes (MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public  Result sendSMSMessage(@PathParam("recipient") String r,@PathParam("message") String m)
	{     
		
		StatusCode status = StatusCode.UnknownError;
		
		Notification notification = new Notification();
		
		status = notification.sendSms(new String[]{r}, m);
		
		Result result =  new Result();
		result.setStatus(status.getStatusCode());
		return result;
	
    }

}