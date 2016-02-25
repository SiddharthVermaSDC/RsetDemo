package learn;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rest_api.DatabaseConnectivity;
@Path("/Image")
public class ImageInsert {
	private Connection connection = null;
	private PreparedStatement ps = null;

	 private ResultSet rs=null;
	// private Statement st=null;
	@Path("/Insert")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String getImage(GetSetImage i) {
	//int doctorId=0;
		try {
			connection = DatabaseConnectivity.getInstance().getConnection();
			//String filePath = "D:/Image/bhu.jpg";
	//		System.out.println(i.getImage());
			FileInputStream fin=new FileInputStream(i.getImage());
			String sql = "INSERT INTO Images (ImageTypeId,Image) values (?,?)";
			ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
     		//ps.setString(1,i.getfName());
			ps.setInt(1,i.getImageTypeId());
			ps.setBinaryStream(2,fin,fin.available());
			System.out.println("Image Inserted");
			 ps.executeUpdate();
		/*	if (row ==1) 
				rs=ps.getGeneratedKeys();
				if(rs.next())
					i.id=rs.getInt(1);
				System.out.println(i.id);
				String key="INSERT INTO Images (ImageTypeId) values (?)";
				ps = connection.prepareStatement(key);
				ps.setInt(1,i.getId());
				ps.executeUpdate();*/
				
				connection.close();
				return "SuccessFully Inserted";
			
			
		} catch (Exception e) {
			System.out.println(e);
			return "Not Successfully";
		}
	}
	

	}

