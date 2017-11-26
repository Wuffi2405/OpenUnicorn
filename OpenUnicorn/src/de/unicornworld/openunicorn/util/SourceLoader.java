package de.unicornworld.openunicorn.util;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class SourceLoader {

	private static BufferedImage image;
	private static ImageIcon icon;

	public SourceLoader() {

	}

	public static BufferedImage loadImage(String path) {
		try {

			image = ImageIO.read(SourceLoader.class.getResourceAsStream(path));
			return image;
		} catch (IOException e) {
			System.err.println("[UnicornWorld] [SourceLaoder] couldn't load Image");
			e.printStackTrace();
			return null;
		}
	}
	
	public ImageIcon loadIcon(String path){
//		try {
////			icon = 
////			icon = (ImageIcon) ImageIO.read(SourceLoader.class.getResourceAsStream(path));
//		} catch (IOException e) {
//			System.err.println("[UnicornWorld] [SourceLaoder] couldn't load Icon");
//			e.printStackTrace();
//		}
		return icon;
	}
	
}
