package rest_api;

import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;
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

  public static String sendMail(@PathParam("recipient") String r,@PathParam("message") String m) {
    SendGrid sendgrid = new SendGrid("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");
     SendGrid.Email email = new SendGrid.Email();
    String str;
    email.addTo(r);
    email.setFrom("info@health-ok.in");
    email.setFromName("HealthOK");
    email.setSubject("Important message from HealthOK");
    email.setHtml(m);
    

    try {
        SendGrid.Response response = sendgrid.send(email);
        str=response.getMessage();
      }
      catch (SendGridException e) {
        str=e.getMessage();
      }
    return str;
  }
}