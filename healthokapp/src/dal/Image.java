package dal;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.ImageType;
import util.Logging;
import util.StatusCode;

public class Image {
	
	
	public int insert ( ImageType imageType,String fileName, InputStream fileStream)
	{
		
		
		Connection connection= null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int imageId = -1;
		
		
		try
		{
//			String str="insert into `Image`(ImageTypeId,FileName) values (?,?)";
			String str="insert into `Image`(ImageTypeId,FileName,Image) values (?,?,?)";

			connection =  Database.createConnection();

			

			ps=(PreparedStatement) connection.prepareStatement(str,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1,imageType.getimageType());
			ps.setString(2, fileName);
		    ps.setBlob(3, fileStream);
			int rw=ps.executeUpdate();

			   if(rw>0)
			   {
				  rs = ps.getGeneratedKeys();
	                if(rs.next())
	                    imageId =rs.getInt(1);
	 }

			   else
			   {
				   
				   Logging.Error("IMAGEDAL", "Unable to insert into Image Table");
			   }
	
		}
		catch(Exception ex)
		{
			Logging.Exception("OrderDAL", "Error Creating Order " + ps.toString() + " Exception " + ex.getMessage());
		}
		finally{
			Database.closeConnection(connection);
		}
		return imageId;
	}


	public StatusCode update ( int imageId, InputStream fileStream)
	{
		
		
		Connection connection= null;
		PreparedStatement ps = null;
		ResultSet rs = null;
StatusCode status = StatusCode.UnknownError;		
		
		try
		{
			String str="update Image set image=? where ImageId = ?"; 

			connection =  Database.createConnection();

			ps=(PreparedStatement) connection.prepareStatement(str,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, imageId);
		    ps.setBlob(2, fileStream);
			int rw=ps.executeUpdate();

			   if(rw>0)
			   {
				  rs = ps.getGeneratedKeys();
	                if(rs.next())
	                    imageId =rs.getInt(1);
			   }
			   else
			   {
				   
					Logging.Exception("ImageDAL", "Error update Image " + ps.toString() + " Invalid Id " + imageId);
				   status= StatusCode.Error;
				   
			   }
		
	status = StatusCode.Success;
		}
		catch(SQLException se)
		{
			Logging.Exception("ImageDAL", "Error Updating Image " + ps.toString() + " Exception " + se.getMessage());
		}
		finally{
			Database.closeConnection(connection);
		}
		return status;
	}


	public model.Image getImage (int imageId)
	{

		Connection connection= null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		
		try
		{
			String str="select ImageId, ImageTypeId, FileName, Image from Image where ImageId = ?"; 

			connection =  Database.createConnection();

			ps=(PreparedStatement) connection.prepareStatement(str);
			ps.setInt(1, imageId);
			 rs=ps.executeQuery();

			 model.Image image = new model.Image();
			 while ( rs.next())
			 {
				 image.setImageId(rs.getInt("ImageId"));
				 image.setImageType(ImageType.item(rs.getInt("ImageTypeId")));
				 image.setFileName(rs.getString("FileName"));
				 image.setImage(rs.getBytes("Image"));
			 }
			 
			 return image;
		}
		catch(SQLException se)
		{
			Logging.Exception("ImageDAL", "Error Updating Image " + ps.toString() + " Exception " + se.getMessage());
		}
		finally{
			Database.closeConnection(connection);
		}
		return null;
		

		
	}
}
