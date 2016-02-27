package rest_api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/FinalRegister")
public class FinalRegistration {

	@Path("/accept")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public String accpet(String jsonString) throws SQLException
	{
		 Connection connection = null;
	     Statement statement = null;
	     ResultSet resultset = null;
	     PreparedStatement preparedstatement=null;
		
		try {
			connection = DatabaseConnectivity.getInstance().getConnection();
      	  	JSONObject json = new JSONObject(jsonString);
			MemberRegister mr=new MemberRegister();
			JSONArray family = json.getJSONArray("family");
			String query;
			JSONObject obj;
			for(int i=0;i<family.length();i++)
			  {
				 obj = family.getJSONObject(i);
				 query=new String("insert into memberdetails(FirstName,LastName,Sex,DOB,BloodGroup,Allergies,CurrentMedication)"
				 		+ " values(\""
					  +obj.getString("FirstName")+"\",\""
					  +obj.getString("LastName")+"\",\""
					  +obj.getString("Sex")+"\",\""
					  +obj.getString("DOB")+"\",\""
					  +obj.getString("BloodGroup")+"\",\""
					  +obj.getString("Allergies")+"\",\""
					 // +obj.getString("MedicalCondition")+"\",\""
					  +obj.getString("CurrentMedication")+"\");");
				preparedstatement =(PreparedStatement)connection.prepareStatement(query);	 
				preparedstatement.executeUpdate();
				
			  }  
			  
			return "got it right";
		   	} 
		catch (Exception e) 
		{ 
		   	return e.getMessage();	
		   	}
		//return jsonString;
	}
//}
/*public static void main(String ar[]) throws SQLException
{
	String jsonString="{\"firstName\" : \"ashish\"}";
	FinalRegistration fr=new FinalRegistration();
	fr.accpet(jsonString);
	
}*/
}
/*String jsonString = "{
"libraryname":"My Library",
"mymusic":[{"Artist Name":"Aaron","Song Name":"Beautiful"},
{"Artist Name":"Britney","Song Name":"Oops I did It Again"},
{"Artist Name":"Britney","Song Name":"Stronger"}]}"
*/
//String libraryName = json.getString("libraryname");


//String song = obj.getString("song");
//GetSetFamilyRegistration gs=new GetSetFamilyRegistration();
//gs=obj;
