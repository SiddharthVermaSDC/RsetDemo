package biz;

import java.io.InputStream;

import model.ImageType;

public class Image {

	
public int saveImage (ImageType imageType, String fileName, InputStream file )	
{
	int imageId = -1;
	
	imageId = new dal.Image().insert(imageType,  fileName, file);
	
	return imageId;
}
	
public model.Image getImage (int imageId)	
{
	
	model.Image image =  new dal.Image().getImage(imageId);
	
	String extension = "";

	int i = image.getFileName().lastIndexOf('.');
	if (i > 0) {
	    extension = image.getFileName().substring(i+1);
	}
	
	image.setExtension(extension);
	
	return image;
}


}
