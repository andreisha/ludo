package br.pucrio.poo.models.utils;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public abstract class Resources {

	private static final String DICE_IMG_NAME = "/Dado";
	private static final String IMAGE_EXTENSION = ".png";

	public static Image getDiceImage(int value) {
		String path = DICE_IMG_NAME + Integer.toString(value) + IMAGE_EXTENSION;
		URL url = getImageURL(path);
		
		if(url == null)
			return null;
		return imageFromURL(url);
	}	

	private static Image imageFromURL(URL url) {
		return new ImageIcon(url).getImage();
	}
	
	private static URL getImageURL(String imagePath) {		
		return getResourceURL(imagePath);
	}

	private static URL getResourceURL(String path) {
		return new Object().getClass().getResource(path);
	}		
}
