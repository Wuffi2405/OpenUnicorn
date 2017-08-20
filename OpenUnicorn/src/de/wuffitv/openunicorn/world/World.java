package de.wuffitv.openunicorn.world;

import java.awt.Graphics;

public class World {

	public static int world_x = 0;
	public static int world_y = 0;
	public static int world_width = 1536;
	public static int world_height = 1536;
	public static Block[][] block = new Block[world_width / Block.BLOCKSIZE][world_height / Block.BLOCKSIZE];

	public World() {
		System.out.println("[OpenUnicorn] [World] [World] called");

		for (int y = 0; y < world_height / Block.BLOCKSIZE; y++) {
			for (int x = 0; x < world_width / Block.BLOCKSIZE; x++) {
				block[x][y] = new Block(x * Block.BLOCKSIZE, y * Block.BLOCKSIZE, 20, 20, null);
			}
		}

	}

	public void update() {

	}

	public void render(Graphics g, int camX, int camY, int renW, int renH) {
		for (int x = (camX / Block.BLOCKSIZE); x < (camX / Block.BLOCKSIZE) + renW; x++) {
			for (int y = (camY / Block.BLOCKSIZE); y < (camY / Block.BLOCKSIZE) + renH; y++) {

				if (x >= 0 && y >= 0 && x < world_width / Block.BLOCKSIZE && y < world_height / Block.BLOCKSIZE) {
					block[x][y].render(g);

				}
			}
		}
	}

}
