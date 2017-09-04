package de.unicornworld.openunicorn.util;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SourceLoader {

	private static BufferedImage image;

	public SourceLoader() {

	}

	public static BufferedImage loadImage(String path) {
		try {

			image = ImageIO.read(SourceLoader.class.getResourceAsStream(path));

			// image =
			// ImageIO.read(SourceLoader.class.getClassLoader().getResourceAsStream(path));
			return image;
		} catch (IOException e) {
			System.err.println("ERROR");
			e.printStackTrace();
			return null;
		}
	}

}
