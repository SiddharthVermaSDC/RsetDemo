package rest_api;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

import util.Logging;
import util.StatusCode;

@Path("/gcm")

public class GCM {

	@Path("/register")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
//	public String registerDevice( JSONObject inputJson)

	public String registerDevice( String inputString)
	{
		JSONObject result  = new JSONObject();
		StatusCode status = util.StatusCode.UnknownError;
try {

	Logging.Debug("GCM-REGISTER", "Registerinng for " + inputString);
	JSONObject input = new JSONObject(inputString);

	result.put("result", status.getStatusCode());
	
int userId = input.getInt("userid");
String token = input.getString("token");

biz.User user = new biz.User();
status = user.RegisterDevice(userId, token);

result.put("result", status.getStatusCode());

	
} catch (JSONException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	
}

return result.toString();
	}

	@Path("/s")
	@GET
	@Produces (MediaType.TEXT_PLAIN)
	public String rTurn(){
		
		return "hello 3";
	}
	          

	@Path("/send")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	
	public String sendMessage (String message)
	{
		JSONObject result  = new JSONObject();
		StatusCode status = util.StatusCode.UnknownError;
		String token = null;
try {
	
	Logging.Debug("GCM-Send", message);
	JSONObject input = new JSONObject(message);

	result.put("result", status.getStatusCode());
	
int userId = input.getInt("userid");
String messageBody = input.getString("message");
biz.GCM gcm = new biz.GCM();
status = gcm.SendMessage(userId, messageBody);

result.put("result", status.getStatusCode());

return result.toString();


} catch (JSONException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	return result.toString();
}

}
}