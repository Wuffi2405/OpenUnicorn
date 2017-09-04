package de.unicornworld.openunicorn.world;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class World {
	public static int worldW = 100, worldH = 100;
	public Block[][] block = new Block[worldW][worldH];
	private static BufferedReader reader;

	public World() {
		for (int x = 0; x < block.length; x++) {
			for (int y = 0; y < block[0].length; y++) {
				block[x][y] = new Block(
						new Rectangle(x * Tile.tileSize, y * Tile.tileSize, Tile.tileSize, Tile.tileSize), Tile.air);
			}
		}

		generateLevel();
	}

	public void generateLevel() {

		try {
			reader = new BufferedReader(new FileReader(new File("OpenUnicorn/src/assets/files/world.uwwf")));

			for (int x = 0; x < worldH; x++) {
				try {

					String[] numbers = reader.readLine().split("");

					for (int y = 0; y < worldW; y++) {

						if (Integer.parseInt(numbers[y]) == 1) {
							block[y][x] = new Block(
									new Rectangle(y * Tile.tileSize, x * Tile.tileSize, Tile.tileSize, Tile.tileSize),
									Tile.stone);
						} else {
							block[y][x] = new Block(
									new Rectangle(y * Tile.tileSize, x * Tile.tileSize, Tile.tileSize, Tile.tileSize),
									Tile.earth);

						}
					}
				} catch (Exception e) {

				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void tick(int camX, int camY, int renW, int renH) {

	}

	public void render(Graphics g, int camX, int camY, int renW, int renH) {
		for (int x = (camX / Tile.tileSize); x < (camX / Tile.tileSize) + renW; x++) {
			for (int y = (camY / Tile.tileSize); y < (camY / Tile.tileSize) + renH; y++) {

				if (x >= 0 && y >= 0 && x < worldW && y < worldH) {
					block[x][y].render(g);

				}
			}
		}
	}

}
