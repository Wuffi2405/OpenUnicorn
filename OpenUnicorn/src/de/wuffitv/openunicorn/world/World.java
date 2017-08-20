package de.wuffitv.openunicorn.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import de.wuffitv.openunicorn.util.SourceLoader;

public class World {

	public static Block block;
	public static int world_x = 0;
	public static int world_y = 0;
	public static int world_width = 1536;
	public static int world_height = 1536;
	private BufferedImage background;

	public World() {
		System.out.println("[OpenUnicorn] [World] [World] called");
		
		block = new Block(0, 0, 20, 20, null);
		background = SourceLoader.loadImage("/assets/background.png");

	}

	public void update() {

	}

	public void render(Graphics g) {
		block.render(g);
	}

}
