package de.wuffitv.openunicorn.world;

import java.awt.Graphics;
import java.awt.Rectangle;

public class World {
	public static int worldW = 10, worldH = 10;
	public Block[][] block = new Block[worldW][worldH];

	public World() {
		for (int x = 0; x < block.length; x++) {
			for (int y = 0; y < block[0].length; y++) {
				block[x][y] = new Block(
						new Rectangle(x * Block.BLOCKSIZE, y * Block.BLOCKSIZE, Block.BLOCKSIZE, Block.BLOCKSIZE),
						null);
			}
		}

		generateLevel();
	}

	public void generateLevel() {

	}

	public void building(int camX, int camY, int renW, int renH) {

	}

	public void tick(int camX, int camY, int renW, int renH) {

		building(camX, camY, renW, renH);
	}

	public void render(Graphics g, int camX, int camY, int renW, int renH) {
		for (int x = 0; x < worldW; x++) {
			for (int y = 0; y < worldH; y++) {

				block[x][y].render(g);

			}
		}
	}

}
