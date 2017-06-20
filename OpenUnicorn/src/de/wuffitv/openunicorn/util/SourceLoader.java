package de.wuffitv.openunicorn.util;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SourceLoader {
	
	private static BufferedImage image;	

	public static BufferedImage loadImage(String path){
		try {
			image = ImageIO.read(SourceLoader.class.getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
}
