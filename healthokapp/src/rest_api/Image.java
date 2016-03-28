package rest_api;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import com.sun.jersey.core.header.FormDataContentDisposition;
//import com.sun.jersey.multipart.FormDataParam;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.json.JSONException;
import org.json.JSONObject;

import model.ImageType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;


@Path("/files")
public class Image {


	@POST
	@Path("/uploaddocpic")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	public String uploadDocImage(
			@FormDataParam("file") InputStream fileInputStream,
			@FormDataParam("file") FormDataContentDisposition contentDispositionHeader
			) 
	
	{

		return uploadFile ( ImageType.DocPic, contentDispositionHeader.getFileName(), fileInputStream);

	}


	@POST
	@Path("/uploadprescription")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	public String uploadPrescription(
			@FormDataParam("file") InputStream fileInputStream,
			@FormDataParam("file") FormDataContentDisposition contentDispositionHeader
			) 
	
	{

		return uploadFile ( ImageType.Prescription, contentDispositionHeader.getFileName(), fileInputStream);

	}

	@POST
	@Path("/uploadreport")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	public String uploadReport(
			@FormDataParam("file") InputStream fileInputStream,
			@FormDataParam("file") FormDataContentDisposition contentDispositionHeader
			) 
	
	{

		return uploadFile ( ImageType.Report, contentDispositionHeader.getFileName(), fileInputStream);

	}

	@POST
	@Path("/uploaduserpic")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	public String uploadUserPic(
			@FormDataParam("file") InputStream fileInputStream,
			@FormDataParam("file") FormDataContentDisposition contentDispositionHeader
			) 
	
	{

		return uploadFile ( ImageType.UserPic, contentDispositionHeader.getFileName(), fileInputStream);

	}


	
	@GET
	@Path("/image/{imageId}")
	@Produces({"image/jpg", "image/png", "image/gif", "image/bmp"})
	public Response getImage(
			@PathParam("imageId") int imageId
			) 
	
	{

	byte[] imageData = new biz.Image().getImage(imageId).getImage();
		
		return Response.ok(new ByteArrayInputStream(imageData)).build();
		
	}


	
	
	private String uploadFile( ImageType imageType, String fileName, InputStream fileInputStream)
	
	{

		
		JSONObject jsonResponse = new JSONObject();
		int imageId = -1;
		
		
		try {
			
			imageId = new biz.Image().saveImage(ImageType.DocPic, fileName, fileInputStream);
			
			jsonResponse.put("imageId", imageId);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
return jsonResponse.toString();

	}
	
	
	}
