package util;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

public class Result {

	private StatusCode statusCode;
	private int status;
	private String message;
	
	public Result()
	{
		
	}
	
	public Result( StatusCode status)
	{
		
		
	}
	
	public String toJsonString()
	{
		
		Gson gson = new Gson();
		return gson.toJson(this);
		 
	}
	
	public JSONObject toJson()
	{
		
		Gson gson = new Gson();
		try {
			return new JSONObject(gson.toJson(this));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		 
	}

}
