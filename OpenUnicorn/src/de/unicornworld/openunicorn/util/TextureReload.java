package de.unicornworld.openunicorn.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class TextureReload {

	public static HashMap<Integer, Image> textures = new HashMap<>();

	public static BufferedImage grass;
	public static BufferedImage wood;
	public static BufferedImage earth;
	public static BufferedImage steinWeg_1;

	public TextureReload() {

		try {

			addBlock(0, ImageIO.read(SourceLoader.class.getResourceAsStream("/assets/texture/block/grass.png")));
			addBlock(1, ImageIO.read(SourceLoader.class.getResourceAsStream("/assets/texture/block/Steinweg1.png")));
			addBlock(2, ImageIO.read(SourceLoader.class.getResourceAsStream("/assets/texture/block/dirt.png")));
			addBlock(3, ImageIO.read(SourceLoader.class.getResourceAsStream("/assets/texture/block/wood.png")));
			addBlock(4, ImageIO.read(SourceLoader.class.getResourceAsStream("/assets/texture/block/wood_inside.png")));
			addBlock(5, ImageIO.read(SourceLoader.class.getResourceAsStream("/assets/texture/block/grass.png")));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void addBlock(int id, Image image) {

		textures.put(id, image);

	}

}
