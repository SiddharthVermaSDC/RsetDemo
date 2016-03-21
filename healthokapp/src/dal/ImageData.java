package dal;

import java.io.FileInputStream;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ImageData {
	
	static Connection con=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
	
	
	  public static int imageupload(model.ImageData image){
		  
		  int result = 0 ;
		  try{
			  
		 Database database = new Database();
		 con=(Connection) database.createConnection();
	    FileInputStream fin = new FileInputStream(image.getImage());
     	String str1 = "INSERT INTO Images (ImageTypeId,Image) values (?,?)";
	    ps=(PreparedStatement) con.prepareStatement(str1,Statement.RETURN_GENERATED_KEYS);
        	ps.setInt(1, image.getImageidtype());
        	ps.setBinaryStream(2, fin, fin.available());
    //	System.out.println("Image Inserted");
	   int row = ps.executeUpdate();
	   if (row == 1)
		rs = ps.getGeneratedKeys();
	   if (rs.next())
		 result= rs.getInt(1);
	   //System.out.println(ds.id);
		  }catch(Exception e){
			  
			  System.out.print(e.getMessage());
				result = 500;
			   
		  }
  return result;
}
}