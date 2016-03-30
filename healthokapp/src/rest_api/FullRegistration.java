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

import biz.User;
import dal.Database;
import util.StatusCode;

@Path("/FullRegistration")
public class FullRegistration {

	
	@Path("/Register")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public model.Result fullRegister(model.UserFull us)
	{
		
		
		
		StatusCode status = new biz.User().fullRegister(us);
		
		model.Result result=new model.Result();
		result.setStatus(status.getStatusCode());
		
		return result;
		
	}
	
	
	
}



	
	
	/*
	@Path("/accept")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Message accept(String jsonString) throws SQLException
	{
		 Connection connection = null;
	     Statement statement = null;
	     ResultSet resultset = null;
	     PreparedStatement preparedstatement=null;
	     Message m=new Message();
		
		try {
			connection = Database.createConnection();
      	  	JSONObject json = new JSONObject(jsonString);
			MemberRegister mr=new MemberRegister();
			JSONArray family = json.getJSONArray("family");
			String query;
			JSONObject obj;
			for(int i=0;i<family.length();i++)
			  {
				 obj = family.getJSONObject(i);
				 query=new String("insert into memberdetails(FirstName,LastName,Sex,DOB,BloodGroup,Allergies,CurrentMedications,Diabetic,BP,HeartProblems,RecurringTests,LongTermCareNeeds,Comments,CityId)"
				 		+ " values(\""
					  +obj.getString("FirstName")+"\",\""
					  +obj.getString("LastName")+"\",\""
					  +obj.getString("Sex")+"\",\""
					  +obj.getString("DOB")+"\",\""
					  +obj.getString("BloodGroup")+"\",\""
					  +obj.getString("Allergies")+"\",\""
					  +obj.getString("CurrentMedications")+"\",\""
					  +obj.getInt("Diabetic")+"\",\""
					  +obj.getInt("BP")+"\",\""
					  +obj.getInt("HeartProblems")+"\",\""
					  +obj.getString("RecurringTests")+"\",\""
					  +obj.getString("LongTermCareNeed")+"\",\""
					  +obj.getString("Comments")+"\",\""
					  +obj.getInt("CityId")+"\");" );
				preparedstatement =(PreparedStatement)connection.prepareStatement(query);	 
				preparedstatement.executeUpdate();
				m.setStatus(1);
			  }  
			  
			
		   	} 
		catch (Exception e) 
		{   m.setStatus(-1);
		   	m.setMessage(e.getMessage());
		   	}
		
		 finally 
	     { 
			 Database.closeConnection(connection);
			 return m;	  
	      }
		//return jsonString;
	}
	
	*/
	
	
	
//}
/*public static void main(String ar[]) throws SQLException
{
	String jsonString="{\"firstName\" : \"ashish\"}";
	FinalRegistration fr=new FinalRegistration();
	fr.accpet(jsonString);
	
}*/

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
