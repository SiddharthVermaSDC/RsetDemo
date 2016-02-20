package notifications;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("/sendSms")
public class sendSms {
	@Path("/new/{recipient}/{message}")
  @GET
  @Consumes (MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public static String sendSms(@PathParam("recipient") String r,@PathParam("message") String m)
	{     String str;
            try {
                    
                    String username = "healthok";
                    String password = "qwert123";
                    String originator = "HLTHOK";

                    String requestUrl  = "http://bhashsms.com/api/sendmsg.php?" +
        "&user=" + URLEncoder.encode(username, "UTF-8") +
        "&pass=" + URLEncoder.encode(password, "UTF-8") +
         "&sender=" + URLEncoder.encode(originator, "UTF-8") +
        "&phone=" + URLEncoder.encode(r, "UTF-8") +
        
        "&text=" + URLEncoder.encode(m, "UTF-8") +
       "&priority=sdnd" +
        "&stype=normal";
      

        

                    URL url = new URL(requestUrl);
                    HttpURLConnection uc = (HttpURLConnection)url.openConnection();
                    str=uc.getResponseMessage();
                 

                    uc.disconnect();

            } catch(Exception ex) {
                   str=ex.getMessage();

            }
            return str;
    }

}