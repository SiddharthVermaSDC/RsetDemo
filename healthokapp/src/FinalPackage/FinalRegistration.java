package FinalPackage;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		try {
			  DatabaseConnectivity bb=new DatabaseConnectivity();
			  bb.conn = DriverManager.getConnection(bb.CONN_STRING,bb.USERNAME,bb.PASSWORD);
			  JSONObject json = new JSONObject(jsonString);
			  //System.out.println(json.getString("firstName"));
			  MemberRegister mr=new MemberRegister();
			  //mr.register(jsonString);
			  JSONArray family = json.getJSONArray("family");
			  String query;
			  JSONObject obj;
			 for(int i=0;i<family.length();i++)
			  {
				 //Gson g=new Gson();
				 
				 obj = family.getJSONObject(i);
				 //GetSetFamilyRegistration obj = g.fromJson(GetSetFamilyRegistration.class);
				query=new String("insert into family values(\""
					  +obj.getString("name")+"\",\""
					  +obj.getString("age")+"\",\""
					  +obj.getString("bloodGroup")+"\",\""
					  +obj.getString("allergies")+"\",\""
					  +obj.getString("medicalCondition")+"\",\""
					  +obj.getString("currentMedicalCondition")+"\",\""
					  +obj.getString("familyId")+"\");");
					  PreparedStatement pstmt =(PreparedStatement)bb.conn.prepareStatement(query);	 
					  pstmt.executeUpdate();
				 	//System.out.println(obj.getString("name"));
			  }  
			  
			  return "suc";
		   	} catch (Exception e) { //System.out.println(e.getMessage());
		   		System.out.println(e.getMessage());
		   		e.printStackTrace();
		   	}
		return jsonString;
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
