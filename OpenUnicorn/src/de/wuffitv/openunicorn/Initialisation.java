package de.wuffitv.openunicorn;

import java.awt.Dimension;
import java.awt.Graphics;

import de.unicornworld.openunicorn.Component;
import de.unicornworld.openunicorn.Tile;
import de.unicornworld.openunicorn.World;
import de.wuffitv.openunicorn.entity.Player;
import de.wuffitv.openunicorn.world.Block;

public class Initialisation {

	public static Initialisation initialisation;

	private boolean readyForLoop = false;

	public static double sx = 0;
	public static double sy = 0;

	public static Dimension size = new Dimension(1300, 700);

	public static int pixelsize = 2;
	public static Dimension pixel = new Dimension(size.width / pixelsize, size.height / pixelsize);

	private static int frame_widthWithoutInsets = 0;
	private static int frame_heightWithoutInsets = 0;
	private Player player;
	private World world;

	public Initialisation() {
		System.out.println("[OpenUnicorn] [Initialisation] [Initialisation] called");

		world = new World();
		player = new Player();

		readyForLoop = true;
		/**
		 * init KeyListener Updater Renderer
		 * 
		 * load World
		 */

	}

	public void update() {
		if (readyForLoop) {
			player.update();

			Component.world.tick((int) sx, (int) sy, (int) (pixel.width / Tile.tileSize + 2),
					(int) (pixel.height / Tile.tileSize + 2));
			Component.character.tick();
			Component.sky.tick();

		}

	}

	public void render(Graphics g) {
		if (readyForLoop) {
			world.render(g, (int) sx, (int) sy, (int) (pixel.width / Block.BLOCKSIZE + 2),
					(int) (pixel.height / Block.BLOCKSIZE + 2));
			player.render(g);
		}
	}

	public static int getFrame_widthWithoutInsets() {
		return frame_widthWithoutInsets;
	}

	public static void setFrame_widthWithoutInsets(int frame_widthWithoutInsets) {
		Initialisation.frame_widthWithoutInsets = frame_widthWithoutInsets;
	}

	public static int getFrame_heightWithoutInsets() {
		return frame_heightWithoutInsets;
	}

	public static void setFrame_heightWithoutInsets(int frame_heightWithoutInsets) {
		Initialisation.frame_heightWithoutInsets = frame_heightWithoutInsets;
	}

}
