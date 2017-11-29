package de.unicornworld.openunicorn.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import javax.imageio.ImageIO;

import de.unicornworld.openunicorn.world.Tile;

public class TextureReload {

	public static HashMap<Integer, Image> textures = new HashMap<>();

	public TextureReload() {

		try {

			addBlock(0, ImageIO.read(SourceLoader.class.getResourceAsStream("/assets/texture/block/grass.png")));
			addBlock(1, ImageIO.read(SourceLoader.class.getResourceAsStream("/assets/texture/block/Steinweg1.png")));
			addBlock(2, ImageIO.read(SourceLoader.class.getResourceAsStream("/assets/texture/block/dirt.png")));
			addBlock(3, ImageIO.read(SourceLoader.class.getResourceAsStream("/assets/texture/block/wood.png")));
			addBlock(4, ImageIO.read(SourceLoader.class.getResourceAsStream("/assets/texture/block/wood_inside.png")));
			addBlock(5, ImageIO.read(SourceLoader.class.getResourceAsStream("/assets/texture/block/grass.png")));
			addBlock(99, new BufferedImage(Tile.tileSize, Tile.tileSize, BufferedImage.TYPE_INT_RGB));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void addBlock(int id, Image image) {

		textures.put(id, image);

	}

}
