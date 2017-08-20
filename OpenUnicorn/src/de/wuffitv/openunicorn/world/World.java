package de.wuffitv.openunicorn.world;

import java.awt.Graphics;

public class World {

	public static int world_x = 0;
	public static int world_y = 0;
	public static int world_width = 1536;
	public static int world_height = 1536;
	public static Block[][] block = new Block[10][10];
	
	public World() {
		System.out.println("[OpenUnicorn] [World] [World] called");

		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				block[x][y] = new Block(x * Block.BLOCKSIZE, y * Block.BLOCKSIZE, 20, 20, null);
			}
		}

	}

	public void update() {

	}

	public void render(Graphics g) {
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				block[x][y].render(g);
			}
		}
	}

}
