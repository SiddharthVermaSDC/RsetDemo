package biz;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONObject;

import com.google.gson.Gson;

import model.GCMRequest;
import model.GCMRequestData;
import util.Logging;
import util.StatusCode;


public class GCM {

	private static String SERVER_ID = "AIzaSyDARHiYIO9QC9H2qHDzA6VNgNbfoozWfSA";
	private static String GCM_URL = "https://android.googleapis.com/gcm/send";
	
	public StatusCode SendMessage (int userId, String message)
	{
		StatusCode status = StatusCode.UnknownError;
		String token = null;

		URL url ;
		HttpURLConnection connection = null;

		try{
			dal.User user = new dal.User();
			token = user.GetToken(userId);
			
			// make REST API call to google to send message
			
			url = new URL ( GCM_URL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Authorization", "key="+SERVER_ID);

			Logging.Debug("GCMSend", "Calling send message 1");

			GCMRequest gcmRequest = new GCMRequest();
			ArrayList<String> tokens = new ArrayList<String>();
			tokens.add(token);
			gcmRequest.setRegistration_ids(tokens);
			
			GCMRequestData gcmRequestData = new GCMRequestData();
			gcmRequestData.setMessage(message);
			
			gcmRequest.setData(gcmRequestData);
//			JSONObject gcmRequestJSON = new JSONObject(gcmRequest);

			String gcmRequestJSON = new Gson().toJson(gcmRequest);
			
			Logging.Debug("GCMSend", "Calling send message 2 " + gcmRequestJSON );

		      connection.setDoInput(true);
		      connection.setDoOutput(true);

		      //Send request
		      DataOutputStream wr = new DataOutputStream (
		                  connection.getOutputStream ());
		      wr.writeBytes (gcmRequestJSON);
		      wr.flush ();
		      wr.close ();			

				Logging.Debug("GCMSend", "Calling send message ");

			if (connection.getResponseCode() != 200) {
				Logging.Error("GCMSend", "Error calling send message");
				throw new RuntimeException("Failed : HTTP error code : "
						+ connection.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(connection.getInputStream())));
			
			StringBuilder responseBuilder = new StringBuilder();
String line;
			while ((line = br.readLine()) != null) {
				responseBuilder.append(line);
			}

			String response = responseBuilder.toString();
			
			
			connection.disconnect();

			Logging.Debug("GCM-SEND", response);
		status = StatusCode.Success;
		return status;
			
		}
		catch ( Exception e)
		{
			Logging.Exception("GCM-Biz", "In exception");
			Logging.Exception("GCM-Biz", e.toString());
			Logging.Exception("GCM-Biz", e.getMessage());
			connection.disconnect();
			
		}
		
		
		return status;
		
		
	}
}
